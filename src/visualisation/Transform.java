package visualisation;

import processing.core.PVector;

public class Transform {

	public float translationX;
	public float translationY;
	public float rotation;
	public float scale;
	
	public GUI parent;
	
	public Transform(GUI parent) {
		this.translationX = 0;
		this.rotation = 0;
		this.translationY = 0;
		this.parent = parent;
	}
	
	public Transform(GUI parent, float translationX, float translationY){
		this(parent);
		this.translationX = translationX;
		this.translationY = translationY;
	}
	
	/**
	 * transforms the given vector into another vector with the transformations
	 * defined by this class.
	 * @param original
	 * @return
	 */
	public PVector transform(PVector original){
		
	
		float x = (original.x - parent.displayWidth/2 )*scale + translationX+ parent.displayWidth/2;
		float y = (original.y -parent.displayHeight/2)*scale + translationY + parent.displayHeight/2;
		
		return new PVector(x,y);
	}
	
	

}
