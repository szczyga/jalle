/**
 * DoGetSellFormFieldsExtLimitResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pl.allegro.webapi.service_php;

public class DoGetSellFormFieldsExtLimitResponse  implements java.io.Serializable {
    private pl.allegro.webapi.service_php.SellFormType[] sellFormFields;

    private long verKey;

    private java.lang.String verStr;

    private int formFieldsCount;

    public DoGetSellFormFieldsExtLimitResponse() {
    }

    public DoGetSellFormFieldsExtLimitResponse(
           pl.allegro.webapi.service_php.SellFormType[] sellFormFields,
           long verKey,
           java.lang.String verStr,
           int formFieldsCount) {
           this.sellFormFields = sellFormFields;
           this.verKey = verKey;
           this.verStr = verStr;
           this.formFieldsCount = formFieldsCount;
    }


    /**
     * Gets the sellFormFields value for this DoGetSellFormFieldsExtLimitResponse.
     * 
     * @return sellFormFields
     */
    public pl.allegro.webapi.service_php.SellFormType[] getSellFormFields() {
        return sellFormFields;
    }


    /**
     * Sets the sellFormFields value for this DoGetSellFormFieldsExtLimitResponse.
     * 
     * @param sellFormFields
     */
    public void setSellFormFields(pl.allegro.webapi.service_php.SellFormType[] sellFormFields) {
        this.sellFormFields = sellFormFields;
    }


    /**
     * Gets the verKey value for this DoGetSellFormFieldsExtLimitResponse.
     * 
     * @return verKey
     */
    public long getVerKey() {
        return verKey;
    }


    /**
     * Sets the verKey value for this DoGetSellFormFieldsExtLimitResponse.
     * 
     * @param verKey
     */
    public void setVerKey(long verKey) {
        this.verKey = verKey;
    }


    /**
     * Gets the verStr value for this DoGetSellFormFieldsExtLimitResponse.
     * 
     * @return verStr
     */
    public java.lang.String getVerStr() {
        return verStr;
    }


    /**
     * Sets the verStr value for this DoGetSellFormFieldsExtLimitResponse.
     * 
     * @param verStr
     */
    public void setVerStr(java.lang.String verStr) {
        this.verStr = verStr;
    }


    /**
     * Gets the formFieldsCount value for this DoGetSellFormFieldsExtLimitResponse.
     * 
     * @return formFieldsCount
     */
    public int getFormFieldsCount() {
        return formFieldsCount;
    }


    /**
     * Sets the formFieldsCount value for this DoGetSellFormFieldsExtLimitResponse.
     * 
     * @param formFieldsCount
     */
    public void setFormFieldsCount(int formFieldsCount) {
        this.formFieldsCount = formFieldsCount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DoGetSellFormFieldsExtLimitResponse)) return false;
        DoGetSellFormFieldsExtLimitResponse other = (DoGetSellFormFieldsExtLimitResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sellFormFields==null && other.getSellFormFields()==null) || 
             (this.sellFormFields!=null &&
              java.util.Arrays.equals(this.sellFormFields, other.getSellFormFields()))) &&
            this.verKey == other.getVerKey() &&
            ((this.verStr==null && other.getVerStr()==null) || 
             (this.verStr!=null &&
              this.verStr.equals(other.getVerStr()))) &&
            this.formFieldsCount == other.getFormFieldsCount();
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
        if (getSellFormFields() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSellFormFields());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSellFormFields(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getVerKey()).hashCode();
        if (getVerStr() != null) {
            _hashCode += getVerStr().hashCode();
        }
        _hashCode += getFormFieldsCount();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DoGetSellFormFieldsExtLimitResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", ">doGetSellFormFieldsExtLimitResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sellFormFields");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "sellFormFields"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "SellFormType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verKey");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "verKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verStr");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "verStr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formFieldsCount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "formFieldsCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
