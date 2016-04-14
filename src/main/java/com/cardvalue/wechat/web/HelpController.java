package com.cardvalue.wechat.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cardvalue.wechat.service.TaskService;

@Controller
@RequestMapping(value = "/help")
public class HelpController {

	@Resource
	private TaskService taskService;
	
	//empty constructor
	public HelpController() {}
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String list(){
		return "/sales/help/list";
	}
	
	@RequestMapping(value = "/signHelp", method=RequestMethod.GET)
	public String signHelp(){
		return "/sales/help/sign-help";
	}
	
	@RequestMapping(value = "/signPolicy", method=RequestMethod.GET)
	public String signPolicy(){
		return "/sales/help/sign-policy";
	}
	
	@RequestMapping(value = "/signDocument", method=RequestMethod.GET)
	public String signDocument(){
		return "/sales/help/sign-document";
	}
	
	@RequestMapping(value = "/signRule", method=RequestMethod.GET)
	public String signRule(){
		return "/sales/help/sign-rule";
	}
	
	@RequestMapping(value = "/next", method=RequestMethod.GET)
	public String next(){
		return "/sales/help/next";
	}
	
	@RequestMapping(value = "/question", method=RequestMethod.GET)
	public String question(){
		return "/sales/help/question";
	}
	
	@RequestMapping(value = "/instruction", method=RequestMethod.GET)
	public String instruction(){
		return "/sales/help/instruction";
	}
	
	@RequestMapping(value = "/contact", method=RequestMethod.GET)
	public String contact(){
		return "/sales/help/contact";
	}
	
}
