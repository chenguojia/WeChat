package com.cardvalue.wechat.dto;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include=Inclusion.NON_EMPTY)
public class WeMenu {

	@JsonProperty("button")
	List<WeButton> buttons = new ArrayList<WeButton>();

	public List<WeButton> getButtons() {
		return buttons;
	}

	public void setButtons(List<WeButton> buttons) {
		this.buttons = buttons;
	}
	
}
