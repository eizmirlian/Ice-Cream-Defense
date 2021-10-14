package application;

import java.util.LinkedList;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Level extends GridPane {
    
    private String ascii;
    private LinkedList<Path> entryPoints = new LinkedList<Path>();
    private int width;
    private int height;
    Difficulty diff;
    Stage stage;
    
    public Level (String ascii, Difficulty diff, int width, int height, Stage primaryStage) {
        this.ascii = ascii;
        this.setMinSize(1000, 800);
        this.width = width;
        this.height = height;
        this.diff = diff;
        this.stage = primaryStage;
    }
    
    public void generateLevel() {
        int col = 0;
        int row = 0;
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
                    grass.setMinSize(50, 40);
                    grass.setStyle("-fx-background-color: green;-fx-background-radius: 0;-fx-border-color: black");
                    this.add(grass, col, row);
                    g = new Grass(row, col, grass);
                    grass.setOnAction(new GrassEventHandler(stage, g, diff));
                    col++;
                    break;
                case '0':
                    entry = new Path(row, col, row + 1, col);
                    entryPoints.add(entry);
                    allPaths[col][row] = entry;
                    makePathButton(col, row);
                    col++;
                    break;
                case '(':
                    entry = new Path(row, col, row, col + 1);
                    entryPoints.add(entry);
                    allPaths[col][row] = entry;
                    makePathButton(col, row);
                    col++;
                    break;
                case ')':
                    entry = new Path(row, col, row, col - 1);
                    entryPoints.add(entry);
                    allPaths[col][row] = entry;
                    makePathButton(col, row);
                    col++;
                    break;
                case '8':
                    entry = new Path(row, col, row - 1, col);
                    entryPoints.add(entry);
                    allPaths[col][row] = entry;
                    makePathButton(col, row);
                    col++;
                    break;
                case 'v':
                    path = new Path(row, col, row + 1, col);
                    allPaths[col][row] = path;
                    makePathButton(col, row);
                    col++;
                    break;
                case '<':
                    path = new Path(row, col, row, col + 1);
                    allPaths[col][row] = path;
                    makePathButton(col, row);
                    col++;
                    break;
                case '>':
                    path = new Path(row, col, row, col - 1);
                    allPaths[col][row] = path;
                    makePathButton(col, row);
                    col++;
                    break;
                case '^':
                    path = new Path(row, col, row - 1, col);
                    allPaths[col][row] = path;
                    makePathButton(col, row);
                    col++;
                    break;
                case 'o':
                    if (!truckPlaced) {
                        ImageView truck = new ImageView();
                        this.add(truck, col, row, 4, 4);
                        truckPlaced = true;
                    }
                    col++;
                    break;
            }          
        }
        this.setNexts(allPaths);
    }
    
    private void makePathButton(int col, int row) {
        Button path = new Button("*");
        path.setMinSize(50, 40);
        path.setStyle("-fx-background-color: gray;-fx-text-fill: yellow;"
                + "-fx-font: 15px Impact;-fx-background-radius: 0");
        this.add(path, col, row);
    }
    
    private void setNexts(Path[][] allPaths) {
        for (Path[] paths : allPaths) {
            for (Path path : paths) {
                if (path != null) {
                    int nextRow = path.getNextPos()[0];
                    int nextCol = path.getNextPos()[1];
                    path.setNext(allPaths[nextCol][nextRow]);
                }
            }
        }
    }
}
