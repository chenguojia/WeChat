package com.cardvalue.wechat.repository;

import java.util.List;

import com.cardvalue.wechat.dto.MessageContentDTO;
import com.cardvalue.wechat.model.MessageContent;
import com.cardvalue.wechat.model.NewsMessageContent;

public interface MessageContentRepository {
	
	public MessageContent findMessageContent(String type, int id);
	
	public List<NewsMessageContent> getChildNews(int parentId);

	public String submitMessageContent(MessageContentDTO dto,String type);
	
}
