package application;

import javafx.scene.control.Button;

public class Grass {
    private int[] pos = new int[2];
    private Button clickable;
    private Tower currentTower;
    
    public Grass(int row, int column, Button click) {
        this.pos[0] = row;
        this.pos[1] = column;
        this.clickable = click;
    }
    
    public Tower getTower() {
        return this.currentTower;
    }
    
    public void buyTower(Tower t) {
        this.currentTower = t;
    }
    public Button getButton() {
        return this.clickable;
    }
}
