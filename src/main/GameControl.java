package main;

import java.util.Random;

import model.Enemy;
import model.Gem;
import model.Item;
import model.Player;
import processing.core.PApplet;
import processing.core.PImage;

public class GameControl extends PApplet{
	
	int gamemode;
	Player player;
	Enemy enemy;
	Gem gem;
	Item item;
	int score;
	int timer = 250;
	float speed = (float) 0.01;
	PImage enemyPicture;
	PImage playerPicture;
	PImage gemPicture;
	PImage itemPicture;


	public static void main(String[] args) {
		PApplet.main("main.GameControl");
	}
	
	public void setup() {
		
		score = 0;
		gamemode = 0;
		enemyPicture = loadImage("../images/enemyPic.png");
		playerPicture = loadImage("../images/playerPic.png");
		gemPicture = loadImage("../images/gemPic.png");
		itemPicture = loadImage("../images/itemPic.png");
		item = new Item(random(100, 700), random(100, 400), 15, this, itemPicture);
		player = new Player(100, 100, 50, this, playerPicture);
		enemy = new Enemy(random(1, 800), random(1, 500), 50, this, enemyPicture, speed);
		gem = new Gem(random(100, 700), random(100, 400), 15, this, gemPicture);
		
	}
	
	public void settings() {
		this.size(800, 500);
	//	fullScreen(1);
	}
	
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
			enemy.npcMovement(enemy, player, speed);			
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
		
	}
	
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
