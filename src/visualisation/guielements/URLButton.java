package visualisation.guielements;

import java.io.IOException;

import processing.core.PApplet;

public class URLButton extends GUIButton{

	private String URL;
	public URLButton(String term, String URL, PApplet gui) {
		super(term,term, gui);
		this.URL = URL;
	}
	
	public void action(int mouseX, int mouseY){
		if(hit(mouseX,mouseY)){
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));
			} catch (IOException e) {
			}
		}
	}

}
