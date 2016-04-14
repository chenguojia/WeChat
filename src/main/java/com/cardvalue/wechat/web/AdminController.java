package com.cardvalue.wechat.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cardvalue.wechat.service.AdminService;

@Controller
public class AdminController {

private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Resource
	private AdminService adminService;
	
	@RequestMapping(value = "/admin/weGrouping", method = RequestMethod.GET)
	public ModelAndView weGrouping() {
		logger.info("start grouping the we users");
		String message = adminService.batchWeGroupMove();
		ModelAndView mv = new ModelAndView("message");
		mv.addObject("message", "微信用户分组完成<br>" + message);
		return mv;
	}
	
}
