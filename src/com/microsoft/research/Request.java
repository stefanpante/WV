
package com.microsoft.research;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.libra_service.ArrayOfPublicationContentType;
import org.datacontract.schemas._2004._07.libra_service.AuthorRelationshipType;
import org.datacontract.schemas._2004._07.libra_service.ObjectType;
import org.datacontract.schemas._2004._07.libra_service.OrderType;
import org.datacontract.schemas._2004._07.libra_service.ReferenceRelationship;
import org.datacontract.schemas._2004._07.libra_service.SuggestionType;


/**
 * <p>Java class for Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AppID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AuthorID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="AuthorQuery" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AuthorReltiaonship" type="{http://schemas.datacontract.org/2004/07/Libra.Service.API}AuthorRelationshipType" minOccurs="0"/>
 *         &lt;element name="ConferenceID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ConferenceQuery" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DomainID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="EndIdx" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="FulltextQuery" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="JournalID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="JournalQuery" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="KeywordID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="OrderBy" type="{http://schemas.datacontract.org/2004/07/Libra.Service.API}OrderType"/>
 *         &lt;element name="OrganizationID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="PublicationContent" type="{http://schemas.datacontract.org/2004/07/Libra.Service.API}ArrayOfPublicationContentType"/>
 *         &lt;element name="PublicationID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="ReferenceType" type="{http://schemas.datacontract.org/2004/07/Libra.Service.API}ReferenceRelationship"/>
 *         &lt;element name="ResultObjects" type="{http://schemas.datacontract.org/2004/07/Libra.Service.API}ObjectType"/>
 *         &lt;element name="StartIdx" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="SubDomainID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="Suggestion" type="{http://schemas.datacontract.org/2004/07/Libra.Service.API}SuggestionType"/>
 *         &lt;element name="TitleQuery" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="YearEnd" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="YearStart" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Request", propOrder = {
    "appID",
    "authorID",
    "authorQuery",
    "authorReltiaonship",
    "conferenceID",
    "conferenceQuery",
    "domainID",
    "endIdx",
    "fulltextQuery",
    "journalID",
    "journalQuery",
    "keywordID",
    "orderBy",
    "organizationID",
    "publicationContent",
    "publicationID",
    "referenceType",
    "resultObjects",
    "startIdx",
    "subDomainID",
    "suggestion",
    "titleQuery",
    "version",
    "yearEnd",
    "yearStart"
})
public class Request {

    @XmlElement(name = "AppID", required = true, nillable = true)
    protected String appID;
    @XmlElement(name = "AuthorID")
    @XmlSchemaType(name = "unsignedInt")
    protected long authorID;
    @XmlElement(name = "AuthorQuery", required = true, nillable = true)
    protected String authorQuery;
    @XmlElement(name = "AuthorReltiaonship")
    protected AuthorRelationshipType authorReltiaonship;
    @XmlElement(name = "ConferenceID")
    @XmlSchemaType(name = "unsignedInt")
    protected long conferenceID;
    @XmlElement(name = "ConferenceQuery", required = true, nillable = true)
    protected String conferenceQuery;
    @XmlElement(name = "DomainID")
    @XmlSchemaType(name = "unsignedInt")
    protected long domainID;
    @XmlElement(name = "EndIdx")
    @XmlSchemaType(name = "unsignedInt")
    protected long endIdx;
    @XmlElement(name = "FulltextQuery", required = true, nillable = true)
    protected String fulltextQuery;
    @XmlElement(name = "JournalID")
    @XmlSchemaType(name = "unsignedInt")
    protected long journalID;
    @XmlElement(name = "JournalQuery", required = true, nillable = true)
    protected String journalQuery;
    @XmlElement(name = "KeywordID")
    @XmlSchemaType(name = "unsignedInt")
    protected long keywordID;
    @XmlElement(name = "OrderBy", required = true)
    protected OrderType orderBy;
    @XmlElement(name = "OrganizationID")
    @XmlSchemaType(name = "unsignedInt")
    protected long organizationID;
    @XmlElement(name = "PublicationContent", required = true, nillable = true)
    protected ArrayOfPublicationContentType publicationContent;
    @XmlElement(name = "PublicationID")
    @XmlSchemaType(name = "unsignedInt")
    protected long publicationID;
    @XmlElement(name = "ReferenceType", required = true)
    protected ReferenceRelationship referenceType;
    @XmlElement(name = "ResultObjects", required = true)
    protected ObjectType resultObjects;
    @XmlElement(name = "StartIdx")
    @XmlSchemaType(name = "unsignedInt")
    protected long startIdx;
    @XmlElement(name = "SubDomainID")
    @XmlSchemaType(name = "unsignedInt")
    protected long subDomainID;
    @XmlElement(name = "Suggestion", required = true)
    protected SuggestionType suggestion;
    @XmlElement(name = "TitleQuery", required = true, nillable = true)
    protected String titleQuery;
    @XmlElement(name = "Version", required = true, nillable = true)
    protected String version;
    @XmlElement(name = "YearEnd")
    protected short yearEnd;
    @XmlElement(name = "YearStart")
    protected short yearStart;

    /**
     * Gets the value of the appID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppID() {
        return appID;
    }

    /**
     * Sets the value of the appID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppID(String value) {
        this.appID = value;
    }

    /**
     * Gets the value of the authorID property.
     * 
     */
    public long getAuthorID() {
        return authorID;
    }

    /**
     * Sets the value of the authorID property.
     * 
     */
    public void setAuthorID(long value) {
        this.authorID = value;
    }

    /**
     * Gets the value of the authorQuery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorQuery() {
        return authorQuery;
    }

    /**
     * Sets the value of the authorQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorQuery(String value) {
        this.authorQuery = value;
    }

    /**
     * Gets the value of the authorReltiaonship property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorRelationshipType }
     *     
     */
    public AuthorRelationshipType getAuthorReltiaonship() {
        return authorReltiaonship;
    }

    /**
     * Sets the value of the authorReltiaonship property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorRelationshipType }
     *     
     */
    public void setAuthorReltiaonship(AuthorRelationshipType value) {
        this.authorReltiaonship = value;
    }

    /**
     * Gets the value of the conferenceID property.
     * 
     */
    public long getConferenceID() {
        return conferenceID;
    }

    /**
     * Sets the value of the conferenceID property.
     * 
     */
    public void setConferenceID(long value) {
        this.conferenceID = value;
    }

    /**
     * Gets the value of the conferenceQuery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConferenceQuery() {
        return conferenceQuery;
    }

    /**
     * Sets the value of the conferenceQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConferenceQuery(String value) {
        this.conferenceQuery = value;
    }

    /**
     * Gets the value of the domainID property.
     * 
     */
    public long getDomainID() {
        return domainID;
    }

    /**
     * Sets the value of the domainID property.
     * 
     */
    public void setDomainID(long value) {
        this.domainID = value;
    }

    /**
     * Gets the value of the endIdx property.
     * 
     */
    public long getEndIdx() {
        return endIdx;
    }

    /**
     * Sets the value of the endIdx property.
     * 
     */
    public void setEndIdx(long value) {
        this.endIdx = value;
    }

    /**
     * Gets the value of the fulltextQuery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFulltextQuery() {
        return fulltextQuery;
    }

    /**
     * Sets the value of the fulltextQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFulltextQuery(String value) {
        this.fulltextQuery = value;
    }

    /**
     * Gets the value of the journalID property.
     * 
     */
    public long getJournalID() {
        return journalID;
    }

    /**
     * Sets the value of the journalID property.
     * 
     */
    public void setJournalID(long value) {
        this.journalID = value;
    }

    /**
     * Gets the value of the journalQuery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJournalQuery() {
        return journalQuery;
    }

    /**
     * Sets the value of the journalQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJournalQuery(String value) {
        this.journalQuery = value;
    }

    /**
     * Gets the value of the keywordID property.
     * 
     */
    public long getKeywordID() {
        return keywordID;
    }

    /**
     * Sets the value of the keywordID property.
     * 
     */
    public void setKeywordID(long value) {
        this.keywordID = value;
    }

    /**
     * Gets the value of the orderBy property.
     * 
     * @return
     *     possible object is
     *     {@link OrderType }
     *     
     */
    public OrderType getOrderBy() {
        return orderBy;
    }

    /**
     * Sets the value of the orderBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderType }
     *     
     */
    public void setOrderBy(OrderType value) {
        this.orderBy = value;
    }

    /**
     * Gets the value of the organizationID property.
     * 
     */
    public long getOrganizationID() {
        return organizationID;
    }

    /**
     * Sets the value of the organizationID property.
     * 
     */
    public void setOrganizationID(long value) {
        this.organizationID = value;
    }

    /**
     * Gets the value of the publicationContent property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPublicationContentType }
     *     
     */
    public ArrayOfPublicationContentType getPublicationContent() {
        return publicationContent;
    }

    /**
     * Sets the value of the publicationContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPublicationContentType }
     *     
     */
    public void setPublicationContent(ArrayOfPublicationContentType value) {
        this.publicationContent = value;
    }

    /**
     * Gets the value of the publicationID property.
     * 
     */
    public long getPublicationID() {
        return publicationID;
    }

    /**
     * Sets the value of the publicationID property.
     * 
     */
    public void setPublicationID(long value) {
        this.publicationID = value;
    }

    /**
     * Gets the value of the referenceType property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceRelationship }
     *     
     */
    public ReferenceRelationship getReferenceType() {
        return referenceType;
    }

    /**
     * Sets the value of the referenceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceRelationship }
     *     
     */
    public void setReferenceType(ReferenceRelationship value) {
        this.referenceType = value;
    }

    /**
     * Gets the value of the resultObjects property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectType }
     *     
     */
    public ObjectType getResultObjects() {
        return resultObjects;
    }

    /**
     * Sets the value of the resultObjects property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectType }
     *     
     */
    public void setResultObjects(ObjectType value) {
        this.resultObjects = value;
    }

    /**
     * Gets the value of the startIdx property.
     * 
     */
    public long getStartIdx() {
        return startIdx;
    }

    /**
     * Sets the value of the startIdx property.
     * 
     */
    public void setStartIdx(long value) {
        this.startIdx = value;
    }

    /**
     * Gets the value of the subDomainID property.
     * 
     */
    public long getSubDomainID() {
        return subDomainID;
    }

    /**
     * Sets the value of the subDomainID property.
     * 
     */
    public void setSubDomainID(long value) {
        this.subDomainID = value;
    }

    /**
     * Gets the value of the suggestion property.
     * 
     * @return
     *     possible object is
     *     {@link SuggestionType }
     *     
     */
    public SuggestionType getSuggestion() {
        return suggestion;
    }

    /**
     * Sets the value of the suggestion property.
     * 
     * @param value
     *     allowed object is
     *     {@link SuggestionType }
     *     
     */
    public void setSuggestion(SuggestionType value) {
        this.suggestion = value;
    }

    /**
     * Gets the value of the titleQuery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitleQuery() {
        return titleQuery;
    }

    /**
     * Sets the value of the titleQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitleQuery(String value) {
        this.titleQuery = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the yearEnd property.
     * 
     */
    public short getYearEnd() {
        return yearEnd;
    }

    /**
     * Sets the value of the yearEnd property.
     * 
     */
    public void setYearEnd(short value) {
        this.yearEnd = value;
    }

    /**
     * Gets the value of the yearStart property.
     * 
     */
    public short getYearStart() {
        return yearStart;
    }

    /**
     * Sets the value of the yearStart property.
     * 
     */
    public void setYearStart(short value) {
        this.yearStart = value;
    }

}
