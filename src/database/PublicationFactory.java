package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PublicationFactory {

	public static Publication fromDatabaseID(int id) throws SQLException{
		ResultSet results = SQLConnector.select("title,year,cited,abstract", "publication", "id", ""+id);
		results.next();
		
		Publication pub = new Publication(id, results.getString("title"), results.getInt("year"), results.getInt("cited"), results.getString("abstract"), getAuthors(id));
		return pub;
	}
	
	private static ArrayList<String> getAuthors(int id) throws SQLException{
		System.out.println("getAuthors()");
		ResultSet authors = SQLConnector.select("author_id", "authorship", "publication_id", ""+id);
		ArrayList<String> authorids = new ArrayList<String>();

		while(authors.next()){
			System.out.println("exe");
			authorids.add(authors.getString("author_id"));
			System.out.println(authors.getString("author_id"));
		}
		
		ArrayList<String> authorsList = new ArrayList<String>();
		for(String authorid: authorids){
			ResultSet author = SQLConnector.select("first_name,last_name", "author", "id", authorid);
			author.next();
			authorsList.add(authors.getString("first_name") + " " + authors.getString("last_name"));
		}
		return authorsList;
	}

}
