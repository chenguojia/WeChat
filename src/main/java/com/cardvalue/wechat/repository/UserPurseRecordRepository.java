package com.cardvalue.wechat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cardvalue.wechat.model.UserPurseRecord;

public interface UserPurseRecordRepository extends CrudRepository<UserPurseRecord, Long>{

	@Query(value="SELECT * FROM user_purse_record WHERE user_id=:userId AND create_date > (NOW() - INTERVAL 1 MONTH)", nativeQuery=true)
	public List<UserPurseRecord> listPurseRecord(@Param("userId") int userId);
	
}
