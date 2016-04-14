package com.cardvalue.wechat.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cardvalue.wechat.dto.CouponInfo;
import com.cardvalue.wechat.dto.ExchangeCouponResult;
import com.cardvalue.wechat.dto.SalesInfo;
import com.cardvalue.wechat.model.Coupon;
import com.cardvalue.wechat.model.Sales;
import com.cardvalue.wechat.model.UserCoupon;
import com.cardvalue.wechat.model.UserPointSummary;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.CouponRepository;
import com.cardvalue.wechat.repository.SalesRepository;
import com.cardvalue.wechat.repository.UserCouponRepository;
import com.cardvalue.wechat.repository.UserPointLogRepository;
import com.cardvalue.wechat.repository.UserPointSummaryRepository;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.service.CouponService;
import com.cardvalue.wechat.util.Constants;

@Service
public class CouponServiceImpl implements CouponService {

	private final static Logger logger = LoggerFactory.getLogger(CouponServiceImpl.class);
	
	@Resource
	private CouponRepository couponRepo;
	
	@Resource
	private UserPointSummaryRepository userPointSummaryRepo;
	
	@Resource
	private UserCouponRepository userCouponRepo;
	
	@Resource
	private UserRepository userRepo;
	
	@Resource
	private SalesRepository salesRepo;
	
	@Resource
	private UserPointLogRepository userPointLogRepo;
	
	@Resource
	private JavaMailSender mailSender;
	
	@Value( "${mail.from.email}" )
	private String mailSenderEmail;
	
	@Value( "${mail.from.personal}" )
	private String mailSenderPersonal;
	
	@Value( "${mail.to.email}" )
	private String mailToEmail;
	
	@Value( "${mail.coupon.exchange.mobile.text}" )
	private String mailText;
	
	@Override
	public List<Coupon> listAllCouponByType(int couponType, int userId) {
		WeUser user = userRepo.findOne(userId);
		int userType = user.getType();
		UserPointSummary summary = userPointSummaryRepo.findByUserId(userId);
		int availablePoint = summary.getAvailablePoint();
		List<Coupon> coupons = couponRepo.findByType(couponType);
		for(Coupon coupon : coupons){
			if(availablePoint >= coupon.getCostPoint() && isContained(coupon.getUserType(), userType)){
				coupon.setAvailable(true);
			}else{
				coupon.setAvailable(false);
			}
		}
		return coupons;
	}

	private boolean isContained(String userTypes, int userType){
		String[] types = StringUtils.split(userTypes, ",");
		for(String type : types){
			if(Integer.parseInt(type) == userType){
				return true;
			}
		}
		return false;
	}
	
	@Override
	@Transactional
	public ExchangeCouponResult exchangeCoupon(int userId, int couponId, Map<String, String> extraParams) {
		ExchangeCouponResult result = new ExchangeCouponResult();
		result.setResultCode(0);
		Coupon coupon = couponRepo.findOne(couponId);
		UserPointSummary summary = userPointSummaryRepo.findByUserId(userId);
		int availablePoint = summary.getAvailablePoint();
		int costPoint = coupon.getCostPoint();
		if(costPoint > availablePoint){
			result.setResultMessage("您的积分点数不足够");
		}else{
			String resultMessage = "兑换成功";
			UserCoupon uc = newCoupon(couponId, userId);
			if(coupon.getType() == Coupon.COUPON_TYPE_MOBILE_FEE){
				uc.setUsed(true);
				Date usedDate = new Date();
				uc.setUsedDate(usedDate);
				userCouponRepo.save(uc);
				Sales s = salesRepo.findByUserId(userId);
				sendExchangeMobileFeeCouponNotification(s.getId(), usedDate, coupon.getMemo(), uc.getCouponNumber(), extraParams);
				resultMessage += ", 充值金额将于两个工作日内冲入指定的手机号";
			}
			summary.setAvailablePoint(availablePoint - costPoint);
			result.setAvailablePoint(summary.getAvailablePoint());
			userPointSummaryRepo.save(summary);
			result.setResultMessage(resultMessage);
			result.setResultCode(1);
			int availableCouponCount = userCouponRepo.findAvailableCouponCountByUserId(userId).intValue();
			result.setAvailableCouponCount(availableCouponCount);
		}
		return result;
	}
	
	@Override
	@Transactional
	public UserCoupon newCoupon(int couponId, int userId){
		UserCoupon tmpUC = null;
		String couponNumber = null;
		do{
			couponNumber = RandomStringUtils.random(8, Constants.RANDOM_CHAR_SET);
			tmpUC = userCouponRepo.findByCouponNumber(couponNumber);
		}while(tmpUC != null);
		UserCoupon uc = new UserCoupon();
		uc.setCouponId(couponId);
		uc.setCouponNumber(couponNumber);
		uc.setCreateDate(new Date());
		uc.setUserId(userId);
		uc.setStatus(Coupon.COUPON_STATUS_AVAILABLE);//状态置为可用
		userCouponRepo.save(uc);
		logger.info("user [" + userId + "] got coupon [" + couponId +"][" + couponNumber + "]");
		return uc;
	}
	
	private void sendExchangeMobileFeeCouponNotification(int salesId, Date usedDate, String couponMemo, 
			String couponNumber, Map<String, String> extraParams){
		try{
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(mailSenderEmail, mailSenderPersonal);
			helper.setTo(StringUtils.split(mailToEmail, ","));
			helper.setSubject("话费兑换通知");
			SalesInfo salesInfo =salesRepo.getSalesInfo(salesId);
			String formattedMailText = String.format(mailText, salesInfo.getBranch(), salesInfo.getRegion(), salesInfo.getName(),
					usedDate, couponMemo, salesInfo.getUsername(), couponNumber, extraParams.get("mobile"));
			helper.setText(formattedMailText);
			mailSender.send(message);
		}catch(Exception e){
			logger.error("Send email ", e);
		}
	}

	@Override
	public int getUserAvailableCouponCount(int userId){
		BigInteger bigCount = userCouponRepo.findAvailableCouponCountByUserId(userId);
		return bigCount.intValue();
	}
	
	@Override
	public List<UserCoupon> listUserCoupon(int userId, boolean used) {
		List<UserCoupon> coupons = userCouponRepo.findByUsedAndUserId(used, userId);
		for(UserCoupon uc : coupons){
			Coupon coupon = couponRepo.findOne(uc.getCouponId());
			uc.setCouponName(coupon.getName());
		}
		return coupons;
	}
	
	@Override
	public CouponInfo getCouponInfo(String couponNumber){
		CouponInfo couponInfo = null;
		UserCoupon uc = userCouponRepo.findByCouponNumber(couponNumber);
		if(uc != null){
			couponInfo = new CouponInfo();
			int userId = uc.getUserId();
			Sales sales = salesRepo.findByUserId(userId);
			int couponId = uc.getCouponId();
			Coupon coupon = couponRepo.findOne(couponId);

			if(sales != null) {
				SalesInfo salesInfo = salesRepo.getSalesInfo(sales.getId());
				couponInfo.setBranchName(salesInfo.getBranch());
				couponInfo.setCouponNumber(uc.getCouponNumber());
				couponInfo.setCreateDate(uc.getCreateDate());
				couponInfo.setRegionName(salesInfo.getRegion());
				couponInfo.setSalesName(salesInfo.getName());
				couponInfo.setUsed(uc.isUsed());
				couponInfo.setUsedDate(uc.getUsedDate());
				couponInfo.setMemo(coupon.getMemo());
			}
			couponInfo.setAmount(coupon.getAmount());
		}
		return couponInfo;
	}
	
	@Override
	public List<CouponInfo> listCouponInfoByUserId(int userId){
		List<UserCoupon> ucs = userCouponRepo.findByStatusAndUserId(1, userId);//查询状态等于1 的未使用的
		List<CouponInfo> cis = new ArrayList<CouponInfo>(ucs.size());
		for(UserCoupon uc : ucs){
			CouponInfo couponInfo = new CouponInfo();
			int couponId = uc.getCouponId();
			Coupon coupon = couponRepo.findOne(couponId);
			couponInfo.setMemo(coupon.getMemo());
			couponInfo.setCouponNumber(uc.getCouponNumber());
			couponInfo.setName(coupon.getName());
			couponInfo.setAmount(coupon.getAmount());
			cis.add(couponInfo);
		}
		return cis;
	}

	@Override
	@Transactional
	public int useCoupon(String couponNumber) {
		UserCoupon uc = userCouponRepo.findByCouponNumber(couponNumber);
		//1:成功使用, 2:不存在, 3:已使用, 4:未知错误
		int flag = 4;
		if(uc != null){
			if(!uc.isUsed()){
				uc.setUsed(true);
				uc.setUsedDate(new Date());
				userCouponRepo.save(uc);
				flag = 1;
			}else{
				flag = 3;
			}
		}else{
			flag = 2;
		}
		return flag;
	}
	
	@Override
	@Transactional
	//1:成功使用, 2:不存在, 3:无法改变状态, 4:状态无效, 5:未知错误
	public int updateCouponStatus(String couponNumber, int status) {
		UserCoupon uc = userCouponRepo.findByCouponNumber(couponNumber);
		return userCouponRepo.updateCouponStatus(uc, status);
	}

	@Override
	@Transactional(readOnly=true)
	public Coupon getCouponByName(String couponName) {
		List<Coupon> coupons = couponRepo.findByName(couponName);
		if(coupons != null && coupons.size() > 0){
			return coupons.get(0);
		}else{
			return null;
		}
	}
	
}
