package com.cardvalue.wechat.dto;

/**
 * Created by Mr tao on 2015/6/19.
 */
public class CreditsTaskModel {

    private String totalCreditLine;
    private String waitSeconds;
    private String resCode;
    private String resMsg;

    public String getTotalCreditLine() {
        return totalCreditLine;
    }

    public void setTotalCreditLine(String totalCreditLine) {
        this.totalCreditLine = totalCreditLine;
    }

    public String getWaitSeconds() {
        return waitSeconds;
    }

    public void setWaitSeconds(String waitSeconds) {
        this.waitSeconds = waitSeconds;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }
}
