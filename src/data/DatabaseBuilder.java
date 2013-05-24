package data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.MySQLCodec;
public class DatabaseBuilder {

	private static final String DB_NAME = "visualisation";
	private static final String FILE = "C:/wamp/bin/mysql/mysql5.5.24/data/visualisation/DBLP-citation-Feb21.txt";
	
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
			br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE), "UTF-8"));
			while ((sCurrentLine = br.readLine()) != null) {
				processPublicationLine(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
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
	private static  int SKIP = -1;

	//65
	private static void processPublicationLine(String line){
		
		lineCounter++;
			if(line.indexOf(TITLE) == 0){
				if(publicationNumber>SKIP){
					if(publication != null) publication.insert();
					String title = line.substring(TITLE.length());
					String lastChar = title.substring(title.length()-1);
					if(lastChar.equals(".")){
						title = title.substring(0, title.length()-1);
					}
					publication = new ParsedPublication(title,lineCounter);
				}
				publicationNumber++;
			}else if(publicationNumber<SKIP){
				//DO NOTHING
			}else if(publication == null){
			}else if(line.indexOf(YEAR) == 0){
				publication.setYear(line.substring(YEAR.length()));
			}else if(line.indexOf(CITATION_AMOUNT) == 0){
				int amount = Integer.parseInt(line.substring(CITATION_AMOUNT.length()));
				amount = amount < 0 ? 0 : amount;
				publication.setCited(""+amount);
			}else if(line.indexOf(ABSTRACT) == 0){
				String abstr = line.substring(ABSTRACT.length());
				publication.setAbstract(abstr);
			}else if(line.indexOf(INDEX) == 0){
				publication.setIndex(line.substring(INDEX.length()));
			}
		
	}
	
	private static int currentIndex;
	private static void processReference(String line) throws SQLException{
		lineCounter++;
			if(line.indexOf(INDEX) == 0){
				if(publicationNumber>SKIP){
					currentIndex = Integer.parseInt(line.substring(INDEX.length()));
				}
				publicationNumber++;
			}else if(publicationNumber<SKIP){
				//DO NOTHING
			}else if(line.indexOf(REFERENCE) == 0){
				String reference = line.substring(REFERENCE.length());
				Relation from = new Relation("from_id", ""+currentIndex);
				Relation to = new Relation("to_id", reference);
				SQLConnector.insert("citation", from, to);
			}
		
	}

	private static void processAuthorVenue(String line) throws SQLException{
			if(line.indexOf(INDEX) == 0){
				publicationNumber++;
			}else if(publicationNumber<SKIP){
				//DO NOTHING
			}
//			else if(line.indexOf(AUTHOR) == 0){
//				String reference = line.substring(AUTHOR.length());
//				for(String ref : reference.split(",")){
//					LogWriter.writeLine("%"+ref+"%\n");
//				}
//			}
	else if(line.indexOf(VENUE) == 0){
				String reference = line.substring(VENUE.length());
				LogWriter.writeLine("%"+reference+"%\n");
			}
		
	}

	private static void processRelation(String line) throws SQLException{
			if(line.indexOf(INDEX) == 0){
				if(publicationNumber>=SKIP){
					currentIndex = Integer.parseInt(line.substring(INDEX.length()));
					LogWriter.writeLine(currentIndex+"\n");
				}

				publicationNumber++;
			}else if(currentIndex<SKIP){
				//DO NOTHING
			}
			else if(line.indexOf(VENUE) == 0){
				String reference = line.substring(VENUE.length());
				//for(String ref : reference.split(",")){
					//MySQLCodec mysql_codec = new MySQLCodec(MySQLCodec.MYSQL_MODE);
					reference = reference.replace("\"", "\\\"");
					//ref = ref.replaceAll('%', '\\');
					//ref = ESAPI.encoder().encodeForSQL(mysql_codec, ref);
					ResultSet res = null;
					try{
						res = SQLConnector.select("id", "venue", "venue", '"'+reference+'"');
					}catch(Exception e){
					}
					if(res.next()){
						int id = res.getInt(1);
						LogWriter.writeLine(id+",");
					}
				//}
			}
//	else if(line.indexOf(VENUE) == 0){
//				String reference = line.substring(VENUE.length());
//				LogWriter.writeLine("%"+reference+"%\n");
//			}
		
	}
	

}
