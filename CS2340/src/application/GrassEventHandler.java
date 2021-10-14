package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GrassEventHandler implements EventHandler<ActionEvent> {
    private Stage primaryStage;
    Grass grass;
    Difficulty diff;
    
    public GrassEventHandler(Stage primaryStage, Grass grass, Difficulty diff) {
        this.primaryStage = primaryStage;
        this.grass = grass;
        this.diff = diff;
    }
    
    @Override
    public void handle(ActionEvent arg0) {
        if (grass.getTower() == null) {
            BorderPane towerMenu = new BorderPane();
            towerMenu.setPadding(new Insets(50));
            towerMenu.setStyle("-fx-background-color: gray");
            Text buildTitle = new Text("Build Menu");
            buildTitle.setStyle("-fx-fill: yellow;-fx-font: 36px Stencil");
            HBox towers = new HBox();
            towerMenu.setTop(buildTitle);
            towerMenu.setCenter(towers);
            towers.setAlignment(Pos.CENTER);
            towers.setPadding(new Insets(50));
            towers.setSpacing(40);
            
            VBox towerOptions1 = new VBox();
            ImageView vanillaCatapult = new ImageView();
            Text price1 = new Text("Price: " + VanillaCatapult.getPrice(diff));
            price1.setStyle("-fx-fill: yellow;-fx-font: 18px Impact");
            Text desc1 = new Text(VanillaCatapult.getDescription());
            desc1.setStyle("-fx-fill: yellow;-fx-font: 18px Impact");
            Button buy1 = new Button("Buy");
            buy1.setStyle("-fx-background-color: green;"
                    + "-fx-text-fill: white;-fx-background-radius: 10;-fx-font: 36px Impact");
            towerOptions1.getChildren().addAll(vanillaCatapult, price1, desc1, buy1);
            towerOptions1.setSpacing(25);
            
            VBox towerOptions2 = new VBox();
            ImageView waffleConeLauncher = new ImageView();
            Text price2 = new Text("Price: " + WaffleConeLauncher.getPrice(diff));
            price2.setStyle("-fx-fill: yellow;-fx-font: 18px Impact");
            Text desc2 = new Text(WaffleConeLauncher.getDescription());
            desc2.setStyle("-fx-fill: yellow;-fx-font: 18px Impact");price1.setStyle("-fx-fill: yellow;-fx-font: 18px Impact");
            Button buy2 = new Button("Buy");
            buy2.setStyle("-fx-background-color: green;"
                    + "-fx-text-fill: white;-fx-background-radius: 10;-fx-font: 36px Impact");
            towerOptions2.getChildren().addAll(waffleConeLauncher, price2, desc2, buy2);
            towerOptions2.setSpacing(25);
            
            VBox towerOptions3 = new VBox();
            ImageView chocChipGatlingGun = new ImageView();
            Text price3 = new Text("Price: " + ChocolateChipGatlingGun.getPrice(diff));
            price3.setStyle("-fx-fill: yellow;-fx-font: 18px Impact");
            Text desc3 = new Text(ChocolateChipGatlingGun.getDescription());
            desc3.setStyle("-fx-fill: yellow;-fx-font: 18px Impact");
            Button buy3 = new Button("Buy");
            buy3.setStyle("-fx-background-color: green;"
                    + "-fx-text-fill: white;-fx-background-radius: 10;-fx-font: 36px Impact");
            towerOptions3.getChildren().addAll(chocChipGatlingGun, price3, desc3, buy3);
            towerOptions3.setSpacing(25);
            
            towers.getChildren().addAll(towerOptions1, towerOptions2, towerOptions3);
            
            Scene buildMenu = new Scene(towerMenu, 1000, 800);
            primaryStage.setScene(buildMenu);
        }
    }

}
