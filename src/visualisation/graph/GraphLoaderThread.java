package visualisation.graph;

import visualisation.Application;
import visualisation.GUI;
import data.Publication;
import data.PublicationFactory;
import data.PublicationManager;
import data.SQLConnector;

public class GraphLoaderThread implements Runnable{
	
	private int id;
	private int expansionDegree;
	private GUI applet;
	
	public GraphLoaderThread(int id, int expansionDegree, GUI applet){
		this.id = id;
		this.expansionDegree = expansionDegree;
		this.applet = applet;
	}

	public void run() {
		applet.startInitialAnimation();
		if (!Application.live)
			SQLConnector.initialize("jdbc:mysql://localhost/visualisation",
					"root", "");
		PublicationManager manager = new PublicationManager(applet);

		Publication root;
		try{
		root = Application.live ? PublicationFactory.fromAcademicsID(id)
				: PublicationFactory.fromDatabaseID(id);

		manager.expand(root);

		Graph graph = new Graph(manager, applet);
		graph.setGraphLayout(new RegularForceBasedLayout());
		for (Node n : graph.getNodes().values()) {
			Publication p = (Publication) n.getSubject();
			if (root.equals(p)) {
				graph.setParentNode(n);
				n.setExpanded(true);
				// TODO: set parentnode to expanded
			}
		}
		applet.setGraph(graph);
		applet.stopInitialAnimation();
		applet.startDrawing();
		} catch(Exception e){
			applet.stopInitialAnimation();
			applet.showWarning("Oops, something went wrong,  \n It seems that the Microsoft servers are not responding!");
			e.printStackTrace();
		}
		
	}

}
