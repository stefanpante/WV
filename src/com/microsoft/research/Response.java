
package com.microsoft.research;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Author" type="{http://research.microsoft.com}AuthorResponse" minOccurs="0"/>
 *         &lt;element name="Conference" type="{http://research.microsoft.com}ConferenceResponse" minOccurs="0"/>
 *         &lt;element name="Domain" type="{http://research.microsoft.com}DomainResponse" minOccurs="0"/>
 *         &lt;element name="Journal" type="{http://research.microsoft.com}JournalResponse" minOccurs="0"/>
 *         &lt;element name="Keyword" type="{http://research.microsoft.com}KeywordResponse" minOccurs="0"/>
 *         &lt;element name="Organization" type="{http://research.microsoft.com}OrganizationResponse" minOccurs="0"/>
 *         &lt;element name="Publication" type="{http://research.microsoft.com}PublicationResponse" minOccurs="0"/>
 *         &lt;element name="ResultCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="Trend" type="{http://research.microsoft.com}TrendGraph" minOccurs="0"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response", propOrder = {
    "author",
    "conference",
    "domain",
    "journal",
    "keyword",
    "organization",
    "publication",
    "resultCode",
    "trend",
    "version"
})
public class Response {

    @XmlElementRef(name = "Author", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<AuthorResponse> author;
    @XmlElementRef(name = "Conference", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<ConferenceResponse> conference;
    @XmlElementRef(name = "Domain", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<DomainResponse> domain;
    @XmlElementRef(name = "Journal", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<JournalResponse> journal;
    @XmlElementRef(name = "Keyword", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<KeywordResponse> keyword;
    @XmlElementRef(name = "Organization", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<OrganizationResponse> organization;
    @XmlElementRef(name = "Publication", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<PublicationResponse> publication;
    @XmlElement(name = "ResultCode")
    @XmlSchemaType(name = "unsignedInt")
    protected Long resultCode;
    @XmlElementRef(name = "Trend", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<TrendGraph> trend;
    @XmlElementRef(name = "Version", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> version;

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AuthorResponse }{@code >}
     *     
     */
    public JAXBElement<AuthorResponse> getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AuthorResponse }{@code >}
     *     
     */
    public void setAuthor(JAXBElement<AuthorResponse> value) {
        this.author = ((JAXBElement<AuthorResponse> ) value);
    }

    /**
     * Gets the value of the conference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConferenceResponse }{@code >}
     *     
     */
    public JAXBElement<ConferenceResponse> getConference() {
        return conference;
    }

    /**
     * Sets the value of the conference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConferenceResponse }{@code >}
     *     
     */
    public void setConference(JAXBElement<ConferenceResponse> value) {
        this.conference = ((JAXBElement<ConferenceResponse> ) value);
    }

    /**
     * Gets the value of the domain property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DomainResponse }{@code >}
     *     
     */
    public JAXBElement<DomainResponse> getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DomainResponse }{@code >}
     *     
     */
    public void setDomain(JAXBElement<DomainResponse> value) {
        this.domain = ((JAXBElement<DomainResponse> ) value);
    }

    /**
     * Gets the value of the journal property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link JournalResponse }{@code >}
     *     
     */
    public JAXBElement<JournalResponse> getJournal() {
        return journal;
    }

    /**
     * Sets the value of the journal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link JournalResponse }{@code >}
     *     
     */
    public void setJournal(JAXBElement<JournalResponse> value) {
        this.journal = ((JAXBElement<JournalResponse> ) value);
    }

    /**
     * Gets the value of the keyword property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link KeywordResponse }{@code >}
     *     
     */
    public JAXBElement<KeywordResponse> getKeyword() {
        return keyword;
    }

    /**
     * Sets the value of the keyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link KeywordResponse }{@code >}
     *     
     */
    public void setKeyword(JAXBElement<KeywordResponse> value) {
        this.keyword = ((JAXBElement<KeywordResponse> ) value);
    }

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OrganizationResponse }{@code >}
     *     
     */
    public JAXBElement<OrganizationResponse> getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OrganizationResponse }{@code >}
     *     
     */
    public void setOrganization(JAXBElement<OrganizationResponse> value) {
        this.organization = ((JAXBElement<OrganizationResponse> ) value);
    }

    /**
     * Gets the value of the publication property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PublicationResponse }{@code >}
     *     
     */
    public JAXBElement<PublicationResponse> getPublication() {
        return publication;
    }

    /**
     * Sets the value of the publication property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PublicationResponse }{@code >}
     *     
     */
    public void setPublication(JAXBElement<PublicationResponse> value) {
        this.publication = ((JAXBElement<PublicationResponse> ) value);
    }

    /**
     * Gets the value of the resultCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setResultCode(Long value) {
        this.resultCode = value;
    }

    /**
     * Gets the value of the trend property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TrendGraph }{@code >}
     *     
     */
    public JAXBElement<TrendGraph> getTrend() {
        return trend;
    }

    /**
     * Sets the value of the trend property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TrendGraph }{@code >}
     *     
     */
    public void setTrend(JAXBElement<TrendGraph> value) {
        this.trend = ((JAXBElement<TrendGraph> ) value);
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVersion(JAXBElement<String> value) {
        this.version = ((JAXBElement<String> ) value);
    }

}
