package com.cardvalue.wechat.interceptor;

import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cardvalue.wechat.annotation.Token;
import com.cardvalue.wechat.util.Constants;

public class TokenInterceptor extends HandlerInterceptorAdapter {
	 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Token annotation = method.getAnnotation(Token.class);
            if (annotation != null) {
                boolean needRemoveSession = annotation.remove();
                if (needRemoveSession) {
                    if (isRepeatSubmit(request)) {
                        return false;
                    }
                    request.getSession(true).removeAttribute(Constants.SESSION_KEY_TOKEN);
                }
            	boolean needSaveSession = annotation.save();
                if (needSaveSession) {
                    request.getSession(true).setAttribute(Constants.SESSION_KEY_TOKEN, UUID.randomUUID().toString());
                }
            }
            return true;
        } else {
            return super.preHandle(request, response, handler);
        }
    }
 
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String serverToken = (String) request.getSession(true).getAttribute(Constants.SESSION_KEY_TOKEN);
        if (serverToken == null) {
            return true;
        }
        String clinetToken = request.getParameter(Constants.SESSION_KEY_TOKEN);
        if (clinetToken == null) {
            return true;
        }
        if (!serverToken.equals(clinetToken)) {
            return true;
        }
        return false;
    }
}