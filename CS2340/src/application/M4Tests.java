package application;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class M4Tests {
    @Test
    public void ethanEnemyDeathTest() {
        Path p1 = new Path(0, 0, 0, 0);
        p1.setLastTile(true);
        NormKid e1 = new NormKid(p1);
        NormKid e2 = new NormKid(p1);
        NormKid e3 = new NormKid(p1);
    
        assertEquals(e1.checkDeath(), false);
        assertEquals(e2.checkDeath(), false);
        assertEquals(e3.checkDeath(), false);
        e1.takeDamage(100);
        assertEquals(e1.checkDeath(), true);
        e1.takeDamage(100);
        assertEquals(e1.checkDeath(), true);
    
        e2.takeDamage(10);
        assertEquals(e2.checkDeath(), false);
        e2.takeDamage(20);
        assertEquals(e2.checkDeath(), false);
        e2.takeDamage(200);
        assertEquals(e2.checkDeath(), true);
        
        e3.takeDamage(110);
        assertEquals(e3.checkDeath(), true);
        e3.takeDamage(-20);
        assertEquals(e3.checkDeath(), false);
        e3.takeDamage(10);
        assertEquals(e3.checkDeath(), true);
    }
    
    @Test
    public void ethanEnemyAttackMonumentTest() {
        Monument m1 = new Monument(100, 20);
        Monument m2 = new Monument(420, 69);
        Monument m3 = new Monument(50, 50);
        Path p1 = new Path(0, 0, 0, 0);
        p1.setLastTile(true);
        NormKid e1 = new NormKid(p1);
        NormKid e2 = new NormKid(p1);
        NormKid e3 = new NormKid(p1);
        
        m1.takeDamage(e1.getHealth());
        assertEquals(m1.getHealth(), 0);
        assertEquals(m1.isAlive(), false);

        m2.takeDamage(e2.getHealth());
        assertEquals(m2.getHealth(), 320);
        assertEquals(m2.isAlive(), true);
        m3.takeDamage(e3.getHealth());
        assertEquals(m2.getHealth(), 220);
        assertEquals(m2.isAlive(), true);
        m3.takeDamage(e3.getHealth());
        assertEquals(m2.getHealth(), 120);
        assertEquals(m2.isAlive(), true);
        m3.takeDamage(e3.getHealth());
        assertEquals(m2.getHealth(), 20);
        assertEquals(m2.isAlive(), true);
        m3.takeDamage(e3.getHealth());
        assertEquals(m2.getHealth(), -80);
        assertEquals(m2.isAlive(), false);

        m3.takeDamage(e3.getHealth());
        assertEquals(m3.getHealth(), -50);
        assertEquals(m3.isAlive(), false);
    }
    @Test
    public void jgEnemyDamageTest() {
    	NormKid testEnemy = new NormKid(new Path(0,0,0,0));
    	testEnemy.takeDamage(50);
    	Assert.assertFalse(testEnemy.checkHealth());
    	testEnemy.takeDamage(50);
    	Assert.assertTrue(testEnemy.checkHealth());
    }

    @Test
    public void jgEnemyPosTest() {
    	NormKid testEnemy = new NormKid(new Path(0,0,0,0));
    	double testArr[] = {0.0,0.0};
    	testEnemy.takeDamage(50);
    	Assert.assertArrayEquals(testEnemy.getPos(), testArr, 0);
    	testArr[0] = 1.0;
    	testArr[1] = 2.5;
    	testEnemy.setPos(testArr);
    	testEnemy.takeDamage(1);
    	Assert.assertArrayEquals(testEnemy.getPos(), testArr, 0);
    }

}
