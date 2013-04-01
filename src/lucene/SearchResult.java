package lucene;

public class SearchResult {
	
	
	public final int databaseID;
	public final String title;
	public final String abstr;
	public final String year;
	public final String citations;
	public final String[] authors;
	public final String[] venues;
	

	public SearchResult(){
		databaseID = -1;
		title = "test";
		abstr = "test";
		year = "test";
		citations = "test";
		authors = new String[2];
		venues = new String[2];
	}
	public SearchResult(final String title, final String abstr, final String citations, final String year, final String[] authors, final String[] venues, final int databaseID){
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
		
		authorl = authorl.substring(0, authorl.length() - 3);
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