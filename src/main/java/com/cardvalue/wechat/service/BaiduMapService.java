package com.cardvalue.wechat.service;

import java.util.List;
import java.util.Map;

import com.cardvalue.wechat.util.Result;

public interface BaiduMapService {

	Result<List<Map<String, Double>>> convertCoordinators(List<Map<String, Double>> coordinatorList);

	Result<Map<String, Double>> convertCoordinators(Map<String, Double> coordinator);
	
}
