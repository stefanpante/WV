package visualisation;

import java.util.ArrayList;

import processing.core.PApplet;
import visualisation.subject.Field;
import visualisation.subject.Subject;

public class IDSubject implements Subject{

	private int id;
	private PApplet parent;
	
	public IDSubject(int id, PApplet parent){
		this.id = id;
		this.parent = parent;
	}

	public int getID(){
		return id;
	}

	/**
	 * Compares this instance to another instance of IDSubject.
	 */
	@Override
	public int compareTo(Subject o) {
		IDSubject ro = (IDSubject) o;
		if(this.getID() <ro.getID())
			return -1;
		if(this.getID() > ro.getID())
			return 1;
		else return 0;
	}

	
	public boolean equals(IDSubject s){
		if(s.getID() == this.getID())
			return true;
		else return false;
	}
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Field> createFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getScore2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSearchTerm() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
