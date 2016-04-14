package com.cardvalue.wechat.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="campaign")
@NamedQueries({
	@NamedQuery(name="findCampaign", query="SELECT c FROM Campaign c WHERE c.id=:id"),
	@NamedQuery(name="findUserCampaign", query="SELECT uc FROM UserCampaign uc WHERE uc.user=:user AND uc.campaign=:campaign"),
	@NamedQuery(name="findUserCampaignByAwardCode", query="SELECT uc FROM UserCampaign uc WHERE uc.awardCode=:awardCode")
})
@NamedNativeQueries({
    @NamedNativeQuery(name="findLoginCount", 
		query="SELECT count(*) FROM action_log WHERE action=1 AND user_id=:userId AND date(create_date)=date(:date)"),
	@NamedNativeQuery(name="findShareCount", 
		query="select count(*) FROM action_log WHERE action=2 AND user_id=:userId AND date(create_date)>=:beginDate AND date(create_date)<=:endDate"),
	@NamedNativeQuery(name="findBranchWechatNumber", 
		query="SELECT wechat_number FROM branch_wechat_number WHERE branch_code=:branchCode")
})
public class Campaign implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@Column(name="begin_date")
	private Date beginDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="allow_user_type")
	private int allowUserType;
	
	private String memo;
	
	@Column(name="share_points")
	private int sharePoints;

	@Column(name="banner_pic_url")
	private String bannerPicUrl;

	@Column(name="banner_click_url")
	private String bannerClickUrl;

	private Integer sort;

	public Campaign(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getAllowUserType() {
		return allowUserType;
	}

	public void setAllowUserType(int allowUserType) {
		this.allowUserType = allowUserType;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getSharePoints() {
		return sharePoints;
	}

	public void setSharePoints(int sharePoints) {
		this.sharePoints = sharePoints;
	}

	public String getBannerPicUrl() {
		return bannerPicUrl;
	}

	public void setBannerPicUrl(String bannerPicUrl) {
		this.bannerPicUrl = bannerPicUrl;
	}

	public String getBannerClickUrl() {
		return bannerClickUrl;
	}

	public void setBannerClickUrl(String bannerClickUrl) {
		this.bannerClickUrl = bannerClickUrl;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
