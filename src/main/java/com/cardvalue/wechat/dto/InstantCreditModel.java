package com.cardvalue.wechat.dto;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 通过商户的appid查询商户申请的速融记录对象
 * 
 * @author Administrator
 * 
 */
public class InstantCreditModel {

	@JsonProperty("cashadv_id")
	private String cashadvId;//保理id
	
	@JsonProperty("processor")
	private String processor;//机构
	
	@JsonProperty("CreationDate")
	private String creationDate;//创建日期
	
	@JsonProperty("FundingProduct")
	private String fundingProduct;//还款方式
	
	@JsonProperty("ApproveFundingAmount")
	private String approveFundingAmount;//批准融资额度
	
	@JsonProperty("ApproveFundingPeriod")
	private String approveFundingPeriod;//批准融资期限
	
	@JsonProperty("ApprovePaybackRecur")
	private String approvePaybackRecur;//批准还款单位 天/周
	
	@JsonProperty("ApprovePaybackTimes")
	private String approvePaybackTimes; //和上面字段对应90天或1周
	
	private String unpaidAmount;//未还金额
	
	private String completeRate;//完成率，百分比
	
	private String totalPaid;//已还金额
	
	@JsonProperty("Status")
	private String status;//状态，汉字
	
	private String prodName;//融资产品:直接扣款\POS\速融
	
	private String prodTitle;

	public String getCashadvId() {
		return cashadvId;
	}

	public void setCashadvId(String cashadvId) {
		this.cashadvId = cashadvId;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getFundingProduct() {
		return fundingProduct;
	}

	public void setFundingProduct(String fundingProduct) {
		this.fundingProduct = fundingProduct;
	}

	public String getApproveFundingAmount() {
		return approveFundingAmount;
	}

	public void setApproveFundingAmount(String approveFundingAmount) {
		this.approveFundingAmount = approveFundingAmount;
	}

	public String getApproveFundingPeriod() {
		return approveFundingPeriod;
	}

	public void setApproveFundingPeriod(String approveFundingPeriod) {
		this.approveFundingPeriod = approveFundingPeriod;
	}

	public String getApprovePaybackRecur() {
		return approvePaybackRecur;
	}

	public void setApprovePaybackRecur(String approvePaybackRecur) {
		this.approvePaybackRecur = approvePaybackRecur;
	}

	public String getApprovePaybackTimes() {
		return approvePaybackTimes;
	}

	public void setApprovePaybackTimes(String approvePaybackTimes) {
		this.approvePaybackTimes = approvePaybackTimes;
	}

	public String getUnpaidAmount() {
		return unpaidAmount;
	}

	public void setUnpaidAmount(String unpaidAmount) {
		this.unpaidAmount = unpaidAmount;
	}

	public String getCompleteRate() {
		return completeRate;
	}

	public void setCompleteRate(String completeRate) {
		this.completeRate = completeRate;
	}

	public String getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(String totalPaid) {
		this.totalPaid = totalPaid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdTitle() {
		return prodTitle;
	}

	public void setProdTitle(String prodTitle) {
		this.prodTitle = prodTitle;
	}

}
