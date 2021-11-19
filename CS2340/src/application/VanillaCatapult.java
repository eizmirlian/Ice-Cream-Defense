package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VanillaCatapult extends Tower {

    private ImageView icon;
    private static String description = "A catapult which launches scoops\nof vanilla "
            + "ice cream at enemies!\nStandard damage and rate of\nfire, with a lot of range.";
    
    public VanillaCatapult(Difficulty diff) {
        super(diff, description, 100, 3, 30, 1);
    }
    @Override
    public Projectile fire() {
        System.out.println("fired");
        ImageView pIcon = new ImageView(new Image("file:src/vanillacatapult.png"));
        return super.fire(pIcon, 10, super.fitWidth / 3, super.fitHeight / 3);
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

    public ImageView getIcon() {
        this.icon = new ImageView(new Image("file:src/vanillacatapult.png"));
        this.icon.setFitWidth(super.fitWidth);
        this.icon.setFitHeight(super.fitHeight);
        return this.icon;
    }
}
