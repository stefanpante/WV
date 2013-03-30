package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class CitationFactory {
	
	public static HashSet<Publication> forwardCitations(int databaseID) throws SQLException{
		HashSet<Publication> result = new HashSet<Publication>();
		ResultSet resultSet = SQLConnector.select("from_id", "citation", "to_id", ""+databaseID);
		while(resultSet.next()) result.add(PublicationFactory.fromDatabaseID(resultSet.getInt("from_id")));
		return result;
	}
	
	public static HashSet<Publication> backwardCitations(int databaseID) throws SQLException{
		HashSet<Publication> result = new HashSet<Publication>();
		ResultSet resultSet = SQLConnector.select("to_id", "citation", "from_id", ""+databaseID);
		while(resultSet.next()) result.add(PublicationFactory.fromDatabaseID(resultSet.getInt("to_id")));
		return result;
	}

}
