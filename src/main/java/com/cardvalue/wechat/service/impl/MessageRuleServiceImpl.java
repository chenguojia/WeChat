package com.cardvalue.wechat.service.impl;

import com.cardvalue.wechat.dto.MessageRuleDTO;
import com.cardvalue.wechat.model.MessageRule;
import com.cardvalue.wechat.repository.MessageRuleRepository;
import com.cardvalue.wechat.service.MessageRuleService;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Mr tao on 2015/1/7.
 */
@Service(value = "MessageRuleService")
public class MessageRuleServiceImpl implements MessageRuleService {

    private static final Logger logger = LoggerFactory.getLogger(MessageRuleServiceImpl.class);

    @Resource
    private MessageRuleRepository messageRuleRepository;

    @Override
    public String submitRule(MessageRuleDTO dto) {
        try {
            //新增提交
            MessageRule rule = new MessageRule();
            PropertyUtils.copyProperties(rule, dto);
            messageRuleRepository.save(rule);
            logger.info("新增|修改关键字检索成功!id为:" + rule.getId());
            return "1";
        } catch (Exception e) {
            logger.error("添加关键字检索出错:", e);
            return "0";
        }
    }

    @Override
    public List getRuleResponseByType(String responseType) {
        return messageRuleRepository.getRuleResponseByType(responseType);
    }

    @Override
    public Object getRuleResponseByTypeAndId(String responseType,String responseId) {
        return messageRuleRepository.getRuleResponseByTypeAndId(responseType, responseId);
    }

}
