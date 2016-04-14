package com.cardvalue.wechat.service;

import com.cardvalue.wechat.dto.WeCreateQrCodeResponseDTO;

public interface WeQrCodeService {

	public WeCreateQrCodeResponseDTO createQrCode(String parameter, boolean isLimit);
	
	public String getQrCodeUrl(String ticket);
	
}
