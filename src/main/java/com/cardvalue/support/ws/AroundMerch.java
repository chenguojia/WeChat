/**
 * AroundMerch.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.support.ws;

public class AroundMerch  implements java.io.Serializable {
    private java.lang.String city;

    private java.math.BigDecimal creditLineIn90Days;

    private double distance;

    private double lat;

    private double lng;

    private java.lang.String merNo;

    private java.lang.String merchantName;

    private double wgsLat;

    private double wgsLng;

    public AroundMerch() {
    }

    public AroundMerch(
           java.lang.String city,
           java.math.BigDecimal creditLineIn90Days,
           double distance,
           double lat,
           double lng,
           java.lang.String merNo,
           java.lang.String merchantName,
           double wgsLat,
           double wgsLng) {
           this.city = city;
           this.creditLineIn90Days = creditLineIn90Days;
           this.distance = distance;
           this.lat = lat;
           this.lng = lng;
           this.merNo = merNo;
           this.merchantName = merchantName;
           this.wgsLat = wgsLat;
           this.wgsLng = wgsLng;
    }


    /**
     * Gets the city value for this AroundMerch.
     * 
     * @return city
     */
    public java.lang.String getCity() {
        return city;
    }


    /**
     * Sets the city value for this AroundMerch.
     * 
     * @param city
     */
    public void setCity(java.lang.String city) {
        this.city = city;
    }


    /**
     * Gets the creditLineIn90Days value for this AroundMerch.
     * 
     * @return creditLineIn90Days
     */
    public java.math.BigDecimal getCreditLineIn90Days() {
        return creditLineIn90Days;
    }


    /**
     * Sets the creditLineIn90Days value for this AroundMerch.
     * 
     * @param creditLineIn90Days
     */
    public void setCreditLineIn90Days(java.math.BigDecimal creditLineIn90Days) {
        this.creditLineIn90Days = creditLineIn90Days;
    }


    /**
     * Gets the distance value for this AroundMerch.
     * 
     * @return distance
     */
    public double getDistance() {
        return distance;
    }


    /**
     * Sets the distance value for this AroundMerch.
     * 
     * @param distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }


    /**
     * Gets the lat value for this AroundMerch.
     * 
     * @return lat
     */
    public double getLat() {
        return lat;
    }


    /**
     * Sets the lat value for this AroundMerch.
     * 
     * @param lat
     */
    public void setLat(double lat) {
        this.lat = lat;
    }


    /**
     * Gets the lng value for this AroundMerch.
     * 
     * @return lng
     */
    public double getLng() {
        return lng;
    }


    /**
     * Sets the lng value for this AroundMerch.
     * 
     * @param lng
     */
    public void setLng(double lng) {
        this.lng = lng;
    }


    /**
     * Gets the merNo value for this AroundMerch.
     * 
     * @return merNo
     */
    public java.lang.String getMerNo() {
        return merNo;
    }


    /**
     * Sets the merNo value for this AroundMerch.
     * 
     * @param merNo
     */
    public void setMerNo(java.lang.String merNo) {
        this.merNo = merNo;
    }


    /**
     * Gets the merchantName value for this AroundMerch.
     * 
     * @return merchantName
     */
    public java.lang.String getMerchantName() {
        return merchantName;
    }


    /**
     * Sets the merchantName value for this AroundMerch.
     * 
     * @param merchantName
     */
    public void setMerchantName(java.lang.String merchantName) {
        this.merchantName = merchantName;
    }


    /**
     * Gets the wgsLat value for this AroundMerch.
     * 
     * @return wgsLat
     */
    public double getWgsLat() {
        return wgsLat;
    }


    /**
     * Sets the wgsLat value for this AroundMerch.
     * 
     * @param wgsLat
     */
    public void setWgsLat(double wgsLat) {
        this.wgsLat = wgsLat;
    }


    /**
     * Gets the wgsLng value for this AroundMerch.
     * 
     * @return wgsLng
     */
    public double getWgsLng() {
        return wgsLng;
    }


    /**
     * Sets the wgsLng value for this AroundMerch.
     * 
     * @param wgsLng
     */
    public void setWgsLng(double wgsLng) {
        this.wgsLng = wgsLng;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AroundMerch)) return false;
        AroundMerch other = (AroundMerch) obj;
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
            ((this.creditLineIn90Days==null && other.getCreditLineIn90Days()==null) || 
             (this.creditLineIn90Days!=null &&
              this.creditLineIn90Days.equals(other.getCreditLineIn90Days()))) &&
            this.distance == other.getDistance() &&
            this.lat == other.getLat() &&
            this.lng == other.getLng() &&
            ((this.merNo==null && other.getMerNo()==null) || 
             (this.merNo!=null &&
              this.merNo.equals(other.getMerNo()))) &&
            ((this.merchantName==null && other.getMerchantName()==null) || 
             (this.merchantName!=null &&
              this.merchantName.equals(other.getMerchantName()))) &&
            this.wgsLat == other.getWgsLat() &&
            this.wgsLng == other.getWgsLng();
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
        if (getCreditLineIn90Days() != null) {
            _hashCode += getCreditLineIn90Days().hashCode();
        }
        _hashCode += new Double(getDistance()).hashCode();
        _hashCode += new Double(getLat()).hashCode();
        _hashCode += new Double(getLng()).hashCode();
        if (getMerNo() != null) {
            _hashCode += getMerNo().hashCode();
        }
        if (getMerchantName() != null) {
            _hashCode += getMerchantName().hashCode();
        }
        _hashCode += new Double(getWgsLat()).hashCode();
        _hashCode += new Double(getWgsLng()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AroundMerch.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.support.cardvalue.com/", "aroundMerch"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("city");
        elemField.setXmlName(new javax.xml.namespace.QName("", "city"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditLineIn90Days");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditLineIn90Days"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "distance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lng");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lng"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
        elemField.setFieldName("merchantName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "merchantName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wgsLat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "wgsLat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wgsLng");
        elemField.setXmlName(new javax.xml.namespace.QName("", "wgsLng"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
