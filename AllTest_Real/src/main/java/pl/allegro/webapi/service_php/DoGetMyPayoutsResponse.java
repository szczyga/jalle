/**
 * DoGetMyPayoutsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pl.allegro.webapi.service_php;

public class DoGetMyPayoutsResponse  implements java.io.Serializable {
    private pl.allegro.webapi.service_php.UserPayoutStruct[] payTransPayout;

    public DoGetMyPayoutsResponse() {
    }

    public DoGetMyPayoutsResponse(
           pl.allegro.webapi.service_php.UserPayoutStruct[] payTransPayout) {
           this.payTransPayout = payTransPayout;
    }


    /**
     * Gets the payTransPayout value for this DoGetMyPayoutsResponse.
     * 
     * @return payTransPayout
     */
    public pl.allegro.webapi.service_php.UserPayoutStruct[] getPayTransPayout() {
        return payTransPayout;
    }


    /**
     * Sets the payTransPayout value for this DoGetMyPayoutsResponse.
     * 
     * @param payTransPayout
     */
    public void setPayTransPayout(pl.allegro.webapi.service_php.UserPayoutStruct[] payTransPayout) {
        this.payTransPayout = payTransPayout;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DoGetMyPayoutsResponse)) return false;
        DoGetMyPayoutsResponse other = (DoGetMyPayoutsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.payTransPayout==null && other.getPayTransPayout()==null) || 
             (this.payTransPayout!=null &&
              java.util.Arrays.equals(this.payTransPayout, other.getPayTransPayout())));
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
        if (getPayTransPayout() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPayTransPayout());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPayTransPayout(), i);
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
        new org.apache.axis.description.TypeDesc(DoGetMyPayoutsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", ">doGetMyPayoutsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payTransPayout");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "payTransPayout"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "UserPayoutStruct"));
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
