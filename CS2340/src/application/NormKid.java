package application;

import javafx.scene.image.ImageView;

public class NormKid implements Enemy {
    private int health;
    private double speed;
    private double[] pos;
    private Path curr;
    private ImageView icon = new ImageView();
    @Override
    public void move() {
        pos[0] = pos[0] + (curr.getNextPos()[0] * speed / GameLoop.getfps());
        pos[1] = pos[1] + (curr.getNextPos()[1] * speed / GameLoop.getfps());
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
    
}
