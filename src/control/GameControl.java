package control;

import main.Player;
import processing.core.PApplet;

public class GameControl extends PApplet{
	
	int gamemode;
	Player player;


	public static void main(String[] args) {
		PApplet.main("control.GameControl");

	}
	
	public void setup() {
		
		player = new Player(100, 100, 50, 50, this);
		
	}
	
	public void settings() {
		this.size(800, 500);
		
	}
	
	public void draw() {
		background(0x52271E);
		player.drawPlayer();
		player.playerMovement();
		
		System.out.println(player.getxPos());
		System.out.println(player.getyPos());
		
		
	}

}
