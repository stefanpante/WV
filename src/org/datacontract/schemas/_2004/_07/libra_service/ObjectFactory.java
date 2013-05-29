
package org.datacontract.schemas._2004._07.libra_service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.libra_service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PublicationType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Libra.Service.API", "PublicationType");
    private final static QName _OrderType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Libra.Service.API", "OrderType");
    private final static QName _PublicationContentType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Libra.Service.API", "PublicationContentType");
    private final static QName _SuggestionType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Libra.Service.API", "SuggestionType");
    private final static QName _ObjectType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Libra.Service.API", "ObjectType");
    private final static QName _ReferenceRelationship_QNAME = new QName("http://schemas.datacontract.org/2004/07/Libra.Service.API", "ReferenceRelationship");
    private final static QName _AuthorRelationshipType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Libra.Service.API", "AuthorRelationshipType");
    private final static QName _ArrayOfPublicationContentType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Libra.Service.API", "ArrayOfPublicationContentType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.libra_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArrayOfPublicationContentType }
     * 
     */
    public ArrayOfPublicationContentType createArrayOfPublicationContentType() {
        return new ArrayOfPublicationContentType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Libra.Service.API", name = "PublicationType")
    public JAXBElement<PublicationType> createPublicationType(PublicationType value) {
        return new JAXBElement<PublicationType>(_PublicationType_QNAME, PublicationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Libra.Service.API", name = "OrderType")
    public JAXBElement<OrderType> createOrderType(OrderType value) {
        return new JAXBElement<OrderType>(_OrderType_QNAME, OrderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicationContentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Libra.Service.API", name = "PublicationContentType")
    public JAXBElement<PublicationContentType> createPublicationContentType(PublicationContentType value) {
        return new JAXBElement<PublicationContentType>(_PublicationContentType_QNAME, PublicationContentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SuggestionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Libra.Service.API", name = "SuggestionType")
    public JAXBElement<SuggestionType> createSuggestionType(SuggestionType value) {
        return new JAXBElement<SuggestionType>(_SuggestionType_QNAME, SuggestionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObjectType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Libra.Service.API", name = "ObjectType")
    public JAXBElement<ObjectType> createObjectType(ObjectType value) {
        return new JAXBElement<ObjectType>(_ObjectType_QNAME, ObjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceRelationship }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Libra.Service.API", name = "ReferenceRelationship")
    public JAXBElement<ReferenceRelationship> createReferenceRelationship(ReferenceRelationship value) {
        return new JAXBElement<ReferenceRelationship>(_ReferenceRelationship_QNAME, ReferenceRelationship.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthorRelationshipType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Libra.Service.API", name = "AuthorRelationshipType")
    public JAXBElement<AuthorRelationshipType> createAuthorRelationshipType(AuthorRelationshipType value) {
        return new JAXBElement<AuthorRelationshipType>(_AuthorRelationshipType_QNAME, AuthorRelationshipType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPublicationContentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Libra.Service.API", name = "ArrayOfPublicationContentType")
    public JAXBElement<ArrayOfPublicationContentType> createArrayOfPublicationContentType(ArrayOfPublicationContentType value) {
        return new JAXBElement<ArrayOfPublicationContentType>(_ArrayOfPublicationContentType_QNAME, ArrayOfPublicationContentType.class, null, value);
    }

}
