
package org.datacontract.schemas._2004._07.libra_service;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PublicationContentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PublicationContentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AllInfo"/>
 *     &lt;enumeration value="MetaOnly"/>
 *     &lt;enumeration value="Title"/>
 *     &lt;enumeration value="Author"/>
 *     &lt;enumeration value="Abstract"/>
 *     &lt;enumeration value="ConferenceAndJournalInfo"/>
 *     &lt;enumeration value="FullVersionURL"/>
 *     &lt;enumeration value="Keyword"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PublicationContentType")
@XmlEnum
public enum PublicationContentType {

    @XmlEnumValue("AllInfo")
    ALL_INFO("AllInfo"),
    @XmlEnumValue("MetaOnly")
    META_ONLY("MetaOnly"),
    @XmlEnumValue("Title")
    TITLE("Title"),
    @XmlEnumValue("Author")
    AUTHOR("Author"),
    @XmlEnumValue("Abstract")
    ABSTRACT("Abstract"),
    @XmlEnumValue("ConferenceAndJournalInfo")
    CONFERENCE_AND_JOURNAL_INFO("ConferenceAndJournalInfo"),
    @XmlEnumValue("FullVersionURL")
    FULL_VERSION_URL("FullVersionURL"),
    @XmlEnumValue("Keyword")
    KEYWORD("Keyword");
    private final String value;

    PublicationContentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PublicationContentType fromValue(String v) {
        for (PublicationContentType c: PublicationContentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
