package com.cardvalue.wechat.service;

import com.cardvalue.wechat.dto.MessageRuleDTO;

import java.util.List;

/**
 * Created by Mr tao on 2015/1/7.
 */
public interface MessageRuleService {

    public String submitRule(MessageRuleDTO dto);

    public List getRuleResponseByType(String responseType);

    public Object getRuleResponseByTypeAndId(String responseType, String responseId);

}
