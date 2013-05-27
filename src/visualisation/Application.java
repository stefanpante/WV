package visualisation;

import processing.core.PApplet;
import javax.jnlp.*;

public class Application {
	
	public static boolean live = true;
	static BasicService basicService = null;

	public Application() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PApplet.main(new String[] { "--present","visualisation.GUI" });
	}

}
