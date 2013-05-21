package visualisation.graph;

import java.util.ArrayList;

import visualisation.subject.Subject;


import data.Publication;
import data.PublicationManager;

public class NodeExpandThread extends Thread{
	
	PublicationManager manager;
	Node node;
	Graph graph;
	
	public NodeExpandThread(PublicationManager manager, Node node, Graph graph){
		this.manager = manager;
		this.node = node;
		this.graph = graph;
	}

	@Override
	public void run() {
		manager.expand((Publication) node.getSubject(), graph, node);
	}

	

}
