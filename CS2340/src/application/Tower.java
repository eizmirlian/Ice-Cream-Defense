package application;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.scene.image.ImageView;

public class Tower {
	
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
    private String description;
    private Difficulty diff;
    private int price;
    private int range;
    private int damage;
    private int fireRate;
    protected int fitWidth = 88;
    protected int fitHeight = 10;
    private ImageView icon;
    
    public Tower(Difficulty diff, String description, int price, int range,
            int damage, int fireRate) {
        int screenX = ((int)screenSize.getWidth());
        int screenY = (int)screenSize.getHeight();
        int screenXFit = (int)((screenX - (screenX%150))*0.08);
        int screenYFit = (int)((screenY - (screenY%150))*0.04);
    	
        this.diff = diff;
        this.description = description;
        this.price = price;
        this.range = range;
        this.damage = damage;
        this.fireRate = fireRate;
        this.fitWidth = screenXFit;
        this.fitHeight = screenYFit;
        
        
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
