package com.cardvalue.wechat.dto;

public class WeGroupCreateRequest {
	
	private WeGroup group;
	
	public WeGroupCreateRequest(){
		group = new WeGroup();
	}
	
	public WeGroup getGroup() {
		return group;
	}

	public void setGroup(WeGroup group) {
		this.group = group;
	}
	
}
