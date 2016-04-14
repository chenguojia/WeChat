package com.cardvalue.wechat.service;

import java.util.List;

import com.cardvalue.wechat.model.UserPointSummary;
import com.cardvalue.wechat.model.UserPurseRecord;

public interface UserPointService {

	UserPointSummary getSummary(int userId);
	
	void addPoint(int userId, int action);
	
	String getLevelMessage(int userId);
	
	int addBalance(int userId, double amount, String memo);
	
	List<UserPurseRecord> listPurseRecord(int userId);

	int addPoint(int userId, int action, String memo, String factoringNo);

	int addExtraPoint(int userId, int point, String memo);

	int withdraw(int userId, String memo);
}
