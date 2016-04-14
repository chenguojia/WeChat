package com.cardvalue.wechat.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.cardvalue.wechat.util.Constants;

public class MerchantRegisterDTO {

	private String mid;

	private String contactName;

	private String contactMobile;

	private String merchantName;

	private String checkCode;

	private int referrerId;

	private String openId;

	private long linkId;

	private String address;

	private boolean requireCheck;

	@NotNull
	private int contactPosition;

	private String agreeClause;//同意条款

	private String processorId;//用户关联银行类型

	/**
	 * 授信需要用到的参数
	 */
	private String loanAmount;//申请额度

	private String paybackPeriod;//还款周期

	/**
	 * 以下属性为新版注册需要用到的属性
	 */
	private String name;

	private Integer provinceId;

	private Integer regionId;

	private String mobile;

	private String email;

	private String password;

	private String passwordAgain;

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
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

	public int getReferrerId() {
		return referrerId;
	}

	public void setReferrerId(int referrerId) {
		this.referrerId = referrerId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public void setRegionId(int cityId) {
		this.regionId = cityId;
	}

	public int getContactPosition() {
		return contactPosition;
	}

	public void setContactPosition(int contactPosition) {
		this.contactPosition = contactPosition;
	}

	public long getLinkId() {
		return linkId;
	}

	public void setLinkId(long linkId) {
		this.linkId = linkId;
	}

	public String toString() {
		return new ToStringBuilder(this).
				append("mid", mid).
				append("merchant name", merchantName).
				append("contact name", contactName).
				append("contact mobile", contactMobile).
				append("referrer id", referrerId).
				toString();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
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

	public String getAgreeClause() {
		return agreeClause;
	}

	public void setAgreeClause(String agreeClause) {
		this.agreeClause = agreeClause;
	}

	public String getProcessorId() {
		return processorId;
	}

	public void setProcessorId(String processorId) {
		this.processorId = processorId;
	}

	public boolean isRequireCheck() {
		return requireCheck;
	}

	public void setRequireCheck(boolean requireCheck) {
		this.requireCheck = requireCheck;
	}

	/*@NotNull
	@Pattern(regexp="\\d{15}", message="请输入正确的商编号")
	private String mid;
	
	@NotNull
	@Size(min=2, message="请输入至少两位的姓名")
	private String contactName;
	
	@NotNull
	@Pattern(regexp=Constants.VALID_PATTERN_MOBILE, message="请输入正确的手机号")
	private String contactMobile;
	
	@NotNull
	@Size(min=1, message="请输入至少一位的商户名称")
	private String merchantName;
	
	private String checkCode;
	
	private int referrerId;
	
	private String openId; 
	
	private int provinceId;
	
	private int regionId;
	
	private long linkId;
	
	private String address;
	
	private boolean requireCheck;
	
	@NotNull
	private int contactPosition;
	
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
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

	public int getReferrerId() {
		return referrerId;
	}

	public void setReferrerId(int referrerId) {
		this.referrerId = referrerId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int cityId) {
		this.regionId = cityId;
	}

	public int getContactPosition() {
		return contactPosition;
	}

	public void setContactPosition(int contactPosition) {
		this.contactPosition = contactPosition;
	}
	
	public long getLinkId() {
		return linkId;
	}

	public void setLinkId(long linkId) {
		this.linkId = linkId;
	}

	public String toString() {
		return new ToStringBuilder(this).
				append("mid", mid).
				append("merchant name", merchantName).
				append("contact name", contactName).
				append("contact mobile", contactMobile).
				append("referrer id", referrerId).
				toString();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public boolean isRequireCheck() {
		return requireCheck;
	}

	public void setRequireCheck(boolean requireCheck) {
		this.requireCheck = requireCheck;
	}*/
	
}

