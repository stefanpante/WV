	
package visualisation.graph;
import java.util.ArrayList;
import java.util.Random;
import data.publication.PublicationManager;
import processing.core.PVector;
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
	private int color2;
	
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
	
	private boolean locked;
	
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
		this.locked = false;
		this.position = new PVector();
		this.pane = new Pane(this);
		this.color2 = 0;
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
		this.color2 = gui.color(0,146,211);
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
	public void draw() {
		if(justDragged){
			this.setMovable(false);
		}
		
		if(movable){
			resetColor();
			pane.getPin().setActive(false);
		}
		gui.fill(color,85);
		gui.noStroke();
		
		gui.ellipse(getTransformedPosition().x, getTransformedPosition().y, diameter, diameter);
		
		gui.fill(color2,100);
		gui.noStroke();
		gui.ellipse(getTransformedPosition().x, getTransformedPosition().y, diameter, diameter);
			
		if(pane.hasFocus()){
			pane.draw();
		}
	}

	/**
	 * Method to check if the mouse cursor is placed inside the node
	 * 
	 * @param mouseX the X-coordinate for the mouse pointer
	 * @param mouseY the Y-coordinate for the mouse pointer
	 * @return true if the mouse is inside the node
	 */
	public boolean hit(int mouseX, int mouseY){
		if(this.getTransformedPosition().dist(new PVector(mouseX,mouseY)) <= diameter/2 || pane.hit(mouseX, mouseY)){
			pane.setFocus(true);
			return true;
		}
		pane.setFocus(false);
		return false;
		
	}
	
	public boolean hit2(int mouseX, int mouseY){
		if(this.getTransformedPosition().dist(new PVector(mouseX,mouseY)) <= diameter/2){
			return true;
		}
		
		return false;
	}
	
	public boolean mousePressed(int mouseX, int mouseY){
		if(this.hit(mouseX, mouseY)){
			this.locked = true;
			return true;
		}
		return false;
	}
	
	public void mouseReleased(){
		this.locked = false;
		this.justDragged = false;
	}
	
	boolean justDragged = false;
	
	public boolean mouseDragged(int mouseX, int mouseY){
		if(locked){
			setMovable(true);
			PVector transformed = gui.getTransform().inverseTransform(new PVector(mouseX, mouseY));
			this.setPosition(transformed.x, transformed.y);
			this.justDragged = true;
			this.color2 = gui.color(19,158,0, 255);
			this.pane.setPosition(new PVector(transformed.x, transformed.y));
			this.pane.getPin().setActive(true);
			return true;
		}
		
		
		return false;
	}

	public Pane getPane(){
		return this.pane;
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

	public void setPosition(double  d, double  e) {
		if(movable){
			position.x = (float) d;
			position.y = (float) e;
			if(pane != null){
				pane.setPosition(d,e);
			}
		}
		
	}

	/**
	 * sets the diameter of the node.
	 * @param diameter
	 */
	public void setDiameter(int diameter){
		this.diameter = diameter;
	}
	
	public float getDiameter(){
		return this.diameter;
	}
	
	public void resetColor(){
		this.color = 0;
		this.color2 = gui.color(0,146,211);
	}
	
	public void dragColor(){
		this.color = 0;
		this.color2 = gui.color(19,158,0, 255);
	}

	@Override
	public boolean hittable() {
		return true;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public int getColor() {
		return 0;
	}




}
