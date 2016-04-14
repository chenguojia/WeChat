/**
 * SoapUpdateAppRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.www;

public class SoapUpdateAppRequest  implements java.io.Serializable {
    private java.lang.String channel;

    private java.lang.String clientSecret;

    private java.lang.String app_id;

    private java.lang.String ownerName;

    private java.lang.String ownerTitle;

    private java.lang.String ownerIdNo;

    private java.lang.String ownerCellPhone;

    private java.lang.String ownerEmail;

    private java.lang.String ownerPhone;

    private java.lang.String ownerFax;

    private java.lang.String ownerGender;

    private java.lang.String ownerProvince;

    private java.lang.String ownerCity;

    private java.lang.String ownerAddress;

    private java.lang.String ownerZip;

    private java.lang.String ownerRelativeName;

    private java.lang.String ownerRelativeType;

    private java.lang.String ownerRelativeCellPhone;

    private java.lang.String corporateName;

    private java.lang.String corporateProvince;

    private java.lang.String corporateCity;

    private java.lang.String corporateAddress;

    private java.lang.String corporateZip;

    private java.lang.String corporateCapital;

    private java.lang.String corporateType;

    private java.lang.String businesslicenseNo;

    private java.lang.String businesslicenseStart;

    private java.lang.String businesslicenseEnd;

    private java.lang.String businessName;

    private java.lang.String businessBriefName;

    private java.lang.String businessProvince;

    private java.lang.String businessCity;

    private java.lang.String businessAddress;

    private java.lang.String businessZip;

    private java.lang.String businessYears;

    private java.lang.String businessPhone;

    private java.lang.String businessWebsite;

    private java.lang.String businessScope;

    private java.lang.String monthlyVolume;

    private java.lang.String posMonthlyVolume;

    private java.lang.String monthlyPurchases;

    private java.lang.String monthlyUtilityBill;

    private java.lang.String monthlyShareholderPay;

    private java.lang.String monthlyStaffPay;

    private java.lang.String acceptCardTypes;

    private java.lang.String foriegnCardRate;

    private java.lang.String foriegnCardTop;

    private java.lang.String localCardRate;

    private java.lang.String localCardTop;

    private java.lang.String MID1;

    private java.lang.String posCnt1;

    private java.lang.String posIDs1;

    private java.lang.String MID2;

    private java.lang.String posCnt2;

    private java.lang.String posIDs2;

    private java.lang.String MID3;

    private java.lang.String posCnt3;

    private java.lang.String posIDs3;

    private java.lang.String businessArea;

    private java.lang.String businessDistrict;

    private java.lang.String realEstateType;

    private java.lang.String monthlyRent;

    private java.lang.String rentDepositMonths;

    private java.lang.String rentInAdvanceMonths;

    private java.lang.String rentingStart;

    private java.lang.String rentingEnd;

    private java.lang.String landLordName;

    private java.lang.String landLordPhone;

    private java.lang.String landLordCellPhone;

    private java.lang.String landLordAdress;

    private java.lang.String basicSettleAccountType;

    private java.lang.String basicSettleAccountName;

    private java.lang.String basicSettleAccountNo;

    private java.lang.String basicSettleAccountBankNo;

    private java.lang.String basicSettleAccountProvince;

    private java.lang.String basicSettleAccountCity;

    private java.lang.String basicSettleAccountBankName;

    private java.lang.String ownerDebitCardName1;

    private java.lang.String ownerDebitCardNo1;

    private java.lang.String ownerDebitCardBank1;

    private java.lang.String ownerDebitCardName2;

    private java.lang.String ownerDebitCardNo2;

    private java.lang.String ownerDebitCardBank2;

    private java.lang.String ownerDebitCardName3;

    private java.lang.String ownerDebitCardNo3;

    private java.lang.String ownerDebitCardBank3;

    public SoapUpdateAppRequest() {
    }

    public SoapUpdateAppRequest(
           java.lang.String channel,
           java.lang.String clientSecret,
           java.lang.String app_id,
           java.lang.String ownerName,
           java.lang.String ownerTitle,
           java.lang.String ownerIdNo,
           java.lang.String ownerCellPhone,
           java.lang.String ownerEmail,
           java.lang.String ownerPhone,
           java.lang.String ownerFax,
           java.lang.String ownerGender,
           java.lang.String ownerProvince,
           java.lang.String ownerCity,
           java.lang.String ownerAddress,
           java.lang.String ownerZip,
           java.lang.String ownerRelativeName,
           java.lang.String ownerRelativeType,
           java.lang.String ownerRelativeCellPhone,
           java.lang.String corporateName,
           java.lang.String corporateProvince,
           java.lang.String corporateCity,
           java.lang.String corporateAddress,
           java.lang.String corporateZip,
           java.lang.String corporateCapital,
           java.lang.String corporateType,
           java.lang.String businesslicenseNo,
           java.lang.String businesslicenseStart,
           java.lang.String businesslicenseEnd,
           java.lang.String businessName,
           java.lang.String businessBriefName,
           java.lang.String businessProvince,
           java.lang.String businessCity,
           java.lang.String businessAddress,
           java.lang.String businessZip,
           java.lang.String businessYears,
           java.lang.String businessPhone,
           java.lang.String businessWebsite,
           java.lang.String businessScope,
           java.lang.String monthlyVolume,
           java.lang.String posMonthlyVolume,
           java.lang.String monthlyPurchases,
           java.lang.String monthlyUtilityBill,
           java.lang.String monthlyShareholderPay,
           java.lang.String monthlyStaffPay,
           java.lang.String acceptCardTypes,
           java.lang.String foriegnCardRate,
           java.lang.String foriegnCardTop,
           java.lang.String localCardRate,
           java.lang.String localCardTop,
           java.lang.String MID1,
           java.lang.String posCnt1,
           java.lang.String posIDs1,
           java.lang.String MID2,
           java.lang.String posCnt2,
           java.lang.String posIDs2,
           java.lang.String MID3,
           java.lang.String posCnt3,
           java.lang.String posIDs3,
           java.lang.String businessArea,
           java.lang.String businessDistrict,
           java.lang.String realEstateType,
           java.lang.String monthlyRent,
           java.lang.String rentDepositMonths,
           java.lang.String rentInAdvanceMonths,
           java.lang.String rentingStart,
           java.lang.String rentingEnd,
           java.lang.String landLordName,
           java.lang.String landLordPhone,
           java.lang.String landLordCellPhone,
           java.lang.String landLordAdress,
           java.lang.String basicSettleAccountType,
           java.lang.String basicSettleAccountName,
           java.lang.String basicSettleAccountNo,
           java.lang.String basicSettleAccountBankNo,
           java.lang.String basicSettleAccountProvince,
           java.lang.String basicSettleAccountCity,
           java.lang.String basicSettleAccountBankName,
           java.lang.String ownerDebitCardName1,
           java.lang.String ownerDebitCardNo1,
           java.lang.String ownerDebitCardBank1,
           java.lang.String ownerDebitCardName2,
           java.lang.String ownerDebitCardNo2,
           java.lang.String ownerDebitCardBank2,
           java.lang.String ownerDebitCardName3,
           java.lang.String ownerDebitCardNo3,
           java.lang.String ownerDebitCardBank3) {
           this.channel = channel;
           this.clientSecret = clientSecret;
           this.app_id = app_id;
           this.ownerName = ownerName;
           this.ownerTitle = ownerTitle;
           this.ownerIdNo = ownerIdNo;
           this.ownerCellPhone = ownerCellPhone;
           this.ownerEmail = ownerEmail;
           this.ownerPhone = ownerPhone;
           this.ownerFax = ownerFax;
           this.ownerGender = ownerGender;
           this.ownerProvince = ownerProvince;
           this.ownerCity = ownerCity;
           this.ownerAddress = ownerAddress;
           this.ownerZip = ownerZip;
           this.ownerRelativeName = ownerRelativeName;
           this.ownerRelativeType = ownerRelativeType;
           this.ownerRelativeCellPhone = ownerRelativeCellPhone;
           this.corporateName = corporateName;
           this.corporateProvince = corporateProvince;
           this.corporateCity = corporateCity;
           this.corporateAddress = corporateAddress;
           this.corporateZip = corporateZip;
           this.corporateCapital = corporateCapital;
           this.corporateType = corporateType;
           this.businesslicenseNo = businesslicenseNo;
           this.businesslicenseStart = businesslicenseStart;
           this.businesslicenseEnd = businesslicenseEnd;
           this.businessName = businessName;
           this.businessBriefName = businessBriefName;
           this.businessProvince = businessProvince;
           this.businessCity = businessCity;
           this.businessAddress = businessAddress;
           this.businessZip = businessZip;
           this.businessYears = businessYears;
           this.businessPhone = businessPhone;
           this.businessWebsite = businessWebsite;
           this.businessScope = businessScope;
           this.monthlyVolume = monthlyVolume;
           this.posMonthlyVolume = posMonthlyVolume;
           this.monthlyPurchases = monthlyPurchases;
           this.monthlyUtilityBill = monthlyUtilityBill;
           this.monthlyShareholderPay = monthlyShareholderPay;
           this.monthlyStaffPay = monthlyStaffPay;
           this.acceptCardTypes = acceptCardTypes;
           this.foriegnCardRate = foriegnCardRate;
           this.foriegnCardTop = foriegnCardTop;
           this.localCardRate = localCardRate;
           this.localCardTop = localCardTop;
           this.MID1 = MID1;
           this.posCnt1 = posCnt1;
           this.posIDs1 = posIDs1;
           this.MID2 = MID2;
           this.posCnt2 = posCnt2;
           this.posIDs2 = posIDs2;
           this.MID3 = MID3;
           this.posCnt3 = posCnt3;
           this.posIDs3 = posIDs3;
           this.businessArea = businessArea;
           this.businessDistrict = businessDistrict;
           this.realEstateType = realEstateType;
           this.monthlyRent = monthlyRent;
           this.rentDepositMonths = rentDepositMonths;
           this.rentInAdvanceMonths = rentInAdvanceMonths;
           this.rentingStart = rentingStart;
           this.rentingEnd = rentingEnd;
           this.landLordName = landLordName;
           this.landLordPhone = landLordPhone;
           this.landLordCellPhone = landLordCellPhone;
           this.landLordAdress = landLordAdress;
           this.basicSettleAccountType = basicSettleAccountType;
           this.basicSettleAccountName = basicSettleAccountName;
           this.basicSettleAccountNo = basicSettleAccountNo;
           this.basicSettleAccountBankNo = basicSettleAccountBankNo;
           this.basicSettleAccountProvince = basicSettleAccountProvince;
           this.basicSettleAccountCity = basicSettleAccountCity;
           this.basicSettleAccountBankName = basicSettleAccountBankName;
           this.ownerDebitCardName1 = ownerDebitCardName1;
           this.ownerDebitCardNo1 = ownerDebitCardNo1;
           this.ownerDebitCardBank1 = ownerDebitCardBank1;
           this.ownerDebitCardName2 = ownerDebitCardName2;
           this.ownerDebitCardNo2 = ownerDebitCardNo2;
           this.ownerDebitCardBank2 = ownerDebitCardBank2;
           this.ownerDebitCardName3 = ownerDebitCardName3;
           this.ownerDebitCardNo3 = ownerDebitCardNo3;
           this.ownerDebitCardBank3 = ownerDebitCardBank3;
    }


    /**
     * Gets the channel value for this SoapUpdateAppRequest.
     * 
     * @return channel
     */
    public java.lang.String getChannel() {
        return channel;
    }


    /**
     * Sets the channel value for this SoapUpdateAppRequest.
     * 
     * @param channel
     */
    public void setChannel(java.lang.String channel) {
        this.channel = channel;
    }


    /**
     * Gets the clientSecret value for this SoapUpdateAppRequest.
     * 
     * @return clientSecret
     */
    public java.lang.String getClientSecret() {
        return clientSecret;
    }


    /**
     * Sets the clientSecret value for this SoapUpdateAppRequest.
     * 
     * @param clientSecret
     */
    public void setClientSecret(java.lang.String clientSecret) {
        this.clientSecret = clientSecret;
    }


    /**
     * Gets the app_id value for this SoapUpdateAppRequest.
     * 
     * @return app_id
     */
    public java.lang.String getApp_id() {
        return app_id;
    }


    /**
     * Sets the app_id value for this SoapUpdateAppRequest.
     * 
     * @param app_id
     */
    public void setApp_id(java.lang.String app_id) {
        this.app_id = app_id;
    }


    /**
     * Gets the ownerName value for this SoapUpdateAppRequest.
     * 
     * @return ownerName
     */
    public java.lang.String getOwnerName() {
        return ownerName;
    }


    /**
     * Sets the ownerName value for this SoapUpdateAppRequest.
     * 
     * @param ownerName
     */
    public void setOwnerName(java.lang.String ownerName) {
        this.ownerName = ownerName;
    }


    /**
     * Gets the ownerTitle value for this SoapUpdateAppRequest.
     * 
     * @return ownerTitle
     */
    public java.lang.String getOwnerTitle() {
        return ownerTitle;
    }


    /**
     * Sets the ownerTitle value for this SoapUpdateAppRequest.
     * 
     * @param ownerTitle
     */
    public void setOwnerTitle(java.lang.String ownerTitle) {
        this.ownerTitle = ownerTitle;
    }


    /**
     * Gets the ownerIdNo value for this SoapUpdateAppRequest.
     * 
     * @return ownerIdNo
     */
    public java.lang.String getOwnerIdNo() {
        return ownerIdNo;
    }


    /**
     * Sets the ownerIdNo value for this SoapUpdateAppRequest.
     * 
     * @param ownerIdNo
     */
    public void setOwnerIdNo(java.lang.String ownerIdNo) {
        this.ownerIdNo = ownerIdNo;
    }


    /**
     * Gets the ownerCellPhone value for this SoapUpdateAppRequest.
     * 
     * @return ownerCellPhone
     */
    public java.lang.String getOwnerCellPhone() {
        return ownerCellPhone;
    }


    /**
     * Sets the ownerCellPhone value for this SoapUpdateAppRequest.
     * 
     * @param ownerCellPhone
     */
    public void setOwnerCellPhone(java.lang.String ownerCellPhone) {
        this.ownerCellPhone = ownerCellPhone;
    }


    /**
     * Gets the ownerEmail value for this SoapUpdateAppRequest.
     * 
     * @return ownerEmail
     */
    public java.lang.String getOwnerEmail() {
        return ownerEmail;
    }


    /**
     * Sets the ownerEmail value for this SoapUpdateAppRequest.
     * 
     * @param ownerEmail
     */
    public void setOwnerEmail(java.lang.String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }


    /**
     * Gets the ownerPhone value for this SoapUpdateAppRequest.
     * 
     * @return ownerPhone
     */
    public java.lang.String getOwnerPhone() {
        return ownerPhone;
    }


    /**
     * Sets the ownerPhone value for this SoapUpdateAppRequest.
     * 
     * @param ownerPhone
     */
    public void setOwnerPhone(java.lang.String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }


    /**
     * Gets the ownerFax value for this SoapUpdateAppRequest.
     * 
     * @return ownerFax
     */
    public java.lang.String getOwnerFax() {
        return ownerFax;
    }


    /**
     * Sets the ownerFax value for this SoapUpdateAppRequest.
     * 
     * @param ownerFax
     */
    public void setOwnerFax(java.lang.String ownerFax) {
        this.ownerFax = ownerFax;
    }


    /**
     * Gets the ownerGender value for this SoapUpdateAppRequest.
     * 
     * @return ownerGender
     */
    public java.lang.String getOwnerGender() {
        return ownerGender;
    }


    /**
     * Sets the ownerGender value for this SoapUpdateAppRequest.
     * 
     * @param ownerGender
     */
    public void setOwnerGender(java.lang.String ownerGender) {
        this.ownerGender = ownerGender;
    }


    /**
     * Gets the ownerProvince value for this SoapUpdateAppRequest.
     * 
     * @return ownerProvince
     */
    public java.lang.String getOwnerProvince() {
        return ownerProvince;
    }


    /**
     * Sets the ownerProvince value for this SoapUpdateAppRequest.
     * 
     * @param ownerProvince
     */
    public void setOwnerProvince(java.lang.String ownerProvince) {
        this.ownerProvince = ownerProvince;
    }


    /**
     * Gets the ownerCity value for this SoapUpdateAppRequest.
     * 
     * @return ownerCity
     */
    public java.lang.String getOwnerCity() {
        return ownerCity;
    }


    /**
     * Sets the ownerCity value for this SoapUpdateAppRequest.
     * 
     * @param ownerCity
     */
    public void setOwnerCity(java.lang.String ownerCity) {
        this.ownerCity = ownerCity;
    }


    /**
     * Gets the ownerAddress value for this SoapUpdateAppRequest.
     * 
     * @return ownerAddress
     */
    public java.lang.String getOwnerAddress() {
        return ownerAddress;
    }


    /**
     * Sets the ownerAddress value for this SoapUpdateAppRequest.
     * 
     * @param ownerAddress
     */
    public void setOwnerAddress(java.lang.String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }


    /**
     * Gets the ownerZip value for this SoapUpdateAppRequest.
     * 
     * @return ownerZip
     */
    public java.lang.String getOwnerZip() {
        return ownerZip;
    }


    /**
     * Sets the ownerZip value for this SoapUpdateAppRequest.
     * 
     * @param ownerZip
     */
    public void setOwnerZip(java.lang.String ownerZip) {
        this.ownerZip = ownerZip;
    }


    /**
     * Gets the ownerRelativeName value for this SoapUpdateAppRequest.
     * 
     * @return ownerRelativeName
     */
    public java.lang.String getOwnerRelativeName() {
        return ownerRelativeName;
    }


    /**
     * Sets the ownerRelativeName value for this SoapUpdateAppRequest.
     * 
     * @param ownerRelativeName
     */
    public void setOwnerRelativeName(java.lang.String ownerRelativeName) {
        this.ownerRelativeName = ownerRelativeName;
    }


    /**
     * Gets the ownerRelativeType value for this SoapUpdateAppRequest.
     * 
     * @return ownerRelativeType
     */
    public java.lang.String getOwnerRelativeType() {
        return ownerRelativeType;
    }


    /**
     * Sets the ownerRelativeType value for this SoapUpdateAppRequest.
     * 
     * @param ownerRelativeType
     */
    public void setOwnerRelativeType(java.lang.String ownerRelativeType) {
        this.ownerRelativeType = ownerRelativeType;
    }


    /**
     * Gets the ownerRelativeCellPhone value for this SoapUpdateAppRequest.
     * 
     * @return ownerRelativeCellPhone
     */
    public java.lang.String getOwnerRelativeCellPhone() {
        return ownerRelativeCellPhone;
    }


    /**
     * Sets the ownerRelativeCellPhone value for this SoapUpdateAppRequest.
     * 
     * @param ownerRelativeCellPhone
     */
    public void setOwnerRelativeCellPhone(java.lang.String ownerRelativeCellPhone) {
        this.ownerRelativeCellPhone = ownerRelativeCellPhone;
    }


    /**
     * Gets the corporateName value for this SoapUpdateAppRequest.
     * 
     * @return corporateName
     */
    public java.lang.String getCorporateName() {
        return corporateName;
    }


    /**
     * Sets the corporateName value for this SoapUpdateAppRequest.
     * 
     * @param corporateName
     */
    public void setCorporateName(java.lang.String corporateName) {
        this.corporateName = corporateName;
    }


    /**
     * Gets the corporateProvince value for this SoapUpdateAppRequest.
     * 
     * @return corporateProvince
     */
    public java.lang.String getCorporateProvince() {
        return corporateProvince;
    }


    /**
     * Sets the corporateProvince value for this SoapUpdateAppRequest.
     * 
     * @param corporateProvince
     */
    public void setCorporateProvince(java.lang.String corporateProvince) {
        this.corporateProvince = corporateProvince;
    }


    /**
     * Gets the corporateCity value for this SoapUpdateAppRequest.
     * 
     * @return corporateCity
     */
    public java.lang.String getCorporateCity() {
        return corporateCity;
    }


    /**
     * Sets the corporateCity value for this SoapUpdateAppRequest.
     * 
     * @param corporateCity
     */
    public void setCorporateCity(java.lang.String corporateCity) {
        this.corporateCity = corporateCity;
    }


    /**
     * Gets the corporateAddress value for this SoapUpdateAppRequest.
     * 
     * @return corporateAddress
     */
    public java.lang.String getCorporateAddress() {
        return corporateAddress;
    }


    /**
     * Sets the corporateAddress value for this SoapUpdateAppRequest.
     * 
     * @param corporateAddress
     */
    public void setCorporateAddress(java.lang.String corporateAddress) {
        this.corporateAddress = corporateAddress;
    }


    /**
     * Gets the corporateZip value for this SoapUpdateAppRequest.
     * 
     * @return corporateZip
     */
    public java.lang.String getCorporateZip() {
        return corporateZip;
    }


    /**
     * Sets the corporateZip value for this SoapUpdateAppRequest.
     * 
     * @param corporateZip
     */
    public void setCorporateZip(java.lang.String corporateZip) {
        this.corporateZip = corporateZip;
    }


    /**
     * Gets the corporateCapital value for this SoapUpdateAppRequest.
     * 
     * @return corporateCapital
     */
    public java.lang.String getCorporateCapital() {
        return corporateCapital;
    }


    /**
     * Sets the corporateCapital value for this SoapUpdateAppRequest.
     * 
     * @param corporateCapital
     */
    public void setCorporateCapital(java.lang.String corporateCapital) {
        this.corporateCapital = corporateCapital;
    }


    /**
     * Gets the corporateType value for this SoapUpdateAppRequest.
     * 
     * @return corporateType
     */
    public java.lang.String getCorporateType() {
        return corporateType;
    }


    /**
     * Sets the corporateType value for this SoapUpdateAppRequest.
     * 
     * @param corporateType
     */
    public void setCorporateType(java.lang.String corporateType) {
        this.corporateType = corporateType;
    }


    /**
     * Gets the businesslicenseNo value for this SoapUpdateAppRequest.
     * 
     * @return businesslicenseNo
     */
    public java.lang.String getBusinesslicenseNo() {
        return businesslicenseNo;
    }


    /**
     * Sets the businesslicenseNo value for this SoapUpdateAppRequest.
     * 
     * @param businesslicenseNo
     */
    public void setBusinesslicenseNo(java.lang.String businesslicenseNo) {
        this.businesslicenseNo = businesslicenseNo;
    }


    /**
     * Gets the businesslicenseStart value for this SoapUpdateAppRequest.
     * 
     * @return businesslicenseStart
     */
    public java.lang.String getBusinesslicenseStart() {
        return businesslicenseStart;
    }


    /**
     * Sets the businesslicenseStart value for this SoapUpdateAppRequest.
     * 
     * @param businesslicenseStart
     */
    public void setBusinesslicenseStart(java.lang.String businesslicenseStart) {
        this.businesslicenseStart = businesslicenseStart;
    }


    /**
     * Gets the businesslicenseEnd value for this SoapUpdateAppRequest.
     * 
     * @return businesslicenseEnd
     */
    public java.lang.String getBusinesslicenseEnd() {
        return businesslicenseEnd;
    }


    /**
     * Sets the businesslicenseEnd value for this SoapUpdateAppRequest.
     * 
     * @param businesslicenseEnd
     */
    public void setBusinesslicenseEnd(java.lang.String businesslicenseEnd) {
        this.businesslicenseEnd = businesslicenseEnd;
    }


    /**
     * Gets the businessName value for this SoapUpdateAppRequest.
     * 
     * @return businessName
     */
    public java.lang.String getBusinessName() {
        return businessName;
    }


    /**
     * Sets the businessName value for this SoapUpdateAppRequest.
     * 
     * @param businessName
     */
    public void setBusinessName(java.lang.String businessName) {
        this.businessName = businessName;
    }


    /**
     * Gets the businessBriefName value for this SoapUpdateAppRequest.
     * 
     * @return businessBriefName
     */
    public java.lang.String getBusinessBriefName() {
        return businessBriefName;
    }


    /**
     * Sets the businessBriefName value for this SoapUpdateAppRequest.
     * 
     * @param businessBriefName
     */
    public void setBusinessBriefName(java.lang.String businessBriefName) {
        this.businessBriefName = businessBriefName;
    }


    /**
     * Gets the businessProvince value for this SoapUpdateAppRequest.
     * 
     * @return businessProvince
     */
    public java.lang.String getBusinessProvince() {
        return businessProvince;
    }


    /**
     * Sets the businessProvince value for this SoapUpdateAppRequest.
     * 
     * @param businessProvince
     */
    public void setBusinessProvince(java.lang.String businessProvince) {
        this.businessProvince = businessProvince;
    }


    /**
     * Gets the businessCity value for this SoapUpdateAppRequest.
     * 
     * @return businessCity
     */
    public java.lang.String getBusinessCity() {
        return businessCity;
    }


    /**
     * Sets the businessCity value for this SoapUpdateAppRequest.
     * 
     * @param businessCity
     */
    public void setBusinessCity(java.lang.String businessCity) {
        this.businessCity = businessCity;
    }


    /**
     * Gets the businessAddress value for this SoapUpdateAppRequest.
     * 
     * @return businessAddress
     */
    public java.lang.String getBusinessAddress() {
        return businessAddress;
    }


    /**
     * Sets the businessAddress value for this SoapUpdateAppRequest.
     * 
     * @param businessAddress
     */
    public void setBusinessAddress(java.lang.String businessAddress) {
        this.businessAddress = businessAddress;
    }


    /**
     * Gets the businessZip value for this SoapUpdateAppRequest.
     * 
     * @return businessZip
     */
    public java.lang.String getBusinessZip() {
        return businessZip;
    }


    /**
     * Sets the businessZip value for this SoapUpdateAppRequest.
     * 
     * @param businessZip
     */
    public void setBusinessZip(java.lang.String businessZip) {
        this.businessZip = businessZip;
    }


    /**
     * Gets the businessYears value for this SoapUpdateAppRequest.
     * 
     * @return businessYears
     */
    public java.lang.String getBusinessYears() {
        return businessYears;
    }


    /**
     * Sets the businessYears value for this SoapUpdateAppRequest.
     * 
     * @param businessYears
     */
    public void setBusinessYears(java.lang.String businessYears) {
        this.businessYears = businessYears;
    }


    /**
     * Gets the businessPhone value for this SoapUpdateAppRequest.
     * 
     * @return businessPhone
     */
    public java.lang.String getBusinessPhone() {
        return businessPhone;
    }


    /**
     * Sets the businessPhone value for this SoapUpdateAppRequest.
     * 
     * @param businessPhone
     */
    public void setBusinessPhone(java.lang.String businessPhone) {
        this.businessPhone = businessPhone;
    }


    /**
     * Gets the businessWebsite value for this SoapUpdateAppRequest.
     * 
     * @return businessWebsite
     */
    public java.lang.String getBusinessWebsite() {
        return businessWebsite;
    }


    /**
     * Sets the businessWebsite value for this SoapUpdateAppRequest.
     * 
     * @param businessWebsite
     */
    public void setBusinessWebsite(java.lang.String businessWebsite) {
        this.businessWebsite = businessWebsite;
    }


    /**
     * Gets the businessScope value for this SoapUpdateAppRequest.
     * 
     * @return businessScope
     */
    public java.lang.String getBusinessScope() {
        return businessScope;
    }


    /**
     * Sets the businessScope value for this SoapUpdateAppRequest.
     * 
     * @param businessScope
     */
    public void setBusinessScope(java.lang.String businessScope) {
        this.businessScope = businessScope;
    }


    /**
     * Gets the monthlyVolume value for this SoapUpdateAppRequest.
     * 
     * @return monthlyVolume
     */
    public java.lang.String getMonthlyVolume() {
        return monthlyVolume;
    }


    /**
     * Sets the monthlyVolume value for this SoapUpdateAppRequest.
     * 
     * @param monthlyVolume
     */
    public void setMonthlyVolume(java.lang.String monthlyVolume) {
        this.monthlyVolume = monthlyVolume;
    }


    /**
     * Gets the posMonthlyVolume value for this SoapUpdateAppRequest.
     * 
     * @return posMonthlyVolume
     */
    public java.lang.String getPosMonthlyVolume() {
        return posMonthlyVolume;
    }


    /**
     * Sets the posMonthlyVolume value for this SoapUpdateAppRequest.
     * 
     * @param posMonthlyVolume
     */
    public void setPosMonthlyVolume(java.lang.String posMonthlyVolume) {
        this.posMonthlyVolume = posMonthlyVolume;
    }


    /**
     * Gets the monthlyPurchases value for this SoapUpdateAppRequest.
     * 
     * @return monthlyPurchases
     */
    public java.lang.String getMonthlyPurchases() {
        return monthlyPurchases;
    }


    /**
     * Sets the monthlyPurchases value for this SoapUpdateAppRequest.
     * 
     * @param monthlyPurchases
     */
    public void setMonthlyPurchases(java.lang.String monthlyPurchases) {
        this.monthlyPurchases = monthlyPurchases;
    }


    /**
     * Gets the monthlyUtilityBill value for this SoapUpdateAppRequest.
     * 
     * @return monthlyUtilityBill
     */
    public java.lang.String getMonthlyUtilityBill() {
        return monthlyUtilityBill;
    }


    /**
     * Sets the monthlyUtilityBill value for this SoapUpdateAppRequest.
     * 
     * @param monthlyUtilityBill
     */
    public void setMonthlyUtilityBill(java.lang.String monthlyUtilityBill) {
        this.monthlyUtilityBill = monthlyUtilityBill;
    }


    /**
     * Gets the monthlyShareholderPay value for this SoapUpdateAppRequest.
     * 
     * @return monthlyShareholderPay
     */
    public java.lang.String getMonthlyShareholderPay() {
        return monthlyShareholderPay;
    }


    /**
     * Sets the monthlyShareholderPay value for this SoapUpdateAppRequest.
     * 
     * @param monthlyShareholderPay
     */
    public void setMonthlyShareholderPay(java.lang.String monthlyShareholderPay) {
        this.monthlyShareholderPay = monthlyShareholderPay;
    }


    /**
     * Gets the monthlyStaffPay value for this SoapUpdateAppRequest.
     * 
     * @return monthlyStaffPay
     */
    public java.lang.String getMonthlyStaffPay() {
        return monthlyStaffPay;
    }


    /**
     * Sets the monthlyStaffPay value for this SoapUpdateAppRequest.
     * 
     * @param monthlyStaffPay
     */
    public void setMonthlyStaffPay(java.lang.String monthlyStaffPay) {
        this.monthlyStaffPay = monthlyStaffPay;
    }


    /**
     * Gets the acceptCardTypes value for this SoapUpdateAppRequest.
     * 
     * @return acceptCardTypes
     */
    public java.lang.String getAcceptCardTypes() {
        return acceptCardTypes;
    }


    /**
     * Sets the acceptCardTypes value for this SoapUpdateAppRequest.
     * 
     * @param acceptCardTypes
     */
    public void setAcceptCardTypes(java.lang.String acceptCardTypes) {
        this.acceptCardTypes = acceptCardTypes;
    }


    /**
     * Gets the foriegnCardRate value for this SoapUpdateAppRequest.
     * 
     * @return foriegnCardRate
     */
    public java.lang.String getForiegnCardRate() {
        return foriegnCardRate;
    }


    /**
     * Sets the foriegnCardRate value for this SoapUpdateAppRequest.
     * 
     * @param foriegnCardRate
     */
    public void setForiegnCardRate(java.lang.String foriegnCardRate) {
        this.foriegnCardRate = foriegnCardRate;
    }


    /**
     * Gets the foriegnCardTop value for this SoapUpdateAppRequest.
     * 
     * @return foriegnCardTop
     */
    public java.lang.String getForiegnCardTop() {
        return foriegnCardTop;
    }


    /**
     * Sets the foriegnCardTop value for this SoapUpdateAppRequest.
     * 
     * @param foriegnCardTop
     */
    public void setForiegnCardTop(java.lang.String foriegnCardTop) {
        this.foriegnCardTop = foriegnCardTop;
    }


    /**
     * Gets the localCardRate value for this SoapUpdateAppRequest.
     * 
     * @return localCardRate
     */
    public java.lang.String getLocalCardRate() {
        return localCardRate;
    }


    /**
     * Sets the localCardRate value for this SoapUpdateAppRequest.
     * 
     * @param localCardRate
     */
    public void setLocalCardRate(java.lang.String localCardRate) {
        this.localCardRate = localCardRate;
    }


    /**
     * Gets the localCardTop value for this SoapUpdateAppRequest.
     * 
     * @return localCardTop
     */
    public java.lang.String getLocalCardTop() {
        return localCardTop;
    }


    /**
     * Sets the localCardTop value for this SoapUpdateAppRequest.
     * 
     * @param localCardTop
     */
    public void setLocalCardTop(java.lang.String localCardTop) {
        this.localCardTop = localCardTop;
    }


    /**
     * Gets the MID1 value for this SoapUpdateAppRequest.
     * 
     * @return MID1
     */
    public java.lang.String getMID1() {
        return MID1;
    }


    /**
     * Sets the MID1 value for this SoapUpdateAppRequest.
     * 
     * @param MID1
     */
    public void setMID1(java.lang.String MID1) {
        this.MID1 = MID1;
    }


    /**
     * Gets the posCnt1 value for this SoapUpdateAppRequest.
     * 
     * @return posCnt1
     */
    public java.lang.String getPosCnt1() {
        return posCnt1;
    }


    /**
     * Sets the posCnt1 value for this SoapUpdateAppRequest.
     * 
     * @param posCnt1
     */
    public void setPosCnt1(java.lang.String posCnt1) {
        this.posCnt1 = posCnt1;
    }


    /**
     * Gets the posIDs1 value for this SoapUpdateAppRequest.
     * 
     * @return posIDs1
     */
    public java.lang.String getPosIDs1() {
        return posIDs1;
    }


    /**
     * Sets the posIDs1 value for this SoapUpdateAppRequest.
     * 
     * @param posIDs1
     */
    public void setPosIDs1(java.lang.String posIDs1) {
        this.posIDs1 = posIDs1;
    }


    /**
     * Gets the MID2 value for this SoapUpdateAppRequest.
     * 
     * @return MID2
     */
    public java.lang.String getMID2() {
        return MID2;
    }


    /**
     * Sets the MID2 value for this SoapUpdateAppRequest.
     * 
     * @param MID2
     */
    public void setMID2(java.lang.String MID2) {
        this.MID2 = MID2;
    }


    /**
     * Gets the posCnt2 value for this SoapUpdateAppRequest.
     * 
     * @return posCnt2
     */
    public java.lang.String getPosCnt2() {
        return posCnt2;
    }


    /**
     * Sets the posCnt2 value for this SoapUpdateAppRequest.
     * 
     * @param posCnt2
     */
    public void setPosCnt2(java.lang.String posCnt2) {
        this.posCnt2 = posCnt2;
    }


    /**
     * Gets the posIDs2 value for this SoapUpdateAppRequest.
     * 
     * @return posIDs2
     */
    public java.lang.String getPosIDs2() {
        return posIDs2;
    }


    /**
     * Sets the posIDs2 value for this SoapUpdateAppRequest.
     * 
     * @param posIDs2
     */
    public void setPosIDs2(java.lang.String posIDs2) {
        this.posIDs2 = posIDs2;
    }


    /**
     * Gets the MID3 value for this SoapUpdateAppRequest.
     * 
     * @return MID3
     */
    public java.lang.String getMID3() {
        return MID3;
    }


    /**
     * Sets the MID3 value for this SoapUpdateAppRequest.
     * 
     * @param MID3
     */
    public void setMID3(java.lang.String MID3) {
        this.MID3 = MID3;
    }


    /**
     * Gets the posCnt3 value for this SoapUpdateAppRequest.
     * 
     * @return posCnt3
     */
    public java.lang.String getPosCnt3() {
        return posCnt3;
    }


    /**
     * Sets the posCnt3 value for this SoapUpdateAppRequest.
     * 
     * @param posCnt3
     */
    public void setPosCnt3(java.lang.String posCnt3) {
        this.posCnt3 = posCnt3;
    }


    /**
     * Gets the posIDs3 value for this SoapUpdateAppRequest.
     * 
     * @return posIDs3
     */
    public java.lang.String getPosIDs3() {
        return posIDs3;
    }


    /**
     * Sets the posIDs3 value for this SoapUpdateAppRequest.
     * 
     * @param posIDs3
     */
    public void setPosIDs3(java.lang.String posIDs3) {
        this.posIDs3 = posIDs3;
    }


    /**
     * Gets the businessArea value for this SoapUpdateAppRequest.
     * 
     * @return businessArea
     */
    public java.lang.String getBusinessArea() {
        return businessArea;
    }


    /**
     * Sets the businessArea value for this SoapUpdateAppRequest.
     * 
     * @param businessArea
     */
    public void setBusinessArea(java.lang.String businessArea) {
        this.businessArea = businessArea;
    }


    /**
     * Gets the businessDistrict value for this SoapUpdateAppRequest.
     * 
     * @return businessDistrict
     */
    public java.lang.String getBusinessDistrict() {
        return businessDistrict;
    }


    /**
     * Sets the businessDistrict value for this SoapUpdateAppRequest.
     * 
     * @param businessDistrict
     */
    public void setBusinessDistrict(java.lang.String businessDistrict) {
        this.businessDistrict = businessDistrict;
    }


    /**
     * Gets the realEstateType value for this SoapUpdateAppRequest.
     * 
     * @return realEstateType
     */
    public java.lang.String getRealEstateType() {
        return realEstateType;
    }


    /**
     * Sets the realEstateType value for this SoapUpdateAppRequest.
     * 
     * @param realEstateType
     */
    public void setRealEstateType(java.lang.String realEstateType) {
        this.realEstateType = realEstateType;
    }


    /**
     * Gets the monthlyRent value for this SoapUpdateAppRequest.
     * 
     * @return monthlyRent
     */
    public java.lang.String getMonthlyRent() {
        return monthlyRent;
    }


    /**
     * Sets the monthlyRent value for this SoapUpdateAppRequest.
     * 
     * @param monthlyRent
     */
    public void setMonthlyRent(java.lang.String monthlyRent) {
        this.monthlyRent = monthlyRent;
    }


    /**
     * Gets the rentDepositMonths value for this SoapUpdateAppRequest.
     * 
     * @return rentDepositMonths
     */
    public java.lang.String getRentDepositMonths() {
        return rentDepositMonths;
    }


    /**
     * Sets the rentDepositMonths value for this SoapUpdateAppRequest.
     * 
     * @param rentDepositMonths
     */
    public void setRentDepositMonths(java.lang.String rentDepositMonths) {
        this.rentDepositMonths = rentDepositMonths;
    }


    /**
     * Gets the rentInAdvanceMonths value for this SoapUpdateAppRequest.
     * 
     * @return rentInAdvanceMonths
     */
    public java.lang.String getRentInAdvanceMonths() {
        return rentInAdvanceMonths;
    }


    /**
     * Sets the rentInAdvanceMonths value for this SoapUpdateAppRequest.
     * 
     * @param rentInAdvanceMonths
     */
    public void setRentInAdvanceMonths(java.lang.String rentInAdvanceMonths) {
        this.rentInAdvanceMonths = rentInAdvanceMonths;
    }


    /**
     * Gets the rentingStart value for this SoapUpdateAppRequest.
     * 
     * @return rentingStart
     */
    public java.lang.String getRentingStart() {
        return rentingStart;
    }


    /**
     * Sets the rentingStart value for this SoapUpdateAppRequest.
     * 
     * @param rentingStart
     */
    public void setRentingStart(java.lang.String rentingStart) {
        this.rentingStart = rentingStart;
    }


    /**
     * Gets the rentingEnd value for this SoapUpdateAppRequest.
     * 
     * @return rentingEnd
     */
    public java.lang.String getRentingEnd() {
        return rentingEnd;
    }


    /**
     * Sets the rentingEnd value for this SoapUpdateAppRequest.
     * 
     * @param rentingEnd
     */
    public void setRentingEnd(java.lang.String rentingEnd) {
        this.rentingEnd = rentingEnd;
    }


    /**
     * Gets the landLordName value for this SoapUpdateAppRequest.
     * 
     * @return landLordName
     */
    public java.lang.String getLandLordName() {
        return landLordName;
    }


    /**
     * Sets the landLordName value for this SoapUpdateAppRequest.
     * 
     * @param landLordName
     */
    public void setLandLordName(java.lang.String landLordName) {
        this.landLordName = landLordName;
    }


    /**
     * Gets the landLordPhone value for this SoapUpdateAppRequest.
     * 
     * @return landLordPhone
     */
    public java.lang.String getLandLordPhone() {
        return landLordPhone;
    }


    /**
     * Sets the landLordPhone value for this SoapUpdateAppRequest.
     * 
     * @param landLordPhone
     */
    public void setLandLordPhone(java.lang.String landLordPhone) {
        this.landLordPhone = landLordPhone;
    }


    /**
     * Gets the landLordCellPhone value for this SoapUpdateAppRequest.
     * 
     * @return landLordCellPhone
     */
    public java.lang.String getLandLordCellPhone() {
        return landLordCellPhone;
    }


    /**
     * Sets the landLordCellPhone value for this SoapUpdateAppRequest.
     * 
     * @param landLordCellPhone
     */
    public void setLandLordCellPhone(java.lang.String landLordCellPhone) {
        this.landLordCellPhone = landLordCellPhone;
    }


    /**
     * Gets the landLordAdress value for this SoapUpdateAppRequest.
     * 
     * @return landLordAdress
     */
    public java.lang.String getLandLordAdress() {
        return landLordAdress;
    }


    /**
     * Sets the landLordAdress value for this SoapUpdateAppRequest.
     * 
     * @param landLordAdress
     */
    public void setLandLordAdress(java.lang.String landLordAdress) {
        this.landLordAdress = landLordAdress;
    }


    /**
     * Gets the basicSettleAccountType value for this SoapUpdateAppRequest.
     * 
     * @return basicSettleAccountType
     */
    public java.lang.String getBasicSettleAccountType() {
        return basicSettleAccountType;
    }


    /**
     * Sets the basicSettleAccountType value for this SoapUpdateAppRequest.
     * 
     * @param basicSettleAccountType
     */
    public void setBasicSettleAccountType(java.lang.String basicSettleAccountType) {
        this.basicSettleAccountType = basicSettleAccountType;
    }


    /**
     * Gets the basicSettleAccountName value for this SoapUpdateAppRequest.
     * 
     * @return basicSettleAccountName
     */
    public java.lang.String getBasicSettleAccountName() {
        return basicSettleAccountName;
    }


    /**
     * Sets the basicSettleAccountName value for this SoapUpdateAppRequest.
     * 
     * @param basicSettleAccountName
     */
    public void setBasicSettleAccountName(java.lang.String basicSettleAccountName) {
        this.basicSettleAccountName = basicSettleAccountName;
    }


    /**
     * Gets the basicSettleAccountNo value for this SoapUpdateAppRequest.
     * 
     * @return basicSettleAccountNo
     */
    public java.lang.String getBasicSettleAccountNo() {
        return basicSettleAccountNo;
    }


    /**
     * Sets the basicSettleAccountNo value for this SoapUpdateAppRequest.
     * 
     * @param basicSettleAccountNo
     */
    public void setBasicSettleAccountNo(java.lang.String basicSettleAccountNo) {
        this.basicSettleAccountNo = basicSettleAccountNo;
    }


    /**
     * Gets the basicSettleAccountBankNo value for this SoapUpdateAppRequest.
     * 
     * @return basicSettleAccountBankNo
     */
    public java.lang.String getBasicSettleAccountBankNo() {
        return basicSettleAccountBankNo;
    }


    /**
     * Sets the basicSettleAccountBankNo value for this SoapUpdateAppRequest.
     * 
     * @param basicSettleAccountBankNo
     */
    public void setBasicSettleAccountBankNo(java.lang.String basicSettleAccountBankNo) {
        this.basicSettleAccountBankNo = basicSettleAccountBankNo;
    }


    /**
     * Gets the basicSettleAccountProvince value for this SoapUpdateAppRequest.
     * 
     * @return basicSettleAccountProvince
     */
    public java.lang.String getBasicSettleAccountProvince() {
        return basicSettleAccountProvince;
    }


    /**
     * Sets the basicSettleAccountProvince value for this SoapUpdateAppRequest.
     * 
     * @param basicSettleAccountProvince
     */
    public void setBasicSettleAccountProvince(java.lang.String basicSettleAccountProvince) {
        this.basicSettleAccountProvince = basicSettleAccountProvince;
    }


    /**
     * Gets the basicSettleAccountCity value for this SoapUpdateAppRequest.
     * 
     * @return basicSettleAccountCity
     */
    public java.lang.String getBasicSettleAccountCity() {
        return basicSettleAccountCity;
    }


    /**
     * Sets the basicSettleAccountCity value for this SoapUpdateAppRequest.
     * 
     * @param basicSettleAccountCity
     */
    public void setBasicSettleAccountCity(java.lang.String basicSettleAccountCity) {
        this.basicSettleAccountCity = basicSettleAccountCity;
    }


    /**
     * Gets the basicSettleAccountBankName value for this SoapUpdateAppRequest.
     * 
     * @return basicSettleAccountBankName
     */
    public java.lang.String getBasicSettleAccountBankName() {
        return basicSettleAccountBankName;
    }


    /**
     * Sets the basicSettleAccountBankName value for this SoapUpdateAppRequest.
     * 
     * @param basicSettleAccountBankName
     */
    public void setBasicSettleAccountBankName(java.lang.String basicSettleAccountBankName) {
        this.basicSettleAccountBankName = basicSettleAccountBankName;
    }


    /**
     * Gets the ownerDebitCardName1 value for this SoapUpdateAppRequest.
     * 
     * @return ownerDebitCardName1
     */
    public java.lang.String getOwnerDebitCardName1() {
        return ownerDebitCardName1;
    }


    /**
     * Sets the ownerDebitCardName1 value for this SoapUpdateAppRequest.
     * 
     * @param ownerDebitCardName1
     */
    public void setOwnerDebitCardName1(java.lang.String ownerDebitCardName1) {
        this.ownerDebitCardName1 = ownerDebitCardName1;
    }


    /**
     * Gets the ownerDebitCardNo1 value for this SoapUpdateAppRequest.
     * 
     * @return ownerDebitCardNo1
     */
    public java.lang.String getOwnerDebitCardNo1() {
        return ownerDebitCardNo1;
    }


    /**
     * Sets the ownerDebitCardNo1 value for this SoapUpdateAppRequest.
     * 
     * @param ownerDebitCardNo1
     */
    public void setOwnerDebitCardNo1(java.lang.String ownerDebitCardNo1) {
        this.ownerDebitCardNo1 = ownerDebitCardNo1;
    }


    /**
     * Gets the ownerDebitCardBank1 value for this SoapUpdateAppRequest.
     * 
     * @return ownerDebitCardBank1
     */
    public java.lang.String getOwnerDebitCardBank1() {
        return ownerDebitCardBank1;
    }


    /**
     * Sets the ownerDebitCardBank1 value for this SoapUpdateAppRequest.
     * 
     * @param ownerDebitCardBank1
     */
    public void setOwnerDebitCardBank1(java.lang.String ownerDebitCardBank1) {
        this.ownerDebitCardBank1 = ownerDebitCardBank1;
    }


    /**
     * Gets the ownerDebitCardName2 value for this SoapUpdateAppRequest.
     * 
     * @return ownerDebitCardName2
     */
    public java.lang.String getOwnerDebitCardName2() {
        return ownerDebitCardName2;
    }


    /**
     * Sets the ownerDebitCardName2 value for this SoapUpdateAppRequest.
     * 
     * @param ownerDebitCardName2
     */
    public void setOwnerDebitCardName2(java.lang.String ownerDebitCardName2) {
        this.ownerDebitCardName2 = ownerDebitCardName2;
    }


    /**
     * Gets the ownerDebitCardNo2 value for this SoapUpdateAppRequest.
     * 
     * @return ownerDebitCardNo2
     */
    public java.lang.String getOwnerDebitCardNo2() {
        return ownerDebitCardNo2;
    }


    /**
     * Sets the ownerDebitCardNo2 value for this SoapUpdateAppRequest.
     * 
     * @param ownerDebitCardNo2
     */
    public void setOwnerDebitCardNo2(java.lang.String ownerDebitCardNo2) {
        this.ownerDebitCardNo2 = ownerDebitCardNo2;
    }


    /**
     * Gets the ownerDebitCardBank2 value for this SoapUpdateAppRequest.
     * 
     * @return ownerDebitCardBank2
     */
    public java.lang.String getOwnerDebitCardBank2() {
        return ownerDebitCardBank2;
    }


    /**
     * Sets the ownerDebitCardBank2 value for this SoapUpdateAppRequest.
     * 
     * @param ownerDebitCardBank2
     */
    public void setOwnerDebitCardBank2(java.lang.String ownerDebitCardBank2) {
        this.ownerDebitCardBank2 = ownerDebitCardBank2;
    }


    /**
     * Gets the ownerDebitCardName3 value for this SoapUpdateAppRequest.
     * 
     * @return ownerDebitCardName3
     */
    public java.lang.String getOwnerDebitCardName3() {
        return ownerDebitCardName3;
    }


    /**
     * Sets the ownerDebitCardName3 value for this SoapUpdateAppRequest.
     * 
     * @param ownerDebitCardName3
     */
    public void setOwnerDebitCardName3(java.lang.String ownerDebitCardName3) {
        this.ownerDebitCardName3 = ownerDebitCardName3;
    }


    /**
     * Gets the ownerDebitCardNo3 value for this SoapUpdateAppRequest.
     * 
     * @return ownerDebitCardNo3
     */
    public java.lang.String getOwnerDebitCardNo3() {
        return ownerDebitCardNo3;
    }


    /**
     * Sets the ownerDebitCardNo3 value for this SoapUpdateAppRequest.
     * 
     * @param ownerDebitCardNo3
     */
    public void setOwnerDebitCardNo3(java.lang.String ownerDebitCardNo3) {
        this.ownerDebitCardNo3 = ownerDebitCardNo3;
    }


    /**
     * Gets the ownerDebitCardBank3 value for this SoapUpdateAppRequest.
     * 
     * @return ownerDebitCardBank3
     */
    public java.lang.String getOwnerDebitCardBank3() {
        return ownerDebitCardBank3;
    }


    /**
     * Sets the ownerDebitCardBank3 value for this SoapUpdateAppRequest.
     * 
     * @param ownerDebitCardBank3
     */
    public void setOwnerDebitCardBank3(java.lang.String ownerDebitCardBank3) {
        this.ownerDebitCardBank3 = ownerDebitCardBank3;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SoapUpdateAppRequest)) return false;
        SoapUpdateAppRequest other = (SoapUpdateAppRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.channel==null && other.getChannel()==null) || 
             (this.channel!=null &&
              this.channel.equals(other.getChannel()))) &&
            ((this.clientSecret==null && other.getClientSecret()==null) || 
             (this.clientSecret!=null &&
              this.clientSecret.equals(other.getClientSecret()))) &&
            ((this.app_id==null && other.getApp_id()==null) || 
             (this.app_id!=null &&
              this.app_id.equals(other.getApp_id()))) &&
            ((this.ownerName==null && other.getOwnerName()==null) || 
             (this.ownerName!=null &&
              this.ownerName.equals(other.getOwnerName()))) &&
            ((this.ownerTitle==null && other.getOwnerTitle()==null) || 
             (this.ownerTitle!=null &&
              this.ownerTitle.equals(other.getOwnerTitle()))) &&
            ((this.ownerIdNo==null && other.getOwnerIdNo()==null) || 
             (this.ownerIdNo!=null &&
              this.ownerIdNo.equals(other.getOwnerIdNo()))) &&
            ((this.ownerCellPhone==null && other.getOwnerCellPhone()==null) || 
             (this.ownerCellPhone!=null &&
              this.ownerCellPhone.equals(other.getOwnerCellPhone()))) &&
            ((this.ownerEmail==null && other.getOwnerEmail()==null) || 
             (this.ownerEmail!=null &&
              this.ownerEmail.equals(other.getOwnerEmail()))) &&
            ((this.ownerPhone==null && other.getOwnerPhone()==null) || 
             (this.ownerPhone!=null &&
              this.ownerPhone.equals(other.getOwnerPhone()))) &&
            ((this.ownerFax==null && other.getOwnerFax()==null) || 
             (this.ownerFax!=null &&
              this.ownerFax.equals(other.getOwnerFax()))) &&
            ((this.ownerGender==null && other.getOwnerGender()==null) || 
             (this.ownerGender!=null &&
              this.ownerGender.equals(other.getOwnerGender()))) &&
            ((this.ownerProvince==null && other.getOwnerProvince()==null) || 
             (this.ownerProvince!=null &&
              this.ownerProvince.equals(other.getOwnerProvince()))) &&
            ((this.ownerCity==null && other.getOwnerCity()==null) || 
             (this.ownerCity!=null &&
              this.ownerCity.equals(other.getOwnerCity()))) &&
            ((this.ownerAddress==null && other.getOwnerAddress()==null) || 
             (this.ownerAddress!=null &&
              this.ownerAddress.equals(other.getOwnerAddress()))) &&
            ((this.ownerZip==null && other.getOwnerZip()==null) || 
             (this.ownerZip!=null &&
              this.ownerZip.equals(other.getOwnerZip()))) &&
            ((this.ownerRelativeName==null && other.getOwnerRelativeName()==null) || 
             (this.ownerRelativeName!=null &&
              this.ownerRelativeName.equals(other.getOwnerRelativeName()))) &&
            ((this.ownerRelativeType==null && other.getOwnerRelativeType()==null) || 
             (this.ownerRelativeType!=null &&
              this.ownerRelativeType.equals(other.getOwnerRelativeType()))) &&
            ((this.ownerRelativeCellPhone==null && other.getOwnerRelativeCellPhone()==null) || 
             (this.ownerRelativeCellPhone!=null &&
              this.ownerRelativeCellPhone.equals(other.getOwnerRelativeCellPhone()))) &&
            ((this.corporateName==null && other.getCorporateName()==null) || 
             (this.corporateName!=null &&
              this.corporateName.equals(other.getCorporateName()))) &&
            ((this.corporateProvince==null && other.getCorporateProvince()==null) || 
             (this.corporateProvince!=null &&
              this.corporateProvince.equals(other.getCorporateProvince()))) &&
            ((this.corporateCity==null && other.getCorporateCity()==null) || 
             (this.corporateCity!=null &&
              this.corporateCity.equals(other.getCorporateCity()))) &&
            ((this.corporateAddress==null && other.getCorporateAddress()==null) || 
             (this.corporateAddress!=null &&
              this.corporateAddress.equals(other.getCorporateAddress()))) &&
            ((this.corporateZip==null && other.getCorporateZip()==null) || 
             (this.corporateZip!=null &&
              this.corporateZip.equals(other.getCorporateZip()))) &&
            ((this.corporateCapital==null && other.getCorporateCapital()==null) || 
             (this.corporateCapital!=null &&
              this.corporateCapital.equals(other.getCorporateCapital()))) &&
            ((this.corporateType==null && other.getCorporateType()==null) || 
             (this.corporateType!=null &&
              this.corporateType.equals(other.getCorporateType()))) &&
            ((this.businesslicenseNo==null && other.getBusinesslicenseNo()==null) || 
             (this.businesslicenseNo!=null &&
              this.businesslicenseNo.equals(other.getBusinesslicenseNo()))) &&
            ((this.businesslicenseStart==null && other.getBusinesslicenseStart()==null) || 
             (this.businesslicenseStart!=null &&
              this.businesslicenseStart.equals(other.getBusinesslicenseStart()))) &&
            ((this.businesslicenseEnd==null && other.getBusinesslicenseEnd()==null) || 
             (this.businesslicenseEnd!=null &&
              this.businesslicenseEnd.equals(other.getBusinesslicenseEnd()))) &&
            ((this.businessName==null && other.getBusinessName()==null) || 
             (this.businessName!=null &&
              this.businessName.equals(other.getBusinessName()))) &&
            ((this.businessBriefName==null && other.getBusinessBriefName()==null) || 
             (this.businessBriefName!=null &&
              this.businessBriefName.equals(other.getBusinessBriefName()))) &&
            ((this.businessProvince==null && other.getBusinessProvince()==null) || 
             (this.businessProvince!=null &&
              this.businessProvince.equals(other.getBusinessProvince()))) &&
            ((this.businessCity==null && other.getBusinessCity()==null) || 
             (this.businessCity!=null &&
              this.businessCity.equals(other.getBusinessCity()))) &&
            ((this.businessAddress==null && other.getBusinessAddress()==null) || 
             (this.businessAddress!=null &&
              this.businessAddress.equals(other.getBusinessAddress()))) &&
            ((this.businessZip==null && other.getBusinessZip()==null) || 
             (this.businessZip!=null &&
              this.businessZip.equals(other.getBusinessZip()))) &&
            ((this.businessYears==null && other.getBusinessYears()==null) || 
             (this.businessYears!=null &&
              this.businessYears.equals(other.getBusinessYears()))) &&
            ((this.businessPhone==null && other.getBusinessPhone()==null) || 
             (this.businessPhone!=null &&
              this.businessPhone.equals(other.getBusinessPhone()))) &&
            ((this.businessWebsite==null && other.getBusinessWebsite()==null) || 
             (this.businessWebsite!=null &&
              this.businessWebsite.equals(other.getBusinessWebsite()))) &&
            ((this.businessScope==null && other.getBusinessScope()==null) || 
             (this.businessScope!=null &&
              this.businessScope.equals(other.getBusinessScope()))) &&
            ((this.monthlyVolume==null && other.getMonthlyVolume()==null) || 
             (this.monthlyVolume!=null &&
              this.monthlyVolume.equals(other.getMonthlyVolume()))) &&
            ((this.posMonthlyVolume==null && other.getPosMonthlyVolume()==null) || 
             (this.posMonthlyVolume!=null &&
              this.posMonthlyVolume.equals(other.getPosMonthlyVolume()))) &&
            ((this.monthlyPurchases==null && other.getMonthlyPurchases()==null) || 
             (this.monthlyPurchases!=null &&
              this.monthlyPurchases.equals(other.getMonthlyPurchases()))) &&
            ((this.monthlyUtilityBill==null && other.getMonthlyUtilityBill()==null) || 
             (this.monthlyUtilityBill!=null &&
              this.monthlyUtilityBill.equals(other.getMonthlyUtilityBill()))) &&
            ((this.monthlyShareholderPay==null && other.getMonthlyShareholderPay()==null) || 
             (this.monthlyShareholderPay!=null &&
              this.monthlyShareholderPay.equals(other.getMonthlyShareholderPay()))) &&
            ((this.monthlyStaffPay==null && other.getMonthlyStaffPay()==null) || 
             (this.monthlyStaffPay!=null &&
              this.monthlyStaffPay.equals(other.getMonthlyStaffPay()))) &&
            ((this.acceptCardTypes==null && other.getAcceptCardTypes()==null) || 
             (this.acceptCardTypes!=null &&
              this.acceptCardTypes.equals(other.getAcceptCardTypes()))) &&
            ((this.foriegnCardRate==null && other.getForiegnCardRate()==null) || 
             (this.foriegnCardRate!=null &&
              this.foriegnCardRate.equals(other.getForiegnCardRate()))) &&
            ((this.foriegnCardTop==null && other.getForiegnCardTop()==null) || 
             (this.foriegnCardTop!=null &&
              this.foriegnCardTop.equals(other.getForiegnCardTop()))) &&
            ((this.localCardRate==null && other.getLocalCardRate()==null) || 
             (this.localCardRate!=null &&
              this.localCardRate.equals(other.getLocalCardRate()))) &&
            ((this.localCardTop==null && other.getLocalCardTop()==null) || 
             (this.localCardTop!=null &&
              this.localCardTop.equals(other.getLocalCardTop()))) &&
            ((this.MID1==null && other.getMID1()==null) || 
             (this.MID1!=null &&
              this.MID1.equals(other.getMID1()))) &&
            ((this.posCnt1==null && other.getPosCnt1()==null) || 
             (this.posCnt1!=null &&
              this.posCnt1.equals(other.getPosCnt1()))) &&
            ((this.posIDs1==null && other.getPosIDs1()==null) || 
             (this.posIDs1!=null &&
              this.posIDs1.equals(other.getPosIDs1()))) &&
            ((this.MID2==null && other.getMID2()==null) || 
             (this.MID2!=null &&
              this.MID2.equals(other.getMID2()))) &&
            ((this.posCnt2==null && other.getPosCnt2()==null) || 
             (this.posCnt2!=null &&
              this.posCnt2.equals(other.getPosCnt2()))) &&
            ((this.posIDs2==null && other.getPosIDs2()==null) || 
             (this.posIDs2!=null &&
              this.posIDs2.equals(other.getPosIDs2()))) &&
            ((this.MID3==null && other.getMID3()==null) || 
             (this.MID3!=null &&
              this.MID3.equals(other.getMID3()))) &&
            ((this.posCnt3==null && other.getPosCnt3()==null) || 
             (this.posCnt3!=null &&
              this.posCnt3.equals(other.getPosCnt3()))) &&
            ((this.posIDs3==null && other.getPosIDs3()==null) || 
             (this.posIDs3!=null &&
              this.posIDs3.equals(other.getPosIDs3()))) &&
            ((this.businessArea==null && other.getBusinessArea()==null) || 
             (this.businessArea!=null &&
              this.businessArea.equals(other.getBusinessArea()))) &&
            ((this.businessDistrict==null && other.getBusinessDistrict()==null) || 
             (this.businessDistrict!=null &&
              this.businessDistrict.equals(other.getBusinessDistrict()))) &&
            ((this.realEstateType==null && other.getRealEstateType()==null) || 
             (this.realEstateType!=null &&
              this.realEstateType.equals(other.getRealEstateType()))) &&
            ((this.monthlyRent==null && other.getMonthlyRent()==null) || 
             (this.monthlyRent!=null &&
              this.monthlyRent.equals(other.getMonthlyRent()))) &&
            ((this.rentDepositMonths==null && other.getRentDepositMonths()==null) || 
             (this.rentDepositMonths!=null &&
              this.rentDepositMonths.equals(other.getRentDepositMonths()))) &&
            ((this.rentInAdvanceMonths==null && other.getRentInAdvanceMonths()==null) || 
             (this.rentInAdvanceMonths!=null &&
              this.rentInAdvanceMonths.equals(other.getRentInAdvanceMonths()))) &&
            ((this.rentingStart==null && other.getRentingStart()==null) || 
             (this.rentingStart!=null &&
              this.rentingStart.equals(other.getRentingStart()))) &&
            ((this.rentingEnd==null && other.getRentingEnd()==null) || 
             (this.rentingEnd!=null &&
              this.rentingEnd.equals(other.getRentingEnd()))) &&
            ((this.landLordName==null && other.getLandLordName()==null) || 
             (this.landLordName!=null &&
              this.landLordName.equals(other.getLandLordName()))) &&
            ((this.landLordPhone==null && other.getLandLordPhone()==null) || 
             (this.landLordPhone!=null &&
              this.landLordPhone.equals(other.getLandLordPhone()))) &&
            ((this.landLordCellPhone==null && other.getLandLordCellPhone()==null) || 
             (this.landLordCellPhone!=null &&
              this.landLordCellPhone.equals(other.getLandLordCellPhone()))) &&
            ((this.landLordAdress==null && other.getLandLordAdress()==null) || 
             (this.landLordAdress!=null &&
              this.landLordAdress.equals(other.getLandLordAdress()))) &&
            ((this.basicSettleAccountType==null && other.getBasicSettleAccountType()==null) || 
             (this.basicSettleAccountType!=null &&
              this.basicSettleAccountType.equals(other.getBasicSettleAccountType()))) &&
            ((this.basicSettleAccountName==null && other.getBasicSettleAccountName()==null) || 
             (this.basicSettleAccountName!=null &&
              this.basicSettleAccountName.equals(other.getBasicSettleAccountName()))) &&
            ((this.basicSettleAccountNo==null && other.getBasicSettleAccountNo()==null) || 
             (this.basicSettleAccountNo!=null &&
              this.basicSettleAccountNo.equals(other.getBasicSettleAccountNo()))) &&
            ((this.basicSettleAccountBankNo==null && other.getBasicSettleAccountBankNo()==null) || 
             (this.basicSettleAccountBankNo!=null &&
              this.basicSettleAccountBankNo.equals(other.getBasicSettleAccountBankNo()))) &&
            ((this.basicSettleAccountProvince==null && other.getBasicSettleAccountProvince()==null) || 
             (this.basicSettleAccountProvince!=null &&
              this.basicSettleAccountProvince.equals(other.getBasicSettleAccountProvince()))) &&
            ((this.basicSettleAccountCity==null && other.getBasicSettleAccountCity()==null) || 
             (this.basicSettleAccountCity!=null &&
              this.basicSettleAccountCity.equals(other.getBasicSettleAccountCity()))) &&
            ((this.basicSettleAccountBankName==null && other.getBasicSettleAccountBankName()==null) || 
             (this.basicSettleAccountBankName!=null &&
              this.basicSettleAccountBankName.equals(other.getBasicSettleAccountBankName()))) &&
            ((this.ownerDebitCardName1==null && other.getOwnerDebitCardName1()==null) || 
             (this.ownerDebitCardName1!=null &&
              this.ownerDebitCardName1.equals(other.getOwnerDebitCardName1()))) &&
            ((this.ownerDebitCardNo1==null && other.getOwnerDebitCardNo1()==null) || 
             (this.ownerDebitCardNo1!=null &&
              this.ownerDebitCardNo1.equals(other.getOwnerDebitCardNo1()))) &&
            ((this.ownerDebitCardBank1==null && other.getOwnerDebitCardBank1()==null) || 
             (this.ownerDebitCardBank1!=null &&
              this.ownerDebitCardBank1.equals(other.getOwnerDebitCardBank1()))) &&
            ((this.ownerDebitCardName2==null && other.getOwnerDebitCardName2()==null) || 
             (this.ownerDebitCardName2!=null &&
              this.ownerDebitCardName2.equals(other.getOwnerDebitCardName2()))) &&
            ((this.ownerDebitCardNo2==null && other.getOwnerDebitCardNo2()==null) || 
             (this.ownerDebitCardNo2!=null &&
              this.ownerDebitCardNo2.equals(other.getOwnerDebitCardNo2()))) &&
            ((this.ownerDebitCardBank2==null && other.getOwnerDebitCardBank2()==null) || 
             (this.ownerDebitCardBank2!=null &&
              this.ownerDebitCardBank2.equals(other.getOwnerDebitCardBank2()))) &&
            ((this.ownerDebitCardName3==null && other.getOwnerDebitCardName3()==null) || 
             (this.ownerDebitCardName3!=null &&
              this.ownerDebitCardName3.equals(other.getOwnerDebitCardName3()))) &&
            ((this.ownerDebitCardNo3==null && other.getOwnerDebitCardNo3()==null) || 
             (this.ownerDebitCardNo3!=null &&
              this.ownerDebitCardNo3.equals(other.getOwnerDebitCardNo3()))) &&
            ((this.ownerDebitCardBank3==null && other.getOwnerDebitCardBank3()==null) || 
             (this.ownerDebitCardBank3!=null &&
              this.ownerDebitCardBank3.equals(other.getOwnerDebitCardBank3())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getChannel() != null) {
            _hashCode += getChannel().hashCode();
        }
        if (getClientSecret() != null) {
            _hashCode += getClientSecret().hashCode();
        }
        if (getApp_id() != null) {
            _hashCode += getApp_id().hashCode();
        }
        if (getOwnerName() != null) {
            _hashCode += getOwnerName().hashCode();
        }
        if (getOwnerTitle() != null) {
            _hashCode += getOwnerTitle().hashCode();
        }
        if (getOwnerIdNo() != null) {
            _hashCode += getOwnerIdNo().hashCode();
        }
        if (getOwnerCellPhone() != null) {
            _hashCode += getOwnerCellPhone().hashCode();
        }
        if (getOwnerEmail() != null) {
            _hashCode += getOwnerEmail().hashCode();
        }
        if (getOwnerPhone() != null) {
            _hashCode += getOwnerPhone().hashCode();
        }
        if (getOwnerFax() != null) {
            _hashCode += getOwnerFax().hashCode();
        }
        if (getOwnerGender() != null) {
            _hashCode += getOwnerGender().hashCode();
        }
        if (getOwnerProvince() != null) {
            _hashCode += getOwnerProvince().hashCode();
        }
        if (getOwnerCity() != null) {
            _hashCode += getOwnerCity().hashCode();
        }
        if (getOwnerAddress() != null) {
            _hashCode += getOwnerAddress().hashCode();
        }
        if (getOwnerZip() != null) {
            _hashCode += getOwnerZip().hashCode();
        }
        if (getOwnerRelativeName() != null) {
            _hashCode += getOwnerRelativeName().hashCode();
        }
        if (getOwnerRelativeType() != null) {
            _hashCode += getOwnerRelativeType().hashCode();
        }
        if (getOwnerRelativeCellPhone() != null) {
            _hashCode += getOwnerRelativeCellPhone().hashCode();
        }
        if (getCorporateName() != null) {
            _hashCode += getCorporateName().hashCode();
        }
        if (getCorporateProvince() != null) {
            _hashCode += getCorporateProvince().hashCode();
        }
        if (getCorporateCity() != null) {
            _hashCode += getCorporateCity().hashCode();
        }
        if (getCorporateAddress() != null) {
            _hashCode += getCorporateAddress().hashCode();
        }
        if (getCorporateZip() != null) {
            _hashCode += getCorporateZip().hashCode();
        }
        if (getCorporateCapital() != null) {
            _hashCode += getCorporateCapital().hashCode();
        }
        if (getCorporateType() != null) {
            _hashCode += getCorporateType().hashCode();
        }
        if (getBusinesslicenseNo() != null) {
            _hashCode += getBusinesslicenseNo().hashCode();
        }
        if (getBusinesslicenseStart() != null) {
            _hashCode += getBusinesslicenseStart().hashCode();
        }
        if (getBusinesslicenseEnd() != null) {
            _hashCode += getBusinesslicenseEnd().hashCode();
        }
        if (getBusinessName() != null) {
            _hashCode += getBusinessName().hashCode();
        }
        if (getBusinessBriefName() != null) {
            _hashCode += getBusinessBriefName().hashCode();
        }
        if (getBusinessProvince() != null) {
            _hashCode += getBusinessProvince().hashCode();
        }
        if (getBusinessCity() != null) {
            _hashCode += getBusinessCity().hashCode();
        }
        if (getBusinessAddress() != null) {
            _hashCode += getBusinessAddress().hashCode();
        }
        if (getBusinessZip() != null) {
            _hashCode += getBusinessZip().hashCode();
        }
        if (getBusinessYears() != null) {
            _hashCode += getBusinessYears().hashCode();
        }
        if (getBusinessPhone() != null) {
            _hashCode += getBusinessPhone().hashCode();
        }
        if (getBusinessWebsite() != null) {
            _hashCode += getBusinessWebsite().hashCode();
        }
        if (getBusinessScope() != null) {
            _hashCode += getBusinessScope().hashCode();
        }
        if (getMonthlyVolume() != null) {
            _hashCode += getMonthlyVolume().hashCode();
        }
        if (getPosMonthlyVolume() != null) {
            _hashCode += getPosMonthlyVolume().hashCode();
        }
        if (getMonthlyPurchases() != null) {
            _hashCode += getMonthlyPurchases().hashCode();
        }
        if (getMonthlyUtilityBill() != null) {
            _hashCode += getMonthlyUtilityBill().hashCode();
        }
        if (getMonthlyShareholderPay() != null) {
            _hashCode += getMonthlyShareholderPay().hashCode();
        }
        if (getMonthlyStaffPay() != null) {
            _hashCode += getMonthlyStaffPay().hashCode();
        }
        if (getAcceptCardTypes() != null) {
            _hashCode += getAcceptCardTypes().hashCode();
        }
        if (getForiegnCardRate() != null) {
            _hashCode += getForiegnCardRate().hashCode();
        }
        if (getForiegnCardTop() != null) {
            _hashCode += getForiegnCardTop().hashCode();
        }
        if (getLocalCardRate() != null) {
            _hashCode += getLocalCardRate().hashCode();
        }
        if (getLocalCardTop() != null) {
            _hashCode += getLocalCardTop().hashCode();
        }
        if (getMID1() != null) {
            _hashCode += getMID1().hashCode();
        }
        if (getPosCnt1() != null) {
            _hashCode += getPosCnt1().hashCode();
        }
        if (getPosIDs1() != null) {
            _hashCode += getPosIDs1().hashCode();
        }
        if (getMID2() != null) {
            _hashCode += getMID2().hashCode();
        }
        if (getPosCnt2() != null) {
            _hashCode += getPosCnt2().hashCode();
        }
        if (getPosIDs2() != null) {
            _hashCode += getPosIDs2().hashCode();
        }
        if (getMID3() != null) {
            _hashCode += getMID3().hashCode();
        }
        if (getPosCnt3() != null) {
            _hashCode += getPosCnt3().hashCode();
        }
        if (getPosIDs3() != null) {
            _hashCode += getPosIDs3().hashCode();
        }
        if (getBusinessArea() != null) {
            _hashCode += getBusinessArea().hashCode();
        }
        if (getBusinessDistrict() != null) {
            _hashCode += getBusinessDistrict().hashCode();
        }
        if (getRealEstateType() != null) {
            _hashCode += getRealEstateType().hashCode();
        }
        if (getMonthlyRent() != null) {
            _hashCode += getMonthlyRent().hashCode();
        }
        if (getRentDepositMonths() != null) {
            _hashCode += getRentDepositMonths().hashCode();
        }
        if (getRentInAdvanceMonths() != null) {
            _hashCode += getRentInAdvanceMonths().hashCode();
        }
        if (getRentingStart() != null) {
            _hashCode += getRentingStart().hashCode();
        }
        if (getRentingEnd() != null) {
            _hashCode += getRentingEnd().hashCode();
        }
        if (getLandLordName() != null) {
            _hashCode += getLandLordName().hashCode();
        }
        if (getLandLordPhone() != null) {
            _hashCode += getLandLordPhone().hashCode();
        }
        if (getLandLordCellPhone() != null) {
            _hashCode += getLandLordCellPhone().hashCode();
        }
        if (getLandLordAdress() != null) {
            _hashCode += getLandLordAdress().hashCode();
        }
        if (getBasicSettleAccountType() != null) {
            _hashCode += getBasicSettleAccountType().hashCode();
        }
        if (getBasicSettleAccountName() != null) {
            _hashCode += getBasicSettleAccountName().hashCode();
        }
        if (getBasicSettleAccountNo() != null) {
            _hashCode += getBasicSettleAccountNo().hashCode();
        }
        if (getBasicSettleAccountBankNo() != null) {
            _hashCode += getBasicSettleAccountBankNo().hashCode();
        }
        if (getBasicSettleAccountProvince() != null) {
            _hashCode += getBasicSettleAccountProvince().hashCode();
        }
        if (getBasicSettleAccountCity() != null) {
            _hashCode += getBasicSettleAccountCity().hashCode();
        }
        if (getBasicSettleAccountBankName() != null) {
            _hashCode += getBasicSettleAccountBankName().hashCode();
        }
        if (getOwnerDebitCardName1() != null) {
            _hashCode += getOwnerDebitCardName1().hashCode();
        }
        if (getOwnerDebitCardNo1() != null) {
            _hashCode += getOwnerDebitCardNo1().hashCode();
        }
        if (getOwnerDebitCardBank1() != null) {
            _hashCode += getOwnerDebitCardBank1().hashCode();
        }
        if (getOwnerDebitCardName2() != null) {
            _hashCode += getOwnerDebitCardName2().hashCode();
        }
        if (getOwnerDebitCardNo2() != null) {
            _hashCode += getOwnerDebitCardNo2().hashCode();
        }
        if (getOwnerDebitCardBank2() != null) {
            _hashCode += getOwnerDebitCardBank2().hashCode();
        }
        if (getOwnerDebitCardName3() != null) {
            _hashCode += getOwnerDebitCardName3().hashCode();
        }
        if (getOwnerDebitCardNo3() != null) {
            _hashCode += getOwnerDebitCardNo3().hashCode();
        }
        if (getOwnerDebitCardBank3() != null) {
            _hashCode += getOwnerDebitCardBank3().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapUpdateAppRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapUpdateAppRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("channel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "channel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientSecret");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientSecret"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("app_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "app_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerIdNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerIdNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerCellPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerCellPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerFax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerFax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerGender");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerGender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerProvince");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerProvince"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerCity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerZip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerZip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerRelativeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerRelativeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerRelativeType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerRelativeType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerRelativeCellPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerRelativeCellPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corporateName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CorporateName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corporateProvince");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CorporateProvince"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corporateCity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CorporateCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corporateAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CorporateAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corporateZip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CorporateZip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corporateCapital");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CorporateCapital"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corporateType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CorporateType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businesslicenseNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BusinesslicenseNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businesslicenseStart");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BusinesslicenseStart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businesslicenseEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BusinesslicenseEnd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BusinessName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessBriefName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BusinessBriefName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessProvince");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BusinessProvince"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessCity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BusinessCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BusinessAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessZip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BusinessZip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessYears");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BusinessYears"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BusinessPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessWebsite");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BusinessWebsite"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessScope");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BusinessScope"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monthlyVolume");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MonthlyVolume"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posMonthlyVolume");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PosMonthlyVolume"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monthlyPurchases");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MonthlyPurchases"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monthlyUtilityBill");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MonthlyUtilityBill"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monthlyShareholderPay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MonthlyShareholderPay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monthlyStaffPay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MonthlyStaffPay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acceptCardTypes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AcceptCardTypes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foriegnCardRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ForiegnCardRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foriegnCardTop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ForiegnCardTop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localCardRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LocalCardRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localCardTop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LocalCardTop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MID1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MID1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posCnt1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PosCnt1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posIDs1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PosIDs1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MID2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MID2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posCnt2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PosCnt2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posIDs2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PosIDs2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MID3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MID3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posCnt3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PosCnt3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posIDs3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PosIDs3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BusinessArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessDistrict");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BusinessDistrict"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("realEstateType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RealEstateType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monthlyRent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MonthlyRent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rentDepositMonths");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RentDepositMonths"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rentInAdvanceMonths");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RentInAdvanceMonths"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rentingStart");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RentingStart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rentingEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RentingEnd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landLordName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LandLordName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landLordPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LandLordPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landLordCellPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LandLordCellPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("landLordAdress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LandLordAdress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("basicSettleAccountType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BasicSettleAccountType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("basicSettleAccountName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BasicSettleAccountName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("basicSettleAccountNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BasicSettleAccountNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("basicSettleAccountBankNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BasicSettleAccountBankNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("basicSettleAccountProvince");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BasicSettleAccountProvince"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("basicSettleAccountCity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BasicSettleAccountCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("basicSettleAccountBankName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BasicSettleAccountBankName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerDebitCardName1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerDebitCardName1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerDebitCardNo1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerDebitCardNo1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerDebitCardBank1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerDebitCardBank1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerDebitCardName2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerDebitCardName2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerDebitCardNo2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerDebitCardNo2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerDebitCardBank2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerDebitCardBank2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerDebitCardName3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerDebitCardName3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerDebitCardNo3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerDebitCardNo3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerDebitCardBank3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OwnerDebitCardBank3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
