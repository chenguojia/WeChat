package com.cardvalue.wechat.message.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cardvalue.wechat.dto.WeChatMessage;
import com.cardvalue.wechat.message.MessageHandler;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.UserRepository;

public class UnsubscribeMessageHandler extends MessageHandler {

	private final static Logger logger = LoggerFactory.getLogger(UnsubscribeMessageHandler.class);
	
	@Resource
	private UserRepository userRepo;
	
	@Override
	public String handle(WeChatMessage message) {
		logger.info("Start handle unsubscribe...");
		String openId = message.getFromUserName();
		WeUser user = userRepo.findByOpenId(openId);
		if(user != null){
			user.setOpenId(null);
			userRepo.save(user);
		}
		logger.info("Complete handle unsubscribe.");
		return null;
	}

}
