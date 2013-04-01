package lucene;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import org.apache.lucene.queryparser.surround.parser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import database.Authorship;
import database.SQLConnector;

public class IndexSearcher {
	
	public static void main(String[] args) throws ParseException, IOException, SQLException{
		SQLConnector.initialize("jdbc:mysql://localhost/visualisation", "root", "");
		SearchResult[] results = generalSearch("prolog bart demoen", 10);
		for(SearchResult result : results){
			System.out.println(result.title+","+result.year+","+result.citations+","+result.databaseID);
		}
	}
	
	public static SearchResult[] generalSearch(String query, int results) throws ParseException, IOException, SQLException{
		int author = searchAuthor(query);
		TopDocs rs;
		if(author >= 0){
			String name = IndexManager.getInstance().extractAuthorNameFromDB(author);
			query = removeFromQuery(name, query);
			System.out.println(query);
			ArrayList<Integer> publications = Authorship.findPublicationsBy(author);
			rs = IndexManager.getInstance().authorSearch(publications, query, results);
			
		}else{
			rs = IndexManager.getInstance().fuzzySearchField("title", query, results);
		}
		return extractSearchResults(rs);
	}
	
	private static String removeFromQuery(String term, String query) {
		for(String t : term.split(" ")){
			query = Pattern.compile(Pattern.quote(t), Pattern.CASE_INSENSITIVE).matcher(query).replaceAll("");
		}
		return query;
	}

	private static int searchAuthor(String query) throws ParseException{
		try{
			TopDocs authors = IndexManager.getInstance().multiSearchField("name", query, 1);
			if(authors.scoreDocs.length == 0) return -1;
			int docId = authors.scoreDocs[0].doc;
			int authorId = IndexManager.getInstance().extractAuthorID(docId);
			String name = IndexManager.getInstance().extractAuthorName(docId);
			String[] nameParts = name.split(" ");
			String[] actualParts = new String[]{nameParts[0], nameParts[nameParts.length-1]};
			boolean occurs = true;
			for(String namePart : actualParts){
				if(!Pattern.compile(Pattern.quote(namePart), Pattern.CASE_INSENSITIVE).matcher(query).find()){
					occurs = false;
				}
			}
			if(occurs) return authorId;
		}catch(IOException e){
			e.printStackTrace();
		}
		return -1;
	}

	private static SearchResult[] extractSearchResults(TopDocs docs)
			throws IOException {
		SearchResult[] result;
		result = new SearchResult[docs.scoreDocs.length];
		for(int i=0;i<docs.scoreDocs.length;i++){
			int docId = docs.scoreDocs[i].doc;
			String[] data = IndexManager.getInstance().extractPublicationDataFromDocID(docId);
			SearchResult searchResult = new SearchResult(data[0],data[3],data[2],data[1],new String[0],new String[0],Integer.parseInt(data[4]));
			result[i] = searchResult;
		}
		return result;
	}

}
