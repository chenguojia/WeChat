package com.cardvalue.wechat.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import com.cardvalue.wechat.model.Parameter;

public interface ParamRepository extends JpaRepository<Parameter, Integer>{
	
	@Query("from Parameter p where p.group=:group and p.status=1 order by order,id")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Parameter> findByGroup(@Param("group") String group);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Parameter findByGroupAndValue(String group, String value);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Parameter findByGroupAndName(String group, String name);
}
