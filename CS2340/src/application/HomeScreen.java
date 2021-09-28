package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
public class HomeScreen extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Tower Defense");
		BorderPane home = new BorderPane();
		home.setPadding(new Insets(50));
		home.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, black, blue)");
		Text title = new Text("BEEJ'S TOWER DEFENSE");
		title.setStyle("-fx-fill: white;-fx-font: 48px Stencil;");
		Button start = new Button("Start");
		start.setStyle("-fx-background-color: green;-fx-text-fill: white;-fx-background-radius: 10;-fx-font: 24px Impact");
		home.setTop(title);
		BorderPane.setAlignment(title, Pos.CENTER);
		home.setCenter(start);
		Scene homepage = new Scene(home, 1000, 800);
		
		
		
		primaryStage.setScene(homepage);
		primaryStage.show();
	}

}
