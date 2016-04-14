package com.cardvalue.wechat.repository;

import org.springframework.data.repository.CrudRepository;

import com.cardvalue.wechat.model.UserPointSummary;

public interface UserPointSummaryRepository extends CrudRepository<UserPointSummary, Long>{
	
	public UserPointSummary findByUserId(int userId);
	
}
