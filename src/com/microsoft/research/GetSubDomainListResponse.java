
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
 *         &lt;element name="GetSubDomainListResult" type="{http://research.microsoft.com}DomainResponse" minOccurs="0"/>
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
    "getSubDomainListResult"
})
@XmlRootElement(name = "GetSubDomainListResponse")
public class GetSubDomainListResponse {

    @XmlElementRef(name = "GetSubDomainListResult", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<DomainResponse> getSubDomainListResult;

    /**
     * Gets the value of the getSubDomainListResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DomainResponse }{@code >}
     *     
     */
    public JAXBElement<DomainResponse> getGetSubDomainListResult() {
        return getSubDomainListResult;
    }

    /**
     * Sets the value of the getSubDomainListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DomainResponse }{@code >}
     *     
     */
    public void setGetSubDomainListResult(JAXBElement<DomainResponse> value) {
        this.getSubDomainListResult = ((JAXBElement<DomainResponse> ) value);
    }

}
