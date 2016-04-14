package com.cardvalue.wechat.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_campaign")
@NamedNativeQueries({
	@NamedNativeQuery(name="addExtraDrawCount", query="UPDATE user_campaign SET extra_draw_count=extra_draw_count+1")
})
public class UserCampaign implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
    @OneToOne(optional=false,cascade={CascadeType.ALL})  
    @JoinColumn(name="campaign_id", unique=false)  
	private Campaign campaign;
	
    @OneToOne(optional=false,cascade={CascadeType.ALL})  
    @JoinColumn(name="user_id", unique=false)  
	private WeUser user;
	
	private String username;
	
	@Column(name="branch_name")
	private String branchName;
	
	@Column(name="extra_draw_count")
	private int extraDrawCount;

	@Column(name="used_extra_draw_count")
	private int usedExtraDrawCount;
	
	@Column(name="has_shared")
	private boolean hasShared;
	
	@Column(name="award_code")
	private String awardCode;
	
	@Column(name="award_gave")
	private boolean awardGave;
	
	@Column(name="award_gave_date")
	private Date awardGaveDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public WeUser getUser() {
		return user;
	}

	public void setUser(WeUser user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getExtraDrawCount() {
		return extraDrawCount;
	}

	public void setExtraDrawCount(int usedDrawCount) {
		this.extraDrawCount = usedDrawCount;
	}

	public String getAwardCode() {
		return awardCode;
	}

	public void setAwardCode(String awardCode) {
		this.awardCode = awardCode;
	}

	public boolean isAwardGave() {
		return awardGave;
	}

	public void setAwardGave(boolean awardGave) {
		this.awardGave = awardGave;
	}

	public Date getAwardGaveDate() {
		return awardGaveDate;
	}

	public void setAwardGaveDate(Date awardGaveDate) {
		this.awardGaveDate = awardGaveDate;
	}

	public int getUsedExtraDrawCount() {
		return usedExtraDrawCount;
	}

	public void setUsedExtraDrawCount(int usedExtraDrawCount) {
		this.usedExtraDrawCount = usedExtraDrawCount;
	}

	public boolean isHasShared() {
		return hasShared;
	}

	public void setHasShared(boolean hasShared) {
		this.hasShared = hasShared;
	}
	
}

