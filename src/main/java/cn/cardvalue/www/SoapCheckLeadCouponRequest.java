/**
 * SoapCheckLeadCouponRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.www;

public class SoapCheckLeadCouponRequest  implements java.io.Serializable {
    private java.lang.String list_id;

    private java.lang.String clientSecret;

    private java.lang.String MID;

    public SoapCheckLeadCouponRequest() {
    }

    public SoapCheckLeadCouponRequest(
           java.lang.String list_id,
           java.lang.String clientSecret,
           java.lang.String MID) {
           this.list_id = list_id;
           this.clientSecret = clientSecret;
           this.MID = MID;
    }


    /**
     * Gets the list_id value for this SoapCheckLeadCouponRequest.
     * 
     * @return list_id
     */
    public java.lang.String getList_id() {
        return list_id;
    }


    /**
     * Sets the list_id value for this SoapCheckLeadCouponRequest.
     * 
     * @param list_id
     */
    public void setList_id(java.lang.String list_id) {
        this.list_id = list_id;
    }


    /**
     * Gets the clientSecret value for this SoapCheckLeadCouponRequest.
     * 
     * @return clientSecret
     */
    public java.lang.String getClientSecret() {
        return clientSecret;
    }


    /**
     * Sets the clientSecret value for this SoapCheckLeadCouponRequest.
     * 
     * @param clientSecret
     */
    public void setClientSecret(java.lang.String clientSecret) {
        this.clientSecret = clientSecret;
    }


    /**
     * Gets the MID value for this SoapCheckLeadCouponRequest.
     * 
     * @return MID
     */
    public java.lang.String getMID() {
        return MID;
    }


    /**
     * Sets the MID value for this SoapCheckLeadCouponRequest.
     * 
     * @param MID
     */
    public void setMID(java.lang.String MID) {
        this.MID = MID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SoapCheckLeadCouponRequest)) return false;
        SoapCheckLeadCouponRequest other = (SoapCheckLeadCouponRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.list_id==null && other.getList_id()==null) || 
             (this.list_id!=null &&
              this.list_id.equals(other.getList_id()))) &&
            ((this.clientSecret==null && other.getClientSecret()==null) || 
             (this.clientSecret!=null &&
              this.clientSecret.equals(other.getClientSecret()))) &&
            ((this.MID==null && other.getMID()==null) || 
             (this.MID!=null &&
              this.MID.equals(other.getMID())));
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
        if (getList_id() != null) {
            _hashCode += getList_id().hashCode();
        }
        if (getClientSecret() != null) {
            _hashCode += getClientSecret().hashCode();
        }
        if (getMID() != null) {
            _hashCode += getMID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapCheckLeadCouponRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapCheckLeadCouponRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("list_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "list_id"));
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
        elemField.setFieldName("MID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MID"));
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
