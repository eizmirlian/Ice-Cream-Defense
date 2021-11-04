package application;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class M4Tests {
    @Test
    //This test tests an enemy�s conditions for death, either being that they have no more health or if they attack the monument they will be deleted. 
    //This is important because we need to ensure that once the ability for towers to attack enemies is correctly implemented, 
    //these enemies will die/be deleted given the correct commands to ensure that they function as intended.
    public void ethanEnemyDeathTest() {
    	
    }
    
    @Test
    public void ethanEnemyAttackMonumentTest() {
    	
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
