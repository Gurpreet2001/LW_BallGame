package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Item extends Body{
	
	

	public Item(float xPos, float yPos, float durchmesser, PApplet window, PImage picture) {
		super(xPos, yPos, durchmesser, window, picture);
	}

	
	public void drawBody() {
		// TODO Auto-generated method stub
		this.window.image(this.picture, this.xPos-25, this.yPos-25);
	}
	
	
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
