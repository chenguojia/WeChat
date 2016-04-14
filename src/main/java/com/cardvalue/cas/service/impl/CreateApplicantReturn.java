/**
 * CreateApplicantReturn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.cas.service.impl;

public class CreateApplicantReturn  implements java.io.Serializable {
    private java.lang.Integer applicantId;

    private java.lang.String resCode;

    private java.lang.String resMsg;

    public CreateApplicantReturn() {
    }

    public CreateApplicantReturn(
           java.lang.Integer applicantId,
           java.lang.String resCode,
           java.lang.String resMsg) {
           this.applicantId = applicantId;
           this.resCode = resCode;
           this.resMsg = resMsg;
    }


    /**
     * Gets the applicantId value for this CreateApplicantReturn.
     * 
     * @return applicantId
     */
    public java.lang.Integer getApplicantId() {
        return applicantId;
    }


    /**
     * Sets the applicantId value for this CreateApplicantReturn.
     * 
     * @param applicantId
     */
    public void setApplicantId(java.lang.Integer applicantId) {
        this.applicantId = applicantId;
    }


    /**
     * Gets the resCode value for this CreateApplicantReturn.
     * 
     * @return resCode
     */
    public java.lang.String getResCode() {
        return resCode;
    }


    /**
     * Sets the resCode value for this CreateApplicantReturn.
     * 
     * @param resCode
     */
    public void setResCode(java.lang.String resCode) {
        this.resCode = resCode;
    }


    /**
     * Gets the resMsg value for this CreateApplicantReturn.
     * 
     * @return resMsg
     */
    public java.lang.String getResMsg() {
        return resMsg;
    }


    /**
     * Sets the resMsg value for this CreateApplicantReturn.
     * 
     * @param resMsg
     */
    public void setResMsg(java.lang.String resMsg) {
        this.resMsg = resMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateApplicantReturn)) return false;
        CreateApplicantReturn other = (CreateApplicantReturn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.applicantId==null && other.getApplicantId()==null) || 
             (this.applicantId!=null &&
              this.applicantId.equals(other.getApplicantId()))) &&
            ((this.resCode==null && other.getResCode()==null) || 
             (this.resCode!=null &&
              this.resCode.equals(other.getResCode()))) &&
            ((this.resMsg==null && other.getResMsg()==null) || 
             (this.resMsg!=null &&
              this.resMsg.equals(other.getResMsg())));
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
        if (getApplicantId() != null) {
            _hashCode += getApplicantId().hashCode();
        }
        if (getResCode() != null) {
            _hashCode += getResCode().hashCode();
        }
        if (getResMsg() != null) {
            _hashCode += getResMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreateApplicantReturn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "createApplicantReturn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicantId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applicantId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resMsg"));
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
