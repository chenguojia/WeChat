package com.cardvalue.wechat.repository.jpa;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cardvalue.wechat.model.Coupon;
import com.cardvalue.wechat.model.UserCoupon;
import com.cardvalue.wechat.repository.UserCouponRepositoryCustom;

public class UserCouponRepositoryImpl implements UserCouponRepositoryCustom{

	private final static Logger logger = LoggerFactory.getLogger(UserCouponRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	private final static int[] COUPON_STATUSES = {Coupon.COUPON_STATUS_AVAILABLE,Coupon.COUPON_STATUS_ACTIVATED,Coupon.COUPON_STATUS_USED};
	
	@Override
	public int updateCouponStatus(UserCoupon uc, int status) {
		int flag = 5;
		logger.info("update coupon with status " + status);
		if(Arrays.binarySearch(COUPON_STATUSES, status) >= 0){
			if(uc != null){
				logger.info("coupon number is " + uc.getCouponNumber());
				if(allowUpdate(uc.getStatus(), status)){
					uc.setStatus(status);
					if(status == 3){
						uc.setUsed(true);
						uc.setUsedDate(new Date());
					}
					em.persist(uc);
					flag = 1;
				}else{
					flag = 3;
				}
			}else{
				flag = 2;
			}
		}else{
			flag = 4;
		}
		logger.info("update coupon with status " + status + ", return flag:" + flag);
		return flag;
	}
	
	private boolean allowUpdate(int sStatus, int tStatus){
		if(sStatus == tStatus){
			return true;
		}else{
			if(sStatus == 1 && tStatus == 2){
				return true;
			}else if(sStatus == 2 && tStatus == 1){
				return true;
			}else if(sStatus == 2 && tStatus == 3){
				return true;
			}else{
				return false;
			}
		}
	}

}
