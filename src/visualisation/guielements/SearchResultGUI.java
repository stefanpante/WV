package visualisation.guielements;

import processing.core.PVector;
import visualisation.GUI;
import lucene.SearchResult;

public class SearchResultGUI implements Drawable{

	private PVector position;
	private SearchResult searchResult;
	private int id; 
	private GUI gui;
	private int width;
	private int height;
	
	public SearchResultGUI(SearchResult searchResult) {
		this.searchResult = searchResult;
		this.id = searchResult.getDatabaseID();
		this.position = new PVector();
	}
	
	public SearchResultGUI(SearchResult searchResult, GUI gui){
		this(searchResult);
		this.gui = gui;
	}
	
	public SearchResultGUI(SearchResult searchResult, GUI gui, PVector position){
		this(searchResult, gui);
		this.position = position;
	}
	
	public void setWidth(int width){
		this.width = width;
	}
	
	public void setHeight(int height){
		this.height = height;
	}

	@Override
	public void draw() {
		//TODO: draw text.
		gui.rect(position.x, position.y, width, height);
		
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
