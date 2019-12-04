package main;

import processing.core.PApplet;

public class Enemy extends Body{
	
	private float speed = (float) 0.01;


	public Enemy(float xPos, float yPos, float durchmesser, int color, PApplet window, float speed) {
		super(xPos, yPos, durchmesser, color, window);
		this.speed = speed;
		
	}
	


	@Override
	public void drawBody() {
		// TODO Auto-generated method stub
		this.window.fill(color);
		this.window.stroke(60, 45, 150);
		this.window.strokeWeight(3);
		this.window.ellipse(this.xPos, this.yPos, this.durchmesser, this.durchmesser);	
	}
	
	public boolean collisionDetection(Player p, Enemy e) {
		
		boolean gameover = false;
		
		float radius = p.getDurchmesser()/2 + e.getDurchmesser()/2;
		
		//returns the difference from player circle point to enemy circle point
		float hyp = window.dist(p.getxPos(), p.getyPos(), e.getxPos(), e.getyPos());
	//	System.out.println(gameover);
		if (hyp < radius) {
			gameover = true;
		}
		else {
			gameover = false;
		}
		
//		System.out.println(gameover);
		return gameover;	
	}
	
	public void npcMovement(Enemy e, Player p) {
		e.setxPos(window.lerp(e.getxPos(), p.getxPos(), e.getSpeed()));
		e.setyPos(window.lerp(e.getyPos(), p.getyPos(), e.getSpeed()));
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
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}
}
