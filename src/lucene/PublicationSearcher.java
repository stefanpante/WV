package lucene;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public abstract class PublicationSearcher {

	public abstract ArrayList<SearchResult> generalSearch(String query, int results) throws Exception;

}
