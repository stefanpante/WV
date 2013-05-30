package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import visualisation.Application;
import visualisation.GUI;

public class HTTP {
	
	public static GUI gui;
	
	public static void main(String[] args) throws IOException{
		System.out.println(loadURL("http://academic.research.microsoft.com/json.svc/search?AppId=" +Application.APP_ID+"&PublicationID=777102&ResultObjects=Publication&ReferenceType=Reference&StartIdx=1&EndIdx=100"));
	}

	public static String loadURL(String url){
		URL _url;
		try {
			_url = new URL(url);
			InputStream i = _url.openStream();
			BufferedReader r = new BufferedReader(
	                new InputStreamReader(i, "UTF-8"));
			String totalText = "";
			String line = null;  
			while ((line = r.readLine()) != null)  
			{  
			   totalText += line;
			} 
			return totalText;
		} catch (IOException e) {
			gui.showWarning("Could not connect to Microsoft Academics Server. The server is experiencing downtime.");
			return "";
		}
	}

}
