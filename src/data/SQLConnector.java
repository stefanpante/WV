package data;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.MySQLCodec;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * Class which represents a connection to a mysql database. Created to make interacting
 * with the database easier.
 * @author Stefan Pante en Kobe Vrancken
 *
 */
public class SQLConnector {

	private static String url;
	private static String username;
	private static String password;
	private static Connection connection;
	private static boolean open;

	/**
	 * Initialize a SQL connection
	 * @param url The url for the databaseserver example given: 
	 * 				jdbc:mysql://localhost/databasename
	 * @param username username for the database
	 * @param password password for the database
	 */
	
	public static void initialize(String url, String username, String password){
		SQLConnector.url = url;
		SQLConnector.username = username;
		SQLConnector.password = password;
		try {
			SQLConnector.open = open();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Opens a connection to the given database server
	 * @return boolean symbolizes success
	 * @throws SQLException when connection or loading of driver fails
	 */
	public static boolean open() throws SQLException{

		if(open == false){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url, username, password);
				open = true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				open = false;
			}
			return open;
		}

		return true;
	}

	/**
	 * Closes a connection to the given database server
	 * @return true if the connection closes
	 * @throws SQLException
	 */
	public static boolean close() throws SQLException{
		if(open == true){
			connection.close();
			open = false;
		}

		return !open;
	}

	/**
	 * inserts an author in the database, only possible if the connection is open
	 * @param author the author object to be inserted
	 * @throws SQLException
	 */
	public static int insert(String tablename, Relation... relations) throws SQLException{
		String fields ="";
		String values ="\"";
		for(Relation relation: relations){
			fields += relation.field+ ", ";
			values += relation.value + "\", \"";
		}
		fields = fields.substring(0, fields.length() -2);
		values = values.substring(0, values.length() -3);

		String query = "INSERT INTO " + tablename + " (" + fields + ") VALUES" + " (" + values + ")" ;
		Statement stat = (Statement) connection.createStatement();
		try{
		stat.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		}catch(MySQLIntegrityConstraintViolationException exc){
			//exc.printStackTrace();
		}
		ResultSet rs = stat.getGeneratedKeys();
		if(rs.next()) return (int) rs.getLong(1);
		else return -1;
	}
	
	/**
	 * inserts an author in the database, only possible if the connection is open
	 * @param author the author object to be inserted
	 * @throws SQLException
	 */
	public static int insert(String tablename, ArrayList<Relation> relations) throws SQLException{
		Relation[] rel = new Relation[relations.size()];
		int i = 0;
		for(Relation relation : relations){
			rel[i++] = (Relation) relation;
		}
		return insert(tablename,rel);
	}
	
	
	/**
	 * Searches the SQL database for the given term in the given table with the given column
	 * @param search
	 * @param table
	 * @param column
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet search(String search, String table, String column) throws SQLException{
		String query = "SELECT * FROM " + table + " WHERE " + column +  "=" + search;	
		Statement statement = (Statement) connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		return result;
	}

	/**
	 * returns the catalog name
	 * @return the catalog name
	 * @throws SQLException
	 */
	public static String getCatalog() throws SQLException{
		return connection.getCatalog();
	}

	/**
	 * Method to update a given record in the database
	 * @param tablename the tablename where the record resides to be updates
	 * @param relations symbolises a columnname together with a value
	 * @throws SQLException
	 */
	public static void update(String tablename, String columnName, String someval, Relation... relations) throws SQLException{
		String updates = "";
		for(Relation relation: relations){
			updates += relation.field + "=" + relation.value + ", ";
		}
		
		updates = updates.substring(0, updates.length() -2);
		
		String query = "UPDATE " + tablename + updates + " WHERE " + columnName + "=" + someval;
		Statement statement = (Statement) connection.createStatement();
		statement.executeUpdate(query);
	}

	/**
	 * Remove an element from a given table
	 * @throws SQLException
	 */
	public static void remove(String tablename, String columnname, String value) throws SQLException{
		String query = "DELETE FROM " + tablename + " WHERE " + columnname + "=" + value;
		Statement statement = (Statement) connection.createStatement();
		statement.executeUpdate(query);
	}
	
	/**
	 * Remove an element from a given table
	 * @param tablename
	 * @param columnname
	 * @param value
	 * @throws SQLException 
	 */
	public static void delete(String tablename, String columnname, String value) throws SQLException{
		remove(tablename, columnname, value);
	}

	public static ArrayList<String> getTables() throws SQLException{
		ArrayList<String> tables = new ArrayList<String>();
		assert(open);
		DatabaseMetaData data = connection.getMetaData();
		ResultSet set = data.getTables(null,null, "%", null);
		while(set.next()){
			tables.add(set.getString(3));
		}

		return tables;

	}
	/**
	 * 
	 * @param selectedcolumn
	 * @param table
	 * @param where
	 * @param value
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet select(String selectedcolumn, String tablename, String where, String value) throws SQLException{
		String query="SELECT " + selectedcolumn + " FROM " + tablename + " WHERE " + where + "=" + value; 

		Statement statement = (Statement) connection.createStatement();
		return statement.executeQuery(query);
	}
	
	/**
	 * 
	 * @param tablename
	 * @param where
	 * @param value
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet selectAllColumns(String tablename, String where, String value) throws SQLException{
		return select("*", tablename, where, value);
	}
	
	/**
	 * 
	 * @param tablename
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet selectAll(String tablename) throws SQLException{
		String query = "SELECT * FROM " + tablename;
		Statement statement = (Statement) connection.createStatement();
		return statement.executeQuery(query);
	}

}
