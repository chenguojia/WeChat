package com.cardvalue.wechat.aop;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.service.UserPointService;
import com.cardvalue.wechat.util.Constants;

@Aspect
@Component
public class UserActionAspect {

	@Resource
	private UserPointService userPointService;
	
    @AfterReturning("execution(* com.cardvalue.wechat.service.UserService.afterLogin(..))")
    public void loginAdvice(){
    	addPoint(Constants.ACTION_LOG_IN);
    }
    
    @AfterReturning("execution(* com.cardvalue.wechat.service.LeadsService.create(..))")
    public void createLeadsAdvice(){
    	addPoint(Constants.ACTION_CREATE_LEADS);
    }
    
    @AfterReturning("execution(* com.cardvalue.wechat.service.MerchantService.findMerchantByNumber(..))")
    public void searchCreditAdvice(){
    	addPoint(Constants.ACTION_SEARCH);
    }
    
    private void addPoint(int action){
    	WeUser user = (WeUser)(RequestContextHolder.getRequestAttributes().getAttribute(Constants.SESSION_KEY_USER, RequestAttributes.SCOPE_SESSION));
    	if(user != null){
    		userPointService.addPoint(user.getId(), action);
    	}
    }
	
}
