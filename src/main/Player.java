package main;

import processing.core.PApplet;

public class Player extends PApplet{
	
	private float xPos, yPos, width, height;
	private int color = 0x000000;
	PApplet window;
	

	public Player(float xPos, float yPos, float width, float height, PApplet window) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.window = window;
	}
	
	public void drawPlayer() {
		
		this.window.fill(0x000000);
		this.window.stroke(66, 135, 245);
		this.window.strokeWeight(3);
		this.window.ellipse(xPos, yPos, width, height);
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

	/**
	 * @return the width
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public float getHeight() {
		return height;
	}
	
	

}
