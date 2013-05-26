package visualisation.guielements;

import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

public class ShapeButton implements GUIElement{

	private PVector position;
	
	private PShape normal;
	private PShape clicked;
	
	private boolean isClicked = false;
	
	private PApplet gui;
	
	public ShapeButton(PShape normal, PShape clicked, PVector position, PApplet gui) {
		this.normal = normal;
		this.clicked = clicked;
		this.position = position;
		this.gui = gui;
	}

	public void draw() {
		if(!isClicked){
			gui.shape(normal, position.x, position.y);
		}else{
			gui.shape(clicked, position.x, position.y);
		}
	
	}

	public boolean hittable() {
		return true;
	}

	public boolean hit(int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getColor() {
		// TODO Auto-generated method stub
		return 0;
	}

	public PVector getTransformedPosition() {
		return position;
	}

	/**
	 * returns the position of the button.
	 */
	public PVector getPosition() {
		return position;
	}

}
