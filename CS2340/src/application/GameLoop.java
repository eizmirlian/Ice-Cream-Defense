package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
//import java.util.Set;    //Checkstyle said this import wasn't used

import javafx.animation.KeyFrame;
//import javafx.animation.KeyValue;    //Checkstyle said this import wasn't used
//import javafx.animation.PathTransition;    //Checkstyle said this import wasn't used
import javafx.animation.Timeline;
//import javafx.animation.TranslateTransition;    //Checkstyle said this import wasn't used
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
//import javafx.scene.shape.Line;    //Checkstyle said this import wasn't used
import javafx.util.Duration;

public class GameLoop implements EventHandler<ActionEvent> {
    
    private static long gameCounter = 0;
    private static double gameSpeed = 1;
    private static double fps = 60;
    private Queue<EnemyWave> waves;
    private static EnemyWave currWave;
    private boolean gameOver = false;
    private Level l;
    private int pID = 0;
    private HashMap<Integer, Projectile> allProjectiles = Level.getAllProjectiles();
    
    public GameLoop(Level l) {
        this.l = l;
        this.waves = l.getWaves();
        GameLoop.currWave = waves.poll();
    }
    
    public static double getfps() {
        return fps;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void handle(ActionEvent arg0) {
        
        HashMap<Integer, Enemy> aliveEnemies = (HashMap<Integer, Enemy>) 
                GameLoop.currWave.getAliveEnemies().clone();
        ArrayList<Tower> activeTowers = (ArrayList<Tower>) Level.getActiveTowers().clone();
        
        if (ConfigEventHandler.getTruck().getHealth() <= 0) {
            Level.setPause(true);
            gameOver = true;
            GameOver g = new GameOver(l.getStage(), Level.getScreenWidth(), 
                    Level.getScreenHeight());
            g.show();
        }
        if (!Level.getPause()) {
            if (gameCounter % 90 == 0 && GameLoop.currWave.hasNext()) {
                GameLoop.currWave.deployNext();
            } else if (currWave.endWave() && !waves.isEmpty()) {
                currWave = waves.poll();
            }
            
            for (int id : aliveEnemies.keySet()) {
                Enemy e = aliveEnemies.get(id);
                double[] toMove = e.move();
                ImageView icon = e.getIcon();
                //System.out.println(toMove[1]);
                icon.setLayoutX(toMove[1]);
                icon.setLayoutY(toMove[0]);
            }
            for (Tower t : activeTowers) {
                if (gameCounter % (60 / t.getFireRate()) == 0) {
                    if (t.targeting()) {
                        Projectile p = t.fire();
                        allProjectiles.put(pID, p);
                        pID++;
                    }
                }
            }
            HashMap<Integer, Projectile> temp = (HashMap<Integer, Projectile>) allProjectiles.clone();
            for (int id : temp.keySet()) {
                Projectile p = allProjectiles.get(id);
                ImageView icon = p.getIcon();
                if (p.finished()) {
                    allProjectiles.remove(id);
                    icon.setVisible(false);
                }
                double[] toMove = p.move();
                icon.setLayoutX(toMove[1]);
                icon.setLayoutY(toMove[0]);
            }
        }
        Timeline timer = new Timeline();
        timer.getKeyFrames().add(new KeyFrame(Duration.millis(16.6), e -> {
            if (!Level.getPause()) {
                GameLoop.gameCounter++;
            }
            if (!gameOver) {
                this.handle(arg0);
            }
        }));
        timer.setCycleCount(1);
        timer.setAutoReverse(false);
        timer.play();
    }
    
    public static EnemyWave getCurrWave() {
        return GameLoop.currWave;
    }
    
    
}
