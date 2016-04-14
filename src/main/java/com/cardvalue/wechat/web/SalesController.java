package com.cardvalue.wechat.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.cardvalue.wechat.model.*;
import com.cardvalue.wechat.repository.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cardvalue.support.ws.SortField;
import com.cardvalue.support.ws.SortType;
import com.cardvalue.wechat.annotation.Token;
import com.cardvalue.wechat.dto.AroundMerchantDTO;
import com.cardvalue.wechat.dto.ExchangeCouponResult;
import com.cardvalue.wechat.dto.KeyMerchantDTO;
import com.cardvalue.wechat.dto.LabelValueTO;
import com.cardvalue.wechat.dto.MerchantRegisterDTO;
import com.cardvalue.wechat.dto.RemoteAddMerchantDTO;
import com.cardvalue.wechat.dto.SaveSalesDTO;
import com.cardvalue.wechat.dto.WeCreateQrCodeResponseDTO;
import com.cardvalue.wechat.service.AroundMerchantService;
import com.cardvalue.wechat.service.CouponService;
import com.cardvalue.wechat.service.ExtraUserService;
import com.cardvalue.wechat.service.KeyMerchantService;
import com.cardvalue.wechat.service.LogService;
import com.cardvalue.wechat.service.MerchantService;
import com.cardvalue.wechat.service.PosApplicantService;
import com.cardvalue.wechat.service.UserPointService;
import com.cardvalue.wechat.service.UserService;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.service.WeChatService;
import com.cardvalue.wechat.service.WeQrCodeService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.PageableResult;
import com.cardvalue.wechat.util.Result;

@Controller
@RequestMapping(value = "/sales")
@SessionAttributes({"login_sales","login_user"})
public class SalesController {

	private static final Logger logger = LoggerFactory.getLogger(SalesController.class);
	
	@Resource
	private WeQrCodeService qrCodeService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private SalesRepository salesRepo;
	
	@Resource
	private UtilRepository utilRepo;
	
	@Resource
	private MerchantService merchantService;
	
	@Resource
	private MerchantRepository merchantRepo;
	
	@Resource
	private LogService logService;
	
	@Resource
	private WeChatService weChatService;
	
	@Resource
	private UtilityService utilityService;
	
	@Resource 
	private UserPointService userPointService;
	
	@Resource
	private CouponService couponService;
	
	@Resource
	private KeyMerchantService keyMerchantService;
	
	@Resource
	private ReferrerLinkRepository referrerLinkRepo;
	
	@Resource
	private ExtraUserService extraUserService;
	
	@Resource
	private AroundMerchantService aroundMerchantService;
	
	@Resource
	private PosApplicantService posApplicantService;

	@Resource
	private WeResidentRepository weResidentRepository;
	
	public SalesController() {}
	
	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public ModelAndView home(@ModelAttribute("login_user") WeUser user){
		List<String> images = utilRepo.getStartupImages(user.getId());
		ModelAndView mv = new ModelAndView();
		if(images != null && images.size()>0){
			mv.addObject("imageUrl", images.get(0));
		}
		
		//判断是否是银联商户
		mv.addObject("user", user);
		mv.addObject("updatedLeadsCount", 0);
		mv.addObject("posAppCount", posApplicantService.countByPrefecture(user.getId()));
		mv.setViewName("sales/home");
		return mv;
	}
	
	@RequestMapping(value = "/account", method=RequestMethod.GET)
	public ModelAndView account(@ModelAttribute("login_sales") Sales sales, @ModelAttribute("login_user") WeUser user){
		logger.info("entering sales account...");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sales/account/sales-account");
		mv.addObject("account", sales);
		mv.addObject("user", user);
		//判断是否为驻地专员
		mv.addObject("isResidents", "0");//表示不为驻地专员
		if(sales != null) {
			List<WeResident> weResidents = weResidentRepository.findByName(sales.getName());
			if(weResidents != null && weResidents.size() > 0) {
				mv.addObject("isResidents", "1");//表示为驻地专员
			}
		}
		return mv;
	}
	
	@RequestMapping(value = "/myMerchant", method=RequestMethod.GET)
	public String myMerchant(){
		return "sales/merchant/my-merchant";
	}
	
	@RequestMapping(value = "/showQrCode", method=RequestMethod.GET)
	public ModelAndView showQrCode(@RequestParam(required=false) String mid, HttpSession session){
		String parameter = mid;
		WeUser user = (WeUser)session.getAttribute(Constants.SESSION_KEY_USER);
		long linkId = utilityService.storeMerchantReferrer(user.getId(), mid);
		parameter = Constants.QRCODE_PREFIX_LINK + String.valueOf(linkId);
		WeCreateQrCodeResponseDTO response = qrCodeService.createQrCode(parameter, false);
		//@TODO
		String qrCodeUrl = qrCodeService.getQrCodeUrl(response.getTicket());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sales/merchant/show-qrcode");
		mv.addObject("url", qrCodeUrl);
		return mv;
	}
	
	@RequestMapping(value = "/new", method=RequestMethod.GET)
	public ModelAndView newSales(@ModelAttribute("login_sales") Sales sales, HttpSession session){
		logger.info("entering new sales...");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sales/account/new-sales");
		mv.addObject("branches", utilRepo.getAllBranches());
		mv.addObject("account", sales);
		SaveSalesDTO dto = new SaveSalesDTO();
		dto.setBranchCode(sales.getBranchCode());
		String salesBranchCode = sales.getBranchCode();
		if(StringUtils.isNotEmpty(salesBranchCode) && !StringUtils.equalsIgnoreCase(salesBranchCode, "all")){
			mv.addObject("regions", utilRepo.getRegionsByBranch(salesBranchCode));
		}
		dto.setRegionCode(sales.getRegionCode());
		mv.addObject("dto", dto);
		
		//获取当前登录用户
		WeUser user = (WeUser)session.getAttribute(Constants.SESSION_KEY_USER);
		//通过传入的人的processorId分析其角色，查询权限范围内的processorIds
		List<Parameter> processorIds = keyMerchantService.queryProcessorIds(user.getProcessorId());
		mv.addObject("processorIds", processorIds);
				
		return mv;
	}
	
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public ModelAndView saveSales(@ModelAttribute("dto") @Valid SaveSalesDTO dto, BindingResult result, HttpSession session){
		ModelAndView mv = new ModelAndView();
		Sales sales = (Sales)session.getAttribute("login_sales");
		if(result.hasErrors()){
			mv.addObject("dto", dto);
			mv.addObject("branches", utilRepo.getAllBranches());
			if(StringUtils.isNotEmpty(dto.getBranchCode()) && !StringUtils.equalsIgnoreCase(dto.getBranchCode(), "all")){
				mv.addObject("regions", utilRepo.getRegionsByBranch(dto.getBranchCode()));
			}
			
			//获取当前登录用户
			WeUser user = (WeUser)session.getAttribute(Constants.SESSION_KEY_USER);
			//通过传入的人的processorId分析其角色，查询权限范围内的processorIds
			List<Parameter> processorIds = keyMerchantService.queryProcessorIds(user.getProcessorId());
			mv.addObject("processorIds", processorIds);
			
			mv.setViewName("sales/account/new-sales");
		}else{
			//调用CRM接口
			String username = extraUserService.addUser(sales.getUserId(), dto);
			//String username = "111";
			//设置消息
			mv.setViewName("/common/message-box");
			if(StringUtils.isNotBlank(username)){
				dto.setUsername(username);
				//调用系统service存储商户
				Sales newSales = salesRepo.saveSales(dto, sales);
				if(newSales != null){
					logService.insertActionLog(Constants.ACTION_ADD_SALES, sales.getUserId(), null, "Sales[id:" + sales.getId() + "] created new sales[id:" + newSales.getId() + "]");
					mv.addObject("title","添加成功");
					mv.addObject("message", "您可以拨打021-60200916或021-60200917询问登录帐号和密码，请点击确认返回上一页");
					mv.addObject("url", "/sales/new");
				}else{
					mv.addObject("title","添加失败");
					mv.addObject("message", "该用户已存在于微信系统");
				}
			}else{
				mv.addObject("title","添加失败");
				mv.addObject("message", "该用户已存在于CRM");
			}
		}
		return mv;
	}
	
	@RequestMapping(value = "/getRegionByBranch", method=RequestMethod.GET)
	public @ResponseBody List<LabelValueTO> getRegionCodeByBranch(@RequestParam String branchCode){
		List<LabelValueTO> regions = new ArrayList<LabelValueTO>();
		regions = utilRepo.getRegionsByBranch(branchCode);
		return regions;
	}
	
	@RequestMapping(value = "/getRegionByProvince", method=RequestMethod.GET)
	public @ResponseBody List<CvRegionConf> getRegionByProvince(@RequestParam String provinceId){
		List<CvRegionConf> regions = utilRepo.queryProvincesOrRegions(2, Integer.parseInt(provinceId));
		return regions;
	}
	
	@RequestMapping(value = "/merchant/register/show", method = RequestMethod.GET)
	public ModelAndView showRegister(@RequestParam(required=false) String code,  @RequestParam(required=false) String linkId, 
			@ModelAttribute("login_sales") Sales sales) {
		String openId = weChatService.getOpenIdByAccessToken(code);
		long lid = Long.valueOf(linkId);
		boolean valid = utilityService.validReferrerLink(lid);
		ModelAndView mv = new ModelAndView();
		if(valid){
			mv.setViewName("/sales/merchant/register-merchant");
			ReferrerLink link = referrerLinkRepo.findById(lid);
			String mid = link.getMid();
			MerchantRegisterDTO dto = new MerchantRegisterDTO();
			if(StringUtils.isNotBlank(mid)){
				List<KeyMerchantDTO> keyMerchants = keyMerchantService.findByMid(mid);
				if(keyMerchants != null && keyMerchants.size() > 0){
					KeyMerchantDTO keyMerchant = keyMerchants.get(0);
					dto.setMid(keyMerchant.getMid());
					dto.setMerchantName(keyMerchant.getMerchantName());
				}
			}
			WeUser u = userService.findByOpenId(openId);
			dto.setReferrerId(u.getId());
			dto.setOpenId(link.getMerchantOpenId());
			dto.setLinkId(lid);
			mv.addObject("dto", dto);
			List<CvRegionConf> provinces =  utilRepo.queryProvincesOrRegions(1, null);
			mv.addObject("provinces", provinces);
			mv.addObject("regions",utilRepo.queryProvincesOrRegions(2, provinces.get(0).getId()));
			mv.addObject("uuid",UUID.randomUUID());
			mv.addObject("positions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_CONTACT_POSITION));
		}else{
			mv.setViewName("message");
			mv.addObject("message", "对不起，该链接已经失效。");
		}
		return mv;
	}
	
	@RequestMapping(value = "/merchant/register/submit", method = RequestMethod.POST)
	public ModelAndView register(@Valid @ModelAttribute("dto") MerchantRegisterDTO dto, BindingResult result,
			 HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Sales sales = (Sales)session.getAttribute(Constants.SESSION_KEY_SALES);
		if(result.hasErrors()){
			mv.addObject("dto", dto);
			mv.addObject("provinces", utilRepo.queryProvincesOrRegions(1, null));
			mv.addObject("regions",utilRepo.queryProvincesOrRegions(2, dto.getProvinceId()));
			mv.addObject("positions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_CONTACT_POSITION));
			mv.addObject("uuid",UUID.randomUUID());
			mv.setViewName("/sales/merchant/register-merchant");
		}else{
			mv.setViewName("message");
			try {
				Result<?> r = merchantService.create(dto, sales);
				mv.addObject("message", r.getMessage());
			} catch (Exception e) {
				//出错
				logger.error("Create Merchant Registration failed:", e);
				mv.addObject("message", "对不起，您注册申请提交失败，请联系400-608-1310获取技术支持。");
			}
		}
		return mv;
	}
	
	@RequestMapping(value = "/pointAndLevel", method = RequestMethod.GET)
	@Token(save=true)
	public ModelAndView pointAndLevel(@ModelAttribute("login_user") WeUser user){
		int userId = user.getId();
		UserPointSummary summary = userPointService.getSummary(userId);
		Parameter levelParam = utilityService.getParamByValueAndGroup(Constants.PARAM_GROUP_USER_POINT_LEVEL, String.valueOf(summary.getLevel()));
		summary.setLevelLabel(levelParam.getName());
		
		List<Coupon> rebateCoupons = couponService.listAllCouponByType(Coupon.COUPON_TYPE_REBATE, userId);
		List<Coupon> mobileCoupons = couponService.listAllCouponByType(Coupon.COUPON_TYPE_MOBILE_FEE, userId);
		int availableCouponCount = couponService.getUserAvailableCouponCount(userId);
		String levelMesssage = userPointService.getLevelMessage(userId);
		
		ModelAndView mv = new ModelAndView("sales/account/point-level");
		mv.addObject("weId", user.getWeId());
		mv.addObject("summary", summary);
		mv.addObject("rebateCoupons", rebateCoupons);
		mv.addObject("mobileCoupons", mobileCoupons);
		mv.addObject("availableCouponCount", availableCouponCount);
		mv.addObject("levelMessage", levelMesssage);
		return mv;
	}
	
	@RequestMapping(value = "/purseRecord", method = RequestMethod.GET)
	public ModelAndView purseRecord(@ModelAttribute("login_user") WeUser user){
		ModelAndView mv = new ModelAndView("sales/account/purse-record");
		mv.addObject("records", userPointService.listPurseRecord(user.getId()));
		return mv;
	}
	
	@RequestMapping(value = "/exchangeCoupon", method = RequestMethod.GET)
	@Token(save=true, remove=true)
	@ResponseBody
	public ExchangeCouponResult exchangeCoupon(@ModelAttribute("login_user") WeUser user, @RequestParam int couponId,
			@RequestParam Map<String, String> extraParams, HttpSession session){
		int userId = user.getId();
		ExchangeCouponResult result = couponService.exchangeCoupon(userId, couponId, extraParams);
		result.setToken((String)session.getAttribute(Constants.SESSION_KEY_TOKEN));
		return result;
	}
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	@Token(save=true, remove=true)
	@ResponseBody
	public Result<String> withdraw(@ModelAttribute("login_user") WeUser user, String weId, HttpSession session){
		int userId = user.getId();
		int code = userPointService.withdraw(userId,  weId);
		user.setWeId(weId);
		Result<String> result = new Result<String>();
		result.setPayload((String)session.getAttribute(Constants.SESSION_KEY_TOKEN));
		result.setCode(String.valueOf(code));
		return result;
	}
	
	@RequestMapping(value = "/showMyCoupons", method = RequestMethod.GET)
	public ModelAndView showMyCoupons(@ModelAttribute("login_user") WeUser user){
		int userId = user.getId();
		List<UserCoupon> availableCoupons = couponService.listUserCoupon(userId, false);
		List<UserCoupon> usedCoupons = couponService.listUserCoupon(userId, true);
		ModelAndView mv = new ModelAndView("sales/account/my-coupon");
		mv.addObject("availableCoupons", availableCoupons);
		mv.addObject("usedCoupons", usedCoupons);
		return mv;
	}
	
	@RequestMapping(value = "/merchantList", method = RequestMethod.GET)
	public ModelAndView merchantList(@ModelAttribute("login_user") WeUser user){
		int referrerId = user.getId();
		List<Merchant> merchants = merchantRepo.findByReferrerId(referrerId);
		ModelAndView mv = new ModelAndView("sales/merchant/merchant-list");
		mv.addObject("list", merchants);
		mv.addObject("totalActiveMerchantNumber", merchantRepo.getMaxAdjustActiveSequence());
		mv.addObject("userActiveMerchantNumber", merchantRepo.getUserActiveMerchantCount(user.getId()));
		return mv;
	}
	
	@RequestMapping(value = "/showMerchant", method = RequestMethod.GET)
	public ModelAndView showMerchant(@RequestParam int id){
		Merchant merchant = merchantRepo.findOne(id);
		ModelAndView mv = new ModelAndView("sales/account/merchant-detail");
		mv.addObject("m", merchant);
		Parameter positionParam = utilityService.getParamByValueAndGroup(Constants.PARAM_GROUP_CONTACT_POSITION, String.valueOf(merchant.getContactPosition()));
		merchant.setContactPositionLabel(positionParam.getName());
		return mv;
	}
	
	@RequestMapping(value = "/keyMerchantList", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView keyMerchantList(@RequestParam(defaultValue="1") String pageNumber, @RequestParam(defaultValue="20") String pageSize, 
			@ModelAttribute("name") String name,@ModelAttribute("processorId") String processorId, HttpSession session){
		WeUser user = (WeUser)session.getAttribute(Constants.SESSION_KEY_USER);
		ModelAndView mv = new ModelAndView("sales/merchant/key-merchant");
		mv.addObject("result", keyMerchantService.findByUserId(user.getId(), name,processorId,Integer.valueOf(pageNumber), Integer.valueOf(pageSize)));
		mv.addObject("name", name);
		mv.addObject("uuid", UUID.randomUUID());
		mv.addObject("processorId", processorId);//查询条件，前天传入的proceesorId
		
		//通过传入的人的processorId分析其角色，查询权限范围内的processorIds
		List<Parameter> processorIds = keyMerchantService.queryProcessorIds(user.getProcessorId());
		
		mv.addObject("processorIds", processorIds);
		
		return mv;
	}
	
	@RequestMapping(value = "/aroundMerchants", method = RequestMethod.GET)
	public ModelAndView aroundMerchants(HttpSession session){
		WeUser user = (WeUser)session.getAttribute(Constants.SESSION_KEY_USER);
		ModelAndView mv = new ModelAndView();
		Double lat = user.getLatitude();
		Double lng = user.getLongitude();
		logger.info("Get user:" + user.getId() + " around merchants base on lat:" + lat + ",lng:" + lng);
		if(lat != null && lng != null){
			mv.addObject("userLat", lat);
			mv.addObject("userLng", lng);
			mv.setViewName("sales/merchant/around-merchant");
		}else{
			mv.setViewName("message");
			mv.addObject("message", "尊敬的用户，很抱歉，无法获得您当前的地理位置，请在进入服务号会话时选择允许获取地理位置，非常感谢。");
		}
		return mv;
	}
	
	@RequestMapping(value = "/listAroundMerchants", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public PageableResult<List<AroundMerchantDTO>> listAroundMerchants(@RequestParam(defaultValue="500") int range, 
			@RequestParam(defaultValue=SortField._DISTANCE) String sortField, @RequestParam(defaultValue=SortType._ASC) String sortType,
			@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="10") int pageSize, 
			@RequestParam(required=false) Double lat, @RequestParam(required=false) Double lng, HttpSession session){
		WeUser user = (WeUser)session.getAttribute(Constants.SESSION_KEY_USER);
		if(lat == null || lng == null){
			lat = user.getLatitude();
			lng = user.getLongitude();
		}
		logger.info("Get user:" + user.getId() + " around merchants base on lat:" + lat + ",lng:" + lng);
		PageableResult<List<AroundMerchantDTO>> result = null;
		if(user.getLatitude() != null && user.getLongitude() != null){
			result = aroundMerchantService.getAroundMerchants(user.getProcessorId(), lat, lng, range, sortField, sortType, page, pageSize);
		}else{
			result = new PageableResult<List<AroundMerchantDTO>>();
			result.setCode(Constants.RESULT_CODE_FAILED);
			result.setMessage("尊敬的用户，很抱歉，无法获得您当前的地理位置，请在进入服务号会话时选择允许获取地理位置，非常感谢。");
		}
		return result;
	}
	
	@RequestMapping(value = "/remoteAddMerchant", method = RequestMethod.POST)
	@ResponseBody
	public Result<?> remoteAddMerchant(@ModelAttribute("dto") @Valid RemoteAddMerchantDTO dto, BindingResult bindingResult, HttpSession session){
		Result<?> result = new Result<Object>();
		if(bindingResult.hasErrors()){
			StringBuilder sb = new StringBuilder();
			List<ObjectError> errors = bindingResult.getAllErrors();
			for(ObjectError error : errors){
				sb.append(error.getDefaultMessage()).append("<br>");
			}
			result.setCode(Constants.RESULT_CODE_FAILED);
			result.setMessage(sb.toString());
		}else{
			Sales s = (Sales)session.getAttribute(Constants.SESSION_KEY_SALES);
			result = merchantService.remoteAdd(dto, s);
		}
		return result;
	}
	
	/**
	 * 银商客户经理点击banner
	 * @param imgPath
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/clickBanner", method = RequestMethod.GET)
	public String clickBanner(String imgPath,@ModelAttribute("login_user") WeUser user){
		//记录日志
		logService.insertActionLog(Constants.ACTION_CLICK_BANNER, user.getId(), null, "银商客户经理，用户id为:"+user.getId()+"在"+(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date())+"点击了banner");
		//重定向到图片页面
        return "redirect:/public/showPicture?pictureName=" +  imgPath;
	}
}
