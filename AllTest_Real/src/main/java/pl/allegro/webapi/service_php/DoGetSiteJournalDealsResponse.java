/**
 * DoGetSiteJournalDealsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pl.allegro.webapi.service_php;

public class DoGetSiteJournalDealsResponse  implements java.io.Serializable {
    private pl.allegro.webapi.service_php.SiteJournalDealsStruct[] siteJournalDeals;

    public DoGetSiteJournalDealsResponse() {
    }

    public DoGetSiteJournalDealsResponse(
           pl.allegro.webapi.service_php.SiteJournalDealsStruct[] siteJournalDeals) {
           this.siteJournalDeals = siteJournalDeals;
    }


    /**
     * Gets the siteJournalDeals value for this DoGetSiteJournalDealsResponse.
     * 
     * @return siteJournalDeals
     */
    public pl.allegro.webapi.service_php.SiteJournalDealsStruct[] getSiteJournalDeals() {
        return siteJournalDeals;
    }


    /**
     * Sets the siteJournalDeals value for this DoGetSiteJournalDealsResponse.
     * 
     * @param siteJournalDeals
     */
    public void setSiteJournalDeals(pl.allegro.webapi.service_php.SiteJournalDealsStruct[] siteJournalDeals) {
        this.siteJournalDeals = siteJournalDeals;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DoGetSiteJournalDealsResponse)) return false;
        DoGetSiteJournalDealsResponse other = (DoGetSiteJournalDealsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.siteJournalDeals==null && other.getSiteJournalDeals()==null) || 
             (this.siteJournalDeals!=null &&
              java.util.Arrays.equals(this.siteJournalDeals, other.getSiteJournalDeals())));
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
        if (getSiteJournalDeals() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSiteJournalDeals());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSiteJournalDeals(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DoGetSiteJournalDealsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", ">doGetSiteJournalDealsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siteJournalDeals");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "siteJournalDeals"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "SiteJournalDealsStruct"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "item"));
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
