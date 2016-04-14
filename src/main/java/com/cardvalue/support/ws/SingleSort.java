/**
 * SingleSort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.support.ws;

public class SingleSort  implements java.io.Serializable {
    private com.cardvalue.support.ws.SortField sortField;

    private com.cardvalue.support.ws.SortType sortType;

    public SingleSort() {
    }

    public SingleSort(
           com.cardvalue.support.ws.SortField sortField,
           com.cardvalue.support.ws.SortType sortType) {
           this.sortField = sortField;
           this.sortType = sortType;
    }


    /**
     * Gets the sortField value for this SingleSort.
     * 
     * @return sortField
     */
    public com.cardvalue.support.ws.SortField getSortField() {
        return sortField;
    }


    /**
     * Sets the sortField value for this SingleSort.
     * 
     * @param sortField
     */
    public void setSortField(com.cardvalue.support.ws.SortField sortField) {
        this.sortField = sortField;
    }


    /**
     * Gets the sortType value for this SingleSort.
     * 
     * @return sortType
     */
    public com.cardvalue.support.ws.SortType getSortType() {
        return sortType;
    }


    /**
     * Sets the sortType value for this SingleSort.
     * 
     * @param sortType
     */
    public void setSortType(com.cardvalue.support.ws.SortType sortType) {
        this.sortType = sortType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SingleSort)) return false;
        SingleSort other = (SingleSort) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sortField==null && other.getSortField()==null) || 
             (this.sortField!=null &&
              this.sortField.equals(other.getSortField()))) &&
            ((this.sortType==null && other.getSortType()==null) || 
             (this.sortType!=null &&
              this.sortType.equals(other.getSortType())));
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
        if (getSortField() != null) {
            _hashCode += getSortField().hashCode();
        }
        if (getSortType() != null) {
            _hashCode += getSortType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SingleSort.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.support.cardvalue.com/", "singleSort"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sortField");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sortField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.support.cardvalue.com/", "sortField"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sortType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sortType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.support.cardvalue.com/", "sortType"));
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
