package com.cardvalue.wechat.dto;

public class UpdateApply {

	public UpdateApply(){}
	
	private int id;
	
	private String merchantName;

	private String merchantContact;
	
	private String contactMobile;
	
	private String memo;
	
	private int contactPosition;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
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
	
}
