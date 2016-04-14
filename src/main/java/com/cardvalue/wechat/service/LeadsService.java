package com.cardvalue.wechat.service;

import java.util.List;

import com.cardvalue.wechat.dto.LeadsStatus;
import com.cardvalue.wechat.dto.LeadsUpdate;
import com.cardvalue.wechat.dto.UpdateApply;
import com.cardvalue.wechat.model.Leads;
import com.cardvalue.wechat.util.PageableResult;
import com.cardvalue.wechat.util.Result;

public interface LeadsService {

	public Result<?> create(Leads leads, int userId);
	
	public List<LeadsStatus> listInAllStatus(int userId);
	
	public PageableResult listInStatus(int userId, String status, int page, int row);
	
	public PageableResult listAll(int userId);
	
	public Leads getLeads(int userId, int id, boolean view);
	
	public void update(LeadsUpdate updateDTO, int userId);

	public long getUpdatedLeadsCount(int userId);
	
	public boolean isRepeated(String mid);

	public void update(UpdateApply updateDTO);
}
