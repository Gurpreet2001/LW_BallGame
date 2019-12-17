package model;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class is used to specify the gem entity
 * It's a specialization from the Body Class
 * @author gurpreet
 */
public class Gem extends Body {


	/**
	 * @param xPos = x coordinate of object
	 * @param yPos = y coordinate of object
	 * @param durchmesser = width/height of object
	 * @param window = window, in which it'll be drawn
	 * @param picture = picture that'll be loaded for this object
	 * @throws Exception = If the value of x/y/durchmesser are under 0, it'll throw an exception
	 */
	public Gem(float xPos, float yPos, float durchmesser, PApplet window, PImage picture) throws Exception {
		super(xPos, yPos, durchmesser, window, picture);
	}

	/**
	 * Function from Interface
	 * Used to draw the Body of gem entities
	 */
	public void drawBody() {	
		this.window.image(this.picture, this.xPos-25, this.yPos-25); 
	}
	
	/**
	 * Checks, if the players collided with the gem or not
	 * @param p = Player entity
	 * @param g = Gem entity
	 * radius = sum of radius from player and gem from enemy
	 * dif = difference from player middlepoint position to gem middlepoint position
	 * @return hitStatus = boolean to tell, if the gem was collected (true) hasen't been collected (false)
	 */
	public boolean collisionDetectionGem(Player p, Gem g)  {	
		boolean hitStatus = false;	
		float radius = p.getDurchmesser()/2 + g.getDurchmesser()/2;	
		//returns the difference from player circle point to enemy circle point
		float dif = window.dist(p.getxPos(), p.getyPos(), g.getxPos(), g.getyPos());
		if (dif < radius) {
			hitStatus = true;
		}
		else {
			hitStatus = false;
		}			
		return hitStatus;	
	}
	
	/**
	 * This functions respawns the gem as soon as it collides with the player
	 * @param hitStatus = tells the function if the respawn is needeed (true) or not (false)
	 */
	public void respawnGem(boolean hitStatus) {
		if (hitStatus == true) {
			this.setxPos((int) window.random(100, 800));
			this.setyPos((int) window.random(100, 500));
		}
	}

}
