/**
 * CrmService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.www;

public interface CrmService extends javax.xml.rpc.Service {
    public java.lang.String getcrmServicePortAddress();

    public cn.cardvalue.www.CrmServicePortType getcrmServicePort() throws javax.xml.rpc.ServiceException;

    public cn.cardvalue.www.CrmServicePortType getcrmServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
