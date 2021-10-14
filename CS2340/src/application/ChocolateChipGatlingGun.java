package application;

public class ChocolateChipGatlingGun implements Tower {

    private int range;
    private int damage;
    private int fireRate;
    private static int price = 170;
    private static String description = "A gatling gun which shoots\na barrage of chocolate chips\nat enemies! Medium damage with\na high rate of fire and low range";
    @Override
    public void fire() {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkRange() {
        // TODO Auto-generated method stub

    }

    @Override
    public void upgrade() {
        // TODO Auto-generated method stub

    }
    public static String getDescription() {
        return description;
    }
    public static double getPrice(Difficulty diff) {
        switch (diff) {
            case EASY:
                return price * 1;
            case MEDIUM:
                return price * 1.2;
            case HARD:
                return price * 1.5;
        }
        return 0;
    }

}
