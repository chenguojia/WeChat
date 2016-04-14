package com.cardvalue.wechat.dto;

/**
 * Created by Mr tao on 2015/6/1.
 */
public class NewMerchantUserModel {

    private String mobilePhone;
    private String idNumber;
    private String applicationId;
    private String businessName;
    private String createdAt;
    private String updatedAt;
    private String objectId;
    private String numLocations;
    private String opratorIsLocal;
    private String opratorAcdQua;
    private String businessContactPhone;
    private String sicCategory;
    private String merchantBusinessYears;
    private String surveySquareFootage;
    private String hasBusinessLicense;
    private String cityId;
    private String industryCategoryId;
    private String installPosTime;
    private String[] mids;
    private String openId;
    private String agreeToLicense; //是否同意授权 1同意 0还未同意
    private String isRenewable;//是否可续贷


    //基础字段
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

    private String ownerName;
    private String paybackPeriod;
    private String tenementNature;
    private String bizStartDate;
    private String industryPId;
    private String industryCId;
    private String provinceId;

    private String longitude;//经度
    private String latitude;//维度

    private String isJxlValid;//聚信立是否验证


    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
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

    public String getNumLocations() {
        return numLocations;
    }

    public void setNumLocations(String numLocations) {
        this.numLocations = numLocations;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerPercentage2() {
        return ownerPercentage2;
    }

    public void setOwnerPercentage2(String ownerPercentage2) {
        this.ownerPercentage2 = ownerPercentage2;
    }

    public String getOpratorIsLocal() {
        return opratorIsLocal;
    }

    public void setOpratorIsLocal(String opratorIsLocal) {
        this.opratorIsLocal = opratorIsLocal;
    }

    public String getOpratorMaritalStatus() {
        return opratorMaritalStatus;
    }

    public void setOpratorMaritalStatus(String opratorMaritalStatus) {
        this.opratorMaritalStatus = opratorMaritalStatus;
    }

    public String getOpratorAcdQua() {
        return opratorAcdQua;
    }

    public void setOpratorAcdQua(String opratorAcdQua) {
        this.opratorAcdQua = opratorAcdQua;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getBusinessContactPhone() {
        return businessContactPhone;
    }

    public void setBusinessContactPhone(String businessContactPhone) {
        this.businessContactPhone = businessContactPhone;
    }

    public String getSicCategory() {
        return sicCategory;
    }

    public void setSicCategory(String sicCategory) {
        this.sicCategory = sicCategory;
    }

    public String getMerchantBusinessYears() {
        return merchantBusinessYears;
    }

    public void setMerchantBusinessYears(String merchantBusinessYears) {
        this.merchantBusinessYears = merchantBusinessYears;
    }

    public String getSurveySquareFootage() {
        return surveySquareFootage;
    }

    public void setSurveySquareFootage(String surveySquareFootage) {
        this.surveySquareFootage = surveySquareFootage;
    }

    public String getHasBusinessLicense() {
        return hasBusinessLicense;
    }

    public void setHasBusinessLicense(String hasBusinessLicense) {
        this.hasBusinessLicense = hasBusinessLicense;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getIndustryCategoryId() {
        return industryCategoryId;
    }

    public void setIndustryCategoryId(String industryCategoryId) {
        this.industryCategoryId = industryCategoryId;
    }

    public String getInstallPosTime() {
        return installPosTime;
    }

    public void setInstallPosTime(String installPosTime) {
        this.installPosTime = installPosTime;
    }

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

    public String getOwner2NearestRelativeName() {
        return owner2NearestRelativeName;
    }

    public void setOwner2NearestRelativeName(String owner2NearestRelativeName) {
        this.owner2NearestRelativeName = owner2NearestRelativeName;
    }

    public String getPurposeFactor() {
        return purposeFactor;
    }

    public void setPurposeFactor(String purposeFactor) {
        this.purposeFactor = purposeFactor;
    }

    public String getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    public String getOwnerResidenceYears() {
        return ownerResidenceYears;
    }

    public void setOwnerResidenceYears(String ownerResidenceYears) {
        this.ownerResidenceYears = ownerResidenceYears;
    }

    public String[] getMids() {
        return mids;
    }

    public void setMids(String[] mids) {
        this.mids = mids;
    }

    public String getAgreeToLicense() {
        return agreeToLicense;
    }

    public void setAgreeToLicense(String agreeToLicense) {
        this.agreeToLicense = agreeToLicense;
    }

    public String getIsRenewable() {
        return isRenewable;
    }

    public void setIsRenewable(String isRenewable) {
        this.isRenewable = isRenewable;
    }

    public String getOwnerSSN() {
        return ownerSSN;
    }

    public void setOwnerSSN(String ownerSSN) {
        this.ownerSSN = ownerSSN;
    }

    public String getOwner2RelativePhone() {
        return owner2RelativePhone;
    }

    public void setOwner2RelativePhone(String owner2RelativePhone) {
        this.owner2RelativePhone = owner2RelativePhone;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPaybackPeriod() {
        return paybackPeriod;
    }

    public void setPaybackPeriod(String paybackPeriod) {
        this.paybackPeriod = paybackPeriod;
    }

    public String getTenementNature() {
        return tenementNature;
    }

    public void setTenementNature(String tenementNature) {
        this.tenementNature = tenementNature;
    }

    public String getBizStartDate() {
        return bizStartDate;
    }

    public void setBizStartDate(String bizStartDate) {
        this.bizStartDate = bizStartDate;
    }

    public String getIndustryPId() {
        return industryPId;
    }

    public void setIndustryPId(String industryPId) {
        this.industryPId = industryPId;
    }

    public String getIndustryCId() {
        return industryCId;
    }

    public void setIndustryCId(String industryCId) {
        this.industryCId = industryCId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getIsJxlValid() {
        return isJxlValid;
    }

    public void setIsJxlValid(String isJxlValid) {
        this.isJxlValid = isJxlValid;
    }
}
