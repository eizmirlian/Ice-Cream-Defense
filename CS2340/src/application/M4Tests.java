package application;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class M3Tests {
    @Test
    //This test tests an enemy’s conditions for death, either being that they have no more health or if they attack the monument they will be deleted. 
    //This is important because we need to ensure that once the ability for towers to attack enemies is correctly implemented, 
    //these enemies will die/be deleted given the correct commands to ensure that they function as intended.
    public void ethanEnemyDeathTest() {
    	
    }
    
    @Test
    //This test tests an enemy’s conditions for death, either being that they have no more health or if they attack the monument they will be deleted. 
    //This is important because we need to ensure that once the ability for towers to attack enemies is correctly implemented, 
    //these enemies will die/be deleted given the correct commands to ensure that they function as intended.
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
