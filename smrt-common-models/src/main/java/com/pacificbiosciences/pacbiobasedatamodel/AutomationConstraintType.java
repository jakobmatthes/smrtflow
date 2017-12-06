//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: XXX
//


package com.pacificbiosciences.pacbiobasedatamodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.pacificbiosciences.pacbioautomationconstraints.AutomationConstraint;


/**
 * This data type defines constraints that an automation has.  The information here, along with the availability of an exclusionary list of automations in the PartNumberType, allows for defining a robust compatibility matrix.
 * 
 * <p>Java class for AutomationConstraintType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AutomationConstraintType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://pacificbiosciences.com/PacBioBaseDataModel.xsd}BaseEntityType">
 *       &lt;sequence>
 *         &lt;element name="Automations" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Automation" type="{http://pacificbiosciences.com/PacBioBaseDataModel.xsd}AutomationType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="SupportsCellReuse" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="SupportsStageStart" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="MaxCollectionsPerCell" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MinMovieLength" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MaxMovieLength" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MinInsertSize" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MaxInsertSize" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AutomationConstraintType", propOrder = {
    "automations"
})
@XmlSeeAlso({
    AutomationConstraint.class
})
public class AutomationConstraintType
    extends BaseEntityType
{

    @XmlElement(name = "Automations")
    protected AutomationConstraintType.Automations automations;
    @XmlAttribute(name = "SupportsCellReuse")
    protected Boolean supportsCellReuse;
    @XmlAttribute(name = "SupportsStageStart")
    protected Boolean supportsStageStart;
    @XmlAttribute(name = "MaxCollectionsPerCell")
    protected Integer maxCollectionsPerCell;
    @XmlAttribute(name = "MinMovieLength")
    protected Integer minMovieLength;
    @XmlAttribute(name = "MaxMovieLength")
    protected Integer maxMovieLength;
    @XmlAttribute(name = "MinInsertSize")
    protected Integer minInsertSize;
    @XmlAttribute(name = "MaxInsertSize")
    protected Integer maxInsertSize;

    /**
     * Gets the value of the automations property.
     * 
     * @return
     *     possible object is
     *     {@link AutomationConstraintType.Automations }
     *     
     */
    public AutomationConstraintType.Automations getAutomations() {
        return automations;
    }

    /**
     * Sets the value of the automations property.
     * 
     * @param value
     *     allowed object is
     *     {@link AutomationConstraintType.Automations }
     *     
     */
    public void setAutomations(AutomationConstraintType.Automations value) {
        this.automations = value;
    }

    /**
     * Gets the value of the supportsCellReuse property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportsCellReuse() {
        return supportsCellReuse;
    }

    /**
     * Sets the value of the supportsCellReuse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportsCellReuse(Boolean value) {
        this.supportsCellReuse = value;
    }

    /**
     * Gets the value of the supportsStageStart property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportsStageStart() {
        return supportsStageStart;
    }

    /**
     * Sets the value of the supportsStageStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportsStageStart(Boolean value) {
        this.supportsStageStart = value;
    }

    /**
     * Gets the value of the maxCollectionsPerCell property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxCollectionsPerCell() {
        return maxCollectionsPerCell;
    }

    /**
     * Sets the value of the maxCollectionsPerCell property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxCollectionsPerCell(Integer value) {
        this.maxCollectionsPerCell = value;
    }

    /**
     * Gets the value of the minMovieLength property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinMovieLength() {
        return minMovieLength;
    }

    /**
     * Sets the value of the minMovieLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinMovieLength(Integer value) {
        this.minMovieLength = value;
    }

    /**
     * Gets the value of the maxMovieLength property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxMovieLength() {
        return maxMovieLength;
    }

    /**
     * Sets the value of the maxMovieLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxMovieLength(Integer value) {
        this.maxMovieLength = value;
    }

    /**
     * Gets the value of the minInsertSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinInsertSize() {
        return minInsertSize;
    }

    /**
     * Sets the value of the minInsertSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinInsertSize(Integer value) {
        this.minInsertSize = value;
    }

    /**
     * Gets the value of the maxInsertSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxInsertSize() {
        return maxInsertSize;
    }

    /**
     * Sets the value of the maxInsertSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxInsertSize(Integer value) {
        this.maxInsertSize = value;
    }


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
     *         &lt;element name="Automation" type="{http://pacificbiosciences.com/PacBioBaseDataModel.xsd}AutomationType" maxOccurs="unbounded"/>
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
        "automation"
    })
    public static class Automations {

        @XmlElement(name = "Automation", required = true)
        protected List<AutomationType> automation;

        /**
         * Gets the value of the automation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the automation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAutomation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AutomationType }
         * 
         * 
         */
        public List<AutomationType> getAutomation() {
            if (automation == null) {
                automation = new ArrayList<AutomationType>();
            }
            return this.automation;
        }

    }

}
