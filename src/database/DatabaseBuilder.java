package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.MySQLCodec;
public class DatabaseBuilder {

	private static final String DB_NAME = "visualisation";
	private static final String FILE = "data/DBLP-citation-Feb21.txt";
	
	public static void main(String[] args) throws SQLException{
		connectDatabase();
		fillPublications();
	}
	
	
	private static void connectDatabase(){
		SQLConnector.initialize("jdbc:mysql://localhost/"+DB_NAME, "root", "");
 	}

	private static void fillPublications() throws SQLException {
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(FILE));
			while ((sCurrentLine = br.readLine()) != null) {
				processReference(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Crashed at line "+lineCounter);
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private static final String TITLE = "#*";
	private static final String AUTHOR = "#@";
	private static final String YEAR = "#year";
	private static final String VENUE = "#conf";
	private static final String CITATION_AMOUNT = "#citation";
	private static final String INDEX = "#index";
	private static final String REFERENCE = "#%";
	private static final String ABSTRACT = "#!";

	

	private static ParsedPublication publication;
	private static int lineCounter = 0;
	private static int publicationNumber = 0;
	
	//65
	private static final int SKIP = 1448400;
	//private static final int SKIP = 00;
	private static void processPublicationLine(String line){
		
		lineCounter++;
			if(line.indexOf(TITLE) == 0){
				if(publicationNumber>SKIP){
					if(publication != null) publication.insert();
					String title = line.substring(TITLE.length());
					MySQLCodec mysql_codec = new MySQLCodec(MySQLCodec.MYSQL_MODE);
					title = ESAPI.encoder().encodeForSQL(mysql_codec, title);
					publication = new ParsedPublication(title,lineCounter);
				}
				publicationNumber++;
				System.out.println(publicationNumber);
			}else if(publicationNumber<SKIP){
				//DO NOTHING
			}else if(publication == null){
				LogWriter.writeLine("nf:"+lineCounter); //not found
			}else if(line.indexOf(YEAR) == 0){
				publication.setYear(line.substring(YEAR.length()));
			}else if(line.indexOf(CITATION_AMOUNT) == 0){
				int amount = Integer.parseInt(line.substring(CITATION_AMOUNT.length()));
				amount = amount < 0 ? 0 : amount;
				publication.setCited(""+amount);
			}else if(line.indexOf(ABSTRACT) == 0){
				String abstr = line.substring(ABSTRACT.length());
				MySQLCodec mysql_codec = new MySQLCodec(MySQLCodec.MYSQL_MODE);
				abstr = ESAPI.encoder().encodeForSQL(mysql_codec, abstr);
				publication.setAbstract(abstr);
			}else if(line.indexOf(INDEX) == 0){
				publication.setIndex(line.substring(INDEX.length()));
			}
		
	}
	
	private static String currentIndex;
	private static void processReference(String line) throws SQLException{
		lineCounter++;
			if(line.indexOf(INDEX) == 0){
				if(publicationNumber>SKIP){
					currentIndex = line.substring(INDEX.length());
				}
				publicationNumber++;
				System.out.println(publicationNumber);
			}else if(publicationNumber<SKIP){
				//DO NOTHING
			}else if(line.indexOf(REFERENCE) == 0){
				String reference = line.substring(REFERENCE.length());
				Relation from = new Relation("from_id", currentIndex);
				Relation to = new Relation("to_id", reference);
				SQLConnector.insert("citation", from, to);
			}
		
	}
	

}
