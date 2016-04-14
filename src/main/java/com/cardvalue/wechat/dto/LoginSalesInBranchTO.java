package com.cardvalue.wechat.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.cardvalue.wechat.util.Utility;

public class LoginSalesInBranchTO implements Serializable, Mappable{

	private static final long serialVersionUID = 1L;

	private String branch;
	
	private String total;
	
	private String loggedCount;
	
	private String unLoggedCount;
	
	private String percentage;

	public LoginSalesInBranchTO(){}

	
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getLoggedCount() {
		return loggedCount;
	}

	public void setLoggedCount(String loggedCount) {
		this.loggedCount = loggedCount;
	}

	public String getUnLoggedCount() {
		return unLoggedCount;
	}

	public void setUnLoggedCount(String unLoggedCount) {
		this.unLoggedCount = unLoggedCount;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	@Override
	public void map(Object[] objs) {
		try{
			branch = objs[0].toString();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		total = objs[1].toString();
		loggedCount = objs[2].toString();
		unLoggedCount = objs[3].toString();
		percentage = Utility.formatPercentage(((BigDecimal)objs[4]).doubleValue());
	}
}
