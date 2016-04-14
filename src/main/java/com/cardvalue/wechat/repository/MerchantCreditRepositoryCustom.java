package com.cardvalue.wechat.repository;

import com.cardvalue.wechat.model.MerchantCredit;

public interface MerchantCreditRepositoryCustom{
	
    public MerchantCredit findByMid(String number, String processorId);
    
}
