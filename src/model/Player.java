package model;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

public class Player extends Body{
	

	public Player(float xPos, float yPos, float durchmesser, PApplet window, PImage picture) throws Exception {
		super(xPos, yPos, durchmesser, window, picture);
	}
	
	
	public void drawBody() {
		// TODO Auto-generated method stub
		this.window.image(this.picture, this.xPos-25, this.yPos-25);
//		this.window.fill(color);
//		this.window.stroke(66, 135, 245);
//		this.window.strokeWeight(3);
//		this.window.ellipse(this.xPos, this.yPos, this.durchmesser, this.durchmesser);
	}
	
	public void playerMovement() {
		this.xPos = this.window.mouseX;
		this.yPos = this.window.mouseY;
	}

}
