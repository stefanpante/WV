package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import scraper.AcademicsScraper;
import visualisation.Application;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PublicationFactory {

	public static void main(String[] args) throws Exception {
		Publication pub = fromAcademicsID(777102);
		System.out.println(pub.createFields().get(0).getContent());
	}

	public static Publication fromAcademicsID(int id) {
		if (Application.api) {
			String json = HTTP
					.loadURL("http://academic.research.microsoft.com/json.svc/search?AppId="
							+ Application.APP_ID
							+ "&PublicationID="
							+ id
							+ "&ResultObjects=Publication&PublicationContent=AllInfo&StartIdx=1&EndIdx=1");
			JsonArray resultArray = JSONParser.extractPublicationArray(json);
			JsonObject publication = resultArray.get(0).getAsJsonObject();
			return JSONParser.extractPublication(publication);
		} else {
			AcademicsScraper scraper = new AcademicsScraper();
			return scraper.scrapeById(id);
		}
	}


	public static Publication fromSearchResult(Publication result) {
		return result;
	}

}
