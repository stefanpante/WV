package visualisation.graph;

import java.util.ArrayList;

import visualisation.subject.Subject;


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
		System.out.println("Running expand thread");
		
		manager.expand((Publication) node.getSubject(), graph, node);
		System.out.println("completing expand thread");
	}

	

}
