package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VanillaCatapult implements Tower {

    private int range;
    private int damage;
    private int fireRate;
    private ImageView icon;
    private int price = 100;
    private Difficulty diff;
    private static String description = "A catapult which launches scoops\nof vanilla ice cream at enemies!\nStandard damage and rate of\nfire, with a lot of range.";
    
    public VanillaCatapult(Difficulty diff) {
        this.diff = diff;
    }
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

    @Override
    public void sell(){
        // TODO Auto-generated method stub
    }

    public String getDescription() {
        return description;
    }
    public double getPrice() {
        switch (this.diff) {
            case EASY:
                return price * 1;
            case MEDIUM:
                return price * 1.2;
            case HARD:
                return price * 1.5;
        }
        return 0;
    }
    public ImageView getIcon() {
        this.icon = new ImageView(new Image("file:src/vanillacatapult.png"));
        this.icon.setFitWidth(100);
        this.icon.setFitHeight(80);
        return this.icon;
    }
}
