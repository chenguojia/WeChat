package com.cardvalue.wechat.repository;

import com.cardvalue.wechat.model.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("reportRepository")
public interface ReportRepository extends CrudRepository<Report, Integer>{
	
	public List<Report> findByNameLike(String name);
	
	public Report findById(Integer name);
	
}
