/**
 * SoapAddAppRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.crm;

public class SoapAddAppRequest  implements java.io.Serializable {
    private String channel;

    private String clientSecret;

    private String user_id;

    private String deal_id;

    private String processor;

    private String preferential;

    private String factorRate;

    private String ownerName;

    private String ownerTitle;

    private String ownerIdNo;

    private String ownerCellPhone;

    private String ownerEmail;

    private String ownerPhone;

    private String ownerFax;

    private String ownerGender;

    private String ownerProvince;

    private String ownerCity;

    private String ownerAddress;

    private String ownerZip;

    private String ownerRelativeName;

    private String ownerRelativeType;

    private String ownerRelativeCellPhone;

    private String corporateName;

    private String corporateProvince;

    private String corporateCity;

    private String corporateAddress;

    private String corporateZip;

    private String corporateCapital;

    private String corporateType;

    private String businesslicenseNo;

    private String businesslicenseStart;

    private String businesslicenseEnd;

    private String businessName;

    private String businessBriefName;

    private String businessProvince;

    private String businessCity;

    private String businessAddress;

    private String businessZip;

    private String businessYears;

    private String businessPhone;

    private String businessWebsite;

    private String businessScope;

    private String monthlyVolume;

    private String posMonthlyVolume;

    private String monthlyPurchases;

    private String monthlyUtilityBill;

    private String monthlyShareholderPay;

    private String monthlyStaffPay;

    private String acceptCardTypes;

    private String foriegnCardRate;

    private String foriegnCardTop;

    private String localCardRate;

    private String localCardTop;

    private String MID1;

    private String posCnt1;

    private String posIDs1;

    private String MID2;

    private String posCnt2;

    private String posIDs2;

    private String MID3;

    private String posCnt3;

    private String posIDs3;

    private String businessArea;

    private String businessDistrict;

    private String realEstateType;

    private String monthlyRent;

    private String rentDepositMonths;

    private String rentInAdvanceMonths;

    private String rentingStart;

    private String rentingEnd;

    private String landLordName;

    private String landLordPhone;

    private String landLordCellPhone;

    private String landLordAdress;

    private String basicSettleAccountType;

    private String basicSettleAccountName;

    private String basicSettleAccountNo;

    private String basicSettleAccountBankNo;

    private String basicSettleAccountProvince;

    private String basicSettleAccountCity;

    private String basicSettleAccountBankName;

    private String ownerDebitCardName1;

    private String ownerDebitCardNo1;

    private String ownerDebitCardBank1;

    private String ownerDebitCardName2;

    private String ownerDebitCardNo2;

    private String ownerDebitCardBank2;

    private String ownerDebitCardName3;

    private String ownerDebitCardNo3;

    private String ownerDebitCardBank3;

    private String prodName;

    private String fundingAmount;

    private String fundingPeriod;

    private String fundingPurpose;

    private String fundingProduct;

    private String onlinePaybackRecur;

    private String directDebitRecur;

    private String comments;

    public SoapAddAppRequest() {
    }

    public SoapAddAppRequest(
           String channel,
           String clientSecret,
           String user_id,
           String deal_id,
           String processor,
           String preferential,
           String factorRate,
           String ownerName,
           String ownerTitle,
           String ownerIdNo,
           String ownerCellPhone,
           String ownerEmail,
           String ownerPhone,
           String ownerFax,
           String ownerGender,
           String ownerProvince,
           String ownerCity,
           String ownerAddress,
           String ownerZip,
           String ownerRelativeName,
           String ownerRelativeType,
           String ownerRelativeCellPhone,
           String corporateName,
           String corporateProvince,
           String corporateCity,
           String corporateAddress,
           String corporateZip,
           String corporateCapital,
           String corporateType,
           String businesslicenseNo,
           String businesslicenseStart,
           String businesslicenseEnd,
           String businessName,
           String businessBriefName,
           String businessProvince,
           String businessCity,
           String businessAddress,
           String businessZip,
           String businessYears,
           String businessPhone,
           String businessWebsite,
           String businessScope,
           String monthlyVolume,
           String posMonthlyVolume,
           String monthlyPurchases,
           String monthlyUtilityBill,
           String monthlyShareholderPay,
           String monthlyStaffPay,
           String acceptCardTypes,
           String foriegnCardRate,
           String foriegnCardTop,
           String localCardRate,
           String localCardTop,
           String MID1,
           String posCnt1,
           String posIDs1,
           String MID2,
           String posCnt2,
           String posIDs2,
           String MID3,
           String posCnt3,
           String posIDs3,
           String businessArea,
           String businessDistrict,
           String realEstateType,
           String monthlyRent,
           String rentDepositMonths,
           String rentInAdvanceMonths,
           String rentingStart,
           String rentingEnd,
           String landLordName,
           String landLordPhone,
           String landLordCellPhone,
           String landLordAdress,
           String basicSettleAccountType,
           String basicSettleAccountName,
           String basicSettleAccountNo,
           String basicSettleAccountBankNo,
           String basicSettleAccountProvince,
           String basicSettleAccountCity,
           String basicSettleAccountBankName,
           String ownerDebitCardName1,
           String ownerDebitCardNo1,
           String ownerDebitCardBank1,
           String ownerDebitCardName2,
           String ownerDebitCardNo2,
           String ownerDebitCardBank2,
           String ownerDebitCardName3,
           String ownerDebitCardNo3,
           String ownerDebitCardBank3,
           String prodName,
           String fundingAmount,
           String fundingPeriod,
           String fundingPurpose,
           String fundingProduct,
           String onlinePaybackRecur,
           String directDebitRecur,
           String comments) {
           this.channel = channel;
           this.clientSecret = clientSecret;
           this.user_id = user_id;
           this.deal_id = deal_id;
           this.processor = processor;
           this.preferential = preferential;
           this.factorRate = factorRate;
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
           this.prodName = prodName;
           this.fundingAmount = fundingAmount;
           this.fundingPeriod = fundingPeriod;
           this.fundingPurpose = fundingPurpose;
           this.fundingProduct = fundingProduct;
           this.onlinePaybackRecur = onlinePaybackRecur;
           this.directDebitRecur = directDebitRecur;
           this.comments = comments;
    }


    /**
     * Gets the channel value for this SoapAddAppRequest.
     *
     * @return channel
     */
    public String getChannel() {
        return channel;
    }


    /**
     * Sets the channel value for this SoapAddAppRequest.
     *
     * @param channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }


    /**
     * Gets the clientSecret value for this SoapAddAppRequest.
     *
     * @return clientSecret
     */
    public String getClientSecret() {
        return clientSecret;
    }


    /**
     * Sets the clientSecret value for this SoapAddAppRequest.
     *
     * @param clientSecret
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }


    /**
     * Gets the user_id value for this SoapAddAppRequest.
     *
     * @return user_id
     */
    public String getUser_id() {
        return user_id;
    }


    /**
     * Sets the user_id value for this SoapAddAppRequest.
     *
     * @param user_id
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    /**
     * Gets the deal_id value for this SoapAddAppRequest.
     *
     * @return deal_id
     */
    public String getDeal_id() {
        return deal_id;
    }


    /**
     * Sets the deal_id value for this SoapAddAppRequest.
     *
     * @param deal_id
     */
    public void setDeal_id(String deal_id) {
        this.deal_id = deal_id;
    }


    /**
     * Gets the processor value for this SoapAddAppRequest.
     *
     * @return processor
     */
    public String getProcessor() {
        return processor;
    }


    /**
     * Sets the processor value for this SoapAddAppRequest.
     *
     * @param processor
     */
    public void setProcessor(String processor) {
        this.processor = processor;
    }


    /**
     * Gets the preferential value for this SoapAddAppRequest.
     *
     * @return preferential
     */
    public String getPreferential() {
        return preferential;
    }


    /**
     * Sets the preferential value for this SoapAddAppRequest.
     *
     * @param preferential
     */
    public void setPreferential(String preferential) {
        this.preferential = preferential;
    }


    /**
     * Gets the factorRate value for this SoapAddAppRequest.
     *
     * @return factorRate
     */
    public String getFactorRate() {
        return factorRate;
    }


    /**
     * Sets the factorRate value for this SoapAddAppRequest.
     *
     * @param factorRate
     */
    public void setFactorRate(String factorRate) {
        this.factorRate = factorRate;
    }


    /**
     * Gets the ownerName value for this SoapAddAppRequest.
     *
     * @return ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }


    /**
     * Sets the ownerName value for this SoapAddAppRequest.
     *
     * @param ownerName
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


    /**
     * Gets the ownerTitle value for this SoapAddAppRequest.
     *
     * @return ownerTitle
     */
    public String getOwnerTitle() {
        return ownerTitle;
    }


    /**
     * Sets the ownerTitle value for this SoapAddAppRequest.
     *
     * @param ownerTitle
     */
    public void setOwnerTitle(String ownerTitle) {
        this.ownerTitle = ownerTitle;
    }


    /**
     * Gets the ownerIdNo value for this SoapAddAppRequest.
     *
     * @return ownerIdNo
     */
    public String getOwnerIdNo() {
        return ownerIdNo;
    }


    /**
     * Sets the ownerIdNo value for this SoapAddAppRequest.
     *
     * @param ownerIdNo
     */
    public void setOwnerIdNo(String ownerIdNo) {
        this.ownerIdNo = ownerIdNo;
    }


    /**
     * Gets the ownerCellPhone value for this SoapAddAppRequest.
     *
     * @return ownerCellPhone
     */
    public String getOwnerCellPhone() {
        return ownerCellPhone;
    }


    /**
     * Sets the ownerCellPhone value for this SoapAddAppRequest.
     *
     * @param ownerCellPhone
     */
    public void setOwnerCellPhone(String ownerCellPhone) {
        this.ownerCellPhone = ownerCellPhone;
    }


    /**
     * Gets the ownerEmail value for this SoapAddAppRequest.
     *
     * @return ownerEmail
     */
    public String getOwnerEmail() {
        return ownerEmail;
    }


    /**
     * Sets the ownerEmail value for this SoapAddAppRequest.
     *
     * @param ownerEmail
     */
    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }


    /**
     * Gets the ownerPhone value for this SoapAddAppRequest.
     *
     * @return ownerPhone
     */
    public String getOwnerPhone() {
        return ownerPhone;
    }


    /**
     * Sets the ownerPhone value for this SoapAddAppRequest.
     *
     * @param ownerPhone
     */
    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }


    /**
     * Gets the ownerFax value for this SoapAddAppRequest.
     *
     * @return ownerFax
     */
    public String getOwnerFax() {
        return ownerFax;
    }


    /**
     * Sets the ownerFax value for this SoapAddAppRequest.
     *
     * @param ownerFax
     */
    public void setOwnerFax(String ownerFax) {
        this.ownerFax = ownerFax;
    }


    /**
     * Gets the ownerGender value for this SoapAddAppRequest.
     *
     * @return ownerGender
     */
    public String getOwnerGender() {
        return ownerGender;
    }


    /**
     * Sets the ownerGender value for this SoapAddAppRequest.
     *
     * @param ownerGender
     */
    public void setOwnerGender(String ownerGender) {
        this.ownerGender = ownerGender;
    }


    /**
     * Gets the ownerProvince value for this SoapAddAppRequest.
     *
     * @return ownerProvince
     */
    public String getOwnerProvince() {
        return ownerProvince;
    }


    /**
     * Sets the ownerProvince value for this SoapAddAppRequest.
     *
     * @param ownerProvince
     */
    public void setOwnerProvince(String ownerProvince) {
        this.ownerProvince = ownerProvince;
    }


    /**
     * Gets the ownerCity value for this SoapAddAppRequest.
     *
     * @return ownerCity
     */
    public String getOwnerCity() {
        return ownerCity;
    }


    /**
     * Sets the ownerCity value for this SoapAddAppRequest.
     *
     * @param ownerCity
     */
    public void setOwnerCity(String ownerCity) {
        this.ownerCity = ownerCity;
    }


    /**
     * Gets the ownerAddress value for this SoapAddAppRequest.
     *
     * @return ownerAddress
     */
    public String getOwnerAddress() {
        return ownerAddress;
    }


    /**
     * Sets the ownerAddress value for this SoapAddAppRequest.
     *
     * @param ownerAddress
     */
    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }


    /**
     * Gets the ownerZip value for this SoapAddAppRequest.
     *
     * @return ownerZip
     */
    public String getOwnerZip() {
        return ownerZip;
    }


    /**
     * Sets the ownerZip value for this SoapAddAppRequest.
     *
     * @param ownerZip
     */
    public void setOwnerZip(String ownerZip) {
        this.ownerZip = ownerZip;
    }


    /**
     * Gets the ownerRelativeName value for this SoapAddAppRequest.
     *
     * @return ownerRelativeName
     */
    public String getOwnerRelativeName() {
        return ownerRelativeName;
    }


    /**
     * Sets the ownerRelativeName value for this SoapAddAppRequest.
     *
     * @param ownerRelativeName
     */
    public void setOwnerRelativeName(String ownerRelativeName) {
        this.ownerRelativeName = ownerRelativeName;
    }


    /**
     * Gets the ownerRelativeType value for this SoapAddAppRequest.
     *
     * @return ownerRelativeType
     */
    public String getOwnerRelativeType() {
        return ownerRelativeType;
    }


    /**
     * Sets the ownerRelativeType value for this SoapAddAppRequest.
     *
     * @param ownerRelativeType
     */
    public void setOwnerRelativeType(String ownerRelativeType) {
        this.ownerRelativeType = ownerRelativeType;
    }


    /**
     * Gets the ownerRelativeCellPhone value for this SoapAddAppRequest.
     *
     * @return ownerRelativeCellPhone
     */
    public String getOwnerRelativeCellPhone() {
        return ownerRelativeCellPhone;
    }


    /**
     * Sets the ownerRelativeCellPhone value for this SoapAddAppRequest.
     *
     * @param ownerRelativeCellPhone
     */
    public void setOwnerRelativeCellPhone(String ownerRelativeCellPhone) {
        this.ownerRelativeCellPhone = ownerRelativeCellPhone;
    }


    /**
     * Gets the corporateName value for this SoapAddAppRequest.
     *
     * @return corporateName
     */
    public String getCorporateName() {
        return corporateName;
    }


    /**
     * Sets the corporateName value for this SoapAddAppRequest.
     *
     * @param corporateName
     */
    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }


    /**
     * Gets the corporateProvince value for this SoapAddAppRequest.
     *
     * @return corporateProvince
     */
    public String getCorporateProvince() {
        return corporateProvince;
    }


    /**
     * Sets the corporateProvince value for this SoapAddAppRequest.
     *
     * @param corporateProvince
     */
    public void setCorporateProvince(String corporateProvince) {
        this.corporateProvince = corporateProvince;
    }


    /**
     * Gets the corporateCity value for this SoapAddAppRequest.
     *
     * @return corporateCity
     */
    public String getCorporateCity() {
        return corporateCity;
    }


    /**
     * Sets the corporateCity value for this SoapAddAppRequest.
     *
     * @param corporateCity
     */
    public void setCorporateCity(String corporateCity) {
        this.corporateCity = corporateCity;
    }


    /**
     * Gets the corporateAddress value for this SoapAddAppRequest.
     *
     * @return corporateAddress
     */
    public String getCorporateAddress() {
        return corporateAddress;
    }


    /**
     * Sets the corporateAddress value for this SoapAddAppRequest.
     *
     * @param corporateAddress
     */
    public void setCorporateAddress(String corporateAddress) {
        this.corporateAddress = corporateAddress;
    }


    /**
     * Gets the corporateZip value for this SoapAddAppRequest.
     *
     * @return corporateZip
     */
    public String getCorporateZip() {
        return corporateZip;
    }


    /**
     * Sets the corporateZip value for this SoapAddAppRequest.
     *
     * @param corporateZip
     */
    public void setCorporateZip(String corporateZip) {
        this.corporateZip = corporateZip;
    }


    /**
     * Gets the corporateCapital value for this SoapAddAppRequest.
     *
     * @return corporateCapital
     */
    public String getCorporateCapital() {
        return corporateCapital;
    }


    /**
     * Sets the corporateCapital value for this SoapAddAppRequest.
     *
     * @param corporateCapital
     */
    public void setCorporateCapital(String corporateCapital) {
        this.corporateCapital = corporateCapital;
    }


    /**
     * Gets the corporateType value for this SoapAddAppRequest.
     *
     * @return corporateType
     */
    public String getCorporateType() {
        return corporateType;
    }


    /**
     * Sets the corporateType value for this SoapAddAppRequest.
     *
     * @param corporateType
     */
    public void setCorporateType(String corporateType) {
        this.corporateType = corporateType;
    }


    /**
     * Gets the businesslicenseNo value for this SoapAddAppRequest.
     *
     * @return businesslicenseNo
     */
    public String getBusinesslicenseNo() {
        return businesslicenseNo;
    }


    /**
     * Sets the businesslicenseNo value for this SoapAddAppRequest.
     *
     * @param businesslicenseNo
     */
    public void setBusinesslicenseNo(String businesslicenseNo) {
        this.businesslicenseNo = businesslicenseNo;
    }


    /**
     * Gets the businesslicenseStart value for this SoapAddAppRequest.
     *
     * @return businesslicenseStart
     */
    public String getBusinesslicenseStart() {
        return businesslicenseStart;
    }


    /**
     * Sets the businesslicenseStart value for this SoapAddAppRequest.
     *
     * @param businesslicenseStart
     */
    public void setBusinesslicenseStart(String businesslicenseStart) {
        this.businesslicenseStart = businesslicenseStart;
    }


    /**
     * Gets the businesslicenseEnd value for this SoapAddAppRequest.
     *
     * @return businesslicenseEnd
     */
    public String getBusinesslicenseEnd() {
        return businesslicenseEnd;
    }


    /**
     * Sets the businesslicenseEnd value for this SoapAddAppRequest.
     *
     * @param businesslicenseEnd
     */
    public void setBusinesslicenseEnd(String businesslicenseEnd) {
        this.businesslicenseEnd = businesslicenseEnd;
    }


    /**
     * Gets the businessName value for this SoapAddAppRequest.
     *
     * @return businessName
     */
    public String getBusinessName() {
        return businessName;
    }


    /**
     * Sets the businessName value for this SoapAddAppRequest.
     *
     * @param businessName
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }


    /**
     * Gets the businessBriefName value for this SoapAddAppRequest.
     *
     * @return businessBriefName
     */
    public String getBusinessBriefName() {
        return businessBriefName;
    }


    /**
     * Sets the businessBriefName value for this SoapAddAppRequest.
     *
     * @param businessBriefName
     */
    public void setBusinessBriefName(String businessBriefName) {
        this.businessBriefName = businessBriefName;
    }


    /**
     * Gets the businessProvince value for this SoapAddAppRequest.
     *
     * @return businessProvince
     */
    public String getBusinessProvince() {
        return businessProvince;
    }


    /**
     * Sets the businessProvince value for this SoapAddAppRequest.
     *
     * @param businessProvince
     */
    public void setBusinessProvince(String businessProvince) {
        this.businessProvince = businessProvince;
    }


    /**
     * Gets the businessCity value for this SoapAddAppRequest.
     *
     * @return businessCity
     */
    public String getBusinessCity() {
        return businessCity;
    }


    /**
     * Sets the businessCity value for this SoapAddAppRequest.
     *
     * @param businessCity
     */
    public void setBusinessCity(String businessCity) {
        this.businessCity = businessCity;
    }


    /**
     * Gets the businessAddress value for this SoapAddAppRequest.
     *
     * @return businessAddress
     */
    public String getBusinessAddress() {
        return businessAddress;
    }


    /**
     * Sets the businessAddress value for this SoapAddAppRequest.
     *
     * @param businessAddress
     */
    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }


    /**
     * Gets the businessZip value for this SoapAddAppRequest.
     *
     * @return businessZip
     */
    public String getBusinessZip() {
        return businessZip;
    }


    /**
     * Sets the businessZip value for this SoapAddAppRequest.
     *
     * @param businessZip
     */
    public void setBusinessZip(String businessZip) {
        this.businessZip = businessZip;
    }


    /**
     * Gets the businessYears value for this SoapAddAppRequest.
     *
     * @return businessYears
     */
    public String getBusinessYears() {
        return businessYears;
    }


    /**
     * Sets the businessYears value for this SoapAddAppRequest.
     *
     * @param businessYears
     */
    public void setBusinessYears(String businessYears) {
        this.businessYears = businessYears;
    }


    /**
     * Gets the businessPhone value for this SoapAddAppRequest.
     *
     * @return businessPhone
     */
    public String getBusinessPhone() {
        return businessPhone;
    }


    /**
     * Sets the businessPhone value for this SoapAddAppRequest.
     *
     * @param businessPhone
     */
    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }


    /**
     * Gets the businessWebsite value for this SoapAddAppRequest.
     *
     * @return businessWebsite
     */
    public String getBusinessWebsite() {
        return businessWebsite;
    }


    /**
     * Sets the businessWebsite value for this SoapAddAppRequest.
     *
     * @param businessWebsite
     */
    public void setBusinessWebsite(String businessWebsite) {
        this.businessWebsite = businessWebsite;
    }


    /**
     * Gets the businessScope value for this SoapAddAppRequest.
     *
     * @return businessScope
     */
    public String getBusinessScope() {
        return businessScope;
    }


    /**
     * Sets the businessScope value for this SoapAddAppRequest.
     *
     * @param businessScope
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }


    /**
     * Gets the monthlyVolume value for this SoapAddAppRequest.
     *
     * @return monthlyVolume
     */
    public String getMonthlyVolume() {
        return monthlyVolume;
    }


    /**
     * Sets the monthlyVolume value for this SoapAddAppRequest.
     *
     * @param monthlyVolume
     */
    public void setMonthlyVolume(String monthlyVolume) {
        this.monthlyVolume = monthlyVolume;
    }


    /**
     * Gets the posMonthlyVolume value for this SoapAddAppRequest.
     *
     * @return posMonthlyVolume
     */
    public String getPosMonthlyVolume() {
        return posMonthlyVolume;
    }


    /**
     * Sets the posMonthlyVolume value for this SoapAddAppRequest.
     *
     * @param posMonthlyVolume
     */
    public void setPosMonthlyVolume(String posMonthlyVolume) {
        this.posMonthlyVolume = posMonthlyVolume;
    }


    /**
     * Gets the monthlyPurchases value for this SoapAddAppRequest.
     *
     * @return monthlyPurchases
     */
    public String getMonthlyPurchases() {
        return monthlyPurchases;
    }


    /**
     * Sets the monthlyPurchases value for this SoapAddAppRequest.
     *
     * @param monthlyPurchases
     */
    public void setMonthlyPurchases(String monthlyPurchases) {
        this.monthlyPurchases = monthlyPurchases;
    }


    /**
     * Gets the monthlyUtilityBill value for this SoapAddAppRequest.
     *
     * @return monthlyUtilityBill
     */
    public String getMonthlyUtilityBill() {
        return monthlyUtilityBill;
    }


    /**
     * Sets the monthlyUtilityBill value for this SoapAddAppRequest.
     *
     * @param monthlyUtilityBill
     */
    public void setMonthlyUtilityBill(String monthlyUtilityBill) {
        this.monthlyUtilityBill = monthlyUtilityBill;
    }


    /**
     * Gets the monthlyShareholderPay value for this SoapAddAppRequest.
     *
     * @return monthlyShareholderPay
     */
    public String getMonthlyShareholderPay() {
        return monthlyShareholderPay;
    }


    /**
     * Sets the monthlyShareholderPay value for this SoapAddAppRequest.
     *
     * @param monthlyShareholderPay
     */
    public void setMonthlyShareholderPay(String monthlyShareholderPay) {
        this.monthlyShareholderPay = monthlyShareholderPay;
    }


    /**
     * Gets the monthlyStaffPay value for this SoapAddAppRequest.
     *
     * @return monthlyStaffPay
     */
    public String getMonthlyStaffPay() {
        return monthlyStaffPay;
    }


    /**
     * Sets the monthlyStaffPay value for this SoapAddAppRequest.
     *
     * @param monthlyStaffPay
     */
    public void setMonthlyStaffPay(String monthlyStaffPay) {
        this.monthlyStaffPay = monthlyStaffPay;
    }


    /**
     * Gets the acceptCardTypes value for this SoapAddAppRequest.
     *
     * @return acceptCardTypes
     */
    public String getAcceptCardTypes() {
        return acceptCardTypes;
    }


    /**
     * Sets the acceptCardTypes value for this SoapAddAppRequest.
     *
     * @param acceptCardTypes
     */
    public void setAcceptCardTypes(String acceptCardTypes) {
        this.acceptCardTypes = acceptCardTypes;
    }


    /**
     * Gets the foriegnCardRate value for this SoapAddAppRequest.
     *
     * @return foriegnCardRate
     */
    public String getForiegnCardRate() {
        return foriegnCardRate;
    }


    /**
     * Sets the foriegnCardRate value for this SoapAddAppRequest.
     *
     * @param foriegnCardRate
     */
    public void setForiegnCardRate(String foriegnCardRate) {
        this.foriegnCardRate = foriegnCardRate;
    }


    /**
     * Gets the foriegnCardTop value for this SoapAddAppRequest.
     *
     * @return foriegnCardTop
     */
    public String getForiegnCardTop() {
        return foriegnCardTop;
    }


    /**
     * Sets the foriegnCardTop value for this SoapAddAppRequest.
     *
     * @param foriegnCardTop
     */
    public void setForiegnCardTop(String foriegnCardTop) {
        this.foriegnCardTop = foriegnCardTop;
    }


    /**
     * Gets the localCardRate value for this SoapAddAppRequest.
     *
     * @return localCardRate
     */
    public String getLocalCardRate() {
        return localCardRate;
    }


    /**
     * Sets the localCardRate value for this SoapAddAppRequest.
     *
     * @param localCardRate
     */
    public void setLocalCardRate(String localCardRate) {
        this.localCardRate = localCardRate;
    }


    /**
     * Gets the localCardTop value for this SoapAddAppRequest.
     *
     * @return localCardTop
     */
    public String getLocalCardTop() {
        return localCardTop;
    }


    /**
     * Sets the localCardTop value for this SoapAddAppRequest.
     *
     * @param localCardTop
     */
    public void setLocalCardTop(String localCardTop) {
        this.localCardTop = localCardTop;
    }


    /**
     * Gets the MID1 value for this SoapAddAppRequest.
     *
     * @return MID1
     */
    public String getMID1() {
        return MID1;
    }


    /**
     * Sets the MID1 value for this SoapAddAppRequest.
     *
     * @param MID1
     */
    public void setMID1(String MID1) {
        this.MID1 = MID1;
    }


    /**
     * Gets the posCnt1 value for this SoapAddAppRequest.
     *
     * @return posCnt1
     */
    public String getPosCnt1() {
        return posCnt1;
    }


    /**
     * Sets the posCnt1 value for this SoapAddAppRequest.
     *
     * @param posCnt1
     */
    public void setPosCnt1(String posCnt1) {
        this.posCnt1 = posCnt1;
    }


    /**
     * Gets the posIDs1 value for this SoapAddAppRequest.
     *
     * @return posIDs1
     */
    public String getPosIDs1() {
        return posIDs1;
    }


    /**
     * Sets the posIDs1 value for this SoapAddAppRequest.
     *
     * @param posIDs1
     */
    public void setPosIDs1(String posIDs1) {
        this.posIDs1 = posIDs1;
    }


    /**
     * Gets the MID2 value for this SoapAddAppRequest.
     *
     * @return MID2
     */
    public String getMID2() {
        return MID2;
    }


    /**
     * Sets the MID2 value for this SoapAddAppRequest.
     *
     * @param MID2
     */
    public void setMID2(String MID2) {
        this.MID2 = MID2;
    }


    /**
     * Gets the posCnt2 value for this SoapAddAppRequest.
     *
     * @return posCnt2
     */
    public String getPosCnt2() {
        return posCnt2;
    }


    /**
     * Sets the posCnt2 value for this SoapAddAppRequest.
     *
     * @param posCnt2
     */
    public void setPosCnt2(String posCnt2) {
        this.posCnt2 = posCnt2;
    }


    /**
     * Gets the posIDs2 value for this SoapAddAppRequest.
     *
     * @return posIDs2
     */
    public String getPosIDs2() {
        return posIDs2;
    }


    /**
     * Sets the posIDs2 value for this SoapAddAppRequest.
     *
     * @param posIDs2
     */
    public void setPosIDs2(String posIDs2) {
        this.posIDs2 = posIDs2;
    }


    /**
     * Gets the MID3 value for this SoapAddAppRequest.
     *
     * @return MID3
     */
    public String getMID3() {
        return MID3;
    }


    /**
     * Sets the MID3 value for this SoapAddAppRequest.
     *
     * @param MID3
     */
    public void setMID3(String MID3) {
        this.MID3 = MID3;
    }


    /**
     * Gets the posCnt3 value for this SoapAddAppRequest.
     *
     * @return posCnt3
     */
    public String getPosCnt3() {
        return posCnt3;
    }


    /**
     * Sets the posCnt3 value for this SoapAddAppRequest.
     *
     * @param posCnt3
     */
    public void setPosCnt3(String posCnt3) {
        this.posCnt3 = posCnt3;
    }


    /**
     * Gets the posIDs3 value for this SoapAddAppRequest.
     *
     * @return posIDs3
     */
    public String getPosIDs3() {
        return posIDs3;
    }


    /**
     * Sets the posIDs3 value for this SoapAddAppRequest.
     *
     * @param posIDs3
     */
    public void setPosIDs3(String posIDs3) {
        this.posIDs3 = posIDs3;
    }


    /**
     * Gets the businessArea value for this SoapAddAppRequest.
     *
     * @return businessArea
     */
    public String getBusinessArea() {
        return businessArea;
    }


    /**
     * Sets the businessArea value for this SoapAddAppRequest.
     *
     * @param businessArea
     */
    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }


    /**
     * Gets the businessDistrict value for this SoapAddAppRequest.
     *
     * @return businessDistrict
     */
    public String getBusinessDistrict() {
        return businessDistrict;
    }


    /**
     * Sets the businessDistrict value for this SoapAddAppRequest.
     *
     * @param businessDistrict
     */
    public void setBusinessDistrict(String businessDistrict) {
        this.businessDistrict = businessDistrict;
    }


    /**
     * Gets the realEstateType value for this SoapAddAppRequest.
     *
     * @return realEstateType
     */
    public String getRealEstateType() {
        return realEstateType;
    }


    /**
     * Sets the realEstateType value for this SoapAddAppRequest.
     *
     * @param realEstateType
     */
    public void setRealEstateType(String realEstateType) {
        this.realEstateType = realEstateType;
    }


    /**
     * Gets the monthlyRent value for this SoapAddAppRequest.
     *
     * @return monthlyRent
     */
    public String getMonthlyRent() {
        return monthlyRent;
    }


    /**
     * Sets the monthlyRent value for this SoapAddAppRequest.
     *
     * @param monthlyRent
     */
    public void setMonthlyRent(String monthlyRent) {
        this.monthlyRent = monthlyRent;
    }


    /**
     * Gets the rentDepositMonths value for this SoapAddAppRequest.
     *
     * @return rentDepositMonths
     */
    public String getRentDepositMonths() {
        return rentDepositMonths;
    }


    /**
     * Sets the rentDepositMonths value for this SoapAddAppRequest.
     *
     * @param rentDepositMonths
     */
    public void setRentDepositMonths(String rentDepositMonths) {
        this.rentDepositMonths = rentDepositMonths;
    }


    /**
     * Gets the rentInAdvanceMonths value for this SoapAddAppRequest.
     *
     * @return rentInAdvanceMonths
     */
    public String getRentInAdvanceMonths() {
        return rentInAdvanceMonths;
    }


    /**
     * Sets the rentInAdvanceMonths value for this SoapAddAppRequest.
     *
     * @param rentInAdvanceMonths
     */
    public void setRentInAdvanceMonths(String rentInAdvanceMonths) {
        this.rentInAdvanceMonths = rentInAdvanceMonths;
    }


    /**
     * Gets the rentingStart value for this SoapAddAppRequest.
     *
     * @return rentingStart
     */
    public String getRentingStart() {
        return rentingStart;
    }


    /**
     * Sets the rentingStart value for this SoapAddAppRequest.
     *
     * @param rentingStart
     */
    public void setRentingStart(String rentingStart) {
        this.rentingStart = rentingStart;
    }


    /**
     * Gets the rentingEnd value for this SoapAddAppRequest.
     *
     * @return rentingEnd
     */
    public String getRentingEnd() {
        return rentingEnd;
    }


    /**
     * Sets the rentingEnd value for this SoapAddAppRequest.
     *
     * @param rentingEnd
     */
    public void setRentingEnd(String rentingEnd) {
        this.rentingEnd = rentingEnd;
    }


    /**
     * Gets the landLordName value for this SoapAddAppRequest.
     *
     * @return landLordName
     */
    public String getLandLordName() {
        return landLordName;
    }


    /**
     * Sets the landLordName value for this SoapAddAppRequest.
     *
     * @param landLordName
     */
    public void setLandLordName(String landLordName) {
        this.landLordName = landLordName;
    }


    /**
     * Gets the landLordPhone value for this SoapAddAppRequest.
     *
     * @return landLordPhone
     */
    public String getLandLordPhone() {
        return landLordPhone;
    }


    /**
     * Sets the landLordPhone value for this SoapAddAppRequest.
     *
     * @param landLordPhone
     */
    public void setLandLordPhone(String landLordPhone) {
        this.landLordPhone = landLordPhone;
    }


    /**
     * Gets the landLordCellPhone value for this SoapAddAppRequest.
     *
     * @return landLordCellPhone
     */
    public String getLandLordCellPhone() {
        return landLordCellPhone;
    }


    /**
     * Sets the landLordCellPhone value for this SoapAddAppRequest.
     *
     * @param landLordCellPhone
     */
    public void setLandLordCellPhone(String landLordCellPhone) {
        this.landLordCellPhone = landLordCellPhone;
    }


    /**
     * Gets the landLordAdress value for this SoapAddAppRequest.
     *
     * @return landLordAdress
     */
    public String getLandLordAdress() {
        return landLordAdress;
    }


    /**
     * Sets the landLordAdress value for this SoapAddAppRequest.
     *
     * @param landLordAdress
     */
    public void setLandLordAdress(String landLordAdress) {
        this.landLordAdress = landLordAdress;
    }


    /**
     * Gets the basicSettleAccountType value for this SoapAddAppRequest.
     *
     * @return basicSettleAccountType
     */
    public String getBasicSettleAccountType() {
        return basicSettleAccountType;
    }


    /**
     * Sets the basicSettleAccountType value for this SoapAddAppRequest.
     *
     * @param basicSettleAccountType
     */
    public void setBasicSettleAccountType(String basicSettleAccountType) {
        this.basicSettleAccountType = basicSettleAccountType;
    }


    /**
     * Gets the basicSettleAccountName value for this SoapAddAppRequest.
     *
     * @return basicSettleAccountName
     */
    public String getBasicSettleAccountName() {
        return basicSettleAccountName;
    }


    /**
     * Sets the basicSettleAccountName value for this SoapAddAppRequest.
     *
     * @param basicSettleAccountName
     */
    public void setBasicSettleAccountName(String basicSettleAccountName) {
        this.basicSettleAccountName = basicSettleAccountName;
    }


    /**
     * Gets the basicSettleAccountNo value for this SoapAddAppRequest.
     *
     * @return basicSettleAccountNo
     */
    public String getBasicSettleAccountNo() {
        return basicSettleAccountNo;
    }


    /**
     * Sets the basicSettleAccountNo value for this SoapAddAppRequest.
     *
     * @param basicSettleAccountNo
     */
    public void setBasicSettleAccountNo(String basicSettleAccountNo) {
        this.basicSettleAccountNo = basicSettleAccountNo;
    }


    /**
     * Gets the basicSettleAccountBankNo value for this SoapAddAppRequest.
     *
     * @return basicSettleAccountBankNo
     */
    public String getBasicSettleAccountBankNo() {
        return basicSettleAccountBankNo;
    }


    /**
     * Sets the basicSettleAccountBankNo value for this SoapAddAppRequest.
     *
     * @param basicSettleAccountBankNo
     */
    public void setBasicSettleAccountBankNo(String basicSettleAccountBankNo) {
        this.basicSettleAccountBankNo = basicSettleAccountBankNo;
    }


    /**
     * Gets the basicSettleAccountProvince value for this SoapAddAppRequest.
     *
     * @return basicSettleAccountProvince
     */
    public String getBasicSettleAccountProvince() {
        return basicSettleAccountProvince;
    }


    /**
     * Sets the basicSettleAccountProvince value for this SoapAddAppRequest.
     *
     * @param basicSettleAccountProvince
     */
    public void setBasicSettleAccountProvince(String basicSettleAccountProvince) {
        this.basicSettleAccountProvince = basicSettleAccountProvince;
    }


    /**
     * Gets the basicSettleAccountCity value for this SoapAddAppRequest.
     *
     * @return basicSettleAccountCity
     */
    public String getBasicSettleAccountCity() {
        return basicSettleAccountCity;
    }


    /**
     * Sets the basicSettleAccountCity value for this SoapAddAppRequest.
     *
     * @param basicSettleAccountCity
     */
    public void setBasicSettleAccountCity(String basicSettleAccountCity) {
        this.basicSettleAccountCity = basicSettleAccountCity;
    }


    /**
     * Gets the basicSettleAccountBankName value for this SoapAddAppRequest.
     *
     * @return basicSettleAccountBankName
     */
    public String getBasicSettleAccountBankName() {
        return basicSettleAccountBankName;
    }


    /**
     * Sets the basicSettleAccountBankName value for this SoapAddAppRequest.
     *
     * @param basicSettleAccountBankName
     */
    public void setBasicSettleAccountBankName(String basicSettleAccountBankName) {
        this.basicSettleAccountBankName = basicSettleAccountBankName;
    }


    /**
     * Gets the ownerDebitCardName1 value for this SoapAddAppRequest.
     *
     * @return ownerDebitCardName1
     */
    public String getOwnerDebitCardName1() {
        return ownerDebitCardName1;
    }


    /**
     * Sets the ownerDebitCardName1 value for this SoapAddAppRequest.
     *
     * @param ownerDebitCardName1
     */
    public void setOwnerDebitCardName1(String ownerDebitCardName1) {
        this.ownerDebitCardName1 = ownerDebitCardName1;
    }


    /**
     * Gets the ownerDebitCardNo1 value for this SoapAddAppRequest.
     *
     * @return ownerDebitCardNo1
     */
    public String getOwnerDebitCardNo1() {
        return ownerDebitCardNo1;
    }


    /**
     * Sets the ownerDebitCardNo1 value for this SoapAddAppRequest.
     *
     * @param ownerDebitCardNo1
     */
    public void setOwnerDebitCardNo1(String ownerDebitCardNo1) {
        this.ownerDebitCardNo1 = ownerDebitCardNo1;
    }


    /**
     * Gets the ownerDebitCardBank1 value for this SoapAddAppRequest.
     *
     * @return ownerDebitCardBank1
     */
    public String getOwnerDebitCardBank1() {
        return ownerDebitCardBank1;
    }


    /**
     * Sets the ownerDebitCardBank1 value for this SoapAddAppRequest.
     *
     * @param ownerDebitCardBank1
     */
    public void setOwnerDebitCardBank1(String ownerDebitCardBank1) {
        this.ownerDebitCardBank1 = ownerDebitCardBank1;
    }


    /**
     * Gets the ownerDebitCardName2 value for this SoapAddAppRequest.
     *
     * @return ownerDebitCardName2
     */
    public String getOwnerDebitCardName2() {
        return ownerDebitCardName2;
    }


    /**
     * Sets the ownerDebitCardName2 value for this SoapAddAppRequest.
     *
     * @param ownerDebitCardName2
     */
    public void setOwnerDebitCardName2(String ownerDebitCardName2) {
        this.ownerDebitCardName2 = ownerDebitCardName2;
    }


    /**
     * Gets the ownerDebitCardNo2 value for this SoapAddAppRequest.
     *
     * @return ownerDebitCardNo2
     */
    public String getOwnerDebitCardNo2() {
        return ownerDebitCardNo2;
    }


    /**
     * Sets the ownerDebitCardNo2 value for this SoapAddAppRequest.
     *
     * @param ownerDebitCardNo2
     */
    public void setOwnerDebitCardNo2(String ownerDebitCardNo2) {
        this.ownerDebitCardNo2 = ownerDebitCardNo2;
    }


    /**
     * Gets the ownerDebitCardBank2 value for this SoapAddAppRequest.
     *
     * @return ownerDebitCardBank2
     */
    public String getOwnerDebitCardBank2() {
        return ownerDebitCardBank2;
    }


    /**
     * Sets the ownerDebitCardBank2 value for this SoapAddAppRequest.
     *
     * @param ownerDebitCardBank2
     */
    public void setOwnerDebitCardBank2(String ownerDebitCardBank2) {
        this.ownerDebitCardBank2 = ownerDebitCardBank2;
    }


    /**
     * Gets the ownerDebitCardName3 value for this SoapAddAppRequest.
     *
     * @return ownerDebitCardName3
     */
    public String getOwnerDebitCardName3() {
        return ownerDebitCardName3;
    }


    /**
     * Sets the ownerDebitCardName3 value for this SoapAddAppRequest.
     *
     * @param ownerDebitCardName3
     */
    public void setOwnerDebitCardName3(String ownerDebitCardName3) {
        this.ownerDebitCardName3 = ownerDebitCardName3;
    }


    /**
     * Gets the ownerDebitCardNo3 value for this SoapAddAppRequest.
     *
     * @return ownerDebitCardNo3
     */
    public String getOwnerDebitCardNo3() {
        return ownerDebitCardNo3;
    }


    /**
     * Sets the ownerDebitCardNo3 value for this SoapAddAppRequest.
     *
     * @param ownerDebitCardNo3
     */
    public void setOwnerDebitCardNo3(String ownerDebitCardNo3) {
        this.ownerDebitCardNo3 = ownerDebitCardNo3;
    }


    /**
     * Gets the ownerDebitCardBank3 value for this SoapAddAppRequest.
     *
     * @return ownerDebitCardBank3
     */
    public String getOwnerDebitCardBank3() {
        return ownerDebitCardBank3;
    }


    /**
     * Sets the ownerDebitCardBank3 value for this SoapAddAppRequest.
     *
     * @param ownerDebitCardBank3
     */
    public void setOwnerDebitCardBank3(String ownerDebitCardBank3) {
        this.ownerDebitCardBank3 = ownerDebitCardBank3;
    }


    /**
     * Gets the prodName value for this SoapAddAppRequest.
     *
     * @return prodName
     */
    public String getProdName() {
        return prodName;
    }


    /**
     * Sets the prodName value for this SoapAddAppRequest.
     *
     * @param prodName
     */
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }


    /**
     * Gets the fundingAmount value for this SoapAddAppRequest.
     *
     * @return fundingAmount
     */
    public String getFundingAmount() {
        return fundingAmount;
    }


    /**
     * Sets the fundingAmount value for this SoapAddAppRequest.
     *
     * @param fundingAmount
     */
    public void setFundingAmount(String fundingAmount) {
        this.fundingAmount = fundingAmount;
    }


    /**
     * Gets the fundingPeriod value for this SoapAddAppRequest.
     *
     * @return fundingPeriod
     */
    public String getFundingPeriod() {
        return fundingPeriod;
    }


    /**
     * Sets the fundingPeriod value for this SoapAddAppRequest.
     *
     * @param fundingPeriod
     */
    public void setFundingPeriod(String fundingPeriod) {
        this.fundingPeriod = fundingPeriod;
    }


    /**
     * Gets the fundingPurpose value for this SoapAddAppRequest.
     *
     * @return fundingPurpose
     */
    public String getFundingPurpose() {
        return fundingPurpose;
    }


    /**
     * Sets the fundingPurpose value for this SoapAddAppRequest.
     *
     * @param fundingPurpose
     */
    public void setFundingPurpose(String fundingPurpose) {
        this.fundingPurpose = fundingPurpose;
    }


    /**
     * Gets the fundingProduct value for this SoapAddAppRequest.
     *
     * @return fundingProduct
     */
    public String getFundingProduct() {
        return fundingProduct;
    }


    /**
     * Sets the fundingProduct value for this SoapAddAppRequest.
     *
     * @param fundingProduct
     */
    public void setFundingProduct(String fundingProduct) {
        this.fundingProduct = fundingProduct;
    }


    /**
     * Gets the onlinePaybackRecur value for this SoapAddAppRequest.
     *
     * @return onlinePaybackRecur
     */
    public String getOnlinePaybackRecur() {
        return onlinePaybackRecur;
    }


    /**
     * Sets the onlinePaybackRecur value for this SoapAddAppRequest.
     *
     * @param onlinePaybackRecur
     */
    public void setOnlinePaybackRecur(String onlinePaybackRecur) {
        this.onlinePaybackRecur = onlinePaybackRecur;
    }


    /**
     * Gets the directDebitRecur value for this SoapAddAppRequest.
     *
     * @return directDebitRecur
     */
    public String getDirectDebitRecur() {
        return directDebitRecur;
    }


    /**
     * Sets the directDebitRecur value for this SoapAddAppRequest.
     *
     * @param directDebitRecur
     */
    public void setDirectDebitRecur(String directDebitRecur) {
        this.directDebitRecur = directDebitRecur;
    }


    /**
     * Gets the comments value for this SoapAddAppRequest.
     *
     * @return comments
     */
    public String getComments() {
        return comments;
    }


    /**
     * Sets the comments value for this SoapAddAppRequest.
     *
     * @param comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SoapAddAppRequest)) return false;
        SoapAddAppRequest other = (SoapAddAppRequest) obj;
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
            ((this.user_id==null && other.getUser_id()==null) ||
             (this.user_id!=null &&
              this.user_id.equals(other.getUser_id()))) &&
            ((this.deal_id==null && other.getDeal_id()==null) ||
             (this.deal_id!=null &&
              this.deal_id.equals(other.getDeal_id()))) &&
            ((this.processor==null && other.getProcessor()==null) ||
             (this.processor!=null &&
              this.processor.equals(other.getProcessor()))) &&
            ((this.preferential==null && other.getPreferential()==null) ||
             (this.preferential!=null &&
              this.preferential.equals(other.getPreferential()))) &&
            ((this.factorRate==null && other.getFactorRate()==null) ||
             (this.factorRate!=null &&
              this.factorRate.equals(other.getFactorRate()))) &&
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
              this.ownerDebitCardBank3.equals(other.getOwnerDebitCardBank3()))) &&
            ((this.prodName==null && other.getProdName()==null) ||
             (this.prodName!=null &&
              this.prodName.equals(other.getProdName()))) &&
            ((this.fundingAmount==null && other.getFundingAmount()==null) ||
             (this.fundingAmount!=null &&
              this.fundingAmount.equals(other.getFundingAmount()))) &&
            ((this.fundingPeriod==null && other.getFundingPeriod()==null) ||
             (this.fundingPeriod!=null &&
              this.fundingPeriod.equals(other.getFundingPeriod()))) &&
            ((this.fundingPurpose==null && other.getFundingPurpose()==null) ||
             (this.fundingPurpose!=null &&
              this.fundingPurpose.equals(other.getFundingPurpose()))) &&
            ((this.fundingProduct==null && other.getFundingProduct()==null) ||
             (this.fundingProduct!=null &&
              this.fundingProduct.equals(other.getFundingProduct()))) &&
            ((this.onlinePaybackRecur==null && other.getOnlinePaybackRecur()==null) ||
             (this.onlinePaybackRecur!=null &&
              this.onlinePaybackRecur.equals(other.getOnlinePaybackRecur()))) &&
            ((this.directDebitRecur==null && other.getDirectDebitRecur()==null) ||
             (this.directDebitRecur!=null &&
              this.directDebitRecur.equals(other.getDirectDebitRecur()))) &&
            ((this.comments==null && other.getComments()==null) ||
             (this.comments!=null &&
              this.comments.equals(other.getComments())));
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
        if (getUser_id() != null) {
            _hashCode += getUser_id().hashCode();
        }
        if (getDeal_id() != null) {
            _hashCode += getDeal_id().hashCode();
        }
        if (getProcessor() != null) {
            _hashCode += getProcessor().hashCode();
        }
        if (getPreferential() != null) {
            _hashCode += getPreferential().hashCode();
        }
        if (getFactorRate() != null) {
            _hashCode += getFactorRate().hashCode();
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
        if (getProdName() != null) {
            _hashCode += getProdName().hashCode();
        }
        if (getFundingAmount() != null) {
            _hashCode += getFundingAmount().hashCode();
        }
        if (getFundingPeriod() != null) {
            _hashCode += getFundingPeriod().hashCode();
        }
        if (getFundingPurpose() != null) {
            _hashCode += getFundingPurpose().hashCode();
        }
        if (getFundingProduct() != null) {
            _hashCode += getFundingProduct().hashCode();
        }
        if (getOnlinePaybackRecur() != null) {
            _hashCode += getOnlinePaybackRecur().hashCode();
        }
        if (getDirectDebitRecur() != null) {
            _hashCode += getDirectDebitRecur().hashCode();
        }
        if (getComments() != null) {
            _hashCode += getComments().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapAddAppRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapAddAppRequest"));
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
        elemField.setFieldName("user_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deal_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deal_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "processor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preferential");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preferential"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("factorRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FactorRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prodName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prodName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fundingAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FundingAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fundingPeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FundingPeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fundingPurpose");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FundingPurpose"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fundingProduct");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FundingProduct"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("onlinePaybackRecur");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OnlinePaybackRecur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("directDebitRecur");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DirectDebitRecur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comments");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Comments"));
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
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
