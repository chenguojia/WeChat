package com.cardvalue.wechat.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cardvalue.wechat.dto.FeedbackItemTO;
import com.cardvalue.wechat.dto.FeedbackTO;
import com.cardvalue.wechat.model.Sales;
import com.cardvalue.wechat.model.UserFeedback;
import com.cardvalue.wechat.model.UserFeedbackItem;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.service.UserFeedbackService;
import com.cardvalue.wechat.service.UserService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.Utility;

@Service
@Repository
public class UserFeedbackServiceImpl implements UserFeedbackService{

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private UserService userService;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void newFeedback(FeedbackTO to) {
		Date current = new Date();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		WeUser user = userService.findByUsername(auth.getName());
		UserFeedback feedback = new UserFeedback();
		feedback.setCount(1);
		feedback.setCreateTime(current);
		feedback.setUpdateTime(current);
		feedback.setCreator(user);
		String title = to.getContent();
		if(title.length() > 10){
			title = title.subSequence(0, 10) + "...";
		}
		feedback.setTitle(title);
		UserFeedbackItem feedbackItem = new UserFeedbackItem();
		feedbackItem.setContent(to.getContent());
		feedbackItem.setCreateTime(current);
		feedbackItem.setCreator(user);
		feedbackItem.setFeedback(feedback);
		feedbackItem.setSerialNumber(1);
		em.persist(feedbackItem);
		em.flush();
	}

	@Override
	@Transactional
	public void newFeedbackItem(FeedbackItemTO to) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		WeUser user = userService.findByUsername(auth.getName());
		UserFeedback feedback = em.find(UserFeedback.class, to.getFeedbackId());
		Date current = new Date();
		UserFeedbackItem feedbackItem = new UserFeedbackItem();
		feedbackItem.setContent(to.getContent());
		feedbackItem.setCreateTime(current);
		feedbackItem.setCreator(user);
		feedbackItem.setFeedback(feedback);
		feedbackItem.setSerialNumber(feedback.getCount()+1);
		feedback.setCount(feedback.getCount()+1);
		em.persist(feedbackItem);
		em.flush();
	}

	@Override
	public List<UserFeedback> listFeedbacks() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		WeUser user = userService.findByUsername(auth.getName());
		TypedQuery<UserFeedback> query = em.createNamedQuery("findFeedbackByUser", UserFeedback.class);
		query.setFirstResult(0);
		query.setMaxResults(4);
		query.setParameter("creator", user);
		List<UserFeedback> list = query.getResultList();
		for(UserFeedback feedback : list){
			Sales sales = userService.findSalesByUserId(feedback.getCreator().getId());
			feedback.setCreatorName(sales.getName());
			feedback.setUpdateTimeLabel(Utility.formatLongDate(feedback.getUpdateTime()));
		}
		return list;
	}

	@Override
	public List<UserFeedbackItem> listFeedbackItems(int feedbackId) {
		UserFeedback feedback = em.find(UserFeedback.class, feedbackId);
		TypedQuery<UserFeedbackItem> query = em.createNamedQuery("findFeedbackItems", UserFeedbackItem.class);
		query.setFirstResult(0);
		query.setMaxResults(4);
		query.setParameter("feedback", feedback);
		List<UserFeedbackItem> list = query.getResultList();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		WeUser user = userService.findByUsername(auth.getName());
		for(UserFeedbackItem item : list){
			if(feedback.getCreator().getId() == user.getId()){
				item.setCreatorName(Constants.CREATOR_NAME_ME);
			}else{
				Sales sales = userService.findSalesByUserId(feedback.getCreator().getId());
				item.setCreatorName(sales.getName());
			}
			item.setCreateTimeLabel(Utility.formatLongDate(item.getCreateTime()));
		}
		return list;
	}

}
