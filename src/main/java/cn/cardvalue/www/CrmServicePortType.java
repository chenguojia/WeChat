/**
 * CrmServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.www;

public interface CrmServicePortType extends java.rmi.Remote {
    public cn.cardvalue.www.ArrResponse soapGetUser(cn.cardvalue.www.SoapGetUserRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.www.ArrResponse soapPostUser(cn.cardvalue.www.SoapPostUserRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.www.ArrResponse soapAddUser(cn.cardvalue.www.SoapAddUserRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.www.ArrResponse soapSetPassword(cn.cardvalue.www.SoapSetPasswordRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.www.ArrResponse soapAuthenticate(cn.cardvalue.www.SoapAuthenticateRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.www.ArrResponse soapAddLead(cn.cardvalue.www.SoapAddLeadRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.www.ArrResponse soapPostLead(cn.cardvalue.www.SoapPostLeadRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.www.ArrResponse soapGetLeadsNotes(cn.cardvalue.www.SoapGetLeadsNotesRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.www.ArrResponse soapGetWhiteList(cn.cardvalue.www.SoapGetWhiteListRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.www.ArrResponse soapGetLeadsCategory(cn.cardvalue.www.SoapGetLeadsCategoryRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.www.ArrResponse soapGetLeads(cn.cardvalue.www.SoapGetLeadsRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.www.ArrResponse soapGetActiveLeads(cn.cardvalue.www.SoapGetActiveLeadsRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.www.ArrResponse soapGetAppsCategory(cn.cardvalue.www.SoapGetAppsCategoryRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.www.ArrResponse soapGetApps(cn.cardvalue.www.SoapGetAppsRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.www.ArrResponse soapGetAppStatus(cn.cardvalue.www.SoapGetAppStatusRequest parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.www.ArrResponse soapUpdateTransactionDataByLeadId(cn.cardvalue.www.SoapUpdateTransactionDataByLeadId parameters) throws java.rmi.RemoteException;
    public cn.cardvalue.www.ArrResponse soapAddLeadCoupon(cn.cardvalue.www.SoapAddLeadCouponRequest parameters) throws java.rmi.RemoteException;
}
