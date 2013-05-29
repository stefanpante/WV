
package com.microsoft.research;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CFPInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CFPInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AbstractSubmissionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="AgendaUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConferenceEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ConferenceStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FinalVersionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="HomepageURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaperSubmissionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ResultNotificationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFPInfo", propOrder = {
    "abstractSubmissionDate",
    "agendaUrl",
    "city",
    "conferenceEndDate",
    "conferenceStartDate",
    "country",
    "finalVersionDate",
    "homepageURL",
    "paperSubmissionDate",
    "resultNotificationDate"
})
public class CFPInfo {

    @XmlElement(name = "AbstractSubmissionDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar abstractSubmissionDate;
    @XmlElementRef(name = "AgendaUrl", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> agendaUrl;
    @XmlElementRef(name = "City", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> city;
    @XmlElement(name = "ConferenceEndDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar conferenceEndDate;
    @XmlElement(name = "ConferenceStartDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar conferenceStartDate;
    @XmlElementRef(name = "Country", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> country;
    @XmlElement(name = "FinalVersionDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar finalVersionDate;
    @XmlElementRef(name = "HomepageURL", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> homepageURL;
    @XmlElement(name = "PaperSubmissionDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar paperSubmissionDate;
    @XmlElement(name = "ResultNotificationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar resultNotificationDate;

    /**
     * Gets the value of the abstractSubmissionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAbstractSubmissionDate() {
        return abstractSubmissionDate;
    }

    /**
     * Sets the value of the abstractSubmissionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAbstractSubmissionDate(XMLGregorianCalendar value) {
        this.abstractSubmissionDate = value;
    }

    /**
     * Gets the value of the agendaUrl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAgendaUrl() {
        return agendaUrl;
    }

    /**
     * Sets the value of the agendaUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAgendaUrl(JAXBElement<String> value) {
        this.agendaUrl = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCity(JAXBElement<String> value) {
        this.city = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the conferenceEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getConferenceEndDate() {
        return conferenceEndDate;
    }

    /**
     * Sets the value of the conferenceEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setConferenceEndDate(XMLGregorianCalendar value) {
        this.conferenceEndDate = value;
    }

    /**
     * Gets the value of the conferenceStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getConferenceStartDate() {
        return conferenceStartDate;
    }

    /**
     * Sets the value of the conferenceStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setConferenceStartDate(XMLGregorianCalendar value) {
        this.conferenceStartDate = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCountry(JAXBElement<String> value) {
        this.country = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the finalVersionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFinalVersionDate() {
        return finalVersionDate;
    }

    /**
     * Sets the value of the finalVersionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFinalVersionDate(XMLGregorianCalendar value) {
        this.finalVersionDate = value;
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
     * Gets the value of the paperSubmissionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPaperSubmissionDate() {
        return paperSubmissionDate;
    }

    /**
     * Sets the value of the paperSubmissionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPaperSubmissionDate(XMLGregorianCalendar value) {
        this.paperSubmissionDate = value;
    }

    /**
     * Gets the value of the resultNotificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getResultNotificationDate() {
        return resultNotificationDate;
    }

    /**
     * Sets the value of the resultNotificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setResultNotificationDate(XMLGregorianCalendar value) {
        this.resultNotificationDate = value;
    }

}
