package com.cardvalue.wechat.service.impl;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cardvalue.wechat.dto.WeCreateQrCodeRequestDTO;
import com.cardvalue.wechat.dto.WeCreateQrCodeResponseDTO;
import com.cardvalue.wechat.service.WeChatService;
import com.cardvalue.wechat.service.WeQrCodeService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.HttpUtils;

@Service
public class WeQrCodeServiceImpl implements WeQrCodeService{

	private static final Logger logger = LoggerFactory.getLogger(WeQrCodeServiceImpl.class);
	
	@Resource
	private WeChatService weService;
	
	@Value("${we.qrcode.create.url}")
	private String createQrCodeUrl;
	
	@Value("${we.qrcode.show.url}")
	private String showQrCodeUrl;
	
	@Override
	public WeCreateQrCodeResponseDTO createQrCode(String parameter, boolean isLimit) {
		String accessToken = weService.getAccessToken();
		Map<String, String> params = new HashMap<String, String>();
		params.put(Constants.WE_PARAM_NAME_ACCESS_TOKEN, accessToken);
		WeCreateQrCodeResponseDTO response = null;
		WeCreateQrCodeRequestDTO request = new WeCreateQrCodeRequestDTO();
		if(isLimit){
			request.setActionName("QR_LIMIT_SCENE");
		}else{
			request.setActionName("QR_SCENE");
			request.setExpireSeconds(1800);
		}
		request.getActionInfo().getScene().setSceneId(Long.parseLong(parameter));
		try {
			ObjectMapper mapper = new ObjectMapper();
			String requestJson = mapper.writeValueAsString(request);
			logger.debug("request json: {}", requestJson);
			String responseBody = HttpUtils.executeHttpRequest(createQrCodeUrl, params, HttpPost.METHOD_NAME, requestJson);
			response = mapper.readValue(responseBody, WeCreateQrCodeResponseDTO.class);
		} catch (Exception e) {
			logger.error("Error:", e);
		}
		return response;
	}

	@Override
	public String getQrCodeUrl(String ticket) {
		String url = null;
		try {
			URIBuilder builder = new URIBuilder(showQrCodeUrl);
			builder.addParameter(Constants.WE_PARAM_NAME_TICKET, ticket);
			url = builder.toString();
			logger.debug("Show QrCode URL : {}", url);
		} catch (URISyntaxException e) {
			logger.error("Error:", e);
		}
		return url;
	}

}
