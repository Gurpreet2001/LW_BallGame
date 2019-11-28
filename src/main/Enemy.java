package main;

import processing.core.PApplet;

public class Enemy extends PApplet{
	
	private float xPos, yPos, width, height, speed = (float) 0.01;
	private int color = 0x000000;
	PApplet window;

	public Enemy(float xPos, float yPos, float width, float height, PApplet window) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.window = window;
	}
	
	public void drawEnemy() {
		this.window.fill(0x000000);
		this.window.stroke(60, 45, 150);
		this.window.strokeWeight(3);
		this.window.ellipse(xPos, yPos, width, height);
	}
	
	public boolean collisionDetection(Player p, Enemy e) {
		
		boolean gameover = false;
		
		float radius = p.getWidth()/2 + e.getWidth()/2;
		
		//returns the difference from player circle point to enemy circle point
		float hyp = dist(p.getxPos(), p.getyPos(), e.getxPos(), e.getyPos());
		System.out.println(gameover);
		if (hyp < radius) {
			gameover = true;
		}
		else {
			gameover = false;
		}
		
//		System.out.println(gameover);
		return gameover;
		
	}
	
	public void npcMovement(Player p, Enemy e) {
		e.setxPos(lerp(e.getxPos(), p.getxPos(), e.getSpeed()));
		e.setyPos(lerp(e.getyPos(), p.getyPos(), e.getSpeed()));
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

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	
	

}
