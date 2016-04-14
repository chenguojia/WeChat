package com.cardvalue.wechat.dto;

public class ExchangeCouponResult {

	private int resultCode;
	
	private String resultMessage;
	
	private int availablePoint;
	
	private int availableCouponCount;

	private String token;
	
	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public int getAvailablePoint() {
		return availablePoint;
	}

	public void setAvailablePoint(int availablePoint) {
		this.availablePoint = availablePoint;
	}

	public int getAvailableCouponCount() {
		return availableCouponCount;
	}

	public void setAvailableCouponCount(int availableCouponCount) {
		this.availableCouponCount = availableCouponCount;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
