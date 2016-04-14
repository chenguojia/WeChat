package com.cardvalue.wechat.message.response;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.cardvalue.wechat.dto.NewsItem;
import com.cardvalue.wechat.dto.WeChatMessage;
import com.cardvalue.wechat.message.ResponseContentProvider;
import com.cardvalue.wechat.model.MessageContent;
import com.cardvalue.wechat.model.NewsMessageContent;
import com.cardvalue.wechat.repository.MessageContentRepository;

public class NewsResponseContentProvider implements ResponseContentProvider{

	@Resource
	private MessageContentRepository messageContentRepo;
	
	@Override
	public void fillContent(WeChatMessage respMessage, MessageContent messageContent,String content) {
		NewsMessageContent newsContent = (NewsMessageContent)messageContent;
		List<NewsItem> items = new ArrayList<NewsItem>();
		List<NewsMessageContent> articles = messageContentRepo.getChildNews(newsContent.getId());
		articles.add(0, newsContent);
		for(NewsMessageContent article : articles){
			NewsItem item = new NewsItem();
			item.setTitle(article.getTitle());
			item.setDescription(article.getDescription());
			item.setPicUrl(article.getPictureUrl());
			item.setUrl(article.getUrl());
			items.add(item);
		}
		respMessage.setArticles(items);
		respMessage.setArticleCount(String.valueOf(items.size()));
	}

}
