package scraper;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import data.Author;

public class PublicatiesPersoneel {

	public static ArrayList<Pub> pubs;
	
	public static void getPublicationsByID() throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(new File("userid_name.csv")));
		
		String s = reader.readLine();
		String baseURL = "https://lirias.kuleuven.be/cv?u=";
		int i = 1;
		while(s != null){
			String[] row = s.split(";");
			loadURL(baseURL + row[0]);
			System.out.println(i);
			i++;
			s = reader.readLine();
		}
		
		reader.close();
		
		System.out.println("Finished");
		System.out.println("Number of papers: " + pubs.size());


	}

	/**
	 * @param s
	 * @return
	 * @throws Exception
	 */
	//TODO Create publications and authors
	public static void loadURL(String s) throws Exception{
		long time = System.currentTimeMillis();
		Document doc = Jsoup.connect(s).get();
		Elements items = doc.getElementsByAttributeValue("class", "item");
		
		for(Element item: items){
			Elements authors = item.getElementsByAttributeValue("name", "author");
			ArrayList<Author> as = new ArrayList<Author>();
			for(Element author: authors){
				String name = author.text();
				//TODO create array of authors
				Author a =new Author(name);
				as.add(a);
			}

			Elements date = item.getElementsByAttributeValue("name", "date");
			int publicationDate;
			try{
				publicationDate = Integer.parseInt(date.get(0).text());
			}
			catch(Exception e){ publicationDate = 0;}

			Elements titles = item.getElementsByAttributeValue("name", "title");
			if(titles.size() != 0){
				String title = titles.get(0).text();
	
				Pub publication = new Pub(title);
				publication.setPublicationDate(publicationDate);
				publication.setAuthors(as);
	
				pubs.add(publication);
				long time2 = System.currentTimeMillis();
				
				long timer = (time2 - time)/1000;
				System.out.println(timer);
			}
		}

	}

	public static void main(String args[]) throws Exception{
		pubs = new ArrayList<Pub>();
		getPublicationsByID();
		File papers = new File("Papers.txt");
		FileWriter fw = new FileWriter(papers.getAbsoluteFile());
		BufferedWriter bw =  new BufferedWriter(fw);
		//testLoadURL();
		
		for(Pub p: pubs){
			bw.write(p.getTitle());
			bw.newLine();
			bw.write(p.authorsToString());
			bw.newLine();
		}
		
		bw.close();
		
		
	}

	public static void testLoadURL() throws Exception{
		pubs = new ArrayList<Pub>();
		loadURL("https://lirias.kuleuven.be/cv?u=u0063907");
		int i = 1;
		for(Pub publication : pubs){
			System.out.println( i +". "+ publication.toString());
			i++;
		}
	}

}
