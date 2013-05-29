
package com.microsoft.research;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="GetLatestUpdatedAuthorListResult" type="{http://research.microsoft.com}AuthorResponse" minOccurs="0"/>
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
    "getLatestUpdatedAuthorListResult"
})
@XmlRootElement(name = "GetLatestUpdatedAuthorListResponse")
public class GetLatestUpdatedAuthorListResponse {

    @XmlElementRef(name = "GetLatestUpdatedAuthorListResult", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<AuthorResponse> getLatestUpdatedAuthorListResult;

    /**
     * Gets the value of the getLatestUpdatedAuthorListResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AuthorResponse }{@code >}
     *     
     */
    public JAXBElement<AuthorResponse> getGetLatestUpdatedAuthorListResult() {
        return getLatestUpdatedAuthorListResult;
    }

    /**
     * Sets the value of the getLatestUpdatedAuthorListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AuthorResponse }{@code >}
     *     
     */
    public void setGetLatestUpdatedAuthorListResult(JAXBElement<AuthorResponse> value) {
        this.getLatestUpdatedAuthorListResult = ((JAXBElement<AuthorResponse> ) value);
    }

}
