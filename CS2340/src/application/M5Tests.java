package application;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class M5Tests {
    @Test
    public void eliasDiffMoneyOnEnemyDeathTest() {
        
    }
    
    @Test
    public void jgEnemyDamageTest() {
        
    }
    
    @Test
    public void jgEnemyDiffDamageTest() {
        
    }
    
    @Test
    public void ethanOnDeathAddMoneyTest() {
    	Path p1 = new Path(0, 0, 0, 0);
        p1.setLastTile(true);
        NormKid e1 = new NormKid(p1, false);
        Monument m1 = new Monument(100, 100);
        Difficulty d1 = Difficulty.EASY;
        Tower t1 = new Tower(d1, "test", 10, 10, 100, 10);
        e1.takeDamage(t1.getDamage());
        m1.gainMoney(100);
        assertEquals(e1.checkDeath(), true);
        assertEquals(m1.getMoney(), 200);
    }
    
    @Test
    public void ethanTestDifferentTowerAttributes() {
    	Difficulty d1 = Difficulty.EASY;
    	ChocolateChipGatlingGun t1 = new ChocolateChipGatlingGun(d1);
    	WaffleConeLauncher t2 = new WaffleConeLauncher(d1);
    	VanillaCatapult t3 = new VanillaCatapult(d1);
    	assertEquals(t1.getPrice(), 170);
    	assertEquals(t1.getDamage(), 10);
    	assertEquals(t1.getFireRate(), 5);
    	
    	assertEquals(t2.getPrice(), 150);
    	assertEquals(t2.getDamage(), 100);
    	assertEquals(t2.getFireRate(), .5);
    	
    	assertEquals(t2.getPrice(), 100);
    	assertEquals(t2.getDamage(), 25);
    	assertEquals(t2.getFireRate(), 1);
    }
    
    public void eliasSpeedDiffTest() {
        Enemy enemy1 = new Enemy(50, 20.0);
        Enemy enemy2 = new Enemy(30, 30.0);
        assertEquals(enemy1.getSpeed() == enemy2.getSpeed(), false);
    }

    @Test
    public void brandonEnemyDamageTest() {
        Enemy enemy1 = new Enemy(50, 20.0);
        Enemy enemy2 = new Enemy(30, 30.0);
        enemy1.takeDamage(10);
        enemy2.takeDamage(20);
        assertEquals(enemy1.getHealth(), 40);
        assertEquals(enemy2.getHealth(), 10);
    }

    @Test
    public void brandonMonumentIsAliveTest() {
        Monument monument = new Monument(30, 30);
        monument.takeDamage(40);
        assertEquals(monument.isAlive(), false);
    }
}
