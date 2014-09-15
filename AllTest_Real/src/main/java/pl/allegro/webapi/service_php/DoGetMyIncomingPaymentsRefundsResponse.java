/**
 * DoGetMyIncomingPaymentsRefundsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pl.allegro.webapi.service_php;

public class DoGetMyIncomingPaymentsRefundsResponse  implements java.io.Serializable {
    private pl.allegro.webapi.service_php.UserIncomingPaymentRefundsStruct[] payTransIncomeRefunds;

    public DoGetMyIncomingPaymentsRefundsResponse() {
    }

    public DoGetMyIncomingPaymentsRefundsResponse(
           pl.allegro.webapi.service_php.UserIncomingPaymentRefundsStruct[] payTransIncomeRefunds) {
           this.payTransIncomeRefunds = payTransIncomeRefunds;
    }


    /**
     * Gets the payTransIncomeRefunds value for this DoGetMyIncomingPaymentsRefundsResponse.
     * 
     * @return payTransIncomeRefunds
     */
    public pl.allegro.webapi.service_php.UserIncomingPaymentRefundsStruct[] getPayTransIncomeRefunds() {
        return payTransIncomeRefunds;
    }


    /**
     * Sets the payTransIncomeRefunds value for this DoGetMyIncomingPaymentsRefundsResponse.
     * 
     * @param payTransIncomeRefunds
     */
    public void setPayTransIncomeRefunds(pl.allegro.webapi.service_php.UserIncomingPaymentRefundsStruct[] payTransIncomeRefunds) {
        this.payTransIncomeRefunds = payTransIncomeRefunds;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DoGetMyIncomingPaymentsRefundsResponse)) return false;
        DoGetMyIncomingPaymentsRefundsResponse other = (DoGetMyIncomingPaymentsRefundsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.payTransIncomeRefunds==null && other.getPayTransIncomeRefunds()==null) || 
             (this.payTransIncomeRefunds!=null &&
              java.util.Arrays.equals(this.payTransIncomeRefunds, other.getPayTransIncomeRefunds())));
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
        if (getPayTransIncomeRefunds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPayTransIncomeRefunds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPayTransIncomeRefunds(), i);
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
        new org.apache.axis.description.TypeDesc(DoGetMyIncomingPaymentsRefundsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", ">doGetMyIncomingPaymentsRefundsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payTransIncomeRefunds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "payTransIncomeRefunds"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "UserIncomingPaymentRefundsStruct"));
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
