package com.cardvalue.wechat.service;

import java.util.List;

import com.cardvalue.wechat.dto.FeedbackItemTO;
import com.cardvalue.wechat.dto.FeedbackTO;
import com.cardvalue.wechat.model.UserFeedback;
import com.cardvalue.wechat.model.UserFeedbackItem;


public interface UserFeedbackService {
	
	public void newFeedback(FeedbackTO to);
	
	public void newFeedbackItem(FeedbackItemTO to);
	
	public List<UserFeedback> listFeedbacks();
	
	public List<UserFeedbackItem> listFeedbackItems(int feedbackId);
	
}
