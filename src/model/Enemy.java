package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Enemy extends Body{
	
	private float speed = (float) 0.01;


	public Enemy(float xPos, float yPos, float durchmesser, PApplet window, PImage picture, float speed) {
		super(xPos, yPos, durchmesser, window, picture);
		this.speed = speed;
		
	}
	


	
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
	
}
