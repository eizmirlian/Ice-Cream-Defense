package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChocolateChipGatlingGun extends Tower {
    
    private ImageView icon;
    private static String description = "A gatling gun which shoots\na barrage of"
            + " chocolate chips\nat enemies! Medium damage with"
            + "\na high rate of fire and low range";
    
    private String upgradeDesc = "Upgrade this tower to make it's fire rate even higher "
            + "and slightly increase damage."; 
    
    public ChocolateChipGatlingGun(Difficulty diff) {
        super(diff, description, 170, 1, 20, 10);
    }
    
    @Override
    public Projectile fire() {
        ImageView pIcon = new ImageView(new Image("file:src/chocChip.png"));
        return super.fire(pIcon, 10, super.fitWidth / 5, super.fitHeight / 5);
    }


    @Override
    public void upgrade() {
        super.setFireRate(15);
        super.setDamage(30);
        super.upgrade();
    }

    @Override
    public void sell() {
        // TODO Auto-generated method stub
    }
    @Override
    public ImageView getIcon() {
        this.icon = new ImageView(new Image("file:src/chocchipgatlinggun.png"));
        this.icon.setFitWidth(super.fitWidth);
        this.icon.setFitHeight(super.fitHeight);
        return this.icon;
    }
    
    @Override
    public String getUpgradeDesc() {
        return this.upgradeDesc;
    }

}
