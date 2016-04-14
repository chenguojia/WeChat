package com.cardvalue.wechat.dto;

public class CalculateResponse {

	private String result;
	
	private CreditInfo resultData;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public CreditInfo getResultData() {
		return resultData;
	}

	public void setResultData(CreditInfo resultData) {
		this.resultData = resultData;
	}

}
