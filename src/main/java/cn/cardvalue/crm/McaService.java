/**
 * McaService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.crm;

public interface McaService extends javax.xml.rpc.Service {
    public String getMcaServicePortAddress();

    public cn.cardvalue.crm.McaServicePortType getMcaServicePort() throws javax.xml.rpc.ServiceException;

    public cn.cardvalue.crm.McaServicePortType getMcaServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
