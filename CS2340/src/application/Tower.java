package application;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class Tower {
    private String description;
    private Difficulty diff;
    private int price;
    private int range;
    private int damage;
    private double fireRate;
    private boolean upgraded;
    protected int fitWidth = 88;
    protected int fitHeight = 70;
    private ImageView icon;
    private Grass location;
    private static Path[][] allPaths;
    private static Group g;
    private ArrayList<Path> pathInRange = new ArrayList<Path>();
    private LinkedList<Enemy> enemiesInRange = new LinkedList<Enemy>();
    private Enemy targeted;
    
    public Tower(Difficulty diff, String description, int price, int range,
            int damage, double fireRate) {
        this.diff = diff;
        this.description = description;
        this.price = price;
        this.range = range;
        this.damage = damage;
        this.fireRate = fireRate;
    }
    
    public Projectile fire() {
        return null;
    }
    
    public Projectile fire(ImageView icon, int projectileSpeed, int pFitWidth, int pFitHeight) {
        double[] temp = new double[2];
        temp[0] = (location.getPos()[0] + 1) * fitHeight;
        temp[1] = (location.getPos()[1] + 1) * fitWidth;
        Projectile p = new Projectile(targeted, temp, icon, projectileSpeed, 
            damage, pFitWidth, pFitHeight);
        Tower.g.getChildren().add(icon);
        return p;
        
    }
    public void checkRange() {
        int effectiveRange = this.range * 2 + 1;
        int upperLeftX = this.location.getPos()[1] - this.range;
        int upperLeftY = this.location.getPos()[0] - this.range;
        int i = 0;
        int j;
        while (i < effectiveRange) {
            j = 0;
            while (j < effectiveRange) {
                int xCoord = upperLeftX + i;
                int yCoord = upperLeftY + j;
                if (xCoord >= 0 && yCoord >= 0 && xCoord < allPaths[0].length 
                    && yCoord < allPaths.length) {
                    Path p = allPaths[upperLeftY + j][upperLeftX + i];
                    if (p != null) {
                        p.addTower(this);
                        pathInRange.add(p);
                    }
                }
                j++;
            }
            i++;
        }
    }
    public void upgrade() {
        this.upgraded = true;
    }

    public void sell() {
        
    }
    
    public void addEnemy(Enemy e) {
        this.enemiesInRange.add(e);
        if (this.targeted == null) {
            this.targeted = e;
        }
    }
    
    public void removeEnemy(Enemy e) {
        this.enemiesInRange.remove(e);
        if (this.targeted == e) {
            this.targeted = null;
        }
    }
    
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        switch (this.diff) {
        case EASY:
            return price * 1;
        case MEDIUM:
            return price * 1.2;
        case HARD:
            return price * 1.5;
        default:
            return 0;
        }
    }
    
    public ImageView getIcon() {
        return icon;
    }
    
    public void setGrass(Grass g) {
        this.location = g;
    }
    
    public double getFireRate() {
        return this.fireRate;
    }
    
    public static void allPaths(Path[][] allPaths) {
        Tower.allPaths = allPaths;
    }
    
    public static void setSpritesGroup(Group g) {
        Tower.g = g;
    }
    
    public boolean targeting() {
        return this.targeted != null;
    }
    
    public boolean checkUpgrade() {
        return this.upgraded;
    }

    public int getOnlyDamageOfTower() {
        return this.damage;
    }
    
    protected void setFireRate(double f) {
        this.fireRate = f;
    }
    
    protected void setDamage(int d) {
        this.damage = d;
    }
    
    public int getUpgradePrice() {
        return this.price * 3 / 4;
    }
    
    public String getUpgradeDesc() {
        return "";
    }
}
