package com.cardvalue.wechat.dto;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Mr tao on 2015/5/26.
 */
public class AddShopDTO {
    private String appId;//最新保理id
    private String name;
    private String mids;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (StringUtils.isNotBlank(name) && name.length() > 1)
            this.name = name.substring(0,name.length() - 1);
        else
            this.name = name;
    }

    public String getMids() {
        return mids;
    }

    public void setMids(String mids) {
        this.mids = mids;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
