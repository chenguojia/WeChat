package com.cardvalue.wechat.message.function;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.service.UserService;

@Component("AccountFunction")
public class AccountFunction {

	@Resource
	private UserService userService;
	
	public String getUsernameAndPassword(String openId, String content){
		WeUser user = userService.findByOpenId(openId);
		String infoStr = null;
		if(user != null){
			infoStr = String.format("您的用户名是%s，密码是%s", user.getUsername(), user.getPassword());
		}else{
			infoStr = "对不起，您还不是注册用户或你的账户未绑定";
		}
		return infoStr;
	}
	
}
