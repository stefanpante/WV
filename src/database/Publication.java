package database;

import java.util.ArrayList;
import java.util.HashSet;

import visualisation.subject.Field;
import visualisation.subject.Subject;

public class Publication implements Subject{
	
	public static Publication root;

	private int id;
	private String title;
	private int cited;
	private int year;
	private ArrayList<String> authors;
	private String summary;
	
	
	
	public Publication(int id, String title, int year, int cited, String summary, ArrayList<String> authors){
		if(root == null) root = this;
		this.id = id;
		this.year = year;
		this.cited = cited;
		this.summary = summary;
		this.title = title;
		this.authors = authors;
	}
	
	public ArrayList<String> getAuthors(){
		return this.authors;
	}
	
	@Override
	public int compareTo(Subject arg0) {
		return getScore()-arg0.getScore();
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



	@Override
	public int getScore() {
		return cited;
	}

	@Override
	public int getScore2() {
		return 0;
	}

	@Override
	public int getID() {
		return id;
	}

	@Override
	public ArrayList<Field> createFields() {
		Field title = new Field("Title", this.title);
		Field cited = new Field("Citations", ""+this.cited);
		Field year = new Field("Year", ""+this.year);
		Field abstr = new Field("Abstract", ""+this.summary);
		ArrayList<Field> result = new ArrayList<Field>();
		result.add(title);
		result.add(cited);
		result.add(year);
		result.add(abstr);
		return result;
	}

	@Override
	public Field getDescription() {
		return new Field("Title", this.title);
	}

	@Override
	public String getSearchTerm() {
		return title;
	}

}
