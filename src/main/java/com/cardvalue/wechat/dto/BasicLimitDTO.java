package com.cardvalue.wechat.dto;


/**
 * Created by Mr tao on 2015/5/26.
 */
public class BasicLimitDTO {
    private String hasBusinessLicense;//是否有营业执照,1:有;0:无
    private String bizStartDate;//营业执照成立日期
    private String industryPId;//所属行业(大类) “大类ID”:”大类名称”
    private String industryCId;//所属行业(小类) “小类ID”:”小类名称”
    private String provinceId;//所属省份 “省份ID”:”省份名称”;
    private String cityId;//所属城市 “城市ID”:”城市名称”
    private String numLocations;//门店数
    private String surveySquareFootage;//营业面积(m²) 0-30:0-30(m2); 30-50:30-50(m2); 50-150:50-150(m2); 150-500:150-500(m2); 500+:500+(m2);

    private String opratorAcdQua;//学历 初中及以下:初中及以下; 高中/中专; 大专:大专; 本科:本科; 硕士及以上:硕士及以上;
    private String opratorIsLocal;//户口所在地|是否本地户口 是:本地; 否:外地;
    private String tenementNature;//门店物业性质|物业性质 自置物业:自置物业; 租借:租借; 其它:其它;

    public String getHasBusinessLicense() {
        return hasBusinessLicense;
    }

    public void setHasBusinessLicense(String hasBusinessLicense) {
        this.hasBusinessLicense = hasBusinessLicense;
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

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getNumLocations() {
        return numLocations;
    }

    public void setNumLocations(String numLocations) {
        this.numLocations = numLocations;
    }

    public String getSurveySquareFootage() {
        return surveySquareFootage;
    }

    public void setSurveySquareFootage(String surveySquareFootage) {
        this.surveySquareFootage = surveySquareFootage;
    }

    public String getOpratorAcdQua() {
        return opratorAcdQua;
    }

    public void setOpratorAcdQua(String opratorAcdQua) {
        this.opratorAcdQua = opratorAcdQua;
    }

    public String getOpratorIsLocal() {
        return opratorIsLocal;
    }

    public void setOpratorIsLocal(String opratorIsLocal) {
        this.opratorIsLocal = opratorIsLocal;
    }

    public String getTenementNature() {
        return tenementNature;
    }

    public void setTenementNature(String tenementNature) {
        this.tenementNature = tenementNature;
    }
}
