/**
 * McaServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.crm;

public interface McaServicePortType extends java.rmi.Remote {
    public cn.cardvalue.crm.ArrResponse soapValidateUser(cn.cardvalue.crm.ValidateUserRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.crm.ArrResponse soapUpdateApp(cn.cardvalue.crm.SoapUpdateAppRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.crm.ArrResponse soapGetApp(cn.cardvalue.crm.SoapGetAppRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.crm.ArrResponse soapListMca(cn.cardvalue.crm.SoapListMcaRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.crm.ArrResponse soapUpdateStatus(cn.cardvalue.crm.SoapUpdateStatusRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.crm.ArrResponse soapRenewMca(cn.cardvalue.crm.SoapRenewMcaRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.crm.ArrResponse soapAddApp(cn.cardvalue.crm.SoapAddAppRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.crm.ArrResponse soapAddDoc(cn.cardvalue.crm.SoapAddDocRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.crm.ArrResponse soapListBill(cn.cardvalue.crm.SoapListBillRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.crm.ArrResponse soapGetOauthToken(cn.cardvalue.crm.GetOauthTokenRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.crm.ArrResponse soapListStatistics(cn.cardvalue.crm.SoapListStatisticsRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.crm.ArrResponse soapAddAppWechat(cn.cardvalue.crm.SoapAddAppWechatRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.crm.ArrResponse soapCheckExistingApp(cn.cardvalue.crm.SoapCheckExistingAppRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.crm.ArrResponse soapListCreditFileStatus(cn.cardvalue.crm.SoapListCreditFileStatusRequest parameters) throws java.rmi.RemoteException;
}
