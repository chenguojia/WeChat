/**
 * CrmServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.www;

public class CrmServiceLocator extends org.apache.axis.client.Service implements cn.cardvalue.www.CrmService {

    public CrmServiceLocator() {
    }


    public CrmServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CrmServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for crmServicePort
    private java.lang.String crmServicePort_address = "http://192.168.0.208:81/soap/server.php";

    public java.lang.String getcrmServicePortAddress() {
        return crmServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String crmServicePortWSDDServiceName = "crmServicePort";

    public java.lang.String getcrmServicePortWSDDServiceName() {
        return crmServicePortWSDDServiceName;
    }

    public void setcrmServicePortWSDDServiceName(java.lang.String name) {
        crmServicePortWSDDServiceName = name;
    }

    public cn.cardvalue.www.CrmServicePortType getcrmServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(crmServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getcrmServicePort(endpoint);
    }

    public cn.cardvalue.www.CrmServicePortType getcrmServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.cardvalue.www.CrmServiceBindingStub _stub = new cn.cardvalue.www.CrmServiceBindingStub(portAddress, this);
            _stub.setPortName(getcrmServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setcrmServicePortEndpointAddress(java.lang.String address) {
        crmServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.cardvalue.www.CrmServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.cardvalue.www.CrmServiceBindingStub _stub = new cn.cardvalue.www.CrmServiceBindingStub(new java.net.URL(crmServicePort_address), this);
                _stub.setPortName(getcrmServicePortWSDDServiceName());
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
        if ("crmServicePort".equals(inputPortName)) {
            return getcrmServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.cardvalue.cn", "crmService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.cardvalue.cn", "crmServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("crmServicePort".equals(portName)) {
            setcrmServicePortEndpointAddress(address);
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
