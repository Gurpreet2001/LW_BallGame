package main;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

public class Gem extends Body {


	public Gem(float xPos, float yPos, float durchmesser, int color, PApplet window, PImage picture) {
		super(xPos, yPos, durchmesser, color, window, picture);
	}

	@Override
	public void drawBody() {	
		this.window.image(this.picture, this.xPos-25, this.yPos-25);
	//	this.window.fill(color);
	//	this.window.stroke(66, 135, 245);
	//	this.window.strokeWeight(3);
	//	this.window.ellipse(this.xPos, this.yPos, this.durchmesser, this.durchmesser);	  
	}
	
	public boolean collisionDetectionGem(Gem g, Player p)  {	
		boolean hitStatus = false;	
		float radius = p.getDurchmesser()/2 + g.getDurchmesser()/2;
		
		//returns the difference from player circle point to enemy circle point
		float hyp = window.dist(p.getxPos(), p.getyPos(), g.getxPos(), g.getyPos());
	//	System.out.println(hitStatus);
		if (hyp < radius) {
			hitStatus = true;
	//		System.out.println(hitStatus);
		}
		else {
			hitStatus = false;
		//	System.out.println(hitStatus);
		}	
		
		return hitStatus;	
	}
	
	public void respawnGem(boolean hitStatus, float random) {
		if (hitStatus == true) {
			this.setxPos(random);
			this.setyPos(random);
		//	System.out.println("hit");
		}
	}
	
	public float randFloat(float min, float max) {

	    Random rand = new Random();

	    return rand.nextFloat() * (max - min) + min;

	}

}
