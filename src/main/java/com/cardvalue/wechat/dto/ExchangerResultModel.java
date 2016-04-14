package com.cardvalue.wechat.dto;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangerResultModel {
	
	private List<ExchangeFooterModel> footer;
	
	private List<ExchangeRecordModel> rows; //对账单明细
	
	private Integer total;//对账单行数

	public List<ExchangeFooterModel> getFooter() {
		return footer;
	}

	public void setFooter(List<ExchangeFooterModel> footer) {
		this.footer = footer;
	}

	public List<ExchangeRecordModel> getRows() {
		return rows;
	}

	public void setRows(List<ExchangeRecordModel> rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
}
