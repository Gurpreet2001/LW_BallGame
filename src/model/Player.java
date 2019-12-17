package model;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class is used to specify the player entity
 * It's a specialization from the Body Class
 * @author gurpreet
 */
public class Player extends Body{
	
	/**
	 * @param xPos = x coordinate of object
	 * @param yPos = y coordinate of object
	 * @param durchmesser = width/height of object
	 * @param window = window, in which it'll be drawn
	 * @param picture = picture that'll be loaded for this object
	 * @throws Exception = If the value of x/y/durchmesser are under 0, it'll throw an exception
	 */
	public Player(float xPos, float yPos, float durchmesser, PApplet window, PImage picture) throws Exception {
		super(xPos, yPos, durchmesser, window, picture);
	}
	
	/**
	 * Function from Interface
	 * Used to draw the Body of enemy entities
	 */
	public void drawBody() {
		this.window.image(this.picture, this.xPos-25, this.yPos-25);
	}
	
	/**
	 * Sets the x and y Coordinates equal to the mouseX/mouseY
	 */
	public void playerMovement() {
		this.xPos = this.window.mouseX;
		this.yPos = this.window.mouseY;
	}

}
