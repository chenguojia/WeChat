package com.cardvalue.wechat.repository;

import com.cardvalue.wechat.util.PageableResult;

public interface KeyMerchantRepositoryCustom {

	public PageableResult findByUserId(int userId, String term, int pageNum, int pageSize);

	public int countByMid(String mid);

	public void updateKeyMerchantUserRel(String username, String mid, String subNo, String province);

}