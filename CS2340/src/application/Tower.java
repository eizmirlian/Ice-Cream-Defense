package application;

import javafx.scene.image.ImageView;

public class Tower {
    private String description;
    private Difficulty diff;
    private int price;
    private int range;
    private int damage;
    private int fireRate;
    protected int fitWidth = 88;
    protected int fitHeight = 70;
    private ImageView icon;
    
    public Tower(Difficulty diff, String description, int price, int range,
            int damage, int fireRate) {
        this.diff = diff;
        this.description = description;
        this.price = price;
        this.range = range;
        this.damage = damage;
        this.fireRate = fireRate;
    }
    public void fire() {
        
    }
    public void checkRange() {
        
    }
    public void upgrade() {
        
    }
    public void sell() {
        
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
}
