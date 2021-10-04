package application;
import org.junit.Test;
import org.junit.Assert;

public class DifficultyTest {

    private final int defaultHealth = 100;
    private final int defaultMoney = 1000;

    public double jgDifFactorTest(Difficulty diff) {
        if (diff == Difficulty.EASY) {
            return 1.0;
        } else if (diff == Difficulty.MEDIUM) {
            return 0.8;
        } else if (diff == Difficulty.HARD) {
            return 0.5;
        }
        return 0;
    }

    @Test
    public void jgDiffTest() {
        Assert.assertEquals((int) (defaultHealth * jgDifFactorTest(Difficulty.EASY)), 100);
        Assert.assertEquals((int) (defaultMoney * jgDifFactorTest(Difficulty.EASY)), 1000);
        Assert.assertEquals((int) (defaultHealth * jgDifFactorTest(Difficulty.MEDIUM)), 80);
        Assert.assertEquals((int) (defaultMoney * jgDifFactorTest(Difficulty.MEDIUM)), 800);
        Assert.assertEquals((int) (defaultHealth * jgDifFactorTest(Difficulty.HARD)), 50);
        Assert.assertEquals((int) (defaultMoney * jgDifFactorTest(Difficulty.HARD)), 500);
    }
}