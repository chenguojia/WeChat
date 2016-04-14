package com.cardvalue.wechat.dto;

import java.sql.Date;

public class LeadsUpdate {

	public LeadsUpdate(){}
	
	private int id;
	
	private int merchantIntention;
	
	private Date feedbackDate;
	
	private String merchantName;

	private String merchantContact;
	
	private String contactMobile;
	
	private String memo;
	
	private int contactPosition;
	
	private String merchantNumber;
	
	private String status;
	
	public int getMerchantIntention() {
		return merchantIntention;
	}

	public void setMerchantIntention(int intention) {
		this.merchantIntention = intention;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantContact() {
		return merchantContact;
	}

	public void setMerchantContact(String merchantContact) {
		this.merchantContact = merchantContact;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactNumber) {
		this.contactMobile = contactNumber;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getContactPosition() {
		return contactPosition;
	}

	public void setContactPosition(int contactPosition) {
		this.contactPosition = contactPosition;
	}

	public String getMerchantNumber() {
		return merchantNumber;
	}

	public void setMerchantNumber(String merchantNumber) {
		this.merchantNumber = merchantNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
