package application;

import javafx.scene.image.ImageView;

public class FinalBoss extends Enemy {
    
    private ImageView icon;
    private int phase = 1;

    public FinalBoss(Path entry, boolean f) {
        super(800, 1, entry);
        if (f) {
            icon = new ImageView("file:src/finalBoss.png");
            icon.setManaged(false);
            icon.setLayoutX(super.getPos()[1]);
            icon.setLayoutY(super.getPos()[0]);
            this.icon.setFitWidth(super.getUnitWidth());
            this.icon.setFitHeight(super.getUnitHeight());
        }
    }
    
    @Override
    public double[] move() {
        if (super.getHealth() < (800 - this.phase * 200)) {
            super.doubleSpeed();
            this.phase++;
        }
        return super.move();
    }

    @Override
    public ImageView getIcon() {
        return icon;
    }

    @Override
    public void giveMoney() {
        GameLoop.getInstance().win();
    }

    public boolean goToWinScreen() {
        return this.getHealth() <= 0;
    }

}
