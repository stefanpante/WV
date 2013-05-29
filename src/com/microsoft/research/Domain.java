
package com.microsoft.research;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Domain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Domain">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CitationCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="DomainID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PublicationCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="SubDomainID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Domain", propOrder = {
    "citationCount",
    "domainID",
    "name",
    "publicationCount",
    "subDomainID"
})
public class Domain {

    @XmlElement(name = "CitationCount")
    @XmlSchemaType(name = "unsignedInt")
    protected Long citationCount;
    @XmlElement(name = "DomainID")
    @XmlSchemaType(name = "unsignedInt")
    protected Long domainID;
    @XmlElementRef(name = "Name", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> name;
    @XmlElement(name = "PublicationCount")
    @XmlSchemaType(name = "unsignedInt")
    protected Long publicationCount;
    @XmlElement(name = "SubDomainID")
    @XmlSchemaType(name = "unsignedInt")
    protected Long subDomainID;

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
     * Gets the value of the domainID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDomainID() {
        return domainID;
    }

    /**
     * Sets the value of the domainID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDomainID(Long value) {
        this.domainID = value;
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
     * Gets the value of the subDomainID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSubDomainID() {
        return subDomainID;
    }

    /**
     * Sets the value of the subDomainID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSubDomainID(Long value) {
        this.subDomainID = value;
    }

}
