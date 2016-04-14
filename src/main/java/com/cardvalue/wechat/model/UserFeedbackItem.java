package com.cardvalue.wechat.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user_feedback_item")
@NamedQuery(name="findFeedbackItems",
	query="SELECT f FROM UserFeedbackItem f WHERE f.feedback = :feedback order by f.serialNumber")
public class UserFeedbackItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public UserFeedbackItem(){}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private WeUser creator;
	
	@Column(name="create_time")
	private Date createTime;
	
	@Transient
	private String createTimeLabel;
	
	private String content;
	
	@Column(name="serial_number")
	private int serialNumber;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private UserFeedback feedback;

	@Transient
	private String creatorName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WeUser getCreator() {
		return creator;
	}

	public void setCreator(WeUser creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public UserFeedback getFeedback() {
		return feedback;
	}

	public void setFeedback(UserFeedback feedback) {
		this.feedback = feedback;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	
	public String getCreateTimeLabel() {
		return createTimeLabel;
	}

	public void setCreateTimeLabel(String createTimeLabel) {
		this.createTimeLabel = createTimeLabel;
	}
	
}
