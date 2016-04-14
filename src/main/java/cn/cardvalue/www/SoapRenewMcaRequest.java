/**
 * SoapRenewMcaRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.www;

public class SoapRenewMcaRequest  implements java.io.Serializable {
    private java.lang.String channel;

    private java.lang.String clientSecret;

    private java.lang.String user_id;

    private java.lang.String new_deal_id;

    private java.lang.String processor;

    private java.lang.String app_id;

    private java.lang.String cashadv_id;

    private java.lang.String fundingAmount;

    private java.lang.String fundingPeriod;

    private java.lang.String fundingPurpose;

    private java.lang.String fundingProduct;

    private java.lang.String onlinePaybackRecur;

    private java.lang.String directDebitRecur;

    private java.lang.String comments;

    public SoapRenewMcaRequest() {
    }

    public SoapRenewMcaRequest(
           java.lang.String channel,
           java.lang.String clientSecret,
           java.lang.String user_id,
           java.lang.String new_deal_id,
           java.lang.String processor,
           java.lang.String app_id,
           java.lang.String cashadv_id,
           java.lang.String fundingAmount,
           java.lang.String fundingPeriod,
           java.lang.String fundingPurpose,
           java.lang.String fundingProduct,
           java.lang.String onlinePaybackRecur,
           java.lang.String directDebitRecur,
           java.lang.String comments) {
           this.channel = channel;
           this.clientSecret = clientSecret;
           this.user_id = user_id;
           this.new_deal_id = new_deal_id;
           this.processor = processor;
           this.app_id = app_id;
           this.cashadv_id = cashadv_id;
           this.fundingAmount = fundingAmount;
           this.fundingPeriod = fundingPeriod;
           this.fundingPurpose = fundingPurpose;
           this.fundingProduct = fundingProduct;
           this.onlinePaybackRecur = onlinePaybackRecur;
           this.directDebitRecur = directDebitRecur;
           this.comments = comments;
    }


    /**
     * Gets the channel value for this SoapRenewMcaRequest.
     * 
     * @return channel
     */
    public java.lang.String getChannel() {
        return channel;
    }


    /**
     * Sets the channel value for this SoapRenewMcaRequest.
     * 
     * @param channel
     */
    public void setChannel(java.lang.String channel) {
        this.channel = channel;
    }


    /**
     * Gets the clientSecret value for this SoapRenewMcaRequest.
     * 
     * @return clientSecret
     */
    public java.lang.String getClientSecret() {
        return clientSecret;
    }


    /**
     * Sets the clientSecret value for this SoapRenewMcaRequest.
     * 
     * @param clientSecret
     */
    public void setClientSecret(java.lang.String clientSecret) {
        this.clientSecret = clientSecret;
    }


    /**
     * Gets the user_id value for this SoapRenewMcaRequest.
     * 
     * @return user_id
     */
    public java.lang.String getUser_id() {
        return user_id;
    }


    /**
     * Sets the user_id value for this SoapRenewMcaRequest.
     * 
     * @param user_id
     */
    public void setUser_id(java.lang.String user_id) {
        this.user_id = user_id;
    }


    /**
     * Gets the new_deal_id value for this SoapRenewMcaRequest.
     * 
     * @return new_deal_id
     */
    public java.lang.String getNew_deal_id() {
        return new_deal_id;
    }


    /**
     * Sets the new_deal_id value for this SoapRenewMcaRequest.
     * 
     * @param new_deal_id
     */
    public void setNew_deal_id(java.lang.String new_deal_id) {
        this.new_deal_id = new_deal_id;
    }


    /**
     * Gets the processor value for this SoapRenewMcaRequest.
     * 
     * @return processor
     */
    public java.lang.String getProcessor() {
        return processor;
    }


    /**
     * Sets the processor value for this SoapRenewMcaRequest.
     * 
     * @param processor
     */
    public void setProcessor(java.lang.String processor) {
        this.processor = processor;
    }


    /**
     * Gets the app_id value for this SoapRenewMcaRequest.
     * 
     * @return app_id
     */
    public java.lang.String getApp_id() {
        return app_id;
    }


    /**
     * Sets the app_id value for this SoapRenewMcaRequest.
     * 
     * @param app_id
     */
    public void setApp_id(java.lang.String app_id) {
        this.app_id = app_id;
    }


    /**
     * Gets the cashadv_id value for this SoapRenewMcaRequest.
     * 
     * @return cashadv_id
     */
    public java.lang.String getCashadv_id() {
        return cashadv_id;
    }


    /**
     * Sets the cashadv_id value for this SoapRenewMcaRequest.
     * 
     * @param cashadv_id
     */
    public void setCashadv_id(java.lang.String cashadv_id) {
        this.cashadv_id = cashadv_id;
    }


    /**
     * Gets the fundingAmount value for this SoapRenewMcaRequest.
     * 
     * @return fundingAmount
     */
    public java.lang.String getFundingAmount() {
        return fundingAmount;
    }


    /**
     * Sets the fundingAmount value for this SoapRenewMcaRequest.
     * 
     * @param fundingAmount
     */
    public void setFundingAmount(java.lang.String fundingAmount) {
        this.fundingAmount = fundingAmount;
    }


    /**
     * Gets the fundingPeriod value for this SoapRenewMcaRequest.
     * 
     * @return fundingPeriod
     */
    public java.lang.String getFundingPeriod() {
        return fundingPeriod;
    }


    /**
     * Sets the fundingPeriod value for this SoapRenewMcaRequest.
     * 
     * @param fundingPeriod
     */
    public void setFundingPeriod(java.lang.String fundingPeriod) {
        this.fundingPeriod = fundingPeriod;
    }


    /**
     * Gets the fundingPurpose value for this SoapRenewMcaRequest.
     * 
     * @return fundingPurpose
     */
    public java.lang.String getFundingPurpose() {
        return fundingPurpose;
    }


    /**
     * Sets the fundingPurpose value for this SoapRenewMcaRequest.
     * 
     * @param fundingPurpose
     */
    public void setFundingPurpose(java.lang.String fundingPurpose) {
        this.fundingPurpose = fundingPurpose;
    }


    /**
     * Gets the fundingProduct value for this SoapRenewMcaRequest.
     * 
     * @return fundingProduct
     */
    public java.lang.String getFundingProduct() {
        return fundingProduct;
    }


    /**
     * Sets the fundingProduct value for this SoapRenewMcaRequest.
     * 
     * @param fundingProduct
     */
    public void setFundingProduct(java.lang.String fundingProduct) {
        this.fundingProduct = fundingProduct;
    }


    /**
     * Gets the onlinePaybackRecur value for this SoapRenewMcaRequest.
     * 
     * @return onlinePaybackRecur
     */
    public java.lang.String getOnlinePaybackRecur() {
        return onlinePaybackRecur;
    }


    /**
     * Sets the onlinePaybackRecur value for this SoapRenewMcaRequest.
     * 
     * @param onlinePaybackRecur
     */
    public void setOnlinePaybackRecur(java.lang.String onlinePaybackRecur) {
        this.onlinePaybackRecur = onlinePaybackRecur;
    }


    /**
     * Gets the directDebitRecur value for this SoapRenewMcaRequest.
     * 
     * @return directDebitRecur
     */
    public java.lang.String getDirectDebitRecur() {
        return directDebitRecur;
    }


    /**
     * Sets the directDebitRecur value for this SoapRenewMcaRequest.
     * 
     * @param directDebitRecur
     */
    public void setDirectDebitRecur(java.lang.String directDebitRecur) {
        this.directDebitRecur = directDebitRecur;
    }


    /**
     * Gets the comments value for this SoapRenewMcaRequest.
     * 
     * @return comments
     */
    public java.lang.String getComments() {
        return comments;
    }


    /**
     * Sets the comments value for this SoapRenewMcaRequest.
     * 
     * @param comments
     */
    public void setComments(java.lang.String comments) {
        this.comments = comments;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SoapRenewMcaRequest)) return false;
        SoapRenewMcaRequest other = (SoapRenewMcaRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.channel==null && other.getChannel()==null) || 
             (this.channel!=null &&
              this.channel.equals(other.getChannel()))) &&
            ((this.clientSecret==null && other.getClientSecret()==null) || 
             (this.clientSecret!=null &&
              this.clientSecret.equals(other.getClientSecret()))) &&
            ((this.user_id==null && other.getUser_id()==null) || 
             (this.user_id!=null &&
              this.user_id.equals(other.getUser_id()))) &&
            ((this.new_deal_id==null && other.getNew_deal_id()==null) || 
             (this.new_deal_id!=null &&
              this.new_deal_id.equals(other.getNew_deal_id()))) &&
            ((this.processor==null && other.getProcessor()==null) || 
             (this.processor!=null &&
              this.processor.equals(other.getProcessor()))) &&
            ((this.app_id==null && other.getApp_id()==null) || 
             (this.app_id!=null &&
              this.app_id.equals(other.getApp_id()))) &&
            ((this.cashadv_id==null && other.getCashadv_id()==null) || 
             (this.cashadv_id!=null &&
              this.cashadv_id.equals(other.getCashadv_id()))) &&
            ((this.fundingAmount==null && other.getFundingAmount()==null) || 
             (this.fundingAmount!=null &&
              this.fundingAmount.equals(other.getFundingAmount()))) &&
            ((this.fundingPeriod==null && other.getFundingPeriod()==null) || 
             (this.fundingPeriod!=null &&
              this.fundingPeriod.equals(other.getFundingPeriod()))) &&
            ((this.fundingPurpose==null && other.getFundingPurpose()==null) || 
             (this.fundingPurpose!=null &&
              this.fundingPurpose.equals(other.getFundingPurpose()))) &&
            ((this.fundingProduct==null && other.getFundingProduct()==null) || 
             (this.fundingProduct!=null &&
              this.fundingProduct.equals(other.getFundingProduct()))) &&
            ((this.onlinePaybackRecur==null && other.getOnlinePaybackRecur()==null) || 
             (this.onlinePaybackRecur!=null &&
              this.onlinePaybackRecur.equals(other.getOnlinePaybackRecur()))) &&
            ((this.directDebitRecur==null && other.getDirectDebitRecur()==null) || 
             (this.directDebitRecur!=null &&
              this.directDebitRecur.equals(other.getDirectDebitRecur()))) &&
            ((this.comments==null && other.getComments()==null) || 
             (this.comments!=null &&
              this.comments.equals(other.getComments())));
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
        if (getChannel() != null) {
            _hashCode += getChannel().hashCode();
        }
        if (getClientSecret() != null) {
            _hashCode += getClientSecret().hashCode();
        }
        if (getUser_id() != null) {
            _hashCode += getUser_id().hashCode();
        }
        if (getNew_deal_id() != null) {
            _hashCode += getNew_deal_id().hashCode();
        }
        if (getProcessor() != null) {
            _hashCode += getProcessor().hashCode();
        }
        if (getApp_id() != null) {
            _hashCode += getApp_id().hashCode();
        }
        if (getCashadv_id() != null) {
            _hashCode += getCashadv_id().hashCode();
        }
        if (getFundingAmount() != null) {
            _hashCode += getFundingAmount().hashCode();
        }
        if (getFundingPeriod() != null) {
            _hashCode += getFundingPeriod().hashCode();
        }
        if (getFundingPurpose() != null) {
            _hashCode += getFundingPurpose().hashCode();
        }
        if (getFundingProduct() != null) {
            _hashCode += getFundingProduct().hashCode();
        }
        if (getOnlinePaybackRecur() != null) {
            _hashCode += getOnlinePaybackRecur().hashCode();
        }
        if (getDirectDebitRecur() != null) {
            _hashCode += getDirectDebitRecur().hashCode();
        }
        if (getComments() != null) {
            _hashCode += getComments().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapRenewMcaRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapRenewMcaRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("channel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "channel"));
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
        elemField.setFieldName("user_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("new_deal_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "new_deal_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "processor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("app_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "app_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cashadv_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cashadv_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fundingAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FundingAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fundingPeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FundingPeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fundingPurpose");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FundingPurpose"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fundingProduct");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FundingProduct"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("onlinePaybackRecur");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OnlinePaybackRecur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("directDebitRecur");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DirectDebitRecur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comments");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Comments"));
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
