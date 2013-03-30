package visualisation.graph;

import java.util.ArrayList;

import processing.core.PVector;

public abstract class GraphLayout {

	/**
	 * The graph upon which the graphlayout is applied.
	 */
	protected Graph graph;

	/**
	 * constructs a new graphlayout without a graph.
	 */
	public GraphLayout(){

	}
	
	/**
	 * constructs a new graphlayout with a given graph.
	 * @param graph
	 */
	public GraphLayout(Graph graph) {
		this.graph = graph;
	}

	/**
	 * Changes the position of the graphs nodes according to the graphLayout's paradigm.
	 */
	public abstract void layout();

	/**
	 * returns the graph associated with this layout.
	 * @return
	 */
	public Graph getGraph(){
		return this.graph;
	}

	/**
	 * Sets the graph of this layout.
	 * @param graph
	 */
	public void setGraph(Graph graph){
		this.graph = graph;
	}

	/**
	 * Returns the angle between the vector represented by the connection of the given nodes
	 * and the x -axis.
	 * @param node1	
	 * @param node2
	 * @return
	 */
	protected float getAngle(Node node1, Node node2){
		PVector pos1 = node1.getPosition();
		PVector pos2 = node2.getPosition();

		float diffX = (pos2.x - pos1.x);
		float diffY = (pos2.y - pos1.y);

		if (diffX == 0) diffX = 0.001f;
		if (diffY == 0) diffY = 0.001f;
		
		return (float) Math.atan2(diffY, diffX);

	}


	/**
	 * Protected class used to store the node and it's next position before it is actually set.
	 * if we set the node's new position when it is actually calculated, it would changes the calculations 
	 * for all the other nodes which causes undesired effects.
	 * @author Stefan
	 *
	 */
	protected class NodeLayoutInfo {

		/**
		 * Referenece to the node.
		 */
		public Node node;
		
		/**
		 * storage of it's next position
		 */
		public PVector nextPosition;	

		/**
		 * Constructs a new layout info with a given node and it's next position.
		 * @param node
		 * @param nextPosition
		 */
		public NodeLayoutInfo(Node node, PVector nextPosition) {
			this.node = node;
			this.nextPosition = nextPosition;
		}
	}


	public abstract void setInitialPosition(Node node, ArrayList<Connection> conns);


}



