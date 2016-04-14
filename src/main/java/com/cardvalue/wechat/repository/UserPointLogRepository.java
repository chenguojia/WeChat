package com.cardvalue.wechat.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cardvalue.wechat.model.UserPointLog;

public interface UserPointLogRepository extends CrudRepository<UserPointLog, Long>{

	@Query(value="select ifnull(sum(point),0) from user_point_log where user_id=:userId and action=:action and Date(create_date)=Date(:date)", nativeQuery=true)
	public BigDecimal getDailyTotalPointByUserAndAction(@Param("userId") int userId, @Param("action") int action, @Param("date") Date date); 
	
	@Query(value="select count(*) from user_point_log where user_id=:userId and action=:action and Date(create_date)=Date(:date)", nativeQuery=true)
	public BigInteger getDailyTimesPointByUserAndAction(@Param("userId") int userId, @Param("action") int action, @Param("date") Date date); 

	@Query(value="select count(*) from user_point_log where factoring_no=:factoringNo", nativeQuery=true)
	public BigInteger getCountByFactoringNo(@Param("factoringNo") String factoringNo);
}
