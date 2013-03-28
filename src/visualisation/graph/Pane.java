package visualisation.graph;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;
import visualisation.GUI;
import visualisation.guielements.Drawable;
import visualisation.subject.Field;


public class Pane implements Drawable {

	private GUI gui;
	private Node parentNode;
	public static final int width = 275;
	public static final int height = 200;
	private boolean focus = false;
	
	
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
	}
	
	public void setGUI(GUI applet){
		this.gui = applet;
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
		
		gui.stroke(0, 50);
		gui.fill(255);
		gui.rect(position.x + 10, position.y - height/2, width, height);
		
		gui.noStroke();
		gui.fill(0);
		ArrayList<Field> fields = parentNode.getSubject().createFields();
		String text = "";
		float offset = 20;
		for(Field field: fields){
			gui.textSize(16);
			gui.fill(gui.color(0,146,211));
			gui.text(field.getName(), position.x + 20, position.y - height/2 + offset, width);
			
			offset += 20;
			gui.fill(gui.color(0));
			float lines = gui.textWidth(field.getContent()) / ( width -10);
			gui.text(field.getContent(), position.x +20, position.y - height/2 + offset, width - 10, 30*lines);
			offset += 30*lines;
			// Can use textWidth to calculate the width of a string in processing.
			// Use it to dynamically alter the height of the pane.
		}
		
	}
	
	public void drawFocus(){
		
	}
	
	public String shortText(){
		Field field = parentNode.getSubject().getDescription();
		 return field.getContent();
	}

}
