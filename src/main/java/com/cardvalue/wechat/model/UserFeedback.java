package com.cardvalue.wechat.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="user_feedback")
@NamedQuery(name="findFeedbackByUser",
	query="SELECT f FROM UserFeedback f WHERE f.creator = :creator order by f.updateTime desc")
public class UserFeedback implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public UserFeedback(){}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private WeUser creator;
	
	@Column(name="create_time")
	private Date createTime;
	
	private int type;
	
	private int status;
	
	private int count;
	
	private String title;
	
	@Column(name="update_time")
	private Date updateTime;
	
	@Transient
	private String updateTimeLabel;
	
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getUpdateTimeLabel() {
		return updateTimeLabel;
	}

	public void setUpdateTimeLabel(String updateTimeLabel) {
		this.updateTimeLabel = updateTimeLabel;
	}
	
}
