package com.cardvalue.wechat.message;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import com.cardvalue.wechat.dto.WeChatMessage;
import com.cardvalue.wechat.message.handler.ClickMessageHandler;
import com.cardvalue.wechat.message.handler.ImageMessageHandler;
import com.cardvalue.wechat.message.handler.LocationMessageHandler;
import com.cardvalue.wechat.message.handler.ScanMessageHandler;
import com.cardvalue.wechat.message.handler.SubscribeMessageHandler;
import com.cardvalue.wechat.message.handler.TextMessageHandler;
import com.cardvalue.wechat.message.handler.UnsubscribeMessageHandler;
import com.cardvalue.wechat.util.Constants;

@Component
public class MessageHandlers {
	
	@Resource
	private AutowireCapableBeanFactory autowireBeanFactory;
	
	public MessageHandler getMessageHandler(WeChatMessage message) throws Exception{
		String type = message.getMsgType();
		MessageHandler handler = null;
		if(StringUtils.equals(Constants.WE_MESSAGE_TYPE_TEXT, type)){
			handler = new TextMessageHandler();
		}else if(StringUtils.equals(Constants.WE_MESSAGE_TYPE_IMAGE, type)){
			handler = new ImageMessageHandler();
		}else if(StringUtils.equals(Constants.WE_MESSAGE_TYPE_EVENT, type)){
			String eventType = message.getEvent();
			if(StringUtils.equalsIgnoreCase(Constants.WE_EVENT_TYPE_SUBSCRIBE, eventType)){
				handler = new SubscribeMessageHandler();
			}else if(StringUtils.equalsIgnoreCase(Constants.WE_EVENT_TYPE_UNSUBSCRIBE, eventType)){
				handler = new UnsubscribeMessageHandler();
			}else if(StringUtils.equalsIgnoreCase(Constants.WE_EVENT_TYPE_SCAN, eventType)){
				handler = new ScanMessageHandler();
			}else if(StringUtils.equalsIgnoreCase(Constants.WE_EVENT_TYPE_CLICK, eventType)){
				handler = new ClickMessageHandler();
			}else if(StringUtils.equalsIgnoreCase(Constants.WE_EVENT_TYPE_LOCATION, eventType)){
				handler = new LocationMessageHandler();
			}else{
				throw new Exception("Unknown WE message type : " + type);
			}
		}else{
			throw new Exception("Unknown WE message type : " + type);
		}
		autowireBeanFactory.autowireBean(handler);
		return handler;
	}
	
}
