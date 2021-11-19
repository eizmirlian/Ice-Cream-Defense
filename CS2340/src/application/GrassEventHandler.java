package application;

import java.awt.Dimension;
import java.awt.Toolkit;

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
    private Grass grass;
    private Difficulty diff;
    
    public GrassEventHandler(Stage primaryStage, Grass grass, Difficulty diff) {
        this.primaryStage = primaryStage;
        this.grass = grass;
        this.diff = diff;
    }
    
    @Override
    public void handle(ActionEvent arg0) {
        BorderPane towerMenu = new BorderPane();
        towerMenu.setPadding(new Insets(50));
        towerMenu.setStyle("-fx-background-color: gray");
        Text buildTitle = new Text("Build Menu");
        buildTitle.setStyle("-fx-fill: yellow;-fx-font: 36px Stencil");
        HBox towers = new HBox();
        towerMenu.setTop(buildTitle);
        towerMenu.setCenter(towers);
        towers.setAlignment(Pos.CENTER);
        towers.setPadding(new Insets(100));
        towers.setSpacing(80);
        
        
        HBox others = new HBox();
        Text moneyLabel = new Text("Money: " + Double.toString(ConfigEventHandler
                .getTruck().getMoney()));
        moneyLabel.setStyle("-fx-fill: yellow;-fx-font: 24px Stencil");
        Button exit = new Button("Exit");
        exit.setStyle("-fx-background-color: red;"
                + "-fx-text-fill: white;-fx-background-radius: 10;-fx-font: 24px Impact");
        exit.setOnAction(e -> {
            this.primaryStage.setScene(ConfigEventHandler.getScene());
        });
        Text errorMessage = new Text("You don't have enough money to buy that");
        errorMessage.setStyle("-fx-font: 24px Palatino; -fx-fill: red;-fx-font-weight: bold");
        errorMessage.setVisible(false);
        others.getChildren().addAll(moneyLabel, errorMessage, exit);
        others.setSpacing(100);    
        towerMenu.setBottom(others);
        others.setAlignment(Pos.CENTER);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenX = (int)screenSize.getWidth();
        int screenY = (int)screenSize.getHeight();
        screenX = screenX - (screenX%150);
        screenY = screenY - (screenY%150);
        if (grass.getTower() == null) {
            
            
            VBox towerOptions1 = new VBox();
            VanillaCatapult v = new VanillaCatapult(diff);
            ImageView vanillaCatapult = v.getIcon();
			/*
			 * Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); int
			 * screenX = (int)screenSize.getWidth(); int screenY =
			 * (int)screenSize.getHeight();
			 */
            vanillaCatapult.setFitWidth(screenX*0.15);
            vanillaCatapult.setFitHeight(screenY*0.12);
            Text towerTitle1 = new Text("VANILLA\nCATAPULT");
            towerTitle1.setStyle("-fx-fill: yellow;-fx-font: 24px Stencil");
            Text price1 = new Text("Price: " + v.getPrice());
            price1.setStyle("-fx-fill: yellow;-fx-font: 18px Impact");
            Text desc1 = new Text(v.getDescription());
            desc1.setStyle("-fx-fill: yellow;-fx-font: 18px Impact");
            Button buy1 = new Button("Buy");
            buy1.setStyle("-fx-background-color: green;"
                    + "-fx-text-fill: white;-fx-background-radius: 10;-fx-font: 36px Impact");
            buy1.setOnAction(new BuyTowerEventHandler(v, this.grass, this.primaryStage,
                    ConfigEventHandler.getTruck(), errorMessage));
            towerOptions1.getChildren().addAll(vanillaCatapult, towerTitle1, price1, desc1, buy1);
            towerOptions1.setSpacing(50);
            
            VBox towerOptions2 = new VBox();
            WaffleConeLauncher w = new WaffleConeLauncher(diff);
            ImageView waffleConeLauncher = w.getIcon();
            waffleConeLauncher.setFitWidth(screenX*0.15);
            waffleConeLauncher.setFitHeight(screenY*0.12);
            Text towerTitle2 = new Text("WAFFLE CONE\nLAUNCHER");
            towerTitle2.setStyle("-fx-fill: yellow;-fx-font: 24px Stencil");
            Text price2 = new Text("Price: " + w.getPrice());
            price2.setStyle("-fx-fill: yellow;-fx-font: 18px Impact");
            Text desc2 = new Text(w.getDescription());
            desc2.setStyle("-fx-fill: yellow;-fx-font: 18px Impact");
            Button buy2 = new Button("Buy");
            buy2.setStyle("-fx-background-color: green;"
                    + "-fx-text-fill: white;-fx-background-radius: 10;-fx-font: 36px Impact");
            buy2.setOnAction(new BuyTowerEventHandler(w, this.grass, this.primaryStage,
                    ConfigEventHandler.getTruck(), errorMessage));
            towerOptions2.getChildren().addAll(waffleConeLauncher, towerTitle2, price2, desc2,
                    buy2);
            towerOptions2.setSpacing(50);
            
            VBox towerOptions3 = new VBox();
            ChocolateChipGatlingGun c = new ChocolateChipGatlingGun(diff);
            ImageView chocChipGatlingGun = c.getIcon();
            chocChipGatlingGun.setFitWidth(screenX * 0.15);
            chocChipGatlingGun.setFitHeight(screenY * 0.12);
            Text towerTitle3 = new Text("CHOCOLATE CHIP\nGATLING GUN");
            towerTitle3.setStyle("-fx-fill: yellow;-fx-font: 24px Stencil");
            Text price3 = new Text("Price: " + c.getPrice());
            price3.setStyle("-fx-fill: yellow;-fx-font: 18px Impact");
            Text desc3 = new Text(c.getDescription());
            desc3.setStyle("-fx-fill: yellow;-fx-font: 18px Impact");
            Button buy3 = new Button("Buy");
            buy3.setStyle("-fx-background-color: green;"
                    + "-fx-text-fill: white;-fx-background-radius: 10;-fx-font: 36px Impact");
            buy3.setOnAction(new BuyTowerEventHandler(c, this.grass, this.primaryStage,
                    ConfigEventHandler.getTruck(), errorMessage));
            towerOptions3.getChildren().addAll(chocChipGatlingGun, towerTitle3, price3,
                    desc3, buy3);
            towerOptions3.setSpacing(50);
            
            towers.getChildren().addAll(towerOptions1, towerOptions2, towerOptions3);
            
            
        } else {
            buildTitle.setText("Upgrade Menu");
        }
        Scene buildMenu = new Scene(towerMenu, screenX, screenY);
        primaryStage.setScene(buildMenu);
    }

}
