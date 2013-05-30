package data.publication;

import visualisation.Application;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import data.net.HTTP;
import data.net.JSONParser;

public class PublicationFactory {

	public static void main(String[] args) throws Exception {
		Publication pub = fromAcademicsAPI(777102);
		System.out.println(pub.createFields().get(0).getContent());
	}

	public static Publication fromAcademicsAPI(int id) {
		String json = HTTP
				.loadURL("http://academic.research.microsoft.com/json.svc/search?AppId="
						+ Application.APP_ID
						+ "&PublicationID="
						+ id
						+ "&ResultObjects=Publication&PublicationContent=AllInfo&StartIdx=1&EndIdx=1");
		JsonArray resultArray = JSONParser.extractPublicationArray(json);
		JsonObject publication = resultArray.get(0).getAsJsonObject();
		return JSONParser.extractPublication(publication);

	}

}
