package hust.soict.dsai.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {

	@SuppressWarnings("exports")
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass()
				.getResource("/hust/soict/dsai/javafx/Painter.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Painter");
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args); 
		// step 1: constructs an instance of Painter
		// step 2: calls the init method
		// step 3: calls the start method, which has been overridden
		// step 4: waits for the application to finish
		// step 5: calls the stop method
	}
}
