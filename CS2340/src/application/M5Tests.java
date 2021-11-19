package application;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class M5Tests {
    @Test
    public void ethanEnemyDeathTest() {
        
    }
    
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
        
    }
    
    @Test
    public void ethanTestDifferentTowerAttributes() {
        
    }
    
    @Test
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
