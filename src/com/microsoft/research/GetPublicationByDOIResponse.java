
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
 *         &lt;element name="GetPublicationByDOIResult" type="{http://research.microsoft.com}PublicationResponse" minOccurs="0"/>
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
    "getPublicationByDOIResult"
})
@XmlRootElement(name = "GetPublicationByDOIResponse")
public class GetPublicationByDOIResponse {

    @XmlElementRef(name = "GetPublicationByDOIResult", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<PublicationResponse> getPublicationByDOIResult;

    /**
     * Gets the value of the getPublicationByDOIResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PublicationResponse }{@code >}
     *     
     */
    public JAXBElement<PublicationResponse> getGetPublicationByDOIResult() {
        return getPublicationByDOIResult;
    }

    /**
     * Sets the value of the getPublicationByDOIResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PublicationResponse }{@code >}
     *     
     */
    public void setGetPublicationByDOIResult(JAXBElement<PublicationResponse> value) {
        this.getPublicationByDOIResult = ((JAXBElement<PublicationResponse> ) value);
    }

}
