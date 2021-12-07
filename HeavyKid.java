package application;

import javafx.scene.image.ImageView;

public class HeavyKid extends Enemy {
    private ImageView icon;
    
    public HeavyKid(Path entry, boolean f) {
        super(300, 2, entry);
        if (f) {
            icon = new ImageView("file:src/enemyHeavyKid.png");
            icon.setManaged(false);
            icon.setLayoutX(super.getPos()[1]);
            icon.setLayoutY(super.getPos()[0]);
            this.icon.setFitWidth(super.getUnitWidth());
            this.icon.setFitHeight(super.getUnitHeight());
        }
    }

    @Override
    public ImageView getIcon() {
        return icon;
    }



    @Override
    public void giveMoney() {
        ConfigEventHandler.getTruck().gainMoney(50);
    }
    
}
