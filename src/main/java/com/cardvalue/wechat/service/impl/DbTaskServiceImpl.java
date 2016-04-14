package com.cardvalue.wechat.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cardvalue.wechat.dto.TaskGroup;
import com.cardvalue.wechat.model.Leads;
import com.cardvalue.wechat.model.Parameter;
import com.cardvalue.wechat.model.Task;
import com.cardvalue.wechat.repository.ParamRepository;
import com.cardvalue.wechat.repository.TaskRepository;
import com.cardvalue.wechat.service.MerchantService;
import com.cardvalue.wechat.service.TaskService;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.PageableResult;

@Service
public class DbTaskServiceImpl implements TaskService {

	@Resource
	private TaskRepository taskRepository;
	
	@Resource
	private UtilityService utilityService;
	
	@Resource
	private ParamRepository paramRepository;
	
	@Resource
	private MerchantService merchantService;
	
	@Override
	public Task getTask(int userId, int id) {
		Task task = taskRepository.findOne(id);
		Parameter phaseParam = paramRepository.findByGroupAndValue(Constants.PARAM_GROUP_TASK_PHASE, String.valueOf(task.getPhase()));
		task.setPhaseLabel(phaseParam.getName());
		Parameter statusParam = paramRepository.findByGroupAndValue(Constants.PARAM_GROUP_TASK_STATUS, String.valueOf(task.getStatus()));
		task.setStatusLabel(statusParam.getName());
		Parameter positionParam = paramRepository.findByGroupAndValue(Constants.PARAM_GROUP_CONTACT_POSITION, String.valueOf(task.getContactPosition()));
		task.setContactPositionLabel(positionParam.getName());
		return task;
	}

	public List<Task> listInterviewTasks(int userId) {
		List<Task> tasks = taskRepository.findInterviewTasks(userId);
		for(int i = 0;i < tasks.size();i++){
			Task task = tasks.get(i);
			Parameter param = paramRepository.findByGroupAndValue(Constants.PARAM_GROUP_TASK_PHASE, String.valueOf(task.getPhase()));
			task.setPhaseLabel(param.getName());
			Parameter statusParam = paramRepository.findByGroupAndValue(Constants.PARAM_GROUP_TASK_STATUS, String.valueOf(task.getStatus()));
			task.setStatusLabel(statusParam.getName());
		}
		return tasks;
	}

	public List<Task> listNormalTasks(int userId, Pageable pageable) {
		List<Task> tasks = taskRepository.findNormalTasks(userId, pageable);
		for(int i = 0;i < tasks.size();i++){
			Task task = tasks.get(i);
			Parameter param = paramRepository.findByGroupAndValue(Constants.PARAM_GROUP_TASK_PHASE, String.valueOf(task.getPhase()));
			task.setPhaseLabel(param.getName());
			Parameter statusParam = paramRepository.findByGroupAndValue(Constants.PARAM_GROUP_TASK_STATUS, String.valueOf(task.getStatus()));
			task.setStatusLabel(statusParam.getName());
		}
		return tasks;
	}

	@Override
	public Task convertLeadsToTask(Leads leads) {
		Task task = new Task();
		String seqNumber = utilityService.generateSequenceNumber(Constants.TYPE_TASK);
		task.setNumber(seqNumber);
		task.setUserId(leads.getUserId());
		task.setCreateTime(new Date());
		task.setContactName(leads.getMerchantContact());
		task.setContactMobile(leads.getContactMobile());
		task.setContactPosition(leads.getContactPosition());
		task.setMerchantNumber(leads.getMerchantNumber());
		task.setSubCode(leads.getSubCode());
		task.setUrgentDegree(Constants.TASK_URGENT_DEGREE_NORMAL);
		task.setPhase(1);
		task.setStatus(1);
		task.setChannel(1);
		return task;
	}

	@Override
	public List<TaskGroup> listTaskGroups(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageableResult<List<Map<String, String>>> listTaskByGroup(int userId, String group,int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
