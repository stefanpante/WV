package lucene;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Map;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class DocumentFactory {

	private static volatile DocumentFactory singletonInstance;
	private final TermFrequencyManager docFileManager;
	
	private DocumentFactory(){
		docFileManager = TermFrequencyManager.getInstance();
	}
	
	public static DocumentFactory getInstance(){
		if(singletonInstance == null) singletonInstance = new DocumentFactory();
		return singletonInstance;
	}
	
	public Document fromPDF(final URI location, final String identifier) throws IOException{
		FileInputStream fi = new FileInputStream(new File(location));
		PDFParser parser = new PDFParser(fi);
		parser.parse();
		COSDocument cd = parser.getDocument();
		PDFTextStripper stripper = new PDFTextStripper();
		String text = stripper.getText(new PDDocument(cd));
		docFileManager.calculateTermFrequencies(identifier, text);
		Map<String, Integer> termFrequencies = docFileManager.retrieveTermFrequencies(identifier);
		return new Document(identifier, termFrequencies);
	}
	
	public Document fromDatabase(final int id) {
		
		return null;
	}
	
	public Document fromIndentifier(final String identifier) throws IOException{
		if(!docFileManager.knowsIdentifier(identifier)) throw new IllegalArgumentException("The identifier has not yet been initialized. If this document does not yet exist, use the other constructor");
		return new Document(identifier, docFileManager.retrieveTermFrequencies(identifier));
	}
}
