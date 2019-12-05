package control;

import java.util.Random;

import main.Enemy;
import main.Gem;
import main.Player;
import processing.core.PApplet;

public class GameControl extends PApplet{
	
	int gamemode;
	Player player;
	Enemy enemy;
	Gem star;
	int score;
	float speed = (float) 0.01;


	public static void main(String[] args) {
		PApplet.main("control.GameControl");

	}
	
	public void setup() {
		
		score = 0;
		gamemode = 0;
		player = new Player(100, 100, 50, 0x000000, this);
		enemy = new Enemy(random(1, 800), random(1, 500), 50, 0x000000, this, speed);
		star = new Gem(random(1, 800), random(1, 500), 15, 0x000000, this);
		
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
			enemy.npcMovement(enemy, player, speed);
			if (star.collisionDetectionStar(star, player) == true) {
				score += 1;
				if(score%20 == 0) {
					speed +=0.01;
				}
				System.out.println(speed);
			}
			star.respawnGem(star.collisionDetectionStar(star, player), star.randFloat(1, 500));
			if(enemy.collisionDetectionEnemy(player, enemy) == true) {
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
		
		fill(255, 255, 255);
		textAlign(CENTER, BOTTOM);
		textSize(30);
		text("Score: " + score,  400, 290);
	}
	
	
	public void drawGame() {
		player.drawBody();
		enemy.drawBody();
		star.drawBody();
		
		
		fill(255, 255, 255);
		textAlign(CENTER, BOTTOM);
		textSize(30);
		text("Score: " + score, 70, 50);
		
/*		System.out.println(player.getxPos());
		System.out.println(player.getyPos());*/
		
	}

}
