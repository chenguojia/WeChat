package com.cardvalue.wechat.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SalesPointSummaryDTO {

	@Id
	private int id;
	
	private String branch;
	
	private String region;
	
	private String name;
	
	private String level;
	
	@Column(name="total_point")
	private int totalPoint;
	
	@Column(name="available_point")
	private int availablePoint;
	
	@Column(name="login_count")
	private int loginCount;
	
	@Column(name="search_count")
	private int searchCount;
	
	@Column(name="leads_count")
	private int leadsCount;
	
	@Column(name="merchant_count")
	private int merchantCount;
	
	@Column(name="login_date_count")
	private int loginDateCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	public int getAvailablePoint() {
		return availablePoint;
	}

	public void setAvailablePoint(int availablePoint) {
		this.availablePoint = availablePoint;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public int getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(int searchCount) {
		this.searchCount = searchCount;
	}

	public int getLeadsCount() {
		return leadsCount;
	}

	public void setLeadsCount(int leadsCount) {
		this.leadsCount = leadsCount;
	}

	public int getMerchantCount() {
		return merchantCount;
	}

	public void setMerchantCount(int merchantCount) {
		this.merchantCount = merchantCount;
	}

	public int getLoginDateCount() {
		return loginDateCount;
	}

	public void setLoginDateCount(int loginDateCount) {
		this.loginDateCount = loginDateCount;
	}
	
}
