package com.cardvalue.wechat.dto;

import java.io.Serializable;

import com.cardvalue.wechat.util.Utility;

public class MerchantInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	//商户编号
	private String mid;
	
	//商户分店号
	private String subCode;
	
	//商户编号+分店号
	private String fullNumber;
	
	//地址
	private String address;
	
	//商户名称
	private String name;
	
	//信用等级
	private String creditRating;
	
	//信用额度
	private String creditLine;
	
	//手续费率
	private String feeRate;

	//还款周期
	private String refundPeriod;
	
	//还款方式
	private String refundWay;
	
	public String getMid() {
		return mid;
	}

	public void setMid(String no) {
		this.mid = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}

	public String getCreditLine() {
		return creditLine;
	}
	
	public String getCreditLineLabel() {
		return Utility.formatAmount(creditLine);
	}

	public void setCreditLine(String creditLine) {
		this.creditLine = creditLine;
	}

	public String getFeeRate() {
		return feeRate;
	}

	public void setFeeRate(String feeRate) {
		this.feeRate = feeRate;
	}

	public String getRefundPeriod() {
		return refundPeriod;
	}

	public void setRefundPeriod(String refundPeriod) {
		this.refundPeriod = refundPeriod;
	}

	public String getRefundWay() {
		return refundWay;
	}

	public void setRefundWay(String refundWay) {
		this.refundWay = refundWay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String branchNumber) {
		this.subCode = branchNumber;
	}

	public String getFullNumber() {
		return fullNumber;
	}

	public void setFullNumber(String fullNumber) {
		this.fullNumber = fullNumber;
	}
}
