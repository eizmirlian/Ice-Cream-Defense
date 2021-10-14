package application;

public class WaffleConeLauncher implements Tower {

    private int range;
    private int damage;
    private int fireRate;
    private static int price = 150;
    private static String description = "A rocket launcher which fires\nwaffle cone rockets at enemies!\nHigh damage output with a low\nrate of fire and medium range.";
    
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
