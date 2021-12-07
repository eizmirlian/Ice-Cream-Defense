package application;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class M6Tests {
    @Test
    public void jgIsUpgradedTest() {
    	Tower testTower = new VanillaCatapult(Difficulty.EASY);
    	assertEquals(testTower.checkUpgrade(), false);
    	testTower.upgrade();
    	assertEquals(testTower.checkUpgrade(), true);
    }

    
    @Test
    public void jgUpgradePriceTest() {
    	Tower testTower = new VanillaCatapult(Difficulty.EASY);
    	double price = testTower.getPrice();
    	assertEquals(testTower.getUpgradePrice(), price * 3/4);
    }    
    
    @Test
    public void eliasSpeedDiffTest() {
        Path p1 = new Path(0, 0, 0, 0);
    	Enemy finBoss = new FinalBoss(p1, false);
    	assertEquals(finBoss.getHealth(), 800);
    }
	
	
	
}