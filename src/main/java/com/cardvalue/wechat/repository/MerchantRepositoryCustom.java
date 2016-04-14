package com.cardvalue.wechat.repository;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.cardvalue.wechat.dto.MerchantRegisterDTO;
import com.cardvalue.wechat.model.AddKeyMerchantDetailDTO;
import com.cardvalue.wechat.model.AddKeyMerchantSummaryDTO;
import com.cardvalue.wechat.model.Sales;
import com.cardvalue.wechat.model.WeUser;


public interface MerchantRepositoryCustom {
	
	public int create(MerchantRegisterDTO dto, Sales sales);
	
	public void authorize(int merchantId);

	public List<AddKeyMerchantSummaryDTO> listAddKeyMerchantSummary();

	public List<AddKeyMerchantDetailDTO> listAddKeyMerchantDetail();
	
	/**
	 * 只添加商户不添加用户
	 * @param dto
	 * @param sales
	 * @param user
	 * @param session
	 * @return
	 */
	public int create(MerchantRegisterDTO dto, Sales sales,WeUser user,HttpSession session);
	
}
