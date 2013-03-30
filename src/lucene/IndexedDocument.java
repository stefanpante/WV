package lucene;

import java.util.Map;


/**
 *
 * 
 * @author Kobe Vrancken
 *
 */
public class IndexedDocument {

	public final String identifier;
	
	public final Map<String, Integer> termFrequencies;
	

	public IndexedDocument(final String identifier, final Map<String, Integer> termFrequencies){
		this.identifier = identifier;
		this.termFrequencies = termFrequencies;
	}
	
	public double compareContent(IndexedDocument document, CompareStrategy strategy){
		return strategy.compare(this, document);
	}

}
