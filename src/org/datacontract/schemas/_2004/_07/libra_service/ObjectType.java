
package org.datacontract.schemas._2004._07.libra_service;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObjectType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObjectType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Publication"/>
 *     &lt;enumeration value="Author"/>
 *     &lt;enumeration value="Conference"/>
 *     &lt;enumeration value="Journal"/>
 *     &lt;enumeration value="Organization"/>
 *     &lt;enumeration value="Domain"/>
 *     &lt;enumeration value="Keyword"/>
 *     &lt;enumeration value="PublicationTrend"/>
 *     &lt;enumeration value="CitationContext"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ObjectType")
@XmlEnum
public enum ObjectType {

    @XmlEnumValue("Publication")
    PUBLICATION("Publication"),
    @XmlEnumValue("Author")
    AUTHOR("Author"),
    @XmlEnumValue("Conference")
    CONFERENCE("Conference"),
    @XmlEnumValue("Journal")
    JOURNAL("Journal"),
    @XmlEnumValue("Organization")
    ORGANIZATION("Organization"),
    @XmlEnumValue("Domain")
    DOMAIN("Domain"),
    @XmlEnumValue("Keyword")
    KEYWORD("Keyword"),
    @XmlEnumValue("PublicationTrend")
    PUBLICATION_TREND("PublicationTrend"),
    @XmlEnumValue("CitationContext")
    CITATION_CONTEXT("CitationContext");
    private final String value;

    ObjectType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ObjectType fromValue(String v) {
        for (ObjectType c: ObjectType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
