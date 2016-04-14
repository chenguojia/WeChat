package com.cardvalue.wechat.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cardvalue.bofeiran.service.GetPerformanceByUserNumberAndMonth;
import com.cardvalue.bofeiran.service.GetPerformanceByUserNumberAndMonthResponse;
import com.cardvalue.bofeiran.service.SettleService;
import com.cardvalue.bofeiran.service.SettleServiceStub;
import com.cardvalue.wechat.service.PerformanceService;

@Service
public class PerformanceServiceImpl implements PerformanceService {

	private static final Logger logger = LoggerFactory.getLogger(PerformanceServiceImpl.class);
	
	@Value("${ws.performance.endpoint}")
	private String wsEndPoint;
	
	@Override
	public String getPerformanceByUserNumberAndMonth(String userNumber,
			String Month) {
		try {
			SettleService settleService = new SettleServiceStub(wsEndPoint); 
			GetPerformanceByUserNumberAndMonth performance=new GetPerformanceByUserNumberAndMonth();
			performance.setUserNumber(userNumber);
			performance.setMonth(Month);
			GetPerformanceByUserNumberAndMonthResponse response=settleService.getPerformanceByUserNumberAndMonth(performance);
			return response.get_return();
		} catch (Exception e) {
			logger.error("Error occurs when invoking performance service", e);
		}
		return null;
	}

}
