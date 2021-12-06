package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javafx.geometry.HPos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Level extends GridPane {
    
    private String ascii;
    private ArrayList<Path> entryPoints = new ArrayList<Path>();
    private int width;
    private int height;
    private Difficulty diff;
    private Queue<EnemyWave> enemyWaves = new LinkedList<EnemyWave>();
    private EnemyType[][] waves;
    private Stage stage;
    private static int screenWidth;
    private static int screenHeight;
    private int unitWidth;
    private int unitHeight;
    private static boolean pause;
    private boolean started;
    private static ArrayList<Tower> activeTowers = new ArrayList<Tower>();
    private static HashMap<Integer, Projectile> allProjectiles = new HashMap<Integer, Projectile>();
    
    public Level(String ascii, Difficulty diff, EnemyType[][] waves, int width,
            int height, Stage primaryStage, int screenWidth, int screenHeight) {
        this.ascii = ascii;
        this.setMinSize(screenWidth, screenHeight);
        this.width = width;
        this.height = height;
        this.diff = diff;
        this.stage = primaryStage;
        Level.screenWidth = screenWidth;
        Level.screenHeight = screenHeight;
        this.unitWidth = Level.screenWidth / this.width;
        this.unitHeight = Level.screenHeight / this.height;
        this.waves = waves;
        Enemy.setUnitHeight(this.unitHeight);
        Enemy.setUnitWidth(this.unitWidth);
        Level.pause = true;
        this.started = false;
    }
    
    public void generateLevel() {
        int col = 0;
        int row = 0;
        this.setStyle("-fx-background-color: green");
        Image truckPic = new Image("file:src/truck.png");
        ImageView truck = new ImageView(truckPic);
        truck.setFitWidth(180);
        truck.setFitHeight(150);
        Button monument = new Button();
        monument.setStyle("-fx-background-color: green");
        Monument iceCreamTruck = ConfigEventHandler.getTruck();
        monument.setGraphic(truck);
        monument.setOnAction(e -> {
            if (iceCreamTruck.getDisplay()) {
                monument.setGraphic(null);
                monument.setText("Money: " + Double.toString(iceCreamTruck.getMoney())
                    + "\nHealth: " + Integer.toString(iceCreamTruck.getHealth()));
                monument.setStyle("-fx-background-color: gray;-fx-text-fill: yellow;"
                    + "-fx-font: 24px Stencil;-fx-background-radius: 0");
                iceCreamTruck.setDisplay(false);
            } else {
                monument.setStyle("-fx-background-color: green");
                iceCreamTruck.setDisplay(true);
                monument.setText("");
                monument.setGraphic(truck);
            }
        });
        Button gameStart = new Button("Start Combat");
        gameStart.setStyle("-fx-background-color: red;"
                + "-fx-text-fill: white;-fx-background-radius: 10;-fx-font: 28px Stencil");
        gameStart.setOnAction(e -> {
            if (!started) {
                GameLoop g = new GameLoop(this);
                g.handle(e);
                started = true;
            }
            if (pause) {
                pause = false;
                gameStart.setText("Pause");
            } else {
                pause = true;
                gameStart.setText("Resume");
            }
        });
        Button grass;
        Path path;
        Path entry;
        Grass g;
        Path[][] allPaths = new Path[width][height];
        boolean truckPlaced = false;
        for (char c : ascii.toCharArray()) {
            if (col >= width) {
                row++;
                col = 0;
            }
            switch (c) {
            case '.':
                grass = new Button();
                grass.setMinSize(this.unitWidth, this.unitHeight);
                grass.setStyle("-fx-background-color: green;-fx-background-radius: 0;"
                        + "-fx-border-color: black");
                this.add(grass, col, row);
                g = new Grass(row, col, grass);
                grass.setOnAction(new GrassEventHandler(stage, g, diff));
                col++;
                break;
            case '0':
                entry = new Path(row, col, row + 1, col);
                entryPoints.add(entry);
                allPaths[row][col] = entry;
                makePathButton(col, row);
                col++;
                break;
            case '(':
                entry = new Path(row, col, row, col + 1);
                entryPoints.add(entry);
                allPaths[row][col] = entry;
                makePathButton(col, row);
                col++;
                break;
            case ')':
                entry = new Path(row, col, row, col - 1);
                entryPoints.add(entry);
                allPaths[row][col] = entry;
                makePathButton(col, row);
                col++;
                break;
            case '8':
                entry = new Path(row, col, row - 1, col);
                entryPoints.add(entry);
                allPaths[row][col] = entry;
                makePathButton(col, row);
                col++;
                break;
            case 'v':
                path = new Path(row, col, row + 1, col);
                allPaths[row][col] = path;
                makePathButton(col, row);
                col++;
                break;
            case '<':
                path = new Path(row, col, row, col - 1);
                allPaths[row][col] = path;
                makePathButton(col, row);
                col++;
                break;
            case '>':
                path = new Path(row, col, row, col + 1);
                allPaths[row][col] = path;
                makePathButton(col, row);
                col++;
                break;
            case '^':
                path = new Path(row, col, row - 1, col);
                allPaths[row][col] = path;
                makePathButton(col, row);
                col++;
                break;
            case 'o':
                if (!truckPlaced) {
                    this.add(monument, col, row, 2, 2);
                    truckPlaced = true;
                }
                col++;
                break;
            default:
                col++;
            }          
        }
        this.setNexts(allPaths);
        this.add(gameStart, 0, height, width - 1, 1);
        GridPane.setHalignment(gameStart, HPos.CENTER);
    }
    
    private void makePathButton(int col, int row) {
        Button path = new Button("*");
        path.setMinSize(this.unitWidth, this.unitHeight);
        path.setStyle("-fx-background-color: gray;-fx-text-fill: yellow;"
                + "-fx-font: 21px Impact;-fx-background-radius: 0");
        this.add(path, col, row);
    }
    
    public void setNexts(Path[][] allPaths) {
        for (Path[] paths : allPaths) {
            for (Path path : paths) {
                if (path != null) {
                    int nextRow = path.getNextPos()[0];
                    int nextCol = path.getNextPos()[1];
                    if (allPaths[nextRow][nextCol] != null) {
                        path.setNext(allPaths[nextRow][nextCol]);
                    } else {
                        //its next must be the monument
                        path.setLastTile(true);
                    }
                }
            }
        }
        Tower.allPaths(allPaths);
    }
    
    protected void makeWaves(Group g) {
        for (EnemyType[] wave : this.waves) {
            enemyWaves.add(new EnemyWave(wave, entryPoints, g));
        }
    }
    public Queue<EnemyWave> getWaves() {
        return this.enemyWaves;
    }
    
    public static boolean getPause() {
        return pause;
    }
    
    public static void setPause(boolean p) {
        pause = p;
    }
    
    public static int getScreenHeight() {
        return Level.screenHeight;
    }
    
    public static int getScreenWidth() {
        return Level.screenWidth;
    }
    
    public Stage getStage() {
        return this.stage;
    }
    
    public static ArrayList<Tower> getActiveTowers() {
        return Level.activeTowers;
    }
    
    public static HashMap<Integer, Projectile> getAllProjectiles() {
        return Level.allProjectiles;
    }
    
    public static void addTower(Tower t) {
        Level.activeTowers.add(t);
    }
}
