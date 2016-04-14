package com.cardvalue.wechat.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.cardvalue.wechat.util.Utility;


public class ActiveRateDTO implements Mappable{
	
	private String branch;
	
	private String totalRate;
	
	private String monthRate;
	
	private String ratePerCapital;

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(String totalRate) {
		this.totalRate = totalRate;
	}

	public String getMonthRate() {
		return monthRate;
	}

	public void setMonthRate(String monthRate) {
		this.monthRate = monthRate;
	}

	public String getRatePerCapital() {
		return ratePerCapital;
	}

	public void setRatePerCapital(String ratePerCapital) {
		this.ratePerCapital = ratePerCapital;
	}

	@Override
	public void map(Object[] objs) {
		branch = String.valueOf(objs[0]);
		totalRate = String.valueOf(objs[1]);
		monthRate = String.valueOf(objs[2]);
		BigDecimal iMonthRate = (BigDecimal)objs[2];
		BigInteger salesCount = (BigInteger)objs[3];
		ratePerCapital = Utility.formatDouble(iMonthRate.doubleValue()/salesCount.intValue());
	}
	
}
