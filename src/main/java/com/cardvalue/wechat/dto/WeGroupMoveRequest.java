package com.cardvalue.wechat.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class WeGroupMoveRequest {
	
	@JsonProperty("to_groupid")
	private int groupId;
	
	@JsonProperty("openid")
	private String openId;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
}
