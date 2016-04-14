package com.cardvalue.wechat.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeFooterModel {
	
	private String cvFee;
	
	@JsonProperty("OutJine")
	private String outJine;
	
	@JsonProperty("InJine")
	private String inJine;
	
	private String baoli;

	private String settleAmt;
	
	@JsonProperty("TotalPayback")
	private String totalPayback;//还款总额度

	@JsonProperty("AmountRequested")
	private String amountRequested; //融资金额
	
	@JsonProperty("TotalRemaining")
	private String totalRemaining;
	
	@JsonProperty("MinMonthPay")
	private String minMonthPay;
	
	public String getCvFee() {
		return cvFee;
	}

	public void setCvFee(String cvFee) {
		this.cvFee = cvFee;
	}

	public String getOutJine() {
		return outJine;
	}

	public void setOutJine(String outJine) {
		this.outJine = outJine;
	}

	public String getInJine() {
		return inJine;
	}

	public void setInJine(String inJine) {
		this.inJine = inJine;
	}

	public String getBaoli() {
		return baoli;
	}

	public void setBaoli(String baoli) {
		this.baoli = baoli;
	}

	public String getSettleAmt() {
		return settleAmt;
	}

	public void setSettleAmt(String settleAmt) {
		this.settleAmt = settleAmt;
	}

	public String getTotalPayback() {
		return totalPayback;
	}

	public void setTotalPayback(String totalPayback) {
		this.totalPayback = totalPayback;
	}

	public String getTotalRemaining() {
		return totalRemaining;
	}

	public void setTotalRemaining(String totalRemaining) {
		this.totalRemaining = totalRemaining;
	}

	public String getMinMonthPay() {
		return minMonthPay;
	}

	public void setMinMonthPay(String minMonthPay) {
		this.minMonthPay = minMonthPay;
	}

	public String getAmountRequested() {
		return amountRequested;
	}

	public void setAmountRequested(String amountRequested) {
		this.amountRequested = amountRequested;
	}
}
