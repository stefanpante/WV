package visualisation.graph;


import data.publication.Publication;
import data.publication.PublicationManager;

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
		manager.expand((Publication) node.getSubject(), graph, node);
		graph.getGUI().stopSearchAnimation();
	}

	

}
