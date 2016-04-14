package com.cardvalue.wechat.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;







import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.service.PerformanceService;
import com.cardvalue.wechat.service.UserService;

@Controller
public class PerformanceController {
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Resource
	private PerformanceService performanceService;
	
	@Resource
	private UserService userService;
	
	/**
	 * 
	 * */
	@RequestMapping(value = "/sales/performance/getPerformance", method = RequestMethod.GET)
	public ModelAndView getPerformance(){
		logger.info("Show Performance ");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        WeUser user = userService.findByUsername(auth.getName());
		
		ModelAndView mv = new ModelAndView();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
	
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(new Date());
        //前一个月
        rightNow.add(Calendar.MONTH,-1);
        Date dt1=rightNow.getTime();
        
        //查询前一个月的绩效
        String lastMonthPerformance= performanceService.getPerformanceByUserNumberAndMonth(user.getUsername(), sdf.format(dt1));
        mv.addObject("lastMonthPerformance", lastMonthPerformance);
        //查询前一个月的绩效
        String currentMonthPerformance=performanceService.getPerformanceByUserNumberAndMonth(user.getUsername(), sdf.format(new Date()));
        mv.addObject("currentMonthPerformance", currentMonthPerformance);
        
        mv.setViewName("sales/account/month-performance");
		return mv;
	} 
}
