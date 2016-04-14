package com.cardvalue.wechat.service;

import java.util.List;
import java.util.Map;

import com.cardvalue.wechat.dto.CouponInfo;
import com.cardvalue.wechat.dto.ExchangeCouponResult;
import com.cardvalue.wechat.model.Coupon;
import com.cardvalue.wechat.model.UserCoupon;

public interface CouponService {

	public List<Coupon> listAllCouponByType(int couponType, int userId);
	
	public Coupon getCouponByName(String couponName);
	
	public ExchangeCouponResult exchangeCoupon(int userId, int couponId, Map<String, String> extraParams);
	
	public List<UserCoupon> listUserCoupon(int userId, boolean used);

	public int getUserAvailableCouponCount(int userId);

	public CouponInfo getCouponInfo(String couponNumber);
	
	public int useCoupon(String couponNumber);

	public int updateCouponStatus(String couponNumber, int status);

	public UserCoupon newCoupon(int couponId, int userId);

	public List<CouponInfo> listCouponInfoByUserId(int userId);
	
}
