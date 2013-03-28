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
	private static int titlec = 0;
	private static int abstrc = 0;
	private static int citedc = 0;
	private static int yearc = 0;
	private static int indexc = 0;
	
	public void insert(){
//		if(abstr == null) abstr = "";
//		if(title == null || abstr == null || cited == null || year == null || index == null){
//			if(title == null) titlec++;
//			if(abstr == null) abstrc++;
//			if(cited == null) citedc++;
//			if(year == null) yearc++;
//			if(index == null) indexc++;
////			System.out.println("title: "+titlec);
////			System.out.println("abstr: "+abstrc);
////			System.out.println("cited: "+citedc);
////			System.out.println("year: "+yearc);
////			System.out.println("index: "+indexc);
//			LogWriter.writeLine("af"+lineNumber); //argument fail
//		}else{
			ArrayList<Relation> relations = new ArrayList<Relation>();
			if(title != null && index != null){
				Relation titleRel = new Relation("title", title);
				Relation indexRel = new Relation("id", index);
				relations.add(titleRel);
				relations.add(indexRel);
				if(year != null){
					Relation yearRel = new Relation("year", year);
					relations.add(yearRel);
				}
				if(cited != null){
					Relation citedRel = new Relation("cited", cited);
					relations.add(citedRel);
				}
				if(abstr != null){
					Relation abstrRel = new Relation("abstract", abstr);
					relations.add(abstrRel);
				}
			}
			try {
				SQLConnector.insert("publication", relations);
			} catch (SQLException e) {
				e.printStackTrace();
				LogWriter.writeLine("if"+lineNumber); //insertion fail
			}
//		}
	}
	
	
}
