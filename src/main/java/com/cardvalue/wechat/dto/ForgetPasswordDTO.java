package com.cardvalue.wechat.dto;

/**
 * Created by Mr tao on 2015/6/8.
 */
public class ForgetPasswordDTO {
    private String mobile; //手机号
    private String password; //密码
    private String checkCode;//验证码

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}
