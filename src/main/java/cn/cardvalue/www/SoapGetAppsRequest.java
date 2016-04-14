/**
 * SoapGetAppsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.www;

public class SoapGetAppsRequest  implements java.io.Serializable {
    private java.lang.String list_id;

    private java.lang.String clientSecret;

    private java.lang.String userName;

    private java.lang.String password;

    private java.lang.String app_id;

    private java.lang.String status;

    private java.lang.String pageNum;

    private java.lang.String pageSize;

    public SoapGetAppsRequest() {
    }

    public SoapGetAppsRequest(
           java.lang.String list_id,
           java.lang.String clientSecret,
           java.lang.String userName,
           java.lang.String password,
           java.lang.String app_id,
           java.lang.String status,
           java.lang.String pageNum,
           java.lang.String pageSize) {
           this.list_id = list_id;
           this.clientSecret = clientSecret;
           this.userName = userName;
           this.password = password;
           this.app_id = app_id;
           this.status = status;
           this.pageNum = pageNum;
           this.pageSize = pageSize;
    }


    /**
     * Gets the list_id value for this SoapGetAppsRequest.
     * 
     * @return list_id
     */
    public java.lang.String getList_id() {
        return list_id;
    }


    /**
     * Sets the list_id value for this SoapGetAppsRequest.
     * 
     * @param list_id
     */
    public void setList_id(java.lang.String list_id) {
        this.list_id = list_id;
    }


    /**
     * Gets the clientSecret value for this SoapGetAppsRequest.
     * 
     * @return clientSecret
     */
    public java.lang.String getClientSecret() {
        return clientSecret;
    }


    /**
     * Sets the clientSecret value for this SoapGetAppsRequest.
     * 
     * @param clientSecret
     */
    public void setClientSecret(java.lang.String clientSecret) {
        this.clientSecret = clientSecret;
    }


    /**
     * Gets the userName value for this SoapGetAppsRequest.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this SoapGetAppsRequest.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }


    /**
     * Gets the password value for this SoapGetAppsRequest.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this SoapGetAppsRequest.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the app_id value for this SoapGetAppsRequest.
     * 
     * @return app_id
     */
    public java.lang.String getApp_id() {
        return app_id;
    }


    /**
     * Sets the app_id value for this SoapGetAppsRequest.
     * 
     * @param app_id
     */
    public void setApp_id(java.lang.String app_id) {
        this.app_id = app_id;
    }


    /**
     * Gets the status value for this SoapGetAppsRequest.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this SoapGetAppsRequest.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the pageNum value for this SoapGetAppsRequest.
     * 
     * @return pageNum
     */
    public java.lang.String getPageNum() {
        return pageNum;
    }


    /**
     * Sets the pageNum value for this SoapGetAppsRequest.
     * 
     * @param pageNum
     */
    public void setPageNum(java.lang.String pageNum) {
        this.pageNum = pageNum;
    }


    /**
     * Gets the pageSize value for this SoapGetAppsRequest.
     * 
     * @return pageSize
     */
    public java.lang.String getPageSize() {
        return pageSize;
    }


    /**
     * Sets the pageSize value for this SoapGetAppsRequest.
     * 
     * @param pageSize
     */
    public void setPageSize(java.lang.String pageSize) {
        this.pageSize = pageSize;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SoapGetAppsRequest)) return false;
        SoapGetAppsRequest other = (SoapGetAppsRequest) obj;
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
            ((this.userName==null && other.getUserName()==null) || 
             (this.userName!=null &&
              this.userName.equals(other.getUserName()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.app_id==null && other.getApp_id()==null) || 
             (this.app_id!=null &&
              this.app_id.equals(other.getApp_id()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.pageNum==null && other.getPageNum()==null) || 
             (this.pageNum!=null &&
              this.pageNum.equals(other.getPageNum()))) &&
            ((this.pageSize==null && other.getPageSize()==null) || 
             (this.pageSize!=null &&
              this.pageSize.equals(other.getPageSize())));
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
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getApp_id() != null) {
            _hashCode += getApp_id().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getPageNum() != null) {
            _hashCode += getPageNum().hashCode();
        }
        if (getPageSize() != null) {
            _hashCode += getPageSize().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapGetAppsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapGetAppsRequest"));
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
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userName"));
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
        elemField.setFieldName("app_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "app_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pageNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageSize");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pageSize"));
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
