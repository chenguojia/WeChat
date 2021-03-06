package com.cardvalue.wechat.dto;

import java.io.Serializable;

public class LabelValueTO implements Serializable, Mappable{

	private static final long serialVersionUID = 1L;

	private String label;
	
	private String value;

	public LabelValueTO(){}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public void map(Object[] objs) {
		label = objs[0].toString();
		value = objs[1].toString();
	}
}
