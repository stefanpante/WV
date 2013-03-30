package lucene;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import database.Publication;
import database.PublicationFactory;
import database.SQLConnector;

public class IndexBuilder {

	public static void main(String[] args) throws Exception {
		SQLConnector.initialize("jdbc:mysql://localhost/visualisation", "root", "");
		IndexedDocumentFactory docFactory = IndexedDocumentFactory.getInstance();
		Publication pub;
		for(int i = 900 ; i < 1572277 ; i++){
			try{
				long time = System.currentTimeMillis();
				pub = PublicationFactory.fromDatabaseID(i);
				long time2 = System.currentTimeMillis();
				System.out.println("Database took "+(time2-time)+" ms");
				docFactory.fromPublication(pub);
				System.out.println("Indexing took "+(System.currentTimeMillis()-time2)+" ms");
				if(i%10 == 0) System.out.println(i);
			}catch(SQLException e){
				System.out.println(i + "went wrong");
				e.printStackTrace();
			}
		
		}
	}

}
