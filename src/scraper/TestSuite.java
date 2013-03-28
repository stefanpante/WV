package scraper;
import java.io.File;
import java.util.ArrayList;


public class TestSuite {
	
	public static void main(String[] args) throws Exception{
		while(true) extractRandomCitationTest();
	}
	
	public static void extractRandomCitationTest() throws Exception{
		try{
		String[] randomPaper = getRandomPaper();
		System.out.println("Paper URL: "+randomPaper[0]);
		System.out.println("Paper TTL: "+randomPaper[1]);
		String pdf = Scraper.savePDF(randomPaper[0], randomPaper[1], "randomPDF");
		long length = new File("C:\\Users\\Kobe\\Documents\\GitHub\\WV--Visualisation-of-networks\\"+pdf).length();
		if(pdf.indexOf("PDF")<0){
			System.out.println("Test suite: not a real pdf file");
		}else if(length>10000000){
			System.out.println("Test suite: pdf file too big");
		}else{
			ArrayList<Reference> references = PDFParser.extractReferencesFromPDF(randomPaper[0]);
			//for(Reference ref : references){
				System.out.println();
			//	System.out.println(ref.getReference());
			//	System.out.println(ref.getPdf());
			//}
		}
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Test suite: Network error. Sleeping one minute.");
			Thread.sleep(60000);
		}
	}
	
	public static String[] getRandomPaper() throws Exception{
		String noun = getRandomNoun();
		System.out.println("Test suite: Noun: "+noun);
		String papers = Scraper.getScholarPage(noun+" computer", 0);
		int index = papers.indexOf("<div class=\"gs_ri\">");
		if(index < 0) return getRandomPaper();
		papers = papers.substring(index);
		index = papers.indexOf(".pdf");
	//	System.out.println(index);
		if(index < 0) return getRandomPaper();
		else {
			String paper = papers.substring(0, index);
			int lastIndex = paper.lastIndexOf("<div class=\"gs_ri\">");
			//System.out.println(lastIndex);
			if(lastIndex < 0) return getRandomPaper();
			paper = paper.substring(lastIndex);
			String title = Scraper.parseTitle(paper);
			lastIndex = paper.lastIndexOf('"');
		//	System.out.println(lastIndex);
			if(lastIndex < 0) return getRandomPaper();
			paper = paper.substring(lastIndex+1)+".pdf";
			String[] res = {paper, title};
			return res;
		}
	}
	
	public static String getRandomNoun() throws Exception{
		String word = Scraper.loadURL("http://watchout4snakes.com/creativitytools/randomword/RandomWord.aspx");
		word = StringOperations.extractTextBetween(word, "class=\"randomWord\">", "</span>");
		return word;
	}
	
	
}
