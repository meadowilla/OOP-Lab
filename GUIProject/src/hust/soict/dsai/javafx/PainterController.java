package hust.soict.dsai.javafx;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    private ToggleGroup tool;
    
    @FXML
    private RadioButton pen;
    
    @FXML
    private RadioButton eraser;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {

    	Rectangle clipArea = new Rectangle(0, 0, drawingAreaPane.getWidth(), drawingAreaPane.getHeight());
    	drawingAreaPane.setClip(clipArea);
    	Color color = null;
    	if (pen.isSelected()) {
    		color = Color.BLACK;
    	} else if (eraser.isSelected()){
    	color = Color.WHITE;
    	}
    	
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
    	drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

}

