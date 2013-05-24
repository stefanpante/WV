package visualisation.graph;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import data.Publication;
import data.PublicationManager;

import processing.core.PApplet;
import processing.core.PVector;
import visualisation.GUI;
import visualisation.guielements.Drawable;

/**
 * Class representing a connected graph. Contains nodes and connections.
 * @author Stefan
 *
 */
public class Graph implements Drawable{

	/*
	 * The connections which make up the node.
	 */
	private CopyOnWriteArrayList<Connection> connections;

	/**
	 * The gui which will be drawn upon.
	 */
	private GUI gui;

	/**
	 * the parent node of this graph. this is the central node.
	 * Can also be considered the root of the graph.
	 */
	private Node parentNode;

	/**
	 * The graphlayout of this graph. Determines how the graph is structured
	 */
	private GraphLayout graphlayout;

	/**
	 * The manager for this graph. needed to be able to expand the graph.
	 */
	//TODO: should be superclass so other things than publications can be displayed.
	private PublicationManager manager;

	/**
	 * This boolean represents if nodes are fixed when expanded or not.
	 * fix meaning that the node cannot move when expanded. 
	 */
	boolean fix = false;

	/**
	 * Creates an empty graph. Nodes and connections can be added later
	 */
	public Graph() {
		//this.nodes = new HashMap<Integer, Node>();
		this.connections = new CopyOnWriteArrayList<Connection>();
	}

	/**
	 * Creates a new graph based on a given list of connections.
	 * Uses the nodes specified in the connections
	 * @param connections	List of connections between nodes
	 * @param regularForceBasedLayout 
	 */
	public Graph(CopyOnWriteArrayList<Connection> connections, PublicationManager manager, GUI gui, Node parentNode){
		this.connections = connections;
		this.manager = manager;
		this.gui = gui;
		this.parentNode = parentNode;
		parentNode.setMovable(false);
	}


	
	// XXX: Dont know how to solve it otherwise for now
	private Pane activePane;
	/**
	 * checks whether there are nodes in the graph which are hit by the mouse.
	 * if a node is hit, it calls the appropiate methods on the node. 
	 * @param mouseX	the x position of the mouse on the screen
	 * @param mouseY	the y position of the mouse on the screen
	 */
	public void hit(int mouseX, int mouseY){
		if(activePane != null){
			if(activePane.hit(mouseX, mouseY)){
				activePane.getParentNode().rollover();
				activePane.getParentNode().showPane();
				if(activePane.getGUIButton().hit(mouseX, mouseY)){
					activePane.getGUIButton().rollover();
				}
			}
			else{
				activePane = null;
			}
		}

		if(activePane == null){
			for(Node node: getNodes().values()){
				if(node.hit(mouseX, mouseY)){
					node.rollover();
					activePane = node.getPane();
					node.showPane();
					break;

				}
				else{
					node.getPane().setFocus(false);
				}
			}
		}
	}

	/**
	 * sets a graphlayout for this graph. ensures the bidirectional relationship between 
	 * the graph and the graphlayout
	 * @param graphlayout
	 */
	public void setGraphLayout(GraphLayout graphlayout){
		this.graphlayout = graphlayout;
		graphlayout.setGraph(this);
	}

	/**
	 * returns the graphlayout for this graph
	 * @return
	 */
	public GraphLayout getGraphLayout(){
		return this.graphlayout;
	}

	/**
	 * Sets the parent node(root) for this graph.
	 * @param node
	 */
	public void setParentNode(Node node){
		this.parentNode = node;
	}

	/**
	 * returns the parent node for this graph.
	 * @return
	 */
	public Node getParentNode(){
		return parentNode;
	}



	/**
	 * Extracts all nodes from a list of connections and saves them.
	 * @param connections 	the list of connections
	 */
	/*private void initializeNodes(ArrayList<Connection> connections){

		//TODO: for testing purposes
		for(Connection connection: connections){
			Node node1 = connection.getNode1();
			Node node2 = connection.getNode2();
			if(!nodes.containsValue(node1)){
				this.nodes.put(node1.getSubject().getID(), node1);
				//node1.addConnection(connection);
			}
			if(!nodes.containsValue(node2)){
				this.nodes.put(node2.getSubject().getID(),node2);
				//node2.addConnection(connection);
			}
		}

	}*/



	/**
	 * returns the gui of this graph.
	 * @return
	 */
	public GUI getGUI(){
		return this.gui;
	}


	/**
	 * Draws all the connections in this graph
	 */
	public void draw() {
		for(Connection connection: connections){
			connection.draw();
		}
		for(Node node: getNodes().values()){
			node.draw();
		}
		parentNode.rollover();
	}

	/**
	 * Checks which node is double clicked upon by the user in the gui.
	 * If it hits a node, the node ist direct descendants are added.
	 * 
	 * @param mouseX	the x coordinate of the mouse
	 * @param mouseY	the y coordinate of the mouse
	 */
	public void expand(int mouseX, int mouseY){
		for(Node node: getNodes().values()){
			if(node.hit(mouseX, mouseY)){

				if(!node.getExpanded()){
					ExecutorService executor = Executors.newCachedThreadPool();
					executor.execute( new NodeExpandThread(manager, node, this));
				}
				System.out.println("Continue normal exectution");
				break;
			}



		}
	}

	public void addNodes(Node parentNode, ArrayList<Connection> conns) {
		this.addConnections(conns);
		getGraphLayout().setInitialPosition(parentNode, conns);
		if(fix) parentNode.setMovable(false);
		parentNode.setExpanded(true);
	}

	public void mouseHit(int mouseX, int mouseY){
		if(activePane != null){
			
			activePane.getGUIButton().action(mouseX, mouseY);
			}
	}

	/**
	 * Returns the number of nodes in this graph.
	 * @return
	 */
	public int getNumberOfNodes(){
		return this.getNodes().size();
	}

	/**
	 * returns the number of connections in this graph.
	 * @return
	 */
	public int getNumberOfConnections(){
		return this.connections.size();
	}

	/**
	 * Arranges the graph according to its layout.
	 */
	public void layout(){
		graphlayout.layout();
	}


	/**
	 * adds a list of connections to this graph.
	 * @param conns
	 */
	public void addConnections(ArrayList<Connection> conns){
		for(Connection connection: conns ){
			this.addConnection(connection);
		}
	}

	public void removeConnections(ArrayList<Connection> conns){
		for(Connection connection: conns){
			this.removeConnection(connection);
		}
	}

	public void removeConnection(Connection connection){
		connections.remove(connection);
	}

	/**
	 * Adds a connection to the graph
	 * @param connection the connection to be added
	 */
	public void addConnection(Connection connection){
		if(!connections.contains(connection)){
			this.connections.add(connection);
			if(!getNodes().containsValue(connection.getNode1())){
				Node node1 = connection.getNode1();
				getNodes().put(node1.getSubject().getID(), node1);
			}
			if(!getNodes().containsValue(connection.getNode2())){
				Node node2 = connection.getNode2();
				getNodes().put(node2.getSubject().getID(), node2);
			}
		}
	}

	/**
	 * Adds a connection to the graph, based on two nodes.
	 * @param node1 the first node to be added.
	 * @param node2 the second node to be added.
	 */
	public void addConnection(Node node1, Node node2, boolean firstIsOriginal){
		Connection connection = new Connection(node1,node2,gui, firstIsOriginal);
		this.connections.add(connection);
	}

	/** 
	 * returns the nodes as a hashmap. The key is the nodes identification number.
	 * @return
	 */
	public ConcurrentHashMap<Integer, Node> getNodes(){
		return manager.getNodes();
	}


	/**
	 * A toggle function to fix or unfix the nodes in the graph.
	 */
	public void fix() {
		if(fix){
			fix = false;
			unfix();
		}

		else{
			fix = true;
		}
	}

	/**
	 * Sets all the nodes to movable.
	 */
	private void unfix() {
		for(Node node: manager.getNodes().values()){
			node.setMovable(true);
		}

	}
}


