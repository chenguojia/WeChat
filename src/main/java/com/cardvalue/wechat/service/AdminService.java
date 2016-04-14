package com.cardvalue.wechat.service;

import com.cardvalue.wechat.util.Result;

public interface AdminService {

	String batchWeGroupMove();

	void weGroupMove(int userId);

	Result<?> weGroupUpdate(String fromGroupName, String toGroupName);
	
}
