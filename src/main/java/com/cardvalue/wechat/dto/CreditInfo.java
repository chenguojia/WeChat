package com.cardvalue.wechat.dto;

import com.cardvalue.wechat.util.Utility;


public class CreditInfo {
	
	private double creditLineIn30Days;
	
	private double creditLineIn60Days;
	
	private double creditLineIn90Days;
	
	private int creditRating;
	
	private String creditRatingLabel;
	
	private double fee;
	
	private double feeRate;
	
	private double fixedPaymentAmont;
	
	private double fixedPaymentRatio;
	
	private int maxPaymentPeriod;
	
	private String paymentWay;
	
	public double getCreditLineIn30Days() {
		return creditLineIn30Days;
	}
	
	public String getCreditLineIn30DaysLabel() {
		return Utility.formatAmount(creditLineIn30Days);
	}

	public void setCreditLineIn30Days(double creditLineIn30Days) {
		this.creditLineIn30Days = creditLineIn30Days;
	}

	public double getCreditLineIn60Days() {
		return creditLineIn60Days;
	}
	
	public String getCreditLineIn60DaysLabel() {
		return Utility.formatAmount(creditLineIn60Days);
	}

	public void setCreditLineIn60Days(double creditLineIn60Days) {
		this.creditLineIn60Days = creditLineIn60Days;
	}

	public double getCreditLineIn90Days() {
		return creditLineIn90Days;
	}
	
	public String getCreditLineIn90DaysLabel() {
		return Utility.formatAmount(creditLineIn90Days);
	}

	public void setCreditLineIn90Days(double creditLineIn90Days) {
		this.creditLineIn90Days = creditLineIn90Days;
	}

	public int getCreditRating() {
		return creditRating;
	}
	
	public void setCreditRating(int creditRating) {
		this.creditRating = creditRating;
	}
	
	public String getCreditRatingLabel() {
		return creditRatingLabel;
	}
	
	public void setCreditRatingLabel(String creditRatingLabel) {
		this.creditRatingLabel = creditRatingLabel;
	}

	public double getFee() {
		return fee;
	}

	public String getFeeLabel() {
		return Utility.formatAmount(fee);
	}
	
	public void setFee(double fee) {
		this.fee = fee;
	}

	public double getFeeRate() {
		return feeRate;
	}
	
	public String getFeeRateLabel() {
		return Utility.appendPercentageMark(feeRate);
	}

	public void setFeeRate(double feeRate) {
		this.feeRate = feeRate;
	}

	public double getFixedPaymentAmont() {
		return fixedPaymentAmont;
	}
	
	public String getFixedPaymentAmontLabel() {
		return Utility.formatAmount(fixedPaymentAmont);
	}

	public void setFixedPaymentAmont(double fixedPaymentAmont) {
		this.fixedPaymentAmont = fixedPaymentAmont;
	}

	public double getFixedPaymentRatio() {
		return fixedPaymentRatio;
	}
	
	public String getFixedPaymentRatioLabel() {
		return Utility.formatPercentage(fixedPaymentRatio);
	}

	public void setFixedPaymentRatio(double fixedPaymentRatio) {
		this.fixedPaymentRatio = fixedPaymentRatio;
	}

	public int getMaxPaymentPeriod() {
		return maxPaymentPeriod;
	}

	public void setMaxPaymentPeriod(int maxPaymentPeriod) {
		this.maxPaymentPeriod = maxPaymentPeriod;
	}

	public String getPaymentWay() {
		return paymentWay;
	}

	public void setPaymentWay(String paymentWay) {
		this.paymentWay = paymentWay;
	}
	
}
