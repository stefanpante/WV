package scraper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import data.Author;

import visualisation.subject.Field;
import visualisation.subject.Subject;


public class Pub implements Subject{

	private ArrayList<Author> authors;
	private ArrayList<Pub> backwardCitations;
	private ArrayList<Pub> forwardCitations;
	private String title;
	private int numberofPages;
	private int publicationDate;
	// Hyperlink naar de pdf
	private String pdf;
	
	// 
	private String citedByURL; 
	
	public Pub(String title){
		this.title = title;
		this.authors = new ArrayList<Author>();
		this.backwardCitations = new ArrayList<Pub>();
		this.forwardCitations = new ArrayList<Pub>();
	}
	
	public Pub(String title, int numberofPages, int publicationDate) {
		super();
		this.title = title;
		this.numberofPages = numberofPages;
		this.publicationDate = publicationDate;
		this.authors = new ArrayList<Author>();
		this.backwardCitations = new ArrayList<Pub>();
		this.forwardCitations = new ArrayList<Pub>();
	}
	
	public String getTitle() {
		return title;
	}
	
	public ArrayList<Author> getAuthors(){
		return authors;
	}
	
	public void addAuthor(Author a){
		authors.add(a);
	}
	
	public void setAuthors(ArrayList<Author> as){
		authors = as;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getNumberofPages() {
		return numberofPages;
	}
	
	public void setNumberofPages(int numberofPages) {
		this.numberofPages = numberofPages;
	}
	
	public int getPublicationDate() {
		return publicationDate;
	}
	
	public void setPublicationDate(int publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	public String getCitedByURL() {
		return citedByURL;
	}
	
	public void setCitedByURL(String citedByURL) {
		this.citedByURL = citedByURL;
	}
	


	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	/**
	 * combined h_index score of all the authors
	 * Can be used to determine size of node?
	 */
	public int getScore() {
		int h = 0;
		for(Author a: authors){
			h += a.getH();
		}
		h /= authors.size();
		
		return h;
	}
	
	public HashMap<String, Field> createFields(){
		ArrayList<Field> fields = new ArrayList<Field>();
		
		Field titl = new Field("Title", title);
		fields.add(titl);
		Field aut = new Field("Authors", authorsToString());
		fields.add(aut);
		Field date = new Field("Publication date","" + publicationDate);
		fields.add(date);
		Field pd = new Field("Link to Pdf", pdf);
		fields.add(pd);
		
		
		return null;
		
	}
	/**
	 * Used to get an information snippet about this publication,
	 * returns the title as a field object. example usage is to 
	 * show the title when the mouse hovers over a node.
	 */
	public Field getDescription(){
		return new Field("Title", title);
	}
	
	public String authorsToString(){
		String result = "";
		for(Author a: authors){
			result += a.toString() + ", ";
		}
		return result;
		
	}
	
	public String toString(){
		return authorsToString() + title + ", " + publicationDate;	
	}

	public int compareTo(Subject o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getScore2() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getSearchTerm() {
		// TODO Auto-generated method stub
		return null;
	}

}
