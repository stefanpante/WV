package database;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class RelationFileConverter {
	
	private static String FILE = "data/venueship_relations.txt";
	
	public static void main(String[] args) throws SQLException {
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE), "UTF-8"));
			while ((sCurrentLine = br.readLine()) != null) {
				processLine(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private static void processLine(String line){
		String[] split = line.split(",");
		if(split.length>1){
			String rel = split[split.length-1];
			for(int i=0;i<split.length-1;i++){
				addRelation(rel, split[i]);
			}
		}
	}
	
	private static void addRelation(String from, String to){
		LogWriter.writeLine(from+","+to+"\n");
	}

}
