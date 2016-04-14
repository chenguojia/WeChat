package com.cardvalue.wechat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_purse_record")
public class UserPurseRecord {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="user_id")
	private Integer userId;
	
	private Integer action;
	
	private double amount;
	
	private double balance;
	
	private String memo;
	
	@Column(name="create_date")
	private Date createDate;
	
	private Integer flag;

	//new add field
	@Column(name="approver_user_id")
	private Integer approverUserId;

	@Column(name="approver_name")
	private String approverName;

	@Column(name="approver_date")
	private Date approverDate;

	@Column
	private String reason;

	public UserPurseRecord(){}
	
	public UserPurseRecord(int userId, int action, double amount){
		this.userId = userId;
		this.action = action;
		this.amount = amount;
		this.createDate = new Date();
		flag = 0;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAction() {
		return action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getApproverUserId() {
		return approverUserId;
	}

	public void setApproverUserId(Integer approverUserId) {
		this.approverUserId = approverUserId;
	}

	public String getApproverName() {
		return approverName;
	}

	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}

	public Date getApproverDate() {
		return approverDate;
	}

	public void setApproverDate(Date approverDate) {
		this.approverDate = approverDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
