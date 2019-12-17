package model;

import main.GameControl;
import processing.core.PApplet;
import processing.core.PImage;

public abstract class Body implements Drawable{

	protected float xPos, yPos, durchmesser;
	protected int color = 0x000000;
	protected PApplet window;
	PImage picture;
	

	public Body(float xPos, float yPos, float durchmesser, PApplet window, PImage picture) throws Exception{
		this.xPos = xPos;
		this.yPos = yPos;
		if(this.xPos < 0) { throw new Exception("Keine Negativzahlen oder 0"); }
		if(this.yPos < 0) { throw new Exception("Keine Negativzahlen oder 0"); }
		if(this.durchmesser < 0) { throw new Exception("Keine Negativzahlen oder 0"); }
		this.durchmesser = durchmesser;
		this.window = window;
		this.picture = picture;
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
}
