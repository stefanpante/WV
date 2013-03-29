package lucene;

import java.util.Map;


/**
 *
 * 
 * @author Kobe Vrancken
 *
 */
public class Document {

	public final String identifier;
	
	public final Map<String, Integer> termFrequencies;
	

	public Document(final String identifier, final Map<String, Integer> termFrequencies){
		this.identifier = identifier;
		this.termFrequencies = termFrequencies;
	}
	
	public double compareContent(Document document, CompareStrategy strategy){
		return strategy.compare(this, document);
	}

}
