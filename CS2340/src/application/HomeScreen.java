package application;

import javafx.application.Application;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class HomeScreen extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tower Defense");
        primaryStage.setResizable(false);

        BorderPane homeRoot = new BorderPane();
        homeRoot.setPadding(new Insets(50));
        homeRoot.setStyle("-fx-background-color: "
            + "linear-gradient(from 25% 25% to 100% 100%, black, blue)");
        Text title = new Text("BEEJ'S TOWER DEFENSE");
        title.setStyle("-fx-fill: white;-fx-font: 48px Stencil;");
        Button start = new Button("Start");
        start.setStyle(
                "-fx-background-color: green;-fx-text-fill: white;"
                + "-fx-background-radius: 10;-fx-font: 36px Impact");
        homeRoot.setTop(title);
        BorderPane.setAlignment(title, Pos.CENTER);
        homeRoot.setCenter(start);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenX = (int)screenSize.getWidth();
        int screenY = (int)screenSize.getHeight();
        screenX = screenX - (screenX%150);
        screenY = screenY - (screenY%150);
        Scene homepage = new Scene(homeRoot, screenX, screenY);
        primaryStage.setScene(homepage);
        
        

        BorderPane configRoot = new BorderPane();
        configRoot.setPadding(new Insets(50));
        configRoot.setStyle("-fx-background-color: "
            + "linear-gradient(from 25% 25% to 100% 100%, black, blue)");
        Text setup = new Text("GAME SETUP");
        setup.setStyle("-fx-fill: white;-fx-font: 48px Stencil;");
        HBox setupContainer = new HBox();
        VBox optionsContainer = new VBox();
        TextField playerName = new TextField();
        playerName.setPromptText("Please Enter Your Name");
        playerName.setMinWidth(175);
        ComboBox<Difficulty> difficulty = new ComboBox<Difficulty>();
        difficulty.getItems().addAll(Difficulty.EASY, Difficulty.MEDIUM, Difficulty.HARD);
        difficulty.setPromptText("Please Select a Difficulty");
        optionsContainer.getChildren().addAll(playerName, difficulty);
        VBox.setMargin(playerName, new Insets(12));
        optionsContainer.setAlignment(Pos.CENTER);
        Button confirm = new Button("Confirm");
        confirm.setStyle("-fx-background-color: green;"
            + "-fx-text-fill: white;-fx-background-radius: 10;-fx-font: 36px Impact");
        setupContainer.getChildren().addAll(optionsContainer, confirm);
        HBox.setMargin(optionsContainer, new Insets(12));
        setupContainer.setAlignment(Pos.CENTER);
        confirm.setAlignment(Pos.CENTER);
        Text errorMessage = new Text("Please enter a name that isn't empty or just whitespace"
            + " and select a difficulty");
        errorMessage.setStyle("-fx-font: 24px Palatino; -fx-fill: red");
        errorMessage.setVisible(false);

        configRoot.setTop(setup);
        BorderPane.setAlignment(setup, Pos.CENTER);
        configRoot.setCenter(setupContainer);
        configRoot.setBottom(errorMessage);
        BorderPane.setAlignment(errorMessage, Pos.CENTER);
        Scene config = new Scene(configRoot, screenX, screenY);
        
        
        
        

        start.setOnAction(e -> {
            primaryStage.setScene(config);
        });

        confirm.setOnAction(new ConfigEventHandler(difficulty, playerName, errorMessage,
                primaryStage));
            

        primaryStage.show();
    }
}