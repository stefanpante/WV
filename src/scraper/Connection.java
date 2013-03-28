package scraper;

public class Connection {

	private Node from;
	private Node to;
	
	public Connection(Node from, Node to){
		this.from = from;
		this.to= to;
		
	}
	
	
	public Node getFrom(){
		return from;
	}
	
	public Node getTo(){
		return to;
	}
}
