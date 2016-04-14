package com.cardvalue.wechat.service;

import java.util.List;

import com.cardvalue.wechat.model.PosApplicant;
import com.cardvalue.wechat.util.Result;

public interface PosApplicantService {

	public PosApplicant findOne(int id);
	
	public List<PosApplicant> findByUserId(int userId);
	
	public List<PosApplicant> findByPrefecture(String prefecture);
	
	public int countByPrefecture(int userId);
	
	public Result<?> claim(int userId, int applicantId);
}
