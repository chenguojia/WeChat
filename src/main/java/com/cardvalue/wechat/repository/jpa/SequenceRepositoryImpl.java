package com.cardvalue.wechat.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cardvalue.wechat.repository.SequenceRepository;

@Repository
public class SequenceRepositoryImpl implements SequenceRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public int getSequenceNumber(String seqName) {
		Query query = em.createNativeQuery("select _nextval(:seqName)");
		query.setParameter("seqName", seqName);
		int seqNumber = (Integer)query.getSingleResult();
		return seqNumber;
	}
	
}
