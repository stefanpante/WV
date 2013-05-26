package visualisation;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.sql.SQLException;
import controlP5.Bang;
import controlP5.CColor;
import controlP5.ControlP5;
import controlP5.Slider;
import controlP5.Textfield;

import processing.core.*;
import visualisation.graph.Graph;
import visualisation.graph.GraphFactory;
import visualisation.graph.GraphLayout;
import visualisation.graph.RegularForceBasedLayout;
import visualisation.guielements.SearchResultMenu;

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
	
	private PShape loadingAnimation;


	/**
	 * Setup sets up the program for running.
	 * 	-inits GUI
	 *   inits GRAPH
	 */
	public void setup(){

		transform = new Transform(this);

		// sets the size of the window
		size(displayWidth,displayHeight);

		// Sets the frameRate for the animation
		frameRate(60);

		loadingAnimation = this.loadShape(getClass().getResource("/res/loading.svg").getPath());
		isLoading = true;
		// Create a graph instance to display
		int id = Application.live ? 777102 : 4;
//		try {
//			graph = GraphFactory.getInstance().fromDatabaseID(id, 1, this);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}




		// Initializes the GUI
		setupGUI();

		// initializes the graph
		initGraph();



	}



	SearchResultMenu menu;

	/**
	 * Initializes the graph.
	 */
	private void initGraph(){
		// Gives the parentNode its default appearance
		//initParentNode();

		// Sets the default graphLayout for the graph
		//graph.setGraphLayout(new CircularLayout(graph));
	}

	/**
	 * Handles mouse events.
	 */
	public void mousePressed(){
		if(menuEnabled){
			int id = menu2.mousePressed(mouseX, mouseY);
			this.processMenuPressed(id);
		}
		if (mouseEvent.getClickCount()==2){
			graph.expand(mouseX, mouseY);
		}
		if(mouseEvent.getClickCount() ==1){
			if(graph != null)
				graph.mouseHit(mouseX, mouseY);
		}
		if(!locked && (mouseX < displayWidth -150)){
			xOffset = mouseX - transform.translationX;
			yOffset = mouseY - transform.translationY;
			locked = true;
		}
	}

	@SuppressWarnings("deprecation")
	private void processMenuPressed(int id){
		if(id == -1){
			inputField.setLabel("Search");

		}
		else{
			try {
				Graph newGraph = GraphFactory.getInstance().fromDatabaseID(id, 1, this);
				if(newGraph.getNodes().size() > 0){
					graph = newGraph;
					this.graph.setGraphLayout(new RegularForceBasedLayout(graph));
					this.resetTransform();
				}
				else{
					warning = "This Paper does not have citations in our database. \n The graph cannot be displayed.";
					currentFrameWarning = 0;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		menuEnabled = false;
	}

	private void resetTransform(){
		this.transform.translationX = 0;
		this.transform.translationY = 0;
		this.transform.scale = 1f;
		slider.setValue(100);
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



	public void mouseWheel(int delta){
		delta *= 4;
		zoom -= delta;
		slider.setValue(zoom);
		transform.scale -= delta/100;
	}

	/**
	 * Setups the gui for this application
	 */
	private void setupGUI(){


		addMouseWheelListener(new MouseWheelListener() { 
			public void mouseWheelMoved(MouseWheelEvent mwe) { 
				mouseWheel(mwe.getWheelRotation());
			}}); 
		inputController = new ControlP5(this);
		int width = displayWidth/2;
		inputField = inputController.addTextfield("search",  displayWidth/2 - width/2, 15, width, 30 );
		CColor color = new CColor(color(0, 146, 211), color(255),color(0, 60, 255),color(0, 146, 211),color(0, 146, 211) );

		inputField.setColor(color);
		inputField.registerTooltip("Type here to search for a paper");

		Bang pause = inputController.addBang("pause");


		pause.setColor(color);
		pause.registerTooltip("With this button you can pause the animation of the graph");
		pause.setHeight(30);
		pause.setWidth(30);
		pause.setPosition(displayWidth/2 - displayWidth/4 - 40, 15);


		CColor col = new CColor(color(0, 146, 211), color(0, 60, 255),color(0, 146, 211),color(0, 146, 211),color(0, 146, 211) );
		slider = inputController.addSlider("zoom");
		slider.scrolled(2);
		slider.setHeight(displayHeight/2);
		slider.setWidth(10);
		slider.setPosition(displayWidth -50, displayHeight/2 - displayHeight/4 );
		slider.setColor(col);
		slider.setValue(100f);
		slider.setRange(5f, 200f);
		slider.registerTooltip("Use this slider to zoom in or out");
		slider.getValueLabel().setColor(this.color(255));


	}
	Textfield inputField;
	Slider slider;
	float zoom = 100;
	boolean menuEnabled = false;
	SearchResultMenu menu2;
	SearchThread trd;
	public void search(String search) throws Exception{
		trd = new SearchThread(search, this);
		trd.start();
	}
	
	private boolean isLoading = false;
	public void startSearchAnimation(){
		isLoading = true;
	}
	
	public void stopSearchAnimation(){
		isLoading = false;
	}


	/**
	 * The draw method. is called 25 times/second
	 */
	@SuppressWarnings("deprecation")
	public void draw(){
		background(color(255));
		fill(color(128,0,0),75);
		transform.scale = zoom/100f;
		this.ellipse(displayWidth/2 + transform.translationX, displayHeight/2 +transform.translationY,50, 50 );
		noStroke();
		if(!fixed){
			if(!pause){
				if(graph != null){
					graph.layout();
					graph.draw();
				}
			}

			if(menuEnabled){
				menu2.draw();
				inputField.setLabel("");
				menu2.hit(mouseX, mouseY);
			}
			else{
				if(graph != null)
					graph.hit(mouseX,mouseY);
			}
		}

		displayWarning();
		isLoading = true;
		showLoadingAnimation();
	}



	private void showLoadingAnimation() {
		if(isLoading){
			loadingAnimation.rotate(TWO_PI/this.frameRate);
			this.shape(loadingAnimation, 3*displayWidth/4 + 35,  30);
		}
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


	public Transform getTransform(){
		return transform;
	}

	public boolean sketchFullScreen(){
		return true;
	}
	private String warning;
	private int currentFrameWarning = 180;
	private int endFrameWarning = 180;
	public void displayWarning(){
		if(currentFrameWarning < endFrameWarning){
			fill(color(255));
			stroke(0, 50);
			rect( displayWidth/2 - 200, displayHeight/2 - 40,400,80);
			textSize(15);
			fill(color(0, 60, 255));
			noStroke();
			textAlign(CENTER, CENTER);
			text(warning, displayWidth/2 - 200, displayHeight/2 - 40, 400, 80);
			currentFrameWarning++;
		}
	}

}
