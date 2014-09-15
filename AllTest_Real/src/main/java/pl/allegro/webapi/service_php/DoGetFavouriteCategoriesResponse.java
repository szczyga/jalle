/**
 * DoGetFavouriteCategoriesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pl.allegro.webapi.service_php;

public class DoGetFavouriteCategoriesResponse  implements java.io.Serializable {
    private pl.allegro.webapi.service_php.FavouritesCategoriesStruct[] sFavouriteCategoriesList;

    public DoGetFavouriteCategoriesResponse() {
    }

    public DoGetFavouriteCategoriesResponse(
           pl.allegro.webapi.service_php.FavouritesCategoriesStruct[] sFavouriteCategoriesList) {
           this.sFavouriteCategoriesList = sFavouriteCategoriesList;
    }


    /**
     * Gets the sFavouriteCategoriesList value for this DoGetFavouriteCategoriesResponse.
     * 
     * @return sFavouriteCategoriesList
     */
    public pl.allegro.webapi.service_php.FavouritesCategoriesStruct[] getSFavouriteCategoriesList() {
        return sFavouriteCategoriesList;
    }


    /**
     * Sets the sFavouriteCategoriesList value for this DoGetFavouriteCategoriesResponse.
     * 
     * @param sFavouriteCategoriesList
     */
    public void setSFavouriteCategoriesList(pl.allegro.webapi.service_php.FavouritesCategoriesStruct[] sFavouriteCategoriesList) {
        this.sFavouriteCategoriesList = sFavouriteCategoriesList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DoGetFavouriteCategoriesResponse)) return false;
        DoGetFavouriteCategoriesResponse other = (DoGetFavouriteCategoriesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sFavouriteCategoriesList==null && other.getSFavouriteCategoriesList()==null) || 
             (this.sFavouriteCategoriesList!=null &&
              java.util.Arrays.equals(this.sFavouriteCategoriesList, other.getSFavouriteCategoriesList())));
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
        if (getSFavouriteCategoriesList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSFavouriteCategoriesList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSFavouriteCategoriesList(), i);
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
        new org.apache.axis.description.TypeDesc(DoGetFavouriteCategoriesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", ">doGetFavouriteCategoriesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SFavouriteCategoriesList");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "sFavouriteCategoriesList"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "FavouritesCategoriesStruct"));
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
