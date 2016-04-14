package com.cardvalue.wechat.util;

import org.codehaus.jackson.annotate.JsonProperty;


public class PageableResult<T> extends Result<T>{
	
	private int totalNumber;
	
	@JsonProperty("pageNum")
	private int pageNumber;
	
	private int pageSize;
	
	private int numRows;
	
	private int pageCount;

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getNumRows() {
		return numRows;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
}
