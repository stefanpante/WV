package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PublicationFactory {

	public static Publication fromDatabaseID(int id) throws SQLException{
		ResultSet results = SQLConnector.select("title,year,cited,abstract", "publication", "id", ""+id);
		results.next();
		Publication pub = new Publication(id, results.getString("title"), results.getInt("year"), results.getInt("cited"), results.getString("abstract"));
		return pub;
	}

}
