package com.cardvalue.wechat.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cardvalue.support.ws.AroundMerch;
import com.cardvalue.support.ws.SingleSort;
import com.cardvalue.support.ws.SortField;
import com.cardvalue.support.ws.SortType;
import com.cardvalue.support.ws.WsSearchAroundMerchRequest;
import com.cardvalue.support.ws.impl.AroundMerchWSServiceImplPortBindingStub;
import com.cardvalue.wechat.dto.AroundMerchantDTO;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.service.AroundMerchantService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.PageableResult;

@Service
public class AroundMerchantServiceWsImpl implements AroundMerchantService{

	private final static Logger logger = LoggerFactory.getLogger(AroundMerchantServiceWsImpl.class);
	
	@Resource
	private AroundMerchWSServiceImplPortBindingStub aroundMerchServiceStub;
	
	@Resource
	private UserRepository userRepo;
	
	@Resource
	private DozerBeanMapper beanMapper;
	
	private final static int DEFAULT_RANGE = 500;
	private final static int DEFAULT_PAGE_NUMBER = 1;
	private final static int DEFAULT_PAGE_SIZE = 10;
	
	@Override
	public PageableResult<List<AroundMerchantDTO>> getAroundMerchants(String processorId, double lat, double lng){
		return getAroundMerchants(processorId, lat, lng, DEFAULT_RANGE, SortField._DISTANCE, SortType._ASC, DEFAULT_PAGE_NUMBER, DEFAULT_PAGE_SIZE);
	}
	
	@Override
	public PageableResult<List<AroundMerchantDTO>> getAroundMerchants(String processorId, double lat, double lng, int range, String sortField, String sortType){
		return getAroundMerchants(processorId, lat, lng, range, sortField, sortType, DEFAULT_PAGE_NUMBER, DEFAULT_PAGE_SIZE);
	}
	
	@Override
	public PageableResult<List<AroundMerchantDTO>> getAroundMerchants(String processorId, double lat, double lng, int range, String sortField, String sortType, int curPage, int pageSize){
		logger.info("start invoking webservice to get around merchants");
		if(StringUtils.equals(Constants.PROCESSOR_ID_CV, processorId)){
			processorId = null;
		}
		PageableResult<List<AroundMerchantDTO>> result = new PageableResult<List<AroundMerchantDTO>>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		WsSearchAroundMerchRequest request = new WsSearchAroundMerchRequest();
		request.setLat(lat);
		request.setLng(lng);
		request.setRange(range);
		request.setCurPage(curPage);
		request.setPageSize(pageSize);
		request.setPId(processorId);
		SingleSort sort = new SingleSort();
		sort.setSortField(SortField.fromString(sortField));
		if(StringUtils.equals(sortField, SortField._AMOUNT)){
			sortType = SortType._DESC;
		}
		sort.setSortType(SortType.fromString(sortType));
		SingleSort[] sorts = new SingleSort[]{sort};
		try {
			AroundMerch[] merchs = aroundMerchServiceStub.getAroundMerchInfo(request, sorts);
			int count = aroundMerchServiceStub.getAroundMerchCount(request.getLat(), request.getLng(), request.getRange(), processorId);
			result.setNumRows(count);
			result.setPageNumber(curPage);
			result.setPageCount((int)Math.ceil((double)count/pageSize));
			result.setPageSize(pageSize);
			List<AroundMerch> aroundMerchants = new ArrayList<AroundMerch>();
			if(merchs != null){
				aroundMerchants = Arrays.asList(merchs);
			}
			result.setPayload(convertAroundMerchList(aroundMerchants));
			result.setCode(Constants.RESULT_CODE_SUCCESS);
		} catch (RemoteException e) {
			logger.error("error occurs while invoking webservice to get around merchants", e);
		}
		return result;
	}
	
	private List<AroundMerchantDTO> convertAroundMerchList(List<AroundMerch> aroundMerchList){
		List<AroundMerchantDTO> dtoList = new ArrayList<AroundMerchantDTO>();
		for(AroundMerch aroundMerch : aroundMerchList){
			dtoList.add(beanMapper.map(aroundMerch, AroundMerchantDTO.class));
		}
		return dtoList;
	}
	
}
