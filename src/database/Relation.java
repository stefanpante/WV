package database;
/**
 * 
 * Stelt een field value relatie voor voor insert in een database
 * bv bij gebruik van insert INTO statemen
 * 
 * INSERT INTO Persons (P_Id, LastName, FirstName)
 * VALUES (5, 'Tjessem', 'Jakob')
 * @author Stefan Pante en Kobe Vrancken
 *
 */
public class Relation {

	public String field;
	public String value;
		
	public Relation(String field, String value){
		this.field = field;
		this.value = value;
	}

	
}
