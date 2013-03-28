package database;

import java.sql.SQLException;

public interface Queryable {

	/**
	 * Inserts current object as new record in the database
	 * 
	 * @return the index at which the record has been inserted
	 * @throws UnsupportedOperationException
	 *             If the record already exists in the database
	 *             |existsInDatabase();
	 * @throws SQLException 
	 */

	public abstract int insert() throws UnsupportedOperationException, SQLException;

	/**
	 * Checks whether or not the record is represented in the database
	 * 
	 * @return true if and only if the record is already represented in the
	 *         database |getIndex() > -1
	 */

	public abstract boolean existsInDatabase();

	/**
	 * Finds the index of the record representing the current object in the
	 * database or -1 if it doesn't exist
	 * 
	 * @return the index of the record representing the current object in the
	 *         database or -1 if it doesn't exist
	 */

	public abstract int getIndex();

	/**
	 * Fills the current author object with information from the database
	 * 
	 * @param index
	 * @return true if and only if the operation has succeeded
	 * @throws IllegalArgumentException
	 *             if the given index does not exist in the database
	 */

	public abstract boolean select(int index) throws IllegalArgumentException;

	/**
	 * Removes reference to current object from the database
	 * 
	 * @return true if and only if the remove operation succeeded
	 * @throws UnsupportedOperationException
	 *             If the record does not exist in the database
	 *             |!existsInDatabase();
	 */
	
	public abstract boolean remove();

}
