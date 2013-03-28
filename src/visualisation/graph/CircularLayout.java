package visualisation.graph;

import java.util.ArrayList;

/**
 * puts the node in a circular layout.
 * @author Stefan
 *
 */
public class CircularLayout extends GraphLayout{

	private double corner;
	
	public CircularLayout(Graph graph) {
		super(graph);
		ArrayList<Node> nodes = new ArrayList<Node>(graph.getNodes().values());
		corner = 2* Math.PI / nodes.size();
	}
	
	public void circular(){
		ArrayList<Node> nodes = new ArrayList<Node>(graph.getNodes().values());
		double radius = 200;
		int i = 0;
		for(Node node: nodes){
			node.setPosition( graph.getGUI().displayWidth / 2 - radius*Math.cos(corner*i), graph.getGUI().displayHeight/2 -  radius*Math.sin(corner*i));
			i++;
			radius += 2;
		}
		graph.getParentNode().setPosition(graph.getGUI().displayWidth/2, graph.getGUI().displayHeight/2);
	}

	@Override
	public void layout() {
		this.circular();
		
	}

}
