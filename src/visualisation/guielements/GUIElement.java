package visualisation.guielements;

import processing.core.PVector;

public interface GUIElement extends Drawable{
	
	/**
	 * draws the GUIElement on the screen.
	 */
	public abstract void draw();
	
	/**
	 * returns if the GUIElement is hittable
	 * @return
	 */
	public abstract boolean hittable();
	
	/**
	 * checks whether the gui element is hit by the mouse.
	 * @param mouseX	the x coordinate of the mouse cursor.
	 * @param mouseY	the y coordinate of the mouse cursor.
	 * @return
	 */
	public abstract boolean hit(int mouseX, int mouseY);
	
	/**
	 * returns whether the the GUIElement is visible.
	 * @return
	 */
	public abstract boolean isVisible();
	
	/** 
	 * returns the color of the GUIElement
	 * @return
	 */
	public abstract int getColor();
	
	/**
	 * returns the transformed position of the GUIElement
	 * returns the position in screen coordinates.
	 * @return
	 */
	public abstract PVector getTransformedPosition();
	
	/**
	 * returns the relative position of the GUIElement
	 * @return
	 */
	public abstract PVector getPosition();
}
