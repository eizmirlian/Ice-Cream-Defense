package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WaffleConeLauncher implements Tower {

    private int range;
    private int damage;
    private int fireRate;
    private int price = 150;
    private ImageView icon;
    private String description = "A rocket launcher which fires\nwaffle cone rockets at enemies!\nHigh damage output with a low\nrate of fire and medium range.";
    private Difficulty diff;
    
    public WaffleConeLauncher(Difficulty diff) {
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
        this.icon = new ImageView(new Image("file:src/truck.png"));
        this.icon.setFitWidth(100);
        this.icon.setFitHeight(80);
        return this.icon;
    }
}
