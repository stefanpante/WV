
package com.microsoft.research;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="domainId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="subDomainId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
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
    "domainId",
    "subDomainId"
})
@XmlRootElement(name = "GetMostViewedAuthorList")
public class GetMostViewedAuthorList {

    @XmlSchemaType(name = "unsignedInt")
    protected Long domainId;
    @XmlSchemaType(name = "unsignedInt")
    protected Long subDomainId;

    /**
     * Gets the value of the domainId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDomainId() {
        return domainId;
    }

    /**
     * Sets the value of the domainId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDomainId(Long value) {
        this.domainId = value;
    }

    /**
     * Gets the value of the subDomainId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSubDomainId() {
        return subDomainId;
    }

    /**
     * Sets the value of the subDomainId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSubDomainId(Long value) {
        this.subDomainId = value;
    }

}
