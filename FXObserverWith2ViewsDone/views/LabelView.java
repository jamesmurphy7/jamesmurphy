package views;

import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import model.SimpleModel;

// TODO 8: Show one view quickly
public class LabelView extends BorderPane implements Observer {

	private Label label; // needed in the constructor and in update()
	private SimpleModel theModel;
	private TextField inputField;

	public LabelView() {
		Label prompt = new Label("Change count ");
		inputField = new TextField();
		inputField.setMaxWidth(40);
		inputField.setOnAction(new TextFieldListener());
		FlowPane flowPane = new FlowPane();
		flowPane.getChildren().add(prompt);
		flowPane.getChildren().add(inputField);
		this.setTop(flowPane);
		label = new Label("0");
		label.setFont(new Font("Arial", 30));
		this.setCenter(label);
		this.setStyle("-fx-background-color: cyan");
   }

	@Override
	public void update(Observable theObserved, Object o) {
		theModel = (SimpleModel) theObserved;
		int currentValue = theModel.currentCount();
		label.setText("" + currentValue);
	}

	// This is a controller in MVC. In general, controllers are implemented in Java
	// as an EventHandler<T> to a components in the view, like a TextField here.
	// Notice that this controller mediates between the view and the model.
	private class TextFieldListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			int newCount = Integer.parseInt(inputField.getText());
			theModel.setCount(newCount);
			// The increment method must have this code to update both views with
			// setChanged()
			// notifyObservers
		}
	}
}