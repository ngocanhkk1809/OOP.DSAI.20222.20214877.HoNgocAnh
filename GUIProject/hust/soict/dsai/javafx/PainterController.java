package hust.soict.dsai.javafx;

import javafx.scene.shape.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    private ToggleGroup identical; 	
    
    @FXML
    private RadioButton pen,eraser;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (pen.isSelected()) {
    		Circle newCircle = new Circle(event.getX(),event.getY(),4,Color.BLACK);
        	drawingAreaPane.getChildren().add(newCircle);
    	}
    	else {
    		Circle newCircle = new Circle(event.getX(),event.getY(),6,Color.WHITE);
    		drawingAreaPane.getChildren().add(newCircle);
    	}
    }

}