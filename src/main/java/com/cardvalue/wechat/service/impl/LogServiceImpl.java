package com.cardvalue.wechat.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cardvalue.wechat.model.ActionLog;
import com.cardvalue.wechat.repository.ActionLogRepository;
import com.cardvalue.wechat.service.LogService;

@Service
public class LogServiceImpl implements LogService{

	@Resource
	private ActionLogRepository actionLogRepository;
	
	@Override
	public ActionLog insertActionLog(int action, Integer userId, String openId, String memo) {
		ActionLog log = new ActionLog();
		log.setAction(action);
		log.setUserId(userId);
		log.setOpenId(openId);
		log.setMemo(memo);
		log.setCreateDate(new Date());
		log = actionLogRepository.save(log);
		return log;
	}
	
}
