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
public class execise extends Application{
	public void start(Stage gui){
		BorderPane pane =new BorderPane();
		HBox top=new HBox(20);
		Text text=new Text("Programming is FUN");
		text.setFont(new Font(20));
		RadioButton red=new RadioButton("RED");
		RadioButton green=new RadioButton("GREEN");
		RadioButton blue=new RadioButton("BLUE");
		RadioButton orange=new RadioButton("ORANGE");
		RadioButton yellow=new RadioButton("YELLOW");
		ToggleGroup group=new ToggleGroup();
		red.setToggleGroup(group);
		green.setToggleGroup(group);
		blue.setToggleGroup(group);
		orange.setToggleGroup(group);
		yellow.setToggleGroup(group);
		red.setOnAction(e->{
			text.setFill(Color.RED);
		});
		green.setOnAction(e->{
			text.setFill(Color.GREEN);
		});
		blue.setOnAction(e->{
			text.setFill(Color.BLUE);
		});
		orange.setOnAction(e->{
			text.setFill(Color.ORANGE);
		});
		yellow.setOnAction(e->{
			text.setFill(Color.YELLOW);
		});
		Pane btp=new HBox();
		//Pane t=new Pane();
		Button left=new Button("<=");
		Button right=new Button("=>");
		left.setOnAction(e->{
				text.setX(text.getX()-10);
				text.setTranslateX(text.getX()-10);
		});
		right.setOnAction(e->{
				text.setX(text.getX()+10);
				text.setTranslateX(text.getX()+10);
		});
		//t.getChildren().add(text);
		btp.getChildren().addAll(left,right);
		top.getChildren().addAll(red,green,blue,yellow,orange);
		pane.setTop(top);
		pane.setCenter(text);
		pane.setBottom(btp);
		Scene scene=new Scene(pane,400,400);
		gui.setScene(scene);
		gui.show();
	}
}