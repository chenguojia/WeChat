package com.cardvalue.wechat.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cardvalue.wechat.dto.RemoteAddMerchantDTO;
import com.cardvalue.wechat.model.ReferrerLink;

@Repository
public interface ReferrerLinkRepository {

	public ReferrerLink create(int referrerId, RemoteAddMerchantDTO dto);
	
	public ReferrerLink create(int referrerId, String mid);
	
	public ReferrerLink clone(long linkId);
	
	public ReferrerLink findLinkByShortKey(String key);
	
	public ReferrerLink findById(long id);
	
	public void valid(long id);
	
	public ReferrerLink attachOpenId(long id, String openId);

	public int removeExpiredLinks();

	public List<ReferrerLink> findLinkByMid(String mid);
}
