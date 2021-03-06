/**
 * PostBuyFormItemDealsStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pl.allegro.webapi.service_php;

public class PostBuyFormItemDealsStruct  implements java.io.Serializable {
    private long dealId;

    private float dealFinalPrice;

    private int dealQuantity;

    private java.util.Calendar dealDate;

    private boolean dealWasDiscounted;

    public PostBuyFormItemDealsStruct() {
    }

    public PostBuyFormItemDealsStruct(
           long dealId,
           float dealFinalPrice,
           int dealQuantity,
           java.util.Calendar dealDate,
           boolean dealWasDiscounted) {
           this.dealId = dealId;
           this.dealFinalPrice = dealFinalPrice;
           this.dealQuantity = dealQuantity;
           this.dealDate = dealDate;
           this.dealWasDiscounted = dealWasDiscounted;
    }


    /**
     * Gets the dealId value for this PostBuyFormItemDealsStruct.
     * 
     * @return dealId
     */
    public long getDealId() {
        return dealId;
    }


    /**
     * Sets the dealId value for this PostBuyFormItemDealsStruct.
     * 
     * @param dealId
     */
    public void setDealId(long dealId) {
        this.dealId = dealId;
    }


    /**
     * Gets the dealFinalPrice value for this PostBuyFormItemDealsStruct.
     * 
     * @return dealFinalPrice
     */
    public float getDealFinalPrice() {
        return dealFinalPrice;
    }


    /**
     * Sets the dealFinalPrice value for this PostBuyFormItemDealsStruct.
     * 
     * @param dealFinalPrice
     */
    public void setDealFinalPrice(float dealFinalPrice) {
        this.dealFinalPrice = dealFinalPrice;
    }


    /**
     * Gets the dealQuantity value for this PostBuyFormItemDealsStruct.
     * 
     * @return dealQuantity
     */
    public int getDealQuantity() {
        return dealQuantity;
    }


    /**
     * Sets the dealQuantity value for this PostBuyFormItemDealsStruct.
     * 
     * @param dealQuantity
     */
    public void setDealQuantity(int dealQuantity) {
        this.dealQuantity = dealQuantity;
    }


    /**
     * Gets the dealDate value for this PostBuyFormItemDealsStruct.
     * 
     * @return dealDate
     */
    public java.util.Calendar getDealDate() {
        return dealDate;
    }


    /**
     * Sets the dealDate value for this PostBuyFormItemDealsStruct.
     * 
     * @param dealDate
     */
    public void setDealDate(java.util.Calendar dealDate) {
        this.dealDate = dealDate;
    }


    /**
     * Gets the dealWasDiscounted value for this PostBuyFormItemDealsStruct.
     * 
     * @return dealWasDiscounted
     */
    public boolean isDealWasDiscounted() {
        return dealWasDiscounted;
    }


    /**
     * Sets the dealWasDiscounted value for this PostBuyFormItemDealsStruct.
     * 
     * @param dealWasDiscounted
     */
    public void setDealWasDiscounted(boolean dealWasDiscounted) {
        this.dealWasDiscounted = dealWasDiscounted;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PostBuyFormItemDealsStruct)) return false;
        PostBuyFormItemDealsStruct other = (PostBuyFormItemDealsStruct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.dealId == other.getDealId() &&
            this.dealFinalPrice == other.getDealFinalPrice() &&
            this.dealQuantity == other.getDealQuantity() &&
            ((this.dealDate==null && other.getDealDate()==null) || 
             (this.dealDate!=null &&
              this.dealDate.equals(other.getDealDate()))) &&
            this.dealWasDiscounted == other.isDealWasDiscounted();
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
        _hashCode += new Long(getDealId()).hashCode();
        _hashCode += new Float(getDealFinalPrice()).hashCode();
        _hashCode += getDealQuantity();
        if (getDealDate() != null) {
            _hashCode += getDealDate().hashCode();
        }
        _hashCode += (isDealWasDiscounted() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PostBuyFormItemDealsStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "PostBuyFormItemDealsStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dealId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "dealId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dealFinalPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "dealFinalPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dealQuantity");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "dealQuantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dealDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "dealDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dealWasDiscounted");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "dealWasDiscounted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
