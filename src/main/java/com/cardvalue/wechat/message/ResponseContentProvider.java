package com.cardvalue.wechat.message;

import com.cardvalue.wechat.dto.WeChatMessage;
import com.cardvalue.wechat.model.MessageContent;

public interface ResponseContentProvider {
	
	public void fillContent(WeChatMessage respMessage, MessageContent messageContent,String content);
	
}
