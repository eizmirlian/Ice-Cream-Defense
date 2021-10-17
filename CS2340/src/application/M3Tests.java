package application;
import org.junit.Test;
import org.junit.Assert;

public class M3Tests {



    @Test
    public void waffleConePriceTest () {
        WaffleConeLauncher waffle = new WaffleConeLauncher(Difficulty.EASY);
        WaffleConeLauncher waffle2 = new WaffleConeLauncher(Difficulty.MEDIUM);
        WaffleConeLauncher waffle3 = new WaffleConeLauncher(Difficulty.HARD);
        Assert.assertEquals(150, waffle.getPrice());
        Assert.assertEquals(180, waffle2.getPrice());
        Assert.assertEquals(225, waffle3.getPrice());
    }

    @Test
    public void monumentHealthAndMoneyTest() {
        Monument monument = new Monument(1000, 100);
        Assert.assertEquals(1000, monument.getHealth());
        Assert.assertEquals(100, monument.getMoney());
        monument.takeDamage(100);
        Assert.assertEquals(100, monument.getHealth());
        monument.buy(50);
        Assert.assertEquals(50, monument.getMoney());
    }

}