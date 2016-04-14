package com.cardvalue.wechat.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cardvalue.wechat.model.*;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cardvalue.wechat.dto.KeyMerchantDTO;
import com.cardvalue.wechat.repository.ReferrerLinkRepository;
import com.cardvalue.wechat.service.KeyMerchantService;
import com.cardvalue.wechat.service.LogService;
import com.cardvalue.wechat.service.MerchantService;
import com.cardvalue.wechat.service.SmsService;
import com.cardvalue.wechat.service.UserService;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.service.WeChatService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.Result;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/public")  
public class PublicController {
	
	@Resource
	private MerchantService merchantService;
	
	@Resource
	private UtilityService utilityService;
	
	@Resource
	private LogService logService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private ReferrerLinkRepository referrerLinkRepo;
	
	@Resource
	private WeChatService weService;
	
	@Resource
	private KeyMerchantService keyMerchantService;
	
	@Resource
	private SmsService smsService;

	@Resource
	private WeChatService weChatService;

	@PersistenceContext
	private EntityManager em;
	
	private static final Logger logger = LoggerFactory.getLogger(PublicController.class);
	
	@RequestMapping(value = "/criteria", method = RequestMethod.GET)
	public String criteria() {
		return "/public/merchant-search";
	}
	
	@RequestMapping(value = "/search", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView search(@RequestParam String number, HttpServletRequest request) {
		logger.info("start search merchant...");
		MerchantCredit credit = merchantService.findMerchantByNumber(number, null);
		ModelAndView mv = new ModelAndView();
		if(credit != null){
			logger.info("merchant {} found", number);
			mv.addObject("merchant", credit);
			mv.setViewName("/public/merchant-detail");
		}else{
			mv.addObject("title","");
			mv.addObject("number", number);
			mv.setViewName("/common/message-box");
			logger.info("merchant {} not found", number);
			mv.addObject("message", "无法找到匹配商户");
		}
		return mv;
	}
	
	@RequestMapping(value = "/showMessage", method = RequestMethod.GET)
	public ModelAndView showMessage(@RequestParam String message) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("message");
		mv.addObject("message", message);
		return mv;
	}
	
	@RequestMapping(value = "/showPicture", method = RequestMethod.GET)
	public ModelAndView showPicture(@RequestParam String pictureName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("public/show-picture");
		mv.addObject("pictureName", pictureName);
		return mv;
	}
	
	@RequestMapping(value = "/merchantValidEntry", method = RequestMethod.GET)
	public ModelAndView merchantValidEntry(@RequestParam String code){
		String openId = weService.getOpenIdByAccessToken(code);
		ModelAndView mv = new ModelAndView("/m/merchant-valid-entry");
		mv.addObject("openId", openId);
		return mv;
	}
	
	@RequestMapping(value = "/merchantValid", method = RequestMethod.POST)
	public ModelAndView merchantValid(@RequestParam String openId, @RequestParam String shortKey){
		logger.info("merchant valid with short key:" + shortKey);
		ModelAndView mv = new ModelAndView();
		if(openId == null){
			mv.setViewName("message");
			mv.addObject("message", "系统内部错误，请重试。");
		}else{
			ReferrerLink link = referrerLinkRepo.findLinkByShortKey(shortKey);
			if(link != null){
				if(link.isValid() == true){
					Date date = DateUtils.addDays(new Date(), -1);
					if(link.getCreateDate().after(date)){
						Result<?> result = merchantService.validMerchant(openId, link.getId());
						if(result.getCode().equals(Constants.RESULT_CODE_SUCCESS)){
							mv.setViewName("/m/merchant-valid-result");
							List<KeyMerchantDTO> keyMerchants = keyMerchantService.findByMid(link.getMid());
							Sales s = userService.findSalesByUserId(link.getReferrerId());
							mv.addObject("merchantName", keyMerchants.get(0).getMerchantName());
							mv.addObject("sales", s);
							mv.addObject("link", link);
						}else{
							mv.setViewName("message");
							mv.addObject("message", result.getMessage());
						}
					}else{
						mv.setViewName("common/message-box-b");
						mv.addObject("url", "/public/refreshReferrerLink?shortKey=" + shortKey);
						mv.addObject("message", "您输入的校验码已超时，请点击确认重新获取校验码。");
					}
				}else{
					mv.setViewName("message");
					mv.addObject("message", "您输入的校验码已完成校验。");
				}
			}else{
				mv.setViewName("message");
				mv.addObject("message", "您输入的校验码错误，请重新输入。");
			}
		}
		return mv;
	}
	
	@RequestMapping(value = "/refreshReferrerLink", method = RequestMethod.GET)
	public ModelAndView refreshReferrerLink(@RequestParam String shortKey){
		logger.info("merchant refresh the referrer link with shortkey:" + shortKey);
		ReferrerLink link = referrerLinkRepo.findLinkByShortKey(shortKey);
		ReferrerLink newLink = referrerLinkRepo.clone(link.getId());
		merchantService.sendReferrerLinkNotice(newLink);
		ModelAndView mv = new ModelAndView("message");
		mv.addObject("message", "校验码已重新生成并发送");
		return mv;
	}
	
	@RequestMapping(value = "/public/page/{pageName}", method = RequestMethod.GET)
	public String showPage(@PathVariable("pageName") String pageName) {
		return "/public/page/" + pageName;
	}

	/**
	 * 最新活动
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/newestCampaign", method = RequestMethod.GET)
	public ModelAndView newestCampaign(HttpSession session) {
		String sql = "FROM Campaign t WHERE t.allowUserType=:allowUserType AND DATE(beginDate)<=DATE(:beginDate) AND DATE(endDate)>=DATE(:endDate) order by t.sort desc";
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/public/newestCampaign");
		//默认查询商户活动
		Query query = em.createQuery(sql).setParameter("allowUserType", 4).setParameter("beginDate", new Date()).setParameter("endDate", new Date());
		WeUser user = null;
		if(session.getAttribute(Constants.SESSION_KEY_USER) != null) user = (WeUser) session.getAttribute(Constants.SESSION_KEY_USER);
		if (user != null ) {
			//当用户类型等于银经、内部员工、运营专员都可以看见银商的活动
			if(user.getType() == 1 || user.getType() == 0 || user.getType() == 2) {
				//银商客经类型活动
				query = em.createQuery(sql, Campaign.class).setParameter("allowUserType", 1).setParameter("beginDate", new Date()).setParameter("endDate", new Date());
			}
		}
		List<Campaign> campaigns = query.getResultList();
		mv.addObject("campaigns", campaigns);
		return mv;
	}

}
