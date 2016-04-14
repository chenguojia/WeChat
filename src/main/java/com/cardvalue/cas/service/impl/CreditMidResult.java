/**
 * CreditMidResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.cas.service.impl;

public class CreditMidResult  implements java.io.Serializable {
    private java.lang.String businessId;

    private java.lang.String mid;

    private java.lang.String status;

    private java.lang.String statusInfo;

    private java.lang.String corpName;

    private java.lang.String posCount;

    private java.lang.String posIds;

    private java.lang.String mcc;

    private java.lang.String mccNo;

    private java.lang.String city;

    private java.lang.String address;

    private java.lang.String borrow;

    private java.lang.String lend;

    private java.lang.String transCount;

    private java.lang.String firstTransDate;

    private java.lang.String lastTransDate;

    private java.lang.String stableS;

    private java.lang.String growthG;

    private java.lang.String recencyRdays;

    private java.lang.String recencyR;

    private java.lang.String averageA;

    private java.lang.String frequencyF;

    private java.lang.String monetaryM;

    private java.lang.String perMonVolumeP;

    private java.lang.String lastMonVolumeL;

    private java.lang.String busiMonths;

    private java.lang.String contMonths;

    private java.lang.String creditRating;

    private java.lang.String passFlag;

    private java.lang.String creditScore;

    private java.lang.String creditAmount;

    private com.cardvalue.cas.service.impl.MidMonthStatistic[] monthStat;

    private com.cardvalue.cas.service.impl.MidVerifyTrans[] verifyTrans;

    private com.cardvalue.cas.service.impl.MidCardsStatistic[] cardStat;

    public CreditMidResult() {
    }

    public CreditMidResult(
           java.lang.String businessId,
           java.lang.String mid,
           java.lang.String status,
           java.lang.String statusInfo,
           java.lang.String corpName,
           java.lang.String posCount,
           java.lang.String posIds,
           java.lang.String mcc,
           java.lang.String mccNo,
           java.lang.String city,
           java.lang.String address,
           java.lang.String borrow,
           java.lang.String lend,
           java.lang.String transCount,
           java.lang.String firstTransDate,
           java.lang.String lastTransDate,
           java.lang.String stableS,
           java.lang.String growthG,
           java.lang.String recencyRdays,
           java.lang.String recencyR,
           java.lang.String averageA,
           java.lang.String frequencyF,
           java.lang.String monetaryM,
           java.lang.String perMonVolumeP,
           java.lang.String lastMonVolumeL,
           java.lang.String busiMonths,
           java.lang.String contMonths,
           java.lang.String creditRating,
           java.lang.String passFlag,
           java.lang.String creditScore,
           java.lang.String creditAmount,
           com.cardvalue.cas.service.impl.MidMonthStatistic[] monthStat,
           com.cardvalue.cas.service.impl.MidVerifyTrans[] verifyTrans,
           com.cardvalue.cas.service.impl.MidCardsStatistic[] cardStat) {
           this.businessId = businessId;
           this.mid = mid;
           this.status = status;
           this.statusInfo = statusInfo;
           this.corpName = corpName;
           this.posCount = posCount;
           this.posIds = posIds;
           this.mcc = mcc;
           this.mccNo = mccNo;
           this.city = city;
           this.address = address;
           this.borrow = borrow;
           this.lend = lend;
           this.transCount = transCount;
           this.firstTransDate = firstTransDate;
           this.lastTransDate = lastTransDate;
           this.stableS = stableS;
           this.growthG = growthG;
           this.recencyRdays = recencyRdays;
           this.recencyR = recencyR;
           this.averageA = averageA;
           this.frequencyF = frequencyF;
           this.monetaryM = monetaryM;
           this.perMonVolumeP = perMonVolumeP;
           this.lastMonVolumeL = lastMonVolumeL;
           this.busiMonths = busiMonths;
           this.contMonths = contMonths;
           this.creditRating = creditRating;
           this.passFlag = passFlag;
           this.creditScore = creditScore;
           this.creditAmount = creditAmount;
           this.monthStat = monthStat;
           this.verifyTrans = verifyTrans;
           this.cardStat = cardStat;
    }


    /**
     * Gets the businessId value for this CreditMidResult.
     * 
     * @return businessId
     */
    public java.lang.String getBusinessId() {
        return businessId;
    }


    /**
     * Sets the businessId value for this CreditMidResult.
     * 
     * @param businessId
     */
    public void setBusinessId(java.lang.String businessId) {
        this.businessId = businessId;
    }


    /**
     * Gets the mid value for this CreditMidResult.
     * 
     * @return mid
     */
    public java.lang.String getMid() {
        return mid;
    }


    /**
     * Sets the mid value for this CreditMidResult.
     * 
     * @param mid
     */
    public void setMid(java.lang.String mid) {
        this.mid = mid;
    }


    /**
     * Gets the status value for this CreditMidResult.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this CreditMidResult.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the statusInfo value for this CreditMidResult.
     * 
     * @return statusInfo
     */
    public java.lang.String getStatusInfo() {
        return statusInfo;
    }


    /**
     * Sets the statusInfo value for this CreditMidResult.
     * 
     * @param statusInfo
     */
    public void setStatusInfo(java.lang.String statusInfo) {
        this.statusInfo = statusInfo;
    }


    /**
     * Gets the corpName value for this CreditMidResult.
     * 
     * @return corpName
     */
    public java.lang.String getCorpName() {
        return corpName;
    }


    /**
     * Sets the corpName value for this CreditMidResult.
     * 
     * @param corpName
     */
    public void setCorpName(java.lang.String corpName) {
        this.corpName = corpName;
    }


    /**
     * Gets the posCount value for this CreditMidResult.
     * 
     * @return posCount
     */
    public java.lang.String getPosCount() {
        return posCount;
    }


    /**
     * Sets the posCount value for this CreditMidResult.
     * 
     * @param posCount
     */
    public void setPosCount(java.lang.String posCount) {
        this.posCount = posCount;
    }


    /**
     * Gets the posIds value for this CreditMidResult.
     * 
     * @return posIds
     */
    public java.lang.String getPosIds() {
        return posIds;
    }


    /**
     * Sets the posIds value for this CreditMidResult.
     * 
     * @param posIds
     */
    public void setPosIds(java.lang.String posIds) {
        this.posIds = posIds;
    }


    /**
     * Gets the mcc value for this CreditMidResult.
     * 
     * @return mcc
     */
    public java.lang.String getMcc() {
        return mcc;
    }


    /**
     * Sets the mcc value for this CreditMidResult.
     * 
     * @param mcc
     */
    public void setMcc(java.lang.String mcc) {
        this.mcc = mcc;
    }


    /**
     * Gets the mccNo value for this CreditMidResult.
     * 
     * @return mccNo
     */
    public java.lang.String getMccNo() {
        return mccNo;
    }


    /**
     * Sets the mccNo value for this CreditMidResult.
     * 
     * @param mccNo
     */
    public void setMccNo(java.lang.String mccNo) {
        this.mccNo = mccNo;
    }


    /**
     * Gets the city value for this CreditMidResult.
     * 
     * @return city
     */
    public java.lang.String getCity() {
        return city;
    }


    /**
     * Sets the city value for this CreditMidResult.
     * 
     * @param city
     */
    public void setCity(java.lang.String city) {
        this.city = city;
    }


    /**
     * Gets the address value for this CreditMidResult.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this CreditMidResult.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the borrow value for this CreditMidResult.
     * 
     * @return borrow
     */
    public java.lang.String getBorrow() {
        return borrow;
    }


    /**
     * Sets the borrow value for this CreditMidResult.
     * 
     * @param borrow
     */
    public void setBorrow(java.lang.String borrow) {
        this.borrow = borrow;
    }


    /**
     * Gets the lend value for this CreditMidResult.
     * 
     * @return lend
     */
    public java.lang.String getLend() {
        return lend;
    }


    /**
     * Sets the lend value for this CreditMidResult.
     * 
     * @param lend
     */
    public void setLend(java.lang.String lend) {
        this.lend = lend;
    }


    /**
     * Gets the transCount value for this CreditMidResult.
     * 
     * @return transCount
     */
    public java.lang.String getTransCount() {
        return transCount;
    }


    /**
     * Sets the transCount value for this CreditMidResult.
     * 
     * @param transCount
     */
    public void setTransCount(java.lang.String transCount) {
        this.transCount = transCount;
    }


    /**
     * Gets the firstTransDate value for this CreditMidResult.
     * 
     * @return firstTransDate
     */
    public java.lang.String getFirstTransDate() {
        return firstTransDate;
    }


    /**
     * Sets the firstTransDate value for this CreditMidResult.
     * 
     * @param firstTransDate
     */
    public void setFirstTransDate(java.lang.String firstTransDate) {
        this.firstTransDate = firstTransDate;
    }


    /**
     * Gets the lastTransDate value for this CreditMidResult.
     * 
     * @return lastTransDate
     */
    public java.lang.String getLastTransDate() {
        return lastTransDate;
    }


    /**
     * Sets the lastTransDate value for this CreditMidResult.
     * 
     * @param lastTransDate
     */
    public void setLastTransDate(java.lang.String lastTransDate) {
        this.lastTransDate = lastTransDate;
    }


    /**
     * Gets the stableS value for this CreditMidResult.
     * 
     * @return stableS
     */
    public java.lang.String getStableS() {
        return stableS;
    }


    /**
     * Sets the stableS value for this CreditMidResult.
     * 
     * @param stableS
     */
    public void setStableS(java.lang.String stableS) {
        this.stableS = stableS;
    }


    /**
     * Gets the growthG value for this CreditMidResult.
     * 
     * @return growthG
     */
    public java.lang.String getGrowthG() {
        return growthG;
    }


    /**
     * Sets the growthG value for this CreditMidResult.
     * 
     * @param growthG
     */
    public void setGrowthG(java.lang.String growthG) {
        this.growthG = growthG;
    }


    /**
     * Gets the recencyRdays value for this CreditMidResult.
     * 
     * @return recencyRdays
     */
    public java.lang.String getRecencyRdays() {
        return recencyRdays;
    }


    /**
     * Sets the recencyRdays value for this CreditMidResult.
     * 
     * @param recencyRdays
     */
    public void setRecencyRdays(java.lang.String recencyRdays) {
        this.recencyRdays = recencyRdays;
    }


    /**
     * Gets the recencyR value for this CreditMidResult.
     * 
     * @return recencyR
     */
    public java.lang.String getRecencyR() {
        return recencyR;
    }


    /**
     * Sets the recencyR value for this CreditMidResult.
     * 
     * @param recencyR
     */
    public void setRecencyR(java.lang.String recencyR) {
        this.recencyR = recencyR;
    }


    /**
     * Gets the averageA value for this CreditMidResult.
     * 
     * @return averageA
     */
    public java.lang.String getAverageA() {
        return averageA;
    }


    /**
     * Sets the averageA value for this CreditMidResult.
     * 
     * @param averageA
     */
    public void setAverageA(java.lang.String averageA) {
        this.averageA = averageA;
    }


    /**
     * Gets the frequencyF value for this CreditMidResult.
     * 
     * @return frequencyF
     */
    public java.lang.String getFrequencyF() {
        return frequencyF;
    }


    /**
     * Sets the frequencyF value for this CreditMidResult.
     * 
     * @param frequencyF
     */
    public void setFrequencyF(java.lang.String frequencyF) {
        this.frequencyF = frequencyF;
    }


    /**
     * Gets the monetaryM value for this CreditMidResult.
     * 
     * @return monetaryM
     */
    public java.lang.String getMonetaryM() {
        return monetaryM;
    }


    /**
     * Sets the monetaryM value for this CreditMidResult.
     * 
     * @param monetaryM
     */
    public void setMonetaryM(java.lang.String monetaryM) {
        this.monetaryM = monetaryM;
    }


    /**
     * Gets the perMonVolumeP value for this CreditMidResult.
     * 
     * @return perMonVolumeP
     */
    public java.lang.String getPerMonVolumeP() {
        return perMonVolumeP;
    }


    /**
     * Sets the perMonVolumeP value for this CreditMidResult.
     * 
     * @param perMonVolumeP
     */
    public void setPerMonVolumeP(java.lang.String perMonVolumeP) {
        this.perMonVolumeP = perMonVolumeP;
    }


    /**
     * Gets the lastMonVolumeL value for this CreditMidResult.
     * 
     * @return lastMonVolumeL
     */
    public java.lang.String getLastMonVolumeL() {
        return lastMonVolumeL;
    }


    /**
     * Sets the lastMonVolumeL value for this CreditMidResult.
     * 
     * @param lastMonVolumeL
     */
    public void setLastMonVolumeL(java.lang.String lastMonVolumeL) {
        this.lastMonVolumeL = lastMonVolumeL;
    }


    /**
     * Gets the busiMonths value for this CreditMidResult.
     * 
     * @return busiMonths
     */
    public java.lang.String getBusiMonths() {
        return busiMonths;
    }


    /**
     * Sets the busiMonths value for this CreditMidResult.
     * 
     * @param busiMonths
     */
    public void setBusiMonths(java.lang.String busiMonths) {
        this.busiMonths = busiMonths;
    }


    /**
     * Gets the contMonths value for this CreditMidResult.
     * 
     * @return contMonths
     */
    public java.lang.String getContMonths() {
        return contMonths;
    }


    /**
     * Sets the contMonths value for this CreditMidResult.
     * 
     * @param contMonths
     */
    public void setContMonths(java.lang.String contMonths) {
        this.contMonths = contMonths;
    }


    /**
     * Gets the creditRating value for this CreditMidResult.
     * 
     * @return creditRating
     */
    public java.lang.String getCreditRating() {
        return creditRating;
    }


    /**
     * Sets the creditRating value for this CreditMidResult.
     * 
     * @param creditRating
     */
    public void setCreditRating(java.lang.String creditRating) {
        this.creditRating = creditRating;
    }


    /**
     * Gets the passFlag value for this CreditMidResult.
     * 
     * @return passFlag
     */
    public java.lang.String getPassFlag() {
        return passFlag;
    }


    /**
     * Sets the passFlag value for this CreditMidResult.
     * 
     * @param passFlag
     */
    public void setPassFlag(java.lang.String passFlag) {
        this.passFlag = passFlag;
    }


    /**
     * Gets the creditScore value for this CreditMidResult.
     * 
     * @return creditScore
     */
    public java.lang.String getCreditScore() {
        return creditScore;
    }


    /**
     * Sets the creditScore value for this CreditMidResult.
     * 
     * @param creditScore
     */
    public void setCreditScore(java.lang.String creditScore) {
        this.creditScore = creditScore;
    }


    /**
     * Gets the creditAmount value for this CreditMidResult.
     * 
     * @return creditAmount
     */
    public java.lang.String getCreditAmount() {
        return creditAmount;
    }


    /**
     * Sets the creditAmount value for this CreditMidResult.
     * 
     * @param creditAmount
     */
    public void setCreditAmount(java.lang.String creditAmount) {
        this.creditAmount = creditAmount;
    }


    /**
     * Gets the monthStat value for this CreditMidResult.
     * 
     * @return monthStat
     */
    public com.cardvalue.cas.service.impl.MidMonthStatistic[] getMonthStat() {
        return monthStat;
    }


    /**
     * Sets the monthStat value for this CreditMidResult.
     * 
     * @param monthStat
     */
    public void setMonthStat(com.cardvalue.cas.service.impl.MidMonthStatistic[] monthStat) {
        this.monthStat = monthStat;
    }

    public com.cardvalue.cas.service.impl.MidMonthStatistic getMonthStat(int i) {
        return this.monthStat[i];
    }

    public void setMonthStat(int i, com.cardvalue.cas.service.impl.MidMonthStatistic _value) {
        this.monthStat[i] = _value;
    }


    /**
     * Gets the verifyTrans value for this CreditMidResult.
     * 
     * @return verifyTrans
     */
    public com.cardvalue.cas.service.impl.MidVerifyTrans[] getVerifyTrans() {
        return verifyTrans;
    }


    /**
     * Sets the verifyTrans value for this CreditMidResult.
     * 
     * @param verifyTrans
     */
    public void setVerifyTrans(com.cardvalue.cas.service.impl.MidVerifyTrans[] verifyTrans) {
        this.verifyTrans = verifyTrans;
    }

    public com.cardvalue.cas.service.impl.MidVerifyTrans getVerifyTrans(int i) {
        return this.verifyTrans[i];
    }

    public void setVerifyTrans(int i, com.cardvalue.cas.service.impl.MidVerifyTrans _value) {
        this.verifyTrans[i] = _value;
    }


    /**
     * Gets the cardStat value for this CreditMidResult.
     * 
     * @return cardStat
     */
    public com.cardvalue.cas.service.impl.MidCardsStatistic[] getCardStat() {
        return cardStat;
    }


    /**
     * Sets the cardStat value for this CreditMidResult.
     * 
     * @param cardStat
     */
    public void setCardStat(com.cardvalue.cas.service.impl.MidCardsStatistic[] cardStat) {
        this.cardStat = cardStat;
    }

    public com.cardvalue.cas.service.impl.MidCardsStatistic getCardStat(int i) {
        return this.cardStat[i];
    }

    public void setCardStat(int i, com.cardvalue.cas.service.impl.MidCardsStatistic _value) {
        this.cardStat[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreditMidResult)) return false;
        CreditMidResult other = (CreditMidResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.businessId==null && other.getBusinessId()==null) || 
             (this.businessId!=null &&
              this.businessId.equals(other.getBusinessId()))) &&
            ((this.mid==null && other.getMid()==null) || 
             (this.mid!=null &&
              this.mid.equals(other.getMid()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.statusInfo==null && other.getStatusInfo()==null) || 
             (this.statusInfo!=null &&
              this.statusInfo.equals(other.getStatusInfo()))) &&
            ((this.corpName==null && other.getCorpName()==null) || 
             (this.corpName!=null &&
              this.corpName.equals(other.getCorpName()))) &&
            ((this.posCount==null && other.getPosCount()==null) || 
             (this.posCount!=null &&
              this.posCount.equals(other.getPosCount()))) &&
            ((this.posIds==null && other.getPosIds()==null) || 
             (this.posIds!=null &&
              this.posIds.equals(other.getPosIds()))) &&
            ((this.mcc==null && other.getMcc()==null) || 
             (this.mcc!=null &&
              this.mcc.equals(other.getMcc()))) &&
            ((this.mccNo==null && other.getMccNo()==null) || 
             (this.mccNo!=null &&
              this.mccNo.equals(other.getMccNo()))) &&
            ((this.city==null && other.getCity()==null) || 
             (this.city!=null &&
              this.city.equals(other.getCity()))) &&
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.borrow==null && other.getBorrow()==null) || 
             (this.borrow!=null &&
              this.borrow.equals(other.getBorrow()))) &&
            ((this.lend==null && other.getLend()==null) || 
             (this.lend!=null &&
              this.lend.equals(other.getLend()))) &&
            ((this.transCount==null && other.getTransCount()==null) || 
             (this.transCount!=null &&
              this.transCount.equals(other.getTransCount()))) &&
            ((this.firstTransDate==null && other.getFirstTransDate()==null) || 
             (this.firstTransDate!=null &&
              this.firstTransDate.equals(other.getFirstTransDate()))) &&
            ((this.lastTransDate==null && other.getLastTransDate()==null) || 
             (this.lastTransDate!=null &&
              this.lastTransDate.equals(other.getLastTransDate()))) &&
            ((this.stableS==null && other.getStableS()==null) || 
             (this.stableS!=null &&
              this.stableS.equals(other.getStableS()))) &&
            ((this.growthG==null && other.getGrowthG()==null) || 
             (this.growthG!=null &&
              this.growthG.equals(other.getGrowthG()))) &&
            ((this.recencyRdays==null && other.getRecencyRdays()==null) || 
             (this.recencyRdays!=null &&
              this.recencyRdays.equals(other.getRecencyRdays()))) &&
            ((this.recencyR==null && other.getRecencyR()==null) || 
             (this.recencyR!=null &&
              this.recencyR.equals(other.getRecencyR()))) &&
            ((this.averageA==null && other.getAverageA()==null) || 
             (this.averageA!=null &&
              this.averageA.equals(other.getAverageA()))) &&
            ((this.frequencyF==null && other.getFrequencyF()==null) || 
             (this.frequencyF!=null &&
              this.frequencyF.equals(other.getFrequencyF()))) &&
            ((this.monetaryM==null && other.getMonetaryM()==null) || 
             (this.monetaryM!=null &&
              this.monetaryM.equals(other.getMonetaryM()))) &&
            ((this.perMonVolumeP==null && other.getPerMonVolumeP()==null) || 
             (this.perMonVolumeP!=null &&
              this.perMonVolumeP.equals(other.getPerMonVolumeP()))) &&
            ((this.lastMonVolumeL==null && other.getLastMonVolumeL()==null) || 
             (this.lastMonVolumeL!=null &&
              this.lastMonVolumeL.equals(other.getLastMonVolumeL()))) &&
            ((this.busiMonths==null && other.getBusiMonths()==null) || 
             (this.busiMonths!=null &&
              this.busiMonths.equals(other.getBusiMonths()))) &&
            ((this.contMonths==null && other.getContMonths()==null) || 
             (this.contMonths!=null &&
              this.contMonths.equals(other.getContMonths()))) &&
            ((this.creditRating==null && other.getCreditRating()==null) || 
             (this.creditRating!=null &&
              this.creditRating.equals(other.getCreditRating()))) &&
            ((this.passFlag==null && other.getPassFlag()==null) || 
             (this.passFlag!=null &&
              this.passFlag.equals(other.getPassFlag()))) &&
            ((this.creditScore==null && other.getCreditScore()==null) || 
             (this.creditScore!=null &&
              this.creditScore.equals(other.getCreditScore()))) &&
            ((this.creditAmount==null && other.getCreditAmount()==null) || 
             (this.creditAmount!=null &&
              this.creditAmount.equals(other.getCreditAmount()))) &&
            ((this.monthStat==null && other.getMonthStat()==null) || 
             (this.monthStat!=null &&
              java.util.Arrays.equals(this.monthStat, other.getMonthStat()))) &&
            ((this.verifyTrans==null && other.getVerifyTrans()==null) || 
             (this.verifyTrans!=null &&
              java.util.Arrays.equals(this.verifyTrans, other.getVerifyTrans()))) &&
            ((this.cardStat==null && other.getCardStat()==null) || 
             (this.cardStat!=null &&
              java.util.Arrays.equals(this.cardStat, other.getCardStat())));
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
        if (getBusinessId() != null) {
            _hashCode += getBusinessId().hashCode();
        }
        if (getMid() != null) {
            _hashCode += getMid().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getStatusInfo() != null) {
            _hashCode += getStatusInfo().hashCode();
        }
        if (getCorpName() != null) {
            _hashCode += getCorpName().hashCode();
        }
        if (getPosCount() != null) {
            _hashCode += getPosCount().hashCode();
        }
        if (getPosIds() != null) {
            _hashCode += getPosIds().hashCode();
        }
        if (getMcc() != null) {
            _hashCode += getMcc().hashCode();
        }
        if (getMccNo() != null) {
            _hashCode += getMccNo().hashCode();
        }
        if (getCity() != null) {
            _hashCode += getCity().hashCode();
        }
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getBorrow() != null) {
            _hashCode += getBorrow().hashCode();
        }
        if (getLend() != null) {
            _hashCode += getLend().hashCode();
        }
        if (getTransCount() != null) {
            _hashCode += getTransCount().hashCode();
        }
        if (getFirstTransDate() != null) {
            _hashCode += getFirstTransDate().hashCode();
        }
        if (getLastTransDate() != null) {
            _hashCode += getLastTransDate().hashCode();
        }
        if (getStableS() != null) {
            _hashCode += getStableS().hashCode();
        }
        if (getGrowthG() != null) {
            _hashCode += getGrowthG().hashCode();
        }
        if (getRecencyRdays() != null) {
            _hashCode += getRecencyRdays().hashCode();
        }
        if (getRecencyR() != null) {
            _hashCode += getRecencyR().hashCode();
        }
        if (getAverageA() != null) {
            _hashCode += getAverageA().hashCode();
        }
        if (getFrequencyF() != null) {
            _hashCode += getFrequencyF().hashCode();
        }
        if (getMonetaryM() != null) {
            _hashCode += getMonetaryM().hashCode();
        }
        if (getPerMonVolumeP() != null) {
            _hashCode += getPerMonVolumeP().hashCode();
        }
        if (getLastMonVolumeL() != null) {
            _hashCode += getLastMonVolumeL().hashCode();
        }
        if (getBusiMonths() != null) {
            _hashCode += getBusiMonths().hashCode();
        }
        if (getContMonths() != null) {
            _hashCode += getContMonths().hashCode();
        }
        if (getCreditRating() != null) {
            _hashCode += getCreditRating().hashCode();
        }
        if (getPassFlag() != null) {
            _hashCode += getPassFlag().hashCode();
        }
        if (getCreditScore() != null) {
            _hashCode += getCreditScore().hashCode();
        }
        if (getCreditAmount() != null) {
            _hashCode += getCreditAmount().hashCode();
        }
        if (getMonthStat() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMonthStat());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMonthStat(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVerifyTrans() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVerifyTrans());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVerifyTrans(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCardStat() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCardStat());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCardStat(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreditMidResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "creditMidResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "businessId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statusInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corpName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corpName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "posCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posIds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "posIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mcc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mcc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mccNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mccNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("city");
        elemField.setXmlName(new javax.xml.namespace.QName("", "city"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("borrow");
        elemField.setXmlName(new javax.xml.namespace.QName("", "borrow"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lend");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lend"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstTransDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "firstTransDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastTransDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastTransDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stableS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stableS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("growthG");
        elemField.setXmlName(new javax.xml.namespace.QName("", "growthG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recencyRdays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recencyRdays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recencyR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recencyR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("averageA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "averageA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("frequencyF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "frequencyF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monetaryM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "monetaryM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perMonVolumeP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perMonVolumeP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastMonVolumeL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastMonVolumeL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("busiMonths");
        elemField.setXmlName(new javax.xml.namespace.QName("", "busiMonths"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contMonths");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contMonths"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditRating");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditRating"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "passFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditScore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditScore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monthStat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "monthStat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "midMonthStatistic"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verifyTrans");
        elemField.setXmlName(new javax.xml.namespace.QName("", "verifyTrans"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "midVerifyTrans"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardStat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cardStat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "midCardsStatistic"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
