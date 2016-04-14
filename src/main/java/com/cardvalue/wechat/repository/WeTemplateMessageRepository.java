package com.cardvalue.wechat.repository;

import com.cardvalue.wechat.model.WeResident;
import com.cardvalue.wechat.model.WeTemplateMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "weTemplateMessageRepository")
public interface WeTemplateMessageRepository extends CrudRepository<WeTemplateMessage, Integer> {
	
	public List<WeTemplateMessage> findByName(String name);

	public WeTemplateMessage findById(Integer id);

	public List<WeTemplateMessage> findByNumber(String number);

	public List<WeTemplateMessage> findByIdentifer(String identifer);

}
