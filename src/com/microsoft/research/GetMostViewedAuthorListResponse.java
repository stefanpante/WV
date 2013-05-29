
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
 *         &lt;element name="GetMostViewedAuthorListResult" type="{http://research.microsoft.com}AuthorResponse" minOccurs="0"/>
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
    "getMostViewedAuthorListResult"
})
@XmlRootElement(name = "GetMostViewedAuthorListResponse")
public class GetMostViewedAuthorListResponse {

    @XmlElementRef(name = "GetMostViewedAuthorListResult", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<AuthorResponse> getMostViewedAuthorListResult;

    /**
     * Gets the value of the getMostViewedAuthorListResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AuthorResponse }{@code >}
     *     
     */
    public JAXBElement<AuthorResponse> getGetMostViewedAuthorListResult() {
        return getMostViewedAuthorListResult;
    }

    /**
     * Sets the value of the getMostViewedAuthorListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AuthorResponse }{@code >}
     *     
     */
    public void setGetMostViewedAuthorListResult(JAXBElement<AuthorResponse> value) {
        this.getMostViewedAuthorListResult = ((JAXBElement<AuthorResponse> ) value);
    }

}
