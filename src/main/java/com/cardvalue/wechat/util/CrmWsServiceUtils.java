package com.cardvalue.wechat.util;

import java.net.URL;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.cardvalue.www.CrmServiceBindingStub;

import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.UserRepository;

@Component
public class CrmWsServiceUtils implements InitializingBean{

	private final static Logger logger = LoggerFactory.getLogger(CrmWsServiceUtils.class);
	
	@Value( "${crm.ws.url}" )
	private String crmWsUrl;
	
	@Value( "${crm.ws.sales.username}" )
	private String crmWsSalesUsername;
	
	@Value( "${crm.ws.sales.password}" )
	private String crmWsSalesPassword;
	
	@Value( "${crm.ws.merchant.username}" )
	private String crmWsMerchantUsername;
	
	@Value( "${crm.ws.merchant.password}" )
	private String crmWsMerchantPassword;

	@Value( "${crm.ws.merchant.refer.username}" )
	private String crmWsMerchantReferUsername;

	@Value( "${crm.ws.merchant.refer.password}" )
	private String crmWsMerchantReferPassword;
	
	@Resource
	private UserRepository userRepo;
	
	private CrmServiceBindingStub serviceStub;
	
	public void setAutheticateInfo(Object request, int source) throws Exception{
		if(source == Constants.USER_TYPE_MERCHANT){
			PropertyUtils.setProperty(request, "list_id", crmWsMerchantUsername);
			PropertyUtils.setProperty(request, "clientSecret", crmWsMerchantPassword);
		}else if(source == Constants.USER_TYPE_MERCHANT_REFER){
			//表示商户转介绍类型
			PropertyUtils.setProperty(request, "list_id", crmWsMerchantReferUsername);
			PropertyUtils.setProperty(request, "clientSecret", crmWsMerchantReferPassword);
		}else{
			PropertyUtils.setProperty(request, "list_id", crmWsSalesUsername);
			PropertyUtils.setProperty(request, "clientSecret", crmWsSalesPassword);			
		}
	}
	
	public void setAutheticateParams(Object request, int userId) throws Exception{
		WeUser user = userRepo.findOne(userId);
		if(user != null){
			int userType = user.getType(); 
			switch(userType){
				case Constants.USER_TYPE_MERCHANT:
					int referrerId = user.getReferrerId();
					boolean hasUserName = PropertyUtils.isWriteable(request, "userName");
					if(referrerId > 0 && hasUserName){
						WeUser referrer = userRepo.findOne(referrerId);
						PropertyUtils.setProperty(request, "userName", referrer.getUsername());
					}
					break;
				default:
					PropertyUtils.setProperty(request, "userName", user.getUsername());
					PropertyUtils.setProperty(request, "password", user.getPassword());
			}
		}else{
			throw new Exception("user:" + userId + " not found");
		}
	}
	
	public CrmServiceBindingStub getServiceStub(){
		return serviceStub;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		try {
			serviceStub = new CrmServiceBindingStub(new URL(crmWsUrl), null);
		} catch (Exception e) {
			logger.error("Error occurs while creating crm service stub", e);
		}
	}
	
}
