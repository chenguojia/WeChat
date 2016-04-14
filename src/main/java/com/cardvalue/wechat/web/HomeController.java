package com.cardvalue.wechat.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cardvalue.wechat.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.MerchantRepository;
import com.cardvalue.wechat.repository.UtilRepository;
import com.cardvalue.wechat.service.LeadsService;
import com.cardvalue.wechat.service.LogService;
import com.cardvalue.wechat.service.UserService;
import com.cardvalue.wechat.service.WeChatService;
import com.cardvalue.wechat.util.Constants;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Resource
	private UserService userService;
	
	@Resource
	private MerchantRepository merchantRepository;

	@Resource
	private WeChatService weChatService;

	@Resource
	private LogService logService;
	
	@Resource
	private AuthenticationManager authenticationManager;
	
	@Resource
	private UtilRepository utilRepo;
	
	@Resource
	private LeadsService leadsService;

	@Resource
	private UserRepository userRepository;
	
	@RequestMapping(value = "/home/enter", method = RequestMethod.GET)
	public String enter(@RequestParam String code, @RequestParam(required=false) String redirectUrl, HttpServletRequest request) throws IOException {
		logger.info("User entering with code {}", code);
		HttpSession session = request.getSession();
		String openId = weChatService.getOpenIdByAccessToken(code);
		if(openId != null){
			WeUser user = userService.findByOpenId(openId);
			session.setAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID, openId);
			if(user != null && user.isEnabled()){
				authenticateUserAndSetSession(user.getUsername(), user.getPassword(), request);
				userService.afterLogin(user, session);
				if(StringUtils.isNoneBlank(redirectUrl)){
					return "redirect:" + redirectUrl;
					//return "redirect:/";
				}else{
					return "redirect:/";
				}
			}else if(user != null && !user.isEnabled()){
				String message = "亲爱的用户，您的账号还没有激活，请等待激活后再次登录，谢谢！";
				return "redirect:/public/showMessage?message=" + URLEncoder.encode(message,"utf-8");
			}else if(user == null && StringUtils.isNoneBlank(redirectUrl) && redirectUrl.indexOf("newestCampaign") != -1 ){
				session.setAttribute(Constants.SESSION_KEY_USER,null);//清空session中上次登录用户信息
				//表示没有登录的用户，查看最新活动
				return "redirect:" + redirectUrl;
			}else if(user == null && StringUtils.isNoneBlank(redirectUrl) && redirectUrl.indexOf("RegisterAndLogin") != -1){
				//表示是商户注册完成了，直接跳转到登录成功且进入主页
				//获取商户手机号码,在url中已经拼接好了
				String mobile = redirectUrl.split("/")[1];
				user = userService.findByUsername(mobile);
				session.setAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID, openId);
				if(user != null && user.isEnabled()) {
					authenticateUserAndSetSession(user.getUsername(), user.getPassword(), request);
					userService.afterLogin(user, session);
					user.setOpenId(openId);//登录
					userRepository.save(user);
					return "redirect:/";
				} else {
					return "redirect:/auth/login";//失败的话返回到登录
				}
			}else{
				if(redirectUrl == null || redirectUrl.equals("")){
					//表示点击用户入口
					logger.info("user not bind with open id {}", openId);
					return "redirect:/auth/login";
				}else{
					//表示点击的功能按钮
					String message = "您需先登录才能使用该功能!！";
					return "redirect:/auth/login?message=" + URLEncoder.encode(message,"utf-8");
				}
			}
		}else{
			logger.info("failed to get open id with code {}", code);
			return "redirect:/auth/login";
			/*String message = "亲爱的用户，，谢谢！";
			return "redirect:/public/showMessage?message=" + URLEncoder.encode(message,"utf-8");*/
		}
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		WeUser user = userService.findByUsername(username);
		if(user.getType() == Constants.USER_TYPE_MERCHANT){
			return "redirect:/m/home";
		}else{
			return "redirect:/sales/home";
		}
	}	

	private void authenticateUserAndSetSession(String username, String password, HttpServletRequest request) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		token.setDetails(new WebAuthenticationDetails(request));
		Authentication authenticatedUser = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	}
}
