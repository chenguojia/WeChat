package com.cardvalue.wechat.web;

import com.cardvalue.wechat.dto.*;
import com.cardvalue.wechat.model.*;
import com.cardvalue.wechat.repository.*;
import com.cardvalue.wechat.service.*;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.PageableResult;
import com.cardvalue.wechat.util.Result;
import com.cardvalue.wechat.util.Utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/app")
public class AppController {

	private static final Logger logger = LoggerFactory.getLogger(AppController.class);

	@Resource
	private UserRepository userRepository;

	@Resource
	private SalesRepository salesRepository;

	@Resource
	private MerchantRepository merchantRepository;

	@Resource
	private PerformanceService performanceService;

	@Resource
	private UserPointService userPointService;

	@Resource
	private UtilityService utilityService;

	@Resource
	private CouponService couponService;

	@Resource UserInfoRepository userInfoRepository;

	@Resource
	private MerchantService merchantService;

	@Resource
	private WeQrCodeService qrCodeService;

	@Resource
	private LeadsService leadsService;

	@Resource
	private SmsService smsService;


	@RequestMapping(value = "/login", method = {RequestMethod.POST})
	@ResponseBody
	public Object login(String username,String password){
		try {
			if (userRepository.findByUsername(username) != null) {
				WeUser user =  userRepository.findByUsernameAndPassword(username,password);
				if (user != null) {
					user.setUserInfo(userInfoRepository.findByUserId(user.getId()));
					//判断登录角色
					if(user.getType() == 0 || user.getType() == 1 || user.getType() == 2
							|| user.getType() == 3 || user.getType() == 6  || user.getType() == 7 || user.getType() == 8) {
						Sales sales = salesRepository.findByUserId(user.getId());
						user.setSales(sales);
						//表示银商客户经理
					} else if(user.getType() == 4) {
						Merchant merchant = merchantRepository.findByUser(user);
						user.setMerchant(merchant);
					}
					return user;
				} else {
					return Utility.setErrorInfo("101","密码不正确!");
				}
			} else {
				return Utility.setErrorInfo("100","用户名不正确!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Utility.setErrorInfo("-1","服务器繁忙!");
		}
	}

	@RequestMapping(value = "/performance/getPerformance", method = RequestMethod.GET)
	@ResponseBody
	public String getPerformance(String username){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(new Date());
		//前一个月
		rightNow.add(Calendar.MONTH,-1);
		Date dt1=rightNow.getTime();
		//查询前一个月的绩效
		String lastMonthPerformance= performanceService.getPerformanceByUserNumberAndMonth(username, sdf.format(dt1));
		//查询前一个月的绩效
		String currentMonthPerformance=performanceService.getPerformanceByUserNumberAndMonth(username, sdf.format(new Date()));
		return "{\"lastMonthPerformance\":\""+lastMonthPerformance+"\",\"currentMonthPerformance\":\""+currentMonthPerformance+"\"}";
	}


	@RequestMapping(value = "/pointAndLevel", method = RequestMethod.GET)
	@ResponseBody
	public String pointAndLevel(Integer userId){
		UserPointSummary summary = userPointService.getSummary(userId);
		return "{\"balance\":\""+summary.getBalance()+"\"}";
	}

	@RequestMapping(value = "/score", method = RequestMethod.GET)
	@ResponseBody
	public PointAndLevelDTO score(Integer userId){
		WeUser user = userRepository.findById(userId);
		UserPointSummary summary = userPointService.getSummary(userId);
		Parameter levelParam = utilityService.getParamByValueAndGroup(Constants.PARAM_GROUP_USER_POINT_LEVEL, String.valueOf(summary.getLevel()));
		summary.setLevelLabel(levelParam.getName());

		List<Coupon> rebateCoupons = couponService.listAllCouponByType(Coupon.COUPON_TYPE_REBATE, userId);
		List<Coupon> mobileCoupons = couponService.listAllCouponByType(Coupon.COUPON_TYPE_MOBILE_FEE, userId);
		int availableCouponCount = couponService.getUserAvailableCouponCount(userId);
		String levelMesssage = userPointService.getLevelMessage(userId);

		PointAndLevelDTO pointAndLevelDTO = new PointAndLevelDTO(summary,rebateCoupons,mobileCoupons,availableCouponCount,levelMesssage);
		return pointAndLevelDTO;
	}

	/**
	 * 对账单查询显示界面
	 * @return
	 */
	@RequestMapping(value = "/bankStatementSearch", method = RequestMethod.GET)
	@ResponseBody
	public Object bankStatementSearch(Integer userId) {
		try {
			WeUser user = userRepository.findById(userId);
			/**表示验证成功:做自己相关业务*/
			//获取商户对象
			Merchant merchant = merchantRepository.findByUser(user);
			//获取商户mid
			String mid = merchant.getMid();
			//获取保利id集合
			List<BaoliIdModel> baoliIdModels = merchantService.queryBaolisIdByMid(mid);
			//如果接口没有返回保理编号则给予提示
			if (baoliIdModels == null || baoliIdModels.size() < 1) {
                return Utility.setErrorInfo("4000","您没有融资，系统无法查出相关信息！");
            }
			return baoliIdModels;
		} catch (Exception e) {
			e.printStackTrace();
			return Utility.setErrorInfo("-1","服务器繁忙!");
		}
	}

	/**
	 * 对账明细
	 * @param pageNumber
	 * @param pageSize
	 * @param beginDate
	 * @param endDate
	 * @param baoliId
	 * @return
	 */
	@RequestMapping(value = "/bankStatementList", method = {RequestMethod.GET})
	@ResponseBody
	public Object bankStatementList(@RequestParam(defaultValue="1") String pageNumber, @RequestParam(defaultValue="20") String pageSize,
									@RequestParam String beginDate,@RequestParam String endDate,@RequestParam String baoliId) {
		try {
			//设置返回模型对象
			ExchangerResultModel exchangerResultModel = merchantService.bankStatementList(beginDate, endDate,baoliId,Integer.valueOf(pageNumber), Integer.valueOf(pageSize));
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("exchangerResultModel",exchangerResultModel);
			map.put("pageCount",String.valueOf((int)Math.ceil((double)exchangerResultModel.getTotal()/Integer.valueOf(pageSize))));
			return map;

		} catch (Exception e) {
			e.printStackTrace();
			return Utility.setErrorInfo("-1","服务器繁忙!");
		}
	}

	/**
	 * 商户扫描商户显示二维码界面
	 * @return
	 */
	@RequestMapping(value = "/showQrCode", method=RequestMethod.GET)
	@ResponseBody
	public Object showQrCode(Integer userId){
		WeUser user = userRepository.findById(userId);
		Merchant merchant = merchantRepository.findByUser(user);
		String mid = merchant == null ? "" : merchant.getMid();
		//创建 referrer对象
		long linkId = utilityService.storeMerchantReferrer(user.getId(), mid);
		String parameter = Constants.QRCODE_PREFIX_LINK + String.valueOf(linkId);
		//生成二维码
		WeCreateQrCodeResponseDTO response = qrCodeService.createQrCode(parameter, false);
		//获取二维码图片地址链接
		String qrCodeUrl = qrCodeService.getQrCodeUrl(response.getTicket());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("url",qrCodeUrl);
		return map;
	}

	/**
	 * 商户发送短信邀请商户关注公众号
	 * @return
	 */
	@RequestMapping(value = "/sendSmsToMerchant", method=RequestMethod.POST)
	@ResponseBody
	public  Result<?> sendSmsToMerchant(Integer userId,String contactMobile){
		String sendName = ""; //发送者名称
		WeUser user = userRepository.findById(userId);
		UserInfo userInfo = userInfoRepository.findByUserId(userId);
		if (userInfo != null) {
			sendName = userInfo.getName();
		} else {
			//等于空的话获取商户名称
			Merchant merchant = merchantRepository.findByUser(user);
			if(merchant != null) {
				sendName = merchant.getName();
			} else {
				sendName = user.getUsername();
			}
		}
		Result<?> result = new Result<Object>();
		int flag = smsService.sendSms(contactMobile, "亲，"+ sendName + "邀请您关注卡得万利商业保理公众服务号，微信中搜索CVBAOLI或卡得万利关注后并进行新用户注册，注册时在推荐人手机栏中请填写"+ sendName +"的手机号码:" + user.getUsername() +"谢谢！");
		if(flag < 0){
			result.setCode(Constants.RESULT_CODE_FAILED);
			result.setMessage("发送短信通知商户失败，错误码:" + flag);
		}else{
			result.setCode(Constants.RESULT_CODE_SUCCESS);
			result.setMessage("短信发送已成功");
		}
		return result;
	}

	/**
	 * 查询值集
	 * @param groupName
	 * @return
	 */
	@RequestMapping(value = "/getParamsByGroup", method=RequestMethod.GET)
	@ResponseBody
	public Object getParamsByGroup(String groupName){
		//return utilityService.getParamsByGroup(Constants.PARAM_GROUP_CONTACT_POSITION);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("params",utilityService.getParamsByGroup(groupName));
		return map;
	}

	@RequestMapping(value = "/submitRefer", method = RequestMethod.POST)
	@ResponseBody
	public Object refer(Integer userId,MerchantReferDTO dto) throws Exception {
		try {
			WeUser user = userRepository.findById(userId);
			Merchant merchant = merchantRepository.findByUser(user);//表示用户有认证过
			//线索对象
			Leads leads = new Leads();
			//商编号
			leads.setMerchantNumber(dto.getMid());
			//
			leads.setMerchantName(dto.getMerchantName());
			//联系人
			leads.setMerchantContact(dto.getContactName());
			//身份
			leads.setContactPosition(dto.getContactPosition());
			//联系电话
			leads.setContactMobile(dto.getContactMobile());
			//备注
			leads.setMemo(dto.getMemo());
			//申请额度
			leads.setLoanAmount(dto.getLoanAmount());
			//还款时间
			leads.setPaybackPeriod(dto.getPaybackPeriod());
			//商户id
			leads.setUserId(user.getReferrerId());
			//渠道是通过微信扫描还是自主添加
			leads.setChannel(Constants.CHANNEL_MERCHANT);
			//转介人信息
			leads.setReferrerName(merchant.getContactName());
			leads.setReferrerCellPhone(merchant.getContactMobile());
			//调用CRM接口
			Result<?> serviceResult = leadsService.create(leads, user.getId());
			if(serviceResult != null && serviceResult.getCode().equals(Constants.RESULT_CODE_SUCCESS)){
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("message", "请准备以下资料，客户经理将上门为您办理。\n"
						+ "	1、营业执照复印件\n  "
						+ "	2、法人身份证正反面复印件\n "
						+ "	3、法人征信报告\n "
						+ "	4、法人借记卡、信用卡复印件\n "
						+ "	5、租房合同或房产证\n "
						+ "	6、近6个月POS机结算账号流水"
						+ "	");
				return map;
			}else if(serviceResult != null){
				return Utility.setErrorInfo("3001",serviceResult.getMessage());
			}else{
				return Utility.setErrorInfo("3000","系统错误，请重试或联系管理员!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Utility.setErrorInfo("-1","服务器繁忙!");
		}
	}

	@RequestMapping(value = "/help", method=RequestMethod.GET)
	public String help(){
		return "app/question";
	}

	@RequestMapping(value = "/applyStatus", method = RequestMethod.GET)
	@ResponseBody
	public Object applyStatus(Integer userId) {
		try {
			//验证认证或授信
			WeUser user = userRepository.findById(userId);
			PageableResult result = leadsService.listAll(user.getId());
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("list", result.getPayload());
			map.put("instantCreditlist",  merchantService.queryInstantCreditByMerchantAppid(user, "1"));
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return Utility.setErrorInfo("-1","服务器繁忙!");
		}
	}

	/**
	 * 速融状态详情查看
	 *
	 * @param cashadvId
	 * @return
	 */
	@RequestMapping(value = "/instantCreditDetail", method = RequestMethod.GET)
	@ResponseBody
	public Object instantCreditDetail(String cashadvId, Integer userId) {
		WeUser user = userRepository.findById(userId);
		InstantCreditModel instantCreditModel = merchantService.getInstantCreditModelByCashadvId(user, cashadvId);
		String processorLabel = "";
		if (utilityService.getParamByValueAndGroup(Constants.PARAM_GROUP_PROCESSOR_ID, instantCreditModel.getProcessor()) != null)
			processorLabel = utilityService.getParamByValueAndGroup(Constants.PARAM_GROUP_PROCESSOR_ID, instantCreditModel.getProcessor()).getName();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("processorLabel", processorLabel);
		map.put("instantCreditModel", instantCreditModel);
		return map;
	}

	/**
	 * 线索状态查看详情
	 * @param id
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/applyDetail", method = RequestMethod.GET)
	@ResponseBody
	public Object applyDetail(Integer id,Integer userId) {
		logger.info("entering leads details...");
		WeUser user = userRepository.findById(userId);
		Leads leads = leadsService.getLeads(user.getId(), id, true);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("leads", leads);
		return map;
	}

	@RequestMapping(value = "/queryCoupon", method = RequestMethod.GET)
	@ResponseBody
	public Object queryCoupon(Integer userId){
		WeUser user = userRepository.findById(userId);
		List<CouponInfo> coupons = couponService.listCouponInfoByUserId(user.getId());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("coupons", coupons);
		return map;
	}

}
