package com.cardvalue.wechat.dto;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Mr tao on 2015/1/14.
 */

public class CreditPruductModel {

    @JsonProperty(value = "prod_id")
    private String prodId;

    @JsonProperty(value = "prod_name")
    private String prodName;

    private String days;

    private String credit;

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }
}
