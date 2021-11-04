package application;

public class Path {
    
    private int[] pos = new int[2];
    private int[] nextPos = new int[2];
    private Path next;
    private boolean steppedOn;
    private Enemy enemy;
    private boolean lastTile;
    
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
        enemy = e;
    }
    
    public void leave() {
        steppedOn = false;
        enemy = null;
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
}
