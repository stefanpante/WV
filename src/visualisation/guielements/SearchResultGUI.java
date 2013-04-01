package visualisation.guielements;

import processing.core.PConstants;
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
		gui.fill(255);
		gui.stroke(gui.color(0, 146, 211) );
		gui.rect(position.x, position.y, width, height);
		
		gui.fill(gui.color(0, 146, 211));
		gui.noStroke();
		gui.textSize(12);
		gui.textAlign(PConstants.CENTER, PConstants.CENTER);
		String text = searchResult.getTitle() + System.getProperty("line.separator")
				+ searchResult.getAuthors();
		System.out.println(searchResult.getTitle());
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
		String text = searchResult.getTitle() + System.getProperty("line.separator")
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
