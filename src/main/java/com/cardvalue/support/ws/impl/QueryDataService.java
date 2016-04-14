/**
 * QueryDataService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.support.ws.impl;

import com.cardvalue.support.ws.QueryDataDelegate;

public interface QueryDataService extends javax.xml.rpc.Service {
    public java.lang.String getQueryDataPortAddress();

    public com.cardvalue.support.ws.QueryDataDelegate getQueryDataPort() throws javax.xml.rpc.ServiceException;

    public com.cardvalue.support.ws.QueryDataDelegate getQueryDataPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
