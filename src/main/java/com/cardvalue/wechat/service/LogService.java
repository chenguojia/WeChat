package com.cardvalue.wechat.service;

import com.cardvalue.wechat.model.ActionLog;

public interface LogService {

	public ActionLog insertActionLog(int action, Integer userId, String openId, String memo);

}
