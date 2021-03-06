package com.cardvalue.wechat.repository.jpa;

import com.cardvalue.wechat.dto.QueryPageModel;
import com.cardvalue.wechat.model.FunctionMessageContent;
import com.cardvalue.wechat.model.MessageRule;
import com.cardvalue.wechat.model.NewsMessageContent;
import com.cardvalue.wechat.model.TextMessageContent;
import com.cardvalue.wechat.repository.MessageRuleRepositoryCustom;
import com.cardvalue.wechat.util.Constants;
import org.apache.axis.components.logger.LogFactory;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/1/6.
 */
public class MessageRuleRepositoryImpl implements MessageRuleRepositoryCustom {

    private static final Logger logger = LoggerFactory.getLogger(MessageRuleRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    /**
     * 通过关键字的消息类型查询关键的逻辑集合
     *
     * @param responseType
     * @return
     */
    @Override
    public List getRuleResponseByType(String responseType) {
        if (StringUtils.isNotBlank(responseType)) {
            TypedQuery query = null;
            if (responseType.equals("text")) {
                query = em.createQuery("select t from TextMessageContent t", TextMessageContent.class); //图文消息
            } else if (responseType.equals("news")) {
                query = em.createQuery("select t from NewsMessageContent t", NewsMessageContent.class); //图文消息
            } else {
                query = em.createQuery("select t from FunctionMessageContent t", FunctionMessageContent.class);//特殊逻辑
            }
            return query.getResultList();
        } else {
            return null;
        }
    }

    /**
     * 通过关键字的消息类型和逻辑id查询关键的逻辑对象
     *
     * @param responseType
     * @param responseId
     * @return
     */
    @Override
    public Object getRuleResponseByTypeAndId(String responseType, String responseId) {
        try {
            if (StringUtils.isNotBlank(responseType)) {
                TypedQuery query = null;
                if (responseType.equals("text")) {
                    query = em.createQuery("select t from TextMessageContent t where t.id=:id", TextMessageContent.class); //图文消息
                } else if (responseType.equals("news")) {
                    query = em.createQuery("select t from NewsMessageContent t where t.id=:id", NewsMessageContent.class); //图文消息
                } else {
                    query = em.createQuery("select t from FunctionMessageContent t where t.id=:id", FunctionMessageContent.class);//特殊逻辑
                }
                query.setParameter("id", Integer.valueOf(responseId));
                Object obj = query.getSingleResult();
                return obj;
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            logger.error("通过关键字的消息类型和逻辑id查询关键的逻辑对象出错：", e);
            return null;
        }
    }
}
