/**
 * NotSoldFilterOptionsStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pl.allegro.webapi.service_php;

public class NotSoldFilterOptionsStruct  implements java.io.Serializable {
    private java.lang.Integer filterFormat;

    private java.lang.Integer filterFromEnd;

    private java.lang.Integer filterAutoListing;

    private pl.allegro.webapi.service_php.FilterPriceStruct filterPrice;

    public NotSoldFilterOptionsStruct() {
    }

    public NotSoldFilterOptionsStruct(
           java.lang.Integer filterFormat,
           java.lang.Integer filterFromEnd,
           java.lang.Integer filterAutoListing,
           pl.allegro.webapi.service_php.FilterPriceStruct filterPrice) {
           this.filterFormat = filterFormat;
           this.filterFromEnd = filterFromEnd;
           this.filterAutoListing = filterAutoListing;
           this.filterPrice = filterPrice;
    }


    /**
     * Gets the filterFormat value for this NotSoldFilterOptionsStruct.
     * 
     * @return filterFormat
     */
    public java.lang.Integer getFilterFormat() {
        return filterFormat;
    }


    /**
     * Sets the filterFormat value for this NotSoldFilterOptionsStruct.
     * 
     * @param filterFormat
     */
    public void setFilterFormat(java.lang.Integer filterFormat) {
        this.filterFormat = filterFormat;
    }


    /**
     * Gets the filterFromEnd value for this NotSoldFilterOptionsStruct.
     * 
     * @return filterFromEnd
     */
    public java.lang.Integer getFilterFromEnd() {
        return filterFromEnd;
    }


    /**
     * Sets the filterFromEnd value for this NotSoldFilterOptionsStruct.
     * 
     * @param filterFromEnd
     */
    public void setFilterFromEnd(java.lang.Integer filterFromEnd) {
        this.filterFromEnd = filterFromEnd;
    }


    /**
     * Gets the filterAutoListing value for this NotSoldFilterOptionsStruct.
     * 
     * @return filterAutoListing
     */
    public java.lang.Integer getFilterAutoListing() {
        return filterAutoListing;
    }


    /**
     * Sets the filterAutoListing value for this NotSoldFilterOptionsStruct.
     * 
     * @param filterAutoListing
     */
    public void setFilterAutoListing(java.lang.Integer filterAutoListing) {
        this.filterAutoListing = filterAutoListing;
    }


    /**
     * Gets the filterPrice value for this NotSoldFilterOptionsStruct.
     * 
     * @return filterPrice
     */
    public pl.allegro.webapi.service_php.FilterPriceStruct getFilterPrice() {
        return filterPrice;
    }


    /**
     * Sets the filterPrice value for this NotSoldFilterOptionsStruct.
     * 
     * @param filterPrice
     */
    public void setFilterPrice(pl.allegro.webapi.service_php.FilterPriceStruct filterPrice) {
        this.filterPrice = filterPrice;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NotSoldFilterOptionsStruct)) return false;
        NotSoldFilterOptionsStruct other = (NotSoldFilterOptionsStruct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.filterFormat==null && other.getFilterFormat()==null) || 
             (this.filterFormat!=null &&
              this.filterFormat.equals(other.getFilterFormat()))) &&
            ((this.filterFromEnd==null && other.getFilterFromEnd()==null) || 
             (this.filterFromEnd!=null &&
              this.filterFromEnd.equals(other.getFilterFromEnd()))) &&
            ((this.filterAutoListing==null && other.getFilterAutoListing()==null) || 
             (this.filterAutoListing!=null &&
              this.filterAutoListing.equals(other.getFilterAutoListing()))) &&
            ((this.filterPrice==null && other.getFilterPrice()==null) || 
             (this.filterPrice!=null &&
              this.filterPrice.equals(other.getFilterPrice())));
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
        if (getFilterFormat() != null) {
            _hashCode += getFilterFormat().hashCode();
        }
        if (getFilterFromEnd() != null) {
            _hashCode += getFilterFromEnd().hashCode();
        }
        if (getFilterAutoListing() != null) {
            _hashCode += getFilterAutoListing().hashCode();
        }
        if (getFilterPrice() != null) {
            _hashCode += getFilterPrice().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NotSoldFilterOptionsStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "NotSoldFilterOptionsStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filterFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "filterFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filterFromEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "filterFromEnd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filterAutoListing");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "filterAutoListing"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filterPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "filterPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "FilterPriceStruct"));
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
