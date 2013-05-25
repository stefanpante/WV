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

	private GraphFactory() {

	}

	public static GraphFactory getInstance() {
		if (instance == null)
			instance = new GraphFactory();
		return instance;
	}

	public Graph fromDatabaseID(int id, int expansionDegree, GUI applet)
			throws SQLException {
		if(!Application.live) SQLConnector.initialize("jdbc:mysql://localhost/visualisation", "root",
				"");
		PublicationManager manager = new PublicationManager(applet);

		Publication root;
		try {
			root = Application.live ? PublicationFactory.fromAcademicsID(id)
					: PublicationFactory.fromDatabaseID(id);

			manager.addPublication(root);
			manager.expand(root);

			Graph graph = new Graph(manager.getConnections(), manager, applet);
			graph.setGraphLayout(new RegularForceBasedLayout());
			for (Node n : graph.getNodes().values()) {
				Publication p = (Publication) n.getSubject();
				if (root.equals(p)) {
					graph.setParentNode(n);
					// TODO: set parentnode to expanded
				}
			}
			return graph;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
