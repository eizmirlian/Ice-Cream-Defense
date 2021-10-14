package application;

import javafx.scene.control.Button;

public class Grass {
    private int[] pos = new int[2];
    private Button clickable;
    private Tower currentTower;
    
    public Grass(int row, int column, Button click) {
        pos[0] = row;
        pos[1] = column;
        clickable = click;
    }
    
    public Tower getTower() {
        return currentTower;
    }
}
