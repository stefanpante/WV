package lucene;

import java.io.IOException;

import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class IndexSearcher {

	public static SearchResult[] searchTitle(String query, int results){
		TopDocs docs = null;
		SearchResult[] result = null;
		try{
			docs = IndexManager.getInstance().searchField("title", query, results);
			for(int i=0;i<docs.scoreDocs.length;i++){
				int docId = docs.scoreDocs[i].doc;
				float docScore = docs.scoreDocs[i].score;
				String[] data = IndexManager.getInstance().extractPublicationDataFromDocID(docId);
				
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return result;
	}

}
