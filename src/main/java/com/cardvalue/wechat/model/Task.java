package com.cardvalue.wechat.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Task implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(length=12)
	private String number;
	
	@Column(name="create_time")
	private Date createTime;
	
	@Column(name="user_id",length=8)
	private int userId;
	
	@Column(name="merchant_number",length=20)
	private String merchantNumber;
	
	@Column(name="sub_code",length=4)
	private String subCode;
	
	@Column(name="merchant_name",length=30)
	private String merchantName;
	
	@Column(length=2)
	private int phase;
	
	@Column(length=2)
	private int status;
	
	@Column(name="contact_name",length=10)
	private String contactName;
	
	@Column(name="contact_position",length=2)
	private int contactPosition;	
	
	@Column(name="contact_mobile", length=14)
	private String contactMobile;
	
	@Column(length=300)
	private String memo;
	
	@Column(name="urgent_degree",length=2)
	private int urgentDegree;
	
	@Column(length=2)
	private int channel=1;
	
	@Column(name="last_update_time", nullable=true)
	private Date lastUpdateTime;
	
	@Transient
	private String phaseLabel;
	
	@Transient
	private String statusLabel;
	
	@Transient
	private String contactPositionLabel;

	@Transient
	private String pqFundedAmount;//计算出来的授信额度

	@Transient
	private List<Map> rfe;//需要补件的列表

	@Transient
	private List<Map> memos;//备忘录

	public Task(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMerchantNumber() {
		return merchantNumber;
	}

	public void setMerchantNumber(String merchantNumber) {
		this.merchantNumber = merchantNumber;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getUrgentDegree() {
		return urgentDegree;
	}

	public void setUrgentDegree(int urgentDegree) {
		this.urgentDegree = urgentDegree;
	}

	public int getContactPosition() {
		return contactPosition;
	}

	public void setContactPosition(int contactPosition) {
		this.contactPosition = contactPosition;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public String getPhaseLabel() {
		return phaseLabel;
	}

	public void setPhaseLabel(String phaseLabel) {
		this.phaseLabel = phaseLabel;
	}

	public String getStatusLabel() {
		return statusLabel;
	}

	public void setStatusLabel(String statusLabel) {
		this.statusLabel = statusLabel;
	}

	public String getContactPositionLabel() {
		return contactPositionLabel;
	}

	public void setContactPositionLabel(String contactPositionLabel) {
		this.contactPositionLabel = contactPositionLabel;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getPqFundedAmount() {
		return pqFundedAmount;
	}

	public void setPqFundedAmount(String pqFundedAmount) {
		this.pqFundedAmount = pqFundedAmount;
	}

	public List<Map> getRfe() {
		return rfe;
	}

	public void setRfe(List<Map> rfe) {
		this.rfe = rfe;
	}

	public List<Map> getMemos() {
		return memos;
	}

	public void setMemos(List<Map> memos) {
		this.memos = memos;
	}
}
