package com.cardvalue.wechat.dto;

/**
 * Created by Mr tao on 2015/6/16.
 */
public class UpdateUserDTO {
    private String loanAmount; //意向融资金额|拟融资金额
    private String planFundTerm;//意向融资期限|拟融资期限(月)
    private String purposeFactor;//用途|资金用途 1:开立分店; 2:店铺装修; 3:添置设备; 4:购买库存; 5:工资账单; 6:广告宣传; 7:其他;
    private String ownerSSN;//身份证号码|法人身份证号
    private String ownerPhone;//固定电话
    private String ownerResidenceYears;//现址居住年限|法人现居住地年限; 数字1至99;
    private String ownerEmail;//邮箱|法人邮箱
    private String ownerAddress;//地址|法人所住地址
    private String ownerPercentage2;//股权百分比|股份比例
    private String apartmentType;//住宅类别  自置:自置; 按揭:按揭; 租借:租借; 父母住宅:父母住宅; 其它:其它;
    private String opratorMaritalStatus;//婚姻状况 已婚:已婚; 未婚:未婚;
    private String owner2NearestRelativeName;//非同住亲友姓名
    private String owner2RelativePhone;//非同住亲友手机

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getPlanFundTerm() {
        return planFundTerm;
    }

    public void setPlanFundTerm(String planFundTerm) {
        this.planFundTerm = planFundTerm;
    }

    public String getPurposeFactor() {
        return purposeFactor;
    }

    public void setPurposeFactor(String purposeFactor) {
        this.purposeFactor = purposeFactor;
    }

    public String getOwnerSSN() {
        return ownerSSN;
    }

    public void setOwnerSSN(String ownerSSN) {
        this.ownerSSN = ownerSSN;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerResidenceYears() {
        return ownerResidenceYears;
    }

    public void setOwnerResidenceYears(String ownerResidenceYears) {
        this.ownerResidenceYears = ownerResidenceYears;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerPercentage2() {
        return ownerPercentage2;
    }

    public void setOwnerPercentage2(String ownerPercentage2) {
        this.ownerPercentage2 = ownerPercentage2;
    }

    public String getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    public String getOpratorMaritalStatus() {
        return opratorMaritalStatus;
    }

    public void setOpratorMaritalStatus(String opratorMaritalStatus) {
        this.opratorMaritalStatus = opratorMaritalStatus;
    }

    public String getOwner2NearestRelativeName() {
        return owner2NearestRelativeName;
    }

    public void setOwner2NearestRelativeName(String owner2NearestRelativeName) {
        this.owner2NearestRelativeName = owner2NearestRelativeName;
    }

    public String getOwner2RelativePhone() {
        return owner2RelativePhone;
    }

    public void setOwner2RelativePhone(String owner2RelativePhone) {
        this.owner2RelativePhone = owner2RelativePhone;
    }
}
