package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import scraper.Scraper;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class CitationFactory {
	
	public static void main(String[] args) throws Exception{
		HashSet<Publication> citations = backwardCitationsFromAcademics(777102);
		for(Publication pub : citations){
			System.out.println(pub.createFields().get(0).getContent());
		}
	}
	
	public static HashSet<Publication> forwardCitationsFromAcademics(int id) throws Exception{
		String json = HTTP.loadURL("http://academic.research.microsoft.com/json.svc/search?AppId=406aea44-49a6-4753-ad34-3c4863221e5c&PublicationID="+id+"&ResultObjects=Publication&ReferenceType=Citation&StartIdx=1&EndIdx=100");
		HashSet<Publication> result = JSONParser.extractPublications(json);
		return result;
	}


	
	public static HashSet<Publication> backwardCitationsFromAcademics(int id) throws Exception{
		String json = HTTP.loadURL("http://academic.research.microsoft.com/json.svc/search?AppId=406aea44-49a6-4753-ad34-3c4863221e5c&PublicationID="+id+"&ResultObjects=Publication&ReferenceType=Reference&StartIdx=1&EndIdx=100");
		HashSet<Publication> result = JSONParser.extractPublications(json);
		return result;
	}
	
	public static HashSet<Publication> forwardCitationsFromDatabase(int databaseID) throws SQLException{
		HashSet<Publication> result = new HashSet<Publication>();
		ResultSet resultSet = SQLConnector.select("from_id", "citation", "to_id", ""+databaseID);
		while(resultSet.next()) result.add(PublicationFactory.fromDatabaseID(resultSet.getInt("from_id")));
		return result;
	}
	
	public static HashSet<Publication> backwardCitationsFromDatabase(int databaseID) throws SQLException{
		HashSet<Publication> result = new HashSet<Publication>();
		ResultSet resultSet = SQLConnector.select("to_id", "citation", "from_id", ""+databaseID);
		while(resultSet.next()) result.add(PublicationFactory.fromDatabaseID(resultSet.getInt("to_id")));
		return result;
	}

}
