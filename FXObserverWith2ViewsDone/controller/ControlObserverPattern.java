package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.SimpleModel;
import views.LabelView;
import views.TextAreaView;

// This is the application. It contains references to the model and 
// both views. This application also has an inner class UpdateButtonListener
// as the Controller to increment the SimpleModel's currentCount which in 
// turn sends an update reference of itself to all OurObservers.
public class ControlObserverPattern extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	// TODO 4: Show the instance variables in the App
	private LabelView view1;
	private TextAreaView view2;
	public SimpleModel theModel;
	private Button upDateButton;

	@Override
	public void start(Stage stage) throws Exception {
		// TODO 5: Show we need an instance of our model in our App
		theModel = new SimpleModel();

		// TODO 6: Show the Layout of the GUI with extra
		view1 = new LabelView();
		// Allow one view to observe the model
		theModel.addObserver(view1);
		
		//view2 = new TextAreaView();
		
		view2 = new TextAreaView();
		theModel.addObserver(view2);
		// TODO 9xx: After implementing TextAreaView, let it observe the model
		// theModel.addObserver(view2);
		
		upDateButton = new Button("Increment the model by 1");
		BorderPane window = new BorderPane();
		Scene scene = new Scene(window, 400, 200);
		BorderPane.setAlignment(upDateButton, Pos.CENTER);
		window.setTop(upDateButton);
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.add(new Label("View1"), 0, 0);
		// Column 0, row 1, below the label
		gridPane.add(view1, 0, 1);
		gridPane.add(new Label("View2"), 1, 0);
		gridPane.add(view2, 1, 1);
		BorderPane.setMargin(gridPane, new Insets(20, 20, 20, 20));
		window.setCenter(gridPane);

		// TODO 7: Show how to allow an instance of
		// UpdateButtonListener to handle button clicks
		upDateButton.setOnAction(new UpdateButtonListener());

		// We need this code in all JavaFX Applications:
		stage.setScene(scene);
		stage.show();
	}

	// TODO 9: Show that the view also allows input!
	//
	// This is a controller in MVC. In general, controllers are implemented in Java
	// as an EventHandler<T> to a components in the view, like the one Button here.
	// Notice that this controller mediates between the view, a button click
	// and the model, a message to change the state of the simple model.
	//
	private class UpdateButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// We get here when the user clicks the button in the view
			theModel.increment();
			// The increment method must have the code to update the views with
			// setChanged()
			// notifyObservers
		}
	}
}