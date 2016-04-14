/**
 * ValidateUserRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.crm;

public class ValidateUserRequest  implements java.io.Serializable {
    private String channel;

    private String clientSecret;

    private String identify;

    private String passwordInMD5;

    public ValidateUserRequest() {
    }

    public ValidateUserRequest(
           String channel,
           String clientSecret,
           String identify,
           String passwordInMD5) {
           this.channel = channel;
           this.clientSecret = clientSecret;
           this.identify = identify;
           this.passwordInMD5 = passwordInMD5;
    }


    /**
     * Gets the channel value for this ValidateUserRequest.
     *
     * @return channel
     */
    public String getChannel() {
        return channel;
    }


    /**
     * Sets the channel value for this ValidateUserRequest.
     *
     * @param channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }


    /**
     * Gets the clientSecret value for this ValidateUserRequest.
     *
     * @return clientSecret
     */
    public String getClientSecret() {
        return clientSecret;
    }


    /**
     * Sets the clientSecret value for this ValidateUserRequest.
     *
     * @param clientSecret
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }


    /**
     * Gets the identify value for this ValidateUserRequest.
     *
     * @return identify
     */
    public String getIdentify() {
        return identify;
    }


    /**
     * Sets the identify value for this ValidateUserRequest.
     *
     * @param identify
     */
    public void setIdentify(String identify) {
        this.identify = identify;
    }


    /**
     * Gets the passwordInMD5 value for this ValidateUserRequest.
     *
     * @return passwordInMD5
     */
    public String getPasswordInMD5() {
        return passwordInMD5;
    }


    /**
     * Sets the passwordInMD5 value for this ValidateUserRequest.
     *
     * @param passwordInMD5
     */
    public void setPasswordInMD5(String passwordInMD5) {
        this.passwordInMD5 = passwordInMD5;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ValidateUserRequest)) return false;
        ValidateUserRequest other = (ValidateUserRequest) obj;
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
            ((this.identify==null && other.getIdentify()==null) ||
             (this.identify!=null &&
              this.identify.equals(other.getIdentify()))) &&
            ((this.passwordInMD5==null && other.getPasswordInMD5()==null) ||
             (this.passwordInMD5!=null &&
              this.passwordInMD5.equals(other.getPasswordInMD5())));
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
        if (getIdentify() != null) {
            _hashCode += getIdentify().hashCode();
        }
        if (getPasswordInMD5() != null) {
            _hashCode += getPasswordInMD5().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ValidateUserRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "validateUserRequest"));
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
        elemField.setFieldName("identify");
        elemField.setXmlName(new javax.xml.namespace.QName("", "identify"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passwordInMD5");
        elemField.setXmlName(new javax.xml.namespace.QName("", "passwordInMD5"));
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
