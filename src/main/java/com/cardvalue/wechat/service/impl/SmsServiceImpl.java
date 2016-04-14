package com.cardvalue.wechat.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cardvalue.wechat.service.SmsService;
import com.jianzhou.sdk.BusinessService;

@Service
public class SmsServiceImpl implements SmsService{

	private final static Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);
	
	@Resource
	private BusinessService smsBusinessService; 
	
	@Value("${sms.enabled}")
	private boolean smsEnabled;
	
	@Value("${sms.account}")
	private String smsAccount;
	
	@Value("${sms.password}")
	private String smsPassword;
	
	@Value("${sms.signature}")
	private String smsSignature;
	
	@Override
	public int sendSms(String mobile, String message) {
		if(smsEnabled){
			String messageTxt = message + smsSignature;
			int flag = smsBusinessService.sendMessage(smsAccount, smsPassword, mobile, messageTxt);
			logger.info("Send SMS [" + messageTxt + "] to mobile:" + mobile + ", return flag:" + flag);
			return flag;
		}
		return 0;
	}

}
