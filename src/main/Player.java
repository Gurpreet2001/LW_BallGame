package main;

import processing.core.PApplet;

public class Player extends Body{
	

	public Player(float xPos, float yPos, float durchmesser, int color, PApplet window) {
		super(xPos, yPos, durchmesser, color, window);
		
	}
	
	@Override
	public void drawBody() {
		// TODO Auto-generated method stub
		this.window.fill(color);
		this.window.stroke(66, 135, 245);
		this.window.strokeWeight(3);
		this.window.ellipse(this.xPos, this.yPos, this.durchmesser, this.durchmesser);
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
