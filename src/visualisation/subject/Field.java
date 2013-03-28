package visualisation.subject;



/**
 * Simple class used to create fields. 
 * 
 * e.g.: To list info on the screen
 * name : Title
 * content: This is our Wetenschappelijke vorming project.
 * @author Stefan Pante and Kobe Vrancken
 *
 */
public class Field{

	/**
	 * The name of the field.
	 */
	private String name;
	
	/**
	 * The content corresponding to the name of the field.
	 */
	private String content;
	
	/**
	 * Constructs a new field object with the given name and content.
	 * @param name		the name of the field
	 * @param content	the content corresponding to the name of the field.
	 */
	public Field(String name, String content){
		this.name = name;
		this.content = content;
	}
	
	/**
	 * @return the name of the field.
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @return The content of this field.
	 */
	public String getContent(){
		return content;
		
	}


}
