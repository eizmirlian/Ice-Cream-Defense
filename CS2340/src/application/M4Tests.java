package application;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class M4Tests {
    @Test
    public void ethanEnemyDeathTest() {
        Path p1 = new Path(0, 0, 0, 0);
        p1.setLastTile(true);
        NormKid e1 = new NormKid(p1);
        NormKid e2 = new NormKid(p1);
        NormKid e3 = new NormKid(p1);
    
        assertEquals(el.checkDeath(), false);
        assertEquals(e2.checkDeath(), false);
        assertEquals(e3.checkDeath(), false);
        e1.takeDamage(100);
        assertEquals(el.checkDeath(), true);
        e1.takeDamage(100);
        assertEquals(el.checkDeath(), true);
    
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

}
