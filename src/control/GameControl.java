package control;

import java.util.Random;

import main.Enemy;
import main.Player;
import processing.core.PApplet;

public class GameControl extends PApplet{
	
	int gamemode;
	Player player;
	Enemy enemy;
	Random i;


	public static void main(String[] args) {
		PApplet.main("control.GameControl");

	}
	
	public void setup() {
		
		player = new Player(100, 100, 50, 50, this);
		enemy = new Enemy(random(1, 800), random(1, 500), 50, 50, this);
		
	}
	
	public void settings() {
		this.size(800, 500);
		
	}
	
	public void draw() {
		background(0x52271E);
		drawGame();
		player.playerMovement();
		enemy.collisionDetection(player, enemy);
		enemy.npcMovement(player, enemy);
	
	}
	
	
	public void drawGame() {
		player.drawPlayer();
		enemy.drawEnemy();
		
/*		System.out.println(player.getxPos());
		System.out.println(player.getyPos());*/
		
	}

}
