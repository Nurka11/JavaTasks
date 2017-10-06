import javafx.animation.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.*;
import javafx.util.*;
import java.util.*;
public class time extends Application{
	int c;
	TextField text;
	public void start(Stage gui){
		text=new TextField();
		// Timeline t=new Timeline(new KeyFrame(Duration.millis(1000),e->{
			// text.setText(""+(Integer.parseInt(text.getText())-1));
		// }));
		
		text.setOnAction(e->{
			c=Integer.parseInt(text.getText());
			Thread ty=new Thread(new s());
			ty.start();
		});
		Pane pane=new Pane();
		pane.getChildren().add(text);
		Scene scene=new Scene(pane,400,400);
		gui.setScene(scene);
		gui.show();
	}
	public class s implements Runnable{
		public void run(){
			try{
				while(c!=0){
					text.setText(""+c);c--;
					Thread.sleep(1000);
				}
			}catch(Exception e){}
		}
	}
}