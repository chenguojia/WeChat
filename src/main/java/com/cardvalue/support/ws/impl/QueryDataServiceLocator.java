/**
 * QueryDataServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.support.ws.impl;

import com.cardvalue.support.ws.QueryDataDelegate;

public class QueryDataServiceLocator extends org.apache.axis.client.Service implements com.cardvalue.support.ws.impl.QueryDataService {

    public QueryDataServiceLocator() {
    }


    public QueryDataServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public QueryDataServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for QueryDataPort
    private java.lang.String QueryDataPort_address = "http://192.168.0.244:8080/WebServices/QueryDataPort";

    public java.lang.String getQueryDataPortAddress() {
        return QueryDataPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String QueryDataPortWSDDServiceName = "QueryDataPort";

    public java.lang.String getQueryDataPortWSDDServiceName() {
        return QueryDataPortWSDDServiceName;
    }

    public void setQueryDataPortWSDDServiceName(java.lang.String name) {
        QueryDataPortWSDDServiceName = name;
    }

    public com.cardvalue.support.ws.QueryDataDelegate getQueryDataPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(QueryDataPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getQueryDataPort(endpoint);
    }

    public com.cardvalue.support.ws.QueryDataDelegate getQueryDataPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.cardvalue.support.ws.impl.QueryDataPortBindingStub _stub = new com.cardvalue.support.ws.impl.QueryDataPortBindingStub(portAddress, this);
            _stub.setPortName(getQueryDataPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setQueryDataPortEndpointAddress(java.lang.String address) {
        QueryDataPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.cardvalue.support.ws.QueryDataDelegate.class.isAssignableFrom(serviceEndpointInterface)) {
                com.cardvalue.support.ws.impl.QueryDataPortBindingStub _stub = new com.cardvalue.support.ws.impl.QueryDataPortBindingStub(new java.net.URL(QueryDataPort_address), this);
                _stub.setPortName(getQueryDataPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("QueryDataPort".equals(inputPortName)) {
            return getQueryDataPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.fexchange.com/", "QueryDataService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.fexchange.com/", "QueryDataPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("QueryDataPort".equals(portName)) {
            setQueryDataPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
