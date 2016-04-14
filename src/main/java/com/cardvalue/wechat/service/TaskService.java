package com.cardvalue.wechat.service;

import java.util.List;
import java.util.Map;

import com.cardvalue.wechat.dto.TaskGroup;
import com.cardvalue.wechat.model.Leads;
import com.cardvalue.wechat.model.Task;
import com.cardvalue.wechat.util.PageableResult;

public interface TaskService {
	
	public Task getTask(int userId, int id);
	
	public Task convertLeadsToTask(Leads l);
	
	public List<TaskGroup> listTaskGroups(int userId);
	
	public PageableResult<List<Map<String, String>>> listTaskByGroup(int userId, String group,int pageNum, int pageSize);

}
