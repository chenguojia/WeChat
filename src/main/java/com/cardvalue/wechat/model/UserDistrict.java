package com.cardvalue.wechat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_district")
public class UserDistrict {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	private String province;
	
	private String prefecture;
	
	private String country;
	
	private String subdistrict;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String branch) {
		this.province = branch;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String region) {
		this.prefecture = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSubdistrict() {
		return subdistrict;
	}

	public void setSubdistrict(String subdistrict) {
		this.subdistrict = subdistrict;
	}

}
