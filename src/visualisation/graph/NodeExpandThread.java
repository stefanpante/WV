package visualisation.graph;


import data.Publication;
import data.PublicationManager;

public class NodeExpandThread implements Runnable{
	
	PublicationManager manager;
	Node node;
	Graph graph;
	
	public NodeExpandThread(PublicationManager manager, Node node, Graph graph){
		this.manager = manager;
		this.node = node;
		this.graph = graph;
	}

	public void run() {
		graph.getGUI().startSearchAnimation();
		boolean success = manager.expand((Publication) node.getSubject(), graph, node);
		if(!success) manager.collapse(node);
		graph.getGUI().stopSearchAnimation();
	}

	

}
