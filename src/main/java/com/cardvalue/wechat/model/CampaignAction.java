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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="campaign_action")
@NamedQueries({
	@NamedQuery(name="getAwardLogs", query="SELECT ca FROM CampaignAction ca WHERE ca.campaign=:campaign and ca.user=:user and ca.amount>0 order by ca.createDate desc")
})
@NamedNativeQueries({
	@NamedNativeQuery(name="getAwardCountInDate", query="SELECT COUNT(*) FROM campaign_action ca WHERE ca.award_id=:awardId AND DATE(create_date)=DATE(:date)"),
	@NamedNativeQuery(name="getAwardCountByDateAndUser", query="SELECT COUNT(*) FROM campaign_action ca WHERE ca.award_id=:awardId AND DATE(create_date)=DATE(:date) AND ca.user_id=:userId"),
	@NamedNativeQuery(name="getAwardAmountInDate", query="SELECT IFNULL(SUM(ca.amount),0.0) FROM campaign_action ca WHERE ca.award_id=:awardId AND DATE(create_date)=DATE(:date)"),
	@NamedNativeQuery(name="getAwardCountByUser", query="SELECT COUNT(*) FROM campaign_action ca WHERE ca.user_id=:userId and campaign_id=:campaignId"),
	@NamedNativeQuery(name="getAwardMessage", query="SELECT IFNULL(mb.label,''), s.name, FORMAT(ca.amount,2) FROM campaign_action ca "
			+ "LEFT JOIN sales s ON(ca.user_id=s.user_id) "
			+ "LEFT JOIN master_branch mb ON (s.branch_code=mb.code) "
			+ "WHERE ca.campaign_id=:campaignId AND ca.award_id <> 0 AND ca.create_date > (NOW() - INTERVAL 6 HOUR) "
			+ "ORDER BY ca.amount DESC, ca.create_date DESC"),
	@NamedNativeQuery(name="getTotalAmount", query="select IFNULL(sum(amount),0) from campaign_action ca where ca.campaign_id=:campaignId and ca.user_id=:userId"),
	@NamedNativeQuery(name="getUsedDrawCount", query="select count(*) from campaign_action ca where ca.campaign_id=:campaignId and ca.user_id=:userId"),
	@NamedNativeQuery(name="dailyReport", query="select mb.label as branch_label, mr.label as region_label, s.name, count(*), sum(ca.amount), "
			+ "(select count(*) from action_log al where al.user_id=s.user_id and al.action=1 and al.create_date>=:beginDate and al.create_date<:endDate) as login_count "
			+ "from campaign_action ca "
			+ "left join sales s on (s.user_id=ca.user_id) "
			+ "left join master_branch mb on (s.branch_code=mb.code) "
			+ "left join master_region mr on (s.region_code=mr.code) "
			+ "where ca.campaign_id=:campaignId and ca.create_date>=:beginDate and ca.create_date<=:endDate "
			+ "group by ca.user_id order by ca.create_date"),
	@NamedNativeQuery(name="getDrawTimesInBranch", query="select count(*) from campaign_action ca "
			+ "left join sales s on s.user_id =ca.user_id "
			+ "where s.branch_code=:branchCode and date(ca.create_date)=curdate() ")
})
public class CampaignAction implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
    @OneToOne(optional=false,cascade={CascadeType.ALL})  
    @JoinColumn(name="user_id", unique=false)  
	private WeUser user;
	
    @OneToOne(optional=false,cascade={CascadeType.ALL})  
    @JoinColumn(name="campaign_id", unique=false)  
	private Campaign campaign;
	
    @Column(name="create_date")
	private Date createDate;

	@Column(name="award_id")
	private int awardId;

	private double amount;
	
	@Column(name="award_memo")
	private String awardMemo;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WeUser getUser() {
		return user;
	}

	public void setUser(WeUser user) {
		this.user = user;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getAwardId() {
		return awardId;
	}

	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}

	public String getAwardMemo() {
		return awardMemo;
	}

	public void setAwardMemo(String awardMemo) {
		this.awardMemo = awardMemo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amout) {
		this.amount = amout;
	}
	
}
