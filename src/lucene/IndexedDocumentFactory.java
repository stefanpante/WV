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

import visualisation.subject.Field;

import data.Publication;

public class IndexedDocumentFactory {

	private static volatile IndexedDocumentFactory singletonInstance;
	private final IndexManager docFileManager;
	
	private IndexedDocumentFactory(){
		docFileManager = IndexManager.getInstance();
	}
	
	public static IndexedDocumentFactory getInstance(){
		if(singletonInstance == null) singletonInstance = new IndexedDocumentFactory();
		return singletonInstance;
	}
	
	public IndexedDocument fromPDF(final URI location, final String identifier) throws Exception{
		FileInputStream fi = new FileInputStream(new File(location));
		PDFParser parser = new PDFParser(fi);
		parser.parse();
		COSDocument cd = parser.getDocument();
		PDFTextStripper stripper = new PDFTextStripper();
		String text = stripper.getText(new PDDocument(cd));
		docFileManager.addToIndex(identifier, text);
		Map<String, Integer> termFrequencies = docFileManager.retrieveTermFrequencies(identifier);
		return new IndexedDocument(identifier, termFrequencies);
	}
	
	public IndexedDocument fromPublication(final Publication publication) throws Exception {
		if(IndexManager.getInstance().knowsIdentifier(publication.getID()+""))
			return new IndexedDocument(publication.getID()+"", IndexManager.getInstance().retrieveTermFrequencies(publication.getID()+""));
		
		String id = publication.getID()+"";
		String abstr = "";
		String title = "";
		
		for(Field field : publication.createFields()){
			if(field.getName().equals("abstract")){
				abstr = field.getContent();
			}else if(field.getName().equals("title")){
				title = field.getContent();
			}
		}
		docFileManager.addToIndex(id, title, abstr);
		Map<String, Integer> termFrequencies = docFileManager.retrieveTermFrequencies(id);
		return new IndexedDocument(id, termFrequencies);
	}
	
	public IndexedDocument fromIndentifier(final String identifier) throws IOException{
		if(!docFileManager.knowsIdentifier(identifier)) throw new IllegalArgumentException("The identifier has not yet been initialized. If this document does not yet exist, use the other constructor");
		return new IndexedDocument(identifier, docFileManager.retrieveTermFrequencies(identifier));
	}
}
