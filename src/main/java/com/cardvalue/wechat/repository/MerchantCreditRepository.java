package com.cardvalue.wechat.repository;

import org.springframework.data.repository.CrudRepository;

import com.cardvalue.wechat.model.MerchantCredit;

public interface MerchantCreditRepository extends CrudRepository<MerchantCredit, Long>, MerchantCreditRepositoryCustom{
	
    
}
