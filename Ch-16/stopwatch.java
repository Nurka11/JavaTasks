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
public class stopwatch extends Application{
	public void start(Stage gui){
		Timeline anim=new Timeline();
		Pane pane = new Pane();
		TextField text=new TextField();
		text.setOnAction(e->{
			text.setText(Integer.parseInt(text.getText())-1+"");
		});
		pane.getChildren().add(text);
		Scene scene=new Scene(pane,400,400);
		gui.setScene(scene);
		gui.show();
	}
}