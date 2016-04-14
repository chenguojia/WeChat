package com.cardvalue.wechat.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cardvalue.wechat.model.UserCoupon;

public interface UserCouponRepository extends CrudRepository<UserCoupon, Long>, UserCouponRepositoryCustom{

	public List<UserCoupon> findByUsedAndUserId(boolean used, int userId);

	public List<UserCoupon> findByStatusAndUserId(int status, int userId);
	
	@Query(value="select ifnull(count(*), 0) from user_coupon where user_id=:userId and used=false", nativeQuery=true)
	public BigInteger findAvailableCouponCountByUserId(@Param("userId") int userId);
	
	public UserCoupon findByCouponNumber(String couponNumber);
	
}
