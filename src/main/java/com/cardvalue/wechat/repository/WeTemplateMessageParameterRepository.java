package com.cardvalue.wechat.repository;

import com.cardvalue.wechat.model.WeResident;
import com.cardvalue.wechat.model.WeTemplateMessageParameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "weTemplateMessageParameterRepository")
public interface WeTemplateMessageParameterRepository extends CrudRepository<WeTemplateMessageParameter, Integer> {
	
	public List<WeTemplateMessageParameter> findByTempId(Integer tempId);

}
