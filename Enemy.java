package application;

import javafx.scene.image.ImageView;

public abstract class Enemy {
    private int health;
    private double speed;
    private double[] pos = new double[2];
    private Path curr;
    private int id;
    private static int unitWidth;
    private static int unitHeight;
    
    public Enemy(int health, double speed) {
        this.health = health;
        this.speed = speed;
    }
    
    public void move() {
        double diffY = (curr.getNextPos()[0] + .5) * Enemy.unitHeight - pos[0];
        double diffX = (curr.getNextPos()[1] + .5) * Enemy.unitWidth - pos[0];
        pos[0] = pos[0] + diffY * speed / GameLoop.getfps();
        pos[1] = pos[1] + diffX * speed / GameLoop.getfps();
    }
    
    public void die() {
        
    }
    
    public boolean checkHealth() {
        if (health <= 0) {
            this.die();
            return true;
        }
        return false;
    }
    
    public int getUnitWidth() {
        return Enemy.unitWidth;
    }
    
    public int getUnitHeight() {
        return Enemy.unitHeight;
    }
    
    public double[] getPos() {
        return this.pos;
    }
    
    public void setPos(double[] pos) {
        this.pos[0] = pos[0];
        this.pos[1] = pos[1];
    }
    
    public void setCurr(Path curr) {
        this.curr = curr;
    }
    
    public int getID() {
        return this.id;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public static void setUnitWidth(int unitWidth) {
        Enemy.unitWidth = unitWidth;
    }
    
    public static void setUnitHeight(int unitHeight) {
        Enemy.unitHeight = unitHeight;
    }

    public abstract ImageView getIcon();
}
