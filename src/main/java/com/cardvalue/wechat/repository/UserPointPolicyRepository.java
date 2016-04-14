package com.cardvalue.wechat.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.cardvalue.wechat.model.UserPointPolicy;

public interface UserPointPolicyRepository extends Repository<UserPointPolicy, Long>{

	@Query(value="select * from user_point_policy where user_type=:userType and action=:action and (level=0 or level=:level)", nativeQuery=true)
	public UserPointPolicy findByUserTypeAndActionAndLevel(@Param("userType") int userType, @Param("action") int action, @Param("level") int level);
	
}