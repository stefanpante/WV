package lucene;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import data.Publication;
import data.PublicationFactory;
import data.SQLConnector;

public class Test {

	public static void main(String[] args) throws Exception {
		SQLConnector.initialize("jdbc:mysql://localhost/visualisation", "root", "");
		IndexedDocumentFactory docFactory = IndexedDocumentFactory.getInstance();
		Publication publicationOne = PublicationFactory.fromDatabaseID(80029);
		Publication publicationTwo = PublicationFactory.fromDatabaseID(467920);

		IndexedDocument firstDoc  = docFactory.fromPublication(publicationOne);
		IndexedDocument secondDoc  = docFactory.fromPublication(publicationTwo);

		System.out.println(firstDoc.compareContent(secondDoc, new CosineSimilarity()));
		
		//System.out.println(IndexManager.getInstance().extractPublicationData(25)[1]);
	}

}
