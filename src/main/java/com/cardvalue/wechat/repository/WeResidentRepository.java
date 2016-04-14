package com.cardvalue.wechat.repository;

import com.cardvalue.wechat.model.WeResident;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "weResidentRepository")
public interface WeResidentRepository extends CrudRepository<WeResident, Integer> {
	
	public List<WeResident> findByName(String name);

}
