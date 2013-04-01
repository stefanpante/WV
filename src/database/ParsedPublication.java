package database;

import java.sql.SQLException;
import java.util.ArrayList;

public class ParsedPublication {

	private final String title;
	private final int lineNumber;
	
	private String year;
	private String cited;
	private String abstr;
	private String index;
	
	public ParsedPublication(String title, int lineNumber){
		this.lineNumber = lineNumber;
		this.title = title;
	}
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public String getCited() {
		return cited;
	}

	public void setCited(String cited) {
		this.cited = cited;
	}

	public String getAbstract() {
		return abstr;
	}

	public void setAbstract(String abstr) {
		this.abstr = abstr;
	}
	
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
	
	public void insert(){
			if(title != null && index != null)
				if(abstr != null) LogWriter.writeLine(index+","+title+","+year+","+cited+","+abstr+"\n");
				else LogWriter.writeLine(index+","+title+","+year+","+cited+"\n");
	}
	
	
}
