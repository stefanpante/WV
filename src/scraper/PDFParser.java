package scraper;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PDFParser {
	
	private static final int UPPERCASE_FREQUENCY_CUTOFF = 0;
	
	public static void main(String[] args) throws Exception {
		long currTime = System.currentTimeMillis();
		String data = readPDFFile("http://people.cs.uct.ac.za/~mnoordie/edwin/MyBib/2001-field.pdf");
		//String data = readPDFFile("http://web.cs.swarthmore.edu/~turnbull/cs97/f08/paper/sivic03.pdf");
		ArrayList<Reference> references = extractReferences(data);
		/*for(Reference r : references){
			System.out.println(r.getPdf());
		}*/
		ProxyListGenerator.stop();
		System.out.println("Finished. Total time: "+((System.currentTimeMillis()-currTime)/1000)+" seconds");
	}
	
	public static ArrayList<Reference> extractReferencesFromPDF(String pdfUrl) throws Exception{
		String data = readPDFFile(pdfUrl);
		ArrayList<Reference> references = extractReferences(data);
		return references;
	}
	
	public static String readPDFFile(String url) throws IOException{
		try{
			System.out.println("Parser: reading PDF from url "+url);
			URL _url = new URL(url);
			PDDocument pdf = PDDocument.load(_url);
			PDFTextStripper stripper = new PDFTextStripper();
			return stripper.getText(pdf);
		}catch(Exception e){
			System.out.println("Parser: Something went wrong when reading the PDF file");
			return "";
		}
	}
	
	public static ArrayList<Reference> extractReferences(String data) throws Exception{
		System.out.println("Parser: starting reference extraction from raw data");
		ArrayList<Reference> result = new ArrayList<Reference>();
		String oldData = "";
		while(oldData != data) {
			oldData  = data;
			data = findReferenceSection(data);
		}
		ArrayList<String> references = splitReferences(data);
		int counter = 1;
		int start_reference = 1; //GEBRUIK DEZE PARAMETER OM AAN TE GEVEN VANAF WELKE REFERENTIE JE WIL STARTEN (TEST PURPOSE)
		for(String reference : references) if(isReference(reference)) {
			if(++counter>start_reference){
				System.out.println("Parser: adding as reference -> "+reference);
				result.add(new Reference(reference));
			}
		}
		return result;
	}
	
	public static ArrayList<String> splitReferences(String data){
		ArrayList<String> references = splitReferences(data, 1);
		for(int i=0;i<references.size();i++){
			String elem_i = references.get(i);
			String replacement = " ";
			Pattern pattern = Pattern.compile("[-][\n\r]");
			Matcher matcher = pattern.matcher(elem_i);
			if(matcher.find()) replacement = "";
			references.set(i, references.get(i).replaceAll("[-]?[\n\r]", replacement));
		}
		return references; 
	}
	
	private static ArrayList<String> splitReferences(String data, int refCount){
		String originalData = data;
		ArrayList<String> references = new ArrayList<String>();
		
		String patternStr = "((\\n[\\W]*[0]*)("+refCount+")([\\W]))";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(data);
		int refBegin = -1;
		if(matcher.find()) refBegin = matcher.end();

		if(refBegin == -1) return references;		
		char patt = data.charAt(refBegin-1);
		data = data.substring(refBegin);
		
		patternStr = "((\\n[\\W]*[0]*)("+(refCount+1)+")([\\W]))";
		pattern = Pattern.compile(patternStr);
		matcher = pattern.matcher(data);
		int refEnd = -1;
		int refSplit = -1;
		if(matcher.find()){
			refEnd = matcher.end();
			refSplit  = matcher.start();
		}
		if(refEnd == -1){
			//LAATSTE TERUGVINDEN
			double averageLength = StringOperations.getAverageLineLength(data);
			String[] lines = data.split("\n");
			String lastRef = lines[0].substring(1);
			int i = 0;
			while(lines[i++].length() >= averageLength) lastRef += lines[i];
			
			references.add(lastRef);
			return references; 
		}
		char verify_patt = data.charAt(refEnd-1);
		data = data.substring(refSplit);
	
		if(refBegin == -1 || refEnd == -1) return references;
		if(patt == verify_patt) references.add(originalData.substring(refBegin+1, refBegin+refSplit-1));
		references.addAll(splitReferences(data,refCount+1));
		return references;
	}
	//TODO: improve!
	public static String findReferenceSection(String data){
		System.out.println("Parser: looking for reference section");
		String result = StringOperations.extractFrom(data, "[Rr][Ee][Ff][Ee][Rr][Ee][Nn][Cc][Ee][Ss]");
		if(result.equals(data)) System.out.println("Parser: no reference section found");
		else System.out.println("Parser: reference section found");
		return result;
	}
	
	//TODO: improve!
	public static boolean isReference(String data){
		System.out.println("Parser: checking as reference -> "+data);
		double uppercaseFrequency = StringOperations.getUppercaseFrequency(data);
		System.out.println("Parser: has uppercase frequency -> "+uppercaseFrequency);
		if(uppercaseFrequency >= UPPERCASE_FREQUENCY_CUTOFF){
			System.out.println("Parser: assuming data to be reference (by uppercase frequency)");
			return true;
		}
		System.out.println("Parser: rejecting data as reference");
		return false;
	}
	
	
}
