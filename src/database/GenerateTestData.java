package database;

import java.sql.SQLException;
import java.util.ArrayList;

import database.Relation;
import database.SQLConnector;

public class GenerateTestData {

	private static SQLConnector databaseConnector;
	private static final String DB_URL = "jdbc:mysql://localhost/visualisation";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";

	public static void main(String[] args) throws SQLException {
		ArrayList<Relation> insertList = new ArrayList<Relation>();
		SQLConnector.initialize(DB_URL, DB_USER, DB_PASSWORD);
	}

	/**
	 * Inserts 'amount' author records from randomNames.csv that have not been
	 * inserted in the author table yet
	 * 
	 * @param amount
	 *            the amount of new records to insert
	 */

	public static void insertNewRandomAuthors(int amount) {
		
		//databaseConnector.insert("author", insertList);
	}

}
