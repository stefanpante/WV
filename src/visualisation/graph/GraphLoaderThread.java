package visualisation.graph;

import visualisation.GUI;
import data.publication.Publication;
import data.publication.PublicationManager;

public class GraphLoaderThread implements Runnable {

	private Publication result;
	private GUI applet;

	public GraphLoaderThread(Publication result, int expansionDegree, GUI applet) {
		this.result = result;
		this.applet = applet;
	}

	public void run() {
		applet.startInitialAnimation();
		PublicationManager manager = new PublicationManager(applet);

		Publication root = result;
		manager.expand(root);

		Graph graph = new Graph(manager, applet);
		graph.setGraphLayout(new RegularForceBasedLayout());
		for (Node n : graph.getNodes().values()) {
			Publication p = (Publication) n.getSubject();
			if (root.equals(p)) {
				graph.setParentNode(n);
				n.setExpanded(true);
			}
		}
		applet.setGraph(graph);
		applet.stopInitialAnimation();
		applet.startDrawing();

	}

}
