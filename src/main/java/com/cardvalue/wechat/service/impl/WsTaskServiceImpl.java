package com.cardvalue.wechat.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.cardvalue.www.ArrResponse;
import cn.cardvalue.www.SoapGetAppsCategoryRequest;
import cn.cardvalue.www.SoapGetAppsRequest;

import com.cardvalue.wechat.dto.KeyMerchantDTO;
import com.cardvalue.wechat.dto.TaskGroup;
import com.cardvalue.wechat.model.Leads;
import com.cardvalue.wechat.model.Task;
import com.cardvalue.wechat.service.TaskService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.CrmWsServiceUtils;
import com.cardvalue.wechat.util.PageableResult;

@Service
public class WsTaskServiceImpl implements TaskService{

	private final static Logger logger = LoggerFactory.getLogger(WsTaskServiceImpl.class);
	
	@Resource
	private CrmWsServiceUtils serviceUtils;
	
	@Resource
	private DozerBeanMapper beanMapper;

	@Override
	public Task convertLeadsToTask(Leads l) {
		return null;
	}

	@Override
	public List<TaskGroup> listTaskGroups(int userId) {
		SoapGetAppsCategoryRequest request = new SoapGetAppsCategoryRequest();
		List<TaskGroup> taskGroups = null;
		try{
			serviceUtils.setAutheticateInfo(request, Constants.USER_TYPE_UMS_SALES);
			serviceUtils.setAutheticateParams(request, userId);
			ArrResponse response = serviceUtils.getServiceStub().soapGetAppsCategory(request);
			if(response != null && response.getCode().equals("1")){
				taskGroups = new ArrayList<TaskGroup>();
				String data = response.getData();
				ObjectMapper mapper = new ObjectMapper();
				List<Map<String, String>> list = mapper.readValue(data, ArrayList.class);
				if(list != null){
					for(Map<String, String> map : list){
						taskGroups.add(beanMapper.map(map, TaskGroup.class));
					}
				}
			}
		}catch(Exception e){
			logger.error("Error occurs while calling ws to list task group", e);
		}
		return taskGroups;
	}

	@Override
	public PageableResult<List<Map<String, String>>> listTaskByGroup(int userId, String group,int pageNum, int pageSize) {
		SoapGetAppsRequest request = new SoapGetAppsRequest();
		List<Task> taskList = null;
		PageableResult result = null;
		try{
			serviceUtils.setAutheticateInfo(request, Constants.USER_TYPE_UMS_SALES);
			serviceUtils.setAutheticateParams(request, userId);
			request.setStatus(group);
			//设置分页参数
			request.setPageNum(String.valueOf(pageNum));
			request.setPageSize(String.valueOf(pageSize));
			ArrResponse response = serviceUtils.getServiceStub().soapGetApps(request);
			if(response != null && response.getCode().equals("1")){
				taskList = new ArrayList<Task>();
				ObjectMapper mapper = new ObjectMapper();
				result =  mapper.readValue(response.getData(), PageableResult.class);
				//获取结果集
				List<Map<String, String>> resultData = (List<Map<String, String>>)result.getPayload();
				if(resultData != null){
					for(Map<String, String> map : resultData){
						taskList.add(beanMapper.map(map, Task.class));
					}
				}
				result.setPayload(taskList);
			}
		}catch(Exception e){
			logger.error("Error occurs while calling ws to list task", e);
		}
		return result;
	}

	@Override
	public Task getTask(int userId, int id) {
		SoapGetAppsRequest request = new SoapGetAppsRequest();
		Task task = null;
		try{
			serviceUtils.setAutheticateInfo(request, Constants.USER_TYPE_UMS_SALES);
			serviceUtils.setAutheticateParams(request, userId);
			request.setApp_id(String.valueOf(id));
			ArrResponse response = serviceUtils.getServiceStub().soapGetApps(request);
			if(response != null && response.getCode().equals("1")){
				ObjectMapper mapper = new ObjectMapper();
				List<Map<String,String>> result =  mapper.readValue(response.getData(), List.class);
				if(result != null && result.size() > 0){
					task = beanMapper.map(result.get(0), Task.class);
				}
			}
		}catch(Exception e){
			logger.error("Error occurs while calling ws to list task", e);
		}
		return task;
	}
	
}
