package SOAP;



import org.datacontract.schemas._2004._07.libra_service.ObjectType;
import org.datacontract.schemas._2004._07.libra_service.OrderType;
import org.datacontract.schemas._2004._07.libra_service.ReferenceRelationship;
import org.datacontract.schemas._2004._07.libra_service.SuggestionType;
import org.tempuri.APIService;

import com.microsoft.research.Request;
import com.microsoft.research.Response;

public class Client {

	public static void main(String[] args) {
		//IAPIService
		Request request = new Request();
		request.setAppID("406aea44-49a6-4753-ad34-3c4863221e5c");
		request.setReferenceType(ReferenceRelationship.NONE);
		request.setSuggestion(SuggestionType.NONE);
		request.setResultObjects(ObjectType.PUBLICATION);
		request.setFulltextQuery("data mining");
		request.setOrderBy(OrderType.CITATION_COUNT);
		request.setStartIdx(1);
		request.setEndIdx(1);
		
		APIService service = new APIService();
		Response response = service.getBasicHttpBindingIAPIService().search(request);
		System.out.println(response);
	/*	List<Publication> publications = response.getPublication().getValue().getResult().getValue().getPublication();
		System.out.println("Found "+publications.size()+" results");
		for(Publication publication : publications){
			System.out.println(publication.getTitle().getValue());
		}*/
		
		//PublicationContentType type = PublicationContentType.ALL_INFO;
	//ArrayOfPublicationContentType arr = new ArrayOfPublicationContentType();
		//request.setPublicationContent(value);
		//Response response = client.
				

	}
}
