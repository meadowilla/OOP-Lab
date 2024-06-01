/**
 * 
 */
/**
 * 
 */
module GUIProject {
	requires java.desktop;
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;
	exports hust.soict.dsai.javafx to javafx.graphics, javafx.fxml;
	opens hust.soict.dsai.javafx to javafx.graphics, javafx.fxml;
}
