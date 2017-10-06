import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.collections.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import java.util.GregorianCalendar;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import java.util.Calendar;
import javafx.geometry.*;
public class ControlLabel extends Application{
	public void start(Stage gui){
		BorderPane pane=new BorderPane();
		Pane top=new HBox();
		ObservableList<String> items=FXCollections.observableArrayList();
		items.addAll("RIGHT","LEFT","TOP","BOTTOM");
		ComboBox pos=new ComboBox(items);
		TextField dis=new TextField("DISTANCE");
		ImageView image=new ImageView("113273.jpg");
		image.setFitHeight(200);
		image.setFitWidth(500);
		Label label=new Label("FCB",image);
		dis.setOnAction(e->{
			label.setGraphicTextGap(Integer.parseInt(dis.getText()));
		});
		pos.setOnAction(e->{
			switch((String)pos.getValue()){
				case "LEFT":label.setContentDisplay(ContentDisplay.LEFT);break;
				case "RIGHT":label.setContentDisplay(ContentDisplay.RIGHT);break;
				case "TOP":label.setContentDisplay(ContentDisplay.TOP);break;
				case "BOTTOM":label.setContentDisplay(ContentDisplay.BOTTOM);break;
			}
		});
		top.getChildren().addAll(pos,dis);
		pane.setCenter(label);
		pane.setTop(top);
		Scene scene=new Scene(pane,600,600);
		gui.setScene(scene);
		gui.show();
	}
}