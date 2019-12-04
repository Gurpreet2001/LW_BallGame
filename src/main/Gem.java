package main;

import processing.core.PApplet;

public class Gem extends Body {

	public Gem(float xPos, float yPos, float durchmesser, int color, PApplet window) {
		super(xPos, yPos, durchmesser, color, window);
	}

	@Override
	public void drawBody() {	
		this.window.fill(color);
		this.window.stroke(66, 135, 245);
		this.window.strokeWeight(3);
		this.window.ellipse(this.xPos, this.yPos, this.durchmesser, this.durchmesser);	  
	}
	
	public boolean collisionDetectionStar(Gem g, Player p)  {	
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
	
	public void respawnGem(boolean hitStatus) {
		if (hitStatus == true) {
			System.out.println("hit");
		}
		else {
			System.out.println("nothit");
		}
	}

}
