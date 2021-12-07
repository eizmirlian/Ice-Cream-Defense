package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UpgradeHandler {
    private BorderPane upgradeMenu;
    private Tower curr;
    private Stage primaryStage;
    private Text error;
    private boolean prevPause;
    
    public UpgradeHandler(Stage primaryStage, BorderPane menu, Tower curr,
            Text error, boolean prevPause) {
        this.primaryStage = primaryStage;
        this.upgradeMenu = menu;
        this.curr = curr;
        this.error = error;
        this.prevPause = prevPause;
    }
    
    public void build() {
        VBox towerContainer = new VBox();
        ImageView towerIcon = curr.getIcon();
        towerIcon.setFitWidth(300);
        towerIcon.setFitHeight(240);
        Text towerTitle;
        Text upgradeDesc;
        if (!curr.checkUpgrade()) {
            towerTitle = new Text("UPGRADE YOUR TOWER");
            Text price = new Text("Price: " + curr.getUpgradePrice());
            price.setStyle("-fx-fill: yellow;-fx-font: 24px Impact");
            upgradeDesc = new Text(curr.getUpgradeDesc());
            upgradeDesc.setStyle("-fx-fill: yellow;-fx-font: 24px Impact");
            Button buy = new Button("Buy");
            buy.setStyle("-fx-background-color: green;"
                    + "-fx-text-fill: white;-fx-background-radius: 10;-fx-font: 36px Impact");
            buy.setOnAction(e -> {
                this.checkUpgrade();
            });
            towerContainer.getChildren().addAll(towerTitle, towerIcon, price, upgradeDesc, buy);
            towerContainer.setSpacing(50);
        } else {
            towerTitle = new Text("YOUR TOWER IS ALREADY FULLY UPGRADED");
            towerContainer.getChildren().addAll(towerTitle, towerIcon);
            towerContainer.setSpacing(50);
        }
        
        towerTitle.setStyle("-fx-fill: yellow;-fx-font: 36px Stencil");
        this.upgradeMenu.setCenter(towerContainer);
        towerContainer.setAlignment(Pos.CENTER);
    }
    
    public void checkUpgrade() {
        Monument truck = ConfigEventHandler.getTruck();
        if (truck.getMoney() >= curr.getUpgradePrice()) {
            truck.buy(curr.getUpgradePrice());
            curr.upgrade();
            this.primaryStage.setScene(ConfigEventHandler.getScene());
            Level.setPause(prevPause);
        } else {
            error.setVisible(true);
        }
    }
}
