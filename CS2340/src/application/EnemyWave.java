package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javafx.scene.Group;

public class EnemyWave {
    private HashMap<Integer, Enemy> aliveEnemies = new HashMap<Integer, Enemy>();
    private HashMap<Integer, Enemy> totalEnemies = new HashMap<Integer, Enemy>();
    private Group container;
    private int count;
    
    public EnemyWave(EnemyType[] enemies, ArrayList<Path> entryPoints, Group container) {
        this.count = 0;
        this.container = container;
        int id = 0;
        Random r = new Random();
        for (EnemyType e : enemies) {
            Enemy enemy;
            switch (e) {
            case LIGHT:
                enemy = new LightKid(entryPoints.get(r.nextInt(entryPoints.size())), true);
                break;
            case MEDIUM:
                enemy = new NormKid(entryPoints.get(r.nextInt(entryPoints.size())), true);
                break;
            case HEAVY:
                enemy = new HeavyKid(entryPoints.get(r.nextInt(entryPoints.size())), true);
                break;
            default:
                enemy = new NormKid(entryPoints.get(r.nextInt(entryPoints.size())), true);
            }
            totalEnemies.put(id, enemy);
            enemy.setID(id);
            id++;
        }
    }
    
    public boolean hasNext() {
        return count < totalEnemies.size();
    }
    
    public Enemy deployNext() {
        Enemy e = this.totalEnemies.get(count);
        aliveEnemies.put(count, e);
        container.getChildren().add(e.getIcon());
        count++;
        return e;
    }
    
    public HashMap<Integer, Enemy> getAliveEnemies() {
        return this.aliveEnemies;
    }
    
    public void enemyDead(int id) {
        aliveEnemies.remove(id);
    }
    
    public boolean endWave() {
        return aliveEnemies.isEmpty() && count == totalEnemies.size();
    }
}
