package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import processing.core.PApplet;

import visualisation.GUI;
import visualisation.graph.Connection;
import visualisation.graph.Node;

/**
 * Manages a list of publications and their citations
 * 
 * @author Kobe
 *
 */

public class PublicationManager {
	
	private GUI applet;
	
	public PublicationManager(GUI applet){
		this.applet = applet;
	}

	private HashMap<Integer, Publication> openPublications = new HashMap<Integer, Publication>();
	private HashSet<Publication> expandedPublications = new HashSet<Publication>();
	private ArrayList<Connection> connections = new ArrayList<Connection>();
	private HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
	
	public boolean hasPublication(Publication publication){
		return openPublications.containsKey(publication.getID());
	}
	
	public void addPublication(Publication publication){
		if(!hasPublication(publication)) openPublications.put(publication.getID(),publication);		
		//for(Publication citation : publication.getCitations()) addCitation(publication, citation);
	}
	
	public ArrayList<Connection> expand(Publication publication){
		ArrayList<Connection> expandedConnections = new ArrayList<Connection>();
		if(expandedPublications.contains(publication)) System.out.println("This publication has already been expanded");
		else{
			try {
				HashSet<Publication> citations = CitationFactory.forwardCitations(publication.getID());
				citations.removeAll(expandedPublications);
				for(Publication citation : citations){
					expandedConnections.add(addCitation(publication, citation, false));
				}
				expandedPublications.add(publication);
				
				citations = CitationFactory.backwardCitations(publication.getID());
				citations.removeAll(expandedPublications);
				for(Publication citation : citations){
					expandedConnections.add(addCitation(publication, citation, true));
				}
				expandedPublications.add(publication);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return expandedConnections;
	}
	
	public ArrayList<Connection> collapse(Node node){
		ArrayList<Connection> collapsedConnections = new ArrayList<Connection>();
		
		for(Connection connection: connections){
			if(connection.getNode1() == node){
				collapsedConnections.add(connection);
				connections.remove(connection);
			}
		}
		applet.loop();
		applet.setFixed(false);
		return collapsedConnections;
		
	}
		
	
	private Connection addCitation(Publication from, Publication to, boolean firstIsOriginal){
		addPublication(to);
		Node firstNode;
		if(nodes.containsKey(from.getID())) firstNode = nodes.get(from.getID());
		else firstNode = new Node(from, applet, this);
		Node secondNode;
		if(nodes.containsKey(to.getID())) secondNode = nodes.get(to.getID());
		else secondNode = new Node(to, applet, this);
		Connection connection = new Connection(firstNode, secondNode, applet, firstIsOriginal);
		if(!connections.contains(connection)){
			connections.add(connection);
			nodes.put(firstNode.getSubject().getID(), firstNode);
			nodes.put(secondNode.getSubject().getID(), secondNode);
		}
		
		return connection;
	}
	
	public ArrayList<Connection> getConnections(){
		return connections;
	}
	
	public HashMap<Integer, Node> getNodes(){
		return nodes;
	}

	public Publication getPublication(int i) {
		return openPublications.get(i);
	}

	public ArrayList<Connection> getConnectionsWith(Node node) {
		ArrayList<Connection> result = new ArrayList<Connection>();
		for(Connection connection : connections)
			if(connection.getNode1().equals(node) || connection.getNode2().equals(node)) 
				result.add(connection);
		return result;
	}


	
}
