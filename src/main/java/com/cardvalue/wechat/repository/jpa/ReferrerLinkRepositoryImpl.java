package com.cardvalue.wechat.repository.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cardvalue.wechat.dto.RemoteAddMerchantDTO;
import com.cardvalue.wechat.model.ReferrerLink;
import com.cardvalue.wechat.repository.ReferrerLinkRepository;
import com.cardvalue.wechat.util.Utility;

@Repository
@Transactional(readOnly=true)
public class ReferrerLinkRepositoryImpl implements ReferrerLinkRepository {

	private final static Logger logger = LoggerFactory.getLogger(ReferrerLinkRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public ReferrerLink clone(long linkId) {
		ReferrerLink link = em.find(ReferrerLink.class, linkId);
		em.detach(link);
		link.setId(0);
		link.setCreateDate(new Date());
		link.setShortKey(generateShortKey());
		em.persist(link);
		return link;
	}

	@Override
	public ReferrerLink create(int referrerId, RemoteAddMerchantDTO dto) {
		ReferrerLink link = new ReferrerLink();
		link.setReferrerId(referrerId);
		link.setCreateDate(new Date());
		link.setShortKey(generateShortKey());//生成验证码
		link.setValid(true);
		link.setMid(dto.getMid());
		link.setContactName(dto.getContactName());
		link.setContactMobile(dto.getContactMobile());
		link.setContactPosition(dto.getContactPosition());
		em.persist(link);
		return link;
	}

	@Override
	public ReferrerLink findLinkByShortKey(String key) {
		TypedQuery<ReferrerLink> query = em.createQuery("select l from ReferrerLink l where l.shortKey=:shortKey", ReferrerLink.class);
		query.setParameter("shortKey", key);
		ReferrerLink l = null;
		try{
			l = query.getSingleResult();
		}catch(Exception e){
			logger.warn("Cannot find link by shortkey:" + key);
		}
		return l;
	}
	
	@Override
	public List<ReferrerLink> findLinkByMid(String mid) {
		TypedQuery<ReferrerLink> query = em.createQuery("select l from ReferrerLink l where l.mid=:mid", ReferrerLink.class);
		query.setParameter("mid", mid);
		return query.getResultList();
	}
	
	@Override
	public ReferrerLink findById(long id) {
		return em.find(ReferrerLink.class, id);
	}
	
	private String generateShortKey(){
		ReferrerLink link = null;
		String shortKey = null;
		do{
			shortKey = Utility.generateShortKey(6);
			link = findLinkByShortKey(shortKey);
		}while(link != null);
		return shortKey;
	}

	@Override
	public void valid(long id) {
		ReferrerLink link = em.find(ReferrerLink.class, id);
		if(link != null){
			link.setValid(false);
			em.persist(link);
		}
	}

	@Override
	@Transactional
	public ReferrerLink attachOpenId(long id, String openId) {
		ReferrerLink link = em.find(ReferrerLink.class, id);
		if(link != null){
			link.setMerchantOpenId(openId);
			em.merge(link);
		}
		return link;
	}

	@Override
	public ReferrerLink create(int referrerId, String mid) {
		ReferrerLink link = new ReferrerLink();
		link.setReferrerId(referrerId);
		link.setMid(mid);
		link.setValid(true);
		link.setCreateDate(new Date());
		em.persist(link);
		return link;
	}
	
	@Override
	public int removeExpiredLinks(){
		Query query = em.createQuery("delete from ReferrerLink l where l.createDate<:date");
		Date date = DateUtils.addDays(new Date(), -3);
		query.setParameter("date", date);
		return query.executeUpdate();
	}
	
}
