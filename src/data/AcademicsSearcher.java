package data;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import lucene.PublicationSearcher;
import lucene.SearchResult;

public class AcademicsSearcher extends PublicationSearcher{
	
	public static void main(String[] args) throws Exception{
		AcademicsSearcher searcher = new AcademicsSearcher();
		System.out.println(searcher.generalSearch("kobe", 10));
	}

	@Override
	public ArrayList<SearchResult> generalSearch(String query, int results)
			throws Exception {
		if(query.equals("") || query == null) return new ArrayList<SearchResult>();
		String actualQuery = query.replaceAll(" ", "+");
		String json = HTTP.loadURL("http://academic.research.microsoft.com/json.svc/search?AppId=406aea44-49a6-4753-ad34-3c4863221e5c&FullTextQuery="+actualQuery+"&ResultObjects=Publication&PublicationContent=AllInfo&StartIdx=1&EndIdx="+results);
		JsonArray resultArray = JSONParser.extractPublicationArray(json);
		Iterator<JsonElement> iterator = resultArray.iterator();
		ArrayList<SearchResult> searchResults = new ArrayList<SearchResult>();
		while(iterator.hasNext()){
			JsonElement next = iterator.next();
			System.out.println(next);
			JsonObject publication = next.getAsJsonObject();
			SearchResult result = JSONParser.extractSearchResult(publication);
			searchResults.add(result);
		}
		return searchResults;
	}

	

}
