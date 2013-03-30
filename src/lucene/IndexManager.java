package lucene;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.Version;

public class IndexManager {
	
	private static volatile IndexManager singletonInstance;
	
	private static final String INDEX_DIRECTORY = "data/frequencies";
    private static final String CONTENT = "content";
    private static final String IDENTIFIER = "identifier";
    private static final String TITLE = "title";
	
	private final Directory directory;

	private IndexManager() throws IOException {
		directory = new SimpleFSDirectory(new File(INDEX_DIRECTORY));
	}
	
	public static IndexManager getInstance(){
		if(singletonInstance == null)
			try {
				singletonInstance = new IndexManager();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return singletonInstance;
	}
	
	public boolean knowsIdentifier(String identifier) throws IOException {
		IndexReader reader = DirectoryReader.open(directory);
		TopDocs rs = queryIdentifier(identifier, reader);
		reader.close();
		if(rs.totalHits>1) throw new IllegalStateException("The same identifier exists two times");
		return rs.totalHits == 1;
	}

	public Map<String, Integer> retrieveTermFrequencies(String identifier) throws IOException {
		IndexReader reader = DirectoryReader.open(directory);
		TopDocs rs = queryIdentifier(identifier,reader);
		return extractFrequencies(reader, rs.scoreDocs[0].doc);
	}
	
	public void addToIndex(String identifier, String content) throws IOException{
		addToIndex(identifier, null, content);
	}
	
	public void addToIndex(String identifier, String title, String content) throws IOException{
		if(knowsIdentifier(identifier)) throw new IllegalArgumentException("This identifier already exists");
		Analyzer analyzer = new EnglishAnalyzer(Version.LUCENE_42);
		IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_42, analyzer);
		IndexWriter writer = new IndexWriter(directory, iwc);
		Document doc = new Document();
		doc.add(new VecTextField(CONTENT, content, Store.YES));
		doc.add(new StringField(IDENTIFIER, identifier, Store.YES));
		if(title != null) doc.add(new StringField(TITLE, title, Store.YES));
		writer.addDocument(doc);
		writer.close();
	}

	private TopDocs queryIdentifier(String identifier, IndexReader reader) throws IOException {
		IndexSearcher searcher = new IndexSearcher(reader);
		Query query = new TermQuery(new Term(IDENTIFIER, identifier)); 
		TopDocs rs = searcher.search(query, 1);
		return rs;
	}
	
	private Map<String, Integer> extractFrequencies(IndexReader reader, int docId)
            throws IOException {
        Terms vector = reader.getTermVector(docId, CONTENT);
        TermsEnum termsEnum = null;
        termsEnum = vector.iterator(termsEnum);
        Map<String, Integer> frequencies = new HashMap<>();
        BytesRef text = null;
        while ((text = termsEnum.next()) != null) {
            String term = text.utf8ToString();
            int freq = (int) termsEnum.totalTermFreq();
            frequencies.put(term, freq);
        }
        return frequencies;
    }
	
	public String[] extractPublicationData(int id) throws IOException{
		IndexReader reader = DirectoryReader.open(directory);
		TopDocs rs = queryIdentifier(id+"",reader);
		int docID = rs.scoreDocs[0].doc;
		String[] result = new String[2];
		result[0] = reader.document(docID).getValues(TITLE)[0];
		result[1] = reader.document(docID).getValues(CONTENT)[0];
		return result;
		
	}

}
