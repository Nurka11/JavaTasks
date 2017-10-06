import javafx.animation.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.*;
import javafx.util.Duration;
import java.util.*;
public class trafficlight extends Application{
	public void start(Stage gui){
		Rectangle rec=new Rectangle(100,100,200,550);
		rec.setFill(Color.WHITE);
		rec.setStroke(Color.BLACK);
		Circle red=new Circle(200,200,75);
		Circle yellow=new Circle(200,375,75);
		yellow.setFill(Color.WHITE);
		yellow.setStroke(Color.BLACK);
		Circle green=new Circle(200,550,75);
		green.setFill(Color.WHITE);
		green.setStroke(Color.BLACK);
		red.setFill(Color.WHITE);
		red.setStroke(Color.BLACK);
		RadioButton red1=new RadioButton("Red");
		RadioButton yellow1=new RadioButton("Yellow");
		RadioButton green1=new RadioButton("Green");
		ToggleGroup group=new ToggleGroup();
		red1.setToggleGroup(group);
		green1.setToggleGroup(group);
		yellow1.setToggleGroup(group);
		red1.setOnAction(e->{
			red.setFill(Color.RED);
			yellow.setFill(Color.WHITE);
			green.setFill(Color.WHITE);
		});
		green1.setOnAction(e->{
			red.setFill(Color.WHITE);
			yellow.setFill(Color.WHITE);
			green.setFill(Color.GREEN);
		});
		yellow1.setOnAction(e->{
			red.setFill(Color.WHITE);
			yellow.setFill(Color.YELLOW);
			green.setFill(Color.WHITE);
		});
		Pane pane=new Pane();
		Pane rbt=new HBox(10);
		Pane gpane=new VBox(10);
		rbt.getChildren().addAll(red1,yellow1,green1);
		pane.getChildren().addAll(rec,red,yellow,green);
		gpane.getChildren().addAll(pane,rbt);
		Scene scene=new Scene(gpane,400,800);
		gui.setScene(scene);
		gui.show();
	}
}