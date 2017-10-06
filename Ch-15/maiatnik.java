import javafx.application.Application;
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
public class maiatnik extends Application{
	public void start(Stage gui){
		Circle circle=new Circle(225,45,5);
		Line line=new Line(225,45,125,100);
		Arc circle1=new Arc(225,45,5,5,0,180);
		Arc circle3=new Arc(225,45,80,40,180,180);
		circle1.setType(ArcType.OPEN);
		circle1.setFill(Color.WHITE);
		Circle circle2=new Circle(300,300,20);
		Pane pane =new Pane();
		pane.setOnKeyPressed(e ->{
			
		});
		pane.getChildren().addAll(circle,line,circle1,circle2);
		PathTransition pt=new PathTransition();
		PathTransition pt2=new PathTransition();
		pt.setDuration(Duration.millis(1000));
		//pt2.setDuration(Duration.millis(1000));
		pt.setPath(circle1);
		//pt2.setPath(circle3);
		pt.setNode(circle2);
		//pt2.setNode(line);
		//pt2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		//pt2.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		//pt2.setAutoReverse(true);
		pt.play();
		//pt2.play();
		Scene scene=new Scene(pane,400,400);
		gui.setScene(scene);
		gui.show();
	}
}