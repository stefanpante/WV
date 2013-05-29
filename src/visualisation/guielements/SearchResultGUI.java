package visualisation.guielements;

import data.Publication;
import processing.core.PConstants;
import processing.core.PVector;
import visualisation.GUI;

public class SearchResultGUI implements Drawable{

	private PVector position;
	private Publication searchResult;
	private int id; 
	private GUI gui;
	private float width;
	private float height;
	
	public SearchResultGUI(Publication searchResult) {
		this.searchResult = searchResult;
		this.id = searchResult.getID();
		this.position = new PVector();
	}
	
	public SearchResultGUI(Publication searchResult, GUI gui){
		this(searchResult);
		this.gui = gui;
	}
	
	public SearchResultGUI(Publication searchResult, GUI gui, PVector position){
		this(searchResult, gui);
		this.position = position;
	}
	
	public void setWidth(float width){
		this.width = width;
	}
	
	public void setHeight(float height){
		this.height = height;
	}
	
	public Publication getSearchResult(){
		return searchResult;
	}

	public void draw() {
		//TODO: draw text.
		gui.fill(255);
		gui.stroke(gui.color(0, 146, 211) );
		gui.rect(position.x, position.y, width, height);
		
		gui.fill(gui.color(0));
		gui.noStroke();
		gui.textSize(12);
		gui.textAlign(PConstants.CENTER, PConstants.CENTER);
		String text = searchResult.getSearchTerm() + System.getProperty("line.separator")
				+ searchResult.getAuthors();
		
		gui.text(text, position.x, position.y, width, height);
		
	}
	
	public void rollover() {
		//TODO: draw text.
		gui.fill(gui.color(142, 220, 211));
		gui.stroke(gui.color(0, 146, 211) );
		gui.rect(position.x, position.y, width, height);
		
		gui.fill(gui.color(0,146,211));
		gui.noStroke();
		gui.textSize(12);
		gui.textAlign(PConstants.CENTER, PConstants.CENTER);
		String text = searchResult.getSearchTerm()  + System.getProperty("line.separator")
				+ searchResult.getAuthors();
		
		gui.text(text, position.x, position.y, width, height);
		
	}
	
	
	public void setPosition(float x, float y){
		this.position.x = x;
		this.position.y = y;
	}
	
	/**
	 * Returns whether the field is hit.
	 * @param mouseX
	 * @param mouseY
	 * @return
	 */
	public boolean hit(int mouseX, int mouseY){
		if(mouseX >= this.position.x && mouseX <= this.position.x + width){
			if(mouseY >= this.position.y && mouseY <= this.position.y + height){
				return true;
				
			}
		}
		
		return false;
	}
	
	public int getID(){
		return id;
	}
	

}
