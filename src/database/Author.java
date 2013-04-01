package database;
import java.sql.SQLException;
import java.util.ArrayList;

import scraper.Pub;
import visualisation.subject.Field;
import visualisation.subject.Subject;


public class Author implements Subject,Queryable {
	
	public static void main(String[] args) throws UnsupportedOperationException, SQLException{
		SQLConnector.initialize("jdbc:mysql://localhost/visualisation", "root", "");
		Author test = new Author("Kobe", "Kris", "Vrancken");
		int index = test.insert();
		System.out.println(index);
	}

	private int recordIndex;
	private String fname;
	private String lname;
	private  String mname;
	private int h_index;
	
	//private String institution;
	

	public Author(String fname, String mname, String lname) {
		super();
		this.setFname(fname);
		this.setLname(lname);
		this.setMname(mname);
		setIndex(-1);
	}
	
	public Author(String fname, String lname){
		this(fname, lname, "");
	}
	
	public Author(String lname){
		this("",lname,"");
	}
	
	public Author(int index){
		select(index);
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getMname() {
		return mname;
	}
	
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	@Override
	public String toString() {
		return fname+" "+mname+" "+lname; 
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

	public void setH(int h){
		this.h_index = h;
	}
	public int getH() {
		return h_index;
	}

	@Override
	public int insert() throws UnsupportedOperationException, SQLException {
		Relation firstName = new Relation("first_name", getFname());
		Relation middleName = new Relation("middle_name", getMname());
		Relation lastName = new Relation("last_name", getLname());

		int index = SQLConnector.insert("author", firstName, middleName, lastName);
		setIndex(index);
		return index;
	}

	@Override
	public boolean existsInDatabase() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getIndex() {
		return recordIndex;
	}
	
	private void setIndex(int index){
		this.recordIndex = index;
	}

	@Override
	public boolean select(int index) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo(Subject arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScore2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
