package data;

import java.util.ArrayList;
import java.util.Iterator;

import scraper.AcademicsScraper;
import visualisation.Application;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import lucene.PublicationSearcher;

public class AcademicsSearcher extends PublicationSearcher {

	public static void main(String[] args) throws Exception {
		AcademicsSearcher searcher = new AcademicsSearcher();
		System.out.println(searcher.generalSearch("kobe", 10));
	}

	@Override
	public ArrayList<Publication> generalSearch(String query, int results) {
		if (query.equals("") || query == null)
			return new ArrayList<Publication>();
		ArrayList<Publication> searchResults = new ArrayList<Publication>();
		if (Application.api) {
			String actualQuery = query.replaceAll(" ", "+");
			String json = HTTP
					.loadURL("http://academic.research.microsoft.com/json.svc/search?AppId="
							+ Application.APP_ID
							+ "&FullTextQuery="
							+ actualQuery
							+ "&ResultObjects=Publication&PublicationContent=AllInfo&StartIdx=1&EndIdx="
							+ results);
			JsonArray resultArray = JSONParser.extractPublicationArray(json);
			Iterator<JsonElement> iterator = resultArray.iterator();
			while (iterator.hasNext()) {
				JsonElement next = iterator.next();
				System.out.println(next);
				JsonObject publication = next.getAsJsonObject();
				Publication result = JSONParser
						.extractSearchResult(publication);
				searchResults.add(result);
			}
		} else {
			AcademicsScraper scraper = new AcademicsScraper();
			return scraper.scrapeByQuery(query);
		}
		return searchResults;
	}

}
