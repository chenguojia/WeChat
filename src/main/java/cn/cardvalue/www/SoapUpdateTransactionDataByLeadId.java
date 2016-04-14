/**
 * SoapUpdateTransactionDataByLeadId.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cardvalue.www;

public class SoapUpdateTransactionDataByLeadId  implements java.io.Serializable {
    private java.lang.String lead_id;

    private java.lang.String region;

    private java.lang.String SICCode;

    private java.lang.String lastMonTranCNT;

    private java.lang.String dayAvgTranCNT;

    private java.lang.String dayAvgPerTranAMT;

    private java.lang.String procMonthlyVolume;

    private java.lang.String lastMonTranAMT;

    private java.lang.String monStDev;

    public SoapUpdateTransactionDataByLeadId() {
    }

    public SoapUpdateTransactionDataByLeadId(
           java.lang.String lead_id,
           java.lang.String region,
           java.lang.String SICCode,
           java.lang.String lastMonTranCNT,
           java.lang.String dayAvgTranCNT,
           java.lang.String dayAvgPerTranAMT,
           java.lang.String procMonthlyVolume,
           java.lang.String lastMonTranAMT,
           java.lang.String monStDev) {
           this.lead_id = lead_id;
           this.region = region;
           this.SICCode = SICCode;
           this.lastMonTranCNT = lastMonTranCNT;
           this.dayAvgTranCNT = dayAvgTranCNT;
           this.dayAvgPerTranAMT = dayAvgPerTranAMT;
           this.procMonthlyVolume = procMonthlyVolume;
           this.lastMonTranAMT = lastMonTranAMT;
           this.monStDev = monStDev;
    }


    /**
     * Gets the lead_id value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @return lead_id
     */
    public java.lang.String getLead_id() {
        return lead_id;
    }


    /**
     * Sets the lead_id value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @param lead_id
     */
    public void setLead_id(java.lang.String lead_id) {
        this.lead_id = lead_id;
    }


    /**
     * Gets the region value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @return region
     */
    public java.lang.String getRegion() {
        return region;
    }


    /**
     * Sets the region value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @param region
     */
    public void setRegion(java.lang.String region) {
        this.region = region;
    }


    /**
     * Gets the SICCode value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @return SICCode
     */
    public java.lang.String getSICCode() {
        return SICCode;
    }


    /**
     * Sets the SICCode value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @param SICCode
     */
    public void setSICCode(java.lang.String SICCode) {
        this.SICCode = SICCode;
    }


    /**
     * Gets the lastMonTranCNT value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @return lastMonTranCNT
     */
    public java.lang.String getLastMonTranCNT() {
        return lastMonTranCNT;
    }


    /**
     * Sets the lastMonTranCNT value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @param lastMonTranCNT
     */
    public void setLastMonTranCNT(java.lang.String lastMonTranCNT) {
        this.lastMonTranCNT = lastMonTranCNT;
    }


    /**
     * Gets the dayAvgTranCNT value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @return dayAvgTranCNT
     */
    public java.lang.String getDayAvgTranCNT() {
        return dayAvgTranCNT;
    }


    /**
     * Sets the dayAvgTranCNT value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @param dayAvgTranCNT
     */
    public void setDayAvgTranCNT(java.lang.String dayAvgTranCNT) {
        this.dayAvgTranCNT = dayAvgTranCNT;
    }


    /**
     * Gets the dayAvgPerTranAMT value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @return dayAvgPerTranAMT
     */
    public java.lang.String getDayAvgPerTranAMT() {
        return dayAvgPerTranAMT;
    }


    /**
     * Sets the dayAvgPerTranAMT value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @param dayAvgPerTranAMT
     */
    public void setDayAvgPerTranAMT(java.lang.String dayAvgPerTranAMT) {
        this.dayAvgPerTranAMT = dayAvgPerTranAMT;
    }


    /**
     * Gets the procMonthlyVolume value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @return procMonthlyVolume
     */
    public java.lang.String getProcMonthlyVolume() {
        return procMonthlyVolume;
    }


    /**
     * Sets the procMonthlyVolume value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @param procMonthlyVolume
     */
    public void setProcMonthlyVolume(java.lang.String procMonthlyVolume) {
        this.procMonthlyVolume = procMonthlyVolume;
    }


    /**
     * Gets the lastMonTranAMT value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @return lastMonTranAMT
     */
    public java.lang.String getLastMonTranAMT() {
        return lastMonTranAMT;
    }


    /**
     * Sets the lastMonTranAMT value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @param lastMonTranAMT
     */
    public void setLastMonTranAMT(java.lang.String lastMonTranAMT) {
        this.lastMonTranAMT = lastMonTranAMT;
    }


    /**
     * Gets the monStDev value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @return monStDev
     */
    public java.lang.String getMonStDev() {
        return monStDev;
    }


    /**
     * Sets the monStDev value for this SoapUpdateTransactionDataByLeadId.
     * 
     * @param monStDev
     */
    public void setMonStDev(java.lang.String monStDev) {
        this.monStDev = monStDev;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SoapUpdateTransactionDataByLeadId)) return false;
        SoapUpdateTransactionDataByLeadId other = (SoapUpdateTransactionDataByLeadId) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.lead_id==null && other.getLead_id()==null) || 
             (this.lead_id!=null &&
              this.lead_id.equals(other.getLead_id()))) &&
            ((this.region==null && other.getRegion()==null) || 
             (this.region!=null &&
              this.region.equals(other.getRegion()))) &&
            ((this.SICCode==null && other.getSICCode()==null) || 
             (this.SICCode!=null &&
              this.SICCode.equals(other.getSICCode()))) &&
            ((this.lastMonTranCNT==null && other.getLastMonTranCNT()==null) || 
             (this.lastMonTranCNT!=null &&
              this.lastMonTranCNT.equals(other.getLastMonTranCNT()))) &&
            ((this.dayAvgTranCNT==null && other.getDayAvgTranCNT()==null) || 
             (this.dayAvgTranCNT!=null &&
              this.dayAvgTranCNT.equals(other.getDayAvgTranCNT()))) &&
            ((this.dayAvgPerTranAMT==null && other.getDayAvgPerTranAMT()==null) || 
             (this.dayAvgPerTranAMT!=null &&
              this.dayAvgPerTranAMT.equals(other.getDayAvgPerTranAMT()))) &&
            ((this.procMonthlyVolume==null && other.getProcMonthlyVolume()==null) || 
             (this.procMonthlyVolume!=null &&
              this.procMonthlyVolume.equals(other.getProcMonthlyVolume()))) &&
            ((this.lastMonTranAMT==null && other.getLastMonTranAMT()==null) || 
             (this.lastMonTranAMT!=null &&
              this.lastMonTranAMT.equals(other.getLastMonTranAMT()))) &&
            ((this.monStDev==null && other.getMonStDev()==null) || 
             (this.monStDev!=null &&
              this.monStDev.equals(other.getMonStDev())));
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
        if (getLead_id() != null) {
            _hashCode += getLead_id().hashCode();
        }
        if (getRegion() != null) {
            _hashCode += getRegion().hashCode();
        }
        if (getSICCode() != null) {
            _hashCode += getSICCode().hashCode();
        }
        if (getLastMonTranCNT() != null) {
            _hashCode += getLastMonTranCNT().hashCode();
        }
        if (getDayAvgTranCNT() != null) {
            _hashCode += getDayAvgTranCNT().hashCode();
        }
        if (getDayAvgPerTranAMT() != null) {
            _hashCode += getDayAvgPerTranAMT().hashCode();
        }
        if (getProcMonthlyVolume() != null) {
            _hashCode += getProcMonthlyVolume().hashCode();
        }
        if (getLastMonTranAMT() != null) {
            _hashCode += getLastMonTranAMT().hashCode();
        }
        if (getMonStDev() != null) {
            _hashCode += getMonStDev().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapUpdateTransactionDataByLeadId.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.cardvalue.cn", "soapUpdateTransactionDataByLeadId"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lead_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lead_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("region");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Region"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SICCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SICCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastMonTranCNT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LastMonTranCNT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dayAvgTranCNT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DayAvgTranCNT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dayAvgPerTranAMT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DayAvgPerTranAMT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("procMonthlyVolume");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ProcMonthlyVolume"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastMonTranAMT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LastMonTranAMT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monStDev");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MonStDev"));
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
