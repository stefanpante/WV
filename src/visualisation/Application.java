package visualisation;

import processing.core.PApplet;
import javax.jnlp.*;

public class Application {
	
	public static boolean live = true;
	public static boolean api = false;
	public static String APP_ID = "1a0f6afe-42fa-4048-8152-ef36d52f7c1e";
	public static String APP_ID2 = "406aea44-49a6-4753-ad34-3c4863221e5c";

	static BasicService basicService = null;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*
		try {
		      basicService = (BasicService)
		        ServiceManager.lookup("javax.jnlp.BasicService");
		    } catch (UnavailableServiceException e) {
		      System.err.println("Lookup failed: " + e);
		    }*/
		
		PApplet.main(new String[] { "--present","visualisation.GUI" });
	}

}
