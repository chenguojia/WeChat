package com.cardvalue.wechat.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.axis2.databinding.types.soapencoding.Array;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cardvalue.wechat.dto.KeyMerchantDTO;
import com.cardvalue.wechat.model.Parameter;
import com.cardvalue.wechat.model.ReferrerLink;
import com.cardvalue.wechat.repository.KeyMerchantRepository;
import com.cardvalue.wechat.repository.MerchantRepository;
import com.cardvalue.wechat.repository.ReferrerLinkRepository;
import com.cardvalue.wechat.service.KeyMerchantService;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.PageableResult;

@Service
public class KeyMerchantServiceImpl implements KeyMerchantService{

	private final static Logger logger = LoggerFactory.getLogger(KeyMerchantServiceImpl.class);

	@Resource
	private KeyMerchantRepository keyMerchantRepo;
	
	@Resource
	private MerchantRepository merchantRepo;
	
	@Resource
	private ReferrerLinkRepository referrerLinkRepo;
	
	@Resource
	private UtilityService utilityService;
	
	@Override
	public PageableResult<List<KeyMerchantDTO>> findByUserId(int userId, String name, String processorId, int pageNum, int pageSize) {
		logger.debug("findByUserId...");
		PageableResult<List<KeyMerchantDTO>> result = keyMerchantRepo.findByUserId(userId, name,processorId, pageNum, pageSize);
		List<KeyMerchantDTO> keyMerchants = result.getPayload();
		for(KeyMerchantDTO keyMerchant : keyMerchants){
			if(StringUtils.equals(keyMerchant.getStatusLabel(), "未开发")){
				List<ReferrerLink> links = referrerLinkRepo.findLinkByMid(keyMerchant.getMid());
				if(links.size() > 0){
					keyMerchant.setStatusLabel("已发短信");
				}
			}
		}
		return result;
	}

	@Override
	public List<KeyMerchantDTO> findByMid(String mid) {
		return keyMerchantRepo.findByMid(mid);
	}

	@Override
	public boolean isKeyMerchant(String mid) {
		int count = keyMerchantRepo.countByMid(mid);
		return (count > 0);
	}
	
	@Override
	public List<Parameter> queryProcessorIds(String processorId){
		
		List<Parameter> processorIds = null;
		
		if(processorId.equals("331")){
			//表示是卡得万利员工，查询所有processorId
			processorIds = utilityService.getParamsByGroup(Constants.PARAM_GROUP_PROCESSOR_ID);
		}else{
			//表示表示是卡得万利员工，查询指定的processorId
			Parameter parameter = utilityService.getParamByValueAndGroup(Constants.PARAM_GROUP_PROCESSOR_ID, processorId);
			processorIds = new ArrayList<Parameter>();
			processorIds.add(parameter);
		}
		
		return processorIds;
	}
	
}
