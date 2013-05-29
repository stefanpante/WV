
package com.microsoft.research;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.microsoft.research package. 
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

    private final static QName _ArrayOfAuthor_QNAME = new QName("http://research.microsoft.com", "ArrayOfAuthor");
    private final static QName _KeywordResponse_QNAME = new QName("http://research.microsoft.com", "KeywordResponse");
    private final static QName _Domain_QNAME = new QName("http://research.microsoft.com", "Domain");
    private final static QName _ArrayOfDomain_QNAME = new QName("http://research.microsoft.com", "ArrayOfDomain");
    private final static QName _ArrayOfPublication_QNAME = new QName("http://research.microsoft.com", "ArrayOfPublication");
    private final static QName _ArrayOfJournal_QNAME = new QName("http://research.microsoft.com", "ArrayOfJournal");
    private final static QName _Publication_QNAME = new QName("http://research.microsoft.com", "Publication");
    private final static QName _JournalResponse_QNAME = new QName("http://research.microsoft.com", "JournalResponse");
    private final static QName _PublicationResponse_QNAME = new QName("http://research.microsoft.com", "PublicationResponse");
    private final static QName _Organization_QNAME = new QName("http://research.microsoft.com", "Organization");
    private final static QName _TrendGraph_QNAME = new QName("http://research.microsoft.com", "TrendGraph");
    private final static QName _Journal_QNAME = new QName("http://research.microsoft.com", "Journal");
    private final static QName _ArrayOfKeyword_QNAME = new QName("http://research.microsoft.com", "ArrayOfKeyword");
    private final static QName _Conference_QNAME = new QName("http://research.microsoft.com", "Conference");
    private final static QName _ResultCollection_QNAME = new QName("http://research.microsoft.com", "ResultCollection");
    private final static QName _ConferenceResponse_QNAME = new QName("http://research.microsoft.com", "ConferenceResponse");
    private final static QName _TrendPoint_QNAME = new QName("http://research.microsoft.com", "TrendPoint");
    private final static QName _CFPInfo_QNAME = new QName("http://research.microsoft.com", "CFPInfo");
    private final static QName _Response_QNAME = new QName("http://research.microsoft.com", "Response");
    private final static QName _OrganizationResponse_QNAME = new QName("http://research.microsoft.com", "OrganizationResponse");
    private final static QName _ArrayOfOrganization_QNAME = new QName("http://research.microsoft.com", "ArrayOfOrganization");
    private final static QName _ArrayOfTrendPoint_QNAME = new QName("http://research.microsoft.com", "ArrayOfTrendPoint");
    private final static QName _DomainResponse_QNAME = new QName("http://research.microsoft.com", "DomainResponse");
    private final static QName _Keyword_QNAME = new QName("http://research.microsoft.com", "Keyword");
    private final static QName _ArrayOfConference_QNAME = new QName("http://research.microsoft.com", "ArrayOfConference");
    private final static QName _AuthorResponse_QNAME = new QName("http://research.microsoft.com", "AuthorResponse");
    private final static QName _Request_QNAME = new QName("http://research.microsoft.com", "Request");
    private final static QName _Author_QNAME = new QName("http://research.microsoft.com", "Author");
    private final static QName _OrganizationName_QNAME = new QName("http://research.microsoft.com", "Name");
    private final static QName _OrganizationHomepageURL_QNAME = new QName("http://research.microsoft.com", "HomepageURL");
    private final static QName _OrganizationResearchInterestDomain_QNAME = new QName("http://research.microsoft.com", "ResearchInterestDomain");
    private final static QName _TrendGraphTrend_QNAME = new QName("http://research.microsoft.com", "Trend");
    private final static QName _GetDomainListResponseGetDomainListResult_QNAME = new QName("http://research.microsoft.com", "GetDomainListResult");
    private final static QName _AuthorResponseResult_QNAME = new QName("http://research.microsoft.com", "Result");
    private final static QName _GetMostViewedPublicationListResponseGetMostViewedPublicationListResult_QNAME = new QName("http://research.microsoft.com", "GetMostViewedPublicationListResult");
    private final static QName _SearchRequest_QNAME = new QName("http://research.microsoft.com", "request");
    private final static QName _ConferenceCFP_QNAME = new QName("http://research.microsoft.com", "CFP");
    private final static QName _ConferenceShortName_QNAME = new QName("http://research.microsoft.com", "ShortName");
    private final static QName _ConferenceFullName_QNAME = new QName("http://research.microsoft.com", "FullName");
    private final static QName _GetSubDomainListResponseGetSubDomainListResult_QNAME = new QName("http://research.microsoft.com", "GetSubDomainListResult");
    private final static QName _AuthorMiddleName_QNAME = new QName("http://research.microsoft.com", "MiddleName");
    private final static QName _AuthorNativeName_QNAME = new QName("http://research.microsoft.com", "NativeName");
    private final static QName _AuthorAffiliation_QNAME = new QName("http://research.microsoft.com", "Affiliation");
    private final static QName _AuthorFirstName_QNAME = new QName("http://research.microsoft.com", "FirstName");
    private final static QName _AuthorDisplayPhotoURL_QNAME = new QName("http://research.microsoft.com", "DisplayPhotoURL");
    private final static QName _AuthorLastName_QNAME = new QName("http://research.microsoft.com", "LastName");
    private final static QName _GetMostViewedAuthorListResponseGetMostViewedAuthorListResult_QNAME = new QName("http://research.microsoft.com", "GetMostViewedAuthorListResult");
    private final static QName _JournalISSN_QNAME = new QName("http://research.microsoft.com", "ISSN");
    private final static QName _CFPInfoAgendaUrl_QNAME = new QName("http://research.microsoft.com", "AgendaUrl");
    private final static QName _CFPInfoCity_QNAME = new QName("http://research.microsoft.com", "City");
    private final static QName _CFPInfoCountry_QNAME = new QName("http://research.microsoft.com", "Country");
    private final static QName _GetLatestUpdatedPublicationListResponseGetLatestUpdatedPublicationListResult_QNAME = new QName("http://research.microsoft.com", "GetLatestUpdatedPublicationListResult");
    private final static QName _SearchResponseSearchResult_QNAME = new QName("http://research.microsoft.com", "SearchResult");
    private final static QName _GetPublicationByDOIResponseGetPublicationByDOIResult_QNAME = new QName("http://research.microsoft.com", "GetPublicationByDOIResult");
    private final static QName _ResponseVersion_QNAME = new QName("http://research.microsoft.com", "Version");
    private final static QName _GetLatestUpdatedAuthorListResponseGetLatestUpdatedAuthorListResult_QNAME = new QName("http://research.microsoft.com", "GetLatestUpdatedAuthorListResult");
    private final static QName _PublicationFullVersionURL_QNAME = new QName("http://research.microsoft.com", "FullVersionURL");
    private final static QName _PublicationAbstract_QNAME = new QName("http://research.microsoft.com", "Abstract");
    private final static QName _PublicationTitle_QNAME = new QName("http://research.microsoft.com", "Title");
    private final static QName _PublicationCitationContext_QNAME = new QName("http://research.microsoft.com", "CitationContext");
    private final static QName _PublicationDOI_QNAME = new QName("http://research.microsoft.com", "DOI");
    private final static QName _GetPublicationByDOIDoi_QNAME = new QName("http://research.microsoft.com", "doi");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.microsoft.research
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Organization }
     * 
     */
    public Organization createOrganization() {
        return new Organization();
    }

    /**
     * Create an instance of {@link ArrayOfKeyword }
     * 
     */
    public ArrayOfKeyword createArrayOfKeyword() {
        return new ArrayOfKeyword();
    }

    /**
     * Create an instance of {@link TrendGraph }
     * 
     */
    public TrendGraph createTrendGraph() {
        return new TrendGraph();
    }

    /**
     * Create an instance of {@link GetDomainListResponse }
     * 
     */
    public GetDomainListResponse createGetDomainListResponse() {
        return new GetDomainListResponse();
    }

    /**
     * Create an instance of {@link AuthorResponse }
     * 
     */
    public AuthorResponse createAuthorResponse() {
        return new AuthorResponse();
    }

    /**
     * Create an instance of {@link ArrayOfPublication }
     * 
     */
    public ArrayOfPublication createArrayOfPublication() {
        return new ArrayOfPublication();
    }

    /**
     * Create an instance of {@link GetMostViewedPublicationListResponse }
     * 
     */
    public GetMostViewedPublicationListResponse createGetMostViewedPublicationListResponse() {
        return new GetMostViewedPublicationListResponse();
    }

    /**
     * Create an instance of {@link GetDomainList }
     * 
     */
    public GetDomainList createGetDomainList() {
        return new GetDomainList();
    }

    /**
     * Create an instance of {@link ConferenceResponse }
     * 
     */
    public ConferenceResponse createConferenceResponse() {
        return new ConferenceResponse();
    }

    /**
     * Create an instance of {@link Search }
     * 
     */
    public Search createSearch() {
        return new Search();
    }

    /**
     * Create an instance of {@link Conference }
     * 
     */
    public Conference createConference() {
        return new Conference();
    }

    /**
     * Create an instance of {@link GetLatestUpdatedAuthorList }
     * 
     */
    public GetLatestUpdatedAuthorList createGetLatestUpdatedAuthorList() {
        return new GetLatestUpdatedAuthorList();
    }

    /**
     * Create an instance of {@link GetSubDomainListResponse }
     * 
     */
    public GetSubDomainListResponse createGetSubDomainListResponse() {
        return new GetSubDomainListResponse();
    }

    /**
     * Create an instance of {@link GetMostViewedAuthorList }
     * 
     */
    public GetMostViewedAuthorList createGetMostViewedAuthorList() {
        return new GetMostViewedAuthorList();
    }

    /**
     * Create an instance of {@link ArrayOfAuthor }
     * 
     */
    public ArrayOfAuthor createArrayOfAuthor() {
        return new ArrayOfAuthor();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link ResultCollection }
     * 
     */
    public ResultCollection createResultCollection() {
        return new ResultCollection();
    }

    /**
     * Create an instance of {@link Keyword }
     * 
     */
    public Keyword createKeyword() {
        return new Keyword();
    }

    /**
     * Create an instance of {@link PublicationResponse }
     * 
     */
    public PublicationResponse createPublicationResponse() {
        return new PublicationResponse();
    }

    /**
     * Create an instance of {@link GetMostViewedAuthorListResponse }
     * 
     */
    public GetMostViewedAuthorListResponse createGetMostViewedAuthorListResponse() {
        return new GetMostViewedAuthorListResponse();
    }

    /**
     * Create an instance of {@link DomainResponse }
     * 
     */
    public DomainResponse createDomainResponse() {
        return new DomainResponse();
    }

    /**
     * Create an instance of {@link Journal }
     * 
     */
    public Journal createJournal() {
        return new Journal();
    }

    /**
     * Create an instance of {@link ArrayOfOrganization }
     * 
     */
    public ArrayOfOrganization createArrayOfOrganization() {
        return new ArrayOfOrganization();
    }

    /**
     * Create an instance of {@link JournalResponse }
     * 
     */
    public JournalResponse createJournalResponse() {
        return new JournalResponse();
    }

    /**
     * Create an instance of {@link CFPInfo }
     * 
     */
    public CFPInfo createCFPInfo() {
        return new CFPInfo();
    }

    /**
     * Create an instance of {@link GetLatestUpdatedPublicationListResponse }
     * 
     */
    public GetLatestUpdatedPublicationListResponse createGetLatestUpdatedPublicationListResponse() {
        return new GetLatestUpdatedPublicationListResponse();
    }

    /**
     * Create an instance of {@link GetPublicationByDOIResponse }
     * 
     */
    public GetPublicationByDOIResponse createGetPublicationByDOIResponse() {
        return new GetPublicationByDOIResponse();
    }

    /**
     * Create an instance of {@link SearchResponse }
     * 
     */
    public SearchResponse createSearchResponse() {
        return new SearchResponse();
    }

    /**
     * Create an instance of {@link ArrayOfJournal }
     * 
     */
    public ArrayOfJournal createArrayOfJournal() {
        return new ArrayOfJournal();
    }

    /**
     * Create an instance of {@link Domain }
     * 
     */
    public Domain createDomain() {
        return new Domain();
    }

    /**
     * Create an instance of {@link OrganizationResponse }
     * 
     */
    public OrganizationResponse createOrganizationResponse() {
        return new OrganizationResponse();
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link GetLatestUpdatedAuthorListResponse }
     * 
     */
    public GetLatestUpdatedAuthorListResponse createGetLatestUpdatedAuthorListResponse() {
        return new GetLatestUpdatedAuthorListResponse();
    }

    /**
     * Create an instance of {@link ArrayOfConference }
     * 
     */
    public ArrayOfConference createArrayOfConference() {
        return new ArrayOfConference();
    }

    /**
     * Create an instance of {@link ArrayOfDomain }
     * 
     */
    public ArrayOfDomain createArrayOfDomain() {
        return new ArrayOfDomain();
    }

    /**
     * Create an instance of {@link GetMostViewedPublicationList }
     * 
     */
    public GetMostViewedPublicationList createGetMostViewedPublicationList() {
        return new GetMostViewedPublicationList();
    }

    /**
     * Create an instance of {@link Publication }
     * 
     */
    public Publication createPublication() {
        return new Publication();
    }

    /**
     * Create an instance of {@link ArrayOfTrendPoint }
     * 
     */
    public ArrayOfTrendPoint createArrayOfTrendPoint() {
        return new ArrayOfTrendPoint();
    }

    /**
     * Create an instance of {@link TrendPoint }
     * 
     */
    public TrendPoint createTrendPoint() {
        return new TrendPoint();
    }

    /**
     * Create an instance of {@link GetPublicationByDOI }
     * 
     */
    public GetPublicationByDOI createGetPublicationByDOI() {
        return new GetPublicationByDOI();
    }

    /**
     * Create an instance of {@link GetLatestUpdatedPublicationList }
     * 
     */
    public GetLatestUpdatedPublicationList createGetLatestUpdatedPublicationList() {
        return new GetLatestUpdatedPublicationList();
    }

    /**
     * Create an instance of {@link KeywordResponse }
     * 
     */
    public KeywordResponse createKeywordResponse() {
        return new KeywordResponse();
    }

    /**
     * Create an instance of {@link GetSubDomainList }
     * 
     */
    public GetSubDomainList createGetSubDomainList() {
        return new GetSubDomainList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAuthor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ArrayOfAuthor")
    public JAXBElement<ArrayOfAuthor> createArrayOfAuthor(ArrayOfAuthor value) {
        return new JAXBElement<ArrayOfAuthor>(_ArrayOfAuthor_QNAME, ArrayOfAuthor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KeywordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "KeywordResponse")
    public JAXBElement<KeywordResponse> createKeywordResponse(KeywordResponse value) {
        return new JAXBElement<KeywordResponse>(_KeywordResponse_QNAME, KeywordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Domain }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Domain")
    public JAXBElement<Domain> createDomain(Domain value) {
        return new JAXBElement<Domain>(_Domain_QNAME, Domain.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDomain }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ArrayOfDomain")
    public JAXBElement<ArrayOfDomain> createArrayOfDomain(ArrayOfDomain value) {
        return new JAXBElement<ArrayOfDomain>(_ArrayOfDomain_QNAME, ArrayOfDomain.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPublication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ArrayOfPublication")
    public JAXBElement<ArrayOfPublication> createArrayOfPublication(ArrayOfPublication value) {
        return new JAXBElement<ArrayOfPublication>(_ArrayOfPublication_QNAME, ArrayOfPublication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfJournal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ArrayOfJournal")
    public JAXBElement<ArrayOfJournal> createArrayOfJournal(ArrayOfJournal value) {
        return new JAXBElement<ArrayOfJournal>(_ArrayOfJournal_QNAME, ArrayOfJournal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Publication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Publication")
    public JAXBElement<Publication> createPublication(Publication value) {
        return new JAXBElement<Publication>(_Publication_QNAME, Publication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JournalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "JournalResponse")
    public JAXBElement<JournalResponse> createJournalResponse(JournalResponse value) {
        return new JAXBElement<JournalResponse>(_JournalResponse_QNAME, JournalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "PublicationResponse")
    public JAXBElement<PublicationResponse> createPublicationResponse(PublicationResponse value) {
        return new JAXBElement<PublicationResponse>(_PublicationResponse_QNAME, PublicationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Organization }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Organization")
    public JAXBElement<Organization> createOrganization(Organization value) {
        return new JAXBElement<Organization>(_Organization_QNAME, Organization.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrendGraph }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "TrendGraph")
    public JAXBElement<TrendGraph> createTrendGraph(TrendGraph value) {
        return new JAXBElement<TrendGraph>(_TrendGraph_QNAME, TrendGraph.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Journal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Journal")
    public JAXBElement<Journal> createJournal(Journal value) {
        return new JAXBElement<Journal>(_Journal_QNAME, Journal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ArrayOfKeyword")
    public JAXBElement<ArrayOfKeyword> createArrayOfKeyword(ArrayOfKeyword value) {
        return new JAXBElement<ArrayOfKeyword>(_ArrayOfKeyword_QNAME, ArrayOfKeyword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Conference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Conference")
    public JAXBElement<Conference> createConference(Conference value) {
        return new JAXBElement<Conference>(_Conference_QNAME, Conference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ResultCollection")
    public JAXBElement<ResultCollection> createResultCollection(ResultCollection value) {
        return new JAXBElement<ResultCollection>(_ResultCollection_QNAME, ResultCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConferenceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ConferenceResponse")
    public JAXBElement<ConferenceResponse> createConferenceResponse(ConferenceResponse value) {
        return new JAXBElement<ConferenceResponse>(_ConferenceResponse_QNAME, ConferenceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrendPoint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "TrendPoint")
    public JAXBElement<TrendPoint> createTrendPoint(TrendPoint value) {
        return new JAXBElement<TrendPoint>(_TrendPoint_QNAME, TrendPoint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CFPInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "CFPInfo")
    public JAXBElement<CFPInfo> createCFPInfo(CFPInfo value) {
        return new JAXBElement<CFPInfo>(_CFPInfo_QNAME, CFPInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Response")
    public JAXBElement<Response> createResponse(Response value) {
        return new JAXBElement<Response>(_Response_QNAME, Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "OrganizationResponse")
    public JAXBElement<OrganizationResponse> createOrganizationResponse(OrganizationResponse value) {
        return new JAXBElement<OrganizationResponse>(_OrganizationResponse_QNAME, OrganizationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOrganization }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ArrayOfOrganization")
    public JAXBElement<ArrayOfOrganization> createArrayOfOrganization(ArrayOfOrganization value) {
        return new JAXBElement<ArrayOfOrganization>(_ArrayOfOrganization_QNAME, ArrayOfOrganization.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfTrendPoint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ArrayOfTrendPoint")
    public JAXBElement<ArrayOfTrendPoint> createArrayOfTrendPoint(ArrayOfTrendPoint value) {
        return new JAXBElement<ArrayOfTrendPoint>(_ArrayOfTrendPoint_QNAME, ArrayOfTrendPoint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomainResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "DomainResponse")
    public JAXBElement<DomainResponse> createDomainResponse(DomainResponse value) {
        return new JAXBElement<DomainResponse>(_DomainResponse_QNAME, DomainResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Keyword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Keyword")
    public JAXBElement<Keyword> createKeyword(Keyword value) {
        return new JAXBElement<Keyword>(_Keyword_QNAME, Keyword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfConference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ArrayOfConference")
    public JAXBElement<ArrayOfConference> createArrayOfConference(ArrayOfConference value) {
        return new JAXBElement<ArrayOfConference>(_ArrayOfConference_QNAME, ArrayOfConference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "AuthorResponse")
    public JAXBElement<AuthorResponse> createAuthorResponse(AuthorResponse value) {
        return new JAXBElement<AuthorResponse>(_AuthorResponse_QNAME, AuthorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Request }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Request")
    public JAXBElement<Request> createRequest(Request value) {
        return new JAXBElement<Request>(_Request_QNAME, Request.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Author }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Author")
    public JAXBElement<Author> createAuthor(Author value) {
        return new JAXBElement<Author>(_Author_QNAME, Author.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Name", scope = Organization.class)
    public JAXBElement<String> createOrganizationName(String value) {
        return new JAXBElement<String>(_OrganizationName_QNAME, String.class, Organization.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "HomepageURL", scope = Organization.class)
    public JAXBElement<String> createOrganizationHomepageURL(String value) {
        return new JAXBElement<String>(_OrganizationHomepageURL_QNAME, String.class, Organization.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDomain }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ResearchInterestDomain", scope = Organization.class)
    public JAXBElement<ArrayOfDomain> createOrganizationResearchInterestDomain(ArrayOfDomain value) {
        return new JAXBElement<ArrayOfDomain>(_OrganizationResearchInterestDomain_QNAME, ArrayOfDomain.class, Organization.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfTrendPoint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Trend", scope = TrendGraph.class)
    public JAXBElement<ArrayOfTrendPoint> createTrendGraphTrend(ArrayOfTrendPoint value) {
        return new JAXBElement<ArrayOfTrendPoint>(_TrendGraphTrend_QNAME, ArrayOfTrendPoint.class, TrendGraph.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomainResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "GetDomainListResult", scope = GetDomainListResponse.class)
    public JAXBElement<DomainResponse> createGetDomainListResponseGetDomainListResult(DomainResponse value) {
        return new JAXBElement<DomainResponse>(_GetDomainListResponseGetDomainListResult_QNAME, DomainResponse.class, GetDomainListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAuthor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Result", scope = AuthorResponse.class)
    public JAXBElement<ArrayOfAuthor> createAuthorResponseResult(ArrayOfAuthor value) {
        return new JAXBElement<ArrayOfAuthor>(_AuthorResponseResult_QNAME, ArrayOfAuthor.class, AuthorResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "GetMostViewedPublicationListResult", scope = GetMostViewedPublicationListResponse.class)
    public JAXBElement<PublicationResponse> createGetMostViewedPublicationListResponseGetMostViewedPublicationListResult(PublicationResponse value) {
        return new JAXBElement<PublicationResponse>(_GetMostViewedPublicationListResponseGetMostViewedPublicationListResult_QNAME, PublicationResponse.class, GetMostViewedPublicationListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Request }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "request", scope = Search.class)
    public JAXBElement<Request> createSearchRequest(Request value) {
        return new JAXBElement<Request>(_SearchRequest_QNAME, Request.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfConference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Result", scope = ConferenceResponse.class)
    public JAXBElement<ArrayOfConference> createConferenceResponseResult(ArrayOfConference value) {
        return new JAXBElement<ArrayOfConference>(_AuthorResponseResult_QNAME, ArrayOfConference.class, ConferenceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CFPInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "CFP", scope = Conference.class)
    public JAXBElement<CFPInfo> createConferenceCFP(CFPInfo value) {
        return new JAXBElement<CFPInfo>(_ConferenceCFP_QNAME, CFPInfo.class, Conference.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ShortName", scope = Conference.class)
    public JAXBElement<String> createConferenceShortName(String value) {
        return new JAXBElement<String>(_ConferenceShortName_QNAME, String.class, Conference.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "HomepageURL", scope = Conference.class)
    public JAXBElement<String> createConferenceHomepageURL(String value) {
        return new JAXBElement<String>(_OrganizationHomepageURL_QNAME, String.class, Conference.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "FullName", scope = Conference.class)
    public JAXBElement<String> createConferenceFullName(String value) {
        return new JAXBElement<String>(_ConferenceFullName_QNAME, String.class, Conference.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDomain }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ResearchInterestDomain", scope = Conference.class)
    public JAXBElement<ArrayOfDomain> createConferenceResearchInterestDomain(ArrayOfDomain value) {
        return new JAXBElement<ArrayOfDomain>(_OrganizationResearchInterestDomain_QNAME, ArrayOfDomain.class, Conference.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomainResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "GetSubDomainListResult", scope = GetSubDomainListResponse.class)
    public JAXBElement<DomainResponse> createGetSubDomainListResponseGetSubDomainListResult(DomainResponse value) {
        return new JAXBElement<DomainResponse>(_GetSubDomainListResponseGetSubDomainListResult_QNAME, DomainResponse.class, GetSubDomainListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "MiddleName", scope = Author.class)
    public JAXBElement<String> createAuthorMiddleName(String value) {
        return new JAXBElement<String>(_AuthorMiddleName_QNAME, String.class, Author.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "NativeName", scope = Author.class)
    public JAXBElement<String> createAuthorNativeName(String value) {
        return new JAXBElement<String>(_AuthorNativeName_QNAME, String.class, Author.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Organization }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Affiliation", scope = Author.class)
    public JAXBElement<Organization> createAuthorAffiliation(Organization value) {
        return new JAXBElement<Organization>(_AuthorAffiliation_QNAME, Organization.class, Author.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "HomepageURL", scope = Author.class)
    public JAXBElement<String> createAuthorHomepageURL(String value) {
        return new JAXBElement<String>(_OrganizationHomepageURL_QNAME, String.class, Author.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDomain }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ResearchInterestDomain", scope = Author.class)
    public JAXBElement<ArrayOfDomain> createAuthorResearchInterestDomain(ArrayOfDomain value) {
        return new JAXBElement<ArrayOfDomain>(_OrganizationResearchInterestDomain_QNAME, ArrayOfDomain.class, Author.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "FirstName", scope = Author.class)
    public JAXBElement<String> createAuthorFirstName(String value) {
        return new JAXBElement<String>(_AuthorFirstName_QNAME, String.class, Author.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "DisplayPhotoURL", scope = Author.class)
    public JAXBElement<String> createAuthorDisplayPhotoURL(String value) {
        return new JAXBElement<String>(_AuthorDisplayPhotoURL_QNAME, String.class, Author.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "LastName", scope = Author.class)
    public JAXBElement<String> createAuthorLastName(String value) {
        return new JAXBElement<String>(_AuthorLastName_QNAME, String.class, Author.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Name", scope = Keyword.class)
    public JAXBElement<String> createKeywordName(String value) {
        return new JAXBElement<String>(_OrganizationName_QNAME, String.class, Keyword.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPublication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Result", scope = PublicationResponse.class)
    public JAXBElement<ArrayOfPublication> createPublicationResponseResult(ArrayOfPublication value) {
        return new JAXBElement<ArrayOfPublication>(_AuthorResponseResult_QNAME, ArrayOfPublication.class, PublicationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "GetMostViewedAuthorListResult", scope = GetMostViewedAuthorListResponse.class)
    public JAXBElement<AuthorResponse> createGetMostViewedAuthorListResponseGetMostViewedAuthorListResult(AuthorResponse value) {
        return new JAXBElement<AuthorResponse>(_GetMostViewedAuthorListResponseGetMostViewedAuthorListResult_QNAME, AuthorResponse.class, GetMostViewedAuthorListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDomain }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Result", scope = DomainResponse.class)
    public JAXBElement<ArrayOfDomain> createDomainResponseResult(ArrayOfDomain value) {
        return new JAXBElement<ArrayOfDomain>(_AuthorResponseResult_QNAME, ArrayOfDomain.class, DomainResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ShortName", scope = Journal.class)
    public JAXBElement<String> createJournalShortName(String value) {
        return new JAXBElement<String>(_ConferenceShortName_QNAME, String.class, Journal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "HomepageURL", scope = Journal.class)
    public JAXBElement<String> createJournalHomepageURL(String value) {
        return new JAXBElement<String>(_OrganizationHomepageURL_QNAME, String.class, Journal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "FullName", scope = Journal.class)
    public JAXBElement<String> createJournalFullName(String value) {
        return new JAXBElement<String>(_ConferenceFullName_QNAME, String.class, Journal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ISSN", scope = Journal.class)
    public JAXBElement<String> createJournalISSN(String value) {
        return new JAXBElement<String>(_JournalISSN_QNAME, String.class, Journal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDomain }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "ResearchInterestDomain", scope = Journal.class)
    public JAXBElement<ArrayOfDomain> createJournalResearchInterestDomain(ArrayOfDomain value) {
        return new JAXBElement<ArrayOfDomain>(_OrganizationResearchInterestDomain_QNAME, ArrayOfDomain.class, Journal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfJournal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Result", scope = JournalResponse.class)
    public JAXBElement<ArrayOfJournal> createJournalResponseResult(ArrayOfJournal value) {
        return new JAXBElement<ArrayOfJournal>(_AuthorResponseResult_QNAME, ArrayOfJournal.class, JournalResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "AgendaUrl", scope = CFPInfo.class)
    public JAXBElement<String> createCFPInfoAgendaUrl(String value) {
        return new JAXBElement<String>(_CFPInfoAgendaUrl_QNAME, String.class, CFPInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "HomepageURL", scope = CFPInfo.class)
    public JAXBElement<String> createCFPInfoHomepageURL(String value) {
        return new JAXBElement<String>(_OrganizationHomepageURL_QNAME, String.class, CFPInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "City", scope = CFPInfo.class)
    public JAXBElement<String> createCFPInfoCity(String value) {
        return new JAXBElement<String>(_CFPInfoCity_QNAME, String.class, CFPInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Country", scope = CFPInfo.class)
    public JAXBElement<String> createCFPInfoCountry(String value) {
        return new JAXBElement<String>(_CFPInfoCountry_QNAME, String.class, CFPInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "GetLatestUpdatedPublicationListResult", scope = GetLatestUpdatedPublicationListResponse.class)
    public JAXBElement<PublicationResponse> createGetLatestUpdatedPublicationListResponseGetLatestUpdatedPublicationListResult(PublicationResponse value) {
        return new JAXBElement<PublicationResponse>(_GetLatestUpdatedPublicationListResponseGetLatestUpdatedPublicationListResult_QNAME, PublicationResponse.class, GetLatestUpdatedPublicationListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "SearchResult", scope = SearchResponse.class)
    public JAXBElement<Response> createSearchResponseSearchResult(Response value) {
        return new JAXBElement<Response>(_SearchResponseSearchResult_QNAME, Response.class, SearchResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "GetPublicationByDOIResult", scope = GetPublicationByDOIResponse.class)
    public JAXBElement<PublicationResponse> createGetPublicationByDOIResponseGetPublicationByDOIResult(PublicationResponse value) {
        return new JAXBElement<PublicationResponse>(_GetPublicationByDOIResponseGetPublicationByDOIResult_QNAME, PublicationResponse.class, GetPublicationByDOIResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Name", scope = Domain.class)
    public JAXBElement<String> createDomainName(String value) {
        return new JAXBElement<String>(_OrganizationName_QNAME, String.class, Domain.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOrganization }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Result", scope = OrganizationResponse.class)
    public JAXBElement<ArrayOfOrganization> createOrganizationResponseResult(ArrayOfOrganization value) {
        return new JAXBElement<ArrayOfOrganization>(_AuthorResponseResult_QNAME, ArrayOfOrganization.class, OrganizationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KeywordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Keyword", scope = Response.class)
    public JAXBElement<KeywordResponse> createResponseKeyword(KeywordResponse value) {
        return new JAXBElement<KeywordResponse>(_Keyword_QNAME, KeywordResponse.class, Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JournalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Journal", scope = Response.class)
    public JAXBElement<JournalResponse> createResponseJournal(JournalResponse value) {
        return new JAXBElement<JournalResponse>(_Journal_QNAME, JournalResponse.class, Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomainResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Domain", scope = Response.class)
    public JAXBElement<DomainResponse> createResponseDomain(DomainResponse value) {
        return new JAXBElement<DomainResponse>(_Domain_QNAME, DomainResponse.class, Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Organization", scope = Response.class)
    public JAXBElement<OrganizationResponse> createResponseOrganization(OrganizationResponse value) {
        return new JAXBElement<OrganizationResponse>(_Organization_QNAME, OrganizationResponse.class, Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Publication", scope = Response.class)
    public JAXBElement<PublicationResponse> createResponsePublication(PublicationResponse value) {
        return new JAXBElement<PublicationResponse>(_Publication_QNAME, PublicationResponse.class, Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Author", scope = Response.class)
    public JAXBElement<AuthorResponse> createResponseAuthor(AuthorResponse value) {
        return new JAXBElement<AuthorResponse>(_Author_QNAME, AuthorResponse.class, Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrendGraph }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Trend", scope = Response.class)
    public JAXBElement<TrendGraph> createResponseTrend(TrendGraph value) {
        return new JAXBElement<TrendGraph>(_TrendGraphTrend_QNAME, TrendGraph.class, Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConferenceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Conference", scope = Response.class)
    public JAXBElement<ConferenceResponse> createResponseConference(ConferenceResponse value) {
        return new JAXBElement<ConferenceResponse>(_Conference_QNAME, ConferenceResponse.class, Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Version", scope = Response.class)
    public JAXBElement<String> createResponseVersion(String value) {
        return new JAXBElement<String>(_ResponseVersion_QNAME, String.class, Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "GetLatestUpdatedAuthorListResult", scope = GetLatestUpdatedAuthorListResponse.class)
    public JAXBElement<AuthorResponse> createGetLatestUpdatedAuthorListResponseGetLatestUpdatedAuthorListResult(AuthorResponse value) {
        return new JAXBElement<AuthorResponse>(_GetLatestUpdatedAuthorListResponseGetLatestUpdatedAuthorListResult_QNAME, AuthorResponse.class, GetLatestUpdatedAuthorListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Keyword", scope = Publication.class)
    public JAXBElement<ArrayOfKeyword> createPublicationKeyword(ArrayOfKeyword value) {
        return new JAXBElement<ArrayOfKeyword>(_Keyword_QNAME, ArrayOfKeyword.class, Publication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "FullVersionURL", scope = Publication.class)
    public JAXBElement<ArrayOfstring> createPublicationFullVersionURL(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_PublicationFullVersionURL_QNAME, ArrayOfstring.class, Publication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Journal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Journal", scope = Publication.class)
    public JAXBElement<Journal> createPublicationJournal(Journal value) {
        return new JAXBElement<Journal>(_Journal_QNAME, Journal.class, Publication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAuthor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Author", scope = Publication.class)
    public JAXBElement<ArrayOfAuthor> createPublicationAuthor(ArrayOfAuthor value) {
        return new JAXBElement<ArrayOfAuthor>(_Author_QNAME, ArrayOfAuthor.class, Publication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Abstract", scope = Publication.class)
    public JAXBElement<String> createPublicationAbstract(String value) {
        return new JAXBElement<String>(_PublicationAbstract_QNAME, String.class, Publication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Title", scope = Publication.class)
    public JAXBElement<String> createPublicationTitle(String value) {
        return new JAXBElement<String>(_PublicationTitle_QNAME, String.class, Publication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "CitationContext", scope = Publication.class)
    public JAXBElement<ArrayOfstring> createPublicationCitationContext(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_PublicationCitationContext_QNAME, ArrayOfstring.class, Publication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Conference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Conference", scope = Publication.class)
    public JAXBElement<Conference> createPublicationConference(Conference value) {
        return new JAXBElement<Conference>(_Conference_QNAME, Conference.class, Publication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "DOI", scope = Publication.class)
    public JAXBElement<String> createPublicationDOI(String value) {
        return new JAXBElement<String>(_PublicationDOI_QNAME, String.class, Publication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "doi", scope = GetPublicationByDOI.class)
    public JAXBElement<String> createGetPublicationByDOIDoi(String value) {
        return new JAXBElement<String>(_GetPublicationByDOIDoi_QNAME, String.class, GetPublicationByDOI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://research.microsoft.com", name = "Result", scope = KeywordResponse.class)
    public JAXBElement<ArrayOfKeyword> createKeywordResponseResult(ArrayOfKeyword value) {
        return new JAXBElement<ArrayOfKeyword>(_AuthorResponseResult_QNAME, ArrayOfKeyword.class, KeywordResponse.class, value);
    }

}
