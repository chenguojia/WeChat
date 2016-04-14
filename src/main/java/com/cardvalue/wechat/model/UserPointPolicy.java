package com.cardvalue.wechat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_point_policy")
public class UserPointPolicy implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="user_type")
	private int userType;
	
	@Column(name="action")
	private int action;
	
	private int level;
	
	private int point;
	
	@Column(name="daily_max_point")
	private int dailyMaxPoint;
	
	@Column(name="daily_max_times")
	private int dailyMaxTimes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int actionType) {
		this.action = actionType;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getDailyMaxPoint() {
		return dailyMaxPoint;
	}

	public void setDailyMaxPoint(int dailyMaxLimit) {
		this.dailyMaxPoint = dailyMaxLimit;
	}

	public int getDailyMaxTimes() {
		return dailyMaxTimes;
	}

	public void setDailyMaxTimes(int dailyMaxTimes) {
		this.dailyMaxTimes = dailyMaxTimes;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
