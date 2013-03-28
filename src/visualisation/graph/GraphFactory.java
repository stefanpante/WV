package visualisation.graph;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import database.CitationFactory;
import database.Publication;
import database.PublicationFactory;
import database.PublicationManager;
import database.SQLConnector;

import processing.core.PApplet;
import visualisation.GUI;
import visualisation.IDSubject;

public class GraphFactory {

	private static volatile GraphFactory instance;
	
	private GraphFactory(){
		
	}
	
	public static GraphFactory getInstance(){
		if(instance == null) instance = new GraphFactory();
		return instance;
	}
	
	
	public Graph fromDatabaseID(int id, int expansionDegree, GUI applet) throws SQLException{
		SQLConnector.initialize("jdbc:mysql://localhost/visualisation", "root", "");
		PublicationManager manager = new PublicationManager(applet);
		
		Publication root = PublicationFactory.fromDatabaseID(id);
		manager.addPublication(root);
		manager.expand(root);

		Graph graph = new Graph(manager.getConnections(), manager, applet);
		for(Node n : graph.getNodes().values()){
			Publication p = (Publication) n.getSubject();
			if(Publication.root.equals(p)) graph.setParentNode(n);
		}
		return graph;
	}
	
	
	
	
	
	public Graph fromBinary(int size, GUI applet){
		Graph graph = new Graph(createBinary(size, applet), null, applet);
		// Sets the parent node for the graph
		graph.setParentNode(graph.getNodes().get(1));
		return graph;
	}
	

	private ArrayList<Connection> createBinary(int size, GUI applet){
		HashMap<Integer,Node> nodes = new HashMap<Integer,Node>();
		// Create all nodes of the binary tree
		for(int i= 0; i < size; i++){
			IDSubject subject = new IDSubject(i+1, applet);
			Node node = new Node(subject, applet, null);
			node.setColor(applet.color(0));
			nodes.put(i+1, node);
		}

		Node node = nodes.get(1);
		if(node == null ) System.out.println("Null");
		// Create all the connections in the binary tree
		ArrayList<Connection> connections = new ArrayList<Connection>();
		for(Integer key: nodes.keySet()){
			if(nodes.containsKey(key*2)){
				Connection conn = new Connection(nodes.get(key), nodes.get(key*2), applet);
				connections.add(conn);
			}

			if(nodes.containsKey(key*2 +1)){
				Connection conn2 = new Connection(nodes.get(key), nodes.get(key*2 +1), applet);
				connections.add(conn2);
			}

//			if(nodes.containsKey(key*2) && nodes.containsKey(key*2+1)){
//				connections.add(new Connection(nodes.get(key*2), nodes.get(key*2+1), this));
//			}
		}

		return connections;


	}

}
