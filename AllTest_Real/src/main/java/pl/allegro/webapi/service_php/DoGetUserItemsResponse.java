/**
 * DoGetUserItemsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pl.allegro.webapi.service_php;

public class DoGetUserItemsResponse  implements java.io.Serializable {
    private pl.allegro.webapi.service_php.UserItemList[] userItemList;

    private int userItemCount;

    public DoGetUserItemsResponse() {
    }

    public DoGetUserItemsResponse(
           pl.allegro.webapi.service_php.UserItemList[] userItemList,
           int userItemCount) {
           this.userItemList = userItemList;
           this.userItemCount = userItemCount;
    }


    /**
     * Gets the userItemList value for this DoGetUserItemsResponse.
     * 
     * @return userItemList
     */
    public pl.allegro.webapi.service_php.UserItemList[] getUserItemList() {
        return userItemList;
    }


    /**
     * Sets the userItemList value for this DoGetUserItemsResponse.
     * 
     * @param userItemList
     */
    public void setUserItemList(pl.allegro.webapi.service_php.UserItemList[] userItemList) {
        this.userItemList = userItemList;
    }


    /**
     * Gets the userItemCount value for this DoGetUserItemsResponse.
     * 
     * @return userItemCount
     */
    public int getUserItemCount() {
        return userItemCount;
    }


    /**
     * Sets the userItemCount value for this DoGetUserItemsResponse.
     * 
     * @param userItemCount
     */
    public void setUserItemCount(int userItemCount) {
        this.userItemCount = userItemCount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DoGetUserItemsResponse)) return false;
        DoGetUserItemsResponse other = (DoGetUserItemsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.userItemList==null && other.getUserItemList()==null) || 
             (this.userItemList!=null &&
              java.util.Arrays.equals(this.userItemList, other.getUserItemList()))) &&
            this.userItemCount == other.getUserItemCount();
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
        if (getUserItemList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUserItemList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUserItemList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getUserItemCount();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DoGetUserItemsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", ">doGetUserItemsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userItemList");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "userItemList"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "UserItemList"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userItemCount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "userItemCount"));
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
