package com.cardvalue.wechat.dto;

/**
 * Created by Mr tao on 2015/5/27.
 */
public class VerifyDTO {
    private String questionIds;//用户回答的题目列表
    private String questionAnswers;//用户回来的题目答案列表
    private String mid;//验证问题id商编

    public String getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(String questionIds) {
        this.questionIds = questionIds;
    }

    public String getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(String questionAnswers) {
        this.questionAnswers = questionAnswers;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}
