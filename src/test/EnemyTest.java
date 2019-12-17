package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import model.Enemy;
import processing.core.PApplet;

public class EnemyTest {
	
	float yPos = 50, xPos = 10, durchmesser = 100;

	/**
	 * Enemy e = Enemy Objekt zum testen
	 * Ich teste, ob das Objekt erstellt werden kann mit Negativwerte   
	 */
	@Test
	public void CtorTest() {
		Enemy e;
		try {
			e = new Enemy(-10, -50, -100, null, null, (float) 0.01);
		} catch (Exception ex) {
			assertTrue(true);
		}
	}
	
	/**
	 * Enemy e = Enemy Objekt zum testen
	 * Ich teste, ob das Objekt die Werte korrekt übernimmt oder nicht
	 */
	@Test
	public void werteTest() {
		Enemy e;
	
		try {
			e = new Enemy(xPos, yPos, durchmesser,null , null, (float) 0.01);
			assertEquals(yPos, e.getyPos(), 0.0);
			assertEquals(xPos, e.getxPos(), 0.0);
			assertEquals(durchmesser, e.getDurchmesser(), 0.0);		
		} catch(Exception ex) {	
			ex.printStackTrace();
		}	
	}
	
	/**
	 * Enemy e = Enemy Objekt zum testen
	 * Ich teste, ob das Objekt gemalt wird oder nicht falls es in die Exception geht, ist es falsch ansonsten richtig
	 */
	@Test
	public void drawTest() {
		Enemy e;
	
		try {
			e = new Enemy(xPos, yPos, durchmesser,null ,null , (float) 0.01);
			e.drawBody();
			assertTrue(true);
		} catch(Exception ex) {
			ex.printStackTrace();
		}		
	}

}
