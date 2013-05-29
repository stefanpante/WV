
package org.datacontract.schemas._2004._07.libra_service;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReferenceRelationship.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReferenceRelationship">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Reference"/>
 *     &lt;enumeration value="Citation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReferenceRelationship")
@XmlEnum
public enum ReferenceRelationship {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Reference")
    REFERENCE("Reference"),
    @XmlEnumValue("Citation")
    CITATION("Citation");
    private final String value;

    ReferenceRelationship(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReferenceRelationship fromValue(String v) {
        for (ReferenceRelationship c: ReferenceRelationship.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
