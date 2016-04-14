package com.cardvalue.wechat.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cardvalue.www.ArrResponse;
import cn.cardvalue.www.SoapAddLeadCouponRequest;
import cn.cardvalue.www.SoapAddLeadRequest;
import cn.cardvalue.www.SoapGetActiveLeadsRequest;
import cn.cardvalue.www.SoapGetLeadsCategoryRequest;
import cn.cardvalue.www.SoapGetLeadsRequest;
import cn.cardvalue.www.SoapPostLeadRequest;

import com.cardvalue.wechat.dto.CouponInfo;
import com.cardvalue.wechat.dto.LeadsStatus;
import com.cardvalue.wechat.dto.LeadsUpdate;
import com.cardvalue.wechat.dto.UpdateApply;
import com.cardvalue.wechat.model.Coupon;
import com.cardvalue.wechat.model.Leads;
import com.cardvalue.wechat.model.Parameter;
import com.cardvalue.wechat.model.UserCoupon;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.MerchantRepository;
import com.cardvalue.wechat.repository.ParamRepository;
import com.cardvalue.wechat.repository.SalesRepository;
import com.cardvalue.wechat.repository.UserCouponRepository;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.repository.UtilRepository;
import com.cardvalue.wechat.service.CouponService;
import com.cardvalue.wechat.service.KeyMerchantService;
import com.cardvalue.wechat.service.LeadsService;
import com.cardvalue.wechat.service.LogService;
import com.cardvalue.wechat.service.UserService;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.CrmWsServiceUtils;
import com.cardvalue.wechat.util.PageableResult;
import com.cardvalue.wechat.util.Result;

@Service
public class WsLeadsServiceImpl implements LeadsService {

	private final static Logger logger = LoggerFactory.getLogger(WsLeadsServiceImpl.class);

	@Resource
	private UtilityService utilityService;

	@Resource
	private ParamRepository paramRepository;

	@Resource
	private SalesRepository salesRepo;

	@Resource
	private UserRepository userRepo;

	@Resource
	private UtilRepository utilRepo;

	@Resource
	private LogService logService;

	@Resource
	private UserService userService;

	@Resource
	private UserRepository userRepository;

	@Resource
	private DozerBeanMapper beanMapper;

	@Resource
	private CrmWsServiceUtils serviceUtils;

	@Resource
	private KeyMerchantService keyMerchantService;

	@Resource
	private CouponService couponService;

	@Resource
	private MerchantRepository merchantRepository;

	@Resource
	private UserCouponRepository userCouponRepo;

	@Override
	@Transactional
	public Result<?> create(Leads leads, int userId) {
		Result<?> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		try{
			//调用CRM接口
			SoapAddLeadRequest request = createAddLeadsRequest(leads);
			request.setSUBMERNO(leads.getSubCode());
			//是否白名单
			boolean isWhiteList = keyMerchantService.isKeyMerchant(leads.getMerchantNumber());
			request.setIsWhiteList(isWhiteList);

			//更具用户id获取用户对象
			if(utilityService.getUserType(userId) != null && utilityService.getUserType(userId).equals("1")){
				//客户经理
				serviceUtils.setAutheticateInfo(request, Constants.USER_TYPE_UMS_SALES);
				serviceUtils.setAutheticateParams(request, leads.getUserId());
			}else{
				//商户
				WeUser user = userRepository.findById(userId);
				request.setWechatId(user.getUsername());

				if(StringUtils.isNotBlank(leads.getReferrerName()) && StringUtils.isNotBlank(leads.getReferrerCellPhone())) {
					//表示是商户转介绍提交线索，设置不同的来源
					serviceUtils.setAutheticateInfo(request, Constants.USER_TYPE_MERCHANT_REFER);
				} else {
					//表示是商户自己提交线索
					serviceUtils.setAutheticateInfo(request, Constants.USER_TYPE_MERCHANT);
				}
			}
			WeUser user = userRepository.findById(userId);
			ArrResponse response = serviceUtils.getServiceStub().soapAddLead(request);
			if(response != null && response.getCode().equals("1")){
				String leadId = response.getData();
				result.setCode(Constants.RESULT_CODE_SUCCESS);
				logService.insertActionLog(Constants.ACTION_CREATE_LEADS, leads.getUserId(), null, leads.toString());
				//coupons
				if(StringUtils.isNotBlank(leads.getCouponNumbers())){
					String[] coupons = StringUtils.split(leads.getCouponNumbers(), ",");
					for(String couponNumber : coupons){
						SoapAddLeadCouponRequest addCouponRequest = new SoapAddLeadCouponRequest();
						serviceUtils.setAutheticateInfo(addCouponRequest, Constants.USER_TYPE_MERCHANT);
						addCouponRequest.setCouponType("现金券");
						addCouponRequest.setLead_id(leadId);
						addCouponRequest.setCouponNumber(couponNumber);
						CouponInfo couponInfo = couponService.getCouponInfo(couponNumber);
						addCouponRequest.setMemo(couponInfo.getMemo());
						logger.info("memo========" + addCouponRequest.getMemo());
						addCouponRequest.setCouponAmt(String.valueOf(couponInfo.getAmount()));
						ArrResponse addCouponResponse =  serviceUtils.getServiceStub().soapAddLeadCoupon(addCouponRequest);
						if(addCouponResponse != null && addCouponResponse.getCode().equals("1")){
							logger.info("Successfully calling crm ws to add leads coupon:" + couponNumber);
							UserCoupon uc = userCouponRepo.findByCouponNumber(couponNumber);
							userCouponRepo.updateCouponStatus(uc, Coupon.COUPON_STATUS_ACTIVATED);
						}else{
							logger.error("Failed to calling crm ws to add leads coupon:" + couponNumber);
						}
					}
				}
			}else if(response != null){
				result.setMessage(response.getData());
			}
		}catch(Exception e){
			result.setMessage("系统内部错误，提交CRM失败");
			logger.error("Failed when calling crm ws to create leads", e);
		}
		return result;
	}

	@Transactional
	@Override
	public void update(LeadsUpdate updateDTO, int userId) {
		SoapPostLeadRequest request = new SoapPostLeadRequest();
		request.setLead_id(String.valueOf(updateDTO.getId()));
		request.setBusinessName(updateDTO.getMerchantName());
		request.setCellPhone(updateDTO.getContactMobile());
		request.setContactName(updateDTO.getMerchantContact());
		request.setNotes(updateDTO.getMemo());
		request.setStatus(updateDTO.getStatus());
		Parameter param = paramRepository.findByGroupAndValue(Constants.PARAM_GROUP_CONTACT_POSITION, String.valueOf(updateDTO.getContactPosition()));
		request.setContactType(param.getName());
		try{
			serviceUtils.setAutheticateInfo(request, Constants.USER_TYPE_UMS_SALES);
			serviceUtils.setAutheticateParams(request, userId);
			serviceUtils.getServiceStub().soapPostLead(request);
		}catch(Exception e){
			logger.error("Failed when calling crm ws to update leads", e);
		}
	}

	@Transactional
	public void update(UpdateApply updateDTO) {}

	@SuppressWarnings("rawtypes")
	@Override
	public List<LeadsStatus> listInAllStatus(int userId) {
		List<LeadsStatus> statusList = new ArrayList<LeadsStatus>();
		try{
			SoapGetLeadsCategoryRequest request = new SoapGetLeadsCategoryRequest();
			serviceUtils.setAutheticateInfo(request, Constants.USER_TYPE_UMS_SALES);
			serviceUtils.setAutheticateParams(request, userId);
			ArrResponse response = serviceUtils.getServiceStub().soapGetLeadsCategory(request);
			if(response != null && response.getCode().equals("1")){
				String data = response.getData();
				logger.info(data);
				ObjectMapper mapper = new ObjectMapper();
				List<HashMap> list = mapper.readValue(data, ArrayList.class);
				for(HashMap map : list){
					statusList.add(beanMapper.map(map, LeadsStatus.class));
				}
				logger.info(list.toString());
			}
		}catch(Exception e){
			logger.error("Failed when calling crm ws to list leads", e);
		}
		return statusList;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PageableResult listInStatus(int userId, String status, int page, int row) {
		SoapGetLeadsRequest request = new SoapGetLeadsRequest();
		request.setMID("");
		request.setLead_id("");
		request.setCode(status);
		request.setStatus("");
		request.setPageNum(String.valueOf(page));
		request.setPageSize(String.valueOf(row));
		List<Leads> leadsList = new ArrayList<Leads>();
		PageableResult result = null;
		try{
			serviceUtils.setAutheticateInfo(request, Constants.USER_TYPE_UMS_SALES);
			serviceUtils.setAutheticateParams(request, userId);
			ArrResponse response = serviceUtils.getServiceStub().soapGetLeads(request);
			if(response != null && response.getCode().equals("1")){
				String data = response.getData();
				logger.info(data);
				ObjectMapper mapper = new ObjectMapper();
				result = mapper.readValue(data, PageableResult.class);
				if(result.getPayload() != null){
					List<Map> resultData = (List<Map>)result.getPayload();
					for(Map map : resultData){
						Leads l = beanMapper.map(map, Leads.class);
						leadsList.add(l);
					}
				}
				result.setPayload(leadsList);
			}
		}catch(Exception e){
			logger.error("Failed when calling crm ws to list leads", e);
		}
		return result;
	}

	private LeadsStatus getStatusCount(int userId, int status){return null;}

	@Override
	public Leads getLeads(int userId, int id, boolean view) {
		Leads leads = null;
		try{
			WeUser user = userRepo.findOne(userId);
			int userType = user.getType();
			ArrResponse response = null;
			if(userType == Constants.USER_TYPE_MERCHANT){
				SoapGetActiveLeadsRequest request = new SoapGetActiveLeadsRequest();
				serviceUtils.setAutheticateInfo(request, Constants.USER_TYPE_MERCHANT);
				serviceUtils.setAutheticateParams(request, userId);
				request.setLead_id(String.valueOf(id));
				request.setWechatId(user.getUsername());
				response = serviceUtils.getServiceStub().soapGetActiveLeads(request);
			}else{
				SoapGetLeadsRequest request = new SoapGetLeadsRequest();
				serviceUtils.setAutheticateInfo(request, Constants.USER_TYPE_UMS_SALES);
				serviceUtils.setAutheticateParams(request, userId);
				request.setLead_id(String.valueOf(id));
				response = serviceUtils.getServiceStub().soapGetLeads(request);
			}
			if(response != null && response.getCode().equals("1")){
				String data = response.getData();
				logger.info(data);
				ObjectMapper mapper = new ObjectMapper();
				PageableResult<List> result = mapper.readValue(data, PageableResult.class);
				leads = beanMapper.map(result.getPayload().get(0), Leads.class);
				//默认为法人
				if(StringUtils.isNoneBlank(leads.getContactPositionLabel())){
					int contactPosition = 1;
					Parameter p = this.paramRepository.findByGroupAndName("contact_position", leads.getContactPositionLabel());
					contactPosition = Integer.parseInt(p.getValue());
					leads.setContactPosition(contactPosition);
				}
				logger.info(leads.toString());
			}
		}catch(Exception e){
			logger.error("Failed when calling crm ws to list leads", e);
		}
		return leads;
	}

	@Override
	public PageableResult<?> listAll(int userId) {
		List<Leads> leadsList = null;
		try{
			WeUser user = userRepo.findOne(userId);
			int userType = user.getType();
			ArrResponse response = null;
			logger.info("start list all leads by username:" + user.getUsername());
			if(userType == Constants.USER_TYPE_MERCHANT){
				SoapGetActiveLeadsRequest request = new SoapGetActiveLeadsRequest();
				request.setWechatId(user.getUsername());
				serviceUtils.setAutheticateInfo(request, Constants.USER_TYPE_MERCHANT);
				response = serviceUtils.getServiceStub().soapGetActiveLeads(request);
			}else{
				SoapGetLeadsRequest request = new SoapGetLeadsRequest();
				serviceUtils.setAutheticateInfo(request, Constants.USER_TYPE_UMS_SALES);
				serviceUtils.setAutheticateParams(request, userId);
				response = serviceUtils.getServiceStub().soapGetLeads(request);
			}
			if(response != null && response.getCode().equals("1")){
				leadsList = new ArrayList<Leads>();
				String data = response.getData();
				logger.info(data);
				ObjectMapper mapper = new ObjectMapper();
				PageableResult result = (PageableResult)mapper.readValue(data, PageableResult.class);
				List<Map<String, String>> resultData = (List<Map<String, String>>)result.getPayload();
				if(resultData != null){
					for(Map<String, String> map : resultData){
						Leads l = beanMapper.map(map, Leads.class);
						leadsList.add(l);
					}
				}
			}else{
				if(response != null){
					logger.warn("get error response from crm:" + response.getData());
				}else{
					logger.warn("get null response from crm");
				}
			}
		}catch(Exception e){
			logger.error("Failed when calling crm ws to list leads", e);
		}
		PageableResult result = new PageableResult();
		result.setPayload(leadsList);
		return result;
	}

	private SoapAddLeadRequest createAddLeadsRequest(Leads leads){
		SoapAddLeadRequest request = new SoapAddLeadRequest();
		//商编,装机贷可以不填写商编
		if(StringUtils.isNotBlank(leads.getMerchantNumber())){
			request.setMID(leads.getMerchantNumber());
		}
		//产品类型 1: POS关联 4:装机贷
		request.setProdName(leads.getProduct());
		//商户名称
		request.setBusinessName(leads.getMerchantName());
		//联系人名称
		request.setContactName(leads.getMerchantContact());
		//通过身份id获取身份中文名称
		Parameter param = paramRepository.findByGroupAndValue(Constants.PARAM_GROUP_CONTACT_POSITION, String.valueOf(leads.getContactPosition()));
		//身份
		request.setContactType(param.getName());
		//联系电话
		request.setCellPhone(leads.getContactMobile());
		//备注
		request.setNotes(leads.getMemo());
		//申请额度
		request.setLoanAmount(leads.getLoanAmount());
		//还款时间
		request.setPaybackPeriod(leads.getPaybackPeriod());
		//添加商户的客户经理对象
		WeUser salesUser = userRepo.findOne(leads.getUserId());
		//经营省份
		if(StringUtils.isNotBlank(leads.getProvinceId())){
			String province = utilityService.getProvincesOrRegionsById(Integer.parseInt(leads.getProvinceId())).getName();
			request.setBusinessProvince(province);
		}
		//经营城市
		if(StringUtils.isNotBlank(leads.getRegionId())){
			String city = utilityService.getProvincesOrRegionsById(Integer.parseInt(leads.getRegionId())).getName();
			request.setBusinessCity(city);
		}
		//员工数量
		if(StringUtils.isNotBlank(leads.getStaffNumber())){
			request.setStaffNum(leads.getStaffNumber());
		}
		//商户行业大类
		if(StringUtils.isNotBlank(leads.getMerchantIndustry())){
			request.setSICCategory(leads.getMerchantIndustry());
		}
		//实际经营人学历
		if(StringUtils.isNotBlank(leads.getManagerEducationLevel())){
			request.setOpratorAcdQua(leads.getManagerEducationLevel());
		}
		//实际经营人婚姻状况
		if(StringUtils.isNotBlank(leads.getManagerMarriageStatus())){
			request.setOpratorMaritalStatus(leads.getManagerMarriageStatus());
		}
		//实际经营人有无子女
		if(StringUtils.isNotBlank(leads.getManagerChildrenStatus())){
			request.setOpratorChild(leads.getManagerChildrenStatus());
		}
		//实际经营人是否本地户口
		if(StringUtils.isNotBlank(leads.getManagerHukouStatus())){
			request.setOpratorIsLocal(leads.getManagerHukouStatus());
		}
		//预计月营业额
		if(StringUtils.isNotBlank(leads.getEstimatedRevenue())){
			request.setMonthlyVolume(leads.getEstimatedRevenue());
		}
		//经营面积
		if(StringUtils.isNotBlank(leads.getBusinessArea())){
			request.setSurveySquareFootage(leads.getBusinessArea());
		}
		if(salesUser != null){
			//用户编码
			request.setProcessor_id(salesUser.getProcessorId());
			request.setOwner_id(null);//提线索的人
		}
		if(StringUtils.isNotBlank(leads.getReferrerName())){
			request.setReferrerName(leads.getReferrerName());
		}
		if(StringUtils.isNotBlank(leads.getReferrerCellPhone())){
			request.setReferrerCellPhone(leads.getReferrerCellPhone());
		}
		//经营地段
		if(StringUtils.isNotBlank(leads.getBusinessLocation())){
			request.setSurveyMerchantLocation(leads.getBusinessLocation());
		}
		//待分配线上
		request.setStatus("1");
		return request;
	}

	@Override
	public long getUpdatedLeadsCount(int userId){return 0;}

	@Override
	public boolean isRepeated(String mid){return false;}

}

