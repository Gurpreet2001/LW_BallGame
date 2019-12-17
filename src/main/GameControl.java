package main;

import java.util.Random;

import model.Enemy;
import model.Gem;
import model.Item;
import model.Player;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class is used to control all the objects within the game
 * inherits von der PApplet Klasse
 * @author gurpreet
 */
public class GameControl extends PApplet{
	
	/**
	 * declare variables
	 */
	int gamemode;
	Player player;
	Enemy enemy;
	Gem gem;
	Item item;
	int score;
	boolean movementStatus = true;
	int timer = 250;
	float speed = (float) 0.01;
	PImage enemyPicture;
	PImage playerPicture;
	PImage gemPicture;
	PImage itemPicture;

	/**
	 * Used, to visualize the window
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main("main.GameControl");
	}
	
	/**
	 * Setup is used to initialize variables
	 */
	public void setup() {
		score = 0;
		gamemode = 0;
		enemyPicture = loadImage("../images/enemyPic.png");
		playerPicture = loadImage("../images/playerPic.png");
		gemPicture = loadImage("../images/gemPic.png");
		itemPicture = loadImage("../images/itemPic.png");

		try {
			enemy = new Enemy(random(1, 800), random(1, 500), 50, this, enemyPicture, speed);
			item = new Item(random(100, 700), random(100, 400), 15, this, itemPicture);
			player = new Player(100, 100, 50, this, playerPicture);
			gem = new Gem(random(100, 700), random(100, 400), 15, this, gemPicture);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	/**
	 * Settings are used, to define the height/width of the game Window
	 */
	public void settings() {
		this.size(800, 500);
	//	fullScreen(1);
	}
	
	/**
	 * Draw is used, to execute the code while the game Window is loaded
 	 * Gamemode 0 = Startupscreen, player needs to press button so the gamemode sets to 1
	 * Gamemode 1 = Game itself starts, all collisionDetections are checked, item/gem spawns
	 * Gamemode 1 = If enemy and player collide, the gamemode will change to 2
	 * Gamemode 2 = Gameover, the player can restart the game by pressing r
	 */
	public void draw() {
		System.out.println(speed);
		
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
				enemy.npcMovement(enemy, player, speed);
			}					
			player.playerMovement();			
			spawnItem();					
			if (gem.collisionDetectionGem(player, gem) == true) {
				score += 1;
				if(score%10 == 0) {
					speed +=0.02;
				}
				System.out.println(speed);
			}
			
			gem.respawnGem(gem.collisionDetectionGem(player, gem));		

			if(enemy.collisionDetectionEnemy(player, enemy) == true) {
				gamemode = 2;
			}    
		}
		
		if(gamemode == 2) {
			drawGameOverScreen();
			if(keyPressed && key=='r') {
				gamemode=1;
				score = 0;
				timer = 250;
				speed = (float)0.01;			
			}
		}
	}
	
	/**
	 * Draws the Startupscreen Text into game Window
	 */
	public void drawStartupScreen() {
		background(0x000000);
		fill(255, 255, 255);
		textAlign(CENTER);
		textSize(30);
		text("Press any key to start playing", 400, 250);
	}
	
	/**
	 * Draws the Gameover Text into game Window
	 */
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
		
		fill(255, 255, 255);
		textAlign(CENTER, BOTTOM);
		textSize(30);
		text("Press R to restart ",  400, 330);
	}
	
	/**
	 * Draws the player, enemy, gem and score for the game
	 */
	public void drawGame() {
		player.drawBody();
		enemy.drawBody();
		gem.drawBody();
		
		
		fill(255, 255, 255);
		textAlign(CENTER, BOTTOM);
		textSize(30);
		text("Score: " + score, 70, 50);
		
	}
	
	/**
	 * timer is reduced every frame per second if the timer is under 0, the item spawns
	 * if the item is collected by the player, the timer sets to a random number (250 to 1000)
	 */
	public void spawnItem() {
		System.out.println(timer);
		timer--;
		if(timer < 0) {
			item.drawBody();
			if (item.collisionDetectionItem(player, item)) {
				score += 5;
				if(speed > 0.01 && speed  != 0.01) {
					speed -= 0.01;
				}	
				timer = (int) random(250, 1000);
			}								
		}
	}

}
