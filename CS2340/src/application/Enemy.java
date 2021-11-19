package application;

import javafx.scene.effect.ColorAdjust;
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
    
    public Enemy(int health, double speed, Path entry) {
        this.health = health;
        this.speed = speed;
        if (entry.getPos()[0] == 0) {
            pos[0] = (entry.getPos()[0] - 1) * unitHeight;
        } else if (entry.getPos()[0] == (Level.getScreenHeight() / unitHeight - 1)) {
            pos[0] = (entry.getPos()[0] + 1.5) * unitHeight;
        } else {
            pos[0] = entry.getPos()[0] * unitHeight;
        }
        if (entry.getPos()[1] == 0) {
            pos[1] = (entry.getPos()[1] - 1) * unitWidth;
        } else if (entry.getPos()[1] == (Level.getScreenWidth() / unitWidth - 1)) {
            pos[1] = (entry.getPos()[1] + 1.5) * unitWidth;
        } else {
            pos[1] = entry.getPos()[1] * unitWidth;
        }
        this.setPos(pos);
        Path preEntry = new Path(entry.getPos()[0], entry.getPos()[1], 
                entry.getPos()[0], entry.getPos()[1]);
        preEntry.setNext(entry);
        curr = preEntry;
    }
    
    public double[] move() {
        double diffY = ((curr.getNextPos()[0]) * Enemy.unitHeight - prevPos[0]) 
                * speed / GameLoop.getfps();
        double diffX = ((curr.getNextPos()[1]) * Enemy.unitWidth - prevPos[1]) 
                * speed / GameLoop.getfps();
        pos[0] = pos[0] + diffY;
        pos[1] = pos[1] + diffX;
        boolean arrivedY = pos[0] + 5 >= curr.getNextPos()[0] * Enemy.unitHeight
                && pos[0] + unitHeight - 5
                <= (curr.getNextPos()[0] + 1) * Enemy.unitHeight;
        boolean arrivedX = pos[1] + 5 >= curr.getNextPos()[1] * Enemy.unitWidth
                && pos[1] + unitWidth - 5
                <= (curr.getNextPos()[1] + 1) * Enemy.unitWidth;
        if (arrivedX && arrivedY) {
            if (this.curr.getLastTile()) {
                ConfigEventHandler.getTruck().takeDamage(health);
                this.die();
            } else {
                this.curr.leave();
                prevPos[0] = pos[0];
                prevPos[1] = pos[1];
                this.curr = curr.getNext();
                this.curr.enter(this);
            }
        }
        return this.pos;
    }
    
    public void die() {
        this.getIcon().setVisible(false);
        GameLoop.getCurrWave().enemyDead(this.id);
        this.curr.leave();
        this.giveMoney();
    }
    
    public boolean checkHealth() {
        if (health <= 0) {
            this.die();
            return true;
        }
        return false;
    }
    
    public void takeDamage(int damage) {
        health -= damage;
        ColorAdjust monochrome = new ColorAdjust();
        //monochrome.setSaturation(-1.0);
        monochrome.setHue(.5);
        
        ImageView icon = this.getIcon();
        icon.setEffect(monochrome);
        checkHealth();
    }
    
    public boolean checkDeath() {
        return health <= 0; 
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
    
    public int getHealth() {
        return this.health;
    }
    
    public void takeOnlyDamage(int damage) {
        this.health -= damage;
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
    
    public double getSpeed() {
        return this.speed;
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
    
    public abstract void giveMoney();
}
