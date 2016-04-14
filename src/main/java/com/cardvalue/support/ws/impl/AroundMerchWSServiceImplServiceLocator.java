/**
 * AroundMerchWSServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.support.ws.impl;

public class AroundMerchWSServiceImplServiceLocator extends org.apache.axis.client.Service implements com.cardvalue.support.ws.impl.AroundMerchWSServiceImplService {

    public AroundMerchWSServiceImplServiceLocator() {
    }


    public AroundMerchWSServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AroundMerchWSServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AroundMerchWSServiceImplPort
    private java.lang.String AroundMerchWSServiceImplPort_address = "http://192.168.0.13:8686/support/services/SearchAroundMerchService";

    public java.lang.String getAroundMerchWSServiceImplPortAddress() {
        return AroundMerchWSServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AroundMerchWSServiceImplPortWSDDServiceName = "AroundMerchWSServiceImplPort";

    public java.lang.String getAroundMerchWSServiceImplPortWSDDServiceName() {
        return AroundMerchWSServiceImplPortWSDDServiceName;
    }

    public void setAroundMerchWSServiceImplPortWSDDServiceName(java.lang.String name) {
        AroundMerchWSServiceImplPortWSDDServiceName = name;
    }

    public com.cardvalue.support.ws.AroundMerchWSService getAroundMerchWSServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AroundMerchWSServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAroundMerchWSServiceImplPort(endpoint);
    }

    public com.cardvalue.support.ws.AroundMerchWSService getAroundMerchWSServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.cardvalue.support.ws.impl.AroundMerchWSServiceImplPortBindingStub _stub = new com.cardvalue.support.ws.impl.AroundMerchWSServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getAroundMerchWSServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAroundMerchWSServiceImplPortEndpointAddress(java.lang.String address) {
        AroundMerchWSServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.cardvalue.support.ws.AroundMerchWSService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.cardvalue.support.ws.impl.AroundMerchWSServiceImplPortBindingStub _stub = new com.cardvalue.support.ws.impl.AroundMerchWSServiceImplPortBindingStub(new java.net.URL(AroundMerchWSServiceImplPort_address), this);
                _stub.setPortName(getAroundMerchWSServiceImplPortWSDDServiceName());
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
        if ("AroundMerchWSServiceImplPort".equals(inputPortName)) {
            return getAroundMerchWSServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.ws.support.cardvalue.com/", "AroundMerchWSServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.ws.support.cardvalue.com/", "AroundMerchWSServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AroundMerchWSServiceImplPort".equals(portName)) {
            setAroundMerchWSServiceImplPortEndpointAddress(address);
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
