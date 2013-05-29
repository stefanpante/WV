
package com.microsoft.research;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Conference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Conference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CFP" type="{http://research.microsoft.com}CFPInfo" minOccurs="0"/>
 *         &lt;element name="CitationCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="EndYear" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="FullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HomepageURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="PublicationCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="ResearchInterestDomain" type="{http://research.microsoft.com}ArrayOfDomain" minOccurs="0"/>
 *         &lt;element name="ShortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartYear" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Conference", propOrder = {
    "cfp",
    "citationCount",
    "endYear",
    "fullName",
    "homepageURL",
    "id",
    "publicationCount",
    "researchInterestDomain",
    "shortName",
    "startYear"
})
public class Conference {

    @XmlElementRef(name = "CFP", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<CFPInfo> cfp;
    @XmlElement(name = "CitationCount")
    @XmlSchemaType(name = "unsignedInt")
    protected Long citationCount;
    @XmlElement(name = "EndYear")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer endYear;
    @XmlElementRef(name = "FullName", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> fullName;
    @XmlElementRef(name = "HomepageURL", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> homepageURL;
    @XmlElement(name = "ID")
    @XmlSchemaType(name = "unsignedInt")
    protected Long id;
    @XmlElement(name = "PublicationCount")
    @XmlSchemaType(name = "unsignedInt")
    protected Long publicationCount;
    @XmlElementRef(name = "ResearchInterestDomain", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<ArrayOfDomain> researchInterestDomain;
    @XmlElementRef(name = "ShortName", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> shortName;
    @XmlElement(name = "StartYear")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer startYear;

    /**
     * Gets the value of the cfp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CFPInfo }{@code >}
     *     
     */
    public JAXBElement<CFPInfo> getCFP() {
        return cfp;
    }

    /**
     * Sets the value of the cfp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CFPInfo }{@code >}
     *     
     */
    public void setCFP(JAXBElement<CFPInfo> value) {
        this.cfp = ((JAXBElement<CFPInfo> ) value);
    }

    /**
     * Gets the value of the citationCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCitationCount() {
        return citationCount;
    }

    /**
     * Sets the value of the citationCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCitationCount(Long value) {
        this.citationCount = value;
    }

    /**
     * Gets the value of the endYear property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEndYear() {
        return endYear;
    }

    /**
     * Sets the value of the endYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEndYear(Integer value) {
        this.endYear = value;
    }

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFullName(JAXBElement<String> value) {
        this.fullName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the homepageURL property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHomepageURL() {
        return homepageURL;
    }

    /**
     * Sets the value of the homepageURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHomepageURL(JAXBElement<String> value) {
        this.homepageURL = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setID(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the publicationCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPublicationCount() {
        return publicationCount;
    }

    /**
     * Sets the value of the publicationCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPublicationCount(Long value) {
        this.publicationCount = value;
    }

    /**
     * Gets the value of the researchInterestDomain property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDomain }{@code >}
     *     
     */
    public JAXBElement<ArrayOfDomain> getResearchInterestDomain() {
        return researchInterestDomain;
    }

    /**
     * Sets the value of the researchInterestDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDomain }{@code >}
     *     
     */
    public void setResearchInterestDomain(JAXBElement<ArrayOfDomain> value) {
        this.researchInterestDomain = ((JAXBElement<ArrayOfDomain> ) value);
    }

    /**
     * Gets the value of the shortName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShortName() {
        return shortName;
    }

    /**
     * Sets the value of the shortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShortName(JAXBElement<String> value) {
        this.shortName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the startYear property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStartYear() {
        return startYear;
    }

    /**
     * Sets the value of the startYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStartYear(Integer value) {
        this.startYear = value;
    }

}
