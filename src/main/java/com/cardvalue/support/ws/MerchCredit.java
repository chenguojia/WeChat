/**
 * MerchCredit.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.support.ws;

public class MerchCredit  implements java.io.Serializable {
    private java.lang.String city;

    private java.math.BigDecimal creditLine;

    private java.lang.String merNo;

    private java.lang.String merchName;

    public MerchCredit() {
    }

    public MerchCredit(
           java.lang.String city,
           java.math.BigDecimal creditLine,
           java.lang.String merNo,
           java.lang.String merchName) {
           this.city = city;
           this.creditLine = creditLine;
           this.merNo = merNo;
           this.merchName = merchName;
    }


    /**
     * Gets the city value for this MerchCredit.
     * 
     * @return city
     */
    public java.lang.String getCity() {
        return city;
    }


    /**
     * Sets the city value for this MerchCredit.
     * 
     * @param city
     */
    public void setCity(java.lang.String city) {
        this.city = city;
    }


    /**
     * Gets the creditLine value for this MerchCredit.
     * 
     * @return creditLine
     */
    public java.math.BigDecimal getCreditLine() {
        return creditLine;
    }


    /**
     * Sets the creditLine value for this MerchCredit.
     * 
     * @param creditLine
     */
    public void setCreditLine(java.math.BigDecimal creditLine) {
        this.creditLine = creditLine;
    }


    /**
     * Gets the merNo value for this MerchCredit.
     * 
     * @return merNo
     */
    public java.lang.String getMerNo() {
        return merNo;
    }


    /**
     * Sets the merNo value for this MerchCredit.
     * 
     * @param merNo
     */
    public void setMerNo(java.lang.String merNo) {
        this.merNo = merNo;
    }


    /**
     * Gets the merchName value for this MerchCredit.
     * 
     * @return merchName
     */
    public java.lang.String getMerchName() {
        return merchName;
    }


    /**
     * Sets the merchName value for this MerchCredit.
     * 
     * @param merchName
     */
    public void setMerchName(java.lang.String merchName) {
        this.merchName = merchName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MerchCredit)) return false;
        MerchCredit other = (MerchCredit) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.city==null && other.getCity()==null) || 
             (this.city!=null &&
              this.city.equals(other.getCity()))) &&
            ((this.creditLine==null && other.getCreditLine()==null) || 
             (this.creditLine!=null &&
              this.creditLine.equals(other.getCreditLine()))) &&
            ((this.merNo==null && other.getMerNo()==null) || 
             (this.merNo!=null &&
              this.merNo.equals(other.getMerNo()))) &&
            ((this.merchName==null && other.getMerchName()==null) || 
             (this.merchName!=null &&
              this.merchName.equals(other.getMerchName())));
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
        if (getCity() != null) {
            _hashCode += getCity().hashCode();
        }
        if (getCreditLine() != null) {
            _hashCode += getCreditLine().hashCode();
        }
        if (getMerNo() != null) {
            _hashCode += getMerNo().hashCode();
        }
        if (getMerchName() != null) {
            _hashCode += getMerchName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MerchCredit.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.support.cardvalue.com/", "merchCredit"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("city");
        elemField.setXmlName(new javax.xml.namespace.QName("", "city"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditLine");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditLine"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "merNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merchName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "merchName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
