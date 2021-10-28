package application;

import java.util.HashMap;
import java.util.Queue;
import java.util.Set;

public class GameLoop {
    
    private static long gameCounter = 0;
    private static double gameSpeed = 1;
    private static double fps = 60;
    
    public static void start(Level l) {
        Queue<EnemyWave> waves = l.getWaves();
        while (true) {
            try {
                Thread.sleep(166);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            EnemyWave currentWave = waves.poll();
            if (!Level.getPause()) {
                if (GameLoop.gameCounter % 120 == 0) {
                    if (currentWave.hasNext()) {
                        currentWave.deployNext();
                    }
                }
                HashMap<Integer, Enemy> alive = currentWave.getAliveEnemies();
                Set<Integer> ids = alive.keySet();
                for (int i : ids) {
                    Enemy e = alive.get(i);
                    e.move();
                    e.checkHealth();
                }
                gameCounter++;
            }
        }
    }
    public static double getfps() {
        return fps;
    }
}
