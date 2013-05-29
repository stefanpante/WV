package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class LogWriter {

	public static final String FILE = "selectedPapers.txt";

	private static OutputStreamWriter fw = null;

	public static void writeLine(String line){
		try { 
			//file = new File(FILE);
			//if (!file.exists()) file.createNewFile();
			//fw = new FileWriter(file.getAbsoluteFile());
			//bw = new BufferedWriter(fw);
			fw = new OutputStreamWriter(new FileOutputStream(FILE, true),Charset.forName("UTF-8").newEncoder());
			fw.append(line);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}


