package data;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class HTTP {
	
	public static void main(String[] args) throws IOException{
		System.out.println(loadURL("http://academic.research.microsoft.com/json.svc/search?AppId=406aea44-49a6-4753-ad34-3c4863221e5c&PublicationID=777102&ResultObjects=Publication&ReferenceType=Reference&StartIdx=1&EndIdx=100"));
	}

	public static String loadURL(String url) throws IOException{
		final URL _url = new URL(url);
		InputStream i = _url.openStream();
		Scanner scan = new Scanner(i);
		final String totalText = scan.nextLine();
		return totalText;
	}

}
