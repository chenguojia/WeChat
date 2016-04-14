package com.cardvalue.wechat.web;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.service.ExtraUserService;
import com.cardvalue.wechat.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Resource
	private UserService userService;
	
	@Resource
	private ExtraUserService extraUserService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/auth/login", method = RequestMethod.GET)
	public ModelAndView login(String message) throws UnsupportedEncodingException {
		//logger.info("Show login page...");
		//return "auth/login";
		ModelAndView mv = new ModelAndView();
		mv.setViewName("auth/login");
		if(message != null && !message.equals(""))
			mv.addObject("message", message);
		else
			mv.addObject("message", null);
		return mv;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/auth/m-login", method = RequestMethod.GET)
	public ModelAndView mLogin(String message) throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("auth/m-login");
		if(message != null && !message.equals(""))
			mv.addObject("message", message);
		else
			mv.addObject("message", null);
		return mv;
	}
	
	
	/**
	 * 新用户入口
	 * @return
	 */
	@RequestMapping(value = "/auth/newUserEntry", method = RequestMethod.GET)
	public ModelAndView newUserEntry(String code) {
		logger.info("Show update new user entry");
		ModelAndView mv = new ModelAndView();
		mv.addObject("code", code);
		mv.setViewName("auth/new-user-entry");
		return mv;
	}
	
	@RequestMapping(value = "/auth/showUpdatePassword", method = RequestMethod.GET)
	public String showUpdatePassword() {
		logger.info("Show update password page...");
		return "auth/update-password";
	}
	
	@RequestMapping(value = "/auth/updatePassword", method = RequestMethod.POST)
	public ModelAndView updatePassword(@RequestParam String password, HttpServletRequest request){
		logger.info("update password...");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		WeUser user = extraUserService.updatePassword(username, password);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/common/message-box");
		mv.addObject("title","");
		if(user != null){
			mv.addObject("message", "更新密码成功");
		}else{
			mv.addObject("message", "更新密码失败");
		}
		return mv;
	} 
	
}
