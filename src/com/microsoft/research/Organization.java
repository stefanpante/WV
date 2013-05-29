
package com.microsoft.research;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Organization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Organization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuthorCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="CitationCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="HomepageURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "Organization", propOrder = {
    "authorCount",
    "citationCount",
    "homepageURL",
    "id",
    "name",
    "publicationCount",
    "researchInterestDomain"
})
public class Organization {

    @XmlElement(name = "AuthorCount")
    @XmlSchemaType(name = "unsignedInt")
    protected Long authorCount;
    @XmlElement(name = "CitationCount")
    @XmlSchemaType(name = "unsignedInt")
    protected Long citationCount;
    @XmlElementRef(name = "HomepageURL", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> homepageURL;
    @XmlElement(name = "ID")
    @XmlSchemaType(name = "unsignedInt")
    protected Long id;
    @XmlElementRef(name = "Name", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> name;
    @XmlElement(name = "PublicationCount")
    @XmlSchemaType(name = "unsignedInt")
    protected Long publicationCount;
    @XmlElementRef(name = "ResearchInterestDomain", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<ArrayOfDomain> researchInterestDomain;

    /**
     * Gets the value of the authorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAuthorCount() {
        return authorCount;
    }

    /**
     * Sets the value of the authorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAuthorCount(Long value) {
        this.authorCount = value;
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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(JAXBElement<String> value) {
        this.name = ((JAXBElement<String> ) value);
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
