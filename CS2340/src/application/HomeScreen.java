package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
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

        Button start = makeHomeScreen(primaryStage);

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
        Scene config = new Scene(configRoot, 1000, 800);

        Image bkgnd = new Image("file:src/TowerDefenseBackground.png");
        HBox initGameScreen = new HBox();
        initGameScreen.setBackground(new Background(new BackgroundImage(bkgnd,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
        Text health = new Text("Tower\nHealth");
        health.setStyle("-fx-font: 24px Impact");
        Text money = new Text("Money");
        money.setStyle("-fx-font: 24px Impact");
        initGameScreen.getChildren().addAll(health, money);
        HBox.setMargin(health, new Insets(12));
        HBox.setMargin(money, new Insets(12, 12, 12, 725));
        Scene initGame = new Scene(initGameScreen, 1000, 800);

        start.setOnAction(e -> {
            primaryStage.setScene(config);
        });

        confirm.setOnAction(e -> {
            if (verifyName(playerName.getText()) && difficulty.getValue() != null) {
                switch (difficulty.getValue()) {
                case EASY:
                    health.setText("Tower\nHealth: 200");
                    money.setText("Money: 250");
                    break;
                case MEDIUM:
                    health.setText("Tower\nHealth: 150");
                    money.setText("Money: 200");
                    break;
                case HARD:
                    health.setText("Tower\nHealth: 100");
                    money.setText("Money: 150");
                    break;
                default:
                    break;
                }
                primaryStage.setScene(initGame);
            } else {
                errorMessage.setVisible(true);
            }
        });

        primaryStage.show();
    }

    public boolean verifyName(String name) {
        name = name.trim();
        return name != "" && name != null && name != "Please Enter Your Name";
    }

    private Button makeHomeScreen(Stage primaryStage) {
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
        Scene homepage = new Scene(homeRoot, 1000, 800);
        primaryStage.setScene(homepage);
        return start;
    }

}
