package com.cardvalue.wechat.repository;

import org.springframework.data.repository.CrudRepository;

import com.cardvalue.wechat.model.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Integer>, UserInfoRepositoryCustom{
	
	public UserInfo findByUserId(Integer userId);
	
}
