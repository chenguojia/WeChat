package com.cardvalue.wechat.service;

import java.util.List;

import com.cardvalue.wechat.dto.AroundMerchantDTO;
import com.cardvalue.wechat.util.PageableResult;

public interface AroundMerchantService {

	PageableResult<List<AroundMerchantDTO>> getAroundMerchants(String processorId, double lat, double lng, int range, String sortField, String sortType);

	PageableResult<List<AroundMerchantDTO>> getAroundMerchants(String processorId, double lat, double lng);

	PageableResult<List<AroundMerchantDTO>> getAroundMerchants(String processorId, double lat, double lng, int range, String sortField, String sortType, int curPage, int pageSize);

}
