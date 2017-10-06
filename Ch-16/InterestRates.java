import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
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
public class InterestRates extends Application{
	public void start(Stage gui){
		Pane pane=new VBox();
		Pane top=new HBox();
		TextField loan=new TextField("Loan");
		TextField years=new TextField("Years");
		Button show=new Button("Show Table");
		TextArea text=new TextArea();
		show.setOnAction(e->{
			text.setText(drawTable(loan.getText(),years.getText()));
		});
		top.getChildren().addAll(loan,years,show);
		pane.getChildren().addAll(top,text);
		Scene scene=new Scene(pane,400,200);
		gui.setScene(scene);
		gui.show();
	}
	public String drawTable(String a,String b){
		int l=Integer.parseInt(a);
		int y=Integer.parseInt(b);
		String res="";
		for(int i=0;i<10;i++){
			res+=String.format("%5d %5d %5d\n",y,l,l*y*i);
		}
		return res;
	}
}