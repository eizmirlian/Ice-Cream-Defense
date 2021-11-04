package application;

import javafx.scene.image.ImageView;

public class NormKid extends Enemy {
    
    private ImageView icon = new ImageView("file:src/enemyNormKid.png");
    
    public NormKid(Path entry) {
        super(100, 3.0);
        this.icon.setFitWidth(super.getUnitWidth());
        this.icon.setFitHeight(super.getUnitHeight());
        double[] pos = new double[2];
        if (entry.getPos()[0] == 0) {
            pos[0] = (entry.getPos()[0] * super.getUnitHeight()) - (super.getUnitHeight());
        } else if (entry.getPos()[0] == (Level.getScreenHeight() / super.getUnitHeight() - 1)) {
            pos[0] = (entry.getPos()[0] * super.getUnitHeight()) + (super.getUnitHeight() * 1.5);
        } else {
            pos[0] = (entry.getPos()[0] * super.getUnitHeight());
        } if (entry.getPos()[1] == 0) {
            pos[1] = (entry.getPos()[1] * super.getUnitWidth()) - (super.getUnitWidth());
        } else if (entry.getPos()[1] == (Level.getScreenWidth() / super.getUnitWidth() - 1)) {
            pos[1] = (entry.getPos()[1] * super.getUnitWidth()) + (super.getUnitWidth() * 1.5);
        } else {
            pos[1] = (entry.getPos()[1] * super.getUnitWidth());
        }
        super.setPos(pos);
        Path preEntry = new Path(entry.getPos()[0], entry.getPos()[1], entry.getPos()[0], entry.getPos()[1]);
        preEntry.setNext(entry);
        super.setCurr(preEntry);
        icon.setManaged(false);
        icon.setLayoutX(super.getPos()[1]);
        icon.setLayoutY(super.getPos()[0]);
    }
    
    @Override
    public boolean checkHealth() {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public ImageView getIcon() {
        return icon;
    }
    
}
