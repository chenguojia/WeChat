package com.cardvalue.wechat.repository;

import java.util.List;

/**
 * Created by Administrator on 2015/1/6.
 */
public interface MessageRuleRepositoryCustom {

    public List getRuleResponseByType(String responseType);

    public Object getRuleResponseByTypeAndId(String responseType,String responseId);
}
