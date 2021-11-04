package application;

import javafx.scene.image.ImageView;

public abstract class Enemy {
    private int health;
    private double speed;
    private double[] pos = new double[2];
    private double[] prevPos = new double[2];
    private Path curr;
    private int id;
    private static int unitWidth;
    private static int unitHeight;
    
    public Enemy(int health, double speed) {
        this.health = health;
        this.speed = speed;
    }
    
    public double[] move() {
        double diffY = ((curr.getNextPos()[0]) * Enemy.unitHeight - prevPos[0]) * speed / GameLoop.getfps();
        double diffX = ((curr.getNextPos()[1]) * Enemy.unitWidth - prevPos[1]) * speed / GameLoop.getfps();
        pos[0] = pos[0] + diffY;
        pos[1] = pos[1] + diffX;
        boolean arrivedY = pos[0] >= curr.getNextPos()[0] * Enemy.unitHeight && pos[0] + this.getIcon().getFitHeight() <= (curr.getNextPos()[0] + 1) * Enemy.unitHeight;
        boolean arrivedX = pos[1] >= curr.getNextPos()[1] * Enemy.unitWidth && pos[1] + this.getIcon().getFitWidth() <= (curr.getNextPos()[1] + 1) * Enemy.unitWidth;
        if (arrivedX && arrivedY) {
            if (this.curr.getLastTile()) {
                ConfigEventHandler.getTruck().takeDamage(health);
                this.die();
            } else {
                prevPos[0] = pos[0];
                prevPos[1] = pos[1];
                this.curr = curr.getNext();
            }
        }
        return this.pos;
    }
    
    public void die() {
        GameLoop.getCurrWave().enemyDead(this.id);
        this.getIcon().setVisible(false);
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
        this.prevPos[0] = pos[0];
        this.prevPos[1] = pos[1];
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
