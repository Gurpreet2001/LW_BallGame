package main;

import control.GameControl;
import processing.core.PApplet;

public abstract class Body{

	protected float xPos, yPos, durchmesser;
	protected int color = 0x000000;
	protected PApplet window;
	

	public Body(float xPos, float yPos, float durchmesser, int color, PApplet window) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.durchmesser = durchmesser;
		this.color = color;
		this.window = window;
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
	 * @return the durchmesser
	 */
	public float getDurchmesser() {
		return durchmesser;
	}


	/**
	 * @param durchmesser the durchmesser to set
	 */
	public void setDurchmesser(float durchmesser) {
		this.durchmesser = durchmesser;
	}


	/**
	 * @return the color
	 */
	public int getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}


	/**
	 * @return the window
	 */
	public PApplet getWindow() {
		return window;
	}


	/**
	 * @param window the window to set
	 */
	public void setWindow(PApplet window) {
		this.window = window;
	}
	
	public abstract void drawBody();
	
	
	
	
	
	
	
	

}
