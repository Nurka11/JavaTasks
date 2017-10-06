import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class mousev extends Application{
	public void start(Stage gui){
		Pane pane=new Pane();
		Text t=new Text("asdfghjkl");
		pane.getChildren().add(t);
		pane.setOnMousePressed(e -> {
			t.setX(e.getX());t.setText(e.getX()+" "+e.getY());
			t.setY(e.getY());
		});
		pane.setOnMouseDragged(e -> {
			t.setX(e.getX());t.setText(e.getX()+" "+e.getY());
			t.setY(e.getY());
		});
		pane.setOnMouseMoved(e -> {
			t.setX(e.getX());t.setText(e.getX()+" "+e.getY());
			t.setY(e.getY());
		});
		Scene scene=new Scene(pane);
		gui.setScene(scene);
		gui.show();
	}
}