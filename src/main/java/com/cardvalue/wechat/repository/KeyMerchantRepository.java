package com.cardvalue.wechat.repository;

import java.util.List;

import com.cardvalue.wechat.dto.KeyMerchantDTO;
import com.cardvalue.wechat.util.PageableResult;

public interface KeyMerchantRepository {

	public List<KeyMerchantDTO> findByMid(String mid);
	
	public List<KeyMerchantDTO> findByProvince(String province);
	
	public List<KeyMerchantDTO> findByProvinceAndPrefecture(String pronvince, String province);
	
	public PageableResult findByUserId(int userId, String term, String processorId, int pageNum, int pageSize);

	public int countByMid(String mid);

	public void updateKeyMerchantUserRel(String username, String mid, String subNo, String province);
	
}
