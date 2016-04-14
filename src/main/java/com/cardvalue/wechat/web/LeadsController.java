package com.cardvalue.wechat.web;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.service.SmsService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cardvalue.wechat.annotation.Token;
import com.cardvalue.wechat.dto.LeadsStatus;
import com.cardvalue.wechat.dto.LeadsUpdate;
import com.cardvalue.wechat.dto.MerchantInfo;
import com.cardvalue.wechat.dto.PageableRequest;
import com.cardvalue.wechat.model.CvRegionConf;
import com.cardvalue.wechat.model.Leads;
import com.cardvalue.wechat.model.MerchantCredit;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.service.LeadsService;
import com.cardvalue.wechat.service.MerchantService;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.CustomSqlDateEditor;
import com.cardvalue.wechat.util.PageableResult;
import com.cardvalue.wechat.util.Result;
import com.cardvalue.wechat.util.ResultUtils;
import com.cardvalue.wechat.util.Utility;

@Controller
@RequestMapping(value = "/leads")
@SessionAttributes("login_user")
public class LeadsController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource
	private LeadsService leadsService;
	
	@Resource
	private UtilityService utilityService;
	
	@Resource
	private MerchantService merchantService;

	@Resource
	private UserRepository userRepository;

	@Resource
	private SmsService smsService;

	@Value("${ws.local.ip}")
	private String wsLocalIp;

	public LeadsController() {}
	
    @InitBinder  
    public void initBinder(WebDataBinder binder) {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);  
        binder.registerCustomEditor(Date.class, new CustomSqlDateEditor(dateFormat, true));  
    }  
	
	@RequestMapping(value = "/showSubmitWithMerchant", method = {RequestMethod.POST, RequestMethod.GET})
	@Token(save=true)
	public ModelAndView showSubmitWithMerchant(MerchantInfo merchant) {
		logger.info("entering submit leads with merchant...");
		String mid = merchant.getMid();
		String subCode = merchant.getSubCode();
		ModelAndView mv = new ModelAndView();
		Leads leads = new Leads();
		leads.setMerchantNumber(mid);
		leads.setSubCode(subCode);
		leads.setFeedbackDate(Utility.getFutureSqlDate(3));
		MerchantCredit credit = merchantService.findMerchantByNumber(mid, null);
		if(credit != null){
			leads.setMerchantName(credit.getMerchantName());
		}
		//default value
		mv.setViewName("sales/leads/leads-create");
		mv.addObject("leads", leads);
		mv.addObject("intentions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_MERCHANT_INTENTION));
		mv.addObject("taskTypes", utilityService.getParamsByGroup(Constants.PARAM_GROUP_TASK_TYPE));
		mv.addObject("positions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_CONTACT_POSITION));
		mv.addObject("feedbackDays", utilityService.getParamsByGroup(Constants.PARAM_GROUP_FEEDBACK_DAYS));
		mv.addObject("backUrl", "/merchant/search?number=" + mid);
		return mv;
	}
	
	@RequestMapping(value = "/showSubmit", method = RequestMethod.GET)
	@Token(save=true)
	public ModelAndView showSubmit() {
		logger.info("entering submit leads with merchant...");
		ModelAndView mv = new ModelAndView();
		Leads leads = new Leads();
		leads.setFeedbackDate(Utility.getFutureSqlDate(3));
		mv.addObject("leads", leads);
		mv.addObject("intentions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_MERCHANT_INTENTION));
		mv.addObject("taskTypes", utilityService.getParamsByGroup(Constants.PARAM_GROUP_TASK_TYPE));
		mv.addObject("positions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_CONTACT_POSITION));
		mv.addObject("feedbackDays", utilityService.getParamsByGroup(Constants.PARAM_GROUP_FEEDBACK_DAYS));
		mv.setViewName("sales/leads/leads-create");
		mv.addObject("backUrl", "/");
		return mv;
	}
	
	@RequestMapping(value = "/showPosInstallation", method = RequestMethod.GET)
	@Token(save=true)
	public ModelAndView showPosInstallation() {
		logger.info("entering submit leads with merchant...");
		ModelAndView mv = new ModelAndView();
		Leads leads = new Leads();
		mv.addObject("leads", leads);
		mv.addObject("intentions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_MERCHANT_INTENTION));
		mv.addObject("taskTypes", utilityService.getParamsByGroup(Constants.PARAM_GROUP_TASK_TYPE));
		mv.addObject("positions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_CONTACT_POSITION));
		mv.addObject("feedbackDays", utilityService.getParamsByGroup(Constants.PARAM_GROUP_FEEDBACK_DAYS));
		List<CvRegionConf> provinces = utilityService.queryProvincesOrRegions(1, 1);
		mv.addObject("provinces", provinces);
		mv.addObject("citys", utilityService.queryProvincesOrRegions(2, provinces.get(0).getId()));
		mv.addObject("industries", utilityService.getParamsByGroup(Constants.PARAM_GROUP_MERCHANT_INDUSTRY));
		mv.addObject("staffNumbers", utilityService.getParamsByGroup(Constants.PARAM_GROUP_STAFF_NUMBER));
		mv.addObject("educationLevels", utilityService.getParamsByGroup(Constants.PARAM_GROUP_EDUCATION_LEVEL));
		mv.addObject("marriageStatuses", utilityService.getParamsByGroup(Constants.PARAM_GROUP_MARRIAGE_STATUS));
		mv.addObject("childrenStatuses", utilityService.getParamsByGroup(Constants.PARAM_GROUP_CHILDREN_STATUS));
		mv.addObject("hukouStatuses", utilityService.getParamsByGroup(Constants.PARAM_GROUP_HUKOU_STATUS));
		mv.addObject("businessAreas", utilityService.getParamsByGroup(Constants.PARAM_GROUP_BUSINESS_AREA));
		mv.addObject("businessLocations", utilityService.getParamsByGroup(Constants.PARAM_GROUP_BUSINESS_LOCATION));
		mv.setViewName("sales/leads/pos-installation-leads-create");
		mv.addObject("backUrl", "/");
		return mv;
	}
	
	@RequestMapping(value = "/create", method=RequestMethod.POST)
	@Token(remove=true)
	public ModelAndView create(Leads leads, HttpSession session){
		logger.info("entering create leads...");
		WeUser user = (WeUser)session.getAttribute("login_user");
		leads.setUserId(user.getId());
		Result<?> result = leadsService.create(leads, user.getId());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/common/message-box");
		if(ResultUtils.isSuccess(result)){

			//判断客经提交的是否是商户转介绍线索
			if (StringUtils.isNotBlank(leads.getReferrerCellPhone())) {
				//客户经理转介绍线索提交成功以后、检查推荐人手机号码是否在微信数据库存在,不存在则短信提醒推荐人微信注册账号
				if (userRepository.findByUsername(leads.getReferrerCellPhone()) == null) {
					//表示推荐人手机号码在CRM中存在，在微信不存在，直接给推荐人发送提示短信让其注册（此步骤在提交的时候做）
					//生产环境则发送短信
					if (wsLocalIp.equals("192.168.0.209")) {
						//发送短信通知推荐人关注微信服务号并进行注册
						smsService.sendSms(leads.getReferrerCellPhone(), "尊敬的卡得万利商户，您好！您转介推荐的商户：" + leads.getMerchantName() + " 的融资手续正在办理中，请立即在微信中搜索“CVBAOLI”或“卡得万利”关注并进行新用户注册，以免影响您的现金券赠送！如在被推荐商户成功放款后还未完成上述操作，您的优惠券将作废处理！");
					}
				}
			}

			mv.addObject("title","创建成功");
			mv.addObject("message", "点击确认返回线索列表");
			mv.addObject("url", "/leads/status");
		}else if(ResultUtils.isFaild(result)){
			mv.addObject("title","创建失败");
			mv.addObject("message", result.getMessage());
		}else{
			mv.addObject("title","创建失败");
			mv.addObject("message", "未知错误");
		}
		return mv;
	}
	
	@RequestMapping(value = "/isRepeated", method=RequestMethod.GET)
	@ResponseBody
	public boolean isRepeatedLeads(String mid){
		return leadsService.isRepeated(mid);
	}
	
	@RequestMapping(value = "/status", method=RequestMethod.GET)
	public ModelAndView status(@ModelAttribute("login_user") WeUser user){
		logger.info("entering leads status...");
		ModelAndView mv = new ModelAndView();
		List<LeadsStatus> list = leadsService.listInAllStatus(user.getId());
		mv.setViewName("sales/leads/leads-status");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public ModelAndView list(@RequestParam String status, @ModelAttribute PageableRequest pageableRequest, @ModelAttribute("login_user") WeUser user){
		logger.info("entering list leads...");
		ModelAndView mv = new ModelAndView();
		PageableResult result = null;
		if(StringUtils.isBlank(status)){
			result = leadsService.listAll(user.getId());
		}else{
			result = leadsService.listInStatus(user.getId(), status, pageableRequest.getPageNumber(), pageableRequest.getPageSize());
		}
		mv.setViewName("sales/leads/leads-list");
		mv.addObject("result", result);
		mv.addObject("status", status);
		mv.addObject("uuid", UUID.randomUUID());
		return mv;
	}
	
	@RequestMapping(value = "/detail", method=RequestMethod.GET)
	public ModelAndView detail(@RequestParam String status, @RequestParam int id, HttpSession session){
		logger.info("entering leads details...");
		ModelAndView mv = new ModelAndView();
		WeUser user = (WeUser)session.getAttribute("login_user");
		Leads leads = leadsService.getLeads(user.getId(), id, true);
		mv.setViewName("sales/leads/leads-detail");
		mv.addObject("leads", leads);
		mv.addObject("status", status);
		return mv;
	}
	
	@RequestMapping(value = "/edit", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam int id,  HttpSession session){
		logger.info("entering leads edit...");
		ModelAndView mv = new ModelAndView();
		WeUser user = (WeUser)session.getAttribute("login_user");
		Leads leads = leadsService.getLeads(user.getId(), id, false);
		mv.setViewName("sales/leads/leads-update");
		mv.addObject("intentions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_MERCHANT_INTENTION));
		mv.addObject("taskTypes", utilityService.getParamsByGroup(Constants.PARAM_GROUP_TASK_TYPE));
		mv.addObject("feedbackDays", utilityService.getParamsByGroup(Constants.PARAM_GROUP_FEEDBACK_DAYS));
		mv.addObject("positions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_CONTACT_POSITION));
		mv.addObject("leads", leads);
		return mv;
	}
	
	@RequestMapping(value = "/update", method=RequestMethod.POST)
	public ModelAndView update(LeadsUpdate updateDTO, HttpSession session){
		logger.info("entering leads update...");
		 WeUser user = (WeUser)session.getAttribute("login_user");
		leadsService.update(updateDTO, user.getId());
		logger.info("update leads successful...");
		ModelAndView mv = new ModelAndView();
		mv.addObject("title","修改成功");
		mv.addObject("message", "点击确认返回线索列表");
		mv.addObject("url", "/leads/status");
		mv.setViewName("/common/message-box");
		return mv;
	}
	
}
