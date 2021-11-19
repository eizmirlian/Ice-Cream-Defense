package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConfigEventHandler implements EventHandler<ActionEvent> {

    private ComboBox<Difficulty> difficulty;
    private TextField playerName;
    private Text error;
    private Stage primaryStage;
    private static Scene gameScreen;
    private static Monument iceCreamTruck;
    private static Level currLevel;
    
    public ConfigEventHandler(ComboBox<Difficulty> difficulty, TextField playerName,
            Text error, Stage primaryStage) {
        this.difficulty = difficulty;
        this.playerName = playerName;
        this.error = error;
        this.primaryStage = primaryStage;
    }
    
    @Override
    public void handle(ActionEvent arg0) {
        String name = this.playerName.getText();
        Difficulty diff = this.difficulty.getValue();
        if (verifyName(name) && diff != null) {
            int diffModifier = setModifier(diff);
            iceCreamTruck = new Monument(50 * diffModifier, 50 * (diffModifier + 1));
            this.levelGen(diff);
        } else {
            error.setVisible(true);
        }
    }
    public int setModifier(Difficulty diff) {
        switch (diff) {
        case EASY:
            return 4;
        case MEDIUM:
            return 3;
        case HARD:
            return 2;
        default:
            return 0;
        }
    }

    public boolean verifyName(String name) {
        return name != null && !(name.trim().equals(""));
    }
    
    private void levelGen(Difficulty diff) {
        Group movingSprites = new Group();
        movingSprites.setManaged(false);
        StackPane base = new StackPane();
        String levelLayout1 = "....0......0..."
                            + "....v......v<<)"
                            + "(>>>v......v..."
                            + "....v....v<<..."
                            + "..v<<....v....."
                            + "..v......v....."
                            + "..v......>>>v.."
                            + "..>>>>>>v...v.."
                            + "........v...v.."
                            + "........v...v.."
                            + "v<<<<<<<<...v.."
                            + "v...........v.."
                            + "v...........>>v"
                            + "oo............v"
                            + "oo<<<<<<<<<<<<<";
        EnemyType[][] levelWaves1 = {{EnemyType.MEDIUM}};
        currLevel = new Level(levelLayout1, diff, levelWaves1, 15, 15, primaryStage, 1500, 1200);
        currLevel.generateLevel();
        currLevel.makeWaves(movingSprites);
        Tower.setSpritesGroup(movingSprites);
        base.getChildren().add(currLevel);
        base.getChildren().add(movingSprites);
        
        gameScreen = new Scene(base, 1500, 1270);
        
        primaryStage.setScene(gameScreen);
        
    }
    public static Scene getScene() {
        return gameScreen;
    }
    public static Monument getTruck() {
        return iceCreamTruck;
    }
    
    public static Level getLevel() {
        return ConfigEventHandler.currLevel;
    }
}
