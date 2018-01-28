//james murphy

package views;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import model.*;
import controller.*;

// TODO 9x: Complete this 2nd view to observe changes to the state of the model
/*
 * @author Your Name
 */
public class TextAreaView extends FlowPane implements Observer{

	private TextArea textArea;
	
	public TextAreaView() {
		textArea = new TextArea();
		textArea.setPrefSize(180,180);
		this.getChildren().add(textArea);
	}
	
	@Override
	public void update(Observable theModel, Object arg) {
		SimpleModel model = (SimpleModel) theModel;
	    String str = "";
	    int n = model.currentCount();
	    for(int count = 1; count <= n; count++) {
	      str += " |";
	      if(count % 20 == 0)
	        str += "\n";
	    }
	    textArea.setText(str);
		
	}

}