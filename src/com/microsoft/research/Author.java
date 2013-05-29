
package com.microsoft.research;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Author complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Author">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Affiliation" type="{http://research.microsoft.com}Organization" minOccurs="0"/>
 *         &lt;element name="CitationCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="DisplayPhotoURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GIndex" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="HIndex" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="HomepageURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MiddleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NativeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PublicationCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="ResearchInterestDomain" type="{http://research.microsoft.com}ArrayOfDomain" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Author", propOrder = {
    "affiliation",
    "citationCount",
    "displayPhotoURL",
    "firstName",
    "gIndex",
    "hIndex",
    "homepageURL",
    "id",
    "lastName",
    "middleName",
    "nativeName",
    "publicationCount",
    "researchInterestDomain"
})
public class Author {

    @XmlElementRef(name = "Affiliation", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<Organization> affiliation;
    @XmlElement(name = "CitationCount")
    @XmlSchemaType(name = "unsignedInt")
    protected Long citationCount;
    @XmlElementRef(name = "DisplayPhotoURL", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> displayPhotoURL;
    @XmlElementRef(name = "FirstName", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> firstName;
    @XmlElement(name = "GIndex")
    @XmlSchemaType(name = "unsignedInt")
    protected Long gIndex;
    @XmlElement(name = "HIndex")
    @XmlSchemaType(name = "unsignedInt")
    protected Long hIndex;
    @XmlElementRef(name = "HomepageURL", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> homepageURL;
    @XmlElement(name = "ID")
    @XmlSchemaType(name = "unsignedInt")
    protected Long id;
    @XmlElementRef(name = "LastName", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> lastName;
    @XmlElementRef(name = "MiddleName", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> middleName;
    @XmlElementRef(name = "NativeName", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> nativeName;
    @XmlElement(name = "PublicationCount")
    @XmlSchemaType(name = "unsignedInt")
    protected Long publicationCount;
    @XmlElementRef(name = "ResearchInterestDomain", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<ArrayOfDomain> researchInterestDomain;

    /**
     * Gets the value of the affiliation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Organization }{@code >}
     *     
     */
    public JAXBElement<Organization> getAffiliation() {
        return affiliation;
    }

    /**
     * Sets the value of the affiliation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Organization }{@code >}
     *     
     */
    public void setAffiliation(JAXBElement<Organization> value) {
        this.affiliation = ((JAXBElement<Organization> ) value);
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
     * Gets the value of the displayPhotoURL property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDisplayPhotoURL() {
        return displayPhotoURL;
    }

    /**
     * Sets the value of the displayPhotoURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDisplayPhotoURL(JAXBElement<String> value) {
        this.displayPhotoURL = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFirstName(JAXBElement<String> value) {
        this.firstName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the gIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGIndex() {
        return gIndex;
    }

    /**
     * Sets the value of the gIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGIndex(Long value) {
        this.gIndex = value;
    }

    /**
     * Gets the value of the hIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHIndex() {
        return hIndex;
    }

    /**
     * Sets the value of the hIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHIndex(Long value) {
        this.hIndex = value;
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
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLastName(JAXBElement<String> value) {
        this.lastName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the middleName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMiddleName() {
        return middleName;
    }

    /**
     * Sets the value of the middleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMiddleName(JAXBElement<String> value) {
        this.middleName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the nativeName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNativeName() {
        return nativeName;
    }

    /**
     * Sets the value of the nativeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNativeName(JAXBElement<String> value) {
        this.nativeName = ((JAXBElement<String> ) value);
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

}
