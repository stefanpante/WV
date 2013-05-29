package data;

import java.util.ArrayList;
import java.util.HashSet;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONParser {
	
	public static Publication extractSearchResult(JsonObject publication){
		Gson gson = new Gson();
	    String title = gson.fromJson(publication.get("Title"), String.class);
	    String abstr = gson.fromJson(publication.get("Abstract"), String.class);
	    String year = gson.fromJson(publication.get("Year"), String.class);
	    String cited = gson.fromJson(publication.get("CitationCount"), String.class);
	    JsonArray authorObject = publication.getAsJsonArray("Author");
	    int id = gson.fromJson(publication.get("ID"), Integer.class);
	    ArrayList<String> authors = extractAuthors(authorObject);
	    //TODO
	    return null;
	    //return new Publication(title, abstr, cited, year, authors, null,id);
	}

	public static Publication extractPublication(JsonObject publication) {
		Gson gson = new Gson();
	    String title = gson.fromJson(publication.get("Title"), String.class);
	    String abstr = gson.fromJson(publication.get("Abstract"), String.class);
	    int year = gson.fromJson(publication.get("Year"), Integer.class);
	    int id = gson.fromJson(publication.get("ID"), Integer.class);
	    int cited = gson.fromJson(publication.get("CitationCount"), Integer.class);
	    String conference = gson.fromJson(publication.get("conference"), String.class);
	    String journal = gson.fromJson(publication.get("journal"), String.class);
	    String url = "http://academic.research.microsoft.com/Publication/"+id;
	    
	    JsonArray authorObject = publication.getAsJsonArray("Author");
	    ArrayList<String> authors = extractAuthors(authorObject);
		return new Publication(id, title, year, cited, abstr, authors, conference, journal, url);
	}

	private static ArrayList<String> extractAuthors(JsonArray authorObject) {
		ArrayList<String> result = new ArrayList<String>();
		for(JsonElement  element : authorObject){
			JsonObject author = element.getAsJsonObject();
			String firstName = author.get("FirstName").getAsString();
			String middleName = author.get("MiddleName").getAsString();
			String lastName = author.get("LastName").getAsString(); 
			String fullName = middleName.equals("") ? firstName + " " + lastName : firstName + " " + middleName + " " + lastName;
			result.add(fullName);
		}
		return result;
	}
	
	public static JsonArray extractPublicationArray(String json) {
		JsonParser parser = new JsonParser();
	    JsonObject result = parser.parse(json).getAsJsonObject();
	    result = result.get("d").getAsJsonObject();
	    JsonObject publication = result.get("Publication").getAsJsonObject();
	    JsonArray resultArray = publication.get("Result").getAsJsonArray();
		return resultArray;
	}
	
	public static HashSet<Publication> extractPublications(String json) {
		JsonArray resultArray = JSONParser.extractPublicationArray(json);
		HashSet<Publication> result = new HashSet<Publication>();
		for(JsonElement element : resultArray){
			Publication pub = JSONParser.extractPublication(element.getAsJsonObject());
			result.add(pub);
		}
		return result;
		
	}

}
