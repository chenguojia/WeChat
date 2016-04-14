package com.cardvalue.wechat.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cardvalue.wechat.model.MessageRule;

@Repository(value = "messageRuleRepository")
public interface MessageRuleRepository extends CrudRepository<MessageRule, Integer>,MessageRuleRepositoryCustom{
	
	@Query("from MessageRule r order by r.priority")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<MessageRule> listAll();
	
}