package application;

import javafx.scene.image.ImageView;

public class NormKid extends Enemy {
    
    private ImageView icon = new ImageView("file:src/truck.png");
    
    public NormKid(Path entry) {
        super(100, 1.0);
        this.icon.setFitWidth(super.getUnitWidth());
        this.icon.setFitHeight(super.getUnitHeight());
        double[] pos = new double[2];
        if (entry.getPos()[0] == 0) {
            pos[0] = (entry.getPos()[0] * super.getUnitHeight()) - (super.getUnitHeight() / 2);
        } else if (entry.getPos()[0] == (Level.getScreenHeight() / super.getUnitHeight() - 1)) {
            pos[0] = (entry.getPos()[0] * super.getUnitHeight()) + (super.getUnitHeight() * 1.5);
        } else {
            pos[0] = (entry.getPos()[0] * super.getUnitHeight()) + (super.getUnitHeight() / 2);
        } if (entry.getPos()[1] == 0) {
            pos[1] = (entry.getPos()[1] * super.getUnitWidth()) - (super.getUnitWidth() / 2);
        } else if (entry.getPos()[1] == (Level.getScreenWidth() / super.getUnitWidth() - 1)) {
            pos[1] = (entry.getPos()[1] * super.getUnitWidth()) + (super.getUnitWidth() * 1.5);
        } else {
            pos[1] = (entry.getPos()[1] * super.getUnitWidth()) + (super.getUnitWidth() / 2);
        }
        super.setPos(pos);
        Path preEntry = new Path(0, 0, 0, 0);
        preEntry.setNext(entry);
        super.setCurr(preEntry);
    }
    
    
    @Override
    public void move() {
        super.move();
        icon.setY(super.getPos()[0]);
        icon.setX(super.getPos()[1]);
        
    }

    @Override
    public void die() {
        // TODO Auto-generated method stub
        
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
