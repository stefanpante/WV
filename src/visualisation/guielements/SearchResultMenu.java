package visualisation.guielements;

import java.util.ArrayList;

import lucene.SearchResult;

import processing.core.PVector;
import visualisation.GUI;

public class SearchResultMenu {

	private PVector startPosition; 
	private ArrayList<SearchResultGUI> items;
	private GUI gui;
	private int width;
	private int height = 50;
	
	
	private SearchResultMenu() {
		this.startPosition = new PVector();
		this.items = new ArrayList<SearchResultGUI>();
		
	}
	
	public SearchResultMenu(SearchResult[] searchResults, GUI gui){
		this();
		this.gui = gui;
		for(SearchResult result: searchResults){
			this.items.add(new SearchResultGUI(result, gui));
		}
		width = gui.displayWidth / 2 +1;
		this.startPosition.x = gui.displayWidth/2 - width/2 -1;
		this.initItems();
	}
	
	private void initItems(){
		for(int i = 0; i < items.size(); i++){
			items.get(i).setHeight(height);
			items.get(i).setWidth(width);
			items.get(i).setPosition(this.startPosition.x, this.startPosition.y + this.height*i);
		}
	}
	
	public void draw(){
		for(SearchResultGUI result: items){
			result.draw();
		}
	}
	
	public void setStartPosition(PVector startPosition){
		this.startPosition = startPosition;
		initItems();
	}
	
	public void setStartPositionY(float y) {
		this.startPosition.y = y;
		initItems();
	}
	
	public void hit(int mouseX, int mouseY){
		for(SearchResultGUI result: items){
			if(result.hit(mouseX, mouseY)){
				result.rollover();
				break;
			}
		}
	}

}
