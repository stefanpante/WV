package lucene;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import data.Publication;


public abstract class PublicationSearcher {

	public abstract ArrayList<Publication> generalSearch(String query, int results) throws Exception;

}
