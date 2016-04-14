package com.cardvalue.wechat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coupon")
public class Coupon implements Serializable{

	private static final long serialVersionUID = 1L;

	public final static int COUPON_TYPE_REBATE = 1;
	public final static int COUPON_TYPE_MOBILE_FEE = 2;
	public final static int COUPON_TYPE_MERCHANT_CASH = 3;
	
	public final static String COUPON_NAME_MERCHANT_CASH_50 = "mc_50";
	public final static String COUPON_NAME_MERCHANT_CASH_200 = "mc_200";
	
	public final static int COUPON_STATUS_AVAILABLE = 1;
	public final static int COUPON_STATUS_ACTIVATED = 2;
	public final static int COUPON_STATUS_USED = 3;
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="cost_point")
	private int costPoint;
	
	private int type;
	
	private String memo;
	
	private boolean available;
	
	private String name;
	
	@Column(name="user_type")
	private String userType;

	private int amount;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCostPoint() {
		return costPoint;
	}

	public void setCostPoint(int costPoint) {
		this.costPoint = costPoint;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
