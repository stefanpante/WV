package visualisation.guielements;

import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

public class ShapeButton implements GUIElement{

	private PVector position;
	
	private boolean visibility;
	private PShape normal;
	private PShape clicked;
	
	private boolean isNormal;
	
	private PApplet gui;
	
	public ShapeButton(PShape normal, PShape clicked, PVector position, PApplet gui) {
		this.normal = normal;
		this.clicked = clicked;
		this.position = position;
		this.isNormal = true;
		this.visibility = true;
		this.gui = gui;
	}

	public void draw() {
		if(isNormal){
			gui.shape(normal, position.x, position.y);
		}else{
			gui.shape(clicked, position.x, position.y);
		}
	
	}

	public boolean hittable() {
		return true;
	}

	public boolean hit(int mouseX, int mouseY) {
		if(mouseX > this.position.x && mouseX < (this.position.x + normal.getWidth())){
			if(mouseY > this.position.y && mouseY < (this.position.y + normal.getHeight())){
				return true;
			}
		}
		return false;
	}
	
	public boolean isVisible() {
		return visibility;
	}

	public int getColor() {
		return 0;
	}
	
	public void toggle(){
		if(isNormal) isNormal = false;
		else isNormal = true;
	}

	/**
	 * returns the normal position ( a buttons position isn't transformed )
	 */
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
