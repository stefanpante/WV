	
package visualisation.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import database.PublicationManager;

import processing.core.PApplet;
import processing.core.PVector;
import processing.opengl.PShader;
import visualisation.GUI;
import visualisation.guielements.GUIElement;
import visualisation.subject.Subject;

/**
 * 
 * Represents a node in the graph. encapsulates an other object under the form of a subject.
 * @author Stefan Pante en Kobe Vrancken
 *
 */
public class Node implements GUIElement{
	
	/**
	 * Boolean which shows if the Node is expanded.
	 */
	private boolean expanded;
	/**
	 * Needed to draw everything
	 */
	private GUI gui;

	/**
	 * the position of this node in the graph's coordinate space
	 */
	private PVector position;
	
	/**
	 * The diameter of the node
	 */
	private float diameter;
	
	/**
	 * The color of the node
	 */
	private int color;
	
	/**
	 * Determines if the position of the node can be altered.
	 */
	private boolean movable;
	
	/**
	 * The subject of the node ( this contains all the information that the node needs to encapsulate
	 */
	private Subject sub;
	
	/**
	 * Publication manager of the node. Used to find it's connections and to be able to expand a node
	 */
	private PublicationManager manager;
	
	/**
	 * The pane of the node. Needed to display relevant information 
	 */
	private Pane pane;
	
	/**
	 * Creates a new Node with a subject. Sets all other parameters to default values
	 * @param subject	the subject of this node.
	 */
	public Node(Subject subject){
		this.sub = subject;
		this.color = 0;
		this.diameter = 100;
		this.movable = true;
		this.expanded = false;
		this.pane = new Pane(this);
		this.position = new PVector();
	}
	
	/**
	 * Creates a new node with given parameters.
	 * @param subject	the subject of the node
	 * @param gui		the gui which the node uses, needed for drawing.
	 * @param manager	the publication manager of the node
	 */
	public Node(Subject subject, GUI gui, PublicationManager manager){
		this(subject);
		this.gui = (GUI) gui;
		this.pane.setGUI(gui);
		Random random = new Random();
		setPosition(150+ random.nextInt(gui.displayWidth-300), 75+random.nextInt(gui.displayHeight -150 ));
		double citationMultiplier = subject.getScore()> 0 ? Math.log(subject.getScore()) : 0;
		setDiameter((int) (10 + 5*citationMultiplier*1.5));

		this.manager = manager;
	}
	
	/**
	 * Sets if this node is movable. If this value is false, the position
	 * of the node cannot be changed.
	 * @param movable
	 */
	public void setMovable(boolean movable){
		this.movable = movable;
	}

	/**
	 * sets the subject of this node. 
	 * @param sub
	 */
	public void setSubject(Subject sub){
		this.sub = sub;
	}
	
	/**
	 * returns the subject of this node.
	 * @return
	 */
	public Subject getSubject(){
		return sub;
	}
	
	/**
	 * sets expanded to true or false.
	 * @param expanded
	 */
	public void setExpanded(boolean expanded){
		this.expanded = expanded;
	}
	
	/**
	 * Returns the expanded
	 * @return
	 */
	public boolean getExpanded(){
		return expanded;
	}
	

	/**
	 * returns all nodes connected to this node.
	 * @return
	 */
	public ArrayList<Connection> getConnections(){
		return manager.getConnectionsWith(this);
	}
	
	/**
	 * Returns if this node is connected to another node.
	 */
	public boolean isConnectedTo(Node other){
		for(Connection conn: getConnections()){
			if(conn.getOther(this) == other){
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Rollover is called when the user hovers over the node in the gui.
	 * Causes the node to change appearance.
	 */
	public void rollover(){
		gui.fill(gui.color(255,0,0),75);
		gui.noStroke();
		gui.ellipse(getTransformedPosition().x, getTransformedPosition().y, diameter +4, diameter + 4);
	}
	
	/*
	 * (non-Javadoc)
	 * @see visualisation.guielements.GUIElement#draw()
	 */
	@Override
	public void draw() {
		gui.fill(color,85);
		gui.noStroke();
		
		gui.ellipse(getTransformedPosition().x, getTransformedPosition().y, diameter, diameter);
		pane.drawFocus();
	}

	public void drawSpecial(){
		gui.fill(gui.color(0,146,211),100);
		gui.noStroke();
		gui.ellipse(getTransformedPosition().x, getTransformedPosition().y, diameter, diameter);
	}
	/**
	 * Method to check if the mouse cursor is placed inside the node
	 * 
	 * @param mouseX the X-coordinate for the mouse pointer
	 * @param mouseY the Y-coordinate for the mouse pointer
	 * @return true if the mouse is inside the node
	 */
	@Override
	public boolean hit(int mouseX, int mouseY){
		if(this.getTransformedPosition().dist(new PVector(mouseX,mouseY)) <= diameter/2){
			return true;
		}
		
		return false;
		
	}

	/**
	 * Draws the pane associated with this node. 
	 */
	public void showPane(){
		pane.draw();
	}
	
	
	/**
	 * Transforms the nodes position for relative coordinates to screen space coordinates.
	 */
	public PVector getTransformedPosition(){
		return gui.getTransform().transform(position);
	}
	
	/**
	 * returns the non transformed relative position of the node.
	 */
	public PVector getPosition(){
		return position;
	}
	
	/**
	 * sets the color of this node.
	 * @param color
	 */
	public void setColor(int color){
		this.color = color;
	}

	/**
	 * returns whether the node is hittable, always true.
	 */
	@Override
	public boolean hittable() {
		return true;
	}

	public void setPosition(double  d, double  e) {
		if(movable){
			position.x = (float) d;
			position.y = (float) e;
		}
		
	}

	/**
	 * sets the diameter of the node.
	 * @param diameter
	 */
	public void setDiameter(int diameter){
		this.diameter = diameter;
	}
	
	/**
	 * returns the color of the node.
	 */
	@Override
	public int getColor() {
		return color;
	}

	/**
	 * returns whether the node is visible
	 */
	@Override
	public boolean isVisible() {
		return true;
	}
	
	/**
	 * Sets the gui for the node. the gui is needed to draw on the screen.
	 * @param gui
	 */
	public void setGUI(GUI gui){
		this.gui =gui;
	}




}
