/**
 * 
 */
/**
 * 
 */
module AimsProject {
	requires java.desktop;
	requires javafx.fxml;
	requires javafx.swing;
	requires javafx.controls;
	requires javafx.graphics;
	requires java.naming;
	exports hust.soict.dsai.aims.screen to javafx.graphics, javafx.fxml;
	opens hust.soict.dsai.aims.screen to javafx.graphics, javafx.fxml;
}