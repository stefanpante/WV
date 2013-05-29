
package org.datacontract.schemas._2004._07.libra_service;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PublicationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PublicationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unkown"/>
 *     &lt;enumeration value="Paper"/>
 *     &lt;enumeration value="Book"/>
 *     &lt;enumeration value="Poster"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PublicationType")
@XmlEnum
public enum PublicationType {

    @XmlEnumValue("Unkown")
    UNKOWN("Unkown"),
    @XmlEnumValue("Paper")
    PAPER("Paper"),
    @XmlEnumValue("Book")
    BOOK("Book"),
    @XmlEnumValue("Poster")
    POSTER("Poster");
    private final String value;

    PublicationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PublicationType fromValue(String v) {
        for (PublicationType c: PublicationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
