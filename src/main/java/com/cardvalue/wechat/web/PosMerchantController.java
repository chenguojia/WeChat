package com.cardvalue.wechat.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cardvalue.wechat.model.PosApplicant;
import com.cardvalue.wechat.model.Sales;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.UtilRepository;
import com.cardvalue.wechat.service.PosApplicantService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.Result;

@Controller
public class PosMerchantController {

	@Resource
	private UtilRepository utilRepo;
	
	@Resource
	private PosApplicantService posService;
	
	@RequestMapping(value = "/posMerchant/list", method = RequestMethod.GET)
	public ModelAndView listPosMerchants(HttpSession session){
		Sales s = (Sales)session.getAttribute(Constants.SESSION_KEY_SALES);
		String regionCode = s.getRegionCode();
		String region = utilRepo.getRegionLabelByCode(regionCode);
		List<PosApplicant> posMerchants = posService.findByPrefecture(region);
		ModelAndView mv = new ModelAndView("sales/merchant/pos-merchants");
		mv.addObject("posMerchants", posMerchants);
		return mv;
	}
	
	@RequestMapping(value = "/posMerchant/my", method = RequestMethod.GET)
	public ModelAndView myPosMerchants(HttpSession session){
		WeUser user = (WeUser)session.getAttribute(Constants.SESSION_KEY_USER);
		List<PosApplicant> posMerchants = posService.findByUserId(user.getId());
		ModelAndView mv = new ModelAndView("sales/merchant/my-pos-merchants");
		mv.addObject("posMerchants", posMerchants);
		return mv;
	}
	
	@RequestMapping(value = "/posMerchant/detail", method = RequestMethod.GET)
	public ModelAndView detail(int appId){
		PosApplicant posMerchant = posService.findOne(appId);
		ModelAndView mv = new ModelAndView("sales/merchant/pos-merchant-detail");
		mv.addObject("merchant", posMerchant);
		return mv;
	}
	
	@RequestMapping(value = "/posMerchant/claim", method = RequestMethod.GET)
	@ResponseBody
	public Result<?> claim(int appId, HttpSession session){
		WeUser user = (WeUser)session.getAttribute(Constants.SESSION_KEY_USER);
		return posService.claim(user.getId(), appId);
	}
	
}
