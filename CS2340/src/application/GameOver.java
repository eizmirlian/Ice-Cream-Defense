package application;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class GameOver {
    
    private Stage primaryStage;
    private int width;
    private int height;
    
    public GameOver(Stage primaryStage, int width, int height) {
        this.primaryStage = primaryStage;
        this.width = width;
        this.height = height;
    }
    
    public void show(boolean win) {
        BorderPane gameOverPane = new BorderPane();
        gameOverPane.setPadding(new Insets(50));
        Text title;
        VBox prompts;
        Text consolation;
        if (win) {
            gameOverPane.setStyle("-fx-background-color: "
                + "linear-gradient(from 40% 25% to 100% 100%, black, green)");
            title = new Text("YOU WIN");
            title.setStyle("-fx-fill: green;-fx-font: 48px Stencil;");
            prompts = new VBox();
            consolation = new Text("Congrats! You defended your ice cream truck until it was working again!\n"
                    + "You can play again or quit!");
            consolation.setStyle("-fx-fill: yellow;-fx-font: 36px Impact;");
            consolation.setTextAlignment(TextAlignment.CENTER);
        } else {
            gameOverPane.setStyle("-fx-background-color: "
                    + "linear-gradient(from 40% 25% to 100% 100%, black, red)");
                title = new Text("GAME OVER");
                title.setStyle("-fx-fill: red;-fx-font: 48px Stencil;");
                prompts = new VBox();
                consolation = new Text("The kids got your ice cream, but you'll get em next time!\n"
                        + "You can quit here, or go back for revenge!");
                consolation.setStyle("-fx-fill: orange;-fx-font: 36px Impact;");
                consolation.setTextAlignment(TextAlignment.CENTER);
        }
        
        
        HBox buttons = new HBox();
        Button playAgain = new Button("Play Again");
        playAgain.setStyle(
                "-fx-background-color: green;-fx-text-fill: white;"
                + "-fx-background-radius: 10;-fx-font: 36px Impact");
        playAgain.setOnAction(e -> {
            HomeScreen h = new HomeScreen();
            h.start(primaryStage);
        });
        Button quit = new Button("Quit");
        quit.setStyle("-fx-background-color: red;"
                + "-fx-text-fill: white;-fx-background-radius: 10;-fx-font: 36px Impact");
        quit.setOnAction(e -> {
            Platform.exit();
        });
        buttons.getChildren().addAll(playAgain, quit);
        HBox.setMargin(playAgain, new Insets(12));
        prompts.getChildren().addAll(consolation, buttons);
        VBox.setMargin(consolation, new Insets(12));
        gameOverPane.setTop(title);
        BorderPane.setAlignment(title, Pos.CENTER);
        gameOverPane.setCenter(prompts);
        prompts.setAlignment(Pos.CENTER);
        buttons.setAlignment(Pos.CENTER);
        Scene gameOverScreen = new Scene(gameOverPane, this.width, this.height);
        primaryStage.setScene(gameOverScreen);
    }
}
