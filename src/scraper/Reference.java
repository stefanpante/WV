package scraper;
import java.util.Arrays;
import java.util.Locale;


public class Reference {
	
	private static final double LEVENSHTEIN_CUTOFF = 0.85; 
	private static final double AUTHOR_PERCENTAGE_CUTOFF = 0.5; //BOTH CONSTANTS PREVENT FALSE POSITIVES -> HIGHER NUMBER = LESS FALSE POSITIVES
	private static final double NUMBER_FREQUENCY_CUTOFF = 0.5; //BOTH CONSTANTS PREVENT FALSE POSITIVES -> HIGHER NUMBER = LESS FALSE POSITIVES


	private String pdf = "";
	private String url = "";
	private String reference;
	
	public static void main(String[] args) throws Exception{
		new Reference("Verbert, K., Duval, E.: Alocom: a generic content model for learning objects. International Journal on Digital Libraries 9(1), 41–63 (2008)");
	}
	
	public Reference(String reference) throws Exception{
		System.out.println("Reference: verify reference: "+reference);
		this.reference = reference;
		findPdf();
	}
	
	public String getPdf() {
		return pdf;
	}
	
	public String getUrl(){
		return url;
	}
	
	public boolean hasPdf(){
		return pdf.equals("");
	}
	
	public boolean hasUrl(){
		return url.equals("");
	}

	public String getReference() {
		return reference;
	}
	
	@SuppressWarnings("unchecked")
	public void findPdf() throws Exception{
		reference = reference.replaceAll(":", " ");
		String[] delim = reference.split("([,.])");
		String[] placeHolder = new String[delim.length];
		int j = 0;
		for(int i=0;i<delim.length;i++){
			delim[i] = StringOperations.removeWhiteSpace(delim[i]);
			delim[i] = delim[i].replaceAll("\"", ""); //No quotes in search string
			//ELK STUK MOET DE CONTROLE DOORSTAAN OF HET DE MOEITE IS OP TE ZOEKEN
			if(couldBeTitle(delim[i])) placeHolder[j++] = delim[i];
		}
		delim = new String[j];
		for(int i=0;i<j;i++){
			delim[i] = placeHolder[i];
		}
		Arrays.sort(delim, new StringLengthComparator());
		pdf = searchPdf(delim);
	}
	
	//takes a string and checks if it is possible for that string to be a title
	//avoids redundant querying
	private boolean couldBeTitle(String title){
		System.out.println("Reference: checking if valid title -> "+title);
		if(title.split(" ").length == 1) {
			System.out.println("Reference: reject as possible title (just one word)");
			return false;
		}
		if(StringOperations.getNumberFrequency(title)>=NUMBER_FREQUENCY_CUTOFF){
			System.out.println("Reference: reject as possible title (too many numbers)");
			return false;
		}
		System.out.println("Reference: accept as possible title");
		return true;
	}
	
	private String searchPdf(String[] data) throws Exception{
		return searchPdf(data, data, 0);
	}
	
	public String searchPdf(String[] backupData, String[] data, int test) throws Exception{
		if(data.length == 0) return "Reference: Reject as reference (every part checked)";
		String assumedTitle = data[0];
		if(assumedTitle.indexOf(" ")<-1) return "Reference: Reject as reference (no more spaces)";
		
		String result = "";
		if(test == 0) result = tryScirus(assumedTitle);
		else if(test == 1) result = tryAcademics(assumedTitle);
		else if(test == 2) result = tryScholar(assumedTitle);
		if(result.equals("")){
			if(data.length == 1){
				if(test == 0) {
					searchPdf(backupData, backupData, 1); //ACADEMICS POGING
				} else if(test == 1) {
					class ScholarVerification implements Runnable {
				        Reference ref;
				        String[] data;
				        ScholarVerification(Reference ref, String[] backupData) { 
				        	this.ref = ref;
				        	this.data = backupData;
				        }
				        public void run() {
				            try {
								ref.searchPdf(data, data, 2); //SCHOLAR POGING IN APARTE THREAD
								ThreadTracker.removeScholarThread(Thread.currentThread());
							} catch (Exception e) {
								System.out.println("Reference: Something went wrong in scholar verification process");
								e.printStackTrace();
							}
				        }
				    }
				    Thread t = new Thread(new ScholarVerification(this, backupData));
				    ThreadTracker.addScholarThread(t);
				    t.start();
				    System.out.println("Reference: Started new scholar thread. Currently running "+ThreadTracker.amountOfScholarThreads()+" scholar threads");
					//searchPdf(backupData, backupData, 2); 
				}
				else if(test == 2) return "Reference: Reference not found (all tests handled)";
			}
			String[] newData = new String[data.length-1];
			for(int i=1;i<data.length;i++) newData[i-1] = data[i];
			return searchPdf(backupData, newData, test);
		}else{
			return result;
		}
	}
	
	public static double getAuthorPercentage(String[] authors, String reference){
		int matchingAuthors = 0;
		//authors[authors.length-1].indexOf("etal") > -1 && authors[authors.length-1].length() <= 6
		for(int i=0;i<authors.length;i++){
				System.out.println("Author: checking "+authors[i]);
				authors[i] = StringOperations.removeWhiteSpace(authors[i]);
				authors[i] = StringOperations.removeHTMLTags(authors[i]);
			//	System.out.println("searching for "+googledAuthors[i]);
				authors[i].replaceAll("&hellip;", "");
				String[] split = authors[i].split(" ");
				String lastName = StringOperations.deAccent(split[split.length-1].toLowerCase(Locale.ENGLISH));
				lastName = StringOperations.removeNonLetters(lastName);
				authors[i] = lastName;
			//	System.out.println(lastName);
				//String reference = this.reference.replaceAll("&hellip;", "");
				reference = StringOperations.deAccent(reference).toLowerCase(Locale.ENGLISH);
				reference = StringOperations.removeNonLetters(reference);
			//	System.out.println(reference);
				if(reference.indexOf(lastName)>-1) {
					matchingAuthors++; 
			//		System.out.println("found "+lastName);
				}
			}
			System.out.println("Reference: checked following author list in "+reference);
			System.out.print("Reference: list: ");
			for(String author : authors) System.out.print(author+" - ");
			double result = 0;
			if(reference.indexOf("et al.") > -1 || reference.indexOf("Et al.") > -1){ //et al. op het einde van de referentie
				System.out.println("Reference: et al gevonden");
				result = matchingAuthors > 0 ? 1 : 0;
			}else{
				result = (double) matchingAuthors/authors.length;
			}
			System.out.println("Reference: "+result*100+" percent of authors found");
			return result;
	}
	
	public String tryScirus(String assumedTitle){
		/**SCIRUS ATTEMPT**/
		System.out.println("Reference: Polling Scirus for "+assumedTitle);
		String[] scirus = Scraper.parseScirus(Scraper.loadScirus(assumedTitle));
		//System.out.println("Found title: "+scirus[0]);
		//System.out.println("Found authors: "+scirus[1]);

		double lev = 0;
		if(scirus[0] != null  && scirus[0].equals("")){
			scirus[0] = scirus[0].replaceAll("CiteSeerX — ", "");
			lev = Levenshtein.substring_compare(scirus[0], assumedTitle);
		}
		System.out.println("Reference: levenshtein value of "+lev+ " (scirus)");
		if(lev>LEVENSHTEIN_CUTOFF){
			System.out.println("Reference: Matching title found on Scirus");
			String[] authors = scirus[1].split("/");
			for(int i=0;i<authors.length;i++){
				int endIndex = authors[i].indexOf(",");
				if(endIndex>-1)
					authors[i] = authors[i].substring(0,endIndex);
				authors[i].replaceAll(" ","");
				//System.out.println(authors[i]);
			}
			double percentageFound = getAuthorPercentage(authors, reference);
			//System.out.println("percentage: "+percentageFound);
			if(percentageFound >= AUTHOR_PERCENTAGE_CUTOFF){
			//System.out.println(matchingAuthors+" of "+googledAuthors.length+" authors have been found in the reference for paper: "+googledTitle);
				System.out.println("Result: Accepting reference: "+scirus[0]+ " (scirus)");
				return scirus[0];
			}
		}
		return "";
	}
	

	public String tryAcademics(String assumedTitle){
		/**ACADEMICS ATTEMPT**/
		System.out.println("Reference: Polling Academics for "+assumedTitle);
		//System.out.println("Trying academics for "+assumedTitle);
		String[] scirus = Scraper.parseAcademics(Scraper.loadAcademics(assumedTitle));
		//System.out.println("Found title: "+scirus[0]);
		//System.out.println("Found authors: "+scirus[1]);
		double lev = 0;
		if(scirus[0] != null && !scirus[0].equals("")) lev = Levenshtein.substring_compare(scirus[0], assumedTitle);
		System.out.println("Reference: levenshtein value of "+lev+ " (Academics)");
		if(lev>LEVENSHTEIN_CUTOFF){
			System.out.println("Reference: Matching title found on Academics");
			String[] authors = scirus[1].split(",");
			for(int i=0;i<authors.length;i++){
				String[] split = authors[i].split(" ");
				authors[i] = split[split.length-1];
				//System.out.println(authors[i]);
			}
			double percentageFound = getAuthorPercentage(authors, reference);
			//System.out.println("percentage: "+percentageFound);
			if(percentageFound >= AUTHOR_PERCENTAGE_CUTOFF){
			//System.out.println(matchingAuthors+" of "+googledAuthors.length+" authors have been found in the reference for paper: "+googledTitle);
				System.out.println("Result: Accepting reference: "+scirus[0]+ " (academics)");
				return scirus[0];
			}
		}
		return "";
	}
	
	public String tryScholar(String assumedTitle) throws Exception{
		/**SCHOLAR ATTEMPT**/
		System.out.println("Reference: Polling Scholar for "+assumedTitle);
		String assumedTitle_replace = assumedTitle.replaceAll(" ", "%20");
		String searchResult = Scraper.loadURL("http://scholar.google.com/scholar?as_vis=1&q="+assumedTitle_replace+"&hl=nl&as_sdt=1,5");
		/*BEDOELDE U LINK VOLGEN*/
		String bedoelde = "Bedoelde u: </span><a href=\"";
		int bedoeldeIndex = searchResult.indexOf(bedoelde);
		if(bedoeldeIndex >= 0){
			/*String suggestion = searchResult.substring(bedoeldeIndex+bedoelde.length());
			suggestion = suggestion.substring(0,suggestion.indexOf('"'));
			*/
			String suggestion = StringOperations.extractTextBetween(searchResult, bedoelde, "\"");
			suggestion = suggestion.replaceAll("amp;", "");
			//System.out.println("Checking again, loading "+"http://scholar.google.com"+suggestion);
			searchResult = Scraper.loadURL("http://scholar.google.com"+suggestion);
		}
		/*--*/
		String[] rawList = searchResult.split("<div class=\"gs_ri\">");
		if(rawList.length>1) {
			String googledTitle = Scraper.parseTitle(rawList[1]);
			double lev = Levenshtein.substring_compare(googledTitle, assumedTitle);
			System.out.println("Reference: levenshtein value of "+lev+ " (scholar)");
			if(lev>LEVENSHTEIN_CUTOFF){
				System.out.println("Reference: Matching title found on Scholar");
				/*AUTHOR VERIFICATION*/
				String[] googledAuthors = Scraper.parseAuthors(rawList[1]);
				//System.out.println("Investigating reference "+this.reference);
				double percentageFound = getAuthorPercentage(googledAuthors, reference);
				if(percentageFound >= AUTHOR_PERCENTAGE_CUTOFF){
				//System.out.println(matchingAuthors+" of "+googledAuthors.length+" authors have been found in the reference for paper: "+googledTitle);
					System.out.println("Result: Accepting reference: "+googledTitle+" (scholar)");
					return googledTitle;
				}
			}
		}
		return "";
	}
}
