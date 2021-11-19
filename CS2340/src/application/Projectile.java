package application;

import javafx.scene.image.ImageView;

public class Projectile {
    private Enemy target;
    private double[] pos = new double[2];
    private ImageView icon;
    private int projectileSpeed;
    private int damage;
    private double[] startingPos = new double[2];
    private boolean hit = false;
    private int fitHeight;
    private int fitWidth;
    
    public Projectile(Enemy target, double[] pos, ImageView icon, 
            int projectileSpeed, int damage, int fitWidth, int fitHeight) {
        this.target = target;
        this.pos[0] = pos[0];
        this.pos[1] = pos[1];
        this.startingPos[0] = pos[0];
        this.startingPos[1] = pos[1];
        this.icon = icon;
        this.projectileSpeed = projectileSpeed;
        this.damage = damage;
        icon.setLayoutX(pos[1]);
        icon.setLayoutY(pos[0]);
        this.fitHeight = fitHeight;
        this.fitWidth = fitWidth;
        icon.setFitHeight(fitHeight);
        icon.setFitWidth(fitWidth);
    }
    
    public double[] move() {
        double diffY = (target.getPos()[0] - startingPos[0])
                * projectileSpeed / GameLoop.getfps();
        double diffX = (target.getPos()[1] - startingPos[1])
                * projectileSpeed / GameLoop.getfps();
        pos[0] = pos[0] + diffY;
        pos[1] = pos[1] + diffX;
        boolean arrivedY = pos[0] + fitHeight >= target.getPos()[0]  
                && pos[0] <= target.getPos()[0] + target.getIcon().getFitHeight();
        boolean arrivedX = pos[1] + fitWidth >= target.getPos()[1]  
                && pos[1] <= target.getPos()[1] + target.getIcon().getFitWidth();
        if (arrivedX && arrivedY) {
            this.hit = true;
            target.takeDamage(this.damage);
        }
        return this.pos;
    }
    
    public double[] getPos() {
        return this.pos;
    }
    
    public boolean finished() {
        return this.hit;
    }
    
    public ImageView getIcon() {
        return this.icon;
    }
}
