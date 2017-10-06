import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class liner extends Application{
	public void start(Stage gui){
		Linep linep=new Linep();
		BorderPane pane = new BorderPane();
		pane.setOnKeyPressed(e ->{
			switch (e.getCode()){
				case DOWN:linep.moved();;break;
				case UP:linep.moveu();break;
				case RIGHT:linep.mover();break;
				case LEFT:linep.movel();break;
			}
		});
		pane.setCenter(linep);
		Scene scene=new Scene(pane);
		gui.setScene(scene);
		gui.show();
		pane.requestFocus();
	}
	class Linep extends Pane{
		int x=100;
		int y=100;
		int w=110;
		int h=100;
		Line line;
		void mover(){
			x=w;y=h;
			w+=10;paintl();
		}void movel(){
			x=w;y=h;
			w-=10;paintl();
		}void moveu(){
			x=w;y=h;
			h-=10;paintl();
		}void moved(){
			x=w;y=h;
			h+=10;paintl();
		}
		void paintl(){
			line=new Line(x,y,w,h);
			getChildren().add(line);
		}
	}
}