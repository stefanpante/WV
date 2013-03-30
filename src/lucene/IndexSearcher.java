package lucene;

import java.io.IOException;

import org.apache.lucene.queryparser.surround.parser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class IndexSearcher {
	
	public static void main(String[] args) throws ParseException{
		SearchResult[] results = searchTitle("Information retrieval", 10);
		for(SearchResult result : results){
			System.out.println(result.title+","+result.year+","+result.citations+","+result.databaseID);
		}
	}

	public static SearchResult[] searchTitle(String query, int maxResults) throws ParseException{
		TopDocs docs = null;
		SearchResult[] result = null;
		try{
			docs = IndexManager.getInstance().fuzzySearchField("title", query, maxResults);
			result = new SearchResult[docs.scoreDocs.length];
			for(int i=0;i<docs.scoreDocs.length;i++){
				int docId = docs.scoreDocs[i].doc;
				//float docScore = docs.scoreDocs[i].score;
				String[] data = IndexManager.getInstance().extractPublicationDataFromDocID(docId);
				SearchResult searchResult = new SearchResult(data[0],data[3],data[2],data[1],new String[0],new String[0],Integer.parseInt(data[4]));
				result[i] = searchResult;
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return result;
	}

}
