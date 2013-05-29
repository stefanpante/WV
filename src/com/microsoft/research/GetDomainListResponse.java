
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
 *         &lt;element name="GetDomainListResult" type="{http://research.microsoft.com}DomainResponse" minOccurs="0"/>
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
    "getDomainListResult"
})
@XmlRootElement(name = "GetDomainListResponse")
public class GetDomainListResponse {

    @XmlElementRef(name = "GetDomainListResult", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<DomainResponse> getDomainListResult;

    /**
     * Gets the value of the getDomainListResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DomainResponse }{@code >}
     *     
     */
    public JAXBElement<DomainResponse> getGetDomainListResult() {
        return getDomainListResult;
    }

    /**
     * Sets the value of the getDomainListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DomainResponse }{@code >}
     *     
     */
    public void setGetDomainListResult(JAXBElement<DomainResponse> value) {
        this.getDomainListResult = ((JAXBElement<DomainResponse> ) value);
    }

}
