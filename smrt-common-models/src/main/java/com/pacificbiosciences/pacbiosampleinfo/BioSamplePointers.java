//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.06 at 03:16:33 PM PST 
//


package com.pacificbiosciences.pacbiosampleinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://pacificbiosciences.com/PacBioSampleInfo.xsd}BarcodedSamplePointers"/>
 *           &lt;element name="BioSamplePointer" type="{http://www.w3.org/2001/XMLSchema}IDREF"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "barcodedSamplePointers",
    "bioSamplePointer"
})
@XmlRootElement(name = "BioSamplePointers")
public class BioSamplePointers {

    @XmlElement(name = "BarcodedSamplePointers")
    protected BarcodedSamplePointers barcodedSamplePointers;
    @XmlElement(name = "BioSamplePointer")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object bioSamplePointer;

    /**
     * Gets the value of the barcodedSamplePointers property.
     * 
     * @return
     *     possible object is
     *     {@link BarcodedSamplePointers }
     *     
     */
    public BarcodedSamplePointers getBarcodedSamplePointers() {
        return barcodedSamplePointers;
    }

    /**
     * Sets the value of the barcodedSamplePointers property.
     * 
     * @param value
     *     allowed object is
     *     {@link BarcodedSamplePointers }
     *     
     */
    public void setBarcodedSamplePointers(BarcodedSamplePointers value) {
        this.barcodedSamplePointers = value;
    }

    /**
     * Gets the value of the bioSamplePointer property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getBioSamplePointer() {
        return bioSamplePointer;
    }

    /**
     * Sets the value of the bioSamplePointer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setBioSamplePointer(Object value) {
        this.bioSamplePointer = value;
    }

}
