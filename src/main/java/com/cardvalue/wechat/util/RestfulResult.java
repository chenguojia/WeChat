package com.cardvalue.wechat.util;

/**
 * Created by Mr tao on 2015/5/19.
 */
public class RestfulResult {

    private String resultCode; // -1表示出错 1表示成功

    private String resultMsg; //提示消息

    private Object resultData; //返回对象

    public RestfulResult() {

    }

    public RestfulResult(String resultCode, String resultMsg, Object resultData) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.resultData = resultData;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }
}
