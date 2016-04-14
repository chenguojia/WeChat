package com.cardvalue.wechat.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="point_campaign_award")
@NamedQuery(name="findPointCampaignAward", query="SELECT a FROM PointCampaignAward a WHERE a.pointDate=:date")
public class PointCampaignAward implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
    @OneToOne(optional=false,cascade={CascadeType.ALL})  
    @JoinColumn(name="award_id", unique=false)  
	private CampaignAward award;
	
    @Column(name="point_date")
    private Date pointDate;
    
    @Column(name="point_end_date")
    private Date pointEndDate;
    
    @OneToOne(optional=false,cascade={CascadeType.ALL})  
    @JoinColumn(name="user_id", unique=false, nullable=true)  
    private WeUser user;

    @Column(name="branch_code")
    private String branchCode;
    
    @Column(name="times")
    private int times;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CampaignAward getAward() {
		return award;
	}

	public void setAward(CampaignAward award) {
		this.award = award;
	}

	public WeUser getUser() {
		return user;
	}

	public void setUser(WeUser user) {
		this.user = user;
	}

	public Date getPointDate() {
		return pointDate;
	}

	public void setPointDate(Date pointDate) {
		this.pointDate = pointDate;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public Date getPointEndDate() {
		return pointEndDate;
	}

	public void setPointEndDate(Date pointEndDate) {
		this.pointEndDate = pointEndDate;
	}
	
}
