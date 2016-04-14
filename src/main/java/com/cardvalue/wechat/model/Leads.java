package com.cardvalue.wechat.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.cardvalue.wechat.util.Utility;

@Entity
@Table
public class Leads implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="number", length=12)
	private String number;
	
	@Column(name="merchant_number", length=20)
	private String merchantNumber;
	
	@Column(name="sub_code", length=4)
	private String subCode;
	
	@Column(name="merchant_name", length=30)
	private String merchantName;
	
	@Column(name="merchant_intention")
	private int merchantIntention;
	
	@Transient
	private String merchantIntentionLabel;
	
	@Column(name="merchant_contact", length=10)
	private String merchantContact;
	
	@Column(name="contact_position")
	private int contactPosition;
	
	@Column(name="contact_mobile", length=20)
	private String contactMobile;
	
	@Column(name="task_type")
	private int taskType;	
	
	@Column
	private int status;
	
	@Column(length=300)
	private String memo;

	@Column(name="user_id")
	private int userId;
	
	@Column(length=2)
	private int channel=1;
	
	@Column(name="feedback_date")
	private Date feedbackDate;
	
	@Column(name="create_date")
	private java.util.Date createDate;
	
	@Transient
	private String statusLabel;
	
	@Transient
	private String taskTypeLabel;
	
	@Transient
	private String contactPositionLabel;
	
	private int updated;
	
	@Transient
	private String loanAmount;//申请额度
	
	@Transient
	private String paybackPeriod;//还款周期
	
	@Transient
	private String merchantIndustry; //商户行业
	
	@Transient
	private String product; //融资产品编码
	
	@Transient
	private String productTitle; //融资产品名称
	
	@Transient
	private String referrerName;
	
	@Transient
	private String referrerCellPhone;
	
	@Transient
	private String statusChangeTime;
	
	@Transient
	private String couponNumbers;

	@Transient
	private String pqFundedAmount;//人工计算出来的授信额度

	@Transient
	private List<Map> memos;//备忘录
	
	public String getMerchantIndustry() {
		return merchantIndustry;
	}

	public void setMerchantIndustry(String merchantIndustry) {
		this.merchantIndustry = merchantIndustry;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String merchantProvince) {
		this.provinceId = merchantProvince;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String merchantCity) {
		this.regionId = merchantCity;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

	public String getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	public String getManagerEducationLevel() {
		return managerEducationLevel;
	}

	public void setManagerEducationLevel(String managerEducationLevel) {
		this.managerEducationLevel = managerEducationLevel;
	}

	public String getManagerMarriageStatus() {
		return managerMarriageStatus;
	}

	public void setManagerMarriageStatus(String managerMarriageStatus) {
		this.managerMarriageStatus = managerMarriageStatus;
	}

	public String getManagerChildrenStatus() {
		return managerChildrenStatus;
	}

	public void setManagerChildrenStatus(String managerChildrenStatus) {
		this.managerChildrenStatus = managerChildrenStatus;
	}

	public String getManagerHukouStatus() {
		return managerHukouStatus;
	}

	public void setManagerHukouStatus(String managerHukouStatus) {
		this.managerHukouStatus = managerHukouStatus;
	}

	public String getEstimatedRevenue() {
		return estimatedRevenue;
	}

	public void setEstimatedRevenue(String estimatedRevenue) {
		this.estimatedRevenue = estimatedRevenue;
	}

	@Transient
	private String provinceId; //商户经营省份
	
	@Transient
	private String regionId; //商户经营城市
	
	@Transient
	private String businessArea; //商户营业面积
	
	@Transient
	private String staffNumber; //商户员工数量
	
	@Transient
	private String managerEducationLevel; //实际经营人学历
	
	@Transient
	private String managerMarriageStatus; //实际经营人婚姻状况
	
	@Transient
	private String managerChildrenStatus; //实际经营人子女状况
	
	@Transient
	private String managerHukouStatus; //实际经营人户口状况
	
	@Transient
	private String estimatedRevenue; //预计月营业额
	
	@Transient
	private String businessLocation; //经营地段
	
	public Leads() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMerchantNumber() {
		return merchantNumber;
	}

	public void setMerchantNumber(String merchantNumber) {
		this.merchantNumber = merchantNumber;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public int getMerchantIntention() {
		return merchantIntention;
	}

	public void setMerchantIntention(int merchantIntention) {
		this.merchantIntention = merchantIntention;
	}

	public String getMerchantContact() {
		return merchantContact;
	}

	public void setMerchantContact(String merchantContact) {
		this.merchantContact = merchantContact;
	}

	public int getContactPosition() {
		return contactPosition;
	}

	public void setContactPosition(int contactPosition) {
		this.contactPosition = contactPosition;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getTaskType() {
		return taskType;
	}

	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMerchantIntentionLabel() {
		return merchantIntentionLabel;
	}

	public void setMerchantIntentionLabel(String merchantIntentionLabel) {
		this.merchantIntentionLabel = merchantIntentionLabel;
	}

	public String getStatusLabel() {
		return statusLabel;
	}

	public void setStatusLabel(String statusLabel) {
		this.statusLabel = statusLabel;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public String getTaskTypeLabel() {
		return taskTypeLabel;
	}

	public void setTaskTypeLabel(String taskTypeLabel) {
		this.taskTypeLabel = taskTypeLabel;
	}

	public String getContactPositionLabel() {
		return contactPositionLabel;
	}

	public void setContactPositionLabel(String positionLabel) {
		this.contactPositionLabel = positionLabel;
	}

	public Date getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	
	public String getFeedbackDateLabel(){
		return Utility.formatShortDate(feedbackDate);
	} 

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public int getUpdated() {
		return updated;
	}

	public void setUpdated(int updated) {
		this.updated = updated;
	}
	
	@Override
	public String toString(){
		return new ToStringBuilder(this).
				append("number", number).
				append("userId", userId).
				append("mid", merchantNumber).
				append("merchantName", merchantName).
				toString();
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getReferrerName() {
		return referrerName;
	}

	public void setReferrerName(String referrerName) {
		this.referrerName = referrerName;
	}

	public String getReferrerCellPhone() {
		return referrerCellPhone;
	}

	public void setReferrerCellPhone(String referrerCellPhone) {
		this.referrerCellPhone = referrerCellPhone;
	}

	public String getStatusChangeTime() {
		return statusChangeTime;
	}

	public void setStatusChangeTime(String statusChangeTime) {
		this.statusChangeTime = statusChangeTime;
	}

	public String getBusinessLocation() {
		return businessLocation;
	}

	public void setBusinessLocation(String businessLocation) {
		this.businessLocation = businessLocation;
	}

	public String getCouponNumbers() {
		return couponNumbers;
	}

	public void setCouponNumbers(String couponMumbers) {
		this.couponNumbers = couponMumbers;
	}

	public String getPqFundedAmount() {
		return pqFundedAmount;
	}

	public void setPqFundedAmount(String pqFundedAmount) {
		this.pqFundedAmount = pqFundedAmount;
	}

	public List<Map> getMemos() {
		return memos;
	}

	public void setMemos(List<Map> memos) {
		this.memos = memos;
	}
}
