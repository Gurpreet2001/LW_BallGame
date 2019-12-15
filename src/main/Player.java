package main;

import processing.core.PApplet;
import processing.core.PImage;

public class Player extends Body{
	

	public Player(float xPos, float yPos, float durchmesser, int color, PApplet window, PImage picture) {
		super(xPos, yPos, durchmesser, color, window, picture);
		
	}
	
	@Override
	public void drawBody() {
		// TODO Auto-generated method stub
		this.window.image(this.picture, this.xPos-25, this.yPos-25);
//		this.window.fill(color);
//		this.window.stroke(66, 135, 245);
//		this.window.strokeWeight(3);
//		this.window.ellipse(this.xPos, this.yPos, this.durchmesser, this.durchmesser);
	}

	
	public void playerMovementItem(Player p, Gem g, float speed) {
		p.setxPos(window.lerp(p.getxPos(), g.getxPos(), speed));
		p.setyPos(window.lerp(p.getyPos(), g.getyPos(), speed));
	}
	
	public void playerMovement() {
		this.xPos = this.window.mouseX;
		this.yPos = this.window.mouseY;
	}

	/**
	 * @return the xPos
	 */
	public float getxPos() {
		return xPos;
	}

	/**
	 * @return the yPos
	 */
	public float getyPos() {
		return yPos;
	}
}
