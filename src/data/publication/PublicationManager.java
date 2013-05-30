package data.publication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;



import visualisation.GUI;
import visualisation.graph.Connection;
import visualisation.graph.Graph;
import visualisation.graph.Node;

/**
 * Manages a list of publications and their citations
 * 
 * @author Kobe
 * 
 */

public class PublicationManager {

	private GUI applet;

	public PublicationManager(GUI applet) {
		this.applet = applet;
	}

	private CopyOnWriteArrayList<Connection> connections = new CopyOnWriteArrayList<Connection>();
	private ConcurrentHashMap<Integer, Node> nodes = new ConcurrentHashMap<Integer, Node>();

	public boolean hasPublication(Publication publication) {
		return getOpenPublications().contains(publication);
	}

	public HashSet<Publication> getOpenPublications() {
		HashSet<Publication> result = new HashSet<Publication>();
		for (Node node : nodes.values()) {
			Publication pub = (Publication) node.getSubject();
			result.add(pub);
		}
		return result;
	}

	public HashSet<Node> getExpandedNodes() {
		HashSet<Node> expandedNodes = new HashSet<Node>();
		for (Node node : nodes.values()) {
			if (node.getExpanded() == true) {
				expandedNodes.add(node);
			}
		}
		return expandedNodes;
	}

	public void expand(Publication publication, Graph graph, Node node) {
		if (getExpandedNodes().contains(node)) {
			this.collapse(node);
		} else {
			ArrayList<Connection> expandedConnections = expand(publication);
			graph.positionNodes(node, expandedConnections);
			node.setExpanded(true);
		}
	}

	public ArrayList<Connection> expand(Publication publication) {
		ArrayList<Connection> result = new ArrayList<Connection>();
		HashSet<Publication> citedPublications;
		HashSet<Publication> citingPublications;
		citedPublications = CitationFactory.forwardCitationsFromAcademics(publication.getID());
		citingPublications = CitationFactory.backwardCitationsFromAcademics(publication.getID());
				

		//citedPublications.removeAll(getOpenPublications());
		//citingPublications.removeAll(getOpenPublications());
		for (Publication citation : citedPublications) {
			Connection c = addCitation(publication, citation, false);
			//if(!connections.contains(c))
				result.add(c);
		}
		for (Publication citation : citingPublications) {
			Connection c = addCitation(publication, citation, true);
			//if(!connections.contains(c))
				result.add(c);
		}
		return result;
	}

	public void collapse(Node node) {
		for (Connection connection : getConnectionsWith(node)) {
			Node other = connection.getNode1().equals(node) ? connection.getNode2() : connection.getNode1();
			
			
			if(!hasAnyOtherConnections(other, connection)){
				this.nodes.remove(other.getSubject().getID());
				connections.remove(connection);
			}
			node.setExpanded(false);
		}
		applet.loop();
		applet.setFixed(false);

	}

	private boolean hasAnyOtherConnections(Node other, Connection connection) {
		ArrayList<Connection> openConnections = this.getConnectionsWith(other);
		openConnections.remove(connection);
		return openConnections.size() > 0;
	}

	private Connection addCitation(Publication from, Publication to,
			boolean firstIsOriginal) {
		Node firstNode;
		if (nodes.containsKey(from.getID()))
			firstNode = nodes.get(from.getID());
		else
			firstNode = new Node(from, applet, this);
		Node secondNode;
		if (nodes.containsKey(to.getID()))
			secondNode = nodes.get(to.getID());
		else
			secondNode = new Node(to, applet, this);
		Connection connection = new Connection(firstNode, secondNode, applet,
				firstIsOriginal);
		if (!connections.contains(connection)) {
			connections.add(connection);
			nodes.put(firstNode.getSubject().getID(), firstNode);
			nodes.put(secondNode.getSubject().getID(), secondNode);
		}

		return connection;
	}

	public CopyOnWriteArrayList<Connection> getConnections() {
		return connections;
	}

	public ConcurrentHashMap<Integer, Node> getNodes() {
		return nodes;
	}

	public ArrayList<Connection> getConnectionsWith(Node node) {
		ArrayList<Connection> result = new ArrayList<Connection>();
		for (Connection connection : connections)
			if (connection.getNode1().equals(node)
					|| connection.getNode2().equals(node))
				result.add(connection);
		return result;
	}

}
