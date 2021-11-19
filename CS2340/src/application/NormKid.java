package application;

import javafx.scene.image.ImageView;

public class NormKid extends Enemy {
    
    private ImageView icon;
    
    public NormKid(Path entry, boolean f) {
        super(100, 3, entry);
        if (f) {
            icon = new ImageView("file:src/enemyNormKid.png");
            icon.setManaged(false);
            icon.setLayoutX(super.getPos()[1]);
            icon.setLayoutY(super.getPos()[0]);
            this.icon.setFitWidth(super.getUnitWidth());
            this.icon.setFitHeight(super.getUnitHeight());
        }
    }
    
    public NormKid(Path entry, int speed, boolean f) {
        super(100, speed, entry);
        if (f) {
            icon = new ImageView("file:src/enemyNormKid.png");
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
        ConfigEventHandler.getTruck().gainMoney(25);
    }
    
}
