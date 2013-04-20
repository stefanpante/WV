package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Authorship {

	public static ArrayList<Integer> findPublicationsBy(int authorId) throws SQLException{
		ResultSet res = SQLConnector.select("publication_id", "authorship", "author_id", authorId+"");
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(res.next()){
			result.add(res.getInt(1));
		}
		return result;
	}

}
