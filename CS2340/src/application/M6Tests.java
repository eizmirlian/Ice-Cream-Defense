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
        assertEquals(testTower.getUpgradePrice(), price * 3 / 4);
    }    
    
    @Test
    public void eliasSpeedDiffTest() {
        Path p1 = new Path(0, 0, 0, 0);
        Enemy finBoss = new FinalBoss(p1, false);
        assertEquals(finBoss.getHealth(), 800);
    }
    
    @Test
    public void eliasDamageFinalBossTest() {
        Path p1 = new Path(0, 0, 0, 0);
        p1.setLastTile(true);
        FinalBoss finBoss = new FinalBoss(p1, false);

        assertEquals(finBoss.getHealth(), 800);

        finBoss.takeOnlyDamage(400);

        assertEquals(finBoss.getHealth(), 400);

        finBoss.takeOnlyDamage(400);

        assertEquals(finBoss.getHealth(), 0);
    } 

    @Test
    public void ethanTestUpgradeDamage() {
        Difficulty d1 = Difficulty.EASY;
        ChocolateChipGatlingGun t1 = new ChocolateChipGatlingGun(d1);
        WaffleConeLauncher t2 = new WaffleConeLauncher(d1);
        VanillaCatapult t3 = new VanillaCatapult(d1);

        assertEquals(t1.getFireRate(), 10);
        assertEquals(t1.getOnlyDamageOfTower(), 15);
        assertEquals(t2.getOnlyDamageOfTower(), 25);
        assertEquals(t3.getFireRate(), 1);

        t1.upgrade();
        t2.upgrade();
        t3.upgrade();

        assertEquals(t1.getFireRate(), 15);
        assertEquals(t1.getOnlyDamageOfTower(), 20);
        assertEquals(t2.getOnlyDamageOfTower(), 40);
        assertEquals(t3.getFireRate(), 1);
    }

    @Test
    public void ethanGoToWinScreenTest() {
        Path p1 = new Path(0, 0, 0, 0);
        p1.setLastTile(true);
        FinalBoss finBoss = new FinalBoss(p1, false);

        assertEquals(finBoss.getHealth(), 800);
        assertEquals(finBoss.goToWinScreen(), false);

        finBoss.takeOnlyDamage(800);

        assertEquals(finBoss.getHealth(), 0);
        assertEquals(finBoss.goToWinScreen(), true);

        finBoss.takeOnlyDamage(200);

        assertEquals(finBoss.getHealth(), -200);
        assertEquals(finBoss.goToWinScreen(), true);

    }

    @Test
    public void brandonFinalBossConstructorTest() {
        Path path = new Path(0, 0, 0, 0);
        path.setLastTile(true);
        FinalBoss finBoss = new FinalBoss(path, false);
        assertEquals(true, true);
    }

    @Test
    public void brandonPathConstructorTest() {
        Path p1 = new Path(0, 0, 0, 0);
        assertEquals(true, true);
    }
    
}