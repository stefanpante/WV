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
			if(root.equals(p)){
				graph.setParentNode(n);
				System.out.println("Parent Node set");
				//TODO: set parentnode to expanded
			}
		}
		return graph;
	}
	
	

}
