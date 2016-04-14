package com.cardvalue.wechat.repository;

import org.springframework.data.repository.CrudRepository;

import com.cardvalue.wechat.model.Sales;

public interface SalesRepository extends CrudRepository<Sales, Integer>, SalesRepositoryCustom {
	
	public Sales findByUserId(int userId);
	
}
