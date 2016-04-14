/**
 * WsSearchAroundMerchRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.support.ws;

public class WsSearchAroundMerchRequest  implements java.io.Serializable {
    private int curPage;

    private double lat;

    private double lng;

    private int pageSize;

    private int range;

    private java.lang.String pId;

    public WsSearchAroundMerchRequest() {
    }

    public WsSearchAroundMerchRequest(
           int curPage,
           double lat,
           double lng,
           int pageSize,
           int range,
           java.lang.String pId) {
           this.curPage = curPage;
           this.lat = lat;
           this.lng = lng;
           this.pageSize = pageSize;
           this.range = range;
           this.pId = pId;
    }


    /**
     * Gets the curPage value for this WsSearchAroundMerchRequest.
     * 
     * @return curPage
     */
    public int getCurPage() {
        return curPage;
    }


    /**
     * Sets the curPage value for this WsSearchAroundMerchRequest.
     * 
     * @param curPage
     */
    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }


    /**
     * Gets the lat value for this WsSearchAroundMerchRequest.
     * 
     * @return lat
     */
    public double getLat() {
        return lat;
    }


    /**
     * Sets the lat value for this WsSearchAroundMerchRequest.
     * 
     * @param lat
     */
    public void setLat(double lat) {
        this.lat = lat;
    }


    /**
     * Gets the lng value for this WsSearchAroundMerchRequest.
     * 
     * @return lng
     */
    public double getLng() {
        return lng;
    }


    /**
     * Sets the lng value for this WsSearchAroundMerchRequest.
     * 
     * @param lng
     */
    public void setLng(double lng) {
        this.lng = lng;
    }


    /**
     * Gets the pageSize value for this WsSearchAroundMerchRequest.
     * 
     * @return pageSize
     */
    public int getPageSize() {
        return pageSize;
    }


    /**
     * Sets the pageSize value for this WsSearchAroundMerchRequest.
     * 
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * Gets the range value for this WsSearchAroundMerchRequest.
     * 
     * @return range
     */
    public int getRange() {
        return range;
    }


    /**
     * Sets the range value for this WsSearchAroundMerchRequest.
     * 
     * @param range
     */
    public void setRange(int range) {
        this.range = range;
    }


    /**
     * Gets the pId value for this WsSearchAroundMerchRequest.
     * 
     * @return pId
     */
    public java.lang.String getPId() {
        return pId;
    }


    /**
     * Sets the pId value for this WsSearchAroundMerchRequest.
     * 
     * @param pId
     */
    public void setPId(java.lang.String pId) {
        this.pId = pId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WsSearchAroundMerchRequest)) return false;
        WsSearchAroundMerchRequest other = (WsSearchAroundMerchRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.curPage == other.getCurPage() &&
            this.lat == other.getLat() &&
            this.lng == other.getLng() &&
            this.pageSize == other.getPageSize() &&
            this.range == other.getRange() &&
            ((this.pId==null && other.getPId()==null) || 
             (this.pId!=null &&
              this.pId.equals(other.getPId())));
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
        _hashCode += getCurPage();
        _hashCode += new Double(getLat()).hashCode();
        _hashCode += new Double(getLng()).hashCode();
        _hashCode += getPageSize();
        _hashCode += getRange();
        if (getPId() != null) {
            _hashCode += getPId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WsSearchAroundMerchRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.support.cardvalue.com/", "wsSearchAroundMerchRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("curPage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "curPage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("pageSize");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pageSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("range");
        elemField.setXmlName(new javax.xml.namespace.QName("", "range"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pId"));
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
