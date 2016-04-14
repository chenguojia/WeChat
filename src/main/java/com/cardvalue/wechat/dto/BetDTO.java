package com.cardvalue.wechat.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BetDTO implements Comparable<BetDTO>{

	@Id
	private String id;
	
	private String type;
	
	private String matchLabel;
	
	private String betLabel;
	
	private String resultLabel;
	
	private Date betTime;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMatchLabel() {
		return matchLabel;
	}

	public void setMatchLabel(String matchLabel) {
		this.matchLabel = matchLabel;
	}

	public String getBetLabel() {
		return betLabel;
	}

	public void setBetLabel(String betLabel) {
		this.betLabel = betLabel;
	}

	public String getResultLabel() {
		return resultLabel;
	}

	public void setResultLabel(String resultLabel) {
		this.resultLabel = resultLabel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBetTime() {
		return betTime;
	}

	public void setBetTime(Date betTime) {
		this.betTime = betTime;
	}

	@Override
	public int compareTo(BetDTO bet) {
		return bet.getBetTime().compareTo(this.getBetTime());
	}
	
}
