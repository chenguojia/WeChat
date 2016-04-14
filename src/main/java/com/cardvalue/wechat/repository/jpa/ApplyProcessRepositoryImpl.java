package com.cardvalue.wechat.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cardvalue.wechat.model.ApplyProcess;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.ApplyProcessRepositoryCustom;
import com.cardvalue.wechat.repository.UserRepositoryCustom;
import com.cardvalue.wechat.util.Constants;

@Repository
@Transactional(readOnly = true)
public class ApplyProcessRepositoryImpl implements ApplyProcessRepositoryCustom {

	private final static Logger logger = LoggerFactory
			.getLogger(ApplyProcessRepositoryImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public ApplyProcess findByProcessTypeAndStepNum(int processType, int stepNum) {
		String sql = "SELECT t FROM ApplyProcess t WHERE t.processType = " +processType +" AND t.stepNum = "+stepNum;
		TypedQuery<ApplyProcess> query = em.createQuery(sql, ApplyProcess.class);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			logger.info("查询流程失败！");
		}
		return null;
	}

}
