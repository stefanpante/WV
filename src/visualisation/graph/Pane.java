package visualisation.graph;
import java.util.ArrayList;
import java.util.HashMap;


import processing.core.PConstants;
import data.publication.Publication;
import data.util.LogWriter;
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
	public final int width = 275;
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
		this.position = new PVector(parentNode.getPosition().x, parentNode.getPosition().y);
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
		this.bookmark = new GUIButton("Bookmark paper", "Unbookmark paper", applet);
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
				float lines = (float) Math.ceil(gui.textWidth(trimInput(field.getContent())) / ( this.width -25));
				if(lines < 1){
					lines = 1;
				}
				String text = "";
				text += field.getContent();
				gui.text(text , position.x + X_OFFSET + 5, position.y - height/2 + offset, this.width - 10, 30*lines);
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
			gui.textAlign(PConstants.LEFT);
			gui.text(fields.get(Publication.ABSTRACT).getName(), position.x + this.width + 10, position.y - height/2 + offset);
			offset +=20;
			gui.fill(gui.color(0));
			gui.textAlign(PConstants.LEFT);
			String abstractString = fields.get(Publication.ABSTRACT).getContent() + "...";
			gui.text(abstractString, position.x + this.width + 10, position.y - height/2 + offset, this.width - 5, height - 30);
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
		if(input.length() <= 600){
			return input;
		}

		String output = input.substring(0, 597);
		output += "...";

		return output;
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
		int width = expanded ? this.width*2 : this.width;
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

	public boolean mousePressed(int mouseX, int mouseY){
		if(!focus){
			return false;
		}

		PVector position = gui.getTransform().transform(this.position);

		if(mouseX >= position.x && mouseX <= position.x + X_OFFSET + width){
			if(mouseY >= (position.y -height/2) && mouseY <= (position.y + height/2)){
				if(showPublication.hit(mouseX, mouseY)){
					showPublication.action(mouseX, mouseY);
					return true;
				}
				if(expand.hit(mouseX, mouseY)){
					this.gui.getGraph().expand(this.getParentNode());
					this.expand.toggleActive();
					return true;
				}
				if(showAbstract.hit(mouseX, mouseY)){
					showAbstract.rollover();
					if(!showAbstract.getActive())
						this.expanded =true;
					else this.expanded = false;
					showAbstract.toggleActive();
					
					return true;
				}

				if(pin.hit(mouseX, mouseY)){
					pin.rollover();
					pin.toggleActive();
					if(!pin.getActive()){
						getParentNode().setMovable(true);
						getParentNode().resetColor();
					}
					else {
						getParentNode().setMovable(false);
						getParentNode().dragColor();
					}
					
					return true;
				}
				
				if(bookmark.hit(mouseX, mouseY)){
					bookmark.rollover();
					if(!bookmark.getActive()){
						bookMark();
					}
					else{
						unBookMark();
					}
					bookmark.toggleActive();
					return true;
				}
			}
		}
		return false;
	}
	
	private void bookMark(){
		Publication pub = (Publication) this.getParentNode().getSubject();
		LogWriter.writeLine("+ " + pub.getID() + "\n");
	}
	
	private void unBookMark(){
		Publication pub = (Publication) this.getParentNode().getSubject();
		LogWriter.writeLine("- " + pub.getID()+ "\n");
		
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
		if(Math.abs(this.position.x - x) > 10f || Math.abs(this.position.y - y) > 10f){
			this.position.x = x;
			this.position.y = y;
		}

	}
	
	public void setPosition(PVector pos){
		this.position = pos;
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
