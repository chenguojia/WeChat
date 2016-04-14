/**
 * SoapPostUserRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.www;

public class SoapPostUserRequest  implements java.io.Serializable {
    private java.lang.String list_id;

    private java.lang.String clientSecret;

    private java.lang.String userName;

    private java.lang.String password;

    private java.lang.String nameEx;

    private java.lang.String dda;

    private java.lang.String bank_name;

    private java.lang.String IDNumber;

    private java.lang.String email;

    private java.lang.String cellPhone;

    public SoapPostUserRequest() {
    }

    public SoapPostUserRequest(
           java.lang.String list_id,
           java.lang.String clientSecret,
           java.lang.String userName,
           java.lang.String password,
           java.lang.String nameEx,
           java.lang.String dda,
           java.lang.String bank_name,
           java.lang.String IDNumber,
           java.lang.String email,
           java.lang.String cellPhone) {
           this.list_id = list_id;
           this.clientSecret = clientSecret;
           this.userName = userName;
           this.password = password;
           this.nameEx = nameEx;
           this.dda = dda;
           this.bank_name = bank_name;
           this.IDNumber = IDNumber;
           this.email = email;
           this.cellPhone = cellPhone;
    }


    /**
     * Gets the list_id value for this SoapPostUserRequest.
     * 
     * @return list_id
     */
    public java.lang.String getList_id() {
        return list_id;
    }


    /**
     * Sets the list_id value for this SoapPostUserRequest.
     * 
     * @param list_id
     */
    public void setList_id(java.lang.String list_id) {
        this.list_id = list_id;
    }


    /**
     * Gets the clientSecret value for this SoapPostUserRequest.
     * 
     * @return clientSecret
     */
    public java.lang.String getClientSecret() {
        return clientSecret;
    }


    /**
     * Sets the clientSecret value for this SoapPostUserRequest.
     * 
     * @param clientSecret
     */
    public void setClientSecret(java.lang.String clientSecret) {
        this.clientSecret = clientSecret;
    }


    /**
     * Gets the userName value for this SoapPostUserRequest.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this SoapPostUserRequest.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }


    /**
     * Gets the password value for this SoapPostUserRequest.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this SoapPostUserRequest.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the nameEx value for this SoapPostUserRequest.
     * 
     * @return nameEx
     */
    public java.lang.String getNameEx() {
        return nameEx;
    }


    /**
     * Sets the nameEx value for this SoapPostUserRequest.
     * 
     * @param nameEx
     */
    public void setNameEx(java.lang.String nameEx) {
        this.nameEx = nameEx;
    }


    /**
     * Gets the dda value for this SoapPostUserRequest.
     * 
     * @return dda
     */
    public java.lang.String getDda() {
        return dda;
    }


    /**
     * Sets the dda value for this SoapPostUserRequest.
     * 
     * @param dda
     */
    public void setDda(java.lang.String dda) {
        this.dda = dda;
    }


    /**
     * Gets the bank_name value for this SoapPostUserRequest.
     * 
     * @return bank_name
     */
    public java.lang.String getBank_name() {
        return bank_name;
    }


    /**
     * Sets the bank_name value for this SoapPostUserRequest.
     * 
     * @param bank_name
     */
    public void setBank_name(java.lang.String bank_name) {
        this.bank_name = bank_name;
    }


    /**
     * Gets the IDNumber value for this SoapPostUserRequest.
     * 
     * @return IDNumber
     */
    public java.lang.String getIDNumber() {
        return IDNumber;
    }


    /**
     * Sets the IDNumber value for this SoapPostUserRequest.
     * 
     * @param IDNumber
     */
    public void setIDNumber(java.lang.String IDNumber) {
        this.IDNumber = IDNumber;
    }


    /**
     * Gets the email value for this SoapPostUserRequest.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this SoapPostUserRequest.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the cellPhone value for this SoapPostUserRequest.
     * 
     * @return cellPhone
     */
    public java.lang.String getCellPhone() {
        return cellPhone;
    }


    /**
     * Sets the cellPhone value for this SoapPostUserRequest.
     * 
     * @param cellPhone
     */
    public void setCellPhone(java.lang.String cellPhone) {
        this.cellPhone = cellPhone;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SoapPostUserRequest)) return false;
        SoapPostUserRequest other = (SoapPostUserRequest) obj;
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
            ((this.nameEx==null && other.getNameEx()==null) || 
             (this.nameEx!=null &&
              this.nameEx.equals(other.getNameEx()))) &&
            ((this.dda==null && other.getDda()==null) || 
             (this.dda!=null &&
              this.dda.equals(other.getDda()))) &&
            ((this.bank_name==null && other.getBank_name()==null) || 
             (this.bank_name!=null &&
              this.bank_name.equals(other.getBank_name()))) &&
            ((this.IDNumber==null && other.getIDNumber()==null) || 
             (this.IDNumber!=null &&
              this.IDNumber.equals(other.getIDNumber()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.cellPhone==null && other.getCellPhone()==null) || 
             (this.cellPhone!=null &&
              this.cellPhone.equals(other.getCellPhone())));
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
        if (getNameEx() != null) {
            _hashCode += getNameEx().hashCode();
        }
        if (getDda() != null) {
            _hashCode += getDda().hashCode();
        }
        if (getBank_name() != null) {
            _hashCode += getBank_name().hashCode();
        }
        if (getIDNumber() != null) {
            _hashCode += getIDNumber().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getCellPhone() != null) {
            _hashCode += getCellPhone().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapPostUserRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapPostUserRequest"));
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
        elemField.setFieldName("nameEx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NameEx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bank_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bank_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IDNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IDNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cellPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cellPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
