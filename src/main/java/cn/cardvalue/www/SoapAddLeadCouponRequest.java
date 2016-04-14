/**
 * SoapAddLeadCouponRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.www;

public class SoapAddLeadCouponRequest  implements java.io.Serializable {
    private java.lang.String list_id;

    private java.lang.String clientSecret;

    private java.lang.String lead_id;

    private java.lang.String couponNumber;

    private java.lang.String couponType;

    private java.lang.String couponAmt;

    private java.lang.String memo;

    public SoapAddLeadCouponRequest() {
    }

    public SoapAddLeadCouponRequest(
           java.lang.String list_id,
           java.lang.String clientSecret,
           java.lang.String lead_id,
           java.lang.String couponNumber,
           java.lang.String couponType,
           java.lang.String couponAmt,
           java.lang.String memo) {
           this.list_id = list_id;
           this.clientSecret = clientSecret;
           this.lead_id = lead_id;
           this.couponNumber = couponNumber;
           this.couponType = couponType;
           this.couponAmt = couponAmt;
           this.memo = memo;
    }


    /**
     * Gets the list_id value for this SoapAddLeadCouponRequest.
     * 
     * @return list_id
     */
    public java.lang.String getList_id() {
        return list_id;
    }


    /**
     * Sets the list_id value for this SoapAddLeadCouponRequest.
     * 
     * @param list_id
     */
    public void setList_id(java.lang.String list_id) {
        this.list_id = list_id;
    }


    /**
     * Gets the clientSecret value for this SoapAddLeadCouponRequest.
     * 
     * @return clientSecret
     */
    public java.lang.String getClientSecret() {
        return clientSecret;
    }


    /**
     * Sets the clientSecret value for this SoapAddLeadCouponRequest.
     * 
     * @param clientSecret
     */
    public void setClientSecret(java.lang.String clientSecret) {
        this.clientSecret = clientSecret;
    }


    /**
     * Gets the lead_id value for this SoapAddLeadCouponRequest.
     * 
     * @return lead_id
     */
    public java.lang.String getLead_id() {
        return lead_id;
    }


    /**
     * Sets the lead_id value for this SoapAddLeadCouponRequest.
     * 
     * @param lead_id
     */
    public void setLead_id(java.lang.String lead_id) {
        this.lead_id = lead_id;
    }


    /**
     * Gets the couponNumber value for this SoapAddLeadCouponRequest.
     * 
     * @return couponNumber
     */
    public java.lang.String getCouponNumber() {
        return couponNumber;
    }


    /**
     * Sets the couponNumber value for this SoapAddLeadCouponRequest.
     * 
     * @param couponNumber
     */
    public void setCouponNumber(java.lang.String couponNumber) {
        this.couponNumber = couponNumber;
    }


    /**
     * Gets the couponType value for this SoapAddLeadCouponRequest.
     * 
     * @return couponType
     */
    public java.lang.String getCouponType() {
        return couponType;
    }


    /**
     * Sets the couponType value for this SoapAddLeadCouponRequest.
     * 
     * @param couponType
     */
    public void setCouponType(java.lang.String couponType) {
        this.couponType = couponType;
    }


    /**
     * Gets the couponAmt value for this SoapAddLeadCouponRequest.
     * 
     * @return couponAmt
     */
    public java.lang.String getCouponAmt() {
        return couponAmt;
    }


    /**
     * Sets the couponAmt value for this SoapAddLeadCouponRequest.
     * 
     * @param couponAmt
     */
    public void setCouponAmt(java.lang.String couponAmt) {
        this.couponAmt = couponAmt;
    }


    /**
     * Gets the memo value for this SoapAddLeadCouponRequest.
     * 
     * @return memo
     */
    public java.lang.String getMemo() {
        return memo;
    }


    /**
     * Sets the memo value for this SoapAddLeadCouponRequest.
     * 
     * @param memo
     */
    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SoapAddLeadCouponRequest)) return false;
        SoapAddLeadCouponRequest other = (SoapAddLeadCouponRequest) obj;
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
            ((this.lead_id==null && other.getLead_id()==null) || 
             (this.lead_id!=null &&
              this.lead_id.equals(other.getLead_id()))) &&
            ((this.couponNumber==null && other.getCouponNumber()==null) || 
             (this.couponNumber!=null &&
              this.couponNumber.equals(other.getCouponNumber()))) &&
            ((this.couponType==null && other.getCouponType()==null) || 
             (this.couponType!=null &&
              this.couponType.equals(other.getCouponType()))) &&
            ((this.couponAmt==null && other.getCouponAmt()==null) || 
             (this.couponAmt!=null &&
              this.couponAmt.equals(other.getCouponAmt()))) &&
            ((this.memo==null && other.getMemo()==null) || 
             (this.memo!=null &&
              this.memo.equals(other.getMemo())));
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
        if (getLead_id() != null) {
            _hashCode += getLead_id().hashCode();
        }
        if (getCouponNumber() != null) {
            _hashCode += getCouponNumber().hashCode();
        }
        if (getCouponType() != null) {
            _hashCode += getCouponType().hashCode();
        }
        if (getCouponAmt() != null) {
            _hashCode += getCouponAmt().hashCode();
        }
        if (getMemo() != null) {
            _hashCode += getMemo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapAddLeadCouponRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapAddLeadCouponRequest"));
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
        elemField.setFieldName("lead_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lead_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("couponNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "couponNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("couponType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "couponType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("couponAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "couponAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memo"));
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
