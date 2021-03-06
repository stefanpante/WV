package data.net;

import java.util.ArrayList;
import java.util.Iterator;

import visualisation.Application;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import data.publication.Publication;
import data.publication.PublicationSearcher;

public class AcademicsSearcher extends PublicationSearcher {

	@Override
	public ArrayList<Publication> generalSearch(String query, int results) {
		if (query.equals("") || query == null)
			return new ArrayList<Publication>();
		ArrayList<Publication> searchResults = new ArrayList<Publication>();
		if (Application.api) {
			try {
				String actualQuery = query.replaceAll(" ", "+");
				String json = HTTP
						.loadURL("http://academic.research.microsoft.com/json.svc/search?AppId="
								+ Application.APP_ID
								+ "&FullTextQuery="
								+ actualQuery
								+ "&ResultObjects=Publication&PublicationContent=AllInfo&StartIdx=1&EndIdx="
								+ results);
				JsonArray resultArray = JSONParser
						.extractPublicationArray(json);
				Iterator<JsonElement> iterator = resultArray.iterator();
				while (iterator.hasNext()) {
					JsonElement next = iterator.next();
					JsonObject publication = next.getAsJsonObject();
					Publication result = JSONParser
							.extractPublication(publication);
					searchResults.add(result);
				}
			} catch (IllegalStateException ignore) {
				Application.api = false;
			}
		}
		if(!Application.api){
			AcademicsScraper scraper = new AcademicsScraper();
			return scraper.scrapeByQuery(query);
		}
		return searchResults;
	}

}
