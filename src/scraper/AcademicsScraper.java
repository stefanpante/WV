package scraper;

import java.util.ArrayList;
import java.util.HashSet;

import data.HTTP;
import data.Publication;

public class AcademicsScraper {
	
	public static void main(String[] args){
		AcademicsScraper scraper = new AcademicsScraper();
		Publication original = scraper.scrapeById(777102);
		System.out.println(original.getSearchTerm());
		/*HashSet<Publication> citations = scraper.scrapeForwardCitations(777102);
		System.out.println("Found "+citations.size()+" publications");
		for(Publication pub : citations){
			System.out.println(pub.getSearchTerm());
		}*/
		
		
	}
	
	public Publication scrapeByTitle(String title){
		String page = HTTP.loadURL("http://academic.research.microsoft.com/Search?query="+title);
		String[] paperListings = page.split("<li class=\"paper-item\">");
		return this.parsePublicationFromListing(paperListings[1]);
	}
	
	public HashSet<Publication> scrapeForwardCitations(int id){
		return scrapeCitations(id, 5);
	}
	
	public HashSet<Publication> scrapeBackwardCitations(int id){
		return scrapeCitations(id, 2);
	}
	
	public HashSet<Publication> scrapeCitations(int id, int type){
		HashSet<Publication> result = new HashSet<Publication>();
		String page = HTTP.loadURL("http://academic.research.microsoft.com/Detail?entitytype=1&searchtype="+type+"&start=1&end=100&orderBy=1&id="+id);
		
		String[] paperListings = page.split("<li class=\"paper-item\">");
		for(int i=1;i<paperListings.length;i++){
			Publication publication = parsePublicationFromListing(paperListings[i]);
			result.add(publication);
		}
		return result;
		
	}

	private Publication parsePublicationFromListing(String listing) {
		String hyperlink = StringOperations.extractTextBetween(listing, "<a", "/a>");
		String title = StringOperations.extractFrom(hyperlink, "\">");
		title = removeTags(title);

		
		String authorString = StringOperations.extractTextBetween(listing, "<div class=\"content\">", "</div>");
		ArrayList<String> authors = parseAuthors(authorString);
		
		String abstractString = StringOperations.extractTextBetween(listing, "<div class=\"abstract\">", "</div>");
		String abstr =  StringOperations.extractTextBetween(abstractString, "\">", "</");
		String conference = "";
		if(listing.indexOf("Conference:")>-1){
			String conferenceString = StringOperations.extractTextBetween(listing, "<div class=\"conference\">", "</div>");
			String inter = StringOperations.extractTextBetween(conferenceString, "</span>", "a/>");
			conference =  StringOperations.extractTextBetween(inter, "\">", "</");
			conference = removeTags(conference);
		}
		int year = 0;
		String yearString = "";
		if(listing.indexOf("class=\"year\">")>-1){
			yearString = StringOperations.extractTextBetween(listing, "class=\"year\">", "</span>");
			if(yearString.length()>=4){
				year = Integer.parseInt(yearString.substring(yearString.length()-4, yearString.length()));
			}
		}else if(listing.indexOf("Year\">")>-1){
			yearString = StringOperations.extractTextBetween(listing, "Year\">", "</span>");
			year = Integer.parseInt(yearString.substring(yearString.length()-5, yearString.length()-1));
		}
		int citations = 0;
		if(listing.indexOf("class=\"citation\">")>-1){
			String citationsRaw = StringOperations.extractTextBetween(listing, "class=\"citation\">", "a>");
			citations = Integer.parseInt(StringOperations.extractTextBetween(citationsRaw, "Citations: ","</"));
		}
		String journal = "";
		if(listing.indexOf("Journal: ")>-1){
			String journalInter = StringOperations.extractTextBetween(listing, "Journal: </span>", "a>");
			journal =  StringOperations.extractTextBetween(journalInter, "\">", "</");
			journal = removeTags(journal);
		}
		int id = Integer.parseInt(StringOperations.extractTextBetween(listing, "href=\"Publication/", "/"));
		String pdf = "http://academic.research.microsoft.com/Publication/"+id;

		return new Publication(id, title, year, citations, abstr, authors, conference, journal, pdf);
	}

	private String removeTags(String string) {
		string = string.replaceAll("</b>", "");
		string = string.replaceAll("<b>", "");
		string = string.replaceAll("<", "");
		string = HtmlManipulator.replaceHtmlEntities(string);
		return string;
	}

	private ArrayList<String> parseAuthors(String authorsString) {
		ArrayList<String> result = new ArrayList<String>();
		String[] authorStrings = authorsString.split("<a");
		for(int i=1;i<authorStrings.length;i++){
			String parseString = authorStrings[i];
			String author = StringOperations.extractTextBetween(parseString, "\">", "</");
			author = removeTags(author);
			result.add(author);
		}
		return result;
	}

	public Publication scrapeById(int id) {
		return new Publication(id, "Test", 0, 0, "test", new ArrayList<String>(), "", "", "");
	}

	public ArrayList<Publication> scrapeByQuery(String query) {
		ArrayList<Publication> result = new ArrayList<Publication>();
		query = query.replaceAll(" ", "%20");
		String page = HTTP.loadURL("http://academic.research.microsoft.com/Search?query="+query);
		String[] paperListings = page.split("<li class=\"paper-item\">");
		for(int i=1;i<paperListings.length;i++){
			Publication publication = parsePublicationFromListing(paperListings[i]);
			result.add(publication);
		}
		return result;
	}
	

}
