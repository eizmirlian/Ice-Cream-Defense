package application;

import javafx.scene.image.ImageView;

public interface Tower {
    public void fire();
    public void checkRange();
    public void upgrade();
    public double getPrice();
    public String getDescription();
    public ImageView getIcon();
}
