package com.cardvalue.wechat.service.impl;

import static com.cardvalue.wechat.util.Constants.CODE_ALL;

import java.net.URL;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.*;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import cn.cardvalue.crm.McaServiceBindingStub;
import cn.cardvalue.crm.SoapCheckExistingAppRequest;
import cn.cardvalue.crm.SoapListMcaRequest;
import cn.cardvalue.crm.SoapUpdateStatusRequest;
import cn.cvbaoli.www.AddServiceBindingStub;
import cn.cvbaoli.www.SoapCreditResultRequestMain;
import cn.cvbaoli.www.SoapRequestAuths;
import cn.cvbaoli.www.SoapSyncUserMerchantRequestMain;
import com.cardvalue.wechat.dto.*;
import com.cardvalue.wechat.model.*;
import com.cardvalue.wechat.repository.*;
import com.cardvalue.wechat.service.*;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cardvalue.www.ArrResponse;
import cn.cardvalue.www.SoapGetAppStatusRequest;

import com.aladin.forweixin.AladinPortBindingStub;
import com.aladin.forweixin.WeixinData;
import com.cardvalue.calculator.service.CalculateRequest;
import com.cardvalue.calculator.service.CalculateResponse;
import com.cardvalue.calculator.service.CalculatorServiceSOAPStub;
import com.cardvalue.support.ws.impl.QueryDataPortBindingStub;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.CrmWsServiceUtils;
import com.cardvalue.wechat.util.Result;
import com.cardvalue.wechat.util.Utility;

@Service
public class MerchantServiceImpl implements MerchantService, InitializingBean{

	private final static Logger logger = LoggerFactory.getLogger(MerchantServiceImpl.class);

	@Value( "${ws.calculate.endpoint}" )
	private String calcWsEndpoint;
	
	@Value( "${ws.calculate.username}" )
	private String calcWsUsername;
	
	@Value( "${ws.calculate.password}" )
	private String calcWsPassword;
	
	@Value( "${ws.calculate.type}" )
	private String calcWsType;
	
	@Value( "${ws.aladin.endpoint}" )
	private String aladinWsEndpoint;
	
	@Value("${sms.template.remote.add.merchant}")
	private String smsTemplateRemoteAddMerchant;

	@Value( "${crm.ws.merchant.username}" )
	private String crmWsMerchantUsername;

	@Value( "${crm.ws.merchant.password}" )
	private String crmWsMerchantPassword;

	@Resource
	private MerchantAddressRepository basicRepo;
	
	@Resource
	private UtilityService utilityService;
	
	@Resource
	private ParamRepository paramRepo;
	
	@Resource
	private MerchantRepository merchantRepo;
	
	@Resource
	private UserPointService userPointService;
	
	@Resource
	private UserRepository userRepo;
	
	@Resource
	private SmsService smsService;
	
	@Resource
	private WeChatService weService;
	
	private AladinPortBindingStub aladinWsStub;
	
	@Resource
	private ReferrerLinkRepository referrerLinkRepo;
	
	@Resource
	private KeyMerchantService keyMerchantService;
	
	@Resource
	private SalesRepository salesRepo;
	
	@Resource
	private CrmWsServiceUtils serviceUtils;
	
	@Resource
	private MerchantCreditRepository merchantCreditRepo;
	
	//对账单webservice
	@Resource
	private QueryDataPortBindingStub queryDataPortBindingStub;

	@Resource
	private AddServiceBindingStub addServiceBindingStub;

	@Resource
	private McaServiceBindingStub mcaServiceBindingStub;//速融接口

	@Resource
	private UserService userService;

	@Resource
	private UserInfoRepository userInfoRepo;

	@Resource
	private LogService logService;

	@Resource
	private UserInfoRepository userInfoRepository;

	@PersistenceContext
	private EntityManager em;

	@Resource
	private CouponService couponService;

	@Resource
	private UtilRepository utilRepo;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		aladinWsStub = new AladinPortBindingStub(new URL(aladinWsEndpoint), null);
	}
	@Override
	public MerchantCredit findMerchantByNumber(String number, String processorId) {
		MerchantCredit credit = merchantCreditRepo.findByMid(number, processorId);
		return credit;
	}
	
	@Override
	public CreditInfo calculate(CalculateInfo info) {
		//TODO integrate with CRM system
		logger.info("entering calculate with input: {}", info.toString());	
		CalculateRequest request = new CalculateRequest();
		request.setType(calcWsType);
		request.setProvinceCode(info.getRegion());
		request.setMccCode(info.getBusType());
		request.setUsername(calcWsUsername);
		request.setPassword(calcWsPassword);
		request.setLastMonthTransactionCount(String.valueOf(info.getMonthlyTransDays()));
		request.setDailyAverageSingleTransactionAmount(String.valueOf(info.getSingleTransAmount()));
		request.setDailyAverageTransactionCount(String.valueOf(info.getDailyTransCount()));
		ObjectMapper mapper = new ObjectMapper();
		CreditInfo cInfo = null;
		try {
			//调用ws
			CalculatorServiceSOAPStub stub = new CalculatorServiceSOAPStub(new URL(calcWsEndpoint), null);
			CalculateResponse response = stub.calculate(request);
			if(response != null && StringUtils.containsIgnoreCase(response.getCode(), "success")){
				cInfo = mapper.readValue(response.getData(), CreditInfo.class);
			}
		} catch (Exception e){
			logger.error("failure occurs while converting json...", e);
		}
		return cInfo;
	}

	@Override
	public boolean allowAccess(MerchantCredit credit, Sales sales) {
		if(credit == null || sales == null){
			return false;
		}
		boolean flag = false;
		//是否有访问所有分支机构的权限
		if(StringUtils.equalsIgnoreCase(sales.getBranchCode(), CODE_ALL)){
			flag = true;
		}else{
			String branchCode = credit.getBranchCode();
			//是否拥有访问商户所在分支机构的权限
			if(StringUtils.contains(sales.getBranchCode(), branchCode)){
				if(StringUtils.equalsIgnoreCase(sales.getRegionCode(), CODE_ALL)){
					flag = true;
				}else{
					String regionCode = credit.getRegionCode();
					if(StringUtils.contains(sales.getRegionCode(), regionCode)){
						flag = true;
					}
				}
			}
		}
		return flag;
	}

	//激活商户
	@Override
	@Transactional
	public int setActivateStatus(String mid, int status, String statusLabel, String memo, Date updateDate, String verifier){
		List<Merchant> merchants = merchantRepo.findByMid(mid);
		int flag = 0; 
		if(merchants != null && merchants.size() > 0){
			Merchant merchant = merchants.get(0);
			int lastStatus = merchant.getActiveStatus();
			if(status != lastStatus){
				merchant.setActiveStatus(status);
				merchant.setActiveStatusLabel(statusLabel);
				merchant.setActiveStatusMemo(memo);
				merchant.setUpdateDate(updateDate);
				merchant.setVerifier(verifier);
				if(status == 2){
					//验证成功
					long totalActiveMerchantCount = merchantRepo.getTotalActiveMerchantCount().longValue();
					long maxAdjustActiveCount = merchantRepo.getMaxAdjustActiveSequence().longValue();
					merchant.setActiveSequence(totalActiveMerchantCount + 1);
					long currentCount = maxAdjustActiveCount + 1;
					merchant.setAdjustActiveSequence(currentCount);
					logger.info("merchant[mid:" + merchant.getMid() + "] successfully activated with [activeSeq:" + merchant.getActiveSequence() + "][adjustSeq:" + currentCount + "]");
					WeUser user = merchant.getUser();//激活的商户
					user.setEnabled(true);
					userRepo.save(user);
					int referrerId = merchant.getUser().getReferrerId();//推荐的人userid
					if(referrerId > 0){
						WeUser referrer = userRepo.findOne(referrerId);//推荐的人对象
						if(referrer.getType() == Constants.USER_TYPE_MERCHANT){
							//商户添加现金优惠券
							String couponName = "mc_50";
							Coupon coupon = couponService.getCouponByName(couponName);//获取50元商户现金券对象
							if(coupon != null){
								UserCoupon uc = couponService.newCoupon(coupon.getId(), referrer.getId());
								logger.info("商编为:" + mid + "的商户认证成功，用户：" + referrer.getUsername() + "获得" + coupon.getMemo() + "成功！" );
							}else{
								logger.error("Coupon [" + couponName + "] doesn't exists");
							}
						}else{
							int continusCount = Utility.getContinusCharLengthFromEnd(String.valueOf(currentCount), Constants.NINE_SUFFIX);
							Parameter p = paramRepo.findByGroupAndValue(Constants.PARAM_GROUP_NINE_SUFFIX_PRIZE, String.valueOf(continusCount));
							double amount = Double.valueOf(p.getName());
							userPointService.addBalance(referrerId, amount, "");
							userPointService.addPoint(referrerId, Constants.ACTION_ADD_MERCHANT);
						}
						weService.pushMessage(referrer.getOpenId(), "您添加的商户" + merchant.getName() + "微信账号已激活!");
					}
					weService.pushMessage(user.getOpenId(), "尊敬的商户，您的卡得万利微信平台帐号已激活,用户名："+ user.getUsername() +",密码："+ user.getPassword() +" ，请登录使用。");
					smsService.sendSms(merchant.getContactMobile(), "尊敬的商户，您的卡得万利微信平台帐号已激活,用户名："+ user.getUsername() +",密码："+ user.getPassword() +" ，请登录使用。");
					
				}else if(status == 3){
					//验证失败
					WeUser user = merchant.getUser();
					userRepo.delete(user);
					
					logger.info("merchant[mid:" + merchant.getMid() + "] failed to be activated");
				}
				merchantRepo.save(merchant);
				flag = 1;
			}
		}else{
			flag = 2;
		}
		return flag;
	}

	@Override
	@Transactional
	public Result<?> create(MerchantRegisterDTO dto, Sales s) {
		logger.info("start creating merchant...");
		int flag = merchantRepo.create(dto, s);
		logger.info("create merchant account into db:" + flag);
		if(flag == 1){
			WeixinData request = new WeixinData();
			request.setBusinessName(dto.getMerchantName());
			request.setMid(dto.getMid());
			request.setMobile(dto.getContactMobile());
			request.setName(dto.getContactName());
			request.setUq(UUID.randomUUID().toString());
			try {
				logger.info("start calling aladin ws to insert call list");
				if(s != null){
					request.setStringField19(s.getName());
					Parameter param = paramRepo.findByGroupAndValue(Constants.PARAM_GROUP_CONTACT_POSITION, String.valueOf(dto.getContactPosition()));
					request.setStringField37(param.getName());
				}
				SoapGetAppStatusRequest statusRequest = new SoapGetAppStatusRequest();
				serviceUtils.setAutheticateInfo(statusRequest, Constants.USER_TYPE_UMS_SALES);
				statusRequest.setMID(dto.getMid());
				ArrResponse response = serviceUtils.getServiceStub().soapGetAppStatus(statusRequest);
				if(response != null && StringUtils.equals(response.getData(), "live")){
					request.setStringField26("活动商户");
				}
				String result = aladinWsStub.addWenxinDataToAladin(request);
				logger.info("the calling result for aladin interface is " + result);
			} catch (RemoteException e) {
				logger.error("Error occurs while calling Aladin", e);
			} catch (Exception e) {
				logger.error("Error occurs while calling Aladin", e);
			}
		}
		Result<?> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		
		/*if(flag == 2){
			result.setMessage("添加商户失败，您提交的商编不是白名单商户。");
		}else */
		
		if(flag == 0){
			//mid已存在
			result.setMessage("添加商户失败，您提交的商编号已被添加，如需咨询，请联系400-608-1310。");
		}else{
			//成功
			referrerLinkRepo.valid(dto.getLinkId());
			weService.pushMessage(dto.getOpenId(), "亲，您已经成功完成注册，银商客户经理会在两个工作日内为您激活账号。卡得万利商业保理是银联商务天天富互联网金融产品，可以为您提供无担保无抵押的融资服务，如需帮助请拔打40086081310。");
			result.setCode(Constants.RESULT_CODE_SUCCESS);
			result.setMessage("商户已添加，我们的远程客户经理会协助商户完成账号激活，成功后会及时给您通知!");
		}
		return result;
	}
	
	@Override
	@Transactional
	public Result<?> createMerchant(MerchantRegisterDTO dto, Sales s,WeUser user,HttpSession session) {
		
		Result<?> result = new Result<Object>();
		
		//短信验证
		String checkCodeResult = null;
		if(dto.isRequireCheck()){
			checkCodeResult = utilityService.validateCheckCode(session, dto.getContactMobile(), dto.getCheckCode());
		}

		if(checkCodeResult == null){
			
			//表示手机短信验证通过
			
			logger.info("start creating merchant...");
			int flag = merchantRepo.create(dto, s,user,session);
			logger.info("create merchant account into db:" + flag);
			if(flag == 1){
				WeixinData request = new WeixinData();
				request.setBusinessName(dto.getMerchantName());
				request.setMid(dto.getMid());
				request.setMobile(dto.getContactMobile());
				request.setName(dto.getContactName());
				request.setUq(UUID.randomUUID().toString());
				try {
					logger.info("start calling aladin ws to insert call list");
					if(s != null){
						request.setStringField19(s.getName());
						Parameter param = paramRepo.findByGroupAndValue(Constants.PARAM_GROUP_CONTACT_POSITION, String.valueOf(dto.getContactPosition()));
						request.setStringField37(param.getName());
					}
					SoapGetAppStatusRequest statusRequest = new SoapGetAppStatusRequest();
					serviceUtils.setAutheticateInfo(statusRequest, Constants.USER_TYPE_UMS_SALES);
					statusRequest.setMID(dto.getMid());
					ArrResponse response = serviceUtils.getServiceStub().soapGetAppStatus(statusRequest);
					if(response != null && StringUtils.equals(response.getData(), "live")){
						request.setStringField26("活动商户");
					}
					String result2 = aladinWsStub.addWenxinDataToAladin(request);
					logger.info("the calling result for aladin interface is " + result2);
				} catch (RemoteException e) {
					logger.error("Error occurs while calling Aladin", e);
				} catch (Exception e) {
					logger.error("Error occurs while calling Aladin", e);
				}
			}
			
			if(flag == 0){
				//mid已存在
				result.setCode(Constants.RESULT_CODE_FAILED);
				result.setMessage("认证失败，您提交的POS机编号或者手机号已被添加，如需咨询，请联系400-608-1310。");
			}else{
				//成功
				referrerLinkRepo.valid(dto.getLinkId());
				weService.pushMessage(dto.getOpenId(), "亲，您已经成功完成认证，银商客户经理会在两个工作日内为您审核认证。卡得万利商业保理是银联商务天天富互联网金融产品，可以为您提供无担保无抵押的融资服务，如需帮助请拔打40086081310。");
				result.setCode(Constants.RESULT_CODE_SUCCESS);
				result.setMessage("亲，您已经成功提交认证申请，我们的远程客户经理会协助商户完成认证审核，成功后会及时给您通知!");
			}
		}else{
			//表示验证码验证失败
			result.setCode(Constants.RESULT_CODE_FAILED);
			result.setMessage(checkCodeResult);
			return result;
		}
		
		
		return result;
	}

	@Override
	@Transactional
	public void authorize(int merchantId) {
		merchantRepo.authorize(merchantId);
	}

	@Override
	@Transactional
	public Result<?> remoteAdd(RemoteAddMerchantDTO dto, Sales s) {
		Result<?> result = new Result<Object>();
		//创建refer link并返回短号码
		//24小时有效期
		ReferrerLink link = referrerLinkRepo.create(s.getUserId(), dto);
		//发送短信
		int flag = sendReferrerLinkNotice(link);
		if(flag < 0){
			result.setCode(Constants.RESULT_CODE_FAILED);
			result.setMessage("发送短信通知商户失败，错误码:" + flag);
		}else{
			result.setMessage("短信发送已成功");
		}
		return result;
	}

	@Override
	@Transactional
	public Result<?> validMerchant(String openId, long linkId) {
		ReferrerLink link = referrerLinkRepo.findById(linkId);
		List<KeyMerchantDTO> keyMerchants = keyMerchantService.findByMid(link.getMid());
		Result<?> result = new Result();
		if(keyMerchants != null && keyMerchants.size() > 0){
			MerchantRegisterDTO dto = new MerchantRegisterDTO();
			dto.setContactMobile(link.getContactMobile());
			dto.setContactName(link.getContactName());
			dto.setContactPosition(link.getContactPosition());
			KeyMerchantDTO keyMerchant = keyMerchants.get(0);
			dto.setMerchantName(keyMerchant.getMerchantName());
			dto.setOpenId(openId);
			dto.setLinkId(linkId);
			dto.setReferrerId(link.getReferrerId());
			dto.setMid(link.getMid());
			//以上信息从白名单读取出来直接set商户相关字段，因为此时需要自动创建用户，所以还需set注册时填写的字段
			dto.setName(link.getContactName());

			//通过白名单中的银联分支机构省市来匹配查询微信系统中的省市
			CvRegionConf cvRegionConf = utilRepo.getProvincesOrRegionsByMatching(keyMerchant.getProvince());
			if(cvRegionConf != null) {
				if(cvRegionConf.getRegionLevel() == 2) {
					//表示匹配到了省
					dto.setProvinceId(cvRegionConf.getId());
					//dto.setRegionId(keyMerchant.getPrefecture());
				} else if(cvRegionConf.getRegionLevel() == 3) {
					//表示匹配到了市
					dto.setProvinceId(cvRegionConf.getPid());
					dto.setRegionId(keyMerchant.getId());
				}
			}
			dto.setMobile(link.getContactMobile());
			dto.setEmail(null);//注册成功以后手动修改
			dto.setPassword(null);//系统自动生成密码
			Sales s = salesRepo.findByUserId(link.getReferrerId());
			result = create(dto, s);
			if(result.getCode().equals(Constants.RESULT_CODE_SUCCESS)){
				WeUser user = userRepo.findOne(link.getReferrerId());
				weService.pushMessage(user.getOpenId(), "您营销的商户" + dto.getMerchantName() + "已成功添加关注，我们的远程客户中心会在两个工作日内为商户激活账号。");
			}
		}else{
			result.setCode(Constants.RESULT_CODE_FAILED);
			result.setMessage("对不起，您当前不是我们的白名单商户，无法验证。");
		}
		return result;
	}
	
	@Override
	public int sendReferrerLinkNotice(ReferrerLink link){
		String mid = link.getMid();
		MerchantCredit credit = merchantCreditRepo.findByMid(mid, null);
		Parameter maxParam = paramRepo.findByGroupAndName(Constants.PARAM_GROUP_CREDIT_LINE_DISPLAY_THRESHOLD, "max");
		double maxValue = Double.valueOf(maxParam.getValue());
		double totalCreditLine = 0.0;
		if(credit != null){
			totalCreditLine = credit.getCreditLine();
		}
		String smsContent = null;
		if(totalCreditLine > maxValue){
			totalCreditLine = maxValue;
		}
		DecimalFormat format = new DecimalFormat("0.0");
		String creditLineInString = format.format(totalCreditLine/10000);
		smsContent = String.format(smsTemplateRemoteAddMerchant, link.getContactName(), creditLineInString, link.getShortKey());
		int flag = smsService.sendSms(link.getContactMobile(), smsContent);
		return flag;
	}
	
	@Override
	public boolean hasCreditLine(List<MerchantCredit> credits){
		boolean flag = false;
		for(MerchantCredit credit : credits){
			if(credit.getCreditLine() > 0){
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	
	public ExchangerResultModel bankStatementList(String beginDate,String endDate,String baoliId,int pageNum, int pageSize){
		ObjectMapper mapper = new ObjectMapper();
		ExchangerResultModel exchangerResultModel = null;
		try {
			//调用接口获取对账单对象
			String result = queryDataPortBindingStub.queryMoney(beginDate, endDate, baoliId, 0, 0, 0);
			//将JSON数据格式转换为实体对象
			exchangerResultModel = (ExchangerResultModel)mapper.readValue(result, ExchangerResultModel.class);
	        //获取对账单明细集合
	        List<ExchangeRecordModel> recordModels = exchangerResultModel.getRows();
	        //对明细进行分页
	        PageModel pageModel = new PageModel(recordModels, pageSize);
			Collections.reverse(recordModels);//倒序一下
	        //获取分页后的集合
	        List<ExchangeRecordModel> newRecordModels = pageModel.getObjects(pageNum); 
	        //将分页后的集合重新加入返回对象中
	        exchangerResultModel.setRows(newRecordModels);
		} catch (Exception e) {
			logger.error("Error occurs while querying bank statement list...", e);
		}
		return exchangerResultModel;
	}
	
	@Override
	public List queryBaolisIdByMid(String mid){
		ObjectMapper mapper = new ObjectMapper();
		List<BaoliIdModel> lst = null;
		try {
			//调用接口获取对保理编号
			String result = queryDataPortBindingStub.queryCashadvIdByMid(mid);
			//获取泛型list类型
			JavaType javaType = getCollectionType(ArrayList.class, BaoliIdModel.class);
			//将JSON转换为泛型LIST
	        lst = (List<BaoliIdModel>)mapper.readValue(result, javaType);
		} catch (Exception e) {
			logger.error("Error occurs while querying merchant baoli id...", e);
		}
		return lst;
	}
	
	/**   
     * 获取泛型的Collection Type  
     * @param collectionClass 泛型的Collection   
     * @param elementClasses 元素类   
     * @return JavaType Java类型   
     * @since 1.0   
     */ 
	 private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
		 ObjectMapper mapper = new ObjectMapper();
	     return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
	 }

	/**
	 * 获取授信详情公共方法
	 * @param dto 调用接口需要用到的dto
	 * @param user 调用接口需要用到的user
	 * @param entryType 入口类型：1表示是在后台认证的时候调用  2表示直接在用户管理界面里点击进入查询授信额度
	 * @returnentryType
	 */
	public Result<?> getCreditInfo(MerchantRegisterDTO dto,WeUser user,String entryType){

		Result<?> result = new Result<Object>();
		ObjectMapper mapper = new ObjectMapper();
		UserInfo userInfo = userInfoRepo.findByUserId(user.getId());
		try {
			//构建调用网站段的授信接口参数
			SoapRequestAuths soapRequestAuths = new SoapRequestAuths("", "");
			SoapCreditResultRequestMain soapCreditResultRequestMain = null;
			//判断entryType类型
			if(entryType.equals("1")) soapCreditResultRequestMain = new SoapCreditResultRequestMain("55",dto.getMerchantName(), dto.getMid(), "yes", dto.getLoanAmount(), String.valueOf(Integer.parseInt(dto.getPaybackPeriod())*30),userInfo.getProvinceName() ,user.getUsername());//表示后台进入
			else soapCreditResultRequestMain = new SoapCreditResultRequestMain("55",null, null, null, null,null,null, user.getUsername());//表示前端用户管理界面进入
			//调用接口返回结果
			cn.cvbaoli.www.ArrResponse arrResponse = addServiceBindingStub.creditResult(soapRequestAuths, soapCreditResultRequestMain);
			//给返回接口设置状态
			result.setReturnStatus(arrResponse.getStatus());
			//判断调用接口返回的状态码
			if(arrResponse.getStatus().equals("3")){
				//表示接口已经拿到了授信结果,获取返回授信信息
				String resultStr = arrResponse.getData();
				//将JSON转对象
				WebsiteCreditModel websiteCreditModel = mapper.readValue(resultStr, WebsiteCreditModel.class);
				//存储授信对象到result
				result.setReturnObj(websiteCreditModel);
			}
			logger.info("===================调用网站接口获取授信,授信状态:"+arrResponse.getStatus()+",处理结果信息为:"+arrResponse.getMsg()+"================");
		} catch (Exception e) {
			logger.error("网站授信接口调用失败：",e);
			result.setCode(Constants.RESULT_CODE_FAILED);
			result.setReturnStatus("0");
		}
		//成功
		result.setCode(Constants.RESULT_CODE_SUCCESS);
		result.setMessage("succeed");
		return result;
	}

	/**
	 * 获取速融记录
	 * @param user
	 * @param type 1获取所有类型融资记录 2只获取“速融”类型融资记录
	 * @return
	 */
	public List queryInstantCreditByMerchantAppid(WeUser user,String type){
		Merchant merchant = userService.findMerchantByUserId(user.getId());
		List<InstantCreditModel> instantCreditModels = new ArrayList<InstantCreditModel>();//速融记录
		try {
			/**step1.接口1：通过商户MID进入CRM查询是否存在APPID*/
			SoapCheckExistingAppRequest soapCheckExistingAppRequest = new SoapCheckExistingAppRequest();
			soapCheckExistingAppRequest.setChannel(crmWsMerchantUsername);
			soapCheckExistingAppRequest.setClientSecret(crmWsMerchantPassword);
			soapCheckExistingAppRequest.setMID(merchant.getMid());
			soapCheckExistingAppRequest.setCorporateName(null);
			//调用检查APPID接口
			cn.cardvalue.crm.ArrResponse checkArrResponse = mcaServiceBindingStub.soapCheckExistingApp(soapCheckExistingAppRequest);
			//表示当前还没有进行融资申请操作，返回空集合
			if(!checkArrResponse.getCode().equals("-2")){
				//服务器没有返回appid时，如果本地有没有appid给出提示，如果有则进行后续操作
				if(StringUtils.isBlank(merchant.getAppid())){
					logger.error("调用速融接口关闭商户融资申请失败,结果为:"+checkArrResponse.getCode()+",失败信息为:" + checkArrResponse.getMessage());
					return new ArrayList<InstantCreditModel>();
				}
			} else {
				//如果存在的话设置APPID给merchant
				merchant.setAppid(checkArrResponse.getData());
				//保存APPID到数据库
				em.merge(merchant);
			}

			/**step2.接口2：获取融资记录*/
			SoapListMcaRequest soapListMcaRequest = new SoapListMcaRequest();
			soapListMcaRequest.setApp_id(merchant.getAppid());
			soapListMcaRequest.setChannel(crmWsMerchantUsername);
			soapListMcaRequest.setClientSecret(crmWsMerchantPassword);
			//调用速融接口
			cn.cardvalue.crm.ArrResponse arrResponse = mcaServiceBindingStub.soapListMca(soapListMcaRequest);
			if(arrResponse.getCode().equals("1")){
				String data = arrResponse.getData();
				ObjectMapper mapper = new ObjectMapper();
				instantCreditModels = mapper.readValue(data, new TypeReference<List<InstantCreditModel>>(){});
			}
			logger.info("调用速融接口获取商户的速融记录,接口段返回状态为："+arrResponse.getCode()+",返回提示信息为:"+arrResponse.getMessage());
		} catch (Exception e) {
			logger.error("调用速融接口获取商户的速融记录失败：",e);
		}

		if(type.equals("1")){
			//返回所有融资类型记录
			return instantCreditModels;
		}else{
			//只返回速融类型记录
			List<InstantCreditModel> newInstantCreditModels = new ArrayList<InstantCreditModel>();//新集合
			for (InstantCreditModel instantCreditModel : instantCreditModels) {
				if(instantCreditModel.getProdName().equals("速融"))
					newInstantCreditModels.add(instantCreditModel);
			}
			return newInstantCreditModels;
		}

	}

	/**
	 * 通过保理id获取单个速融记录
	 * @param user
	 * @return
	 */
	public InstantCreditModel getInstantCreditModelByCashadvId(WeUser user,String cashadvId){
		List<InstantCreditModel> instantCreditModels = queryInstantCreditByMerchantAppid(user,"1");
		for (InstantCreditModel instantCreditModel : instantCreditModels) {
			if(instantCreditModel.getCashadvId().equals(cashadvId)){
				return instantCreditModel;
			}
		}
		return new InstantCreditModel();
	}

	/**
	 * 判断是否有未完成的融资申请
	 * @param user
	 * @return
	 */
	public Result<?> isFinishFinancing(WeUser user){
		Result<?> result = new Result<Object>();
		//获取所有融资记录
		List<InstantCreditModel> instantCreditModels = queryInstantCreditByMerchantAppid(user,"1");
		//遍历融资记录
		for (InstantCreditModel instantCreditModel : instantCreditModels) {
			//判断是否存在未关闭或者未放弃的申请记录
			if(!(instantCreditModel.getStatus().equals("已关闭") || instantCreditModel.getStatus().equals("已放弃"))){
				result.setCode(Constants.RESULT_CODE_FAILED);
				if(!instantCreditModel.getProdName().equals("速融"))
					result.setMessage("亲，您好，您的融资申请（"+instantCreditModel.getProdName()+"）还未结束，请登录网站完成该申请！");
				else
					result.setMessage("亲，您好，您的速融申请还未结束，不允许再次申请！");

				return result;
			}
		}
		return null;//表示所有融资申请都结束了
	}


	/**
	 * 关闭融资申请
	 * @param user
	 * @return
	 */
	public Result<?> closeFinancing(WeUser user,String cashadvId){
		Result<?> result = new Result<Object>();
		Merchant merchant = userService.findMerchantByUserId(user.getId());
		try {
			/**step1.接口1：通过商户MID进入CRM查询是否存在APPID*/
			SoapCheckExistingAppRequest soapCheckExistingAppRequest = new SoapCheckExistingAppRequest();
			soapCheckExistingAppRequest.setChannel(crmWsMerchantUsername);
			soapCheckExistingAppRequest.setClientSecret(crmWsMerchantPassword);
			soapCheckExistingAppRequest.setMID(merchant.getMid());
			soapCheckExistingAppRequest.setCorporateName(null);
			//调用检查APPID接口
			cn.cardvalue.crm.ArrResponse checkArrResponse = mcaServiceBindingStub.soapCheckExistingApp(soapCheckExistingAppRequest);
			//表示当前还没有进行融资申请操作，返回空集合
			if(!checkArrResponse.getCode().equals("-2")){
				//服务器没有返回appid时，如果本地有没有appid给出提示，如果有则进行后续操作
				if(StringUtils.isBlank(merchant.getAppid())){
					logger.error("调用速融接口关闭商户融资申请失败,结果为:"+checkArrResponse.getCode()+",失败信息为:" + checkArrResponse.getMessage());
					result.setCode(Constants.RESULT_CODE_FAILED);
					result.setMessage("服务器繁忙，该申请关闭失败！请稍后再试！");
					return result;
				}
			} else {
				merchant.setAppid(checkArrResponse.getData());//如果存在的话设置APPID给merchant
				//保存APPID到数据库
				em.merge(merchant);
			}

			//构建接口参数
			SoapUpdateStatusRequest soapUpdateStatusRequest = new SoapUpdateStatusRequest();
			soapUpdateStatusRequest.setChannel(crmWsMerchantUsername);
			soapUpdateStatusRequest.setClientSecret(crmWsMerchantPassword);
			soapUpdateStatusRequest.setApp_id(merchant.getAppid());
			soapUpdateStatusRequest.setCashadv_id(cashadvId);
			soapUpdateStatusRequest.setNewStatus("已放弃");
			soapUpdateStatusRequest.setProcessor(user.getProcessorId());
			soapUpdateStatusRequest.setUser_id(user.getUsername());
			soapUpdateStatusRequest.setDeal_id("0");//应该置为null
			//调用修改速融状态接口
			cn.cardvalue.crm.ArrResponse arrResponse = mcaServiceBindingStub.soapUpdateStatus(soapUpdateStatusRequest);
			if(arrResponse.getCode().equals("1")){
				result.setCode(Constants.RESULT_CODE_SUCCESS);
				result.setMessage("您已成功关闭该申请！");
			}else{
				//失败信息返回
				result.setCode(Constants.RESULT_CODE_FAILED);
				result.setMessage(arrResponse.getData());
			}
		} catch (Exception e) {
			logger.error("调用速融接口关闭商户融资申请失败：",e);
			result.setCode(Constants.RESULT_CODE_FAILED);
			result.setMessage("服务器繁忙，该申请关闭失败！请稍后再试！");
		}
		return result;
	}

	/**
	 * 修改商户信息，（用于网站第一次同步用户到微信，微信端进入认证界面补全信息）
	 * @param dto
	 * @param user
	 * @param session
	 * @return
	 */
	@Transactional
	public Merchant mergeMerchant(MerchantRegisterDTO dto,WeUser user,HttpSession session){

		//表示不存在相同的MID
		Merchant merchant = merchantRepo.findByUser(user);

		if(StringUtils.isBlank(merchant.getMid())){
			//特殊处理，用户可以输入多个商编
			String[] mids = dto.getMid().split(",");
			if(mids.length == 1){
				merchant.setMid(dto.getMid().substring(0,15));
			}else{
				merchant.setMid(mids[0].substring(0,15));
				//拼接其他mid
				String otherMid = "";
				for(int i = 1 ; i <mids.length ; i ++){
					otherMid += mids[i]+",";
				}
				merchant.setOtherMid(otherMid);
			}
		}

		if(StringUtils.isBlank(merchant.getName())) merchant.setName(dto.getMerchantName());
		if(StringUtils.isBlank(merchant.getContactName())) merchant.setContactName(dto.getContactName());
		if(StringUtils.isBlank(merchant.getAddress())) merchant.setAddress(dto.getAddress());

		/**修改商户信息*/
		em.merge(merchant);

		//修改完成以后重新存入session中
		session.setAttribute(Constants.SESSION_KEY_MERCHANT, merchant);

		/**修改用户对象的proceesorId*/
		if(dto.getProcessorId() != null){
			user.setProcessorId(dto.getProcessorId());//如果网站端有传入PROCESSORID则修改
			em.merge(user);
		}

		/**调用网站接口，将修改的信息同步到网站*/
		try {
			UserInfo userInfo = userInfoRepository.findByUserId(user.getId());
			SoapRequestAuths soapRequestAuths = new SoapRequestAuths("","");
			SoapSyncUserMerchantRequestMain soapSyncUserMerchantRequestMain = new SoapSyncUserMerchantRequestMain(user.getUsername(), dto.getContactMobile(), merchant.getMid(),userInfo.getProvinceId().toString(), dto.getMerchantName(), dto.getAddress(), dto.getProcessorId() == null ? user.getProcessorId() :  dto.getProcessorId());
			cn.cvbaoli.www.ArrResponse arrResponse = addServiceBindingStub.syncUserMerchant(soapRequestAuths, soapSyncUserMerchantRequestMain);
			if(!arrResponse.getStatus().equals("1")){
				//表示失败，打印日志信息
				ObjectMapper mapper = new ObjectMapper();
				logService.insertActionLog(Constants.ACTION_SYN_MERCHANT, user.getId(), null, "微信端商户认证成功，同步到网站用户失败，错误信息为："+arrResponse.getMsg()+"，失败详情如下：1、网站service第1个参数对象'auths'转json为:"+ mapper.writeValueAsString(soapRequestAuths) + " 2、网站service第2个参数对象转'json'为:"+ mapper.writeValueAsString(soapSyncUserMerchantRequestMain));
			}
			logger.info("微信端认证，同步认证信息到网站，结果为："+ arrResponse.getStatus() +" 日志信息为：",arrResponse.getMsg());
		} catch (Exception e) {
			logger.error("商户微信端认证，同步到网站接口出错！错误信息如下：",e);
		}

		return merchant;
	}
	 
}
