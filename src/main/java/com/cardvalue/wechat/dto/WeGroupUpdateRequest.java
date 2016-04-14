package com.cardvalue.wechat.dto;

public class WeGroupUpdateRequest {
	
	private WeGroup group;
	
	public WeGroupUpdateRequest(){
		group = new WeGroup();
	}
	
	public WeGroup getGroup() {
		return group;
	}

	public void setGroup(WeGroup group) {
		this.group = group;
	}
	
}
