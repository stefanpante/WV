package database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {

	public static final String FILE = "data/dblog.txt";
	
	public static void writeLine(String line){
		try { 
			File file = new File(FILE);
 			if (!file.exists()) file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(line);
			bw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
