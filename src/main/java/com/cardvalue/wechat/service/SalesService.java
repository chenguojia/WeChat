package com.cardvalue.wechat.service;

import com.cardvalue.wechat.model.Sales;

public interface SalesService {

	public Sales findSalesByNumber(String number);
	
}
