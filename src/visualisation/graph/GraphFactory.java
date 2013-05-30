package visualisation.graph;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import data.Publication;
import data.PublicationFactory;
import data.PublicationManager;


import visualisation.Application;
import visualisation.GUI;

public class GraphFactory {

	private static volatile GraphFactory instance;

	private GraphFactory() {

	}

	public static GraphFactory getInstance() {
		if (instance == null)
			instance = new GraphFactory();
		return instance;
	}

	public void fromSearchResult(Publication result, int expansionDegree, GUI applet)
		 {
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(new GraphLoaderThread(result, expansionDegree, applet));

	}

}
