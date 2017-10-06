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
public class circle extends Application{
	Pane pane=new Pane();
	public void start(Stage gui){
		paintCircle(100);
		Scene scene=new Scene(pane,200,200);
		gui.setScene(scene);
		gui.show();
	}
	public int paintCircle(int n){
		if(n<1)return 0;
		Circle c=new Circle(100,100,n);
		c.setFill(Color.WHITE);
		c.setStroke(Color.BLACK);
		pane.getChildren().add(c);
		return paintCircle(n-5);
	}
}