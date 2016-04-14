package com.cardvalue.wechat.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.*;

import javax.annotation.Resource;

import com.cardvalue.wechat.dto.we.custom.TemplateMessage;
import com.cardvalue.wechat.model.WeTemplateMessage;
import com.cardvalue.wechat.model.WeTemplateMessageParameter;
import com.cardvalue.wechat.repository.WeTemplateMessageParameterRepository;
import com.cardvalue.wechat.repository.WeTemplateMessageRepository;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cardvalue.wechat.dto.WeChatMessage;
import com.cardvalue.wechat.dto.WeCommonResponse;
import com.cardvalue.wechat.dto.WeGroup;
import com.cardvalue.wechat.dto.WeGroupCreateRequest;
import com.cardvalue.wechat.dto.WeGroupCreateResponse;
import com.cardvalue.wechat.dto.WeGroupListResponse;
import com.cardvalue.wechat.dto.WeGroupMoveRequest;
import com.cardvalue.wechat.dto.WeGroupUpdateRequest;
import com.cardvalue.wechat.dto.WeMenu;
import com.cardvalue.wechat.dto.we.custom.TextMessage;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.service.UserService;
import com.cardvalue.wechat.service.WeChatService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.HttpUtils;
import com.cardvalue.wechat.util.Result;
import com.cardvalue.wechat.util.XMLConverter;

@Service
public class WeChatServiceImpl implements WeChatService{

	private static final Logger logger = LoggerFactory.getLogger(WeChatServiceImpl.class);
	
	@Autowired
	private XMLConverter xmlConverter;

	@Value( "${wechat.username}" )
	private String weChatUsername;
	
	@Value( "${wechat.url}" )
	private String weChatUrl;
	
	@Value( "${wechat.send.url}" )
	private String weChatSendUrl;

	@Value( "${wechat.send.template.url}" )
	private String weChatSendTemplateUrl;

	@Value( "${wechat.entry.message}" )
	private String entryMessage;
	
	@Value( "${wechat.entry.text.keyword}" )
	private String entryTextKeyWord;
	
	@Value( "${wechat.entry.click.keyword}" )
	private String entryClickKeyword;
	
	@Value( "${wechat.appid}" )
	private String appId;
	
	@Value( "${wechat.secret}" )
	private String secret;	
	
	@Value( "${wechat.accesstoken.url}" )
	private String weChatAccessTokenUrl;
	
	@Value(" ${wechat.gettoken.url} ")
	private String weChatGetTokenUrl;
	
	@Value(" ${we.menu.create.url} ")
	private String weChatCreateMenuUrl;
	
	@Value(" ${we.group.list.url} ")
	private String weChatGroupListUrl;
	
	@Value(" ${we.group.create.url} ")
	private String weChatGroupCreateUrl;
	
	@Value(" ${we.group.move.url} ")
	private String weChatGroupMoveUrl;
	
	@Value(" ${we.group.update.url} ")
	private String weChatGroupUpdateUrl;

	@Value("${wechat.app.name}")
	private String appName;

	@Value("${wechat.appid}")
	private String weAppId;
	
	@Resource
	private UserRepository userRepository;
	
	@Resource
	private UserService userService;
	
	private static String accessToken;
	
	private static Date accessTokenExpireDate;

	@Resource
	private WeTemplateMessageRepository weTemplateMessageRepository;

	@Resource
	private WeTemplateMessageParameterRepository weTemplateMessageParameterRepository;


	@Override
	public void pushMessage(String openId, String content){
		TextMessage message = new TextMessage();
		message.setTouser(openId);
		message.getText().setContent(content);
		ObjectMapper mapper = new ObjectMapper();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String accessToken = getAccessToken();
		HttpPost httpPost = new HttpPost(weChatSendUrl + "access_token=" + accessToken);
		httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");  
		try{
			String customMessage = mapper.writeValueAsString(message);
			logger.info("push custom message [openid:" + openId + "][message:" + customMessage + "]");
			httpPost.setEntity(new StringEntity(customMessage, "utf-8"));
			CloseableHttpResponse response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			StringBuilder sb = new StringBuilder();
			if(entity.isStreaming()){
				BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
				String line = reader.readLine();
				while(line != null){
					sb.append(line);
					line = reader.readLine();
				}
			}
			EntityUtils.consume(response.getEntity());
			logger.info("push custom message and get result:" + sb.toString());
			response.close();
		}catch(Exception e){
			logger.error("error occurs while sending custom message", e);
		}finally{
			if(httpclient != null){
				try {
					httpclient.close();
				} catch (IOException e) {
					logger.error("error occurs while close http client", e);
				}
			}
		}
	}

	/**
	 * 推送自定义模板消息
	 * @param openId 接受者
	 * @param templateName 模板中文名称
	 * @param values 模板中参数
	 */
	public void pushTemplateMessage(String openId, String templateName,Object ... values){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String accessToken = getAccessToken();
		ObjectMapper mapper = new ObjectMapper();
		HttpPost httpPost = new HttpPost(weChatSendTemplateUrl + "access_token=" + accessToken);
		httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
		try{
			//组装post参数
			String customMessage = "";
			String data = "\"data\":{";
			List<WeTemplateMessage> weTemplateMessages = weTemplateMessageRepository.findByName(templateName);
			if(weTemplateMessages != null && weTemplateMessages.size() > 0) {
				WeTemplateMessage weTemplateMessage = weTemplateMessages.get(0);
				String url = "https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2F220.248.19.21%2F" + appName
						    + "%2Fhome%2Fenter%3FredirectUrl%3D"+ (StringUtils.isNotBlank(weTemplateMessage.getUrl()) ? URLEncoder.encode(weTemplateMessage.getUrl()) : "/") +"&response_type=code&scope=snsapi_base&appid=" + weAppId;
				TemplateMessage templateMessage = new TemplateMessage(openId,weTemplateMessage.getIdentifer(),url, weTemplateMessage.getTopcolor());
				customMessage = mapper.writeValueAsString(templateMessage);
				List<WeTemplateMessageParameter> weTemplateMessageParameters = weTemplateMessageParameterRepository.findByTempId(weTemplateMessage.getId());
				if(weTemplateMessageParameters != null && weTemplateMessageParameters.size() > 0 && weTemplateMessageParameters.size() == values.length) {
					for (int i = 0 ;i < weTemplateMessageParameters.size(); i ++) {
						WeTemplateMessageParameter weTemplateMessageParameter = weTemplateMessageParameters.get(i);
						data += " \""+ weTemplateMessageParameter.getName() +"\": { \"value\":\""+  (StringUtils.isNotBlank(weTemplateMessageParameter.getContent()) ?  weTemplateMessageParameter.getContent() : values[i])  +"\",\"color\":\"" + weTemplateMessageParameter.getColor() + "\" },";
					}
				}
			}
			data = data.substring(0,data.length() - 1) + "}";//减去最后一个,号
			customMessage = customMessage.substring(0,customMessage.length() - 1) + "," + data + "}";

			logger.info("push custom template message [openid:" + openId + "][message:" + customMessage + "]");
			httpPost.setEntity(new StringEntity(customMessage, "utf-8"));
			CloseableHttpResponse response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			StringBuilder sb = new StringBuilder();
			if(entity.isStreaming()){
				BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
				String line = reader.readLine();
				while(line != null){
					sb.append(line);
					line = reader.readLine();
				}
			}
			EntityUtils.consume(response.getEntity());
			logger.info("push custo template message and get result:" + sb.toString());
			response.close();
		}catch(Exception e){
			logger.error("error occurs while sending custom message", e);
		}finally{
			if(httpclient != null){
				try {
					httpclient.close();
				} catch (IOException e) {
					logger.error("error occurs while close http client", e);
				}
			}
		}
	}
	
	@Override
	public String getOpenIdByAccessToken(String code){
		String openId = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("appid", appId);
		map.put("secret", secret);
		map.put("code", code);
		try{
			String responseBody = HttpUtils.executeHttpRequest(weChatAccessTokenUrl, map, HttpGet.METHOD_NAME);
			JsonFactory jsonFactory = new JsonFactory();
			JsonParser jParser = jsonFactory.createJsonParser(responseBody);
			while (jParser.nextToken() != JsonToken.END_OBJECT) {
				String fieldName = jParser.getCurrentName();
				logger.debug("json token : {}, text : {}", fieldName, jParser.getText());
				if ("openid".equals(fieldName)) {
					jParser.nextToken();
					openId = jParser.getText();
					logger.info("open id: {}", openId);
				}
			}
		}catch(Exception e){
			logger.error("error : " , e);
		}
		return openId;
	}
	
	@SuppressWarnings("unused")
	private boolean checkMessageType(WeChatMessage message, String type){
		boolean flag = false;
		if(message != null){
			if(message.getMsgType().equals("event")){
				String key = message.getEventKey();
				flag = StringUtils.contains(key, type);
				logger.info("key: {} entryClickKeyword: {}", key, entryMessage);
			}
		}
		return flag;
	}
	
	@Override
	public synchronized String getAccessToken(){
		logger.info("Get access token [accessTokenExpireDate:" + accessTokenExpireDate + "]");
		logger.info("Get access token [currentDate:" + Calendar.getInstance().getTime() + "]");
		boolean tokenExpired = accessTokenExpireDate == null || Calendar.getInstance().getTime().after(accessTokenExpireDate);
		if(tokenExpired){
			Map<String, String> params = new HashMap<String, String>();
			params.put(Constants.WE_PARAM_NAME_APPID, appId);
			params.put(Constants.WE_PARAM_NAME_SECRET, secret);
			params.put(Constants.WE_PARAM_NAME_GRANT_TYPE, Constants.WE_PARAM_VALUE_GRANT_TYPE);
			try {
				String responseBody = HttpUtils.executeHttpRequest(weChatGetTokenUrl, params, HttpGet.METHOD_NAME);
				ObjectMapper mapper = new ObjectMapper();
				Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String,String>>(){});
				Calendar current = Calendar.getInstance();
				accessToken = map.get(Constants.WE_RESPONSE_KEY_ACCESS_TOKEN);
				current.add(Calendar.SECOND, Integer.parseInt(map.get(Constants.WE_RESPONSE_KEY_EXPIRES_IN)));
				accessTokenExpireDate = current.getTime();
			} catch (Exception e) {
				logger.error("error : " , e);
			}
		}
		return accessToken;
	}

	@Override
	public void createMenu(WeMenu menu) {
		String accessToken = getAccessToken();
		Map<String, String> params = new HashMap<String, String>();
		params.put(Constants.WE_PARAM_NAME_ACCESS_TOKEN, accessToken);
		try {
			ObjectMapper mapper = new ObjectMapper();
			String menuJsonString = mapper.writeValueAsString(menu);
			logger.info("menu json string : {}", menuJsonString);
			String responseBody = HttpUtils.executeHttpRequest(weChatCreateMenuUrl, params, HttpPost.METHOD_NAME, menuJsonString);
			Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String,String>>(){});
			if(!map.get("errcode").equals("0")){
				logger.error("create menu failed");
			}
		} catch (Exception e) {
			logger.error("error : " , e);
		}
	}
	
	@Override
	public Result<?> listGroups() {
		String accessToken = getAccessToken();
		Map<String, String> params = new HashMap<String, String>();
		params.put(Constants.WE_PARAM_NAME_ACCESS_TOKEN, accessToken);
		Result<List<WeGroup>> result = new Result<List<WeGroup>>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		try {
			ObjectMapper mapper = new ObjectMapper();
			String responseBody = HttpUtils.executeHttpRequest(weChatGroupListUrl, params, HttpGet.METHOD_NAME);
			try{
				WeGroupListResponse response = mapper.readValue(responseBody, WeGroupListResponse.class);
				result.setCode(Constants.RESULT_CODE_SUCCESS);
				result.setPayload(response.getGroups());
			}catch(JsonMappingException e){
				logger.info("", e);
				WeCommonResponse resp = mapper.readValue(responseBody, WeCommonResponse.class);
				result.setMessage(resp.getErrmsg());
			}
		} catch (Exception e) {
			logger.error("error : " , e);
			result.setMessage(e.toString());
		}
		return result;
	}
	
	@Override
	public Result<?> createGroup(String name) {
		String accessToken = getAccessToken();
		Map<String, String> params = new HashMap<String, String>();
		params.put(Constants.WE_PARAM_NAME_ACCESS_TOKEN, accessToken);
		Result<Object> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		try {
			ObjectMapper mapper = new ObjectMapper();
			WeGroupCreateRequest request = new WeGroupCreateRequest();
			request.getGroup().setName(name);
			String responseBody = HttpUtils.executeHttpRequest(weChatGroupCreateUrl, params, HttpPost.METHOD_NAME, mapper.writeValueAsString(request));
			try{
				WeGroupCreateResponse resp = mapper.readValue(responseBody, WeGroupCreateResponse.class);
				result.setCode(Constants.RESULT_CODE_SUCCESS);
				result.setPayload(resp);
			}catch(JsonMappingException e){
				logger.info("", e);
				WeCommonResponse resp = mapper.readValue(responseBody, WeCommonResponse.class);
				result.setMessage(resp.getErrmsg());
			}
		} catch (Exception e) {
			logger.error("error : " , e);
			result.setMessage(e.toString());
		}
		return result;
	}
	
	@Override
	public Result<?> moveUserToGroup(String openId, int groupId) {
		String accessToken = getAccessToken();
		Map<String, String> params = new HashMap<String, String>();
		params.put(Constants.WE_PARAM_NAME_ACCESS_TOKEN, accessToken);
		Result<Object> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		try {
			ObjectMapper mapper = new ObjectMapper();
			WeGroupMoveRequest request = new WeGroupMoveRequest();
			request.setGroupId(groupId);
			request.setOpenId(openId);
			String responseBody = HttpUtils.executeHttpRequest(weChatGroupMoveUrl, params, HttpPost.METHOD_NAME, mapper.writeValueAsString(request));
			WeCommonResponse resp = mapper.readValue(responseBody, WeCommonResponse.class);
			if(resp.getErrcode() == 0){
				result.setCode(Constants.RESULT_CODE_SUCCESS);
			}else{
				result.setMessage(resp.getErrmsg());
			}
		} catch (Exception e) {
			logger.error("error : " , e);
			result.setMessage(e.toString());
		}
		return result;
	}
	
	@Override
	public Result<?> updateGroup(int groupId, String groupName) {
		String accessToken = getAccessToken();
		Map<String, String> params = new HashMap<String, String>();
		params.put(Constants.WE_PARAM_NAME_ACCESS_TOKEN, accessToken);
		Result<Object> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		try {
			ObjectMapper mapper = new ObjectMapper();
			WeGroupUpdateRequest request = new WeGroupUpdateRequest();
			request.getGroup().setId(groupId);
			request.getGroup().setName(groupName);
			String responseBody = HttpUtils.executeHttpRequest(weChatGroupUpdateUrl, params, HttpPost.METHOD_NAME, mapper.writeValueAsString(request));
			WeCommonResponse resp = mapper.readValue(responseBody, WeCommonResponse.class);
			if(resp.getErrcode() == 0){
				result.setCode(Constants.RESULT_CODE_SUCCESS);
			}else{
				result.setMessage(resp.getErrmsg());
			}
		}catch (Exception e) {
			logger.error("error : " , e);
			result.setMessage(e.toString());
		}
		return result;
	}
}
