package com.cardvalue.wechat.repository;


public interface TaskRepositoryCustom {
	public long getCountInPhase(int phase, int userId);
	public long getUrgentCount(int userId);
	public long getCount(int userId);
}
