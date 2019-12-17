package model;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

public class Gem extends Body {


	public Gem(float xPos, float yPos, float durchmesser, PApplet window, PImage picture) {
		super(xPos, yPos, durchmesser, window, picture);
	}

	public void drawBody() {	
		this.window.image(this.picture, this.xPos-25, this.yPos-25);
	//	this.window.fill(color);
	//	this.window.stroke(66, 135, 245);
	//	this.window.strokeWeight(3);
	//	this.window.ellipse(this.xPos, this.yPos, this.durchmesser, this.durchmesser);	  
	}
	
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
	
	public void respawnGem(boolean hitStatus) {
		if (hitStatus == true) {
			this.setxPos((int) window.random(100, 800));
			this.setyPos((int) window.random(100, 500));
		}
	}

}