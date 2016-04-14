package com.cardvalue.wechat.dto;

public class CalculateInfo {

	private String region;
	
	private String busType;
	
	private Integer monthlyTransDays;
	
	private Integer dailyTransCount;
	
	private Double singleTransAmount;
	
	public CalculateInfo(){}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public Integer getMonthlyTransDays() {
		return monthlyTransDays;
	}

	public void setMonthlyTransDays(Integer monthlyTransDays) {
		this.monthlyTransDays = monthlyTransDays;
	}

	public Integer getDailyTransCount() {
		return dailyTransCount;
	}

	public void setDailyTransCount(Integer dailyTransCount) {
		this.dailyTransCount = dailyTransCount;
	}

	public Double getSingleTransAmount() {
		return singleTransAmount;
	}

	public void setSingleTransAmount(Double singleTransAmount) {
		this.singleTransAmount = singleTransAmount;
	}
	
	@Override
	public String toString(){
		return new StringBuilder().append("CalculateInfo[region:")
				.append(region).append("][busType:")
				.append(busType).append("][monthlyTransDays:")
				.append(monthlyTransDays).append("][dailyTransCount:")
				.append(dailyTransCount).append("][singleTransAmount:")
				.append(singleTransAmount).append("]").toString();
	}
}
