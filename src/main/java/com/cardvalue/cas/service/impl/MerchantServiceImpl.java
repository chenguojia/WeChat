/**
 * MerchantServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.cas.service.impl;

public interface MerchantServiceImpl extends java.rmi.Remote {
    public com.cardvalue.cas.service.impl.AddMidReturn addMidRequest(java.lang.String applicantId, java.lang.String midList) throws java.rmi.RemoteException;
    public com.cardvalue.cas.service.impl.CreateApplicantReturn createApplicant(java.lang.String channel, java.lang.String creditWay, java.lang.String corpName, java.lang.Boolean checkName, java.lang.String province, java.lang.String plannedAmt, java.lang.String plannedDays) throws java.rmi.RemoteException;
    public com.cardvalue.cas.service.impl.UpdateApplicantReturn updateApplicant(java.lang.String applicantId, java.lang.String channel, java.lang.String creditWay, java.lang.String corpName, java.lang.Boolean checkName, java.lang.String province, java.lang.String plannedAmt, java.lang.String plannedDays) throws java.rmi.RemoteException;
    public com.cardvalue.cas.service.impl.DeleteMidReturn deleteMidRequest(java.lang.String applicantId, java.lang.String midList) throws java.rmi.RemoteException;
    public com.cardvalue.cas.service.impl.AddOpenReturn addOpenRequest(java.lang.String applicantId, java.lang.String businessType, java.lang.String cityName, java.lang.String businessAreaClass, java.lang.String addressType, java.lang.String staffNumClass, java.lang.String educationClass, java.lang.String maritalStatus, java.lang.String hasChildren, java.lang.String localResidence, java.lang.String mccCode, java.lang.String storeProp, java.lang.String regName, java.lang.String bizName, java.lang.String bizScope) throws java.rmi.RemoteException;
    public com.cardvalue.cas.service.impl.DeleteOpenReturn deleteOpenRequest(java.lang.String applicantId) throws java.rmi.RemoteException;
    public com.cardvalue.cas.service.impl.DeleteBusinessReturn deleteBusiness(java.lang.String businessType, java.lang.String businessId) throws java.rmi.RemoteException;
    public com.cardvalue.cas.service.impl.PosCreditCalculateReturn posCreditCalculate(java.lang.String mcc_code, java.lang.String pro_code, java.lang.String recencyR, java.lang.String averageA, java.lang.String frequencyF, java.lang.String monetaryM, java.lang.String perMonVolumeP, java.lang.String lastMonVolumeL, java.lang.String stableS, java.lang.String growthG, java.lang.String monthOfBiz, java.lang.String contMonth) throws java.rmi.RemoteException;
    public com.cardvalue.cas.service.impl.CreditResultReturn creditResult(java.lang.String applicantId) throws java.rmi.RemoteException;
}
