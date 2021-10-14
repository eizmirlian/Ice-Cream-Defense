package application;

public class VanillaCatapult implements Tower {

    private int range;
    private int damage;
    private int fireRate;
    private static int price = 100;
    private static String description = "A catapult which launches scoops\nof vanilla ice cream at enemies!\nStandard damage and rate of\nfire, with a lot of range.";
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
