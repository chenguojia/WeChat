package com.cardvalue.wechat.auth;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cardvalue.wechat.model.UserAdmin;
import com.cardvalue.wechat.repository.UserAdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.service.LogService;
import com.cardvalue.wechat.service.UserService;
import com.cardvalue.wechat.util.Constants;

@Component("authSuccessHandler")
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandlerImpl.class);

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Resource
	private UserService userService;
	
	@Resource
	private LogService logService;

	@Resource
	private UserAdminRepository userAdminRepository;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
		logger.info("onAuthenticationSuccess...");
		HttpSession session = request.getSession();
		session.removeAttribute("loginFailedMessage");
		String openId = (String) session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID);
		logger.info("get openId {} from session {}", openId, session.getId());
		// TODO add logic to bind the user if only needed
		WeUser user = userService.bind(auth.getName(), openId);
		userService.afterLogin(user, session);

		UserAdmin userAdmin = userAdminRepository.findByUserId(user.getId());//判断是否管理员
		if(userAdmin == null) {
			redirectStrategy.sendRedirect(request, response, "/");
		} else{
			//是管理员，跳转到管理员界面
			redirectStrategy.sendRedirect(request, response, "/background/home");
		}
	}

}
