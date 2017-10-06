import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.shape.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class move extends Application{
	public void start(Stage gui){
		Button b=new Button("move");
		Myhandler handler=new Myhandler();
		b.setOnAction(handler);
		Circle circle=new Circle(250,250,100);
		Pane pane=new Pane();
		pane.getChildren().addAll(circle,b);
		Scene scene=new Scene(pane,500,500);
		gui.setScene(scene);
		gui.show();
	}
	class Myhandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			System.out.println("Button clicked");
		}
	}
}