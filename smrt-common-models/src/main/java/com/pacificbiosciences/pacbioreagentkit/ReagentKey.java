//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.09 at 04:52:36 PM PDT 
//


package com.pacificbiosciences.pacbioreagentkit;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReagentKey.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReagentKey">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Base"/>
 *     &lt;enumeration value="DTT"/>
 *     &lt;enumeration value="DilBuffer"/>
 *     &lt;enumeration value="MineralOil"/>
 *     &lt;enumeration value="MIXED_DilBuffer"/>
 *     &lt;enumeration value="MIXED_OS"/>
 *     &lt;enumeration value="OSbuffer"/>
 *     &lt;enumeration value="OSenzyme"/>
 *     &lt;enumeration value="PhospholinkedNT"/>
 *     &lt;enumeration value="SABuffer"/>
 *     &lt;enumeration value="Spike"/>
 *     &lt;enumeration value="Streptavidin"/>
 *     &lt;enumeration value="SubstrateOS"/>
 *     &lt;enumeration value="TSQ"/>
 *     &lt;enumeration value="WashBuffer"/>
 *     &lt;enumeration value="WettingBuffer"/>
 *     &lt;enumeration value="PCA"/>
 *     &lt;enumeration value="PCD"/>
 *     &lt;enumeration value="Analog"/>
 *     &lt;enumeration value="Sample"/>
 *     &lt;enumeration value="PEGDilBuffer"/>
 *     &lt;enumeration value="ExtraBuffer"/>
 *     &lt;enumeration value="PrewetBuffer"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReagentKey")
@XmlEnum
public enum ReagentKey {

    @XmlEnumValue("Base")
    BASE("Base"),
    DTT("DTT"),
    @XmlEnumValue("DilBuffer")
    DIL_BUFFER("DilBuffer"),
    @XmlEnumValue("MineralOil")
    MINERAL_OIL("MineralOil"),
    @XmlEnumValue("MIXED_DilBuffer")
    MIXED_DIL_BUFFER("MIXED_DilBuffer"),
    MIXED_OS("MIXED_OS"),
    @XmlEnumValue("OSbuffer")
    O_SBUFFER("OSbuffer"),
    @XmlEnumValue("OSenzyme")
    O_SENZYME("OSenzyme"),
    @XmlEnumValue("PhospholinkedNT")
    PHOSPHOLINKED_NT("PhospholinkedNT"),
    @XmlEnumValue("SABuffer")
    SA_BUFFER("SABuffer"),
    @XmlEnumValue("Spike")
    SPIKE("Spike"),
    @XmlEnumValue("Streptavidin")
    STREPTAVIDIN("Streptavidin"),
    @XmlEnumValue("SubstrateOS")
    SUBSTRATE_OS("SubstrateOS"),
    TSQ("TSQ"),
    @XmlEnumValue("WashBuffer")
    WASH_BUFFER("WashBuffer"),
    @XmlEnumValue("WettingBuffer")
    WETTING_BUFFER("WettingBuffer"),
    PCA("PCA"),
    PCD("PCD"),
    @XmlEnumValue("Analog")
    ANALOG("Analog"),
    @XmlEnumValue("Sample")
    SAMPLE("Sample"),
    @XmlEnumValue("PEGDilBuffer")
    PEG_DIL_BUFFER("PEGDilBuffer"),
    @XmlEnumValue("ExtraBuffer")
    EXTRA_BUFFER("ExtraBuffer"),
    @XmlEnumValue("PrewetBuffer")
    PREWET_BUFFER("PrewetBuffer");
    private final String value;

    ReagentKey(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReagentKey fromValue(String v) {
        for (ReagentKey c: ReagentKey.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
