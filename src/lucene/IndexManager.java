package lucene;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
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
import org.apache.lucene.queryparser.surround.parser.ParseException;
import org.apache.lucene.queryparser.surround.parser.QueryParser;
import org.apache.lucene.queryparser.surround.query.BasicQueryFactory;
import org.apache.lucene.queryparser.surround.query.SrndQuery;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Explanation;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MultiTermQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.Version;

import data.SQLConnector;

public class IndexManager {
	
	private static volatile IndexManager singletonInstance;
	
	private static final String PUBLICATION_DIRECTORY = "data/publicationIndexTermVectors";
	private static final String AUTHOR_DIRECTORY = "data/authorIndex";

    private static final String CONTENT = "abstract";
    private static final String IDENTIFIER = "id";
    private static final String TITLE = "title";
    private static final String YEAR = "year";
    private static final String CITED = "cited";
    private static final String ID = "id";
	
	private final Directory publication_directory;
	private final Directory author_directory;

	private IndexManager() throws IOException {
		publication_directory = new SimpleFSDirectory(new File(PUBLICATION_DIRECTORY));
		author_directory = new SimpleFSDirectory(new File(AUTHOR_DIRECTORY));
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
		IndexReader reader = getDirectoryReader();
		TopDocs rs = queryIdentifier(identifier);
		reader.close();
		if(rs.totalHits>1) throw new IllegalStateException("The same identifier exists two times");
		return rs.totalHits == 1;
	}
	
	private IndexReader getDirectoryReader(Directory directory) throws IOException{
		return DirectoryReader.open(directory);
	}

	private IndexReader getDirectoryReader() throws IOException {
		return getDirectoryReader(publication_directory);
	}

	public Map<String, Integer> retrieveTermFrequencies(String identifier) throws IOException {
		IndexReader reader = getDirectoryReader();
		TopDocs rs = queryIdentifier(identifier);
		return extractFrequencies(reader, rs.scoreDocs[0].doc);
	}
	
	public void addToIndex(String identifier, String content) throws Exception{
		addToIndex(identifier, null, content);
	}
	
	public void addToIndex(String identifier, String title, String content) throws Exception{
		if(true) throw new Exception("Can't add to index, it is locked.");
		if(knowsIdentifier(identifier)) throw new IllegalArgumentException("This identifier already exists");
		//negeert stopwoorden
		Analyzer analyzer = new WhitespaceAnalyzer(Version.LUCENE_42);
		IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_42, analyzer);
		IndexWriter writer = new IndexWriter(publication_directory, iwc);
		Document doc = new Document();
		doc.add(new VecTextField(CONTENT, content, Store.YES));
		doc.add(new StringField(IDENTIFIER, identifier, Store.YES));
		if(title != null) doc.add(new StringField(TITLE, title, Store.YES));
		writer.addDocument(doc);
		writer.close();
	}
	
	private TopDocs queryIdentifier(String identifier) throws IOException {
		return searchField(IDENTIFIER, identifier, 1);
	}

	private IndexSearcher getDirectorySearcher(IndexReader reader) {
		IndexSearcher searcher = new IndexSearcher(reader);
		return searcher;
	}
	
	private IndexSearcher getDirectorySearcher() throws IOException{
		return getDirectorySearcher(getDirectoryReader());
	}
	
	public TopDocs searchField(String fieldName, String query, int results) throws IOException{
		IndexSearcher searcher = getDirectorySearcher();
		Query q = new TermQuery(new Term(fieldName, query));
		TopDocs rs = searcher.search(q, results);
		return rs;
	}
	
	public TopDocs multiSearchField(String fieldName, String query, int results) throws IOException, ParseException{
		IndexSearcher searcher;
		if(fieldName.equals("name")){
			searcher = getDirectorySearcher(getDirectoryReader(author_directory));
		}else{
			searcher = getDirectorySearcher();
		}
		BooleanQuery booleanQuery = buildTermQuery(fieldName, query);
		TopDocs rs = searcher.search(booleanQuery, results);
		return rs;
	}
	
	public TopDocs fuzzySearchField(String fieldName, String query, int results) throws IOException, ParseException{
		IndexSearcher searcher;
		if(fieldName.equals("name")){
			searcher = getDirectorySearcher(getDirectoryReader(author_directory));
		}else{
			searcher = getDirectorySearcher();
		}
		BooleanQuery booleanQuery = buildFuzzyQuery(fieldName, query);
		TopDocs rs = searcher.search(booleanQuery, results);
		return rs;
	}
	
	private BooleanQuery buildTermQuery(String fieldName, String query) {
		return buildBooleanQuery(fieldName, query, false);
	}

	private BooleanQuery buildFuzzyQuery(String fieldName, String query) {
		return buildBooleanQuery(fieldName, query, true);
	}

	private BooleanQuery buildBooleanQuery(String fieldName, String query, boolean fuzzy) {
		query = query.toLowerCase();
		BooleanQuery booleanQuery = new BooleanQuery();
		for(String s : query.split(" ")){
			Query q;
			Term t = new Term(fieldName, s);
			if(fuzzy) q = new FuzzyQuery(t);
			else q = new TermQuery(t);
			booleanQuery.add(q, BooleanClause.Occur.SHOULD);
		}
		return booleanQuery;
	}

	
	private Map<String, Integer> extractFrequencies(IndexReader reader, int docId)
            throws IOException {
        Terms vector = reader.getTermVector(docId, CONTENT);
        TermsEnum termsEnum = null;
        termsEnum = vector.iterator(termsEnum);
        Map<String, Integer> frequencies = new HashMap<String, Integer>();
        BytesRef text = null;
        while ((text = termsEnum.next()) != null) {
            String term = text.utf8ToString();
            int freq = (int) termsEnum.totalTermFreq();
            frequencies.put(term, freq);
        }
        return frequencies;
    }
	
	public String[] extractPublicationData(int databaseId) throws IOException{
		TopDocs rs = queryIdentifier(databaseId+"");
		int docID = rs.scoreDocs[0].doc;
		return extractPublicationDataFromDocID(docID);
	}
	
	public String[] extractPublicationDataFromDocID(int docId) throws IOException{
		IndexReader reader = getDirectoryReader();
		String[] result = new String[5];
		result[0] = reader.document(docId).getValues(TITLE)[0];
		result[1] = reader.document(docId).getValues(YEAR)[0];
		result[2] = reader.document(docId).getValues(CITED)[0];
		result[3] = (reader.document(docId).getValues(CONTENT).length > 0 ? reader.document(docId).getValues(CONTENT)[0] : "");
		result[4] = reader.document(docId).getValues(ID)[0];
		return result;
		
	}

	public String extractAuthorName(int authorId) throws IOException {
		IndexReader reader = getDirectoryReader(author_directory);
		return reader.document(authorId).getValues("name")[0];
	}
	
	public String extractAuthorNameFromDB(int author) throws SQLException {
		ResultSet res = SQLConnector.select("name", "author", "id", ""+author);
		res.next();
		return res.getString(1);
		
	}

	public int extractAuthorID(int authorId) throws IOException {
		IndexReader reader = getDirectoryReader(author_directory);
		return Integer.parseInt(reader.document(authorId).getValues("id")[0]);
	}

	public TopDocs combinedSearch(
			ArrayList<Integer> publications, String query, int results) throws IOException {
		IndexSearcher searcher = getDirectorySearcher();
		HashMap<Integer, Float> result = new HashMap<Integer, Float>();
		
		
		BooleanQuery outerQuery = new BooleanQuery();
		for(Integer index : publications){
			outerQuery.add(new TermQuery(new Term("id", index+"")), Occur.SHOULD);			
		}
		if(query.replaceAll(" ", "").length() > 0){
			BooleanQuery innerQuery = buildFuzzyQuery("title", query);
			outerQuery.add(innerQuery, Occur.MUST);		
		}
		
		results = publications.size()>results ? results : publications.size();
		TopDocs rs = searcher.search(outerQuery, results);
		
		
		return rs;
	}

	


}
