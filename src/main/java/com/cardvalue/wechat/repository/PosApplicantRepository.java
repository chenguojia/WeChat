package com.cardvalue.wechat.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cardvalue.wechat.model.PosApplicant;

public interface PosApplicantRepository extends CrudRepository<PosApplicant, Integer>{

	public List<PosApplicant> findByUserId(int userId);
	
	public List<PosApplicant> findByPrefecture(String prefecture);	
	
}
