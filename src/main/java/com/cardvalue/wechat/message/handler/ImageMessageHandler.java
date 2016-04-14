package com.cardvalue.wechat.message.handler;

import java.io.IOException;

import com.cardvalue.wechat.dto.WeChatMessage;
import com.cardvalue.wechat.message.MessageHandler;

public class ImageMessageHandler extends MessageHandler {

	@Override
	public String handle(WeChatMessage message) throws IOException {
		String respXml = matchImage(message);
		return respXml;
	}
}
