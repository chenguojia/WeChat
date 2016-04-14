package com.cardvalue.wechat.repository.jpa;

import java.math.BigInteger;
import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cardvalue.wechat.dto.MerchantApplyDTO;
import com.cardvalue.wechat.model.Leads;
import com.cardvalue.wechat.repository.LeadsRepositoryCustom;
import com.cardvalue.wechat.repository.UtilRepository;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.util.Constants;

@Repository
public class LeadsRepositoryImpl implements LeadsRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UtilRepository utilRepo;
	
	@Resource
	private UtilityService utilityService;
	
	@Override
	public long getCountInStatus(int status, int userId) {
		Query query = em.createQuery("select count(*) from Leads l where l.status=:status and l.userId=:userId");
		query.setParameter("status", status);
		query.setParameter("userId", userId);
		long count = (Long)query.getSingleResult();
		return count;
	}

	@Override
	public long getCount(int userId) {
		Query query = em.createQuery("select count(*) from Leads l where l.userId=:userId");
		query.setParameter("userId", userId);
		long count = (Long)query.getSingleResult();
		return count;
	}

	@Override
	@Transactional
	public void merchantApply(MerchantApplyDTO dto) {
		Leads leads = new Leads();
		//未分配时空置为0
		String seqNumber = utilityService.generateSequenceNumber(Constants.TYPE_LEADS);
		leads.setNumber(seqNumber);
		leads.setUserId(0);
		leads.setCreateDate(new Date());
		//从提交的dto中获取属性
		leads.setMerchantContact(dto.getContactName());
		leads.setContactMobile(dto.getContactMobile());
		leads.setContactPosition(dto.getContactPosition());
		leads.setMemo(dto.getMemo());
		leads.setMerchantName(dto.getMerchantName());
		leads.setMerchantNumber(dto.getMid());
		leads.setSubCode(dto.getSubCode());
		//线索是商户提交，直接设置商户意向是同意
		leads.setMerchantIntention(1);
		//状态为待处理
		leads.setStatus(3);
		em.persist(leads);
	}

	@Override
	public long getUpdatedLeadsCount(int userId){
		long count = 0;
		Query query = em.createQuery("select count(*) from Leads l where l.userId=:userId and l.updated=1");
		query.setParameter("userId", userId);
		count = (Long)query.getSingleResult();
		return count;
	}
	
	@Override
	public long getUpdatedLeadsCountInStatus(int userId, int status){
		long count = 0;
		Query query = em.createQuery("select count(*) from Leads l where l.userId=:userId and l.status=:status and l.updated=1");
		query.setParameter("userId", userId);
		query.setParameter("status", status);
		count = (Long)query.getSingleResult();
		return count;
	}

	@Override
	public boolean isRepeated(String mid) {
		Query query = em.createNativeQuery("SELECT COUNT(*) FROM leads l WHERE l.merchant_number=:mid AND l.create_date > NOW() - INTERVAL 1 MONTH");
		query.setParameter("mid", mid);
		int count = ((BigInteger)query.getSingleResult()).intValue();
		return (count > 0);
	}
}
