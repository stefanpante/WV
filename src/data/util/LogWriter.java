package data.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class LogWriter {

	public static final String FILE = "selectedPapers.txt";

	private static OutputStreamWriter fw = null;

	public static void writeLine(String line){
		try { 
			fw = new OutputStreamWriter(new FileOutputStream(FILE, true),Charset.forName("UTF-8").newEncoder());
			fw.append(line);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}


