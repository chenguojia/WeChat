package com.cardvalue.wechat.repository;

import org.springframework.data.repository.CrudRepository;

import com.cardvalue.wechat.model.WeUser;

public interface UserRepository extends CrudRepository<WeUser, Integer>, UserRepositoryCustom{
	
	public WeUser findByOpenId(String openId);
	
	public WeUser findByUsername(String username);
	
	public WeUser findById(int id);

	public WeUser findByUsernameAndPassword(String username,String password);
	
}
