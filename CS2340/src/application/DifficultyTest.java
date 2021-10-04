import org.junit.Test;
import org.junit.Assert;

public class DifficultyTest {

    private final int defaultHealth = 100;
    private final int defaultMoney = 1000;

    public double jgDifFactorTest(int diff) {
        if (diff == 1) {
            return 1.0;
        } else if (diff == 2) {
            return 0.8;
        } else if (diff == 3) {
            return 0.5;
        } else {
            throw new IllegalArgumentException("Invalid Input Value for Difficulty");
        }
    }

    @Test(timeout = 200)
    public void jgDiffTest() {
        Assert.assertEquals((int) (defaultHealth * jgDifFactorTest(1)), 100);
        Assert.assertEquals((int) (defaultMoney * jgDifFactorTest(1)), 1000);
        Assert.assertEquals((int) (defaultHealth * jgDifFactorTest(2)), 80);
        Assert.assertEquals((int) (defaultMoney * jgDifFactorTest(2)), 800);
        Assert.assertEquals((int) (defaultHealth * jgDifFactorTest(2)), 50);
        Assert.assertEquals((int) (defaultMoney * jgDifFactorTest(2)), 500);
    }
}