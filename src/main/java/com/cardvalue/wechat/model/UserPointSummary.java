package com.cardvalue.wechat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user_point_summary")
public class UserPointSummary implements Serializable{

	private static final long serialVersionUID = 1L;

	public UserPointSummary(){}
	
	public UserPointSummary(int userId){
		this.setAvailablePoint(0);
		this.setLevel(1);
		this.setTotalPoint(0);
		this.setUserId(userId);
		this.setBalance(0.0);
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="user_id")
	private int userId;
	
	private int level;
	
	@Transient
	private String levelLabel;
	
	@Column(name="total_point")
	private int totalPoint;
	
	@Column(name="available_point")
	private int availablePoint;

	private double balance;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getLevelLabel() {
		return levelLabel;
	}

	public void setLevelLabel(String levelLabel) {
		this.levelLabel = levelLabel;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	public int getAvailablePoint() {
		return availablePoint;
	}

	public void setAvailablePoint(int availablePoint) {
		this.availablePoint = availablePoint;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
