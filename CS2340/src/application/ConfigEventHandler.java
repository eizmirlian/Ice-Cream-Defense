package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConfigEventHandler implements EventHandler<ActionEvent> {

    private ComboBox<Difficulty> difficulty;
    private TextField playerName;
    private Text error;
    private Stage primaryStage;
    
    public ConfigEventHandler(ComboBox<Difficulty> difficulty, TextField playerName, Text error, Stage primaryStage) {
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
            Monument iceCreamTruck;
            iceCreamTruck = new Monument(50 * diffModifier, 50 * (diffModifier + 1));
            this.levelGen(diff);
        } else {
            error.setVisible(true);
        }
    }
    public int setModifier(Difficulty diff) {
        switch(diff) {
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
        Level level1 = new Level(".....0............0."
                               + ".....v............v."
                               + ".....v............v."
                               + ".....v............v."
                               + ".....v............v."
                               + ".....v.......v<<<<<."
                               + ".....v.......v......"
                               + "(>>>>v.......v......"
                               + ".....v.......v......"
                               + ".....v.......v......"
                               + ".....v.......v......"
                               + ".....v.......>>>>v.."
                               + ".....v...........v.."
                               + ".....v...........v.."
                               + ".....v...........v.."
                               + ".....v........v<<<.."
                               + "....oooo......v....."
                               + "(>>>oooo......v....."
                               + "....oooo<<<<<<<....."
                               + "....oooo............", diff, 20, 20, primaryStage);
        level1.generateLevel();
        Scene initGame = new Scene(level1, 1000, 800);
        primaryStage.setScene(initGame);
    }

}
