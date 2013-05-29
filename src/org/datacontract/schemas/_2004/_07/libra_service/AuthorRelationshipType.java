
package org.datacontract.schemas._2004._07.libra_service;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthorRelationshipType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AuthorRelationshipType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="CoAuthor"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AuthorRelationshipType")
@XmlEnum
public enum AuthorRelationshipType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("CoAuthor")
    CO_AUTHOR("CoAuthor");
    private final String value;

    AuthorRelationshipType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AuthorRelationshipType fromValue(String v) {
        for (AuthorRelationshipType c: AuthorRelationshipType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
