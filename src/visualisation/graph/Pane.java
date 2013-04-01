package visualisation.graph;
import java.util.ArrayList;

import database.Publication;

import processing.core.PApplet;
import processing.core.PVector;
import visualisation.GUI;
import visualisation.guielements.Drawable;
import visualisation.guielements.GUIButton;
import visualisation.subject.Field;


public class Pane implements Drawable {

	private GUI gui;
	private Node parentNode;
	public static final int width = 275;
	public int height;
	private boolean focus = false;
	private static int X_OFFSET = 10;
	public static int CORNER_RADIUS = 10;
	private GUIButton button;

	/**
	 * Constructs a new Pane with a given parentNode
	 * @param parentNode
	 */
	public Pane(Node parentNode){
		this.parentNode = parentNode;
		
	}

	/**
	 * Constructs a new pane with a corresponding node
	 * @param parentNode the parentNode for this pane
	 * @param parent the PApplet used to draw this pane.
	 */
	public Pane(Node parentNode, GUI applet){
		this(parentNode);
		this.gui = applet;
		this.calculateHeight();
		this.button = new GUIButton("Search on Scholar", this.buildSearchString(), gui);
	}

	public void setGUI(GUI applet){
		this.gui = applet;
		this.calculateHeight();
		this.button = new GUIButton("Search on Scholar", this.buildSearchString(), gui);
	}

	/**
	 * turns off the focus if it is on and vice versa.
	 */
	public void toggleFocus(){
		if(focus) focus = false;
		else focus = true;
	}

	/**
	 * Draws the pane onto the screen
	 */
	@Override
	public void draw() {
		PVector position = parentNode.getTransformedPosition();
		gui.textAlign(GUI.LEFT);
		gui.stroke(0, 50);
		
		gui.fill(gui.color(0,146,211));
		gui.rect(position.x+ X_OFFSET, position.y - height/2 -40, width, 40, CORNER_RADIUS, CORNER_RADIUS, 0, 0);
		gui.textSize(20);
		gui.fill(255);
		gui.text("Description", position.x + X_OFFSET + 5, position.y - height/2 - 10);
		
		gui.fill(255);
		gui.rect(position.x + X_OFFSET, position.y - height/2, width, height, 0, 0, CORNER_RADIUS, CORNER_RADIUS);

		gui.noStroke();
		gui.fill(0);
		ArrayList<Field> fields = parentNode.getSubject().createFields();
		float offset = 0;
		for(Field field: fields){
			offset += 20;
			gui.textSize(12);
			if(!field.getContent().equals("null")){
				gui.fill(gui.color(0,146,211));
				gui.text(field.getName(), position.x + X_OFFSET + 5, position.y - height/2 + offset, width - 10, 30);
				offset += 20;
				gui.fill(gui.color(0));
				float lines = gui.textWidth(trimInput(field.getContent())) / ( width -25);
				if(lines < 1){
					lines = 1;
				}
				String text = "";
				text += field.getContent();
				gui.text(trimInput(text) , position.x + X_OFFSET + 5, position.y - height/2 + offset, width - 10, 30*lines);
				offset += 15*lines;
			}
		}
		button.setPosition(position.x + X_OFFSET*2, position.y - height/2 + offset + 40);
		button.draw();

	}

	public void calculateHeight(){
		ArrayList<Field> fields = parentNode.getSubject().createFields();
		height = 0;
		for(Field field: fields){
			height += 20;
			gui.textSize(12);
			if(!field.getContent().equals("null")){
				height+= 20;
				gui.fill(gui.color(0));
				float lines = gui.textWidth(trimInput(field.getContent())) / ( width -35);
				if(lines < 1){
					lines = 1;
				}
				String text = "";
				height += 15*lines;
			}
		}
		
		// 40 + 50 pixels for the button
		height +=90;
	}

	public String trimInput(String input){
		if(input.length() <= 200){
			return input;
		}

		String output = input.substring(0, 197);
		output += "...";

		return output;
	}
	public String shortText(){
		Field field = parentNode.getSubject().getDescription();
		return field.getContent();
	}

	public boolean hasFocus(){
		return focus;
	}
	
	public void setFocus(boolean focus){
		this.focus = focus;
	}

	public boolean hit(int mouseX, int mouseY) {
		
		if(!this.focus){
			return false;
		}
		
		PVector position = parentNode.getTransformedPosition();
		if(mouseX >= position.x && mouseX <= position.x + X_OFFSET + width ){
			if(mouseY >= (position.y -height/2) && mouseY <= (position.y + height/2)){
				return true;
			}
		}
		this.setFocus(false);
		return false;
	}
	
	public Node getParentNode(){
		return parentNode;
	}
	
	private String buildSearchString(){

		String searchString = "http://scholar.google.com/scholar?q=" + parentNode.getSubject().getSearchTerm() + " ";
		Publication pub = (Publication) parentNode.getSubject();
		for(String s : pub.getAuthors()){
			
			searchString += s.split(" ")[1] + " ";
		}
		
		searchString = searchString.replace(" ", "+");
		
		return searchString;
	}
	
	
	public GUIButton getGUIButton(){
		return this.button;
	}

}
