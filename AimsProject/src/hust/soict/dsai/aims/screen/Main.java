package hust.soict.dsai.aims.screen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@SuppressWarnings("exports")
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/hust/soict/dsai/aims/screen/Cart.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Cart");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String [] args) {
		launch(args);
	}
}
