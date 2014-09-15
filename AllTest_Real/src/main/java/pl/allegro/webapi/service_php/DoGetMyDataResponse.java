/**
 * DoGetMyDataResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pl.allegro.webapi.service_php;

public class DoGetMyDataResponse  implements java.io.Serializable {
    private pl.allegro.webapi.service_php.UserDataStruct userData;

    private pl.allegro.webapi.service_php.InvoiceDataStruct invoiceData;

    private pl.allegro.webapi.service_php.CompanyExtraDataStruct companyExtraData;

    private pl.allegro.webapi.service_php.CompanySecondAddressStruct companySecondAddress;

    private pl.allegro.webapi.service_php.PharmacyDataStruct pharmacyData;

    private pl.allegro.webapi.service_php.AlcoholDataStruct alcoholData;

    private pl.allegro.webapi.service_php.RelatedPersonsStruct relatedPersons;

    public DoGetMyDataResponse() {
    }

    public DoGetMyDataResponse(
           pl.allegro.webapi.service_php.UserDataStruct userData,
           pl.allegro.webapi.service_php.InvoiceDataStruct invoiceData,
           pl.allegro.webapi.service_php.CompanyExtraDataStruct companyExtraData,
           pl.allegro.webapi.service_php.CompanySecondAddressStruct companySecondAddress,
           pl.allegro.webapi.service_php.PharmacyDataStruct pharmacyData,
           pl.allegro.webapi.service_php.AlcoholDataStruct alcoholData,
           pl.allegro.webapi.service_php.RelatedPersonsStruct relatedPersons) {
           this.userData = userData;
           this.invoiceData = invoiceData;
           this.companyExtraData = companyExtraData;
           this.companySecondAddress = companySecondAddress;
           this.pharmacyData = pharmacyData;
           this.alcoholData = alcoholData;
           this.relatedPersons = relatedPersons;
    }


    /**
     * Gets the userData value for this DoGetMyDataResponse.
     * 
     * @return userData
     */
    public pl.allegro.webapi.service_php.UserDataStruct getUserData() {
        return userData;
    }


    /**
     * Sets the userData value for this DoGetMyDataResponse.
     * 
     * @param userData
     */
    public void setUserData(pl.allegro.webapi.service_php.UserDataStruct userData) {
        this.userData = userData;
    }


    /**
     * Gets the invoiceData value for this DoGetMyDataResponse.
     * 
     * @return invoiceData
     */
    public pl.allegro.webapi.service_php.InvoiceDataStruct getInvoiceData() {
        return invoiceData;
    }


    /**
     * Sets the invoiceData value for this DoGetMyDataResponse.
     * 
     * @param invoiceData
     */
    public void setInvoiceData(pl.allegro.webapi.service_php.InvoiceDataStruct invoiceData) {
        this.invoiceData = invoiceData;
    }


    /**
     * Gets the companyExtraData value for this DoGetMyDataResponse.
     * 
     * @return companyExtraData
     */
    public pl.allegro.webapi.service_php.CompanyExtraDataStruct getCompanyExtraData() {
        return companyExtraData;
    }


    /**
     * Sets the companyExtraData value for this DoGetMyDataResponse.
     * 
     * @param companyExtraData
     */
    public void setCompanyExtraData(pl.allegro.webapi.service_php.CompanyExtraDataStruct companyExtraData) {
        this.companyExtraData = companyExtraData;
    }


    /**
     * Gets the companySecondAddress value for this DoGetMyDataResponse.
     * 
     * @return companySecondAddress
     */
    public pl.allegro.webapi.service_php.CompanySecondAddressStruct getCompanySecondAddress() {
        return companySecondAddress;
    }


    /**
     * Sets the companySecondAddress value for this DoGetMyDataResponse.
     * 
     * @param companySecondAddress
     */
    public void setCompanySecondAddress(pl.allegro.webapi.service_php.CompanySecondAddressStruct companySecondAddress) {
        this.companySecondAddress = companySecondAddress;
    }


    /**
     * Gets the pharmacyData value for this DoGetMyDataResponse.
     * 
     * @return pharmacyData
     */
    public pl.allegro.webapi.service_php.PharmacyDataStruct getPharmacyData() {
        return pharmacyData;
    }


    /**
     * Sets the pharmacyData value for this DoGetMyDataResponse.
     * 
     * @param pharmacyData
     */
    public void setPharmacyData(pl.allegro.webapi.service_php.PharmacyDataStruct pharmacyData) {
        this.pharmacyData = pharmacyData;
    }


    /**
     * Gets the alcoholData value for this DoGetMyDataResponse.
     * 
     * @return alcoholData
     */
    public pl.allegro.webapi.service_php.AlcoholDataStruct getAlcoholData() {
        return alcoholData;
    }


    /**
     * Sets the alcoholData value for this DoGetMyDataResponse.
     * 
     * @param alcoholData
     */
    public void setAlcoholData(pl.allegro.webapi.service_php.AlcoholDataStruct alcoholData) {
        this.alcoholData = alcoholData;
    }


    /**
     * Gets the relatedPersons value for this DoGetMyDataResponse.
     * 
     * @return relatedPersons
     */
    public pl.allegro.webapi.service_php.RelatedPersonsStruct getRelatedPersons() {
        return relatedPersons;
    }


    /**
     * Sets the relatedPersons value for this DoGetMyDataResponse.
     * 
     * @param relatedPersons
     */
    public void setRelatedPersons(pl.allegro.webapi.service_php.RelatedPersonsStruct relatedPersons) {
        this.relatedPersons = relatedPersons;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DoGetMyDataResponse)) return false;
        DoGetMyDataResponse other = (DoGetMyDataResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.userData==null && other.getUserData()==null) || 
             (this.userData!=null &&
              this.userData.equals(other.getUserData()))) &&
            ((this.invoiceData==null && other.getInvoiceData()==null) || 
             (this.invoiceData!=null &&
              this.invoiceData.equals(other.getInvoiceData()))) &&
            ((this.companyExtraData==null && other.getCompanyExtraData()==null) || 
             (this.companyExtraData!=null &&
              this.companyExtraData.equals(other.getCompanyExtraData()))) &&
            ((this.companySecondAddress==null && other.getCompanySecondAddress()==null) || 
             (this.companySecondAddress!=null &&
              this.companySecondAddress.equals(other.getCompanySecondAddress()))) &&
            ((this.pharmacyData==null && other.getPharmacyData()==null) || 
             (this.pharmacyData!=null &&
              this.pharmacyData.equals(other.getPharmacyData()))) &&
            ((this.alcoholData==null && other.getAlcoholData()==null) || 
             (this.alcoholData!=null &&
              this.alcoholData.equals(other.getAlcoholData()))) &&
            ((this.relatedPersons==null && other.getRelatedPersons()==null) || 
             (this.relatedPersons!=null &&
              this.relatedPersons.equals(other.getRelatedPersons())));
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
        if (getUserData() != null) {
            _hashCode += getUserData().hashCode();
        }
        if (getInvoiceData() != null) {
            _hashCode += getInvoiceData().hashCode();
        }
        if (getCompanyExtraData() != null) {
            _hashCode += getCompanyExtraData().hashCode();
        }
        if (getCompanySecondAddress() != null) {
            _hashCode += getCompanySecondAddress().hashCode();
        }
        if (getPharmacyData() != null) {
            _hashCode += getPharmacyData().hashCode();
        }
        if (getAlcoholData() != null) {
            _hashCode += getAlcoholData().hashCode();
        }
        if (getRelatedPersons() != null) {
            _hashCode += getRelatedPersons().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DoGetMyDataResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", ">doGetMyDataResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userData");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "userData"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "UserDataStruct"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invoiceData");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "invoiceData"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "InvoiceDataStruct"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyExtraData");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "companyExtraData"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "CompanyExtraDataStruct"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companySecondAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "companySecondAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "CompanySecondAddressStruct"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pharmacyData");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "pharmacyData"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "PharmacyDataStruct"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alcoholData");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "alcoholData"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "AlcoholDataStruct"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relatedPersons");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "relatedPersons"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "RelatedPersonsStruct"));
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
