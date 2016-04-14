package com.cardvalue.wechat.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cardvalue.wechat.util.Constants;

public class SaveSalesDTO {

	@NotNull
	@Size(min=2, message="请输入至少两位的姓名")
	private String name;
	
	@NotNull
	@Pattern(regexp=Constants.VALID_PATTERN_MOBILE, message="请输入正确的手机号")
	private String mobile;
	
	@NotNull
	@Size(min=4, message="请输入分支机构")
	private String branchCode;
	
	@NotNull
	@Size(min=4, message="请输入地市编码")
	private String regionCode;

	private String idNumber;
	
	private String bank;
	
	private String bankCardNumber;
	
	private String email;
	
	private String userType;
	
	private String username;
	
	private String password;
	
	@NotNull
	@Size(min=1, message="请输入所属机构")
	private String processorId;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

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

	public String getProcessorId() {
		return processorId;
	}

	public void setProcessorId(String processorId) {
		this.processorId = processorId;
	}
	
}
