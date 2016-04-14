/**
 * SoapAddDocRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.crm;

public class SoapAddDocRequest  implements java.io.Serializable {
    private String channel;

    private String clientSecret;

    private String app_id;

    private String category;

    private String name;

    private String url;

    public SoapAddDocRequest() {
    }

    public SoapAddDocRequest(
           String channel,
           String clientSecret,
           String app_id,
           String category,
           String name,
           String url) {
           this.channel = channel;
           this.clientSecret = clientSecret;
           this.app_id = app_id;
           this.category = category;
           this.name = name;
           this.url = url;
    }


    /**
     * Gets the channel value for this SoapAddDocRequest.
     *
     * @return channel
     */
    public String getChannel() {
        return channel;
    }


    /**
     * Sets the channel value for this SoapAddDocRequest.
     *
     * @param channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }


    /**
     * Gets the clientSecret value for this SoapAddDocRequest.
     *
     * @return clientSecret
     */
    public String getClientSecret() {
        return clientSecret;
    }


    /**
     * Sets the clientSecret value for this SoapAddDocRequest.
     *
     * @param clientSecret
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }


    /**
     * Gets the app_id value for this SoapAddDocRequest.
     *
     * @return app_id
     */
    public String getApp_id() {
        return app_id;
    }


    /**
     * Sets the app_id value for this SoapAddDocRequest.
     *
     * @param app_id
     */
    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }


    /**
     * Gets the category value for this SoapAddDocRequest.
     *
     * @return category
     */
    public String getCategory() {
        return category;
    }


    /**
     * Sets the category value for this SoapAddDocRequest.
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }


    /**
     * Gets the name value for this SoapAddDocRequest.
     *
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name value for this SoapAddDocRequest.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets the url value for this SoapAddDocRequest.
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this SoapAddDocRequest.
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SoapAddDocRequest)) return false;
        SoapAddDocRequest other = (SoapAddDocRequest) obj;
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
            ((this.category==null && other.getCategory()==null) ||
             (this.category!=null &&
              this.category.equals(other.getCategory()))) &&
            ((this.name==null && other.getName()==null) ||
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.url==null && other.getUrl()==null) ||
             (this.url!=null &&
              this.url.equals(other.getUrl())));
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
        if (getCategory() != null) {
            _hashCode += getCategory().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapAddDocRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://crm.cardvalue.cn/", "soapAddDocRequest"));
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
        elemField.setFieldName("category");
        elemField.setXmlName(new javax.xml.namespace.QName("", "category"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
