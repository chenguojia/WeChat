package com.cardvalue.wechat.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamDTO {

	@Id
	private int id;
	
	private String name;
	
	private String flag;

	public String getName() {
		return name;
	}

	public void setName(String teamName) {
		this.name = teamName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
