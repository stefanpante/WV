package visualisation.guielements;

import processing.core.PApplet;
import processing.core.PVector;
import visualisation.GUI;
import visualisation.graph.Pane;

public class GUIButton implements GUIElement{

	private String term;
	private String alternativeTerm;
	private boolean activated;
	private PApplet gui;
	
	private int width = 250;
	private int height = 30;
	private PVector position;
	
	public GUIButton(String term, String alternativeTerm, PApplet gui) {
		this.term = term;
		this.alternativeTerm = alternativeTerm;
		this.gui = gui;
		this.activated = false;
		this.position = new PVector();
	}
	
	public void toggleActive(){
		if(activated) activated = false;
		else activated = true;
	}

	public void draw() {
		gui.fill(gui.color(0,146,211));
		gui.stroke(gui.color(0), 50);
		gui.rect(position.x, position.y, width, height, Pane.CORNER_RADIUS /2, Pane.CORNER_RADIUS /2, Pane.CORNER_RADIUS/2, Pane.CORNER_RADIUS/2);
		gui.textAlign(GUI.CENTER, GUI.CENTER);
		gui.noStroke();
		gui.fill(gui.color(255));
		gui.textSize(12);
		if(!activated){
			gui.text(term, position.x, position.y, width, height);
		}
		else{
			gui.text(alternativeTerm, position.x, position.y, width, height);
		}
		
	}

	public void rollover(){
		gui.fill(gui.color(0, 60, 255));
		gui.stroke(gui.color(0), 50);
		gui.rect(position.x, position.y, width, height, Pane.CORNER_RADIUS /2, Pane.CORNER_RADIUS /2, Pane.CORNER_RADIUS/2, Pane.CORNER_RADIUS/2);
		gui.textAlign(GUI.CENTER, GUI.CENTER);
		gui.noStroke();
		gui.fill(gui.color(255));
		gui.textSize(12);
		if(!activated){
			gui.text(term, position.x, position.y, width, height);
		}
		else{
			gui.text(alternativeTerm, position.x, position.y, width, height);
		}
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

	@Override
	public boolean isVisible() {
		return true;
	}

	public void setPosition(float x, float y){
		this.position.x = x;
		this.position.y = y;
	}
	
	@Override
	public int getColor() {
		return 0;
	}
	
	@Override
	public PVector getPosition() {
		return position;
	}

	@Override
	public PVector getTransformedPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setWidth(int width) {
		this.width = width;
		
	}
	
	public boolean getActive(){
		return this.activated;
	}

	public void setActive(boolean b) {
		this.activated = b;
		
	}



}
