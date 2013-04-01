package visualisation.subject;

import java.util.ArrayList;


public interface Subject extends Comparable<Subject>{

	/**
	 * Used to score the subject
	 * @return
	 */
	public abstract int getScore();
	public abstract int getScore2();
	public int getID();
	public abstract ArrayList<Field> createFields();
	public abstract Field getDescription();
	public abstract String getSearchTerm();
	
}
