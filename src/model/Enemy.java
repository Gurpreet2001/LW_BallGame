package model;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class is used to specify the enemy entity
 * It's a specialization from the Body Class
 * @author gurpreet
 *
 */
public class Enemy extends Body{
	
	private float speed = (float) 0.01;
	
	/**
	 * @param xPos = x coordinate of object
	 * @param yPos = y coordinate of object
	 * @param durchmesser = width/height of object
	 * @param window = window, in which it'll be drawn
	 * @param picture = picture that'll be loaded for this object
	 * @param speed = Movement speed, which enemy entity'll use to move towards the player
	 * @throws Exception = If the value of x/y/durchmesser are under 0, it'll throw an exception
	 */
	public Enemy(float xPos, float yPos, float durchmesser, PApplet window, PImage picture, float speed) throws Exception {
		super(xPos, yPos, durchmesser, window, picture);
		this.speed = speed;
		
	}
	
	 

	/**
	 * Function from Interface
	 * Used to draw the Body of enemy entities
	 */
	public void drawBody() {
		this.window.image(this.picture, this.xPos-25, this.yPos-25);
	}
	
	/**
	 * Checks, if the players collided with the enemy or not
	 * @param p = Player entity
	 * @param e = Enemy entity
	 * radius = sum of radius from player and radius from enemy
	 * dif = difference from player middlepoint position to enemy middlepoint position
	 * @return gameover = boolean to tell, if the game is over (true) or if it's still going on (false)
	 */
	public boolean collisionDetectionEnemy(Player p, Enemy e) {	
		boolean gameover = false;
		 
		float radius = p.getDurchmesser()/2 + e.getDurchmesser()/2;		
		//returns the difference from player circle point to enemy circle point
		float dif = window.dist(p.getxPos(), p.getyPos(), e.getxPos(), e.getyPos());
		if (dif < radius) {
			gameover = true;
		}
		else {
			gameover = false;
		}		
		return gameover;	
	}
	
	/**
	 * Moves the enemy every frame for 100*speed towards the player
	 * @param e = Enemy entity
	 * @param p = Player entity
	 * @param speed = Speed, which enemy entity'll use to move towards the player
	 */
	public void npcMovement(Enemy e, Player p, float speed) {
		e.setxPos(window.lerp(e.getxPos(), p.getxPos(), speed));
		e.setyPos(window.lerp(e.getyPos(), p.getyPos(), speed));
	}	
	
}
