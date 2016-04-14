package com.cardvalue.wechat.dto;

/**
 * Created by Mr tao on 2015/6/1.
 */
public class NewMerchantModel {
    private String mobile;//新商户的手机号码
    private String userId;//新商户的用户id

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
