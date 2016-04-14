package com.cardvalue.wechat.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import com.cardvalue.wechat.util.Utility;

public class SalesLoginTO implements Serializable, Mappable{

	private static final long serialVersionUID = 1L;

	private int userId;
	
	private String name;
	
	private String loginDate;
	
	private String loginTime;
	
	private String branchCode;
	
	private String regionCode;
	
	private String branch;
	
	private String region;
	
	private String mobile;
	
	private String username;
	
	private String password;
	
	private String dayLoginCount;

	private String submitLeadsCount;
	
	public SalesLoginTO(){}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	
	public String getDayLoginCount() {
		return dayLoginCount;
	}

	public void setDayLoginCount(String dayLoginCount) {
		this.dayLoginCount = dayLoginCount;
	}

	public String getSubmitLeadsCount() {
		return submitLeadsCount;
	}

	public void setSubmitLeadsCount(String submitLeadsCount) {
		this.submitLeadsCount = submitLeadsCount;
	}

	@Override
	public void map(Object[] objs) {
		name = (String)objs[1];
		mobile = (String)objs[2];
		loginDate = Utility.formatShortDate((Date)objs[3]);
		loginTime = Utility.formatShortTime((Time) objs[4]);
		branchCode = (String)objs[5];
		regionCode = (String)objs[6];
		branch = (String)objs[7];
		region = (String)objs[8];
		username = (String)objs[9];
		password = (String)objs[10];
		dayLoginCount = String.valueOf(objs[11]);
		submitLeadsCount = String.valueOf(objs[12]);
	}
	
}
