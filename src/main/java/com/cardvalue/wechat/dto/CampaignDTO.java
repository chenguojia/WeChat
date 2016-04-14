package com.cardvalue.wechat.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CampaignDTO {

	private String name;
	
	private int drawCount;
	
	private String awardCode;
	
	private Date beginDate;
	
	private Date endDate;
	
	private int userId;
	
	private int campaignId;
	
	private List<String> awardMessages = new ArrayList<String>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDrawCount() {
		return drawCount;
	}

	public void setDrawCount(int drawCount) {
		this.drawCount = drawCount;
	}

	public String getAwardCode() {
		return awardCode;
	}

	public void setAwardCode(String awardCode) {
		this.awardCode = awardCode;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public List<String> getAwardMessages() {
		return awardMessages;
	}
	
	public void addAwardMessage(String message){
		this.awardMessages.add(message);
	}
}
