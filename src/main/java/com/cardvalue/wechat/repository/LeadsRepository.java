package com.cardvalue.wechat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cardvalue.wechat.model.Leads;

public interface LeadsRepository extends CrudRepository<Leads, Integer>, LeadsRepositoryCustom{
	
	@Query("from Leads where status=:status and userId=:userId order by merchantIntention, feedbackDate")
	public List<Leads> findByStatusAnduserId(@Param("status")int status, @Param("userId")int userId);
	
	@Query("from Leads where userId=:userId order by updated desc, createDate")
	public List<Leads> findByUserId(@Param("userId")int userId);
	
}
