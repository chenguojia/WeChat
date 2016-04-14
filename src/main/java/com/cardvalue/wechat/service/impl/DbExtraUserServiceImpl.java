package com.cardvalue.wechat.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cardvalue.wechat.dto.SaveSalesDTO;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.service.ExtraUserService;

@Service
public class DbExtraUserServiceImpl implements ExtraUserService{

	private final static Logger logger = LoggerFactory.getLogger(DbExtraUserServiceImpl.class);
	
	@Resource
	private UserRepository userRepository;
	
	@Transactional
	@Override
	public WeUser updatePassword(String username, String password){
		logger.info("update password...");
		WeUser weUser = userRepository.findByUsername(username);
		if(weUser != null){
			weUser.setPassword(password);
			userRepository.save(weUser);
		}
		return weUser;
	}

	@Override
	public String addUser(int userId, SaveSalesDTO dto) {
		return null;
	}
	
}
