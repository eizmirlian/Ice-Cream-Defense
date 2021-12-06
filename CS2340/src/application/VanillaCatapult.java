package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VanillaCatapult extends Tower {
    
    private ImageView icon;
    private static String description = "A catapult which launches scoops\nof vanilla "
            + "ice cream at enemies!\nStandard damage and rate of\nfire, with a lot of range.";
    
    private String upgradeDesc = "Upgrade this tower to increase it's damage.";

    
    public VanillaCatapult(Difficulty diff) {
        super(diff, description, 100, 3, 25, 2.0);
    }
    @Override
    public Projectile fire() {
        ImageView pIcon = new ImageView(new Image("file:src/vanillaScoop.png"));
        return super.fire(pIcon, 9, super.fitWidth / 2, super.fitHeight / 2);
    }


    @Override
    public void upgrade() {
        super.setDamage(40);
        super.upgrade();
    }

    @Override
    public void sell() {
        // TODO Auto-generated method stub
    }

    public String getDescription() {
        return description;
    }
    
    @Override
    public ImageView getIcon() {
        this.icon = new ImageView(new Image("file:src/vanillacatapult.png"));
        this.icon.setFitWidth(super.fitWidth);
        this.icon.setFitHeight(super.fitHeight);
        return this.icon;
    }
    
    
    @Override
    public String getUpgradeDesc() {
        return this.upgradeDesc;
    }
}
