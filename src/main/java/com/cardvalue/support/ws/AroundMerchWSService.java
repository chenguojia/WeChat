/**
 * AroundMerchWSService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.support.ws;

public interface AroundMerchWSService extends java.rmi.Remote {
    public com.cardvalue.support.ws.AroundMerch[] getAroundMerchInfo(com.cardvalue.support.ws.WsSearchAroundMerchRequest request, com.cardvalue.support.ws.SingleSort[] sorts) throws java.rmi.RemoteException;
    public int getAroundMerchCount(double lat, double lng, int range, java.lang.String pId) throws java.rmi.RemoteException;
    public com.cardvalue.support.ws.MerchCredit[] getMerchLmtInfoByMerNo(java.lang.String merNo, java.lang.String pId) throws java.rmi.RemoteException;
}
