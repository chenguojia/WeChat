package com.cardvalue.wechat.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by Mr tao on 2015/1/7.
 */
public class MessageRuleDTO {

    private Integer id;

    @NotNull
    private Integer priority;

    @NotNull
    private String keyword;

    @NotNull
    private String responseType;

    @NotNull
    private String responseId;

    @NotNull
    private String ruleType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }
}
