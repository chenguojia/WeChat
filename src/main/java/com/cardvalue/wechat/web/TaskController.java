package com.cardvalue.wechat.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cardvalue.wechat.dto.TaskGroup;
import com.cardvalue.wechat.model.Task;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.service.MerchantService;
import com.cardvalue.wechat.service.TaskService;
import com.cardvalue.wechat.util.Constants;

@Controller
@RequestMapping(value = "/task")
@SessionAttributes("login_user")
public class TaskController {

	private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
	
	@Resource
	private TaskService taskService;
	
	@Resource
	private MerchantService merchantService;
	
	//empty constructor
	public TaskController() {}
	
	@RequestMapping(value = "/listGroups", method=RequestMethod.GET)
	public ModelAndView listGroups( @ModelAttribute("login_user") WeUser user){
		logger.info("entering list task groups...");
		ModelAndView mv = new ModelAndView();
		int userId = user.getId();
		List<TaskGroup> list = taskService.listTaskGroups(userId);
		mv.setViewName("sales/task/task-group");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue="1") String pageNumber, @RequestParam(defaultValue="20") String pageSize,
			@RequestParam String group,  @ModelAttribute("login_user") WeUser user){
		logger.info("entering list task...");
		ModelAndView mv = new ModelAndView();
		int userId = user.getId();
		mv.setViewName("sales/task/task-list");
		mv.addObject("result", taskService.listTaskByGroup(userId, group,Integer.valueOf(pageNumber), Integer.valueOf(pageSize)));
		mv.addObject("group", group);
		return mv;
	}
	
	@RequestMapping(value = "/detail", method=RequestMethod.GET)
	public ModelAndView detail(@RequestParam int id, @RequestParam String group, HttpSession session){
		logger.info("entering task detail...");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sales/task/task-detail");
		WeUser user = (WeUser)session.getAttribute(Constants.SESSION_KEY_USER);
		Task task = taskService.getTask(user.getId(), id);
		mv.addObject("task", task);
		mv.addObject("group", group);
		return mv;
	}
	
}
