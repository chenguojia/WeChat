package com.cardvalue.wechat.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cardvalue.wechat.dto.LeadsStatus;
import com.cardvalue.wechat.dto.LeadsUpdate;
import com.cardvalue.wechat.dto.UpdateApply;
import com.cardvalue.wechat.model.Leads;
import com.cardvalue.wechat.model.Parameter;
import com.cardvalue.wechat.repository.LeadsRepository;
import com.cardvalue.wechat.repository.ParamRepository;
import com.cardvalue.wechat.repository.SalesRepository;
import com.cardvalue.wechat.repository.UtilRepository;
import com.cardvalue.wechat.service.LeadsService;
import com.cardvalue.wechat.service.LogService;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.PageableResult;
import com.cardvalue.wechat.util.Result;

@Service
public class DbLeadsServiceImpl implements LeadsService {

	@Resource
	private LeadsRepository leadsRepository;
	
	@Resource
	private UtilityService utilityService;
	
	@Resource
	private ParamRepository paramRepository;
	
	@Resource
	private SalesRepository salesRepo;
	
	@Resource
	private UtilRepository utilRepo;
	
	@Resource
	private LogService logService;
	
	@Override
	@Transactional
	public Result<Object> create(Leads leads, int userId) {
		String seqNumber = utilityService.generateSequenceNumber(Constants.TYPE_LEADS);
		leads.setNumber(seqNumber);
		leads.setCreateDate(new Date());
		setLeadsFields(leads);
		leadsRepository.save(leads);
		logService.insertActionLog(Constants.ACTION_CREATE_LEADS, leads.getUserId(), null, leads.toString());
		Result<Object> result = new Result<Object>();
		return result;
	}

	@Transactional
	@Override
	public void update(LeadsUpdate updateDTO, int userId) {
		Leads leads = leadsRepository.findOne(updateDTO.getId());
		BeanUtils.copyProperties(updateDTO, leads);
		leads.setContactMobile(updateDTO.getContactMobile());
		setLeadsFields(leads);
		leadsRepository.save(leads);
	}

	@Transactional
	public void update(UpdateApply updateDTO) {
		Leads leads = leadsRepository.findOne(updateDTO.getId());
		BeanUtils.copyProperties(updateDTO, leads);
		leadsRepository.save(leads);
	}
	
	@Override
	public List<LeadsStatus> listInAllStatus(int userId) {
		List<LeadsStatus> list = new ArrayList<LeadsStatus>();
		//待跟进线索(status=3)
		LeadsStatus followStatus = getStatusCount(userId, 3);
		list.add(followStatus);
		//处理中线索(status=4)
		LeadsStatus processingStatus = getStatusCount(userId, 4);
		list.add(processingStatus);		
		//成功线索(status=1)
		LeadsStatus successStatus = getStatusCount(userId, 1);
		list.add(successStatus);
		//失败线索(status=2)
		LeadsStatus failedStatus = getStatusCount(userId, 2);
		list.add(failedStatus);
		//全部线索
		long allCount = leadsRepository.getCount(userId);
		LeadsStatus allStatus = new LeadsStatus();
		allStatus.setStatus("");
		allStatus.setCount(allCount);
		allStatus.setStatusLabel("全部线索");
		list.add(allStatus);		
		return list;
	}
	
	@Override
	public PageableResult listInStatus(int userId, String status, int page, int row) {
		List<Leads> list = leadsRepository.findByStatusAnduserId(Integer.parseInt(status), userId);
		for(Leads l : list){
			Parameter intentionParam = paramRepository.findByGroupAndValue(Constants.PARAM_GROUP_MERCHANT_INTENTION, String.valueOf(l.getMerchantIntention()));
			l.setMerchantIntentionLabel(intentionParam.getName());
		}
		PageableResult result = new PageableResult();
		result.setPayload(list);
		return result;
	}
	
	private LeadsStatus getStatusCount(int userId, int status){
		LeadsStatus leadStatus = new LeadsStatus();
		long count = leadsRepository.getCountInStatus(status, userId);
		leadStatus.setCount(count);
		Parameter param = paramRepository.findByGroupAndValue(Constants.PARAM_GROUP_LEADS_STATUS, String.valueOf(status));
		leadStatus.setStatus(param.getValue());
		leadStatus.setStatusLabel(param.getName());
		leadStatus.setUpdateCount(leadsRepository.getUpdatedLeadsCountInStatus(userId, status));
		return leadStatus;
	}

	@Override
	public Leads getLeads(int userId, int id, boolean view) {
		Leads leads = leadsRepository.findOne(id);
		Parameter statusParam = paramRepository.findByGroupAndValue(Constants.PARAM_GROUP_LEADS_STATUS, String.valueOf(leads.getStatus()));
		leads.setStatusLabel(statusParam.getName());
		Parameter intentionParam = paramRepository.findByGroupAndValue(Constants.PARAM_GROUP_MERCHANT_INTENTION, String.valueOf(leads.getMerchantIntention()));
		if(intentionParam != null){
			leads.setMerchantIntentionLabel(intentionParam.getName());
		}
		Parameter taskTypeParam = paramRepository.findByGroupAndValue(Constants.PARAM_GROUP_TASK_TYPE, String.valueOf(leads.getTaskType()));
		leads.setTaskTypeLabel(taskTypeParam.getName());
		Parameter positionParam = paramRepository.findByGroupAndValue(Constants.PARAM_GROUP_CONTACT_POSITION, String.valueOf(leads.getContactPosition()));
		leads.setContactPositionLabel(positionParam.getName());
		if(view && leads.getUpdated() == 1){
			leads.setUpdated(0);
			leadsRepository.save(leads);
		}
		return leads;
	}

	@Override
	public PageableResult<?> listAll(int userId) {
		List<Leads> list = leadsRepository.findByUserId(userId);
		for(Leads l : list){
			Parameter param = paramRepository.findByGroupAndValue(Constants.PARAM_GROUP_LEADS_STATUS, String.valueOf(l.getStatus()));
			l.setStatusLabel(param.getName());
		}
		PageableResult result = new PageableResult();
		result.setPayload(list);
		return result;
	}
	
	private void setLeadsFields(Leads leads){
		int status = 3;
		switch(leads.getMerchantIntention()){
		case 1:	//同意
		case 2:	//考虑
			break;
		case 3: //拒绝
			status = 2;
			break;	
		}
		leads.setStatus(status);
	}
	
	@Override
	public long getUpdatedLeadsCount(int userId){
		long count = 0;
		count = leadsRepository.getUpdatedLeadsCount(userId);
		return count;
	}
	
	@Override
	public boolean isRepeated(String mid){
		return leadsRepository.isRepeated(mid);
	}

}
