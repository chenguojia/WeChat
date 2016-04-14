package com.cardvalue.wechat.dto;

/**
 * Created by Mr tao on 2015/6/15.
 */
public class UpdatePasswordDTO {
    private String merchantId;//后台设置
    private String oldPassword;
    private String newPassword;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
