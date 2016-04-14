/**
 * CalculateRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.calculator.service;

public class CalculateRequest  implements java.io.Serializable {
    private java.lang.String type;

    private java.lang.String username;

    private java.lang.String password;

    private java.lang.String mccCode;

    private java.lang.String provinceCode;

    private java.lang.String lastMonthTransactionCount;

    private java.lang.String lastMonthTransactionAmount;

    private java.lang.String dailyAverageTransactionCount;

    private java.lang.String dailyAverageSingleTransactionAmount;

    private java.lang.String monthlyAverageTransactionAmount;

    public CalculateRequest() {
    }

    public CalculateRequest(
           java.lang.String type,
           java.lang.String username,
           java.lang.String password,
           java.lang.String mccCode,
           java.lang.String provinceCode,
           java.lang.String lastMonthTransactionCount,
           java.lang.String lastMonthTransactionAmount,
           java.lang.String dailyAverageTransactionCount,
           java.lang.String dailyAverageSingleTransactionAmount,
           java.lang.String monthlyAverageTransactionAmount) {
           this.type = type;
           this.username = username;
           this.password = password;
           this.mccCode = mccCode;
           this.provinceCode = provinceCode;
           this.lastMonthTransactionCount = lastMonthTransactionCount;
           this.lastMonthTransactionAmount = lastMonthTransactionAmount;
           this.dailyAverageTransactionCount = dailyAverageTransactionCount;
           this.dailyAverageSingleTransactionAmount = dailyAverageSingleTransactionAmount;
           this.monthlyAverageTransactionAmount = monthlyAverageTransactionAmount;
    }


    /**
     * Gets the type value for this CalculateRequest.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this CalculateRequest.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the username value for this CalculateRequest.
     * 
     * @return username
     */
    public java.lang.String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this CalculateRequest.
     * 
     * @param username
     */
    public void setUsername(java.lang.String username) {
        this.username = username;
    }


    /**
     * Gets the password value for this CalculateRequest.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this CalculateRequest.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the mccCode value for this CalculateRequest.
     * 
     * @return mccCode
     */
    public java.lang.String getMccCode() {
        return mccCode;
    }


    /**
     * Sets the mccCode value for this CalculateRequest.
     * 
     * @param mccCode
     */
    public void setMccCode(java.lang.String mccCode) {
        this.mccCode = mccCode;
    }


    /**
     * Gets the provinceCode value for this CalculateRequest.
     * 
     * @return provinceCode
     */
    public java.lang.String getProvinceCode() {
        return provinceCode;
    }


    /**
     * Sets the provinceCode value for this CalculateRequest.
     * 
     * @param provinceCode
     */
    public void setProvinceCode(java.lang.String provinceCode) {
        this.provinceCode = provinceCode;
    }


    /**
     * Gets the lastMonthTransactionCount value for this CalculateRequest.
     * 
     * @return lastMonthTransactionCount
     */
    public java.lang.String getLastMonthTransactionCount() {
        return lastMonthTransactionCount;
    }


    /**
     * Sets the lastMonthTransactionCount value for this CalculateRequest.
     * 
     * @param lastMonthTransactionCount
     */
    public void setLastMonthTransactionCount(java.lang.String lastMonthTransactionCount) {
        this.lastMonthTransactionCount = lastMonthTransactionCount;
    }


    /**
     * Gets the lastMonthTransactionAmount value for this CalculateRequest.
     * 
     * @return lastMonthTransactionAmount
     */
    public java.lang.String getLastMonthTransactionAmount() {
        return lastMonthTransactionAmount;
    }


    /**
     * Sets the lastMonthTransactionAmount value for this CalculateRequest.
     * 
     * @param lastMonthTransactionAmount
     */
    public void setLastMonthTransactionAmount(java.lang.String lastMonthTransactionAmount) {
        this.lastMonthTransactionAmount = lastMonthTransactionAmount;
    }


    /**
     * Gets the dailyAverageTransactionCount value for this CalculateRequest.
     * 
     * @return dailyAverageTransactionCount
     */
    public java.lang.String getDailyAverageTransactionCount() {
        return dailyAverageTransactionCount;
    }


    /**
     * Sets the dailyAverageTransactionCount value for this CalculateRequest.
     * 
     * @param dailyAverageTransactionCount
     */
    public void setDailyAverageTransactionCount(java.lang.String dailyAverageTransactionCount) {
        this.dailyAverageTransactionCount = dailyAverageTransactionCount;
    }


    /**
     * Gets the dailyAverageSingleTransactionAmount value for this CalculateRequest.
     * 
     * @return dailyAverageSingleTransactionAmount
     */
    public java.lang.String getDailyAverageSingleTransactionAmount() {
        return dailyAverageSingleTransactionAmount;
    }


    /**
     * Sets the dailyAverageSingleTransactionAmount value for this CalculateRequest.
     * 
     * @param dailyAverageSingleTransactionAmount
     */
    public void setDailyAverageSingleTransactionAmount(java.lang.String dailyAverageSingleTransactionAmount) {
        this.dailyAverageSingleTransactionAmount = dailyAverageSingleTransactionAmount;
    }


    /**
     * Gets the monthlyAverageTransactionAmount value for this CalculateRequest.
     * 
     * @return monthlyAverageTransactionAmount
     */
    public java.lang.String getMonthlyAverageTransactionAmount() {
        return monthlyAverageTransactionAmount;
    }


    /**
     * Sets the monthlyAverageTransactionAmount value for this CalculateRequest.
     * 
     * @param monthlyAverageTransactionAmount
     */
    public void setMonthlyAverageTransactionAmount(java.lang.String monthlyAverageTransactionAmount) {
        this.monthlyAverageTransactionAmount = monthlyAverageTransactionAmount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CalculateRequest)) return false;
        CalculateRequest other = (CalculateRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.username==null && other.getUsername()==null) || 
             (this.username!=null &&
              this.username.equals(other.getUsername()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.mccCode==null && other.getMccCode()==null) || 
             (this.mccCode!=null &&
              this.mccCode.equals(other.getMccCode()))) &&
            ((this.provinceCode==null && other.getProvinceCode()==null) || 
             (this.provinceCode!=null &&
              this.provinceCode.equals(other.getProvinceCode()))) &&
            ((this.lastMonthTransactionCount==null && other.getLastMonthTransactionCount()==null) || 
             (this.lastMonthTransactionCount!=null &&
              this.lastMonthTransactionCount.equals(other.getLastMonthTransactionCount()))) &&
            ((this.lastMonthTransactionAmount==null && other.getLastMonthTransactionAmount()==null) || 
             (this.lastMonthTransactionAmount!=null &&
              this.lastMonthTransactionAmount.equals(other.getLastMonthTransactionAmount()))) &&
            ((this.dailyAverageTransactionCount==null && other.getDailyAverageTransactionCount()==null) || 
             (this.dailyAverageTransactionCount!=null &&
              this.dailyAverageTransactionCount.equals(other.getDailyAverageTransactionCount()))) &&
            ((this.dailyAverageSingleTransactionAmount==null && other.getDailyAverageSingleTransactionAmount()==null) || 
             (this.dailyAverageSingleTransactionAmount!=null &&
              this.dailyAverageSingleTransactionAmount.equals(other.getDailyAverageSingleTransactionAmount()))) &&
            ((this.monthlyAverageTransactionAmount==null && other.getMonthlyAverageTransactionAmount()==null) || 
             (this.monthlyAverageTransactionAmount!=null &&
              this.monthlyAverageTransactionAmount.equals(other.getMonthlyAverageTransactionAmount())));
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
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getUsername() != null) {
            _hashCode += getUsername().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getMccCode() != null) {
            _hashCode += getMccCode().hashCode();
        }
        if (getProvinceCode() != null) {
            _hashCode += getProvinceCode().hashCode();
        }
        if (getLastMonthTransactionCount() != null) {
            _hashCode += getLastMonthTransactionCount().hashCode();
        }
        if (getLastMonthTransactionAmount() != null) {
            _hashCode += getLastMonthTransactionAmount().hashCode();
        }
        if (getDailyAverageTransactionCount() != null) {
            _hashCode += getDailyAverageTransactionCount().hashCode();
        }
        if (getDailyAverageSingleTransactionAmount() != null) {
            _hashCode += getDailyAverageSingleTransactionAmount().hashCode();
        }
        if (getMonthlyAverageTransactionAmount() != null) {
            _hashCode += getMonthlyAverageTransactionAmount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CalculateRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cardvalue.com/calculator/service/", ">CalculateRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("username");
        elemField.setXmlName(new javax.xml.namespace.QName("", "username"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mccCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mccCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provinceCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "provinceCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastMonthTransactionCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastMonthTransactionCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastMonthTransactionAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastMonthTransactionAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dailyAverageTransactionCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dailyAverageTransactionCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dailyAverageSingleTransactionAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dailyAverageSingleTransactionAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monthlyAverageTransactionAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "monthlyAverageTransactionAmount"));
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
