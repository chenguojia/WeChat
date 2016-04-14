package com.cardvalue.wechat.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cardvalue.wechat.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>, TaskRepositoryCustom{
	
	public List<Task> findByPhaseAndUserId(int phase, int userId);
	
	public List<Task> findByuserId(int userId);
	
	@Query("from Task t where t.userId=:userId and t.phase != 1 order by t.lastUpdateTime")
	public List<Task> findNormalTasks(@Param("userId") int userId, Pageable pageable);
	
	@Query("from Task t where t.userId=:userId and t.phase = 1 order by t.lastUpdateTime")
	public List<Task> findInterviewTasks(@Param("userId") int userId);
}
