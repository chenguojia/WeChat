/**
 * McaServiceBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.crm;

public class McaServiceBindingStub extends org.apache.axis.client.Stub implements cn.cardvalue.crm.McaServicePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[14];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapValidateUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "validateUserRequest"), cn.cardvalue.crm.ValidateUserRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.crm.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapUpdateApp");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapUpdateAppRequest"), cn.cardvalue.crm.SoapUpdateAppRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.crm.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapGetApp");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapGetAppRequest"), cn.cardvalue.crm.SoapGetAppRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.crm.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapListMca");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapListMcaRequest"), cn.cardvalue.crm.SoapListMcaRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.crm.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapUpdateStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapUpdateStatusRequest"), cn.cardvalue.crm.SoapUpdateStatusRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.crm.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapRenewMca");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapRenewMcaRequest"), cn.cardvalue.crm.SoapRenewMcaRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.crm.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapAddApp");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapAddAppRequest"), cn.cardvalue.crm.SoapAddAppRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.crm.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapAddDoc");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapAddDocRequest"), cn.cardvalue.crm.SoapAddDocRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.crm.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapListBill");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapListBillRequest"), cn.cardvalue.crm.SoapListBillRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.crm.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapGetOauthToken");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "getOauthTokenRequest"), cn.cardvalue.crm.GetOauthTokenRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.crm.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapListStatistics");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapListStatisticsRequest"), cn.cardvalue.crm.SoapListStatisticsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.crm.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapAddAppWechat");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapAddAppWechatRequest"), cn.cardvalue.crm.SoapAddAppWechatRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.crm.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapCheckExistingApp");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapCheckExistingAppRequest"), cn.cardvalue.crm.SoapCheckExistingAppRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.crm.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapListCreditFileStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapListCreditFileStatusRequest"), cn.cardvalue.crm.SoapListCreditFileStatusRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.crm.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[13] = oper;

    }

    public McaServiceBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public McaServiceBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public McaServiceBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "arrResponse");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.crm.ArrResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "getOauthTokenRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.crm.GetOauthTokenRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapAddAppRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.crm.SoapAddAppRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapAddAppWechatRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.crm.SoapAddAppWechatRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapAddDocRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.crm.SoapAddDocRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapCheckExistingAppRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.crm.SoapCheckExistingAppRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapGetAppRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.crm.SoapGetAppRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapListBillRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.crm.SoapListBillRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapListCreditFileStatusRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.crm.SoapListCreditFileStatusRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapListMcaRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.crm.SoapListMcaRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapListStatisticsRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.crm.SoapListStatisticsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapRenewMcaRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.crm.SoapRenewMcaRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapUpdateAppRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.crm.SoapUpdateAppRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapUpdateStatusRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.crm.SoapUpdateStatusRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "validateUserRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.crm.ValidateUserRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        Class cls = (Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            Class sf = (Class)
                                 cachedSerFactories.get(i);
                            Class df = (Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public cn.cardvalue.crm.ArrResponse soapValidateUser(cn.cardvalue.crm.ValidateUserRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/McaService.php/soapValidateUser");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapValidateUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.crm.ArrResponse) _resp;
            } catch (Exception _exception) {
                return (cn.cardvalue.crm.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.crm.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.crm.ArrResponse soapUpdateApp(cn.cardvalue.crm.SoapUpdateAppRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/McaService.php/soapUpdateApp");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapUpdateApp"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.crm.ArrResponse) _resp;
            } catch (Exception _exception) {
                return (cn.cardvalue.crm.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.crm.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.crm.ArrResponse soapGetApp(cn.cardvalue.crm.SoapGetAppRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/McaService.php/soapGetApp");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetApp"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.crm.ArrResponse) _resp;
            } catch (Exception _exception) {
                return (cn.cardvalue.crm.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.crm.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.crm.ArrResponse soapListMca(cn.cardvalue.crm.SoapListMcaRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/McaService.php/soapListMca");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapListMca"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.crm.ArrResponse) _resp;
            } catch (Exception _exception) {
                return (cn.cardvalue.crm.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.crm.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.crm.ArrResponse soapUpdateStatus(cn.cardvalue.crm.SoapUpdateStatusRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/McaService.php/soapUpdateStatus");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapUpdateStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.crm.ArrResponse) _resp;
            } catch (Exception _exception) {
                return (cn.cardvalue.crm.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.crm.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.crm.ArrResponse soapRenewMca(cn.cardvalue.crm.SoapRenewMcaRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/McaService.php/soapRenewMca");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapRenewMca"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.crm.ArrResponse) _resp;
            } catch (Exception _exception) {
                return (cn.cardvalue.crm.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.crm.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.crm.ArrResponse soapAddApp(cn.cardvalue.crm.SoapAddAppRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/McaService.php/soapAddApp");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapAddApp"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.crm.ArrResponse) _resp;
            } catch (Exception _exception) {
                return (cn.cardvalue.crm.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.crm.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.crm.ArrResponse soapAddDoc(cn.cardvalue.crm.SoapAddDocRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/McaService.php/soapAddDoc");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapAddDoc"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.crm.ArrResponse) _resp;
            } catch (Exception _exception) {
                return (cn.cardvalue.crm.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.crm.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.crm.ArrResponse soapListBill(cn.cardvalue.crm.SoapListBillRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/McaService.php/soapListBill");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapListBill"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.crm.ArrResponse) _resp;
            } catch (Exception _exception) {
                return (cn.cardvalue.crm.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.crm.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.crm.ArrResponse soapGetOauthToken(cn.cardvalue.crm.GetOauthTokenRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/McaService.php/soapGetOauthToken");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapGetOauthToken"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.crm.ArrResponse) _resp;
            } catch (Exception _exception) {
                return (cn.cardvalue.crm.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.crm.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.crm.ArrResponse soapListStatistics(cn.cardvalue.crm.SoapListStatisticsRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/McaService.php/soapListStatistics");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapListStatistics"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.crm.ArrResponse) _resp;
            } catch (Exception _exception) {
                return (cn.cardvalue.crm.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.crm.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.crm.ArrResponse soapAddAppWechat(cn.cardvalue.crm.SoapAddAppWechatRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/McaService.php/soapAddAppWechat");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapAddAppWechat"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.crm.ArrResponse) _resp;
            } catch (Exception _exception) {
                return (cn.cardvalue.crm.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.crm.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.crm.ArrResponse soapCheckExistingApp(cn.cardvalue.crm.SoapCheckExistingAppRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/McaService.php/soapCheckExistingApp");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapCheckExistingApp"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.crm.ArrResponse) _resp;
            } catch (Exception _exception) {
                return (cn.cardvalue.crm.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.crm.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.crm.ArrResponse soapListCreditFileStatus(cn.cardvalue.crm.SoapListCreditFileStatusRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/McaService.php/soapListCreditFileStatus");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapListCreditFileStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.crm.ArrResponse) _resp;
            } catch (Exception _exception) {
                return (cn.cardvalue.crm.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.crm.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
