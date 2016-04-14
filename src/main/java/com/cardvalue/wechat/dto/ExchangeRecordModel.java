package com.cardvalue.wechat.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRecordModel {
	
	@JsonProperty("OutJine")
	private String outJine;
	
	private String cvFee;
	
	private String paymentAmt;
	
	private String xyid;
	
	@JsonProperty("InJine")
	private String inJine;
	
	private String huankuan;
	
	private String qingsuandate;
	
	private String baoli;

	@JsonProperty("pos_repaymentDate")
	private String posRepaymentDate;

	public String getOutJine() {
		return outJine;
	}

	public void setOutJine(String outJine) {
		this.outJine = outJine;
	}

	public String getCvFee() {
		return cvFee;
	}

	public void setCvFee(String cvFee) {
		this.cvFee = cvFee;
	}

	public String getPaymentAmt() {
		return paymentAmt;
	}

	public void setPaymentAmt(String paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	public String getXyid() {
		return xyid;
	}

	public void setXyid(String xyid) {
		this.xyid = xyid;
	}

	public String getInJine() {
		return inJine;
	}

	public void setInJine(String inJine) {
		this.inJine = inJine;
	}

	public String getHuankuan() {
		return huankuan;
	}

	public void setHuankuan(String huankuan) {
		this.huankuan = huankuan;
	}

	public String getQingsuandate() {
		return qingsuandate;
	}

	public void setQingsuandate(String qingsuandate) {
		this.qingsuandate = qingsuandate;
	}

	public String getBaoli() {
		return baoli;
	}

	public void setBaoli(String baoli) {
		this.baoli = baoli;
	}

	public String getPosRepaymentDate() {
		return posRepaymentDate;
	}

	public void setPosRepaymentDate(String posRepaymentDate) {
		this.posRepaymentDate = posRepaymentDate;
	}
}
