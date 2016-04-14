/**
 * SoapListBillRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.crm;

public class SoapListBillRequest  implements java.io.Serializable {
    private String channel;

    private String clientSecret;

    private String app_id;

    public SoapListBillRequest() {
    }

    public SoapListBillRequest(
           String channel,
           String clientSecret,
           String app_id) {
           this.channel = channel;
           this.clientSecret = clientSecret;
           this.app_id = app_id;
    }


    /**
     * Gets the channel value for this SoapListBillRequest.
     *
     * @return channel
     */
    public String getChannel() {
        return channel;
    }


    /**
     * Sets the channel value for this SoapListBillRequest.
     *
     * @param channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }


    /**
     * Gets the clientSecret value for this SoapListBillRequest.
     *
     * @return clientSecret
     */
    public String getClientSecret() {
        return clientSecret;
    }


    /**
     * Sets the clientSecret value for this SoapListBillRequest.
     *
     * @param clientSecret
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }


    /**
     * Gets the app_id value for this SoapListBillRequest.
     *
     * @return app_id
     */
    public String getApp_id() {
        return app_id;
    }


    /**
     * Sets the app_id value for this SoapListBillRequest.
     *
     * @param app_id
     */
    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SoapListBillRequest)) return false;
        SoapListBillRequest other = (SoapListBillRequest) obj;
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
              this.app_id.equals(other.getApp_id())));
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapListBillRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapListBillRequest"));
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
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
