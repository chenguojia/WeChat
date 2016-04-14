package com.cardvalue.wechat.service;

public interface RegularService {

	public void dailyReport();
	
	public void monthlyReport();

	public void pointSummaryReport();

	public void unactivatedMerchantReport();

	void addKeyMerchantReport();
	
	public void clearExpiredReferrerLinks();
	
}