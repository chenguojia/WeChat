package com.cardvalue.wechat.dto;

/**
 * Created by Mr tao on 2015/6/1.
 */
public class ApplicationModel {
    private String status;
    private String statusDetail;
    private String appStatus;
    private String leadStatus;
    private String createdAt;
    private String updatedAt;
    private String objectId;
    private String cashadvanceId;
    private String cashadvanceStatus;
    private String isComputingAmount;//是否正在计算额度 1，是；0，否。
    private Double amountRequested;
    private String isAmountLocked;
    private String creditId;//授信id
    private String isEnabled;//授信id
    private String isDocumentLocked;//是否允许修改申请中的资料

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public String getLeadStatus() {
        return leadStatus;
    }

    public void setLeadStatus(String leadStatus) {
        this.leadStatus = leadStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCashadvanceId() {
        return cashadvanceId;
    }

    public void setCashadvanceId(String cashadvanceId) {
        this.cashadvanceId = cashadvanceId;
    }

    public Double getAmountRequested() {
        return amountRequested;
    }

    public void setAmountRequested(Double amountRequested) {
        this.amountRequested = amountRequested;
    }

    public String getIsAmountLocked() {
        return isAmountLocked;
    }

    public void setIsAmountLocked(String isAmountLocked) {
        this.isAmountLocked = isAmountLocked;
    }

    public String getCashadvanceStatus() {
        return cashadvanceStatus;
    }

    public void setCashadvanceStatus(String cashadvanceStatus) {
        this.cashadvanceStatus = cashadvanceStatus;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getIsComputingAmount() {
        return isComputingAmount;
    }

    public void setIsComputingAmount(String isComputingAmount) {
        this.isComputingAmount = isComputingAmount;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getIsDocumentLocked() {
        return isDocumentLocked;
    }

    public void setIsDocumentLocked(String isDocumentLocked) {
        this.isDocumentLocked = isDocumentLocked;
    }
}
