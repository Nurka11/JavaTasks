import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
public class ball extends Application{
	public static void main(String[] args){
		Application.launch(args);
	}
	public void start(Stage gui){
		Circle circle=new Circle();
		circle.setRadius(50);
		Pane p=new HBox(2);
		p.getChildren().add(circle);
		Scene s=new Scene(p);
		gui.setScene(s);
		gui.show();
	}
}