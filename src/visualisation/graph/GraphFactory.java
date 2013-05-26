package visualisation.graph;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import data.Publication;
import data.PublicationFactory;
import data.PublicationManager;
import data.SQLConnector;

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

	public void fromDatabaseID(int id, int expansionDegree, GUI applet)
		 {
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(new GraphLoaderThread(id, expansionDegree, applet));

	}

}
