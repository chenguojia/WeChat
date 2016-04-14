package com.cardvalue.wechat.message.response;

import com.cardvalue.wechat.dto.WeChatMessage;
import com.cardvalue.wechat.message.ResponseContentProvider;
import com.cardvalue.wechat.model.MessageContent;
import com.cardvalue.wechat.model.TextMessageContent;

public class TextResponseContentProvider implements ResponseContentProvider{

	@Override
	public void fillContent(WeChatMessage respMessage, MessageContent messageContent,String content) {
		TextMessageContent textContent = (TextMessageContent)messageContent;
		respMessage.setContent(textContent.getContent());
	}

}
