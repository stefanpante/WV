package data.publication;

import java.util.HashSet;

import data.net.AcademicsScraper;
import data.net.HTTP;
import data.net.JSONParser;

import visualisation.Application;

public class CitationFactory {

	public static HashSet<Publication> forwardCitationsFromAcademics(int id) {
		HashSet<Publication> result = null;
		if (Application.api) {
			String json = HTTP.loadURL("http://academic.research.microsoft.com/json.svc/search?AppId="+ Application.APP_ID+"&PublicationID="+id+"&ResultObjects=Publication&ReferenceType=Citation&StartIdx=1&EndIdx=100");
			try{
				result = JSONParser.extractPublications(json);
			} catch (IllegalStateException ignore) {
				Application.api = false;
			}
		}
		if(!Application.api){
			AcademicsScraper scraper = new AcademicsScraper();
			result = scraper.scrapeForwardCitations(id);
		}
		return result;
	}


	public static HashSet<Publication> backwardCitationsFromAcademics(int id) {
		HashSet<Publication> result = null;
		if (Application.api) {
			String json = HTTP.loadURL("http://academic.research.microsoft.com/json.svc/search?AppId="+ Application.APP_ID+"&PublicationID="+id+"&ResultObjects=Publication&ReferenceType=Reference&StartIdx=1&EndIdx=100");
			try{
				result = JSONParser.extractPublications(json);
			} catch (IllegalStateException ignore) {
				Application.api = false;
			}
		}
		if(!Application.api){
			AcademicsScraper scraper = new AcademicsScraper();
			result = scraper.scrapeBackwardCitations(id);
		}

		return result;
	}
}
