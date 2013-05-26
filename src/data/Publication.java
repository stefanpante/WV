package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import visualisation.subject.Field;
import visualisation.subject.Subject;

public class Publication implements Subject {

	
	public static String TITLE ="Title";
	public static String CITED = "Cited";
	public static String YEAR = "Year";
	public static String ABSTRACT = "Abstract";
	public static String AUTHORS = "Authors";	
	public static String CONFERENCE = "Conference";
	public static String JOURNAL = "journal";
	public static String PDF = "pdf";
	public static Publication root;

	private int id;
	private String title;
	private int cited;
	private int year;
	private ArrayList<String> authors;
	private String summary;
	private String conference;
	private String journal;
	private String pdf;

	public Publication(int id, String title, int year, int cited,
			String summary, ArrayList<String> authors, String conference,
			String journal, String pdf) {
		if (root == null)
			root = this;
		this.id = id;
		this.year = year;
		this.cited = cited;
		this.summary = summary;
		this.title = title;
		this.authors = authors;
		this.conference = conference;
		this.journal = journal;
		this.pdf = pdf;
	}

	public String getConference() {
		return conference;
	}

	public String getJournal() {
		return journal;
	}

	public String getPdf() {
		return pdf;
	}

	public ArrayList<String> getAuthors() {
		return this.authors;
	}

	public int compareTo(Subject arg0) {
		return getScore() - arg0.getScore();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publication other = (Publication) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getScore() {
		return cited;
	}

	public int getScore2() {
		return 0;
	}

	public int getID() {
		return id;
	}

	private String getAuthorsString(){
		String result = "";
		for(String author: authors){
			result += author +", ";
		}
		
		return result.substring(0, result.length() - 3);
	}
	
	public HashMap<String, Field> createFields() {
		Field title = new Field("Title", this.title);
		Field cited = new Field("Citations", "" + this.cited);
		Field authors = new Field("Authors", this.getAuthorsString());
		Field conference = new Field("Conference", this.getConference());
		Field year = new Field("Year", "" + this.year);
		Field abstr = new Field("Abstract", "" + this.summary);
		
		HashMap<String, Field> result = new HashMap<String, Field>();
		result.put(TITLE, title);
		result.put(CITED, cited);
		result.put(CONFERENCE, conference);
		result.put(YEAR,year);
		result.put(AUTHORS, authors);
		result.put(ABSTRACT, abstr);
		
		return result;
	}

	public Field getDescription() {
		return new Field("Title", this.title);
	}

	public String getSearchTerm() {
		return title;
	}

}
