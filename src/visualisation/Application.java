package visualisation;

import processing.core.PApplet;
import javax.jnlp.*;

public class Application {
	
	public static boolean live = true;
	public static boolean api = false;
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
