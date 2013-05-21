package visualisation.graph;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import data.CitationFactory;
import data.Publication;
import data.PublicationFactory;
import data.PublicationManager;
import data.SQLConnector;

import processing.core.PApplet;
import visualisation.Application;
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
		
		Publication root;
		try {
			root = Application.live ? PublicationFactory.fromAcademicsID(id) : PublicationFactory.fromDatabaseID(id);
		System.out.println(root);
		manager.addPublication(root);
		Node n = new Node(root, applet,manager);
		Graph graph = new Graph(manager.getConnections(), manager, applet, n);
		graph.setGraphLayout( new RegularForceBasedLayout());
		manager.expand(root, graph, n);
		return graph;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	

}
