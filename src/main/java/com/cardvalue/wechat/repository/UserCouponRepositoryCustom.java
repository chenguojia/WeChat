package com.cardvalue.wechat.repository;

import com.cardvalue.wechat.model.UserCoupon;

public interface UserCouponRepositoryCustom{
	
	int updateCouponStatus(UserCoupon uc, int status);

}
