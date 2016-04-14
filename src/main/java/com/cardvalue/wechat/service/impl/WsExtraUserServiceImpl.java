package com.cardvalue.wechat.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cardvalue.www.ArrResponse;
import cn.cardvalue.www.SoapAddUserRequest;
import cn.cardvalue.www.SoapSetPasswordRequest;

import com.cardvalue.wechat.dto.SaveSalesDTO;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.service.ExtraUserService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.CrmWsServiceUtils;

@Service
public class WsExtraUserServiceImpl implements ExtraUserService{

	private final static Logger logger = LoggerFactory.getLogger(WsExtraUserServiceImpl.class);
	
	@Resource
	private CrmWsServiceUtils serviceUtils;
	
	@Resource
	private UserRepository userRepo;
	
	@Override
	@Transactional
	public WeUser updatePassword(String username, String password) {
		SoapSetPasswordRequest request = new SoapSetPasswordRequest();
		try{
			WeUser user = userRepo.findByUsername(username);
			serviceUtils.setAutheticateInfo(request, Constants.USER_TYPE_UMS_SALES);
			serviceUtils.setAutheticateParams(request, user.getId());
			request.setNewPass(password);
			request.setConfirmPass(password);
			ArrResponse response = serviceUtils.getServiceStub().soapSetPassword(request);
			if(response != null && response.getCode().equals("1")){
				user.setPassword(password);
				user = userRepo.save(user);
				return user;
			}
		}catch(Exception e){
			logger.error("Error occurs while calling crm ws to update password",e);
		}
		return null;
	}

	@Override
	public String addUser(int userId, SaveSalesDTO dto) {
		SoapAddUserRequest request = new SoapAddUserRequest();
		try{
			serviceUtils.setAutheticateParams(request, userId);
			serviceUtils.setAutheticateInfo(request, Constants.USER_TYPE_UMS_SALES);
			request.setBank_name(dto.getBank());
			request.setBranchCode(dto.getBranchCode());
			request.setCellPhone(dto.getMobile());
			request.setDda(dto.getBankCardNumber());
			request.setEmail(dto.getEmail());
			request.setIDNumber(dto.getIdNumber());
			request.setNameEx(dto.getName());
			request.setNewUserPassword(RandomStringUtils.randomNumeric(6));
			//机构设置为待确定
			request.setProcessor_id(dto.getProcessorId());
			logger.info("start calling crm ws to add user:" + dto.getName());
			ArrResponse response = serviceUtils.getServiceStub().soapAddUser(request);
			if(response != null){
				String codeStr = response.getCode();
				logger.info("get response code:" + codeStr + " from calling crm ws to add user:" + dto.getName());
				int code = Integer.valueOf(codeStr);
				if(code < 0){
					return null;
				}
				return codeStr;
			}else{
				logger.error("get null response from calling crm ws to add user:" + dto.getName());
			}
		}catch(Exception e){
			logger.error("Error occurs while calling crm ws to update password",e);
		}
		return null;
	}
	
}
