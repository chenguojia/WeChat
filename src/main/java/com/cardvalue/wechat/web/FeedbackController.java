package com.cardvalue.wechat.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cardvalue.wechat.dto.FeedbackItemTO;
import com.cardvalue.wechat.dto.FeedbackTO;
import com.cardvalue.wechat.service.UserFeedbackService;

@Controller
public class FeedbackController {

private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class);
	
	@Resource
	private UserFeedbackService feedbackService;
	
	@RequestMapping(value = "/feedback", method = RequestMethod.GET)
	public ModelAndView feedback() {
		logger.info("Show feedback page...");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/feedback");
		mv.addObject("feedbacks", feedbackService.listFeedbacks());
		return mv;
	}
	
	@RequestMapping(value = "/feedback/listItems", method = RequestMethod.GET)
	public ModelAndView listItems(int feedbackId) {
		logger.info("list feedback items page...");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/feedback-items");
		mv.addObject("feedbackId", feedbackId);
		mv.addObject("feedbackItems", feedbackService.listFeedbackItems(feedbackId));
		return mv;
	}
	
	@RequestMapping(value = "/feedback/new", method = RequestMethod.POST)
	public ModelAndView newFeedback(@Valid FeedbackTO to, BindingResult result) {
		logger.info("new feedback...");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/message-box");
		if(result.hasErrors()){
			mv.addObject("title", "错误");
			mv.addObject("message", result.getAllErrors());
		}else{
			feedbackService.newFeedback(to);
			mv.addObject("title", "");
			mv.addObject("message", "您的建议已经成功提交，谢谢！");
		}
		return mv;
	}
	
	@RequestMapping(value = "/feedback/newItem", method = RequestMethod.POST)
	public ModelAndView newFeedbackItem(@Valid FeedbackItemTO to, BindingResult result) {
		logger.info("new feedback item...");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/message-box");
		if(result.hasErrors()){
			mv.addObject("title", "错误");
			mv.addObject("message", result.getAllErrors());
		}else{
			feedbackService.newFeedbackItem(to);
			mv.addObject("title", "");
			mv.addObject("message", "回复成功！");
		}
		return mv;
	}
	
}
