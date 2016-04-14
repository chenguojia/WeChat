/**
 * SoapGetActiveLeadsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.www;

public class SoapGetActiveLeadsRequest  implements java.io.Serializable {
    private java.lang.String list_id;

    private java.lang.String clientSecret;

    private java.lang.String MID;

    private java.lang.String SUBMERNO;

    private java.lang.String lead_id;

    private java.lang.String wechatId;

    public SoapGetActiveLeadsRequest() {
    }

    public SoapGetActiveLeadsRequest(
           java.lang.String list_id,
           java.lang.String clientSecret,
           java.lang.String MID,
           java.lang.String SUBMERNO,
           java.lang.String lead_id,
           java.lang.String wechatId) {
           this.list_id = list_id;
           this.clientSecret = clientSecret;
           this.MID = MID;
           this.SUBMERNO = SUBMERNO;
           this.lead_id = lead_id;
           this.wechatId = wechatId;
    }


    /**
     * Gets the list_id value for this SoapGetActiveLeadsRequest.
     * 
     * @return list_id
     */
    public java.lang.String getList_id() {
        return list_id;
    }


    /**
     * Sets the list_id value for this SoapGetActiveLeadsRequest.
     * 
     * @param list_id
     */
    public void setList_id(java.lang.String list_id) {
        this.list_id = list_id;
    }


    /**
     * Gets the clientSecret value for this SoapGetActiveLeadsRequest.
     * 
     * @return clientSecret
     */
    public java.lang.String getClientSecret() {
        return clientSecret;
    }


    /**
     * Sets the clientSecret value for this SoapGetActiveLeadsRequest.
     * 
     * @param clientSecret
     */
    public void setClientSecret(java.lang.String clientSecret) {
        this.clientSecret = clientSecret;
    }


    /**
     * Gets the MID value for this SoapGetActiveLeadsRequest.
     * 
     * @return MID
     */
    public java.lang.String getMID() {
        return MID;
    }


    /**
     * Sets the MID value for this SoapGetActiveLeadsRequest.
     * 
     * @param MID
     */
    public void setMID(java.lang.String MID) {
        this.MID = MID;
    }


    /**
     * Gets the SUBMERNO value for this SoapGetActiveLeadsRequest.
     * 
     * @return SUBMERNO
     */
    public java.lang.String getSUBMERNO() {
        return SUBMERNO;
    }


    /**
     * Sets the SUBMERNO value for this SoapGetActiveLeadsRequest.
     * 
     * @param SUBMERNO
     */
    public void setSUBMERNO(java.lang.String SUBMERNO) {
        this.SUBMERNO = SUBMERNO;
    }


    /**
     * Gets the lead_id value for this SoapGetActiveLeadsRequest.
     * 
     * @return lead_id
     */
    public java.lang.String getLead_id() {
        return lead_id;
    }


    /**
     * Sets the lead_id value for this SoapGetActiveLeadsRequest.
     * 
     * @param lead_id
     */
    public void setLead_id(java.lang.String lead_id) {
        this.lead_id = lead_id;
    }


    /**
     * Gets the wechatId value for this SoapGetActiveLeadsRequest.
     * 
     * @return wechatId
     */
    public java.lang.String getWechatId() {
        return wechatId;
    }


    /**
     * Sets the wechatId value for this SoapGetActiveLeadsRequest.
     * 
     * @param wechatId
     */
    public void setWechatId(java.lang.String wechatId) {
        this.wechatId = wechatId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SoapGetActiveLeadsRequest)) return false;
        SoapGetActiveLeadsRequest other = (SoapGetActiveLeadsRequest) obj;
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
              this.MID.equals(other.getMID()))) &&
            ((this.SUBMERNO==null && other.getSUBMERNO()==null) || 
             (this.SUBMERNO!=null &&
              this.SUBMERNO.equals(other.getSUBMERNO()))) &&
            ((this.lead_id==null && other.getLead_id()==null) || 
             (this.lead_id!=null &&
              this.lead_id.equals(other.getLead_id()))) &&
            ((this.wechatId==null && other.getWechatId()==null) || 
             (this.wechatId!=null &&
              this.wechatId.equals(other.getWechatId())));
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
        if (getSUBMERNO() != null) {
            _hashCode += getSUBMERNO().hashCode();
        }
        if (getLead_id() != null) {
            _hashCode += getLead_id().hashCode();
        }
        if (getWechatId() != null) {
            _hashCode += getWechatId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapGetActiveLeadsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetActiveLeadsRequest"));
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
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SUBMERNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SUBMERNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lead_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lead_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wechatId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "wechatId"));
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
