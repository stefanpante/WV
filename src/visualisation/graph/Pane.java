package visualisation.graph;
import java.util.ArrayList;
import java.util.HashMap;

import data.LogWriter;
import data.Publication;
import processing.core.PVector;
import visualisation.GUI;
import visualisation.guielements.Drawable;
import visualisation.guielements.GUIButton;
import visualisation.guielements.URLButton;
import visualisation.subject.Field;


public class Pane implements Drawable {

	private GUI gui;
	private Node parentNode;
	private PVector position;
	public static final int width = 275;
	private boolean expanded;
	public int height;
	private boolean focus = false;
	private static int X_OFFSET = 10;
	public static int CORNER_RADIUS = 10;
	private URLButton showPublication;
	private GUIButton expand;
	private GUIButton showAbstract;
	private GUIButton pin;
	private GUIButton bookmark;

	/**
	 * Constructs a new Pane with a given parentNode
	 * @param parentNode
	 */
	public Pane(Node parentNode){
		this.parentNode = parentNode;
		this.position = parentNode.getPosition();
		this.expanded = false;
	}

	/**
	 * Constructs a new pane with a corresponding node
	 * @param parentNode the parentNode for this pane
	 * @param parent the PApplet used to draw this pane.
	 */
	public Pane(Node parentNode, GUI applet){
		this(parentNode);
		this.gui = applet;
		this.position = parentNode.getPosition();
		this.calculateHeight();
		this.showPublication = new URLButton("View publication", this.buildSearchString(), gui);
		this.expand = new GUIButton("Expand", "Collapse", applet);
		this.showAbstract = new GUIButton("Show Abstract","Hide Abstract", applet);
		this.pin = new GUIButton("Pin", "Unpin", applet);
		this.bookmark = new GUIButton("Bookmark paper", "Unbookmark paper", applet);
	}

	public void setGUI(GUI applet){
		this.gui = applet;
		this.calculateHeight();
		this.showPublication = new URLButton("View publication", this.buildSearchString(), gui);
		this.expand = new GUIButton("Expand", "Collapse",  applet);
		this.showAbstract = new GUIButton("Show Abstract","Hide Abstract",  applet);
		this.pin = new GUIButton("Pin", "Unpin", applet);
	}

	/**
	 * turns off the focus if it is on and vice versa.
	 */
	public void toggleFocus(){
		if(focus) {
			focus = false;
			expanded = false;
		}
		else focus = true;
	}

	/**
	 * Draws the pane onto the screen
	 */
	public void draw() {
		PVector position = gui.getTransform().transform(this.position);
		gui.textAlign(GUI.LEFT);
		gui.stroke(0, 50);

		int width = this.width;
		if(expanded) width *= 2;

		gui.fill(gui.color(0,146,211));
		gui.rect(position.x+ X_OFFSET, position.y - height/2 -40, width, 40, CORNER_RADIUS, CORNER_RADIUS, 0, 0);
		gui.textSize(20);
		gui.fill(255);
		gui.text("Description", position.x + X_OFFSET + 5, position.y - height/2 - 10);

		// Body of the information pane.
		gui.fill(255);
		gui.rect(position.x + X_OFFSET, position.y - height/2, width, height, 0, 0, CORNER_RADIUS, CORNER_RADIUS);

		gui.noStroke();
		gui.fill(0);
		HashMap<String, Field> fields = parentNode.getSubject().createFields();
		float offset = 0;
		// manual drawing, ugly code

		gui.textSize(12);

		ArrayList<Field> items = new ArrayList<Field>();
		items.add(fields.get(Publication.TITLE));
		items.add(fields.get(Publication.AUTHORS));
		//items.add(fields.get(Publication.CONFERENCE));
		items.add(fields.get(Publication.CITED));
		items.add(fields.get(Publication.YEAR));

		for(Field field: items){
			offset += 20;
			gui.textSize(12);
			if( field != null && !field.getContent().equals("null")){
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

		showPublication.setWidth(122);
		showPublication.setPosition(position.x + X_OFFSET*2 +2, position.y - height/2 + offset + 20);
		pin.setWidth(122);
		pin.setPosition(position.x + X_OFFSET*2 +2 + 130, position.y - height/2 + offset + 20);
		pin.draw();
		showPublication.draw();
		expand.setPosition(position.x + X_OFFSET*2 +2, position.y - height/2 + offset + 55);
		expand.setWidth(122);
		expand.draw();
		showAbstract.setWidth(122);
		showAbstract.setPosition(position.x + X_OFFSET*2 +130, position.y - height/2 + offset + 55);
		showAbstract.draw();
		bookmark.setPosition(position.x + X_OFFSET*2 +2, position.y - height/2 + offset + 95);
		bookmark.draw();
		offset = 20;
		if(expanded){
			gui.fill(gui.color(0,146,211));
			gui.text(fields.get(Publication.ABSTRACT).getName(), this.width + 10, position.y - height/2 + offset);
			offset +=20;
			gui.fill(gui.color(0));
			gui.text(fields.get(Publication.ABSTRACT).getContent(), this.width + 10, position.y - height/2 + offset);
		}

	}

	public void calculateHeight(){
		HashMap<String, Field> fields = parentNode.getSubject().createFields();

		ArrayList<Field> items = new ArrayList<Field>();
		items.add(fields.get(Publication.TITLE));
		items.add(fields.get(Publication.AUTHORS));
		//items.add(fields.get(Publication.CONFERENCE));
		items.add(fields.get(Publication.CITED));
		items.add(fields.get(Publication.YEAR));

		height = 0;
		for(Field field: items){
			height += 20;
			gui.textSize(12);
			System.out.println(field != null);
			System.out.println(field.getName());
			if(field != null && !field.getContent().equals("null")){
				height+= 20;
				gui.fill(gui.color(0));
				float lines = gui.textWidth(trimInput(field.getContent())) / ( width -35);
				if(lines < 1){
					lines = 1;
				}
				height += 15*lines;
			}
		}

		// 40 + 50 pixels for the button
		height +=150;
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
		if(!focus){
			this.expanded = false;
		}
	}

	public boolean hit(int mouseX, int mouseY) {
		if(!this.focus){
			return false;
		}

		PVector position = gui.getTransform().transform(this.position);
		if(mouseX >= position.x && mouseX <= position.x + X_OFFSET + width ){
			if(mouseY >= (position.y -height/2) && mouseY <= (position.y + height/2)){
				if(showPublication.hit(mouseX, mouseY)){
					showPublication.rollover();
				}
				if(expand.hit(mouseX, mouseY)){
					expand.rollover();
				}
				if(showAbstract.hit(mouseX, mouseY)){
					showAbstract.rollover();
				}
				if(pin.hit(mouseX, mouseY)){
					pin.rollover();
				}
				if(bookmark.hit(mouseX, mouseY)){
					bookmark.rollover();
				}
				return true;
			}
		}
		this.setFocus(false);
		return false;
	}

	public void mousePressed(int mouseX, int mouseY){
		if(!focus){
			return;
		}

		PVector position = gui.getTransform().transform(this.position);

		if(mouseX >= position.x && mouseX <= position.x + X_OFFSET + width){
			if(mouseY >= (position.y -height/2) && mouseY <= (position.y + height/2)){
				if(showPublication.hit(mouseX, mouseY)){
					showPublication.action(mouseX, mouseY);
				}
				if(expand.hit(mouseX, mouseY)){
					this.gui.getGraph().expand(this.getParentNode());
					this.expand.toggleActive();
				}
				if(showAbstract.hit(mouseX, mouseY)){
					showAbstract.rollover();
					showAbstract.toggleActive();
					this.expanded =true;
				}

				if(pin.hit(mouseX, mouseY)){
					pin.rollover();
					pin.toggleActive();
					getParentNode().setMovable(true);
					getParentNode().resetColor();
				}
				
				if(bookmark.hit(mouseX, mouseY)){
					pin.rollover();
					if(pin.getActive()){
						bookMark();
					}
					else{
						unBookMark();
					}
					bookmark.toggleActive();
				}
			}
		}
	}
	
	private void bookMark(){
		Publication pub = (Publication) this.getParentNode().getSubject();
		LogWriter.writeLine("+ " + pub.getID());
	}
	
	private void unBookMark(){
		Publication pub = (Publication) this.getParentNode().getSubject();
		LogWriter.writeLine("- " + pub.getID());
		
	}


	public Node getParentNode(){
		return parentNode;
	}

	private String buildSearchString(){
		Publication pub = (Publication) parentNode.getSubject();
		String searchString = pub.getPdf();		
		return searchString;
	}

	public void setPosition(double d, double e){
		float x = (float) d;
		float y = (float) e;
		if(Math.abs(this.position.x - x) > 40f || Math.abs(this.position.y - y) > 40f){
			this.position.x = x;
			this.position.y = y;
		}

	}

	public URLButton getShowPublicationsButton(){
		return this.showPublication;
	}

	public GUIButton getPin(){
		return this.pin;
	}
	
	public GUIButton getExpandButton(){
		return this.expand;
	}
	


}
