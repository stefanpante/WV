package visualisation.subject;

import java.util.HashMap;


public interface Subject extends Comparable<Subject>{

	/**
	 * Used to score the subject
	 * @return
	 */
	public abstract int getScore();
	public abstract int getScore2();
	public int getID();
	public abstract HashMap<String, Field> createFields();
	public abstract Field getDescription();
	public abstract String getSearchTerm();
	
}
