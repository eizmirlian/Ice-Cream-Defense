package application;

import javafx.scene.image.ImageView;

public class HeavyKid extends Enemy{
private ImageView icon;
    
    public HeavyKid(Path entry, boolean f) {
        super(300, 1, entry);
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
    
}
