/**
 * DoGetMyPaymentsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pl.allegro.webapi.service_php;

public class DoGetMyPaymentsResponse  implements java.io.Serializable {
    private pl.allegro.webapi.service_php.UserPaymentStruct[] payTransPayment;

    public DoGetMyPaymentsResponse() {
    }

    public DoGetMyPaymentsResponse(
           pl.allegro.webapi.service_php.UserPaymentStruct[] payTransPayment) {
           this.payTransPayment = payTransPayment;
    }


    /**
     * Gets the payTransPayment value for this DoGetMyPaymentsResponse.
     * 
     * @return payTransPayment
     */
    public pl.allegro.webapi.service_php.UserPaymentStruct[] getPayTransPayment() {
        return payTransPayment;
    }


    /**
     * Sets the payTransPayment value for this DoGetMyPaymentsResponse.
     * 
     * @param payTransPayment
     */
    public void setPayTransPayment(pl.allegro.webapi.service_php.UserPaymentStruct[] payTransPayment) {
        this.payTransPayment = payTransPayment;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DoGetMyPaymentsResponse)) return false;
        DoGetMyPaymentsResponse other = (DoGetMyPaymentsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.payTransPayment==null && other.getPayTransPayment()==null) || 
             (this.payTransPayment!=null &&
              java.util.Arrays.equals(this.payTransPayment, other.getPayTransPayment())));
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
        if (getPayTransPayment() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPayTransPayment());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPayTransPayment(), i);
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
        new org.apache.axis.description.TypeDesc(DoGetMyPaymentsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", ">doGetMyPaymentsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payTransPayment");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "payTransPayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "UserPaymentStruct"));
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
