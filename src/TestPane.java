import java.util.ArrayList;
import java.util.HashMap;

import data.Publication;

import processing.core.PApplet;
import processing.core.PVector;
import visualisation.guielements.GUIButton;
import visualisation.guielements.URLButton;
import visualisation.subject.Field;


public class TestPane extends PApplet {

	private URLButton showPublication;
	private GUIButton expand;
	private GUIButton showAbstract;
	private GUIButton pin;
	
	public void setup(){
		size(700, 800);
		this.showPublication = new URLButton("View publication", "Dummy text", this);
		this.expand = new GUIButton("Expand","Show Abstract", this);
		this.showAbstract = new GUIButton("Show Abstract","Show Abstract", this);
		this.pin = new GUIButton("Pin","Show Abstract", this);
	}
	
	int width = 275;
	int height = 400;
	boolean expanded;
	private static int X_OFFSET = 10;
	public static int CORNER_RADIUS = 10;
	
	public void draw(){
		background(color(255));
		PVector position = new PVector(25,425);
		textAlign(this.LEFT);
		stroke(0, 50);

		// Header of the information pane
		int width = this.width;
		expanded = false;
		if(expanded) width *= 2;
		
		fill(color(0,146,211));
		rect(position.x+ X_OFFSET, position.y - height/2 -40, width, 40, CORNER_RADIUS, CORNER_RADIUS, 0, 0);
		textSize(20);
		fill(255);
		text("Description", position.x + X_OFFSET + 5, position.y - height/2 - 10);

		// Body of the information pane.
		this.fill(255);
		this.rect(position.x + X_OFFSET, position.y - height/2, width, height, 0, 0, CORNER_RADIUS, CORNER_RADIUS);

		this.noStroke();
		this.fill(0);
		HashMap<String, Field> fields = getProperties();
		float offset = 0;
		// manual drawing, ugly code
		
		this.textSize(12);
		
		ArrayList<Field> items = new ArrayList<Field>();
		items.add(fields.get(Publication.TITLE));
		items.add(fields.get(Publication.AUTHORS));
		//items.add(fields.get(Publication.CONFERENCE));
		items.add(fields.get(Publication.CITED));
		items.add(fields.get(Publication.YEAR));
		
		for(Field field: items){
			offset += 20;
			this.textSize(12);
			if( field != null && !field.getContent().equals("null")){
				this.fill(this.color(0,146,211));
				this.text(field.getName(), position.x + X_OFFSET + 5, position.y - height/2 + offset, width - 10, 30);
				offset += 20;
				this.fill(this.color(0));
				float lines = this.textWidth(trimInput(field.getContent())) / ( width -25);
				if(lines < 1){
					lines = 1;
				}
				String text = "";
				text += field.getContent();
				this.text(trimInput(text) , position.x + X_OFFSET + 5, position.y - height/2 + offset, width - 10, 30*lines);
				offset += 15*lines;
			}
		}
		
		showPublication.setWidth(122);
		showPublication.setPosition(position.x + X_OFFSET*2 +2, position.y - height/2 + offset + 20);
		pin.setWidth(122);
		pin.setPosition(position.x + X_OFFSET*2 +2 + 130, position.y - height/2 + offset + 20);
		pin.draw();
		showPublication.draw();
		expand.setPosition(position.x + X_OFFSET*2 +2, position.y - height/2 + offset + 55);
		expand.setWidth(122);
		expand.draw();
		showAbstract.setWidth(122);
		showAbstract.setPosition(position.x + X_OFFSET*2 +130, position.y - height/2 + offset + 55);
		showAbstract.draw();
		
		offset = 20;
		if(expanded){
			this.fill(this.color(0,146,211));
			this.text(fields.get(Publication.ABSTRACT).getName(), this.width + 10, position.y - height/2 + offset);
			offset +=20;
			this.fill(color(0));
			this.text(fields.get(Publication.ABSTRACT).getContent(), this.width + 10, position.y - height/2 + offset);
		}
	}
	
	public String trimInput(String input){
		if(input.length() <= 200){
			return input;
		}

		String output = input.substring(0, 197);
		output += "...";

		return output;
	}
	
	public HashMap<String, Field> getProperties(){
		HashMap<String, Field> properties = new HashMap<String, Field>();
		
		properties.put(Publication.TITLE, new Field("Title", "This is a test paper"));
		properties.put(Publication.AUTHORS, new Field("Kobe Vrancken", "Stefan Pante"));
		properties.put(Publication.CONFERENCE, new Field("Conference", "Hello"));
		properties.put(Publication.CITED, new Field("Citations", "100"));
		properties.put(Publication.YEAR, new Field("Year", "1998"));
		properties.put(Publication.ABSTRACT, new Field("Abstract", "This the abstract for the short paper we are creating"));
		return properties;
		
	}


}
