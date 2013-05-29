package visualisation.graph;

import java.util.ArrayList;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import data.PublicationManager;

import visualisation.GUI;
import visualisation.guielements.Drawable;

/**
 * Class representing a connected graph. Contains nodes and connections.
 * 
 * @author Stefan
 * 
 */
public class Graph implements Drawable {

	/**
	 * The gui which will be drawn upon.
	 */
	private GUI gui;

	/**
	 * the parent node of this graph. this is the central node. Can also be
	 * considered the root of the graph.
	 */
	private Node parentNode;
	
	private ArrayList<Node> selectedNodes; 

	/**
	 * The graphlayout of this graph. Determines how the graph is structured
	 */
	private GraphLayout graphlayout;

	/**
	 * The manager for this graph. needed to be able to expand the graph.
	 */
	// TODO: should be superclass so other things than publications can be
	// displayed.
	private PublicationManager manager;

	/**
	 * This boolean represents if nodes are fixed when expanded or not. fix
	 * meaning that the node cannot move when expanded.
	 */
	boolean fix = false;

	/**
	 * Creates a new graph based on a given list of connections. Uses the nodes
	 * specified in the connections
	 * 
	 * @param connections
	 *            List of connections between nodes
	 * @param regularForceBasedLayout
	 */
	public Graph(PublicationManager manager, GUI gui) {
		this.manager = manager;
		this.gui = gui;
	}

	// XXX: Dont know how to solve it otherwise for now
	private Pane activePane;

	/**
	 * checks whether there are nodes in the graph which are hit by the mouse.
	 * if a node is hit, it calls the appropiate methods on the node.
	 * 
	 * @param mouseX
	 *            the x position of the mouse on the screen
	 * @param mouseY
	 *            the y position of the mouse on the screen
	 */
	public void hit(int mouseX, int mouseY) {
		if (activePane != null) {
			if (activePane.hit(mouseX, mouseY)) {
				activePane.getParentNode().rollover();
				activePane.getParentNode().showPane();
				if (activePane.getShowPublicationsButton().hit(mouseX, mouseY)) {
					activePane.getShowPublicationsButton().rollover();
				}
			} else {
				activePane = null;
			}
		}

		if (activePane == null) {
			for (Node node : getNodes().values()) {
				if (node.hit(mouseX, mouseY)) {
					node.rollover();
					activePane = node.getPane();
					node.showPane();
					break;

				} else {
					node.getPane().setFocus(false);
				}
			}
		}
	}

	/**
	 * sets a graphlayout for this graph. ensures the bidirectional relationship
	 * between the graph and the graphlayout
	 * 
	 * @param graphlayout
	 */
	public void setGraphLayout(GraphLayout graphlayout) {
		this.graphlayout = graphlayout;
		graphlayout.setGraph(this);
	}

	/**
	 * returns the graphlayout for this graph
	 * 
	 * @return
	 */
	public GraphLayout getGraphLayout() {
		return this.graphlayout;
	}

	/**
	 * Sets the parent node(root) for this graph.
	 * 
	 * @param node
	 */
	public void setParentNode(Node node) {
		this.parentNode = node;
	}

	/**
	 * returns the parent node for this graph.
	 * 
	 * @return
	 */
	public Node getParentNode() {
		return parentNode;
	}

	/**
	 * returns the gui of this graph.
	 * 
	 * @return
	 */
	public GUI getGUI() {
		return this.gui;
	}

	/**
	 * Draws all the connections in this graph
	 */
	public void draw() {
		for (Connection connection : manager.getConnections()) {
			connection.draw();
		}
		for (Node node : manager.getNodes().values()) {
			node.draw();
		}
		parentNode.rollover();
	}

	/**
	 * Checks which node is double clicked upon by the user in the gui. If it
	 * hits a node, the node ist direct descendants are added.
	 * 
	 * @param mouseX
	 *            the x coordinate of the mouse
	 * @param mouseY
	 *            the y coordinate of the mouse
	 */
	public void expand(int mouseX, int mouseY) {
		for (Node node : getNodes().values()) {
			if (node.hit(mouseX, mouseY)) {
				
				ExecutorService executor = Executors.newCachedThreadPool();
				executor.execute(new NodeExpandThread(manager, node, this));
				break;
			}

		}
	}
	
	public void expand(Node node){
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(new NodeExpandThread(manager, node, this));		
	}

	public void positionNodes(Node parentNode, ArrayList<Connection> conns) {
		getGraphLayout().setInitialPosition(parentNode, conns);
		if (fix)
			parentNode.setMovable(false);
		parentNode.setExpanded(true);
	}

	public void mouseHit(int mouseX, int mouseY) {
		if (activePane != null) {
			activePane.getShowPublicationsButton().action(mouseX, mouseY);
		}
	}

	public boolean mouseDragged(int mouseX, int mouseY) {
		for (Node node : getNodes().values()) {
			if (node.mouseDragged(mouseX, mouseY)) {
				return true;
			}
		}
		return false;
	}

	public boolean mousePressed(int mouseX, int mouseY) {
		if(activePane != null){
			if(activePane.mousePressed(mouseX, mouseY))
				return true;
		}
		for (Node node : getNodes().values()) {
			if (node.mousePressed(mouseX, mouseY)) {
				return true;
			}
		}

		return false;
	}

	public void mouseReleased() {
		for (Node node : getNodes().values()) {
			node.mouseReleased();
		}
	}

	/**
	 * Arranges the graph according to its layout.
	 */
	public void layout() {
		graphlayout.layout();
	}

	/**
	 * returns the nodes as a hashmap. The key is the nodes identification
	 * number.
	 * 
	 * @return
	 */
	public ConcurrentHashMap<Integer, Node> getNodes() {
		return manager.getNodes();
	}

	/**
	 * A toggle function to fix or unfix the nodes in the graph.
	 */
	public void fix() {
		if (fix) {
			fix = false;
			unfix();
		}

		else {
			fix = true;
		}
	}

	/**
	 * Sets all the nodes to movable.
	 */
	private void unfix() {
		for (Node node : manager.getNodes().values()) {
			node.setMovable(true);
		}

	}
}
