package com.cardvalue.wechat.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.cardvalue.wechat.model.MerchantAddress;

public interface MerchantAddressRepository extends Repository<MerchantAddress, Long> {
	
	@Query("SELECT mb FROM MerchantAddress mb WHERE mb.number=:number and mb.subCode=:subCode")
	public MerchantAddress findOneByNumber(@Param("number") String number, @Param("subCode") String subCode);
	
}
