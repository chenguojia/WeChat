package com.cardvalue.wechat.dto;

/**
 * Created by Mr tao on 2015/5/26.
 */
public class PosLimitDTO {

    private String creditId;//授信id，后台赋值

    private String mids;

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getMids() {
        return mids;
    }

    public void setMids(String mids) {
        this.mids = mids;
    }

}
