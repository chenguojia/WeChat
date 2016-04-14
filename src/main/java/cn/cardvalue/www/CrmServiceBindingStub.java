/**
 * CrmServiceBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.www;

public class CrmServiceBindingStub extends org.apache.axis.client.Stub implements cn.cardvalue.www.CrmServicePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[17];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapGetUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetUserRequest"), cn.cardvalue.www.SoapGetUserRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapPostUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapPostUserRequest"), cn.cardvalue.www.SoapPostUserRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapAddUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapAddUserRequest"), cn.cardvalue.www.SoapAddUserRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapSetPassword");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapSetPasswordRequest"), cn.cardvalue.www.SoapSetPasswordRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapAuthenticate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapAuthenticateRequest"), cn.cardvalue.www.SoapAuthenticateRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapAddLead");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapAddLeadRequest"), cn.cardvalue.www.SoapAddLeadRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapPostLead");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapPostLeadRequest"), cn.cardvalue.www.SoapPostLeadRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapGetLeadsNotes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetLeadsNotesRequest"), cn.cardvalue.www.SoapGetLeadsNotesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapGetWhiteList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetWhiteListRequest"), cn.cardvalue.www.SoapGetWhiteListRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapGetLeadsCategory");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetLeadsCategoryRequest"), cn.cardvalue.www.SoapGetLeadsCategoryRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapGetLeads");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetLeadsRequest"), cn.cardvalue.www.SoapGetLeadsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapGetActiveLeads");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetActiveLeadsRequest"), cn.cardvalue.www.SoapGetActiveLeadsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapGetAppsCategory");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetAppsCategoryRequest"), cn.cardvalue.www.SoapGetAppsCategoryRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapGetApps");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetAppsRequest"), cn.cardvalue.www.SoapGetAppsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapGetAppStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetAppStatusRequest"), cn.cardvalue.www.SoapGetAppStatusRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapUpdateTransactionDataByLeadId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapUpdateTransactionDataByLeadId"), cn.cardvalue.www.SoapUpdateTransactionDataByLeadId.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("soapAddLeadCoupon");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapAddLeadCouponRequest"), cn.cardvalue.www.SoapAddLeadCouponRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse"));
        oper.setReturnClass(cn.cardvalue.www.ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[16] = oper;

    }

    public CrmServiceBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public CrmServiceBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public CrmServiceBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "arrResponse");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.ArrResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapAddLeadCouponRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapAddLeadCouponRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapAddLeadRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapAddLeadRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapAddUserRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapAddUserRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapAuthenticateRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapAuthenticateRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetActiveLeadsRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapGetActiveLeadsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetAppsCategoryRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapGetAppsCategoryRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetAppsRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapGetAppsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetAppStatusRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapGetAppStatusRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetLeadsCategoryRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapGetLeadsCategoryRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetLeadsNotesRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapGetLeadsNotesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetLeadsRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapGetLeadsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetUserRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapGetUserRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetWhiteListRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapGetWhiteListRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapPostLeadRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapPostLeadRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapPostUserRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapPostUserRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapSetPasswordRequest");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapSetPasswordRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapUpdateTransactionDataByLeadId");
            cachedSerQNames.add(qName);
            cls = cn.cardvalue.www.SoapUpdateTransactionDataByLeadId.class;
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
                java.lang.String key = (java.lang.String) keys.nextElement();
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
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
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
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public cn.cardvalue.www.ArrResponse soapGetUser(cn.cardvalue.www.SoapGetUserRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapGetUser");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.www.ArrResponse soapPostUser(cn.cardvalue.www.SoapPostUserRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapPostUser");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapPostUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.www.ArrResponse soapAddUser(cn.cardvalue.www.SoapAddUserRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapAddUser");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapAddUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.www.ArrResponse soapSetPassword(cn.cardvalue.www.SoapSetPasswordRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapSetPassword");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapSetPassword"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.www.ArrResponse soapAuthenticate(cn.cardvalue.www.SoapAuthenticateRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapAuthenticate");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapAuthenticate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.www.ArrResponse soapAddLead(cn.cardvalue.www.SoapAddLeadRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapAddLead");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapAddLead"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.www.ArrResponse soapPostLead(cn.cardvalue.www.SoapPostLeadRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapPostLead");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapPostLead"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.www.ArrResponse soapGetLeadsNotes(cn.cardvalue.www.SoapGetLeadsNotesRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapGetLeadsNotes");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetLeadsNotes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.www.ArrResponse soapGetWhiteList(cn.cardvalue.www.SoapGetWhiteListRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapGetWhiteList");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetWhiteList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.www.ArrResponse soapGetLeadsCategory(cn.cardvalue.www.SoapGetLeadsCategoryRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapGetLeadsCategory");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetLeadsCategory"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.www.ArrResponse soapGetLeads(cn.cardvalue.www.SoapGetLeadsRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapGetLeads");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetLeads"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.www.ArrResponse soapGetActiveLeads(cn.cardvalue.www.SoapGetActiveLeadsRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapGetActiveLeads");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetActiveLeads"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.www.ArrResponse soapGetAppsCategory(cn.cardvalue.www.SoapGetAppsCategoryRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapGetAppsCategory");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetAppsCategory"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.www.ArrResponse soapGetApps(cn.cardvalue.www.SoapGetAppsRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapGetApps");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetApps"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.www.ArrResponse soapGetAppStatus(cn.cardvalue.www.SoapGetAppStatusRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapGetAppStatus");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetAppStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.www.ArrResponse soapUpdateTransactionDataByLeadId(cn.cardvalue.www.SoapUpdateTransactionDataByLeadId parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapUpdateTransactionDataByLeadId");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapUpdateTransactionDataByLeadId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.cardvalue.www.ArrResponse soapAddLeadCoupon(cn.cardvalue.www.SoapAddLeadCouponRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.208/soap/server.php/soapAddLeadCoupon");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapAddLeadCoupon"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.cardvalue.www.ArrResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.cardvalue.www.ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.cardvalue.www.ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
