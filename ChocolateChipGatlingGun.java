package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChocolateChipGatlingGun extends Tower {
    
    private ImageView icon;
    private static String description = "A gatling gun which shoots\na barrage of"
            + " chocolate chips\nat enemies! Medium damage with"
            + "\na high rate of fire and low range";
    
    public ChocolateChipGatlingGun(Difficulty diff) {
        super(diff, description, 170, 0, 0, 0);
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
    @Override
    public ImageView getIcon() {
        this.icon = new ImageView(new Image("file:src/chocchipgatlinggun.png"));
        this.icon.setFitWidth(super.fitWidth);
        this.icon.setFitHeight(super.fitHeight);
        return this.icon;
    }

}
