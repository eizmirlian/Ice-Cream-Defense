package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class M5Tests {
    @Test
    public void eliasDiffMoneyOnEnemyDeathTest() {
        Path p1 = new Path(0, 0, 0, 0);
        p1.setLastTile(true);
        Enemy normKid = new NormKid(p1, false);
        Monument m1 = new Monument(100, 100);
        Enemy heavKid = new HeavyKid(p1, false);
        normKid.takeOnlyDamage(1000);
        m1.gainMoney(25);
        assertEquals(m1.getMoney(), 125.0);
        heavKid.takeOnlyDamage(1000);
        m1.gainMoney(50);
        assertEquals(m1.getMoney(), 175.0);
    }

    @Test
    public void jgEnemyDamageTest() {
        Path p1 = new Path(0, 0, 0, 0);
        p1.setLastTile(true);
        Difficulty d1 = Difficulty.EASY;
        Enemy normKid = new NormKid(p1, false);
        Tower t1 = new Tower(d1, "test", 10, 10, 100, 10);
        normKid.takeOnlyDamage(t1.getDamage());
        Assert.assertEquals(normKid.checkDeath(), true);
    }

    @Test
    public void jgEnemyDiffDamageTest() {
        Path p1 = new Path(0, 0, 0, 0);
        p1.setLastTile(true);
        Enemy normKid = new NormKid(p1, false);
        Enemy heavKid = new HeavyKid(p1, false);
        Assert.assertEquals(normKid.getHealth(), 100);
        Assert.assertEquals(heavKid.getHealth(), 300);
    }

    @Test
    public void ethanOnDeathAddMoneyTest() {
        Path p1 = new Path(0, 0, 0, 0);
        p1.setLastTile(true);
        Enemy e1 = new NormKid(p1, false);
        Monument m1 = new Monument(100, 100);
        Difficulty d1 = Difficulty.EASY;
        Tower t1 = new Tower(d1, "test", 10, 10, 100, 10);
        e1.takeOnlyDamage(t1.getDamage());
        m1.gainMoney(100);
        assertEquals(e1.checkDeath(), true);
        assertEquals(m1.getMoney(), 200);
    }

    @Test
    public void ethanTestDifferentTowerAttributes() {
        Difficulty d1 = Difficulty.EASY;
        ChocolateChipGatlingGun t1 = new ChocolateChipGatlingGun(d1);
        WaffleConeLauncher t2 = new WaffleConeLauncher(d1);
        assertEquals(t1.getPrice(), 170);
        assertEquals(t1.getDamage(), 10);
        assertEquals(t1.getFireRate(), 8);

        assertEquals(t2.getPrice(), 150);
        assertEquals(t2.getDamage(), 100);
        assertEquals(t2.getFireRate(), .5);
    }
    public void eliasSpeedDiffTest() {
        Path p1 = new Path(0, 0, 0, 0);
        p1.setLastTile(true);
        Enemy enemy1 = new NormKid(p1, 5, false);
        Enemy enemy2 = new NormKid(p1, 4, false);
        assertEquals(enemy1.getSpeed() == enemy2.getSpeed(), false);
    }

    @Test
    public void brandonEnemyDamageTest() {
        Path p1 = new Path(0, 0, 0, 0);
        p1.setLastTile(true);
        NormKid enemy1 = new NormKid(p1, false);
        NormKid enemy2 = new NormKid(p1, false);
        enemy1.takeOnlyDamage(10);
        enemy2.takeOnlyDamage(20);
        assertEquals(enemy1.getHealth(), 90);
        assertEquals(enemy2.getHealth(), 80);
    }

    @Test
    public void brandonMonumentIsAliveTest() {
        Monument monument = new Monument(30, 30);
        monument.takeDamage(40);
        assertEquals(monument.isAlive(), false);
    }
}
