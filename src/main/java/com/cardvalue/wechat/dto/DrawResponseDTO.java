package com.cardvalue.wechat.dto;

public class DrawResponseDTO {
	
	private int result;
	
	private String resultMessage;
	
	private int remainDrawCount;
	
	private String token;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public int getRemainDrawCount() {
		return remainDrawCount;
	}

	public void setRemainDrawCount(int remainDrawCount) {
		this.remainDrawCount = remainDrawCount;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
