/**
 * SoapUpdateStatusRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.www;

public class SoapUpdateStatusRequest  implements java.io.Serializable {
    private java.lang.String channel;

    private java.lang.String clientSecret;

    private java.lang.String app_id;

    private java.lang.String processor;

    private java.lang.String user_id;

    private java.lang.String deal_id;

    private java.lang.String cashadv_id;

    private java.lang.String newStatus;

    public SoapUpdateStatusRequest() {
    }

    public SoapUpdateStatusRequest(
           java.lang.String channel,
           java.lang.String clientSecret,
           java.lang.String app_id,
           java.lang.String processor,
           java.lang.String user_id,
           java.lang.String deal_id,
           java.lang.String cashadv_id,
           java.lang.String newStatus) {
           this.channel = channel;
           this.clientSecret = clientSecret;
           this.app_id = app_id;
           this.processor = processor;
           this.user_id = user_id;
           this.deal_id = deal_id;
           this.cashadv_id = cashadv_id;
           this.newStatus = newStatus;
    }


    /**
     * Gets the channel value for this SoapUpdateStatusRequest.
     * 
     * @return channel
     */
    public java.lang.String getChannel() {
        return channel;
    }


    /**
     * Sets the channel value for this SoapUpdateStatusRequest.
     * 
     * @param channel
     */
    public void setChannel(java.lang.String channel) {
        this.channel = channel;
    }


    /**
     * Gets the clientSecret value for this SoapUpdateStatusRequest.
     * 
     * @return clientSecret
     */
    public java.lang.String getClientSecret() {
        return clientSecret;
    }


    /**
     * Sets the clientSecret value for this SoapUpdateStatusRequest.
     * 
     * @param clientSecret
     */
    public void setClientSecret(java.lang.String clientSecret) {
        this.clientSecret = clientSecret;
    }


    /**
     * Gets the app_id value for this SoapUpdateStatusRequest.
     * 
     * @return app_id
     */
    public java.lang.String getApp_id() {
        return app_id;
    }


    /**
     * Sets the app_id value for this SoapUpdateStatusRequest.
     * 
     * @param app_id
     */
    public void setApp_id(java.lang.String app_id) {
        this.app_id = app_id;
    }


    /**
     * Gets the processor value for this SoapUpdateStatusRequest.
     * 
     * @return processor
     */
    public java.lang.String getProcessor() {
        return processor;
    }


    /**
     * Sets the processor value for this SoapUpdateStatusRequest.
     * 
     * @param processor
     */
    public void setProcessor(java.lang.String processor) {
        this.processor = processor;
    }


    /**
     * Gets the user_id value for this SoapUpdateStatusRequest.
     * 
     * @return user_id
     */
    public java.lang.String getUser_id() {
        return user_id;
    }


    /**
     * Sets the user_id value for this SoapUpdateStatusRequest.
     * 
     * @param user_id
     */
    public void setUser_id(java.lang.String user_id) {
        this.user_id = user_id;
    }


    /**
     * Gets the deal_id value for this SoapUpdateStatusRequest.
     * 
     * @return deal_id
     */
    public java.lang.String getDeal_id() {
        return deal_id;
    }


    /**
     * Sets the deal_id value for this SoapUpdateStatusRequest.
     * 
     * @param deal_id
     */
    public void setDeal_id(java.lang.String deal_id) {
        this.deal_id = deal_id;
    }


    /**
     * Gets the cashadv_id value for this SoapUpdateStatusRequest.
     * 
     * @return cashadv_id
     */
    public java.lang.String getCashadv_id() {
        return cashadv_id;
    }


    /**
     * Sets the cashadv_id value for this SoapUpdateStatusRequest.
     * 
     * @param cashadv_id
     */
    public void setCashadv_id(java.lang.String cashadv_id) {
        this.cashadv_id = cashadv_id;
    }


    /**
     * Gets the newStatus value for this SoapUpdateStatusRequest.
     * 
     * @return newStatus
     */
    public java.lang.String getNewStatus() {
        return newStatus;
    }


    /**
     * Sets the newStatus value for this SoapUpdateStatusRequest.
     * 
     * @param newStatus
     */
    public void setNewStatus(java.lang.String newStatus) {
        this.newStatus = newStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SoapUpdateStatusRequest)) return false;
        SoapUpdateStatusRequest other = (SoapUpdateStatusRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.channel==null && other.getChannel()==null) || 
             (this.channel!=null &&
              this.channel.equals(other.getChannel()))) &&
            ((this.clientSecret==null && other.getClientSecret()==null) || 
             (this.clientSecret!=null &&
              this.clientSecret.equals(other.getClientSecret()))) &&
            ((this.app_id==null && other.getApp_id()==null) || 
             (this.app_id!=null &&
              this.app_id.equals(other.getApp_id()))) &&
            ((this.processor==null && other.getProcessor()==null) || 
             (this.processor!=null &&
              this.processor.equals(other.getProcessor()))) &&
            ((this.user_id==null && other.getUser_id()==null) || 
             (this.user_id!=null &&
              this.user_id.equals(other.getUser_id()))) &&
            ((this.deal_id==null && other.getDeal_id()==null) || 
             (this.deal_id!=null &&
              this.deal_id.equals(other.getDeal_id()))) &&
            ((this.cashadv_id==null && other.getCashadv_id()==null) || 
             (this.cashadv_id!=null &&
              this.cashadv_id.equals(other.getCashadv_id()))) &&
            ((this.newStatus==null && other.getNewStatus()==null) || 
             (this.newStatus!=null &&
              this.newStatus.equals(other.getNewStatus())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getChannel() != null) {
            _hashCode += getChannel().hashCode();
        }
        if (getClientSecret() != null) {
            _hashCode += getClientSecret().hashCode();
        }
        if (getApp_id() != null) {
            _hashCode += getApp_id().hashCode();
        }
        if (getProcessor() != null) {
            _hashCode += getProcessor().hashCode();
        }
        if (getUser_id() != null) {
            _hashCode += getUser_id().hashCode();
        }
        if (getDeal_id() != null) {
            _hashCode += getDeal_id().hashCode();
        }
        if (getCashadv_id() != null) {
            _hashCode += getCashadv_id().hashCode();
        }
        if (getNewStatus() != null) {
            _hashCode += getNewStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapUpdateStatusRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapUpdateStatusRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("channel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "channel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientSecret");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientSecret"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("app_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "app_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "processor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deal_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deal_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cashadv_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cashadv_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "newStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
