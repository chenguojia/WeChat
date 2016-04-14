package com.cardvalue.wechat.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cardvalue.wechat.util.Constants;

public class MerchantApplyDTO {

	private String loanAmount;//申请额度
	
	private String paybackPeriod;//还款周期
	
	private String mid;
	
	private String subCode;
	
	@NotNull
	@Size(min=2, message="请输入至少两位的姓名")
	private String contactName;
	
	@NotNull
	@Pattern(regexp=Constants.VALID_PATTERN_MOBILE, message="请输入正确的手机号")
	private String contactMobile;
	
	private String merchantName;
	
	private Integer contactPosition;
	
	private String memo;

	private String branchCode;
	
	private String regionCode;
	
	private String couponNumbers;
	
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public Integer getContactPosition() {
		return contactPosition;
	}

	public void setContactPosition(Integer contactPosition) {
		this.contactPosition = contactPosition;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String provinceCode) {
		this.branchCode = provinceCode;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getPaybackPeriod() {
		return paybackPeriod;
	}

	public void setPaybackPeriod(String paybackPeriod) {
		this.paybackPeriod = paybackPeriod;
	}

	public String getCouponNumbers() {
		return couponNumbers;
	}

	public void setCouponNumbers(String couponNumbers) {
		this.couponNumbers = couponNumbers;
	}
}
