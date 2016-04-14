package com.cardvalue.wechat.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cardvalue.wechat.repository.TaskRepositoryCustom;

@Repository
public class TaskRepositoryImpl implements TaskRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public long getCountInPhase(int phase, int userId) {
		Query query = em.createQuery("select count(*) from Task t where t.phase=:phase and t.userId=:userId");
		query.setParameter("phase", phase);
		query.setParameter("userId", userId);
		long count = (Long)query.getSingleResult();
		return count;
	}

	@Override
	public long getUrgentCount(int userId) {
		Query query = em.createQuery("select count(*) from Task t where t.userId=:userId and t.urgentDegree>1");
		query.setParameter("userId", userId);
		long count = (Long)query.getSingleResult();
		return count;
	}

	@Override
	public long getCount(int userId) {
		Query query = em.createQuery("select count(*) from Task t where t.userId=:userId");
		query.setParameter("userId", userId);
		long count = (Long)query.getSingleResult();
		return count;
	}


}
