package com.cardvalue.wechat.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cardvalue.wechat.dto.CalculateInfo;
import com.cardvalue.wechat.dto.CreditInfo;
import com.cardvalue.wechat.dto.KeyMerchantDTO;
import com.cardvalue.wechat.dto.RemoteAddMerchantDTO;
import com.cardvalue.wechat.model.MerchantCredit;
import com.cardvalue.wechat.model.Parameter;
import com.cardvalue.wechat.model.Sales;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.service.KeyMerchantService;
import com.cardvalue.wechat.service.LogService;
import com.cardvalue.wechat.service.MerchantService;
import com.cardvalue.wechat.service.UserService;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.util.Constants;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/merchant")  
public class MerchantController {
	
	@Resource
	private MerchantService merchantService;
	
	@Resource
	private UtilityService utilityService;
	
	@Resource
	private LogService logService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private KeyMerchantService keyMerchantService;
	
	private static final Logger logger = LoggerFactory.getLogger(MerchantController.class);
	
	@RequestMapping(value = "/criteria", method = RequestMethod.GET)
	public String criteria(@RequestParam(defaultValue=Constants.SOURCE_TYPE_SALES) String type) {
		return type + "/merchant/merchant-search";
	}
	
	@RequestMapping(value = {"/search"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView search(@RequestParam String number, @RequestParam(defaultValue=Constants.SOURCE_TYPE_SALES) String type) {
		logger.info("start search merchant...");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		WeUser user = userService.findByUsername(auth.getName());
		Integer userId = user.getId();
		String openId = user.getOpenId();
		StringBuilder logMemoBuilder = new StringBuilder();
		logMemoBuilder.append("mid:").append(number).append(",type:").append(type);
		ModelAndView mv = new ModelAndView();
		Sales sales = userService.findSalesByUserId(userId);
		//check the log-in sales have the permission to search the mid
		MerchantCredit credit = merchantService.findMerchantByNumber(number, user.getProcessorId());
		if(merchantService.allowAccess(credit, sales)){
			logger.info("merchant {} found", number);
			mv.addObject("merchant", credit);
			mv.addObject("number", number);
			mv.addObject("positions", utilityService.getParamsByGroup(Constants.PARAM_GROUP_CONTACT_POSITION));
			mv.addObject("dto", new RemoteAddMerchantDTO());
			mv.setViewName(type + "/merchant/merchant-detail");
			logMemoBuilder.append(",result:found");
		}else{
			mv.addObject("title","");
			mv.addObject("number", number);
			mv.addObject("url", "/merchant/calculator");
			mv.setViewName("/common/message-box-b");
			if(credit != null){
				logger.info("user {} is not allowed to search mid {}", user.getUsername(), number);
				mv.addObject("message", "查询商编不在您的负责区域内,是否转入授信计算器进行计算?");
				logMemoBuilder.append(",result:not-allowd");
			}else{
				logger.info("merchant {} not found", number);
				mv.addObject("message", "无法找到匹配商户,是否转入授信计算器进行计算?");
				logMemoBuilder.append(",result:not-found");
			}
		}
		int action = Constants.ACTION_SEARCH;
		logService.insertActionLog(action, userId, openId, logMemoBuilder.toString());
		return mv;
	}
	
	@RequestMapping(value = "/calculator", method = RequestMethod.GET)
	public ModelAndView calculator(@RequestParam(defaultValue=Constants.SOURCE_TYPE_SALES) String type) {
		logger.info("entering calculator...");
		ModelAndView mv = new ModelAndView();
		List<Parameter> regions = utilityService.getParamsByGroup(Constants.PARAM_GROUP_PROVINCE);
		//List<Parameter> busTypes = utilityService.getParamsByGroup(Constants.PARAM_GROUP_BUSINESS_TYPE);
		mv.addObject("regions", regions);
		//mv.addObject("busTypes", busTypes);
		mv.addObject("calculateInfo", new CalculateInfo());
		mv.setViewName(type + "/merchant/credit-calculator");
		return mv;
	}
	
	@RequestMapping(value = "/calculate", method = RequestMethod.POST)
	public ModelAndView calculate(CalculateInfo info, @RequestParam(defaultValue=Constants.SOURCE_TYPE_SALES) String type
			, @RequestParam(required=false) String openId) {
		logger.info("entering calculate...");
		Integer userId = 0;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null && auth.isAuthenticated()){
			WeUser user = userService.findByUsername(auth.getName());
			if(user != null){
				userId = user.getId();
				openId = user.getOpenId();
			}
		}
		ModelAndView mv = new ModelAndView();
		CreditInfo creditInfo = merchantService.calculate(info);
		StringBuilder logMemoBuilder = new StringBuilder();
		logMemoBuilder.append("caculate criteria:").append(info.toString()).append(",type:").append(type);
		if(creditInfo == null){
			mv.addObject("title", "没有查询结果");
			mv.addObject("message", "请检查条件后重试。");
			mv.setViewName("/common/message-box");
			logMemoBuilder.append(",result:not-found");
		}else{
			int creditRating = creditInfo.getCreditRating();
			Parameter param = utilityService.getParamByValueAndGroup(Constants.PARAM_GROUP_CREDIT_RATING, String.valueOf(creditRating));
			creditInfo.setCreditRatingLabel(param.getName());
			mv.addObject("creditInfo", creditInfo);
			mv.setViewName(type + "/merchant/credit-result");
			logMemoBuilder.append(",result:found");
		}
		int action = Constants.ACTION_CALCULATE;
		logService.insertActionLog(action, userId, openId, logMemoBuilder.toString());
		return mv;
	}
	
	@RequestMapping(value = "/findMerchantName", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> findMerchantName(@RequestParam String mid){
		String merchantName = "";
		List<KeyMerchantDTO> merchants = keyMerchantService.findByMid(mid);
		if(merchants != null && merchants.size() > 0){
			merchantName = merchants.get(0).getMerchantName();
		}
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("merchantName", merchantName);
		return maps;
	}
	
}
