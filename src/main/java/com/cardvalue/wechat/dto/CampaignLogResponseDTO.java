package com.cardvalue.wechat.dto;

import java.util.ArrayList;
import java.util.List;

public class CampaignLogResponseDTO {

	private String totalAmount;
	
	private String awardCode;
	
	private String hotline;
	
	private String timeTillEnd;
	
	private List<AwardLog> awardList = new ArrayList<AwardLog>();

	private String wechatNumber;
	
	private boolean awardGave;
	
	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getAwardCode() {
		return awardCode;
	}

	public void setAwardCode(String awardCode) {
		this.awardCode = awardCode;
	}

	public String getHotline() {
		return hotline;
	}

	public void setHotline(String hotLine) {
		this.hotline = hotLine;
	}

	public String getTimeTillEnd() {
		return timeTillEnd;
	}

	public void setTimeTillEnd(String timeTillEnd) {
		this.timeTillEnd = timeTillEnd;
	}

	public List<AwardLog> getAwardList() {
		return awardList;
	}
	
	public void addAward(String date, String amount){
		AwardLog log = new AwardLog(date, amount);
		awardList.add(log);
	}
	
	public String getWechatNumber() {
		return wechatNumber;
	}

	public void setWechatNumber(String wechatNumber) {
		this.wechatNumber = wechatNumber;
	}

	public boolean isAwardGave() {
		return awardGave;
	}

	public void setAwardGave(boolean gaveAward) {
		this.awardGave = gaveAward;
	}

	public class AwardLog{
		private String date;
		
		private String amount;

		public AwardLog(String date, String amount) {
			super();
			this.date = date;
			this.amount = amount;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}
		
	}
	
}
