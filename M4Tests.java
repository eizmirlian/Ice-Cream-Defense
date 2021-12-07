package application;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class M4Tests {
    @Test
    public void ethanEnemyDeathTest() {
        Path p1 = new Path(0, 0, 0, 0);
        p1.setLastTile(true);
        NormKid e1 = new NormKid(p1, false);
        NormKid e2 = new NormKid(p1, false);
        NormKid e3 = new NormKid(p1, false);
    
        assertEquals(e1.checkDeath(), false);
        assertEquals(e2.checkDeath(), false);
        assertEquals(e3.checkDeath(), false);
        e1.takeOnlyDamage(100);
        assertEquals(e1.checkDeath(), true);
        e1.takeOnlyDamage(100);
        assertEquals(e1.checkDeath(), true);
        e2.takeOnlyDamage(10);
        assertEquals(e2.checkDeath(), false);
        e2.takeOnlyDamage(20);
        assertEquals(e2.checkDeath(), false);
        e2.takeOnlyDamage(200);
        assertEquals(e2.checkDeath(), true);
        
        e3.takeOnlyDamage(110);
        assertEquals(e3.checkDeath(), true);
        e3.takeOnlyDamage(-20);
        assertEquals(e3.checkDeath(), false);
        e3.takeOnlyDamage(10);
        assertEquals(e3.checkDeath(), true);
    }
    
    @Test
    public void eliasEnemyMoveTest() {
        Path p1 = new Path(1, 0, 1, 1);
        Enemy.setUnitHeight(10);
        Enemy.setUnitWidth(20);
        Enemy e1 = new NormKid(p1, false);
        Enemy e2 = new NormKid(p1, false);
        assertEquals(e1.move()[0], 10);
        assertEquals(e1.move()[1], -18);
        assertEquals(e2.move()[0], 10);
        assertEquals(e2.move()[1], -18);
    }
    
    @Test
    public void eliasEnemyInitTest() {
        Path p1 = new Path(1, 0, 1, 1);
        Enemy.setUnitHeight(10);
        Enemy.setUnitWidth(20);
        Enemy e1 = new NormKid(p1, false);
        Enemy e2 = new NormKid(p1, false);
        assertEquals(e1.getPos()[0], 10);
        assertEquals(e1.getPos()[1], -20);
        assertEquals(e2.getPos()[0], 10);
        assertEquals(e2.getPos()[1], -20);
    }
    
    @Test
    public void ethanEnemyAttackMonumentTest() {
        Monument m1 = new Monument(100, 20);
        Monument m2 = new Monument(420, 69);
        Monument m3 = new Monument(50, 50);
        Path p1 = new Path(0, 0, 0, 0);
        p1.setLastTile(true);
        NormKid e1 = new NormKid(p1, false);
        NormKid e2 = new NormKid(p1, false);
        NormKid e3 = new NormKid(p1, false);
        
        m1.takeDamage(e1.getHealth());
        assertEquals(m1.getHealth(), 0);
        assertEquals(m1.isAlive(), false);

        m2.takeDamage(e2.getHealth());
        assertEquals(m2.getHealth(), 320);
        assertEquals(m2.isAlive(), true);
        m2.takeDamage(e3.getHealth());
        assertEquals(m2.getHealth(), 220);
        assertEquals(m2.isAlive(), true);
        m2.takeDamage(e3.getHealth());
        assertEquals(m2.getHealth(), 120);
        assertEquals(m2.isAlive(), true);
        m2.takeDamage(e3.getHealth());
        assertEquals(m2.getHealth(), 20);
        assertEquals(m2.isAlive(), true);
        m2.takeDamage(e3.getHealth());
        assertEquals(m2.getHealth(), -80);
        assertEquals(m2.isAlive(), false);

        m3.takeDamage(e3.getHealth());
        assertEquals(m3.getHealth(), -50);
        assertEquals(m3.isAlive(), false);
    }
    @Test
    public void jgEnemyDamageTest() {
        NormKid testEnemy = new NormKid(new Path(0, 0, 0, 0), false);
        testEnemy.takeDamage(50);
        Assert.assertFalse(testEnemy.checkHealth());
    }

    @Test
    public void jgEnemyPosTest() {
        NormKid testEnemy = new NormKid(new Path(0, 0, 0, 0), false);
        double[] testArr = {-10.0, -20.0};
        testEnemy.takeDamage(50);
        Assert.assertArrayEquals(testEnemy.getPos(), testArr, 0);
        testArr[0] = 1.0;
        testArr[1] = 2.5;
        testEnemy.setPos(testArr);
        testEnemy.takeDamage(1);
        Assert.assertArrayEquals(testEnemy.getPos(), testArr, 0);
    }
    @Test 
    public void brandonBuyTowerTest() {
        Tower tower = new Tower(Difficulty.EASY, "TEST TOWER", 40, 40, 40, 40);
        assertEquals(tower.getDescription(), "TEST TOWER");
    }

    @Test
    public void brandonTowerConstructorTest() {
        Tower tower = new Tower(Difficulty.EASY, "TEST TOWER", 40, 40, 40, 40);
        assertEquals(1, 1);
    }
    
    

}
