//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: XXX
//


package com.pacificbiosciences.pacbiodatasets;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BarcodeSetMetadataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BarcodeSetMetadataType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://pacificbiosciences.com/PacBioDatasets.xsd}DataSetMetadataType">
 *       &lt;sequence>
 *         &lt;element name="BarcodeConstruction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BarcodeSetMetadataType", propOrder = {
    "barcodeConstruction"
})
public class BarcodeSetMetadataType
    extends DataSetMetadataType
{

    @XmlElement(name = "BarcodeConstruction", required = true)
    protected String barcodeConstruction;

    /**
     * Gets the value of the barcodeConstruction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarcodeConstruction() {
        return barcodeConstruction;
    }

    /**
     * Sets the value of the barcodeConstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarcodeConstruction(String value) {
        this.barcodeConstruction = value;
    }

}
