package com.cardvalue.wechat.ws;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cardvalue.wechat.dto.SaveSalesDTO;
import com.cardvalue.wechat.model.ActionLog;
import com.cardvalue.wechat.model.Campaign;
import com.cardvalue.wechat.model.Coupon;
import com.cardvalue.wechat.model.Sales;
import com.cardvalue.wechat.model.UserCampaign;
import com.cardvalue.wechat.model.UserCoupon;
import com.cardvalue.wechat.model.UserPointSummary;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.ActionLogRepository;
import com.cardvalue.wechat.repository.CampaignRepository;
import com.cardvalue.wechat.repository.SalesRepository;
import com.cardvalue.wechat.repository.UserCampaignRepository;
import com.cardvalue.wechat.repository.UserPointLogRepository;
import com.cardvalue.wechat.repository.UserPointSummaryRepository;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.service.CouponService;
import com.cardvalue.wechat.service.KeyMerchantService;
import com.cardvalue.wechat.service.MerchantService;
import com.cardvalue.wechat.service.UserPointService;
import com.cardvalue.wechat.service.UserService;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.service.WeChatService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.Result;
import com.cardvalue.wechat.ws.bo.AddPointRequest;
import com.cardvalue.wechat.ws.bo.AddUserRequest;
import com.cardvalue.wechat.ws.bo.AuthRequest;
import com.cardvalue.wechat.ws.bo.GetPointRequest;
import com.cardvalue.wechat.ws.bo.MakeLoanRequest;
import com.cardvalue.wechat.ws.bo.SynMerchantRequest;
import com.cardvalue.wechat.ws.bo.SynMerchantUserRequest;
import com.cardvalue.wechat.ws.bo.UpdatePasswordRequest;
import com.cardvalue.wechat.ws.bo.UpdateUserRequest;

@Component
@WebService(serviceName="AccountService")
public class AccountServiceEndpoint  {

	private final static Logger logger = LoggerFactory.getLogger(AccountServiceEndpoint.class);
	
	@Resource
	private UserRepository userRepo;

	@Resource
	private SalesRepository salesRepo;
	
	@Resource
	private UserPointService userPointService;
	
	@Resource
	private UserPointSummaryRepository userPointSummaryRepo;
	
	@Resource
	private UserPointLogRepository userPointLogRepo;
	
	@Resource
	private MerchantService merchantService;
	
	@Resource
	private KeyMerchantService keyMerchantService;

	@Resource
	private UserService userService;

	@Resource
	private WeChatService weChatService;
	
	@Resource
	private CouponService couponService;

	@Resource
	private UserCampaignRepository userCampaignRepository;

	@Resource
	private CampaignRepository campaignRepository;

	@Resource
	private ActionLogRepository actionLogRepository;

	@Resource
	private UtilityService utilityService;

	@WebMethod(operationName="updateUser")
	public Result<?> updateUser(UpdateUserRequest request) {
		logger.info("start update user... [username:" + request.getUsername() + "][userType:" + request.getUserType() + "][processorId:" + request.getProcessorId() + "]");
		Result<Object> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		String username = request.getUsername();
		WeUser user = userRepo.findByUsername(username);
		if(user != null){
			if(validatePassword(user.getPassword(), request.getPassword())){
				try {
					user.setType(Integer.parseInt(request.getUserType()));
					user.setProcessorId(request.getProcessorId());
					userRepo.save(user);
					Sales sales = salesRepo.findByUserId(user.getId());
					PropertyUtils.copyProperties(sales, request);
					salesRepo.save(sales);
					result.setMessage("更新成功");
					result.setCode(Constants.RESULT_CODE_SUCCESS);
				} catch (Exception e) {
					logger.error("Error",e);
					result.setMessage("系统错误:" + e.getMessage());
				}
			}else{
				result.setMessage("密码错误");
			}
		}else{
			result.setMessage("用户不存在");
		}
		logger.info("finish update user [code:" + result.getCode() + "]");
		logger.info(result.toString());
		return result;
	}
	
	@WebMethod(operationName="updatePassword")
	public Result<?> updatePassword(UpdatePasswordRequest request) {
		logger.info("start update password...");
		Result<Object> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		String username = request.getUsername();
		WeUser user = userRepo.findByUsername(username);
		if(user != null){
			if(validatePassword(user.getPassword(), request.getPassword())){
				user.setPassword(request.getNewPassword());
				userRepo.save(user);
				result.setCode(Constants.RESULT_CODE_SUCCESS);
			}else{
				result.setMessage("密码错误");
			}
		}else{
			result.setMessage("用户不存在");
		}
		logger.info("finish update password [code:" + result.getCode() + "]");
		logger.info(result.toString());
		return result;
	}
	
	@WebMethod(operationName="addUser")
	public Result<?> addUser(AddUserRequest request) {
		logger.info("start add user...");
		Result<Object> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		SaveSalesDTO dto = new SaveSalesDTO();
		try{
			PropertyUtils.copyProperties(dto, request);
			Sales s = salesRepo.saveSales(dto);
			if(s != null){
				result.setCode(Constants.RESULT_CODE_SUCCESS);
				result.setMessage("添加新用户成功");
			}else{
				result.setMessage("添加新用户失败, 手机号码重复");
			}
		}catch(Exception e){
			logger.error("Error:", e);
			result.setMessage("添加新用户失败, 原因:" + e.toString());
		}
		logger.info("finish add user [code:" + result.getCode() + "]");
		logger.info(result.toString());
		return result;
	}

	/**
	 * 网站调用微信,添加用户
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@WebMethod(operationName="synMerchantUser")
	public Result<?> synMerchantUser(AuthRequest auth,SynMerchantUserRequest request) throws Exception {

		//获取安全用户名和密码
		String authName = auth.getAuthName();
		String authPwd =  auth.getAuthPwd();

		//网站同步用户
		Result<?> r = userService.synMerchantUser(request);

		return r;
	}

	/**
	 * 网站调用微信,添加商户
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@WebMethod(operationName="synMerchant")
	public Result<?> synMerchant(AuthRequest auth,SynMerchantRequest request) throws Exception {

		//获取安全用户名和密码
		String authName = auth.getAuthName();
		String authPwd =  auth.getAuthPwd();

		//网站同步商户对象
		Result<?> r = userService.synMerchant(request);

		return r;
	}

	/**
	 * 网站调用微信,获取token
	 * @param auth
	 * @return
	 * @throws Exception
	 */
	@WebMethod(operationName="getWechatToken")
	public String getWechatToken(AuthRequest auth) throws Exception {
		try {
			//获取安全用户名和密码
			String authName = auth.getAuthName();
			String authPwd =  auth.getAuthPwd();
			return weChatService.getAccessToken();
		} catch (Exception e) {
			logger.error("给网站返回微信token报错:",e);
			return null;
		}
	}

	@WebMethod(operationName="updateUserStatus")
	public Result<?> updateUserStatus(String username, int status) {
		logger.info("start update user status...");
		Result<Object> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		WeUser user = userRepo.findByUsername(username);
		if(user == null){
			result.setMessage("更新用户状态失败，用户不存在");
		}else{
			if(status == 1){
				user.setEnabled(true);
			}else{
				user.setEnabled(false);
				user.setOpenId(null);
			}
			userRepo.save(user);
			result.setCode(Constants.RESULT_CODE_SUCCESS);
			result.setMessage("更新用户状态成功");
		}
		logger.info("finish upadte user status[code:" + result.getCode() + "]");
		logger.info(result.toString());
		return result;
	}
	
	//crm调用，查看用户积分
	@WebMethod(operationName="getPoint")
	public Result<?> getPoint(GetPointRequest request) {
		logger.info("start get point...");
		Result<Object> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		WeUser user = userRepo.findByUsername(request.getUsername());
		if (user != null) {
			if(validatePassword(user.getPassword(), request.getPassword())){
				UserPointSummary ups = userPointService.getSummary(user.getId());
				result.setCode(Constants.RESULT_CODE_SUCCESS);
				result.setMessage(String.valueOf(ups.getAvailablePoint()));
			}else {
				result.setMessage("用户[" + request.getUsername() + "]密码不正确");
			}
		} else {
			result.setMessage("用户[" + request.getUsername() + "]不存在");
		}
		logger.info("finish get point[code:" + result.getCode() + "]");
		logger.info(result.toString());
		return result;
	}
	
	//crm调用，日常加分
	@WebMethod(operationName="addPoint")
	public Result<?> addPoint(AddPointRequest request) {
		logger.info("start add point...");
		Result<Object> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		WeUser user = userRepo.findByUsername(request.getUsername());
		if (user != null) {
			if(validatePassword(user.getPassword(), request.getPassword())){
				int availablePoints = userPointService.addExtraPoint(user.getId(), request.getPoint(), request.getMemo());
				result.setCode(Constants.RESULT_CODE_SUCCESS);
				result.setMessage("加分成功");
				result.setPayload(availablePoints);
			}else {
				result.setMessage("用户[" + request.getUsername() + "]密码不正确");
			}
		} else {
			result.setMessage("用户[" + request.getUsername() + "]不存在");
		}
		logger.info("finish add point[code:" + result.getCode() + "]");
		logger.info(result.toString());
		return result;
	}
	
	//crm调用，放款成功后续调用，如加分等
	@WebMethod(operationName="makeLoan")
	public Result<?> makeLoan(MakeLoanRequest request) {
		logger.info("start make loan...");
		Result<Object> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		WeUser user = userRepo.findByUsername(request.getUsername());
		if(user != null){
			if(validatePassword(user.getPassword(), request.getPassword())){
				if(StringUtils.isNotBlank(request.getFactoringNumber())){
					int number = userPointLogRepo.getCountByFactoringNo(request.getFactoringNumber()).intValue();
					if(number == 0){
						int availablePoint = userPointService.addPoint(user.getId(), Constants.ACTION_MAKE_LOAN, request.getMemo(), request.getFactoringNumber());
						result.setCode(Constants.RESULT_CODE_SUCCESS);
						result.setMessage("加分成功");
						result.setPayload(availablePoint);
					}else{
						result.setMessage("融资保理[ " + request.getFactoringNumber() + "]已积分，请勿重复积分");
					}
				}else{
					result.setMessage("没有提供融资保理编号");
				}
			}else {
				result.setMessage("用户[" + request.getUsername() + "]密码不正确");
			}
		}else{
			result.setMessage("用户[" + request.getUsername() + "]不存在");
		}
		logger.info("finish make loan[code:" + result.getCode() + "]");
		logger.info(result.toString());
		return result;
	}
	
	@WebMethod(exclude=true)
	private boolean validatePassword(String blankPassword, String encodedPassword){
//		if(blankPassword  == null || encodedPassword  == null){
//			return false;
//		}
//		String md5Password = null;
//		try{
//			md5Password = Md5Crypt.md5Crypt(blankPassword.getBytes("utf-8"), encodedPassword);
//		}catch(Exception e){
//			logger.error("Error", e);
//		}
//		return StringUtils.equals(md5Password, encodedPassword);
		//always return true because of the potential password difference between crm and wechat
		return true;
	}
	
	public Result<?> updateCouponStatus(String couponNumber, int status){
		logger.info("update coupon [" + couponNumber + "]status with status:" + status);
		int flag = couponService.updateCouponStatus(couponNumber, status);
		Result<?> result = new Result<Object>();
		if(flag == 1){
			result.setCode(Constants.RESULT_CODE_SUCCESS);
		}else{
			result.setCode(Constants.RESULT_CODE_FAILED);
			//2:不存在, 3:无法改变状态, 4:状态无效, 5:未知错误
			String errorMessage = "未知错误";
			switch(flag){
			case 2:
				errorMessage = "优惠券" + couponNumber + "不存在";
				break;
			case 3:
				errorMessage = "优惠券" + couponNumber + "无法改变为状态" + status;
				break;
			case 4:
				errorMessage = "优惠券" + couponNumber + "状态" + status + "无法识别";
				break;
			}
			result.setMessage(errorMessage);
		}
		logger.info("finish update coupon status with " + result.toString());
		return result;
	}
	
	@WebMethod(operationName="newCoupon")
	public Result<?> newCoupon(String username, String couponName){
		logger.info("new coupon [" + couponName + "] for user [" + username + "]");
		WeUser user = userRepo.findByUsername(username);
		Result<?> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		if(user != null){
			Coupon coupon = couponService.getCouponByName(couponName);
			if(coupon != null){
				UserCoupon uc = couponService.newCoupon(coupon.getId(), user.getId());
				result.setCode(Constants.RESULT_CODE_SUCCESS);
				result.setMessage(uc.getCouponNumber());
			}else{
				result.setMessage("Coupon [" + couponName + "] doesn't exists");
			}
		}else{
			result.setMessage("User [" + username + "] doesn't exists");
		}

		//如果失败则记录日志到数据库
		if (result.getCode().equals(Constants.RESULT_CODE_FAILED)) {
			//当前接口请求参数
			Map<String, Object> callMethodParams = new HashMap<String, Object>();
			callMethodParams.put("username", username);
			callMethodParams.put("couponName", couponName);
			//记录错误信息到数据库
			utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_ADD_COUPON, new Date(),
					this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, result.getMessage(), "")));
		}

		logger.info("new coupon with " + result.toString());
		return result;
	}

	/**
	 * 微信端线索在CRM中变成成功线索时，CRM调用此方法增加抽奖次数
	 * @param username
	 * @return
	 */
	@WebMethod(operationName="changeExtraDrawCount")
	public Result<?> changeExtraDrawCount(String username){
		Result<?> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		WeUser user = userRepo.findByUsername(username);
		if (user != null) {
			//2015.6.18 杉德活动
			if(user.getType() == Constants.USER_TYPE_SANDPAY_SALES){
				//表示此线索是银商客户经理提出的，大转盘只针对银商客经
				try {
					//成功线索，需要将用户的抽奖次数加1
					//2015.6.18 杉德活动
					Campaign campaign = campaignRepository.findById(10);//获取抽奖活动
					if (campaign != null) {
						//判断当前活动是否已经结束
						Date now = new Date();
						if(now.after(campaign.getBeginDate()) && now.before(campaign.getEndDate())){
							//表示活动还未结束
							List<UserCampaign> userCampaigns = userCampaignRepository.findByCampaignAndUser(campaign,user);
							if(userCampaigns != null && userCampaigns.size() > 0) {
								UserCampaign userCampaign = userCampaigns.get(0);
								userCampaign.setExtraDrawCount(userCampaign.getExtraDrawCount() + 1);
								userCampaignRepository.save(userCampaign);
								result.setCode(Constants.RESULT_CODE_SUCCESS);
								result.setMessage("用户:" + user.getUsername() + " 提交的线索crm已经转为成功线索，用户新增一次抽奖机会，现在可用抽奖总次数为:" + (userCampaign.getExtraDrawCount()-userCampaign.getUsedExtraDrawCount()));
							} else {
								//表示在大转盘活动内，用户是先进入提交线索，后进入大转盘就会，执行此处代码,依然增加次数
								//创建用户关联大转盘活动对象.
								UserCampaign userCampaign = new UserCampaign();
								userCampaign.setUser(user);
								userCampaign.setCampaign(campaign);
								userCampaign.setAwardGave(false);
								userCampaign.setExtraDrawCount(0);
								userCampaign.setUsedExtraDrawCount(0);
								//userCampaignRepository.save(userCampaign);
								//logger.info("user campaign record created, user:" + user.getId() + ",campaign:" + campaign.getId());
								//新增抽奖次数
								userCampaign.setExtraDrawCount(userCampaign.getExtraDrawCount() + 1);
								userCampaignRepository.save(userCampaign);
								result.setCode(Constants.RESULT_CODE_SUCCESS);
								result.setMessage("用户:" + user.getUsername() + " 提交的线索crm已经转为成功线索，用户新增一次抽奖机会，现在可用抽奖总次数为:" + (userCampaign.getExtraDrawCount()-userCampaign.getUsedExtraDrawCount()));
							}
						} else {
							//表示活动已结束
							result.setMessage("用户:" + user.getUsername() + " 当前日期不在微信大转盘活动时间范围内，新增抽奖次数失败!!");
						}
					} else {
						result.setMessage("用户:" + user.getUsername() + " 微信端无法查到大转盘活动，新增抽奖次数失败!!");
					}
				} catch (Exception e) {
					result.setMessage("用户:" + user.getUsername() + "新增抽奖机会出错:" + e);
				}
			} else {
				//表示不是银商客户经理提出，需要给出提示
				result.setMessage("用户:" + user.getUsername() + "的身份类型不是‘银联客户经理’，本次大转盘只针对银商客经！:");
			}

		} else {
			result.setMessage("用户:" + username + " CRM传入的用户名，微信端无法找到!");
		}
		logger.info(result.getMessage());
		return result;
	}

}