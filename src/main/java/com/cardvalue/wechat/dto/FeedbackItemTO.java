package com.cardvalue.wechat.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FeedbackItemTO {
	
	@NotNull
	@Size(min=5, max=255)
	private String content;
	
	private int feedbackId;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	
}
