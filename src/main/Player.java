package main;

import processing.core.PApplet;

public class Player extends PApplet{
	
	private float xPos, yPos, width, height;
	private int color = 0x000000;
	private int umrandung = 0xFFFFFF;
	PApplet window;
	

	public Player(float xPos, float yPos, float width, float height, PApplet window) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.window = window;
	}
	
	public void drawPlayer() {
		this.window.stroke(umrandung);
		this.window.fill(0x000000);
		this.window.ellipse(xPos, yPos, width, height);
	}
	
	public void playerMovement() {
		this.xPos = window.mouseX;
		this.yPos = window.mouseY;
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
