package com.cardvalue.wechat.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by Mr tao on 2015/2/9.
 */
public class WeNewActivitiesDto {
    private Integer id;

    @NotNull
    private Integer userType;

    @NotNull
    private Integer responseId;

    @NotNull
    private String responseType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getResponseId() {
        return responseId;
    }

    public void setResponseId(Integer responseId) {
        this.responseId = responseId;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
}
