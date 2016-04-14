package com.cardvalue.wechat.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cardvalue.wechat.util.Constants;

public class SaveMerchantDTO {

    @NotNull
    @Pattern(regexp="\\d{15}", message="注册登记号需要是15位的数字")
	private String registerNumber;
	
    @NotNull
    @Pattern(regexp="\\d{15}", message="商户编号需要是15位的数字")
	private String mid;
	
    @NotNull
    @Size(min=4, message="商户名称至少大于4位")
	private String name;
	
    @NotNull
    @Size(min=2, message="联系人名称至少大于2位")
	private String contactName;
	
    @NotNull
    @Pattern(regexp=Constants.VALID_PATTERN_MOBILE, message="请输入正确的手机号")
	private String contactMobile;

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
    
}
