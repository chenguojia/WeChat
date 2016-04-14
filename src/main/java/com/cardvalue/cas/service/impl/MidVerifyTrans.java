/**
 * MidVerifyTrans.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.cas.service.impl;

public class MidVerifyTrans  implements java.io.Serializable {
    private java.lang.String tranTime;

    private java.lang.String mid;

    private java.lang.String tid;

    private java.lang.String cardNo;

    private java.lang.String currency;

    private java.lang.String tranAmount;

    public MidVerifyTrans() {
    }

    public MidVerifyTrans(
           java.lang.String tranTime,
           java.lang.String mid,
           java.lang.String tid,
           java.lang.String cardNo,
           java.lang.String currency,
           java.lang.String tranAmount) {
           this.tranTime = tranTime;
           this.mid = mid;
           this.tid = tid;
           this.cardNo = cardNo;
           this.currency = currency;
           this.tranAmount = tranAmount;
    }


    /**
     * Gets the tranTime value for this MidVerifyTrans.
     * 
     * @return tranTime
     */
    public java.lang.String getTranTime() {
        return tranTime;
    }


    /**
     * Sets the tranTime value for this MidVerifyTrans.
     * 
     * @param tranTime
     */
    public void setTranTime(java.lang.String tranTime) {
        this.tranTime = tranTime;
    }


    /**
     * Gets the mid value for this MidVerifyTrans.
     * 
     * @return mid
     */
    public java.lang.String getMid() {
        return mid;
    }


    /**
     * Sets the mid value for this MidVerifyTrans.
     * 
     * @param mid
     */
    public void setMid(java.lang.String mid) {
        this.mid = mid;
    }


    /**
     * Gets the tid value for this MidVerifyTrans.
     * 
     * @return tid
     */
    public java.lang.String getTid() {
        return tid;
    }


    /**
     * Sets the tid value for this MidVerifyTrans.
     * 
     * @param tid
     */
    public void setTid(java.lang.String tid) {
        this.tid = tid;
    }


    /**
     * Gets the cardNo value for this MidVerifyTrans.
     * 
     * @return cardNo
     */
    public java.lang.String getCardNo() {
        return cardNo;
    }


    /**
     * Sets the cardNo value for this MidVerifyTrans.
     * 
     * @param cardNo
     */
    public void setCardNo(java.lang.String cardNo) {
        this.cardNo = cardNo;
    }


    /**
     * Gets the currency value for this MidVerifyTrans.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this MidVerifyTrans.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the tranAmount value for this MidVerifyTrans.
     * 
     * @return tranAmount
     */
    public java.lang.String getTranAmount() {
        return tranAmount;
    }


    /**
     * Sets the tranAmount value for this MidVerifyTrans.
     * 
     * @param tranAmount
     */
    public void setTranAmount(java.lang.String tranAmount) {
        this.tranAmount = tranAmount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MidVerifyTrans)) return false;
        MidVerifyTrans other = (MidVerifyTrans) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tranTime==null && other.getTranTime()==null) || 
             (this.tranTime!=null &&
              this.tranTime.equals(other.getTranTime()))) &&
            ((this.mid==null && other.getMid()==null) || 
             (this.mid!=null &&
              this.mid.equals(other.getMid()))) &&
            ((this.tid==null && other.getTid()==null) || 
             (this.tid!=null &&
              this.tid.equals(other.getTid()))) &&
            ((this.cardNo==null && other.getCardNo()==null) || 
             (this.cardNo!=null &&
              this.cardNo.equals(other.getCardNo()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.tranAmount==null && other.getTranAmount()==null) || 
             (this.tranAmount!=null &&
              this.tranAmount.equals(other.getTranAmount())));
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
        if (getTranTime() != null) {
            _hashCode += getTranTime().hashCode();
        }
        if (getMid() != null) {
            _hashCode += getMid().hashCode();
        }
        if (getTid() != null) {
            _hashCode += getTid().hashCode();
        }
        if (getCardNo() != null) {
            _hashCode += getCardNo().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getTranAmount() != null) {
            _hashCode += getTranAmount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MidVerifyTrans.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "midVerifyTrans"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tranTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tranTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cardNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tranAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tranAmount"));
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
