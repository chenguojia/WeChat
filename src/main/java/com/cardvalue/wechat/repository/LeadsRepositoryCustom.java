package com.cardvalue.wechat.repository;

import com.cardvalue.wechat.dto.MerchantApplyDTO;

public interface LeadsRepositoryCustom {
	public long getCountInStatus(int status, int userId);
	public long getCount(int userId);
	public void merchantApply(MerchantApplyDTO dto);
	public long getUpdatedLeadsCount(int userId);
	public long getUpdatedLeadsCountInStatus(int userId, int status);
	public boolean isRepeated(String mid);
}
