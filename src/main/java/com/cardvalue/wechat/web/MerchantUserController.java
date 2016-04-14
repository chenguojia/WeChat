package com.cardvalue.wechat.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.cardvalue.wechat.dto.*;
import com.cardvalue.wechat.model.*;
import com.cardvalue.wechat.repository.*;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cardvalue.wechat.annotation.Token;
import com.cardvalue.wechat.service.CouponService;
import com.cardvalue.wechat.service.LeadsService;
import com.cardvalue.wechat.service.MerchantService;
import com.cardvalue.wechat.service.SmsService;
import com.cardvalue.wechat.service.UserService;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.service.WeChatService;
import com.cardvalue.wechat.service.WeQrCodeService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.PageableResult;
import com.cardvalue.wechat.util.Result;
import com.cardvalue.wechat.util.Utility;

@Controller
@RequestMapping(value = "/m")
@SessionAttributes({Constants.SESSION_KEY_USER, Constants.SESSION_KEY_MERCHANT})
public class MerchantUserController {

	private static final Logger logger = LoggerFactory.getLogger(MerchantUserController.class);

	@Resource
	private UserService userService;

	@Resource
	private WeChatService weChatService;
	
	@Resource
	private MerchantUserRepository merchantUserRepo;
	
	@Resource
	private UserRepository userRepo;
	
	@Resource
	private UtilityService utilityService;
	
	@Resource
	private UtilRepository utilRepo;
	
	@Resource
	private LeadsService leadsService;
	
	@Resource
	private MerchantCreditRepository merchantCreditRepo;
	
	@Resource
	private MerchantService merchantService;
	
	@Resource
	private SmsService smsService;

	@Resource
	private WeQrCodeService qrCodeService;

	@Resource
	private MerchantRepository merchantRepository;

	@Resource
	private UserInfoRepository userInfoRepository;

	@Resource
	private CouponService couponService;

	@Resource
	private MerchantRepository merchantRepo;

	@Resource
	private ActionLogRepository actionLogRepository;

	@Value("${wechat.app.name}")
	private String appName;

	@Value("${wechat.appid}")
	private String weAppId;

	@Resource
	private UserInfoRepository userInfoRepo;

	@Resource
	private UtilRepository utilRepository;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(HttpSession session) {
		
		Merchant merchant = null;
		
		//从session中取当前登录人关联的商户，如果为null表示当前用户还未认证
		if(session.getAttribute(Constants.SESSION_KEY_MERCHANT) != null)
			merchant= (Merchant)session.getAttribute(Constants.SESSION_KEY_MERCHANT);
				
		ModelAndView mv = new ModelAndView("m/entry");
		mv.addObject("merchant", merchant);
		return mv;
	}
	
	@RequestMapping(value = "/authorize", method = RequestMethod.GET)
	@ResponseBody
	public int authorize(@ModelAttribute(Constants.SESSION_KEY_MERCHANT) Merchant merchant) {
		try{
			merchantService.authorize(merchant.getId());
			return 1;
		}catch(Exception e){
			logger.error("Error occurs while merchant authorization", e);
			return 2;
		}
	}
	
	@RequestMapping(value = "/showApply", method = RequestMethod.GET)
	@Token(save=true)
	public ModelAndView newApply(@ModelAttribute("login_user") WeUser user, HttpSession session) {

		//验证认证或授信
		ModelAndView mv = this.authenticationAndCreditValidate("3", "2", null, session, user).getMv();
		if (mv == null) {
			/**表示验证成功:做自己相关业务*/
			mv = new ModelAndView();
			Merchant merchant = merchantRepository.findByUser(user);
			//判断认证是否通过
			if(merchant.getActiveStatus() == 2){
				//表示认证审核通过
				mv.setViewName("/m/apply");
				mv.addObject("positions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_CONTACT_POSITION));
				MerchantApplyDTO dto = new MerchantApplyDTO();
				dto.setContactName(merchant.getContactName());
				dto.setContactMobile(merchant.getContactMobile());
				dto.setContactPosition(merchant.getContactPosition());
				dto.setMerchantName(merchant.getName());
				dto.setMid(merchant.getMid());
				//授信额度
				MerchantCredit credit = merchantCreditRepo.findByMid(merchant.getMid(), null);
				String creditLabel = "暂无额度";
				if(credit != null){
					creditLabel = credit.getCreditLineLabel();
				}
				List<CouponInfo> coupons = couponService.listCouponInfoByUserId(user.getId());
				mv.addObject("coupons", coupons);
				mv.addObject("credit", creditLabel);
				mv.addObject("creditLine", credit == null ? 0 : credit.getCreditLine());
				mv.addObject("dto", dto);
				return mv;
			}else{
				//表示正在审核，给出提示
				mv.addObject("title","");
				mv.addObject("url", "/m/home");
				mv.setViewName("/common/message-box");
				mv.addObject("message", "您当前的认证正在核实当中，请耐心等待!");
				return mv;
			}
		} else {
			/**表示验证不成功:直接返回错误提示页面*/
			return mv;
		}
	}

	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	@Token(remove=true, save=true)
	public ModelAndView apply(@ModelAttribute("login_user") WeUser user, 
			@ModelAttribute("dto") @Valid MerchantApplyDTO dto, BindingResult result, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()){
			//授信额度
			Merchant merchant = merchantRepository.findByUser(user);
			MerchantCredit credit = merchantCreditRepo.findByMid(merchant.getMid(), null);
			String creditLabel = "暂无额度";
			if(credit != null){
				creditLabel = credit.getCreditLineLabel();
			}
			List<CouponInfo> coupons = couponService.listCouponInfoByUserId(user.getId());
			mv.addObject("credit", creditLabel);
			mv.addObject("positions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_CONTACT_POSITION));
			mv.addObject("dto", dto);
			mv.addObject("token", (String)session.getAttribute(Constants.SESSION_KEY_TOKEN));
			mv.addObject("coupons", coupons);
			mv.setViewName("m/apply");
		}else{
			//表示用户有认证过
			Merchant merchant = merchantRepository.findByUser(user);
			//线索对象
			Leads leads = new Leads();
			//商编号
			leads.setMerchantNumber(merchant.getMid());
			leads.setMerchantName(merchant.getName());
			//联系人
			leads.setMerchantContact(dto.getContactName());
			//身份
			leads.setContactPosition(merchant.getContactPosition());
			//联系电话
			leads.setContactMobile(dto.getContactMobile());
			//备注
			leads.setMemo(dto.getMemo());
			//申请额度
			leads.setLoanAmount(dto.getLoanAmount());
			//还款时间
			leads.setPaybackPeriod(dto.getPaybackPeriod());
			//商户id
			leads.setUserId(user.getId());
			//数据存到我们数据库还是CRM数据库
			leads.setTaskType(Constants.TYPE_LEADS);
			//渠道是通过微信扫描还是自主添加
			leads.setChannel(Constants.CHANNEL_MERCHANT);
			//添加商户的客户经理userId
			leads.setUserId(user.getReferrerId());
			//coupons
			leads.setCouponNumbers(dto.getCouponNumbers());
			//调用CRM接口
			Result<?> serviceResult = leadsService.create(leads, user.getId());
			
			mv.setViewName("/common/message-box");
			if(serviceResult != null && serviceResult.getCode().equals(Constants.RESULT_CODE_SUCCESS)){
				mv.addObject("title","创建成功");
				mv.addObject("message", "请准备以下资料，客户经理将上门为您办理。<br/>"
						+ " <div style=\"text-align: left;\">	"
						+ "	1、营业执照复印件 <br/>"
						+ "	2、法人身份证正反面复印件<br/>"
						+ "	3、法人征信报告<br/>"
						+ "	4、法人借记卡、信用卡复印件<br/>"
						+ "	5、租房合同或房产证<br/>"
						+ "	6、近6个月POS机结算账号流水<br/>"
						+ "	</div>"
						+ "	<p style=\"text-align: center;\">"
						+ "	点击确认返回申请列表"
						+ "	</p>");
				mv.addObject("url", "/m/applyStatus");
			}else if(serviceResult != null){
				mv.addObject("title","创建失败");
				mv.addObject("message", serviceResult.getMessage());
			}else{
				mv.addObject("title","创建失败");
				mv.addObject("message", "系统错误，请重试或联系管理员");
			}
		}
		return mv;
	}
	
	@RequestMapping(value = "/showRefer", method = RequestMethod.GET)
	@Token(save=true)
	public ModelAndView showRefer(HttpSession session,@ModelAttribute("login_user") WeUser user) {
		//验证认证或授信
		ModelAndView mv = this.authenticationAndCreditValidate("1", "2", null, session, user).getMv();
		if (mv == null) {
			/**表示验证成功:做自己相关业务*/
			mv = new ModelAndView();
			//表示认证审核通过
			mv.setViewName("/m/refer");
			mv.addObject("positions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_CONTACT_POSITION));
			MerchantReferDTO dto = new MerchantReferDTO();
			mv.addObject("dto", dto);
			return mv;
		} else {
			/**表示验证不成功:直接返回错误提示页面*/
			return mv;
		}
	}
	
	@RequestMapping(value = "/refer", method = RequestMethod.POST)
	@Token(remove=true, save=true)
	public ModelAndView refer(@ModelAttribute("login_user") WeUser user, 
			@ModelAttribute("dto") @Valid MerchantReferDTO dto, BindingResult result, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()){
			//授信额度
			mv.addObject("positions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_CONTACT_POSITION));
			mv.addObject("dto", dto);
			mv.addObject("token", (String)session.getAttribute(Constants.SESSION_KEY_TOKEN));
			mv.setViewName("m/refer");
		}else{
			//表示用户有认证过
			Merchant merchant= (Merchant)session.getAttribute(Constants.SESSION_KEY_MERCHANT);
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
			
			mv.setViewName("/common/message-box");
			if(serviceResult != null && serviceResult.getCode().equals(Constants.RESULT_CODE_SUCCESS)){
				mv.addObject("title","创建成功");
				mv.addObject("message", "请准备以下资料，客户经理将上门为您办理。<br/>"
						+ " <div style=\"text-align: left;\">	"
						+ "	1、营业执照复印件 <br/>"
						+ "	2、法人身份证正反面复印件<br/>"
						+ "	3、法人征信报告<br/>"
						+ "	4、法人借记卡、信用卡复印件<br/>"
						+ "	5、租房合同或房产证<br/>"
						+ "	6、近6个月POS机结算账号流水<br/>"
						+ "	</div>"
						+ "	<p style=\"text-align: center;\">"
						+ "	点击确认返回申请列表"
						+ "	</p>");
				mv.addObject("url", "/m/applyStatus");
			}else if(serviceResult != null){
				mv.addObject("title","创建失败");
				mv.addObject("message", serviceResult.getMessage());
			}else{
				mv.addObject("title","创建失败");
				mv.addObject("message", "系统错误，请重试或联系管理员");
			}
		}
		return mv;
	}
	
	@RequestMapping(value = "/applyStatus", method = RequestMethod.GET)
	public ModelAndView applyStatus(HttpSession session, @ModelAttribute("login_user") WeUser user) {
		//验证认证或授信
		ModelAndView mv = this.authenticationAndCreditValidate("1", "2", null, session, user).getMv();
		if (mv == null) {
			/**表示验证成功:做自己相关业务*/
			mv = new ModelAndView();
			PageableResult result = leadsService.listAll(user.getId());
			mv.setViewName("m/leads-list");
			mv.addObject("list", result.getPayload());
			mv.addObject("instantCreditlist", merchantService.queryInstantCreditByMerchantAppid(user, "1"));
			return mv;
		} else {
			/**表示验证不成功:直接返回错误提示页面*/
			return mv;
		}

	}
	
	@RequestMapping(value = "/applyDetail", method = RequestMethod.GET)
	public ModelAndView applyDetail(@RequestParam int id, HttpSession session) {
		logger.info("entering leads details...");
		ModelAndView mv = new ModelAndView();
		WeUser user = (WeUser)session.getAttribute("login_user");
		Leads leads = leadsService.getLeads(user.getId(), id, true);
		mv.setViewName("m/leads-detail");
		mv.addObject("leads", leads);
		return mv;
	}

	/**
	 * 速融状态详情查看
	 *
	 * @param cashadvId
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/instantCreditDetail", method = RequestMethod.GET)
	public ModelAndView instantCreditDetail(String cashadvId, @ModelAttribute("login_user") WeUser user) {
		ModelAndView mv = new ModelAndView("/m/instant-credit-detail");
		InstantCreditModel instantCreditModel = merchantService.getInstantCreditModelByCashadvId(user, cashadvId);
		String processorLabel = "";
		if (utilityService.getParamByValueAndGroup(Constants.PARAM_GROUP_PROCESSOR_ID, instantCreditModel.getProcessor()) != null)
			processorLabel = utilityService.getParamByValueAndGroup(Constants.PARAM_GROUP_PROCESSOR_ID, instantCreditModel.getProcessor()).getName();
		mv.addObject("processorLabel", processorLabel);
		mv.addObject("instantCreditModel", instantCreditModel);
		return mv;
	}

	/**
	 * 速融申请记录关闭
	 *
	 * @param cashadvId
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/closeFinancing", method = RequestMethod.GET)
	public ModelAndView closeFinancing(String cashadvId, @ModelAttribute("login_user") WeUser user) {
		ModelAndView mv = new ModelAndView();
		Result<?> r = merchantService.closeFinancing(user, cashadvId);
		if (r.getCode().equals(Constants.RESULT_CODE_SUCCESS)) {
			//状态已经关闭
			mv.setViewName("/common/message-box");
			mv.addObject("message", r.getMessage());
			mv.addObject("url", "/m/applyStatus");
		} else {
			//状态关闭失败
			mv.setViewName("/common/message-box-c");
			mv.addObject("message", r.getMessage());
		}
		return mv;
	}


	@RequestMapping(value = "/editApply", method = RequestMethod.GET)
	public ModelAndView editApply(@RequestParam int id, HttpSession session) {
		logger.info("entering edit leads ...");
		ModelAndView mv = new ModelAndView();
		WeUser user = (WeUser)session.getAttribute("login_user");
		Leads leads = leadsService.getLeads(user.getId(), id, true);
		mv.addObject("positions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_CONTACT_POSITION));
		mv.setViewName("m/leads-update");
		mv.addObject("leads", leads);
		return mv;
	}
	
	@RequestMapping(value = "/updateApply", method=RequestMethod.POST)
	public ModelAndView updateApply(UpdateApply updateDTO){
		logger.info("entering update apply...");
		leadsService.update(updateDTO);
		logger.info("update apply successful...");
		ModelAndView mv = new ModelAndView();
		mv.addObject("title","修改成功");
		mv.addObject("message", "点击确认返回申请列表");
		mv.addObject("url", "/m/applyStatus");
		mv.setViewName("/common/message-box");
		return mv;
	}
	
	@RequestMapping(value = "/account", method=RequestMethod.GET)
	public ModelAndView account(HttpSession session, @ModelAttribute("login_user") WeUser user){
		ModelAndView mv = new ModelAndView();
		//Merchant merchant = session.getAttribute(Constants.SESSION_KEY_MERCHANT) == null ? null : (Merchant)session.getAttribute(Constants.SESSION_KEY_MERCHANT);//不能获取到及时修改的merchant
		Merchant merchant = merchantRepo.findByUser(user);
		mv.addObject("userInfo", (UserInfo) userInfoRepo.findByUserId(user.getId()));
		String authStatus = "";
		if (merchant != null) {
			mv.addObject("merchant", merchant);
			MerchantCredit credit = merchantCreditRepo.findByMid(merchant.getMid(), null);
			String creditLabel = "暂无额度";
			if (credit != null) {
				creditLabel = credit.getCreditLineLabel();
			}
			authStatus = "已认证";
			if (user.getType() == Constants.USER_TYPE_MERCHANT && user.getReferrerId() == 0) {
				//表示为自主注册的用户,继续判断其有无认证
				if (session.getAttribute(Constants.SESSION_KEY_MERCHANT) == null) {
					authStatus = "未认证";
				}
			}
			mv.addObject("authStatus", authStatus);
			mv.addObject("credit", creditLabel);
		} else {
			authStatus = "未认证";
			mv.addObject("authStatus", authStatus);
		}
		mv.setViewName("/m/account");
		return mv;
	}
	
	@RequestMapping(value = "/help", method=RequestMethod.GET)
	public String help(){
		return "m/question";
	}
	
	@RequestMapping(value = "/register/show", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		UserRegisterDTO dto = new UserRegisterDTO();
		dto.setOpenId((String)session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID));
		mv.setViewName("/m/register");
		mv.addObject("dto", dto);
		mv.addObject("provinces", utilRepo.queryProvincesOrRegions(1, null));//查询所有省
		//mv.addObject("regions", utilRepo.queryProvincesOrRegions(2, 13));//查询市
		return mv;
	}
	
	@RequestMapping(value = "/register/submit", method = RequestMethod.POST)
	public ModelAndView register(@Valid @ModelAttribute("dto") UserRegisterDTO dto, BindingResult result,HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()){
			mv.addObject("dto", dto);
			mv.addObject("provinces", utilRepo.queryProvincesOrRegions(1, null));//查询所有省
			if(dto.getProvinceId() != null) mv.addObject("regions", utilRepo.queryProvincesOrRegions(2, dto.getProvinceId()));//查询指定市
			mv.setViewName("/m/register");
		}else{

			//判断推荐人手机号码是否不为空
			if(StringUtils.isNotBlank(dto.getReferrerMobile())){
				//检查推荐人手机号码是否存在
				if (userRepo.findByUsername(dto.getReferrerMobile()) == null
						&& merchantRepository.findByContactMobile(dto.getReferrerMobile()) == null) {
					//表示推荐人手机号码不正确，给提醒
					mv.setViewName("common/message-box-c");
					mv.addObject("message", "系统无法找到您填写的推荐人手机号码，请重新填写!");
					return mv;
				}else{
					//表示输入的推荐人手机号码系统能找到
					WeUser user = userRepo.findByUsername(dto.getReferrerMobile());
					//设置推荐人id
					dto.setReferrerId(user.getId());
				}
			} else {
				//分销商扫描
				String openId =(String)session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID);
				List<ActionLog>	actionLogs = actionLogRepository.findByActionAndOpenId(Constants.ACTION_SUBSCRIBE_QRCODE_DISTRIBUTOR, openId);
				if(actionLogs != null && actionLogs.size() > 0) {
					dto.setReferrerId(Integer.parseInt(actionLogs.get(0).getMemo()));
				}
			}

			mv.setViewName("message");
			mv.setViewName("common/message-box-c");
			mv.addObject("url", "/m/register/show");
			try {
				//注册操作
				Result<?> r = userService.createUser(dto,session);
				//注册结果
				if(r.getCode().equals(Constants.RESULT_CODE_SUCCESS)){
					mv.setViewName("common/message-box");
					//注册成功以后点击确认直接登录跳转到首页
					String homeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2F220.248.19.21%2F" + this.appName + "%2Fhome%2Fenter%3FredirectUrl%3DRegisterAndLogin%2F"+ dto.getMobile() +"&response_type=code&scope=snsapi_base&appid=" + this.weAppId;
					mv.addObject("url", homeUrl);//跳转到登录页面
				}
				mv.addObject("message", r.getMessage());
			} catch (Exception e) {
				//出错
				logger.error("Create Merchant Registration failed:", e);
				mv.addObject("message", "对不起，您注册申请提交失败，请联系400-608-1310获取技术支持。");
			}
		}
		return mv;
	}
	
	/**
	 * 对账单查询显示界面
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/bankStatementSearch", method = RequestMethod.GET)
	public ModelAndView bankStatementSearch(HttpSession session, @ModelAttribute("login_user") WeUser user) {
		//验证认证或授信
		ModelAndView mv = this.authenticationAndCreditValidate("3", "2", null, session, user).getMv();
		if (mv == null) {
			/**表示验证成功:做自己相关业务*/
			mv = new ModelAndView();
			//获取商户对象
			Merchant merchant = (Merchant) session.getAttribute(Constants.SESSION_KEY_MERCHANT);
			//获取商户mid
			String mid = merchant.getMid();
			//获取保利id集合
			List<BaoliIdModel> baoliIdModels = merchantService.queryBaolisIdByMid(mid);
			//设置返回模型对象
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("baoliIdModels", baoliIdModels);
			modelAndView.setViewName("m/bank-statement-search");
			//如果接口没有返回保理编号则给予提示
			if (baoliIdModels == null || baoliIdModels.size() < 1) {
				modelAndView.setViewName("/common/message-box");
				modelAndView.addObject("title", "");
				modelAndView.addObject("url", "/m/myAccount");
				modelAndView.addObject("message", "您没有融资，系统无法查出相关信息！");
			}
			return modelAndView;
		} else {
			/**表示验证不成功:直接返回错误提示页面*/
			return mv;
		}
	}
	
	/**
	 * 对账单明细查询
	 * @param pageNumber
	 * @param pageSize
	 * @param beginDate
	 * @param endDate
	 * @param baoliId
	 * @return
	 */
	@RequestMapping(value = "/bankStatementList", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView bankStatementList(@RequestParam(defaultValue="1") String pageNumber, @RequestParam(defaultValue="20") String pageSize,
			@RequestParam String beginDate,@RequestParam String endDate,@RequestParam String baoliId) {
		//设置返回模型对象
		ExchangerResultModel exchangerResultModel = merchantService.bankStatementList(beginDate, endDate,baoliId,Integer.valueOf(pageNumber), Integer.valueOf(pageSize));
		ModelAndView modelAndView = new ModelAndView();	
		modelAndView.addObject("exchangerResultModel",exchangerResultModel);
		modelAndView.addObject("pageNumber",pageNumber);
		modelAndView.addObject("pageCount",(int)Math.ceil((double)exchangerResultModel.getTotal()/Integer.valueOf(pageSize)));
		modelAndView.addObject("beginDate",beginDate);
		modelAndView.addObject("endDate",endDate);
		modelAndView.addObject("baoliId",baoliId);
		modelAndView.setViewName("m/bank-statement-list");
		//如果接口没有查到对账单明细内容则给予提示
		if(exchangerResultModel.getTotal()<1){
			modelAndView.setViewName("/common/message-box");
			modelAndView.addObject("title","");
			modelAndView.addObject("url", "/m/bankStatementSearch");
			modelAndView.addObject("message", "该时间范围内没有相关对账信息，请重新选择开始和结束时间！");
		}
		return modelAndView;
	}

	/**
	 * 会员认证显示页面
	 *
	 * @param isView
	 * @param session
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/accountAuthenticationShow", method = {RequestMethod.GET})
	public ModelAndView accountAuthenticationShow(String isView, HttpSession session, @ModelAttribute("login_user") WeUser user) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userInfo", (UserInfo) session.getAttribute(Constants.SESSION_KEY_USER_INFO));
		mv.addObject("positions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_CONTACT_POSITION));
		mv.addObject("processorIds", utilityService.getParamsByGroup(Constants.PARAM_GROUP_PROCESSOR_ID));
		mv.addObject("provinces", utilRepo.queryProvincesOrRegions(1, null));//查询所有省
		//mv.addObject("regions", utilRepo.queryProvincesOrRegions(2, 13));//查询市
		//获取商户信息
		Merchant merchant = merchantRepository.findByUser(user);
		MerchantRegisterDTO merchantRegisterDTO = new MerchantRegisterDTO();
		if (merchant != null) {
			merchantRegisterDTO.setContactPosition(merchant.getContactPosition());
			merchantRegisterDTO.setProcessorId(user.getProcessorId());
		}

		mv.addObject("dto", merchantRegisterDTO);
		mv.addObject("isView", isView);
		mv.addObject("merchant", merchant);
		mv.setViewName("/m/account-authentication");

		return mv;
	}

	/**
	 * 会员认证操作
	 *
	 * @param user
	 * @param dto
	 * @param result
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/accountAuthentication", method = {RequestMethod.POST})
	public ModelAndView accountAuthentication(@ModelAttribute("login_user") WeUser user, @Valid @ModelAttribute("dto") MerchantRegisterDTO dto,
											  BindingResult result, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();

		//获取商户信息
		Merchant merchant = merchantRepository.findByUser(user);

		//判断是否第一进行认证信息提交
		if (merchant == null) {
			//表示第一次授信
			if (result.hasErrors()) {
				//表示提交form验证失败
				mv.addObject("dto", dto);
				mv.addObject("positions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_CONTACT_POSITION));
				mv.addObject("processorIds", utilityService.getParamsByGroup(Constants.PARAM_GROUP_PROCESSOR_ID));
				mv.addObject("provinces", utilRepo.queryProvincesOrRegions(1, null));//查询所有省
				if(dto.getProvinceId() != null) mv.addObject("regions", utilRepo.queryProvincesOrRegions(2, dto.getProvinceId()));//查询指定市
				mv.setViewName("/m/register");
				mv.setViewName("/m/account-authentication");
				return mv;
			} else {
				//修改UserInfo的省、市、邮箱,从注册页面提取到认证界面
				UserInfo userInfo = userInfoRepo.findByUserId(user.getId());
				userInfo.setProvinceId(dto.getProvinceId());
				userInfo.setRegionId(dto.getRegionId());
				if(dto.getProvinceId() != null) userInfo.setProvinceName(utilRepository.getProvincesOrRegionsById(dto.getProvinceId()).getName());
				if(dto.getRegionId() != null) userInfo.setRegionName(utilRepository.getProvincesOrRegionsById(dto.getRegionId()).getName());
				userInfo.setEmail(dto.getEmail());
				userInfoRepo.save(userInfo);
				logger.info("用户: "+ user.getUsername() +" 的userInf表已经成功set provinceId、regionId、email字段!");

				//认证
				Result<?> rst = merchantService.createMerchant(dto, null, user, session);
				//认证结果
				if (rst.getCode().equals(Constants.RESULT_CODE_SUCCESS)) {
					//验证认证或授信
					mv = this.authenticationAndCreditValidate("2", "1", dto, session, user).getMv();
					if (mv == null) {
						/**表示验证成功:做自己相关业务*/
						mv = new ModelAndView();
						mv.setViewName("/m/credit-show");
						//获取授信额度
						WebsiteCreditModel websiteCreditModel = (WebsiteCreditModel) this.authenticationAndCreditValidate("2", "1", dto, session, user).getResult().getReturnObj();
						//将授信信息加入作用域
						mv.addObject("websiteCreditModel", websiteCreditModel);
						//如果是需人工授信则给出提示
						if (this.authenticationAndCreditValidate("2", "1", dto, session, user).getResult().getReturnStatus().equals("4"))
							mv.addObject("titleMsg", "系统当前无法自动给出授信额度，我们将在线下为您手动授信！您可以继续选择以下产品进行申请操作！");
						return mv;
					} else {
						/**表示验证不成功:直接返回错误提示页面*/
						return mv;
					}
				} else {
					//认证失败弹出提示信息
					mv.setViewName("common/message-box-c");
					mv.addObject("message", rst.getMessage());
					return mv;
				}
			}
		} else {

			/**
			 * @解释：判断是否数据库中mid为null，dto中的mid不为null 是否成立
			 * @备注：只会执行一次,因为页面的mid字段不为空
			 */
			if (org.apache.commons.lang.StringUtils.isBlank(merchant.getMid()) && org.apache.commons.lang.StringUtils.isNotBlank(dto.getMid())) {
				//表示是网站同步用户后，第一次进入微信端认证或者授信界面作修改
				merchant = merchantService.mergeMerchant(dto, user, session);
			}

			//表示已经认证过，重新授信
			String mid = dto.getMid();
			PropertyUtils.copyProperties(dto, merchant);//复制属性
			dto.setMid(mid);//设置mid

			//验证认证或授信
			mv = this.authenticationAndCreditValidate("2", "1", dto, session, user).getMv();
			if (mv == null) {
				/**表示验证成功:做自己相关业务*/
				mv = new ModelAndView();
				mv.setViewName("/m/credit-show");
				//获取授信额度
				WebsiteCreditModel websiteCreditModel = (WebsiteCreditModel) this.authenticationAndCreditValidate("2", "1", dto, session, user).getResult().getReturnObj();
				//将授信信息加入作用域
				mv.addObject("websiteCreditModel", websiteCreditModel);
				//如果是需人工授信则给出提示
				if (this.authenticationAndCreditValidate("2", "1", dto, session, user).getResult().getReturnStatus().equals("4"))
					mv.addObject("titleMsg", "系统当前无法自动给出授信额度，我们将在线下为您手动授信！您可以继续选择以下产品进行申请操作！");
				return mv;
			} else {
				/**表示验证不成功:直接返回错误提示页面*/
				return mv;
			}
		}

	}
	
	/**
	 * 会员认证操作
	 * @param session
	 * @return 1表示生成验证 0表示失败
	 */
	@RequestMapping(value = "/getCheckCode", method = {RequestMethod.GET})
	public @ResponseBody String getCheckCode(String mobile,HttpSession session){
		try {
			//生成验证码
			String checCode = Utility.createRandom(true, 4);
			//发送短信
			int flag = smsService.sendSms(mobile, "您好，验证码为:"+checCode+"，2分钟内有效，请勿泄露。");
			if(flag > 0){
				//短信发送成功，SESSION储存
				session.setAttribute("checkCode",checCode);
				session.setAttribute("checkCodeMobile",mobile);
				session.setAttribute("checkCodeSetDate",new Date());
				return "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0";
	}

	/**
	 * 获取授信额度
	 *
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/creditShow", method = {RequestMethod.GET})
	public ModelAndView creditShow(@ModelAttribute("login_user") WeUser user, HttpSession session) {
		//验证认证或授信
		ModelAndView mv = this.authenticationAndCreditValidate("3", "2", null, session, user).getMv();
		if (mv == null) {
			/**表示验证成功:做自己相关业务*/
			mv = new ModelAndView();
			//表示成功，获取授信
			WebsiteCreditModel websiteCreditModel = (WebsiteCreditModel) this.authenticationAndCreditValidate("3", "2", null, session, user).getResult().getReturnObj();
			//将授信信息加入作用域
			mv.addObject("websiteCreditModel", websiteCreditModel);
			//如果是需人工授信则给出提示
			if (this.authenticationAndCreditValidate("3", "2", null, session, user).getResult().getReturnStatus().equals("4"))
				mv.addObject("titleMsg", "系统当前无法自动给出授信额度，我们将在线下为您手动授信！您可以继续选择以下产品进行申请操作！");
			mv.setViewName("/m/credit-show");
			return mv;
		} else {
			/**表示验证不成功:直接返回错误提示页面*/
			return mv;
		}
	}

	/**
	 * 获取授信状态
	 *
	 * @param user
	 * @param session
	 * @return
	 * @throws java.text.ParseException
	 */
	@RequestMapping(value = "/getCreditStatus", method = {RequestMethod.GET})
	@ResponseBody
	public String getCreditStatus(@ModelAttribute("login_user") WeUser user, HttpSession session) throws ParseException {
		//获取授信状态
		Result<?> r = merchantService.getCreditInfo(null, user, "2");
		//根据授信状态返回标志
		if (r.getReturnStatus().equals("3") || r.getReturnStatus().equals("4") || r.getReturnStatus().equals("5")) {
			session.removeAttribute("startCreditDate");//表示服务器已经获取到授信，清除计时器
			return "1";
		} else {
			//判断是否超过5分钟，如果超过则清除
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startCreditDate = sdf.parse((String) session.getAttribute("startCreditDate"));
			if (Utility.getDateDiff(new Date(), startCreditDate, "m") >= Constants.INSTANT_CREDIT_TIMEOUT) {
				session.removeAttribute("startCreditDate");//表示服务器获取到授信倒计时已经超时或者获取错误，清除计时器
				return "2";
			} else {
				//表示倒计时还没有超时
				return "0";
			}
		}
	}

	/**
	 * 商户首页，点击我的账户
	 *
	 * @return
	 */
	@RequestMapping(value = "/myAccount", method = RequestMethod.GET)
	public String myAccount() {
		return "m/my-account";
	}

	/**
	 * 5分钟获取超时
	 *
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/getInstantCreditTimeout", method = {RequestMethod.GET})
	public ModelAndView getInstantCreditTimeout(HttpSession session) {
		session.removeAttribute("startCreditDate");//表示服务器获取到授信超时，清除计时器
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "");
		mv.addObject("url", "/m/showApply");
		mv.setViewName("/common/message-box-b");
		mv.addObject("message", "系统无法获取您的授信信息，点击确认进入提交线索!");
		return mv;
	}

	/**
	 * 通用的验证会员认证和是否授信
	 *
	 * @param type      1表示只对会员是否认证进行校验，2表示只对是否授信进行校验，3表示会员认证和授信同时验证
	 * @param entryType 入口类型：1表示是在后台认证的时候调用  2表示直接在用户管理界面里点击进入查询授信额度
	 * @param dto       后台入口提交认证信息时，DTO有值，如果不是后台则置null
	 * @param session
	 * @param user
	 * @return
	 */
	public AuthenticationAndCreditValidateModel authenticationAndCreditValidate(String type, String entryType, MerchantRegisterDTO dto, HttpSession session, WeUser user) {

		//验证结果
		AuthenticationAndCreditValidateModel checkReuslt = new AuthenticationAndCreditValidateModel();

		ModelAndView mv = new ModelAndView();

		if (type.equals("1") || type.equals("3")) {
			/**Step1.判断自主注册用户有没有认证*/
			if (user.getType() == Constants.USER_TYPE_MERCHANT) {
				//表示为自主注册的用户,继续判断其有无认证
				if (session.getAttribute(Constants.SESSION_KEY_MERCHANT) == null) {
					//从session中取当前登录人关联的商户，如果为null表示当前用户还未认证，给出提示
					mv.addObject("title", "");
					mv.addObject("url", "/m/accountAuthenticationShow");
					mv.setViewName("/common/message-box-b");
					mv.addObject("message", "您当前还未进行会员认证，暂无该功能权限。是否进行会员认证？");
					/**验证失败*/
					checkReuslt.setValidateResult("0");
					checkReuslt.setMv(mv);
					checkReuslt.setResult(null);
					return checkReuslt;
				}
			}
		}

		if (type.equals("2") || type.equals("3")) {
			/**Step2.判断用户是否有授信*/
			Result<?> r = merchantService.getCreditInfo(dto, user, entryType);

			//判断当前是否正在授信还没结束,无论后台返回0或者1错误代码都继续重试等待
			if (session.getAttribute("startCreditDate") != null && (r.getReturnStatus().equals("0") || r.getReturnStatus().equals("1"))) {
				/**
				 * @状态解释：已认证，正在授信
				 * @所需操作：表示接口已经拿到appId了，但是还未返回授信结果，此时系统转圈圈等待
				 */
				String startCreditDate = null;
				if (session.getAttribute("startCreditDate") == null) {
					startCreditDate = (new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
					session.setAttribute("startCreditDate", startCreditDate);//将开始时间存入session
				} else {
					startCreditDate = (String) session.getAttribute("startCreditDate");//获取计时开始时间
				}
				mv.addObject("startCreditDate", startCreditDate);//开始授信时间,10分钟倒计时使用
				mv.addObject("currentDate", (new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));//服务器当前时间，传入前端
				mv.addObject("instantCreditTimeout", Constants.INSTANT_CREDIT_TIMEOUT);//速融超时时间(分钟单位)
				mv.setViewName("/m/credit-wait");//返回转圈圈页面
				/**验证失败*/
				checkReuslt.setValidateResult("0");
				checkReuslt.setMv(mv);
				checkReuslt.setResult(null);
				return checkReuslt;
			}

			//判断是否有授信
			if (r.getReturnStatus().equals("1")) {
				/**
				 * @状态解释：已认证，还未授信
				 * @所需操作：需要填写融资申请信息（即填写认证信息下面的两个字段），系统跳转到认证界面进行填写“预计贷款金额、预计还款时间”两字段并提交
				 */
				mv.addObject("title", "");
				mv.addObject("url", "/m/accountAuthenticationShow");
				mv.setViewName("/common/message-box-b");
				mv.addObject("message", "您当前还未进行授信，暂无该功能权限。是否进行授信操作？ ");
				/**验证失败*/
				checkReuslt.setValidateResult("0");
				checkReuslt.setMv(mv);
				checkReuslt.setResult(null);
				return checkReuslt;
			} else if (r.getReturnStatus().equals("2")) {
				/**
				 * @状态解释：已认证，正在授信
				 * @所需操作：表示接口已经拿到appId了，但是还未返回授信结果，此时系统转圈圈等待
				 */
				String startCreditDate = null;
				if (session.getAttribute("startCreditDate") == null) {
					startCreditDate = (new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
					session.setAttribute("startCreditDate", startCreditDate);//将开始时间存入session
				} else {
					startCreditDate = (String) session.getAttribute("startCreditDate");//获取计时开始时间
				}
				mv.addObject("startCreditDate", startCreditDate);//开始授信时间,10分钟倒计时使用
				mv.addObject("currentDate", (new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));//服务器当前时间，传入前端
				mv.addObject("instantCreditTimeout", Constants.INSTANT_CREDIT_TIMEOUT);//速融超时时间(分钟单位)
				mv.setViewName("/m/credit-wait");//返回转圈圈页面
				/**验证失败*/
				checkReuslt.setValidateResult("0");
				checkReuslt.setMv(mv);
				checkReuslt.setResult(null);
				return checkReuslt;
			} else if (r.getReturnStatus().equals("3") || r.getReturnStatus().equals("4") || r.getReturnStatus().equals("5")) {
				/**
				 * @状态解释：已认证，已授信
				 * @所需操作：表示接口已经拿到了授信结果，直接返回
				 */
				/**验证成功*/
				checkReuslt.setValidateResult("1");
				checkReuslt.setMv(null);
				checkReuslt.setResult(r);
				return checkReuslt;
			} else {
				/**
				 * @状态解释 ：已认证，网站出错或者授信出错
				 * @所需操作：表示接口端出错调用失败(接口默认返回0网站出错 或者5授信失败)，微信端给出错误提示信息
				 */
				mv.setViewName("common/message-box-c");
				mv.addObject("message", "亲，您好，系统当前无法给出您授信额度，请线下联系管理员，如需帮助请拔打40086081310。");
				/**验证失败*/
				checkReuslt.setValidateResult("0");
				checkReuslt.setMv(mv);
				checkReuslt.setResult(null);
				return checkReuslt;
			}
		}

		/**验证成功:(特殊返回，只正对于用户认证返回，授信不会走这一步)*/
		checkReuslt.setValidateResult("1");
		checkReuslt.setMv(null);
		checkReuslt.setResult(null);
		return checkReuslt;
	}

	/**
	 * 商户扫描商户显示二维码界面
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/showQrCode", method=RequestMethod.GET)
	public ModelAndView showQrCode(HttpSession session){
		WeUser user = (WeUser)session.getAttribute(Constants.SESSION_KEY_USER);
		Merchant merchant = merchantRepository.findByUser(user);
		String mid = merchant == null ? "" : merchant.getMid();
		//创建 referrer对象
		long linkId = utilityService.storeMerchantReferrer(user.getId(), mid);
		String parameter = Constants.QRCODE_PREFIX_LINK + String.valueOf(linkId);
		//生成二维码
		WeCreateQrCodeResponseDTO response = qrCodeService.createQrCode(parameter, false);
		//获取二维码图片地址链接
		String qrCodeUrl = qrCodeService.getQrCodeUrl(response.getTicket());
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", new RemoteAddMerchantDTO());
		mv.setViewName("m/show-qrcode-m");
		mv.addObject("url", qrCodeUrl);
		return mv;
	}

	/**
	 * 商户发送短信邀请商户关注公众号
	 * @param user
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/sendSmsToMerchant", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public  Result<?> sendSmsToMerchant(@ModelAttribute("login_user") WeUser user,RemoteAddMerchantDTO dto){
		String sendName = ""; //发送者名称
		UserInfo userInfo = userInfoRepository.findByUserId(user.getId());
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
		int flag = smsService.sendSms(dto.getContactMobile(), "亲，"+ sendName + "邀请您关注卡得万利商业保理公众服务号，微信中搜索CVBAOLI或卡得万利关注后并进行新用户注册，注册时在推荐人手机栏中请填写"+ sendName +"的手机号码:" + user.getUsername() +"谢谢！");
		if(flag < 0){
			result.setCode(Constants.RESULT_CODE_FAILED);
			result.setMessage("发送短信通知商户失败，错误码:" + flag);
		}else{
			result.setCode(Constants.RESULT_CODE_SUCCESS);
			result.setMessage("短信发送已成功");
		}

		return result;

	}

	@RequestMapping(value = "/queryCoupon", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView queryCoupon(@ModelAttribute("login_user") WeUser user){
		ModelAndView mv = new ModelAndView();
		List<CouponInfo> coupons = couponService.listCouponInfoByUserId(user.getId());
		mv.addObject("coupons", coupons);
		mv.setViewName("/m/coupon");
		return mv;
	}

}