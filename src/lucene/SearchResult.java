package lucene;

import java.util.ArrayList;

public class SearchResult {
	
	
	public  int databaseID;
	public  String title;
	public  String abstr;
	public  String year;
	public  String citations;
	public  ArrayList<String> authors;
	public  String[] venues;
	public static SearchResult loading = new SearchResult("Processing your query, please wait...");

	public SearchResult(String title){
		this.title = title;
	}

	public SearchResult( String title,  String abstr,  String citations,  String year,  ArrayList<String> authors,  String[] venues,  int databaseID){
		this.title = title;
		this.abstr = abstr;
		this.year = year;
		this.citations = citations;
		this.authors = authors;
		this.venues = venues;
		this.databaseID = databaseID;
	}
	
	
	public int getDatabaseID(){
		return databaseID;
	}
	public String getYear(){
		return year;
	}
	public String getTitle(){
		return title;
	}
	
	public String getAuthors(){
		String authorl = "";
		for(String author: authors){
			authorl += author + ", ";
		}
		
		//authorl = authorl.substring(0, authorl.length() - 3);
		return authorl;
	}
	
	public String getVenues(){
		String venuesl = "";
		for(String venue: venues){
			venuesl += venue + ", ";
		}
		
		venuesl = venuesl.substring(0, venuesl.length() - 3);
		return venuesl;
	}
	
	public String getAbstract(){
		return abstr;
	}

}
