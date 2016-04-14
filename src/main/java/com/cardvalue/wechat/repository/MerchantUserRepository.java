package com.cardvalue.wechat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cardvalue.wechat.model.Merchant;
import com.cardvalue.wechat.model.MerchantUser;
import com.cardvalue.wechat.model.WeUser;

public interface MerchantUserRepository extends CrudRepository<MerchantUser, Integer>{
	
	@Query("select mu.merchant from MerchantUser mu where mu.user=:user")
	public List<Merchant> findMerchantByUser(@Param("user") WeUser user);
	
	@Query("select mu.user from MerchantUser mu where mu.merchant=:merchant")
	public List<WeUser> findUserByMerchant(@Param("merchant") Merchant merchant);
	
}
