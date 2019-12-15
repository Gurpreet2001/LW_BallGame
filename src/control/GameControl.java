package control;

import java.util.Random;

import main.Enemy;
import main.Gem;
import main.Item;
import main.Player;
import processing.core.PApplet;
import processing.core.PImage;

public class GameControl extends PApplet{
	
	int gamemode;
	Player player;
	Enemy enemy;
	Gem gem;
	Item item;
	int score;
	float speed = (float) 0.01;
	boolean movementStatus = true;
	PImage enemyPicture;
	PImage playerPicture;
	PImage gemPicture;
	PImage itemPicture;


	public static void main(String[] args) {
		PApplet.main("control.GameControl");

	}
	
	public void setup() {
		
		score = 0;
		gamemode = 0;
		enemyPicture = loadImage("../images/enemyPic.png");
		playerPicture = loadImage("../images/playerPic.png");
		gemPicture = loadImage("../images/gemPic.png");
		itemPicture = loadImage("../images/itemPic.png");
		item = new Item(random(100, 700), random(100, 400), 15, 0x000000, this, itemPicture);
		player = new Player(100, 100, 50, 0x000000, this, playerPicture);
		enemy = new Enemy(random(1, 800), random(1, 500), 50, 0x000000, this, enemyPicture, speed);
		gem = new Gem(random(100, 700), random(100, 400), 15, 0x000000, this, gemPicture);
		
	}
	
	public void settings() {
		this.size(800, 500);
	//	fullScreen(1);
		
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
			if(movementStatus == true) {
				player.playerMovement();
				
				if(score%10==0 && score!=0) {
					item.drawBody();			
				}
			}			
			enemy.npcMovement(enemy, player, speed);
			if (gem.collisionDetectionGem(player, gem) == true) {
				score += 5;
				if(score%10 == 0) {
					speed +=.01;
				}
				System.out.println(speed);
			}
			gem.respawnGem(gem.collisionDetectionGem(player, gem), gem.randFloat(100, 400));		

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
		gem.drawBody();
		
		
		fill(255, 255, 255);
		textAlign(CENTER, BOTTOM);
		textSize(30);
		text("Score: " + score, 70, 50);
		
/*		System.out.println(player.getxPos());
		System.out.println(player.getyPos());*/
		
	}

}
