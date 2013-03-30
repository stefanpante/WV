package visualisation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import controlP5.Bang;
import controlP5.CColor;
import controlP5.ControlP5;
import controlP5.Slider;
import controlP5.Textfield;

import processing.core.*;
import visualisation.graph.CircularLayout;
import visualisation.graph.Connection;
import visualisation.graph.Graph;
import visualisation.graph.GraphFactory;
import visualisation.graph.GraphLayout;
import visualisation.graph.Node;
import visualisation.graph.RegularForceBasedLayout;

public class GUI extends PApplet{

	private static final long serialVersionUID = 1L;
	/**
	 * The Graph that needs to be drawn
	 */
	private Graph graph;

	/**
	 * Controller used for input.
	 */
	private ControlP5 inputController;

	/**
	 * Boolean which controls the animation of the graph
	 */
	private boolean pause = false;

	/**
	 * The default GraphLayout
	 */

	private GraphLayout graphLayout =  new RegularForceBasedLayout();

	/**
	 * Used for panning and zooming.
	 */
	public Transform transform;

	/**
	 * Setup sets up the program for running.
	 * 	-inits GUI
	 *   inits GRAPH
	 */
	public void setup(){

		transform = new Transform(this);
		
		// sets the size of the window
		size(displayWidth - 50,displayHeight -120);

		// Sets the frameRate for the animation
		frameRate(60);

		// Create a graph instance to display
		try {
			graph = GraphFactory.getInstance().fromDatabaseID(4, 1, this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// Initializes the GUI
		setupGUI();

		// initializes the graph
		initGraph();
	}

	/**
	 * Initializes the graph.
	 */
	private void initGraph(){
		// Gives the parentNode its default appearance
		initParentNode();

		// Sets the default graphLayout for the graph
		graph.setGraphLayout(graphLayout);
		//graph.setGraphLayout(new CircularLayout(graph));
	}

	/**
	 * Handles mouse events.
	 */
	public void mousePressed(){
		if (mouseEvent.getClickCount()==2){
			graph.expand(mouseX, mouseY);
		}
		if(mouseEvent.getClickCount() ==1){
			//graph.mouseHit(mouseX, mouseY);
		}
		if(!locked && (mouseX < displayWidth -150)){
			xOffset = mouseX - transform.translationX;
			yOffset = mouseY - transform.translationY;
			locked = true;
		}
	}

	public void mouseReleased(){
		locked = false;
	}

	public void mouseDragged(){
		if(locked){
			transform.translationX = (mouseX - xOffset);
			transform.translationY = (mouseY - yOffset);
		}
	}

	private boolean locked = false;
	private float xOffset;
	private float yOffset;

	/**
	 * Initializes the parent node of the graph.
	 */
	private void initParentNode(){

		// Sets the diameter of the parent node to 50 pixels, replace with static method?
		//graph.getParentNode().setDiameter(50);

		// Sets the color of the parent node to red.
		graph.getParentNode().setColor(color(255,0,0));
	}



	/**
	 * Setups the gui for this application
	 */
	private void setupGUI(){

		
		inputController = new ControlP5(this);
		
		Textfield text = inputController.addTextfield("Type here to search...");
		CColor color = new CColor(color(0, 146, 211), color(255),color(0, 60, 255),color(0, 146, 211),color(0, 146, 211) );
		text.setColor(color);
		text.registerTooltip("Type here to search for a paper");
		fill(0);
		int width = displayWidth/2;
		text.setWidth(width);
		text.setHeight(30);
		text.setPosition(displayWidth/2 - width/2, 15);
		Bang pause = inputController.addBang("pause");
		Bang reset = inputController.addBang("reset");
		Bang fixed = inputController.addBang("fix");

		fixed.setColor(color);
		fixed.setHeight(30);
		fixed.setWidth(30);
		fixed.setPosition(displayWidth/2 - displayWidth/4  -120, 15);
		fixed.registerTooltip("Use this button if you don't want the nodes that you are going to expand to move.");

		pause.setColor(color);
		pause.registerTooltip("With this button you can pause the animation of the graph");
		reset.setColor(color);
		reset.setHeight(30);
		reset.setWidth(30);
		reset.registerTooltip("With this button, you can reset the layout of the graph");
		reset.setPosition(displayWidth/2 - displayWidth/4 -80, 15);
		pause.setHeight(30);
		pause.setWidth(30);
		pause.setPosition(displayWidth/2 - displayWidth/4 - 40, 15);


		CColor col = new CColor(color(0, 146, 211), color(0, 60, 255),color(0, 146, 211),color(0, 146, 211),color(0, 146, 211) );
		Slider slider = inputController.addSlider("zoom");
		slider.setHeight(displayHeight/2);
		slider.setWidth(10);
		slider.setPosition(displayWidth -100, displayHeight/2 - displayHeight/4 -30);
		slider.setColor(col);
		slider.setValue(100f);
		slider.setRange(5f, 200f);
		slider.registerTooltip("Use this slider to zoom in or out");

	}

	float zoom = 100;
	/**
	 * The draw method. is called 25 times/second
	 */
	public void draw(){
		background(255);
		fill(color(128,0,0),75);
		transform.scale = zoom/100f;
		this.ellipse(displayWidth/2 + transform.translationX, displayHeight/2 +transform.translationY,50, 50 );
		noStroke();
		if(!fixed){
		graph.draw();
			if(!pause){
				graph.layout();
			}
			
			updateStatusMessage();
			graph.hit(mouseX,mouseY);
		}
	}

	/**
	 * Updates the status message of this application
	 */
	private void updateStatusMessage(){
		// The basic string
		String paused = "Program status: ";
		if(pause){
			paused += "Paused";
		}else{
			paused += "Running";
		}

		textSize(15);
		fill(color(0, 146, 211));
		//textFont(font);
		text(paused, displayWidth / 2 + displayWidth / 4 + 10, 35);
	}

	public void fix(){
		graph.fix();
	}
	
	public void pause(){
		if(pause){
			pause = false;
		}

		else{
			pause = true;
		}
	}
	
	boolean fixed = false;
	public void setFixed(boolean fixed){
		this.fixed = fixed;
	}

	public boolean getFixed(){
		return fixed;
	}
	public void reset(){
		Random random = new Random();
		for(Node node: graph.getNodes().values()){
			node.setPosition(150+ random.nextInt(displayWidth-300), 75+random.nextInt(displayHeight -150));
		}
		transform.translationX = 0;
		transform.translationY = 0;
		transform.scale = 1.0f;
		zoom = 100;
	}

	public Transform getTransform(){
		return transform;
	}

}
