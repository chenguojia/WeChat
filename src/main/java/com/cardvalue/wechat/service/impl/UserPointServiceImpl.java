package com.cardvalue.wechat.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import com.cardvalue.wechat.service.WeChatService;
import com.cardvalue.wechat.util.Utility;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cardvalue.wechat.model.Parameter;
import com.cardvalue.wechat.model.UserPointLog;
import com.cardvalue.wechat.model.UserPointPolicy;
import com.cardvalue.wechat.model.UserPointSummary;
import com.cardvalue.wechat.model.UserPurseRecord;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.ParamRepository;
import com.cardvalue.wechat.repository.UserPointLogRepository;
import com.cardvalue.wechat.repository.UserPointPolicyRepository;
import com.cardvalue.wechat.repository.UserPointSummaryRepository;
import com.cardvalue.wechat.repository.UserPurseRecordRepository;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.service.UserPointService;
import com.cardvalue.wechat.util.Constants;

@Service
public class UserPointServiceImpl implements UserPointService {

	private static Logger logger = LoggerFactory.getLogger(UserPointServiceImpl.class);
	
	@Resource
	private UserPointSummaryRepository userPointSummaryRepo;
	
	@Resource
	private UserRepository userRepo;
	
	@Resource
	private UserPointLogRepository userPointLogRepo;
	
	@Resource
	private ParamRepository paramRepo;
	
	@Resource
	private UserPointPolicyRepository userPointPolicyRepo;
	
	@Resource
	private UserPurseRecordRepository userPurseRecordRepo;
	
	@Resource
	private JavaMailSender mailSender;

	@Resource
	private WeChatService weChatService;
	
	@Override
	@Transactional(readOnly=true)
	public UserPointSummary getSummary(int userId) {
		UserPointSummary summary = userPointSummaryRepo.findByUserId(userId);
		if(summary == null){
			summary = new UserPointSummary(userId);
			userPointSummaryRepo.save(summary);
		}
		return summary;
	}

	@Override
	@Transactional
	public int addExtraPoint(int userId, int point, String memo) {
		UserPointSummary summary = getSummary(userId);
		UserPointLog log = new UserPointLog();
		log.setAction(Constants.ACTION_EXTRA_POINT);
		log.setCreateDate(new Date());
		log.setPoint(point);
		log.setUserId(userId);
		log.setMemo(memo);
		userPointLogRepo.save(log);
		
		summary.setTotalPoint(summary.getTotalPoint() + point);
		summary.setAvailablePoint(summary.getAvailablePoint() + point);
		userPointSummaryRepo.save(summary);
		updateLevel(userId);
		return summary.getAvailablePoint();
	}
	
	@Override
	@Transactional
	public void addPoint(int userId, int action) {
		addPoint(userId, action, null, null);
	}
	
	@Override
	@Transactional
	public int addPoint(int userId, int action, String memo, String factoringNo) {
		WeUser user = userRepo.findOne(userId);
		int userType = user.getType();
		
		UserPointSummary summary = userPointSummaryRepo.findByUserId(userId);
		if(summary == null){
			summary = new UserPointSummary(userId);
			summary = userPointSummaryRepo.save(summary);
		}
		
		UserPointPolicy policy = userPointPolicyRepo.findByUserTypeAndActionAndLevel(userType, action, summary.getLevel());
		if(policy != null){
			int maxPoint = policy.getDailyMaxPoint();
			int maxTimes = policy.getDailyMaxTimes();
			int dailyActionPoint = userPointLogRepo.getDailyTotalPointByUserAndAction(userId, action, new Date()).intValue();
			int dailyActionTimes = userPointLogRepo.getDailyTimesPointByUserAndAction(userId, action, new Date()).intValue();
			if( (maxPoint < 0 || (maxPoint > 0 && dailyActionPoint < maxPoint)) &&
				maxTimes < 0 || (maxTimes > 0 && dailyActionTimes < maxTimes)){
				int point = policy.getPoint();
				
				UserPointLog log = new UserPointLog();
				log.setAction(action);
				log.setCreateDate(new Date());
				log.setPoint(point);
				log.setUserId(userId);
				log.setMemo(memo);
				log.setFactoringNo(factoringNo);
				userPointLogRepo.save(log);

				summary.setTotalPoint(summary.getTotalPoint() + point);
				summary.setAvailablePoint(summary.getAvailablePoint() + point);
				userPointSummaryRepo.save(summary);
				updateLevel(userId);
			}
		}
		return summary.getAvailablePoint();
	}
	
	public void updateLevel(int userId){
		UserPointSummary summary = userPointSummaryRepo.findByUserId(userId);
		int totalPoint = summary.getTotalPoint();
		List<Parameter> levels = paramRepo.findByGroup(Constants.PARAM_GROUP_USER_POINT_LEVEL);
		for(Parameter level : levels){
			int levelPoint = Integer.parseInt(level.getMemo());
			int levelValue = Integer.parseInt(level.getValue());
			//如果总分大于指定级别积分并且级别小于指定级别，设置新级别
			if(totalPoint >= levelPoint && summary.getLevel() < levelValue){
				summary.setLevel(Integer.parseInt(level.getValue()));
			}else if(totalPoint >= levelPoint){
				//如果总分大于指定级别积分但是级别不小于指定级别，说明已超过此级别，比较下一级别
				continue;
			}else{
				//如果总分小于指定级别积分，则不修改级别
				break;
			}
		}
		userPointSummaryRepo.save(summary);
	}

	@Override
	public String getLevelMessage(int userId) {
		UserPointSummary summary = userPointSummaryRepo.findByUserId(userId);
		List<Parameter> levels = paramRepo.findByGroup(Constants.PARAM_GROUP_USER_POINT_LEVEL);
		String message = "您已是最高等级";
		int totalPoint = summary.getTotalPoint();
		for(Parameter level : levels){
			int levelPoint = Integer.parseInt(level.getMemo());
			int levelValue = Integer.parseInt(level.getValue());
			if(totalPoint < levelPoint && summary.getLevel() < levelValue){
				message = "还有" + (levelPoint - totalPoint) + "分升级" + level.getName();
				break;
			}
		}
		return message;
	}

	@Override
	@Transactional
	public int addBalance(int userId, double amount, String memo) {
		UserPointSummary summary = getSummary(userId);
		double currentBalance = summary.getBalance();
		double newBalance = currentBalance + amount;
		summary.setBalance(newBalance);
		userPointSummaryRepo.save(summary);
		UserPurseRecord record = new UserPurseRecord(userId, 1, amount);
		record.setBalance(newBalance);
		record.setMemo(memo);
		userPurseRecordRepo.save(record);
		return 1;
	}

	@Override
	@Transactional
	public int withdraw(int userId, String memo) {
		WeUser user = userRepo.findById(userId);
		if(!StringUtils.equals(memo, user.getWeId())){
			user.setWeId(memo);
			logger.info("user [id" + userId + "] set we_id:" + memo);
			userRepo.save(user);
		}
		UserPointSummary summary = getSummary(userId);
		double currentBalance = summary.getBalance();
		double newBalance = 0;
		summary.setBalance(newBalance);
		userPointSummaryRepo.save(summary);
		UserPurseRecord record = new UserPurseRecord(userId, 2, currentBalance);
		record.setBalance(newBalance);
		record.setMemo(memo);
		userPurseRecordRepo.save(record);

		//push模板消息
		weChatService.pushTemplateMessage(user.getOpenId(),"红包提现通知",null,currentBalance,user.getUsername(), Utility.formatLongDate(new Date()),Utility.formatLongDate(Utility.addOrMinusDayForDate(1, new Date(), 3)),null);
		return 1;
	}
	
	@Override
	public List<UserPurseRecord> listPurseRecord(int userId) {
		return userPurseRecordRepo.listPurseRecord(userId);
	}

}
