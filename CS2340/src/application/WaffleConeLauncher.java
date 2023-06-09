package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WaffleConeLauncher extends Tower {

    private static String description = "A rocket launcher which fires\nwaffle cone rockets"
            + " at enemies!\nHigh damage output with a low\nrate of fire and medium range.";
    private ImageView icon;
    
    public WaffleConeLauncher(Difficulty diff) {
        super(diff, description, 150, 0, 0, 0);
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
    public void sell() {
        // TODO Auto-generated method stub
    }

    public String getDescription() {
        return description;
    }
    @Override
    public ImageView getIcon() {
        this.icon = new ImageView(new Image("file:src/waffleconelauncher.png"));
        this.icon.setFitWidth(super.fitWidth);
        this.icon.setFitHeight(super.fitHeight);
        return this.icon;
    }
}
