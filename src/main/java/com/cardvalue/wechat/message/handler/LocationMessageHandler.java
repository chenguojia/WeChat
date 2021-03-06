package com.cardvalue.wechat.message.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.cardvalue.wechat.service.NewMerchantService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cardvalue.wechat.dto.WeChatMessage;
import com.cardvalue.wechat.message.MessageHandler;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.service.BaiduMapService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.Result;

public class LocationMessageHandler extends MessageHandler{

	private final static Logger logger = LoggerFactory.getLogger(LocationMessageHandler.class);
	
	@Resource
	private UserRepository userRepo;
	
	@Resource
	private BaiduMapService mapService;

	@Resource
	private NewMerchantService newMerchantService;

	/**
	 * 微信发送定位消息
	 * @param message
	 * @return
	 * @throws IOException
	 */
	@Override
	public String handle(WeChatMessage message) throws IOException {
		double latitude = message.getLatitude();
		double longitude = message.getLongitude();
		String openId = message.getFromUserName();

		//修改新版商户的经度和纬度
		Map parameter = new HashMap();
		parameter.put("longitude",longitude);
		parameter.put("latitude",latitude);
		newMerchantService.updateMerchantUserlatitudeAndLongitude(openId,parameter);

		//保存老版用户的经纬度信息
		logger.info(String.format("User (%s) Location: latitude %f, longitude %f", openId, latitude, longitude));
		WeUser user = userRepo.findByOpenId(openId);
		if(user != null){
			logger.debug("convert the user coordinator from gps to baidu...");
			Map<String,Double> coord = new HashMap<String, Double>();
			coord.put("x", longitude);
			coord.put("y", latitude);
			Result<Map<String, Double>> result = mapService.convertCoordinators(coord);
			if(StringUtils.equals(result.getCode(), Constants.RESULT_CODE_SUCCESS)){
				latitude = result.getPayload().get("y");
				longitude = result.getPayload().get("x");
			}
			user.setLatitude(latitude);
			user.setLongitude(longitude);
			userRepo.save(user);
			logger.info("User {} location updated", openId);
		}
		return null;
	}
}
