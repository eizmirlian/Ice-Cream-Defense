package application;

import java.util.ArrayList;

public class Path {
    
    private int[] pos = new int[2];
    private int[] nextPos = new int[2];
    private Path next;
    private boolean steppedOn;
    private Enemy enemy;
    private boolean lastTile;
    private ArrayList<Tower> inRange = new ArrayList<Tower>();
    
    public Path(int row, int column, int nextRow, int nextColumn) {
        this.pos[0] = row;
        this.pos[1] = column;
        this.nextPos[0] = nextRow;
        this.nextPos[1] = nextColumn;
        this.enemy = null;
        this.lastTile = false;
    }
    
    public int[] getPos() {
        return pos;
    }
    
    public int[] getNextPos() {
        return this.nextPos;
    }
    
    public void setNext(Path next) {
        this.next = next;
        this.nextPos = next.getPos();
    }
    
    public Path getNext() {
        return next;
    }
    
    public void enter(Enemy e) {
        steppedOn = true;
        this.enemy = e;
        for (Tower t : inRange) {
            t.addEnemy(e);
        }
    }
    
    public void leave() {
        steppedOn = false;
        for (Tower t : inRange) {
            t.removeEnemy(this.enemy);
        }
        this.enemy = null;
    }
    public boolean check() {
        return steppedOn;
    }
    
    public Enemy getEnemy() {
        return enemy;
    }
    
    public void setLastTile(boolean lastTile) {
        this.lastTile = lastTile;
    }
    
    public boolean getLastTile() {
        return this.lastTile;
    }
    
    public void addTower(Tower t) {
        this.inRange.add(t);
    }
}
