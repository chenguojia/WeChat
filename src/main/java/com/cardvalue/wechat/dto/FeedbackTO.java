package com.cardvalue.wechat.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FeedbackTO {
	
	@NotNull
	@Size(min=5, max=255)
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
