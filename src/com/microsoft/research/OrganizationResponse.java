
package com.microsoft.research;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrganizationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://research.microsoft.com}ResultCollection">
 *       &lt;sequence>
 *         &lt;element name="Result" type="{http://research.microsoft.com}ArrayOfOrganization" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationResponse", propOrder = {
    "result"
})
public class OrganizationResponse
    extends ResultCollection
{

    @XmlElementRef(name = "Result", namespace = "http://research.microsoft.com", type = JAXBElement.class)
    protected JAXBElement<ArrayOfOrganization> result;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfOrganization }{@code >}
     *     
     */
    public JAXBElement<ArrayOfOrganization> getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfOrganization }{@code >}
     *     
     */
    public void setResult(JAXBElement<ArrayOfOrganization> value) {
        this.result = ((JAXBElement<ArrayOfOrganization> ) value);
    }

}
