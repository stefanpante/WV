package tutorial;

import java.io.File;

import processing.core.PImage;
import visualisation.GUI;

public class Tutorial {

	GUI gui;
	long start;
	long delay = 6000;
	public boolean finished = false;
	int startNumber = 1;
	PImage img; 
	PImage left; 
	public Tutorial(GUI gui) {
		this.gui = gui;
		this.start = gui.millis();
		startNumber = 1;

		img = gui.loadImage(System.getProperty("user.dir") +"/tutorial/"  + startNumber + ".png");
		left = gui.loadImage(System.getProperty("user.dir") +"tutorial"+"Network.png");
	}

	public void draw(){
		if(!finished){
			if(gui.millis() - start >= delay){
				start = gui.millis();
				startNumber++;
				if(startNumber <= 6){
					img = gui.loadImage(System.getProperty("user.dir") + "/tutorial/" + startNumber + ".png");
				}
				else{
					finished = true;
				}
			}
			gui.image(left, 0, gui.displayHeight/2 -370);
			gui.image(img, gui.displayWidth/2 - 230, gui.displayHeight/2 -214);
		}
	}



}
