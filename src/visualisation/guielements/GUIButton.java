package visualisation.guielements;

import java.awt.Desktop;
import java.io.IOException;

import processing.core.PVector;
import visualisation.GUI;
import visualisation.graph.Pane;

public class GUIButton implements GUIElement{

	private String term;
	private String url;
	private GUI gui;
	
	private int width = 250;
	private int height = 30;
	private PVector position;
	
	public GUIButton(String term, String URL, GUI gui) {
		this.term = term;
		this.url = URL;
		this.gui = gui;
		this.position = new PVector();
	}

	public void draw() {
		gui.fill(gui.color(0,146,211));
		gui.stroke(gui.color(0), 50);
		gui.rect(position.x, position.y, width, height, Pane.CORNER_RADIUS /2, Pane.CORNER_RADIUS /2, Pane.CORNER_RADIUS/2, Pane.CORNER_RADIUS/2);
		gui.textAlign(GUI.CENTER, GUI.CENTER);
		gui.noStroke();
		gui.fill(gui.color(255));
		gui.textSize(12);
		gui.text(term, position.x, position.y, width, height);
		
	}

	public void rollover(){
		gui.fill(gui.color(0, 60, 255));
		gui.stroke(gui.color(0), 50);
		gui.rect(position.x, position.y, width, height, Pane.CORNER_RADIUS /2, Pane.CORNER_RADIUS /2, Pane.CORNER_RADIUS/2, Pane.CORNER_RADIUS/2);
		gui.textAlign(GUI.CENTER, GUI.CENTER);
		gui.noStroke();
		gui.fill(gui.color(255));
		gui.textSize(12);
		gui.text(term, position.x, position.y, width, height);
	}
	
	public boolean hittable() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean hit(int mouseX, int mouseY) {
		if(mouseX >= position.x && mouseX <= position.x + width){
			if(mouseY >= position.y && mouseY <= position.y + height){
				return true;
			}
		}
		
		return false;
	}
	
	public void action(int mouseX, int mouseY){
		if(hit(mouseX,mouseY)){
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
			} catch (IOException e) {
				System.out.println("Cannot open the webbrowser.");
			}
		}
	}

	public boolean isVisible() {
		return true;
	}

	public void setPosition(float x, float y){
		this.position.x = x;
		this.position.y = y;
	}
	public int getColor() {
		// TODO Auto-generated method stub
		return 0;
	}

	public PVector getTransformedPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	public PVector getPosition() {
		return position;
	}



}
