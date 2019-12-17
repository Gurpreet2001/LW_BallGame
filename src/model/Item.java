package model;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class is used to specify the item entity
 * It's a specialization from the Body Class
 * @author gurpreet
 */
public class Item extends Body{
	
	/**
	 * @param xPos = x coordinate of object
	 * @param yPos = y coordinate of object
	 * @param durchmesser = width/height of object
	 * @param window = window, in which it'll be drawn
	 * @param picture = picture that'll be loaded for this object
	 * @throws Exception = If the value of x/y/durchmesser are under 0, it'll throw an exception
	 */
	public Item(float xPos, float yPos, float durchmesser, PApplet window, PImage picture) throws Exception {
		super(xPos, yPos, durchmesser, window, picture);
	}

	/**
	 * Function from Interface
	 * Used to draw the Body of item entities
	 */
	public void drawBody() {
		// TODO Auto-generated method stub
		this.window.image(this.picture, this.xPos-25, this.yPos-25);
	}
	
	/**
	 * Checks, if the players collided with the item or not
	 * @param p = Player entity
	 * @param i = Item entity
	 * radius = sum of radius from player and radius from item
	 * dif = difference from player middlepoint position to item middlepoint position
	 * @return hitStatus = boolean to tell, if the game is over (true) or if it's still going on (false)
	 */
	public boolean collisionDetectionItem(Player p, Item i) {	
		boolean hitStatus = false;	
		float radius = p.getDurchmesser()/2 + i.getDurchmesser()/2;
		
		//returns the difference from player circle point to enemy circle point
		float dif = window.dist(p.getxPos(), p.getyPos(), i.getxPos(), i.getyPos());
		if (dif < radius) {
			hitStatus = true;
		}
		else {
			hitStatus = false;
		}	
		
		return hitStatus;	
	}
}
