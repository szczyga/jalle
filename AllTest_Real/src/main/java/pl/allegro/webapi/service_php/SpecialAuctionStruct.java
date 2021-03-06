/**
 * SpecialAuctionStruct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pl.allegro.webapi.service_php;

public class SpecialAuctionStruct  implements java.io.Serializable {
    private long itId;

    private java.lang.String itName;

    private float itPrice;

    private float itBuyNowPrice;

    private int itBidCount;

    private int itFotoCount;

    private long itTimeLeft;

    private long itEndingTime;

    private int itCountry;

    private int itIsListingThumb;

    private int itIsEscrow;

    private long itSellerId;

    private float itSendCostPrice;

    private int itIsBoldTitle;

    private long itStartingTime;

    private int itIsAllegroStandard;

    private int itHasFreeShipping;

    private pl.allegro.webapi.service_php.AttribStruct[] itAttribsList;

    public SpecialAuctionStruct() {
    }

    public SpecialAuctionStruct(
           long itId,
           java.lang.String itName,
           float itPrice,
           float itBuyNowPrice,
           int itBidCount,
           int itFotoCount,
           long itTimeLeft,
           long itEndingTime,
           int itCountry,
           int itIsListingThumb,
           int itIsEscrow,
           long itSellerId,
           float itSendCostPrice,
           int itIsBoldTitle,
           long itStartingTime,
           int itIsAllegroStandard,
           int itHasFreeShipping,
           pl.allegro.webapi.service_php.AttribStruct[] itAttribsList) {
           this.itId = itId;
           this.itName = itName;
           this.itPrice = itPrice;
           this.itBuyNowPrice = itBuyNowPrice;
           this.itBidCount = itBidCount;
           this.itFotoCount = itFotoCount;
           this.itTimeLeft = itTimeLeft;
           this.itEndingTime = itEndingTime;
           this.itCountry = itCountry;
           this.itIsListingThumb = itIsListingThumb;
           this.itIsEscrow = itIsEscrow;
           this.itSellerId = itSellerId;
           this.itSendCostPrice = itSendCostPrice;
           this.itIsBoldTitle = itIsBoldTitle;
           this.itStartingTime = itStartingTime;
           this.itIsAllegroStandard = itIsAllegroStandard;
           this.itHasFreeShipping = itHasFreeShipping;
           this.itAttribsList = itAttribsList;
    }


    /**
     * Gets the itId value for this SpecialAuctionStruct.
     * 
     * @return itId
     */
    public long getItId() {
        return itId;
    }


    /**
     * Sets the itId value for this SpecialAuctionStruct.
     * 
     * @param itId
     */
    public void setItId(long itId) {
        this.itId = itId;
    }


    /**
     * Gets the itName value for this SpecialAuctionStruct.
     * 
     * @return itName
     */
    public java.lang.String getItName() {
        return itName;
    }


    /**
     * Sets the itName value for this SpecialAuctionStruct.
     * 
     * @param itName
     */
    public void setItName(java.lang.String itName) {
        this.itName = itName;
    }


    /**
     * Gets the itPrice value for this SpecialAuctionStruct.
     * 
     * @return itPrice
     */
    public float getItPrice() {
        return itPrice;
    }


    /**
     * Sets the itPrice value for this SpecialAuctionStruct.
     * 
     * @param itPrice
     */
    public void setItPrice(float itPrice) {
        this.itPrice = itPrice;
    }


    /**
     * Gets the itBuyNowPrice value for this SpecialAuctionStruct.
     * 
     * @return itBuyNowPrice
     */
    public float getItBuyNowPrice() {
        return itBuyNowPrice;
    }


    /**
     * Sets the itBuyNowPrice value for this SpecialAuctionStruct.
     * 
     * @param itBuyNowPrice
     */
    public void setItBuyNowPrice(float itBuyNowPrice) {
        this.itBuyNowPrice = itBuyNowPrice;
    }


    /**
     * Gets the itBidCount value for this SpecialAuctionStruct.
     * 
     * @return itBidCount
     */
    public int getItBidCount() {
        return itBidCount;
    }


    /**
     * Sets the itBidCount value for this SpecialAuctionStruct.
     * 
     * @param itBidCount
     */
    public void setItBidCount(int itBidCount) {
        this.itBidCount = itBidCount;
    }


    /**
     * Gets the itFotoCount value for this SpecialAuctionStruct.
     * 
     * @return itFotoCount
     */
    public int getItFotoCount() {
        return itFotoCount;
    }


    /**
     * Sets the itFotoCount value for this SpecialAuctionStruct.
     * 
     * @param itFotoCount
     */
    public void setItFotoCount(int itFotoCount) {
        this.itFotoCount = itFotoCount;
    }


    /**
     * Gets the itTimeLeft value for this SpecialAuctionStruct.
     * 
     * @return itTimeLeft
     */
    public long getItTimeLeft() {
        return itTimeLeft;
    }


    /**
     * Sets the itTimeLeft value for this SpecialAuctionStruct.
     * 
     * @param itTimeLeft
     */
    public void setItTimeLeft(long itTimeLeft) {
        this.itTimeLeft = itTimeLeft;
    }


    /**
     * Gets the itEndingTime value for this SpecialAuctionStruct.
     * 
     * @return itEndingTime
     */
    public long getItEndingTime() {
        return itEndingTime;
    }


    /**
     * Sets the itEndingTime value for this SpecialAuctionStruct.
     * 
     * @param itEndingTime
     */
    public void setItEndingTime(long itEndingTime) {
        this.itEndingTime = itEndingTime;
    }


    /**
     * Gets the itCountry value for this SpecialAuctionStruct.
     * 
     * @return itCountry
     */
    public int getItCountry() {
        return itCountry;
    }


    /**
     * Sets the itCountry value for this SpecialAuctionStruct.
     * 
     * @param itCountry
     */
    public void setItCountry(int itCountry) {
        this.itCountry = itCountry;
    }


    /**
     * Gets the itIsListingThumb value for this SpecialAuctionStruct.
     * 
     * @return itIsListingThumb
     */
    public int getItIsListingThumb() {
        return itIsListingThumb;
    }


    /**
     * Sets the itIsListingThumb value for this SpecialAuctionStruct.
     * 
     * @param itIsListingThumb
     */
    public void setItIsListingThumb(int itIsListingThumb) {
        this.itIsListingThumb = itIsListingThumb;
    }


    /**
     * Gets the itIsEscrow value for this SpecialAuctionStruct.
     * 
     * @return itIsEscrow
     */
    public int getItIsEscrow() {
        return itIsEscrow;
    }


    /**
     * Sets the itIsEscrow value for this SpecialAuctionStruct.
     * 
     * @param itIsEscrow
     */
    public void setItIsEscrow(int itIsEscrow) {
        this.itIsEscrow = itIsEscrow;
    }


    /**
     * Gets the itSellerId value for this SpecialAuctionStruct.
     * 
     * @return itSellerId
     */
    public long getItSellerId() {
        return itSellerId;
    }


    /**
     * Sets the itSellerId value for this SpecialAuctionStruct.
     * 
     * @param itSellerId
     */
    public void setItSellerId(long itSellerId) {
        this.itSellerId = itSellerId;
    }


    /**
     * Gets the itSendCostPrice value for this SpecialAuctionStruct.
     * 
     * @return itSendCostPrice
     */
    public float getItSendCostPrice() {
        return itSendCostPrice;
    }


    /**
     * Sets the itSendCostPrice value for this SpecialAuctionStruct.
     * 
     * @param itSendCostPrice
     */
    public void setItSendCostPrice(float itSendCostPrice) {
        this.itSendCostPrice = itSendCostPrice;
    }


    /**
     * Gets the itIsBoldTitle value for this SpecialAuctionStruct.
     * 
     * @return itIsBoldTitle
     */
    public int getItIsBoldTitle() {
        return itIsBoldTitle;
    }


    /**
     * Sets the itIsBoldTitle value for this SpecialAuctionStruct.
     * 
     * @param itIsBoldTitle
     */
    public void setItIsBoldTitle(int itIsBoldTitle) {
        this.itIsBoldTitle = itIsBoldTitle;
    }


    /**
     * Gets the itStartingTime value for this SpecialAuctionStruct.
     * 
     * @return itStartingTime
     */
    public long getItStartingTime() {
        return itStartingTime;
    }


    /**
     * Sets the itStartingTime value for this SpecialAuctionStruct.
     * 
     * @param itStartingTime
     */
    public void setItStartingTime(long itStartingTime) {
        this.itStartingTime = itStartingTime;
    }


    /**
     * Gets the itIsAllegroStandard value for this SpecialAuctionStruct.
     * 
     * @return itIsAllegroStandard
     */
    public int getItIsAllegroStandard() {
        return itIsAllegroStandard;
    }


    /**
     * Sets the itIsAllegroStandard value for this SpecialAuctionStruct.
     * 
     * @param itIsAllegroStandard
     */
    public void setItIsAllegroStandard(int itIsAllegroStandard) {
        this.itIsAllegroStandard = itIsAllegroStandard;
    }


    /**
     * Gets the itHasFreeShipping value for this SpecialAuctionStruct.
     * 
     * @return itHasFreeShipping
     */
    public int getItHasFreeShipping() {
        return itHasFreeShipping;
    }


    /**
     * Sets the itHasFreeShipping value for this SpecialAuctionStruct.
     * 
     * @param itHasFreeShipping
     */
    public void setItHasFreeShipping(int itHasFreeShipping) {
        this.itHasFreeShipping = itHasFreeShipping;
    }


    /**
     * Gets the itAttribsList value for this SpecialAuctionStruct.
     * 
     * @return itAttribsList
     */
    public pl.allegro.webapi.service_php.AttribStruct[] getItAttribsList() {
        return itAttribsList;
    }


    /**
     * Sets the itAttribsList value for this SpecialAuctionStruct.
     * 
     * @param itAttribsList
     */
    public void setItAttribsList(pl.allegro.webapi.service_php.AttribStruct[] itAttribsList) {
        this.itAttribsList = itAttribsList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SpecialAuctionStruct)) return false;
        SpecialAuctionStruct other = (SpecialAuctionStruct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.itId == other.getItId() &&
            ((this.itName==null && other.getItName()==null) || 
             (this.itName!=null &&
              this.itName.equals(other.getItName()))) &&
            this.itPrice == other.getItPrice() &&
            this.itBuyNowPrice == other.getItBuyNowPrice() &&
            this.itBidCount == other.getItBidCount() &&
            this.itFotoCount == other.getItFotoCount() &&
            this.itTimeLeft == other.getItTimeLeft() &&
            this.itEndingTime == other.getItEndingTime() &&
            this.itCountry == other.getItCountry() &&
            this.itIsListingThumb == other.getItIsListingThumb() &&
            this.itIsEscrow == other.getItIsEscrow() &&
            this.itSellerId == other.getItSellerId() &&
            this.itSendCostPrice == other.getItSendCostPrice() &&
            this.itIsBoldTitle == other.getItIsBoldTitle() &&
            this.itStartingTime == other.getItStartingTime() &&
            this.itIsAllegroStandard == other.getItIsAllegroStandard() &&
            this.itHasFreeShipping == other.getItHasFreeShipping() &&
            ((this.itAttribsList==null && other.getItAttribsList()==null) || 
             (this.itAttribsList!=null &&
              java.util.Arrays.equals(this.itAttribsList, other.getItAttribsList())));
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
        _hashCode += new Long(getItId()).hashCode();
        if (getItName() != null) {
            _hashCode += getItName().hashCode();
        }
        _hashCode += new Float(getItPrice()).hashCode();
        _hashCode += new Float(getItBuyNowPrice()).hashCode();
        _hashCode += getItBidCount();
        _hashCode += getItFotoCount();
        _hashCode += new Long(getItTimeLeft()).hashCode();
        _hashCode += new Long(getItEndingTime()).hashCode();
        _hashCode += getItCountry();
        _hashCode += getItIsListingThumb();
        _hashCode += getItIsEscrow();
        _hashCode += new Long(getItSellerId()).hashCode();
        _hashCode += new Float(getItSendCostPrice()).hashCode();
        _hashCode += getItIsBoldTitle();
        _hashCode += new Long(getItStartingTime()).hashCode();
        _hashCode += getItIsAllegroStandard();
        _hashCode += getItHasFreeShipping();
        if (getItAttribsList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItAttribsList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItAttribsList(), i);
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
        new org.apache.axis.description.TypeDesc(SpecialAuctionStruct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "SpecialAuctionStruct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itName");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itBuyNowPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itBuyNowPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itBidCount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itBidCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itFotoCount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itFotoCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itTimeLeft");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itTimeLeft"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itEndingTime");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itEndingTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itCountry");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itCountry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itIsListingThumb");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itIsListingThumb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itIsEscrow");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itIsEscrow"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itSellerId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itSellerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itSendCostPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itSendCostPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itIsBoldTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itIsBoldTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itStartingTime");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itStartingTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itIsAllegroStandard");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itIsAllegroStandard"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itHasFreeShipping");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itHasFreeShipping"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itAttribsList");
        elemField.setXmlName(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "itAttribsList"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://webapi.allegro.pl/service.php", "AttribStruct"));
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
