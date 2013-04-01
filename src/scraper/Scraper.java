package scraper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.Reader;
import java.lang.StringBuilder;

import database.Author;


public class Scraper{
	
	
	public static void main(String[] args) throws Exception{
	//	String[] res = parseScirus(loadScirus("Graph-based domain mapping for transfer learning in general games"));
		//System.out.println(res[0]);
		//System.out.println(res[1]);
		while(true) {
			long firstTime = System.currentTimeMillis(); 
			String result = loadAcademics("learning and teaching styles in engineering education");
			long totalTime = System.currentTimeMillis()-firstTime;
			if(!result.equals("")) System.out.println("succesfully loaded academics in "+totalTime/1000+" seconds");
			System.out.println(parseAcademics(result));
		}
		//System.out.println(getScholarPage("test", 0));
	}

	public static String[] getRawResultList(String data){
		return data.split("<div class=\"gs_ri\">");
	}
	
	/* Returns all papers written by a given author by doing a full scholar search */
	//TODO Middle name (SL Weibel)
	public static ArrayList<Pub> searchAuthor(String fname, String lname) throws Exception{
		String data = getScholarPage("author:"+'"'+fname+"+"+lname+'"', 0);
		int amountOfPapers = parsePaperAmount(data);
		ArrayList<Pub> result = new ArrayList<Pub>();
		for(int i=0;i<amountOfPapers;i+=100){
			if(i>0) data = getScholarPage("author:"+'"'+fname+"+"+lname+'"', i);
			String[] rawList = getRawResultList(data);
			for(String raw:rawList){
				Pub pub = new Pub(parseTitle(raw));
				pub.setCitedByURL(parseCitedBy(raw));
				String pdfURL = findPDF(parseVersions(raw));
				String localPDF = "";
				if(!pdfURL.equals("")){
					System.out.println("Titel: "+pub.getTitle());
					System.out.println("URL: "+pdfURL);
					System.out.println("Saving PDF...");
					localPDF = savePDF(pdfURL, pub.getTitle());
					if(!localPDF.equals("")){
						pub.setPdf(localPDF);
						result.add(pub);
					}else{
						System.out.println("Foute PDF link voor "+pub.getTitle());
					}
				}else{
					System.out.println("Geen PDF link gevonden voor "+pub.getTitle());
				}
			}
			result.remove(0);
		}
		return result;
	}

	public static String loadURL(String url) throws Exception{
		return loadURL(url, "", 0);
	}
	public static String loadURL(String url, String ip, int port) throws Exception{
		return loadURL(url, "", 0, 0);	
	}
		
	public static String loadURL(String url, String ip, int port, int timeout) throws Exception{
		
		URL url_m = new URL(url);
		Proxy proxy = null;
		if(ip.equals("") == false) proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
		boolean google = false;
		if(url.indexOf(".google.")> 0) google = true;
		
		String userAgent = "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1312.57 Safari/537.17";
		if(google) userAgent = GoogleRequestTracker.waitAndGetUserAgent();
		HttpURLConnection con = ip.equals("") == false ? (HttpURLConnection) url_m.openConnection(proxy) : (HttpURLConnection) url_m.openConnection();
		con.setRequestProperty("User-Agent", userAgent);
		//System.out.println(userAgent);
		con.setConnectTimeout(timeout);
		con.setReadTimeout(timeout);
		if(google) con.setRequestProperty("Cookie", "GSP=ID=762a112b5c765732:CF=4"); //maakt cookie aan voor scholar zodat bibtex references kunnen worden opgehaald
		
		Pattern p = Pattern.compile("text/html;\\s+charset=([^\\s]+)\\s*");
		try{
			Matcher m = p.matcher(con.getContentType());
			String charset = m.matches() ? m.group(1) : "ISO-8859-1";
			Reader r = new InputStreamReader(con.getInputStream(), charset);
			StringBuilder buf = new StringBuilder();
			while (true) {
				int ch = r.read();
				if (ch < 0)
					break;
				buf.append((char) ch);
			}
			con.disconnect();
			if(google) GoogleRequestTracker.requestFinished();
			return buf.toString();
		}catch(Exception e){
			System.out.println("Scraper: Failed to load web page");
			//e.printStackTrace();
			return "";
		}
	}

	/* Returns the result of given query (100 results starting from given start number) in Google Scholar in HTML form*/
	public static String getScholarPage(String query, int start) throws Exception{
		query = query.replace(" ","+");
		return loadURL("http://scholar.google.com/scholar?q="+query+"&btnG=&hl=nl&as_sdt=1%2C5&as_vis=1&start="+start+"&num=100");
	}
	
	public static String[] getScholarPageList(String query, int start) throws Exception{
		return getRawResultList(getScholarPage(query,start));
	}

	/* Finds all authors of the first article in the given string
	 * Not used at this time */
	public static String[] parseAuthors(String parseData){
		parseData = parseData.substring(parseData.indexOf("<div class=\"gs_a\">")+18);
		parseData = parseData.substring(0,parseData.indexOf(" - "));
		parseData = parseData.replaceAll("<[^>]*>", "");
		return parseData.split(", ");
	}

	/* Finds title of the first article in the given string */
	public static String parseTitle(String parseData){
		try{
		parseData = parseData.substring(parseData.indexOf("<a"));
		parseData = parseData.substring(0,parseData.indexOf("</a>"));
		parseData = parseData.replaceAll("<[^>]*>", "");
		}
		catch (Exception e){
			return "";
		}
		return parseData;
	}

	public static String parseCitedBy(String parseData){
		int citedByIndex = parseData.indexOf("Geciteerd door");
		if(citedByIndex == -1) return "";
		parseData = parseData.substring(0,citedByIndex-2);
		parseData = parseData.substring(parseData.lastIndexOf('"'));
		return parseData;
	}

	public static String parseCode(String parseData){
		parseData = parseData.substring(parseData.indexOf("<a href=\"/scholar?q=related:")+28);
		parseData = parseData.substring(0,parseData.indexOf(":"));
		return parseData;
	}

	public static String parseVersions(String parseData){
		int citedByIndex = parseData.indexOf("\">Alle ");
		if(citedByIndex == -1) return "";
		parseData = parseData.substring(0,citedByIndex);
		parseData = parseData.substring(parseData.lastIndexOf('"')+1);
		return parseData;
	}
	
	public static String findPDFInData(String data){
		int index = data.indexOf(".pdf");
		if(index == -1) return "";
		data = data.substring(0,index+4);
		data = data.substring(data.lastIndexOf('"')+1);
		return data;
	}

	public static String findPDF(String versionURL) throws Exception{
		if(versionURL.equals("")) return "";
		String parseData = loadURL("http://scholar.google.com"+versionURL);
		//System.out.println(parseData);
		return findPDFInData(parseData);
	}
	public static String savePDF(String URL, String title) throws Exception{
		return savePDF(URL, title, "");
	}
	
	public static String savePDF(String URL, String title, String folder) throws Exception{
		title = title.replaceAll("[^a-zA-Z]","");
		String path = folder.equals("") ? "PDF/"+title+".pdf" : "PDF/"+folder+"/"+title+".pdf";
		File f = new File(path);
		if(f.exists()) return path;
		URL url1 = new URL(URL);
		byte[] ba1 = new byte[1024];
		int baLength;
		FileOutputStream fos1 = new FileOutputStream(path);
		try {
			// Contacting the URL
			URLConnection urlConn = url1.openConnection();
			// Checking whether the URL contains a PDF
			if (!urlConn.getContentType().equalsIgnoreCase("application/pdf")) {
				System.out.println("Scraper: unable to read as PDF file ("+path+")");
			} else {
				try {
					// Read the PDF from the URL and save to a local file
					InputStream is1 = url1.openStream();
					while ((baLength = is1.read(ba1)) != -1) {
						fos1.write(ba1, 0, baLength);
					}
					fos1.flush();
					fos1.close();
					is1.close();

					return path;

				} catch (ConnectException ce) {
					System.out.println("Scraper: Fout bij verbinden met PDF [" + ce.getMessage() + "]");
				}
			}

		} catch (NullPointerException npe) {
			System.out.println("Scraper: Fout bij openen van PDF[" + npe.getMessage() + "]");
		}
		return "";
	}

	public static String getTex(String parseData) throws Exception{
		String code = parseCode(parseData);
		return loadURL("http://scholar.google.com/scholar.bib?q=info:"+code+":scholar.google.com/&output=citation&hl=nl&as_sdt=1,5&as_vis=1&ct=citation&cd=0");
	}

	public static ArrayList<Author> parseAuthorsFromTex(String parseData){
		//TODO
		return null;
	}

	public static int parsePaperAmount(String parseData){
		parseData = parseData.substring(parseData.indexOf("<div id=\"gs_ab_md\">"));
		parseData = parseData.substring(0,parseData.indexOf("</div>"));
		parseData = parseData.substring(0,parseData.indexOf(" resultaten"));	
		parseData = parseData.substring(parseData.indexOf("ngeveer ")+8);
		return Integer.parseInt(parseData);
	}
	
	
	public static String loadAcademics(String query){
		try {
			if(!ProxyListGenerator.hasStarted()) {
				System.out.println("Scraper: Starting new thread to generate proxies");
				Thread t = new Thread(new ProxyListGenerator());
				ProxyListGenerator.runningThread = t;
				t.start();
			}
			while(!ProxyListGenerator.foundIP()) {
				System.out.println("Scraper: No valid proxy ip found yet. Wating 10 seconds. (This can take a while)");
				Thread.sleep(10000);
			}
			IP ipObject = ProxyListGenerator.IPList.get(0);
			//IP ipObject = new IP("192.73.234.102", 3128, 0);
			query = StringOperations.removeNonLetters_whiteSpace(query);
			query = query.replace(" ","%20");
			System.out.println("Scraper: Loading academics. Query "+query+" with IP "+ipObject.getIp()+" and port "+ipObject.getPort());
			String result =  loadURL("http://academic.research.microsoft.com/Search?query="+query, ipObject.getIp(), ipObject.getPort());
			if(result.equals("")) {
				ProxyListGenerator.IPList.remove(0);
				return loadAcademics(query);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Scraper: something went wrong while scraping Academics:");
			return "";
		}
	}
	
	
	
	//Returns paper title and author of first academic search result
	public static String[] parseAcademics(String parseData){
		try{
			//String findOnPage = i >= 9 ? "ctl00_MainContent_PaperList_ctl"+(i+1)+"_Title" : "ctl00_MainContent_PaperList_ctl0"+(i+1)+"_Title";
			//System.out.println(findOnPage);
			//String result = StringOperations.extractTextBetween(parseData, findOnPage, "<div class=\"clear\">");
			int authorBeginIndex = parseData.indexOf("<a class=\"author-name-tooltip\"");
			int authorEndIndex = -1;
			String titleString = "";
			if(authorBeginIndex>-1){
				authorEndIndex = parseData.substring(authorBeginIndex).indexOf("</div>");
				titleString = parseData.substring(0, authorBeginIndex);
				int lastTitleIndex = titleString.lastIndexOf("<div class=\"title-download\">");
				if(lastTitleIndex > -1){
					titleString = titleString.substring(lastTitleIndex);
					titleString = StringOperations.extractBefore(titleString, "</a>");
				}else{
					titleString = "";
				}
				
			}
			String authorString = "";
			if(authorEndIndex>-1) authorString = parseData.substring(authorBeginIndex, authorBeginIndex+authorEndIndex);
			authorString = StringOperations.removeHTMLTags(authorString);
			authorString = StringOperations.removeWhiteSpace(authorString);
			titleString = StringOperations.removeHTMLTags(titleString);
			titleString = StringOperations.removeWhiteSpace(titleString);
			System.out.println("Scraper: academics parsed "+titleString+ "with authors "+authorString);
			String[] res = {titleString, authorString};
			return res;
		}catch(Exception e){
			System.out.println("Scraper: Nothing found in academics data");
			return new String[2];
		}
	}
	
	public static String loadScirus(String query){
		System.out.println("Scraper: loading Scirus page for query "+query);
		try {
			query = query.replace(" ","+");
			return loadURL("http://www.scirus.com/srsapp/search?q="+query+"&t=all&sort=0&drill=yes");
		} catch (Exception e) {
			System.out.println("Scraper: failed to load scirus page");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	//PARSED HET EERSTE RESULT EN RETURNED AUTHORS EN TITEL
	public static String[] parseScirus(String parseData){
		try{
			String split = "<font class=\"authorname\">";
			int endIndex = parseData.indexOf(split);
			String authorString = parseData.substring(endIndex+split.length());
			String titleString = parseData.substring(0,endIndex);
			endIndex = authorString.indexOf("</font>");
			authorString = authorString.substring(0, endIndex);
			int beginIndex = titleString.lastIndexOf("<a name=\"url\"");
			titleString = titleString.substring(beginIndex);
			beginIndex = titleString.indexOf(">");
			titleString = titleString.substring(beginIndex+1);
			endIndex = titleString.indexOf("</a>");
			titleString = titleString.substring(0, endIndex);
			titleString = titleString.replaceAll("<b>", "");
			titleString = titleString.replaceAll("</b>", "");
			String[] res = {titleString,authorString};
			return res;
		}catch(Exception e){
			System.out.println("Scraper: Nothing found in Scirus data");
			return new String[2];
		}
	}
	
}