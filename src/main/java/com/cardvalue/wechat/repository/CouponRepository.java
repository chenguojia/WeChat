package com.cardvalue.wechat.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cardvalue.wechat.model.Coupon;

public interface CouponRepository extends CrudRepository<Coupon, Integer>{

	public List<Coupon> findByType(int type);
	
	public List<Coupon> findByName(String name);
	
}
