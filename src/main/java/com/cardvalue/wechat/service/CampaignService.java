package com.cardvalue.wechat.service;

import com.cardvalue.wechat.dto.DrawRequestDTO;
import com.cardvalue.wechat.dto.DrawResponseDTO;

public interface CampaignService {

	public void dailyBatch();

	void dailyMorningReport();

	void dailyEveningReport();
	
	void addExtraDrawCount();

	int getRotaryCount(int userId);

	int modifyRotaryCount(int userId, int mCount);

	DrawResponseDTO drawRotary(DrawRequestDTO request);

}
