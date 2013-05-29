
package com.microsoft.research;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResultCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EndIdx" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="StartIdx" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="TotalItem" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultCollection", propOrder = {
    "endIdx",
    "startIdx",
    "totalItem"
})
@XmlSeeAlso({
    DomainResponse.class,
    PublicationResponse.class,
    AuthorResponse.class,
    ConferenceResponse.class,
    KeywordResponse.class,
    OrganizationResponse.class,
    JournalResponse.class
})
public class ResultCollection {

    @XmlElement(name = "EndIdx")
    @XmlSchemaType(name = "unsignedInt")
    protected Long endIdx;
    @XmlElement(name = "StartIdx")
    @XmlSchemaType(name = "unsignedInt")
    protected Long startIdx;
    @XmlElement(name = "TotalItem")
    @XmlSchemaType(name = "unsignedInt")
    protected Long totalItem;

    /**
     * Gets the value of the endIdx property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEndIdx() {
        return endIdx;
    }

    /**
     * Sets the value of the endIdx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEndIdx(Long value) {
        this.endIdx = value;
    }

    /**
     * Gets the value of the startIdx property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStartIdx() {
        return startIdx;
    }

    /**
     * Sets the value of the startIdx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStartIdx(Long value) {
        this.startIdx = value;
    }

    /**
     * Gets the value of the totalItem property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalItem() {
        return totalItem;
    }

    /**
     * Sets the value of the totalItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalItem(Long value) {
        this.totalItem = value;
    }

}
