package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BuyTowerEventHandler implements EventHandler<ActionEvent> {
    
    private Tower toBuy;
    private Grass location;
    private Stage primaryStage;
    private Monument truck;
    private Text error;
    
    public BuyTowerEventHandler(Tower toBuy, Grass location, Stage primaryStage, Monument truck,
            Text error) {
        this.toBuy = toBuy;
        this.location = location;
        this.primaryStage = primaryStage;
        this.truck = truck;
        this.error = error;
    }
    
    @Override
    public void handle(ActionEvent arg0) {
        if (truck.getMoney() >= toBuy.getPrice()) {
            truck.buy(toBuy.getPrice());
            this.primaryStage.setScene(ConfigEventHandler.getScene());
            this.location.buyTower(toBuy);
            this.location.getButton().setGraphic(toBuy.getIcon());
            Level.setPause(false);
        } else {
            error.setVisible(true);
        }
    }

}
