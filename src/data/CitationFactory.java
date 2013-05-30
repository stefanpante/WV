package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import visualisation.Application;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class CitationFactory {

	public static void main(String[] args) throws Exception {
		HashSet<Publication> citations = backwardCitationsFromAcademics(777102);
		for (Publication pub : citations) {
		}
	}
	public static HashSet<Publication> forwardCitationsFromAcademics(int id) {
		HashSet<Publication> result;
		if (Application.api) {
			String json = HTTP.loadURL("http://academic.research.microsoft.com/json.svc/search?AppId="+ Application.APP_ID+"&PublicationID="+id+"&ResultObjects=Publication&ReferenceType=Citation&StartIdx=1&EndIdx=100");
			result = JSONParser.extractPublications(json);
		} else {
			AcademicsScraper scraper = new AcademicsScraper();
			result = scraper.scrapeForwardCitations(id);
		}
		return result;
	}


	public static HashSet<Publication> backwardCitationsFromAcademics(int id) {
		HashSet<Publication> result;
		if (Application.api) {
			String json = HTTP.loadURL("http://academic.research.microsoft.com/json.svc/search?AppId="+ Application.APP_ID+"&PublicationID="+id+"&ResultObjects=Publication&ReferenceType=Reference&StartIdx=1&EndIdx=100");
			result = JSONParser.extractPublications(json);
		} else {
			AcademicsScraper scraper = new AcademicsScraper();
			result = scraper.scrapeBackwardCitations(id);
		}

		return result;
	}
}
