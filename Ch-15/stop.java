import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;
public class stop extends Application{
	public void start(Stage gui){
		Polygon pg=new Polygon();
		Pane pane = new Pane();
		ObservableList<Double> list=pg.getPoints();
		pg.setStroke(Color.RED);
		pg.setFill(Color.WHITE);
		double w=400,h=400;
		double centerX=w/2,centerY=h/2;
		double r=Math.min(w,h)*0.4;
		for(int i=0;i<6;i++){
			list.add(centerX + r * Math.cos(2 * i * Math.PI / 6)); 
			list.add(centerY - r * Math.sin(2 * i * Math.PI / 6)); 
		}
		pane.getChildren().add(pg);
		Scene scene=new Scene(pane,400,400);
		gui.setScene(scene);
		gui.show();
		
	}
}