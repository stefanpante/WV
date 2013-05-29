
package com.microsoft.research;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;
import org.datacontract.schemas._2004._07.libra_service.PublicationType;


/**
 * <p>Java class for Publication complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Publication">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Abstract" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Author" type="{http://research.microsoft.com}ArrayOfAuthor" minOccurs="0"/>
 *         &lt;element name="CitationContext" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="CitationCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="Conference" type="{http://research.microsoft.com}Conference" minOccurs="0"/>
 *         &lt;element name="DOI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FullVersionURL" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="Journal" type="{http://research.microsoft.com}Journal" minOccurs="0"/>
 *         &lt;element name="Keyword" type="{http://research.microsoft.com}ArrayOfKeyword" minOccurs="0"/>
 *         &lt;element name="ReferenceCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://schemas.datacontract.org/2004/07/Libra.Service.API}PublicationType" minOccurs="0"/>
 *         &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Publication", propOrder = {
    "_abstract",
    "author",
    "citationContext",
    "citationCount",
    "conference",
    "doi",
    "fullVersionURL",
    "id",
    "journal",
    "keyword",
    "referenceCount",
    "title",
    "type",
    "year"
})
public class Publication {

    @XmlElementRef(name = "Abstract", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> _abstract;
    @XmlElementRef(name = "Author", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<ArrayOfAuthor> author;
    @XmlElementRef(name = "CitationContext", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<ArrayOfstring> citationContext;
    @XmlElement(name = "CitationCount")
    @XmlSchemaType(name = "unsignedInt")
    protected Long citationCount;
    @XmlElementRef(name = "Conference", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<Conference> conference;
    @XmlElementRef(name = "DOI", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> doi;
    @XmlElementRef(name = "FullVersionURL", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<ArrayOfstring> fullVersionURL;
    @XmlElement(name = "ID")
    @XmlSchemaType(name = "unsignedInt")
    protected Long id;
    @XmlElementRef(name = "Journal", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<Journal> journal;
    @XmlElementRef(name = "Keyword", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<ArrayOfKeyword> keyword;
    @XmlElement(name = "ReferenceCount")
    @XmlSchemaType(name = "unsignedInt")
    protected Long referenceCount;
    @XmlElementRef(name = "Title", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<String> title;
    @XmlElement(name = "Type")
    protected PublicationType type;
    @XmlElement(name = "Year")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer year;

    /**
     * Gets the value of the abstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAbstract() {
        return _abstract;
    }

    /**
     * Sets the value of the abstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAbstract(JAXBElement<String> value) {
        this._abstract = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAuthor }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAuthor> getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAuthor }{@code >}
     *     
     */
    public void setAuthor(JAXBElement<ArrayOfAuthor> value) {
        this.author = ((JAXBElement<ArrayOfAuthor> ) value);
    }

    /**
     * Gets the value of the citationContext property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getCitationContext() {
        return citationContext;
    }

    /**
     * Sets the value of the citationContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setCitationContext(JAXBElement<ArrayOfstring> value) {
        this.citationContext = ((JAXBElement<ArrayOfstring> ) value);
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
     * Gets the value of the conference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Conference }{@code >}
     *     
     */
    public JAXBElement<Conference> getConference() {
        return conference;
    }

    /**
     * Sets the value of the conference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Conference }{@code >}
     *     
     */
    public void setConference(JAXBElement<Conference> value) {
        this.conference = ((JAXBElement<Conference> ) value);
    }

    /**
     * Gets the value of the doi property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDOI() {
        return doi;
    }

    /**
     * Sets the value of the doi property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDOI(JAXBElement<String> value) {
        this.doi = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fullVersionURL property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getFullVersionURL() {
        return fullVersionURL;
    }

    /**
     * Sets the value of the fullVersionURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setFullVersionURL(JAXBElement<ArrayOfstring> value) {
        this.fullVersionURL = ((JAXBElement<ArrayOfstring> ) value);
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
     * Gets the value of the journal property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Journal }{@code >}
     *     
     */
    public JAXBElement<Journal> getJournal() {
        return journal;
    }

    /**
     * Sets the value of the journal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Journal }{@code >}
     *     
     */
    public void setJournal(JAXBElement<Journal> value) {
        this.journal = ((JAXBElement<Journal> ) value);
    }

    /**
     * Gets the value of the keyword property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyword }{@code >}
     *     
     */
    public JAXBElement<ArrayOfKeyword> getKeyword() {
        return keyword;
    }

    /**
     * Sets the value of the keyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyword }{@code >}
     *     
     */
    public void setKeyword(JAXBElement<ArrayOfKeyword> value) {
        this.keyword = ((JAXBElement<ArrayOfKeyword> ) value);
    }

    /**
     * Gets the value of the referenceCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReferenceCount() {
        return referenceCount;
    }

    /**
     * Sets the value of the referenceCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReferenceCount(Long value) {
        this.referenceCount = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTitle(JAXBElement<String> value) {
        this.title = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link PublicationType }
     *     
     */
    public PublicationType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicationType }
     *     
     */
    public void setType(PublicationType value) {
        this.type = value;
    }

    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setYear(Integer value) {
        this.year = value;
    }

}
