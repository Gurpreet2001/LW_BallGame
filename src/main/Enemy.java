package main;

import processing.core.PApplet;
import processing.core.PImage;

public class Enemy extends Body{
	
	private float speed = (float) 0.01;


	public Enemy(float xPos, float yPos, float durchmesser, int color, PApplet window, PImage picture, float speed) {
		super(xPos, yPos, durchmesser, color, window, picture);
		this.speed = speed;
		
	}
	


	@Override
	public void drawBody() {
		// TODO Auto-generated method stub
		this.window.image(this.picture, this.xPos-25, this.yPos-25);
	//	this.window.fill(color);
	//	this.window.stroke(60, 45, 150);
	//	this.window.strokeWeight(3);		
	//	this.window.ellipse(this.xPos, this.yPos, this.durchmesser, this.durchmesser);	
	}
	
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
	
	public void npcMovement(Enemy e, Player p, float speed) {
		e.setxPos(window.lerp(e.getxPos(), p.getxPos(), speed));
		e.setyPos(window.lerp(e.getyPos(), p.getyPos(), speed));
	}

	/**
	 * @return the xPos
	 */
	public float getxPos() {
		return xPos;
	}

	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(float xPos) {
		this.xPos = xPos;
	}

	/**
	 * @return the yPos
	 */
	public float getyPos() {
		return yPos;
	}

	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(float yPos) {
		this.yPos = yPos;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}
	
	public void moveUp() {
		 this.yPos=window.max(0, yPos-speed); 
	}

	public void moveDown() {
	 this.yPos=window.min(window.height, yPos+speed);
	}

	public void moveRight() {
	 this.xPos=window.min(window.width, xPos+speed);
	}

	public void moveLeft() {
	 this.xPos=window.max(0, xPos-speed);
	}
	
	
	
}
