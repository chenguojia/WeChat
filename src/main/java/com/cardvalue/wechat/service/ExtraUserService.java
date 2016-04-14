package com.cardvalue.wechat.service;

import com.cardvalue.wechat.dto.SaveSalesDTO;
import com.cardvalue.wechat.model.WeUser;

public interface ExtraUserService {

	public WeUser updatePassword(String username, String password);

	String addUser(int userId, SaveSalesDTO dto);
	
}
