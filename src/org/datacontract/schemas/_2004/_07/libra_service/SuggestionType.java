
package org.datacontract.schemas._2004._07.libra_service;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SuggestionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SuggestionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="NameSuggestion"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SuggestionType")
@XmlEnum
public enum SuggestionType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("NameSuggestion")
    NAME_SUGGESTION("NameSuggestion");
    private final String value;

    SuggestionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SuggestionType fromValue(String v) {
        for (SuggestionType c: SuggestionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
