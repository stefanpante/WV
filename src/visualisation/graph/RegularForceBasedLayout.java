
package visualisation.graph;

import java.util.ArrayList;
import java.util.HashMap;

import processing.core.PApplet;
import processing.core.PVector;

public class RegularForceBasedLayout extends GraphLayout {
	
	public static float c1 = 30f;
	// Minimum length of spring
	public static float c2 = 150f;
	public static float c3 = 11000f;
	public static float c4 = 0.1f;

	private boolean stop = false;

	public RegularForceBasedLayout(Graph graph) {
		super(graph);
	}
	
	public RegularForceBasedLayout(){
		super();
	}
	
	/**
	 * Calculates the attraction force with a logaritmic spring.
	 * @param node
	 * @return
	 */
	private PVector calculateAttractionForce(Node node){
		PVector attractionForce = new PVector();
		for(Connection connection : node.getConnections()){
			Node other = connection.getOther(node);
//			float force = (float) (c1 * Math.max(Math.log(connection.getDistance()/c2), 0));
			int size = node.getConnections().size() * other.getConnections().size();
			if(size>800){
				size = 800;
			}
//			float force = (float) (c1 * Math.max(Math.log(connection.getDistance()/(c2*size)), 0));
			float force = (float) (node.getPosition().dist(other.getPosition()) - (150 + size)) /2;
			float angle = getAngle(node,other);
			attractionForce.add(new PVector((float) (force * Math.cos(angle)), (float) (force * Math.sin(angle))));
		}
		
		return attractionForce;
	}
	
	/**
	 * Calculates the repulsion 
	 * @param currentNode
	 * @return
	 */
	private PVector calculateRepulsionForce(Node currentNode){
		HashMap<Integer, Node> nodes = graph.getNodes();
		PVector repulsion = new PVector();
		for(Node other: nodes.values()){
			if(other != currentNode){
				float distance = currentNode.getPosition().dist(other.getPosition());
				if(distance < 50){
					float repellentForce = - (float) (c3/  Math.pow(distance , 2));
					float angle =  getAngle(currentNode,other);
				repulsion.add(new PVector((float) (repellentForce * Math.cos(angle)), (float) (repellentForce * Math.sin(angle))));
				}
			}
				
		}
		
		return repulsion;
		
	}
	
	private void forceBased(){
		if(!stop){
			
			HashMap<Integer, Node> nodes = graph.getNodes();
			ArrayList<NodeLayoutInfo> nodelayoutInfo = new ArrayList<NodeLayoutInfo>();
			
			for(Node node: nodes.values()){
				
				// Calculate the forces on the nodes
				PVector attractionForce = calculateAttractionForce(node);
				PVector repulsionForce = calculateRepulsionForce(node);
				attractionForce.add(repulsionForce);
				
				// Change the position of the Node
				PVector pos = new PVector();
				pos.x = node.getPosition().x;
				pos.y = node.getPosition().y;
				attractionForce.mult(c4);
				pos.add(attractionForce);
				
				// Save the position for later
				nodelayoutInfo.add(new NodeLayoutInfo(node, pos));
			}
			
			// Update the positions of all nodes
			for(NodeLayoutInfo info: nodelayoutInfo){
					info.node.setPosition(info.nextPosition.x, info.nextPosition.y);
			}
		}
		
		// Resets the parent node's position to the center of the screen.
		graph.getParentNode().setPosition(graph.getGUI().displayWidth/2, graph.getGUI().displayHeight/2);

	}

	@Override
	public void layout() {
		this.forceBased();
		
	}
}
