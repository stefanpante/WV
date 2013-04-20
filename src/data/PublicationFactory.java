package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import scraper.Scraper;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PublicationFactory {
	
	public static void main(String[] args) throws Exception{
		Publication pub = fromAcademicsID(777102);
		System.out.println(pub.createFields().get(0).getContent());
	}
	
	public static Publication fromAcademicsID(int id) throws Exception{
		String json = HTTP.loadURL("http://academic.research.microsoft.com/json.svc/search?AppId=406aea44-49a6-4753-ad34-3c4863221e5c&PublicationID="+id+"&ResultObjects=Publication&PublicationContent=AllInfo&StartIdx=1&EndIdx=1");
		JsonArray resultArray = JSONParser.extractPublicationArray(json);
		JsonObject publication = resultArray.get(0).getAsJsonObject();
	    return JSONParser.extractPublication(publication);
	}

	
	

	public static Publication fromDatabaseID(int id) throws SQLException{
		ResultSet results = SQLConnector.select("title,year,cited,abstract", "publication", "id", ""+id);
		results.next();
		
		Publication pub = new Publication(id, results.getString("title"), results.getInt("year"), results.getInt("cited"), results.getString("abstract"), getAuthors(id));
		return pub;
	}
	
	private static ArrayList<String> getAuthors(int id) throws SQLException{
		ResultSet authors = SQLConnector.select("author_id", "authorship", "publication_id", ""+id);
		ArrayList<String> authorids = new ArrayList<String>();
		while(authors.next()){
			authorids.add(authors.getString("author_id"));
		}
		ArrayList<String> authorsList = new ArrayList<String>();
		for(String authorid: authorids){
			ResultSet author = SQLConnector.select("name", "author", "id", authorid);
			author.next();
			authorsList.add(author.getString(1));
		}
		return authorsList;
	}

}
