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
	float speed = (float) 0.01;


	public static void main(String[] args) {
		PApplet.main("control.GameControl");

	}
	
	public void setup() {
		
		gamemode = 0;
		player = new Player(100, 100, 50, 0x000000, this);
		enemy = new Enemy(50,50, 50, 0x000000, this, speed);
		
	}
	
	public void settings() {
		this.size(800, 500);
		
	}
	
	public void draw() {
		
		
		if(gamemode == 0) {
			drawStartupScreen();
			if(keyPressed) {
				gamemode = 1;
			}
		}
		
		if(gamemode == 1) {
			background(0x52271E);
			drawGame();
			player.playerMovement();
			enemy.npcMovement(enemy, player);
			if(enemy.collisionDetection(player, enemy) == true) {
				gamemode = 2;
			}
		}
		
		if(gamemode == 2) {
			drawGameOverScreen();
		}
	}
	
	public void drawStartupScreen() {
		background(0x000000);
		fill(255, 255, 255);
		textAlign(CENTER);
		textSize(30);
		text("Press any key to start playing", 400, 250);
	}
	
	public void drawGameOverScreen() {
		background(0x000000);
		fill(255, 255, 255);
		textAlign(CENTER);
		textSize(30);
		text("You lost.", 400, 250);
	}
	
	
	public void drawGame() {
		player.drawBody();
		enemy.drawBody();
		
/*		System.out.println(player.getxPos());
		System.out.println(player.getyPos());*/
		
	}

}
