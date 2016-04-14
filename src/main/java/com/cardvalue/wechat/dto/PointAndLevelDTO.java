package com.cardvalue.wechat.dto;

import com.cardvalue.wechat.model.Coupon;
import com.cardvalue.wechat.model.UserPointSummary;

import java.util.List;

/**
 * Created by Mr tao on 2015/3/27.
 */
public class PointAndLevelDTO {

    private UserPointSummary summary;
    private List<Coupon> rebateCoupons;
    private List<Coupon> mobileCoupons;
    private Integer availableCouponCount;
    private String levelMesssage;

    public UserPointSummary getSummary() {
        return summary;
    }

    public void setSummary(UserPointSummary summary) {
        this.summary = summary;
    }

    public List<Coupon> getRebateCoupons() {
        return rebateCoupons;
    }

    public void setRebateCoupons(List<Coupon> rebateCoupons) {
        this.rebateCoupons = rebateCoupons;
    }

    public List<Coupon> getMobileCoupons() {
        return mobileCoupons;
    }

    public void setMobileCoupons(List<Coupon> mobileCoupons) {
        this.mobileCoupons = mobileCoupons;
    }

    public Integer getAvailableCouponCount() {
        return availableCouponCount;
    }

    public void setAvailableCouponCount(Integer availableCouponCount) {
        this.availableCouponCount = availableCouponCount;
    }

    public String getLevelMesssage() {
        return levelMesssage;
    }

    public void setLevelMesssage(String levelMesssage) {
        this.levelMesssage = levelMesssage;
    }

    public PointAndLevelDTO(UserPointSummary summary, List<Coupon> rebateCoupons, List<Coupon> mobileCoupons, Integer availableCouponCount, String levelMesssage) {
        this.summary = summary;
        this.rebateCoupons = rebateCoupons;
        this.mobileCoupons = mobileCoupons;
        this.availableCouponCount = availableCouponCount;
        this.levelMesssage = levelMesssage;
    }
}
