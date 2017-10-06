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
public class showcolors extends Application{
	public void start(Stage gui){
		VBox pane=new VBox(50);
		Text text=new Text("ShowColors");
		Slider red=new Slider();
		red.setMaxWidth(255);
		Text rt=new Text("RED");
		Slider blue=new Slider();
		blue.setMaxWidth(255);
		Text bt=new Text("BLUE");
		Slider green=new Slider();
		green.setMaxWidth(255);
		Text gt=new Text("GREEN");
		Slider opacity=new Slider();
		opacity.setMaxWidth(1.0);
		Text ot=new Text("OPACITY");
		Pane r=new HBox(10);
		r.getChildren().addAll(rt,red);
		Pane b=new HBox(10);
		b.getChildren().addAll(bt,blue);
		Pane g=new HBox(10);
		g.getChildren().addAll(gt,green);
		Pane o=new HBox(10);
		o.getChildren().addAll(ot,opacity);
		pane.getChildren().addAll(text,r,b,g,o);
		red.valueProperty().addListener(e->{
           text.setFill(Color.rgb((int)red.getValue(),(int)green.getValue(),(int)blue.getValue(),Math.random()));
        });
		blue.valueProperty().addListener(e->{
           text.setFill(Color.rgb((int)red.getValue(),(int)green.getValue(),(int)blue.getValue(),Math.random()));
        });
		green.valueProperty().addListener(e->{
           text.setFill(Color.rgb((int)red.getValue(),(int)green.getValue(),(int)blue.getValue(),Math.random()));
        });
		opacity.valueProperty().addListener(e->{
           text.setFill(Color.rgb((int)red.getValue(),(int)green.getValue(),(int)blue.getValue(),Math.random()));
        });
		
		Scene scene=new Scene(pane,400,400);
		gui.setScene(scene);
		gui.show();
	}
}