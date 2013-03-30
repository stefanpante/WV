
package visualisation.graph;


import processing.core.PApplet;
import processing.core.PVector;
import visualisation.GUI;
import visualisation.guielements.Drawable;
import visualisation.guielements.GUIElement;

/**
 * Connection represents the connection between two nodes inside a graph ( can be used for any other type of connection)
 * @author Stefan Pante
 *
 */
public class Connection implements Drawable{
	
	/**
	 * The first node of the connection
	 */
	private Node node1;
	
	/**
	 * the second node of the connection
	 */
	private Node node2;
	
	/**
	 * The color of this connection ( used for drawing)
	 */
	private int color;
	
	/**
	 * Boolean that saves if the first node is the original paper (the one that cites the other one)
	 */
	private boolean firstIsOriginal;
	
	/**
	 * A reference to the GUI is needed to be able to draw.
	 */
	private GUI gui;

	
	/**
	 * Constructs a new connection with the given nodes.
	 * @param node1		the first node of the connection.
	 * @param node2		the second node of the connection.
	 */
	public Connection(Node node1, Node node2, boolean firstIsOriginal){
		this.node1 = node1;
		this.node2 = node2;
		this.color = 0;
	}
	
	/**
	 * Constructs a new connection with the given nodes and a gui object to be able to draw.
	 * @param node1		the first node of the connection.
	 * @param node2		the second node of the connection.
	 * @param gui		the gui, which will be used to draw.
	 */
	public Connection(Node node1, Node node2, GUI gui, boolean firstIsOriginal) {
		this(node1, node2, firstIsOriginal);
		this.gui = gui;
		
	}
	
	/**
	 * Calculates the distance between two nodes. Uses position which is specified in the Node class.
	 * @return the distance between two nodes.
	 */
	public float getDistance(){

		return node1.getPosition().dist(node2.getPosition());
	}
	
	/**
	 * Calculates the angle between the connection and the x - axis of the coordinatespace.
	 * @return
	 */
	public float getAngle(){
		float x1 = node1.getPosition().x;
		float x2 = node2.getPosition().x;
		float y1 = node1.getPosition().y;
		float y2 = node1.getPosition().y;
		
		return (float) (Math.atan((x2-x1)/(y2-y1)));
	}
	
	/**
	 * Checks which node is given and returns the other one in this connection.
	 * @param node the node which will be used to compare
	 * @return	the other node than the one which is specified.
	 */
	public Node getOther(Node node){
		if(node1 == node) return node2;
		return node1;
	}

	/**
	 * Draws the connections. The opacity of the line which represents the connection is determined by
	 * the distance between the two end points of the connection.
	 */
	@Override
	public void draw() {
		
		// calculate the theoretical max distance between the two end points of the connection.
		float max = (float) Math.sqrt(gui.displayWidth*gui.displayWidth + gui.displayHeight*gui.displayHeight);
		max *= 0.75;
		// Map the distance between the two end nodes to a range of 0..100 to have a value for the opacity
		float alpha =  PApplet.map(getDistance(), 0, max, 100, 0);
		
		// set the stroke to the color of this connection. Adjust the opacity for distance.
		gui.stroke(color, 5 + alpha * 0.5f);
		
		// Get the positions of the two endpoints of the connection
		PVector pos1 = node1.getTransformedPosition();
		PVector pos2 = node2.getTransformedPosition();
		
		// draw the connection
		gui.line(pos1.x, pos1.y, pos2.x, pos2.y);
	
	}
	
	
	

	/**
	 * Setter for the gui. the specified gui will be used to draw.
	 * @param gui	the gui to be used.
	 */
	public void setGUI(GUI gui){
		this.gui = gui;
	}
	


	public int getColor() {
		return color;
	}

	/**
	 * Returns the first node of the connection
	 * @return
	 */
	public Node getNode1(){
		return node1;
	}
	
	/**
	 * returns the second node of the connection
	 * @return
	 */
	public Node getNode2(){
		return node2;
	}

	/**
	 * checks if this connection is equal to another connection.
	 * uses the subject of a node to determine if it the two nodes are equal.
	 * @param o
	 * @return
	 */
	
	//TODO: should use the equals method specified in node
	public boolean equals(Connection o) {
		if(o.getNode1().getSubject().equals(this.getNode1().getSubject()) &&
				o.getNode2().getSubject().equals(this.getNode2().getSubject()))
			return true;
		if(o.getNode2().getSubject().equals(this.getNode1().getSubject()) &&
				o.getNode1().getSubject().equals(this.getNode2().getSubject()))
			return true;
		return false;
	}

	
}
