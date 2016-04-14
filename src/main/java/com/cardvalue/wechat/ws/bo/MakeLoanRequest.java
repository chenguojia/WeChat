package com.cardvalue.wechat.ws.bo;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MakeLoanRequest {

	private String username;
	
	private String password;
	
	private String mid;
	
	private String factoringNumber;
	
	private String memo;
	
	private boolean keyMerchant;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getFactoringNumber() {
		return factoringNumber;
	}

	public void setFactoringNumber(String factoringNumber) {
		this.factoringNumber = factoringNumber;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public boolean isKeyMerchant() {
		return keyMerchant;
	}

	public void setKeyMerchant(boolean keyMerchantFlag) {
		this.keyMerchant = keyMerchantFlag;
	}
	
	public String toString(){
		return new ToStringBuilder(this)
				.append("username", username)
				.append("password", password)
				.toString();
	}
	
}
