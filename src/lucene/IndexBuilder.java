package lucene;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import data.Publication;
import data.PublicationFactory;
import data.SQLConnector;

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
				docFactory.fromPublication(pub);
			}catch(SQLException e){
				e.printStackTrace();
			}
		
		}
	}

}
