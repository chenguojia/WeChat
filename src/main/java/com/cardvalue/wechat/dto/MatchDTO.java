package com.cardvalue.wechat.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MatchDTO {

	@Id
	private int id;
	
	private String team1Name;
	
	private String team2Name;
	
	private String team1Flag;
	
	private String team2Flag;
	
	private String matchTime;
	
	private String location;

	public String getTeam1Name() {
		return team1Name;
	}

	public void setTeam1Name(String team1Name) {
		this.team1Name = team1Name;
	}

	public String getTeam2Name() {
		return team2Name;
	}

	public void setTeam2Name(String team2Name) {
		this.team2Name = team2Name;
	}

	public String getTeam1Flag() {
		return team1Flag;
	}

	public void setTeam1Flag(String team1Flag) {
		this.team1Flag = team1Flag;
	}

	public String getTeam2Flag() {
		return team2Flag;
	}

	public void setTeam2Flag(String team2Flag) {
		this.team2Flag = team2Flag;
	}

	public String getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(String matchTime) {
		this.matchTime = matchTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
