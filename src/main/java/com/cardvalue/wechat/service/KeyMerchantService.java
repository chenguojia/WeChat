package com.cardvalue.wechat.service;

import java.util.List;

import com.cardvalue.wechat.dto.KeyMerchantDTO;
import com.cardvalue.wechat.model.Parameter;
import com.cardvalue.wechat.util.PageableResult;

public interface KeyMerchantService {

	PageableResult<?> findByUserId(int userId, String name, String processorId, int pageNum, int pageSize);
	
	List<KeyMerchantDTO> findByMid(String mid);
	
	boolean isKeyMerchant(String mid);
	
	/**
	 * 通过传入的人的processorId分析其角色，查询权限范围内的processorIds
	 * @param processorId
	 * @return
	 */
	public List<Parameter> queryProcessorIds(String processorId);
}
