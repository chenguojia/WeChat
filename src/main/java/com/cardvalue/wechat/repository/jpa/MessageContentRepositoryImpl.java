package com.cardvalue.wechat.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cardvalue.wechat.dto.MessageContentDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cardvalue.wechat.model.FunctionMessageContent;
import com.cardvalue.wechat.model.MessageContent;
import com.cardvalue.wechat.model.NewsMessageContent;
import com.cardvalue.wechat.model.TextMessageContent;
import com.cardvalue.wechat.repository.MessageContentRepository;
import com.cardvalue.wechat.util.Constants;

@Repository(value = "messageContentRepository")
@Transactional(readOnly=true)
public class MessageContentRepositoryImpl implements MessageContentRepository{

	private static final Logger logger = LoggerFactory.getLogger(MessageContentRepositoryImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public MessageContent findMessageContent(String type, int id) {
		Class clazz = null;
		if(Constants.WE_MESSAGE_TYPE_NEWS.equals(type)){
			clazz = NewsMessageContent.class;
		}else if(Constants.WE_MESSAGE_TYPE_FUNCTION.equals(type)){
			clazz = FunctionMessageContent.class;
		}else{
			clazz = TextMessageContent.class;
		}
		MessageContent messageContent = (MessageContent)em.find(clazz, id);
		return messageContent;
	}

	@Override
	public List<NewsMessageContent> getChildNews(int parentId) {
		TypedQuery<NewsMessageContent> query = em.createQuery("from NewsMessageContent where parentId=:parentId order by sort", NewsMessageContent.class);
		query.setParameter("parentId", parentId);
		return query.getResultList();
	}

	@Override
	public String submitMessageContent(MessageContentDTO dto,String type) {
		try {
			//新增提交
			Object messageContent = null;
			if(type.equals("text")){
				 messageContent = new TextMessageContent();
			}else if(type.equals("news")){
				messageContent = new NewsMessageContent();
			}else{
				messageContent = new FunctionMessageContent();
			}
			PropertyUtils.copyProperties(messageContent, dto);
			em.merge(messageContent);
			//em.persist(messageContent);
			logger.info("新增|修改关键字关联逻辑检索成功!");
			return "1";
		} catch (Exception e) {
			logger.error("添加关键字检索出错:", e);
			return "0";
		}
	}

}
