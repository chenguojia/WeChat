package com.cardvalue.wechat.aop;

import com.cardvalue.wechat.model.ActionLog;
import com.cardvalue.wechat.repository.ActionLogRepository;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.RestfulResult;
import com.cardvalue.wechat.util.Utility;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mr tao on 2015/6/29.
 */

@Component
@Aspect
public class CallCrmExceptionAspect {

    @Resource
    private UtilityService utilityService;

    @Resource
    private ActionLogRepository actionLogRepository;

//    @AfterReturning(value = "execution(* com.cardvalue.wechat.service.NewMerchantService.*(..))", returning = "result")
//    public void afterReturning(JoinPoint joinPoint, Object result) {
//        if (result instanceof RestfulResult && ((RestfulResult) result).getResultCode().equals(Constants.RESTFUL_RESULT_FAILED)) {
//            //获取调用类名
//            String className = joinPoint.getTarget().getClass().getName();
//            //调用方法名
//            String method = joinPoint.getSignature().getName();
//            //获取调用方法参数名以及值
//            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//            String[] parameterNames = signature.getParameterNames();
//            Object[] parameterValues = joinPoint.getArgs();
//            //将调用方法参数名以及值组装成Map
//            Map callMethodParams = new HashMap();
//            if (parameterNames != null && parameterValues != null && parameterNames.length == parameterValues.length) {
//                for (int i = 0; i < parameterNames.length; i++) {
//                    callMethodParams.put(parameterNames[i], parameterValues[i]);
//                }
//            }
//            String errorMsg = "服务器出错: 调用 " + className + "." + method + " 失败 !";
//            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
//                    className, method, callMethodParams, errorMsg, null)));
//        }
//
//    }
//
//    /**
//     * 发送异常邮件
//     *
//     * @param joinPoint
//     * @param ex
//     */
//    @AfterThrowing(pointcut = "execution(* com.cardvalue.wechat.service.NewMerchantService.*(..))", throwing = "ex")
//    public void handleException(JoinPoint joinPoint, DataIntegrityViolationException ex) {
//        //获取调用类名
//        String className = joinPoint.getTarget().getClass().getName();
//        //调用方法名
//        String method = joinPoint.getSignature().getName();
//        //获取调用方法参数名以及值
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        String[] parameterNames = signature.getParameterNames();
//        Object[] parameterValues = joinPoint.getArgs();
//        //将调用方法参数名以及值组装成Map
//        Map callMethodParams = new HashMap();
//        if (parameterNames != null && parameterValues != null && parameterNames.length == parameterValues.length) {
//            for (int i = 0; i < parameterNames.length; i++) {
//                callMethodParams.put(parameterNames[i], parameterValues[i]);
//            }
//        }
//        System.out.println("进入切面========================================================");
//        String errorMsg = "服务器出错: 调用 " + className + "." + method + " 失败 !";
//        utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
//                className, method, callMethodParams, errorMsg, Utility.getExceptionInfo(ex))));
//    }


}
