package application;

public class Path {
    
    private int[] pos = new int[2];
    private int[] nextPos = new int[2];
    private Path next;
    private boolean steppedOn;
    private Enemy enemy;
    
    public Path (int row, int column, int nextRow, int nextColumn) {
        this.pos[0] = row;
        this.pos[1] = column;
        this.nextPos[0] = nextRow;
        this.nextPos[1] = nextColumn;
        this.enemy = null;
    }
    
    public int[] getPos() {
        return pos;
    }
    
    public int[] getNextPos() {
        return this.nextPos;
    }
    
    public void setNext(Path next) {
        this.next = next;
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
}
