package com.cardvalue.wechat.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * 调用网站接口，返回授信列表model
 *
 * @author Administrator
 */
public class WebsiteCreditModel {

    private String mobile;//手机号/用户名

    @JsonProperty("app_id")
    private String appId;

    @JsonProperty("corp_name")
    private String corpName;

    @JsonProperty("mid_list")
    private String midList;

    @JsonProperty("check_name")
    private String checkName;

    @JsonProperty("planned_amt")
    private String plannedAmt;

    @JsonProperty("planned_days")
    private String plannedDays;

    @JsonProperty("dd_credit")
    private String ddCredit;//账户直接扣款

    @JsonProperty("dd_days")
    private String ddDays;//周周还，还款周期

    @JsonProperty("instant_credit")
    private String instantCredit;//速融产品

    @JsonProperty("instant_days")
    private String instantDays;//速融，还款周期

    @JsonProperty("pos_credit")
    private String posCredit;//关联POS还款产品

    @JsonProperty("pos_days")
    private String posDays;//pos还款，还款周期

    @JsonProperty("credit_effdate")
    private String creditEffDate;

    @JsonProperty("credit_expdate")
    private String creditExpDate;

    private String flag;

    @JsonProperty("last_request_time")
    private String lastRequestTime;

    @JsonProperty("next_available_request_time")
    private String nextAvailableRequestTime;

    private List<CreditPruductModel> results;//产品结果

    private String trans;//交易流水,暂时不做处理

    @JsonProperty("answer_passed")
    private String answerPassed;//商编校验用的,暂时不做处理

    @JsonProperty("wrong_times")
    private String wrongTimes;

    @JsonProperty("credit_pass_flag")
    private String creditPassFlag;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getMidList() {
        return midList;
    }

    public void setMidList(String midList) {
        this.midList = midList;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getPlannedAmt() {
        return plannedAmt;
    }

    public void setPlannedAmt(String plannedAmt) {
        this.plannedAmt = plannedAmt;
    }

    public String getPlannedDays() {
        return plannedDays;
    }

    public void setPlannedDays(String plannedDays) {
        this.plannedDays = plannedDays;
    }

    public String getDdCredit() {
        return ddCredit;
    }

    public void setDdCredit(String ddCredit) {
        this.ddCredit = ddCredit;
    }

    public String getInstantCredit() {
        return instantCredit;
    }

    public void setInstantCredit(String instantCredit) {
        this.instantCredit = instantCredit;
    }

    public String getPosCredit() {
        return posCredit;
    }

    public void setPosCredit(String posCredit) {
        this.posCredit = posCredit;
    }

    public String getCreditEffDate() {
        return creditEffDate;
    }

    public void setCreditEffDate(String creditEffDate) {
        this.creditEffDate = creditEffDate;
    }

    public String getCreditExpDate() {
        return creditExpDate;
    }

    public void setCreditExpDate(String creditExpDate) {
        this.creditExpDate = creditExpDate;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getLastRequestTime() {
        return lastRequestTime;
    }

    public void setLastRequestTime(String lastRequestTime) {
        this.lastRequestTime = lastRequestTime;
    }

    public String getNextAvailableRequestTime() {
        return nextAvailableRequestTime;
    }

    public void setNextAvailableRequestTime(String nextAvailableRequestTime) {
        this.nextAvailableRequestTime = nextAvailableRequestTime;
    }

    public String getDdDays() {
        return ddDays;
    }

    public void setDdDays(String ddDays) {
        this.ddDays = ddDays;
    }

    public String getPosDays() {
        return posDays;
    }

    public void setPosDays(String posDays) {
        this.posDays = posDays;
    }

    public String getInstantDays() {
        return instantDays;
    }

    public void setInstantDays(String instantDays) {
        this.instantDays = instantDays;
    }

    public List<CreditPruductModel> getResults() {
        return results;
    }

    public void setResults(List<CreditPruductModel> results) {
        this.results = results;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public String getAnswerPassed() {
        return answerPassed;
    }

    public void setAnswerPassed(String answerPassed) {
        this.answerPassed = answerPassed;
    }
}
