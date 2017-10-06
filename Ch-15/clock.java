import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import java.util.GregorianCalendar;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import java.util.Calendar;
public class clock extends Application{
	public void start(Stage gui){
		Timeline animation;
		clockp clock2=new clockp();
		clock2.paintc();
		EventHandler<ActionEvent> eventHandler = e -> {
			clock2.setCurrentTime();
		};
		animation=new Timeline(new KeyFrame(Duration.millis(1000),eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		//setCurrentTime();
		Pane pane =new Pane();
		pane.getChildren().add(clock2);
		Scene scene=new Scene(pane,400,400);
		gui.setScene(scene);
		gui.show();
	}
	public class clockp extends Pane{
		public clockp(){
			setCurrentTime();
		}
		Calendar cal=new GregorianCalendar();
		double sag=cal.get(Calendar.HOUR_OF_DAY);
		double min=cal.get(Calendar.MINUTE);
		double sec=cal.get(Calendar.SECOND);
		double sectilX=200;
		double sectilY=125;
		double mintilX=200;
		double mintilY=150;
		double sagtilX=200;
		double sagtilY=172;
		
		void paintc(){
			Circle clock1=new Circle(200,200,100);
			clock1.setFill(Color.WHITE);
			clock1.setStroke(Color.BLACK);
			Text t1=new Text(192.5,113,"12");
			Text t2=new Text(290,200,"3");
			Text t3=new Text(200,295,"6");
			Text t4=new Text(105,200,"9");
			move();
			Line mintil=new Line(200,200,mintilX,mintilY);
			mintil.setStroke(Color.GREEN);
			Line sectil=new Line(200,200,sectilX,sectilY);
			Line sagtil=new Line(200,200,sagtilX,sagtilY);
			sagtil.setStroke(Color.BLACK);
			sectil.setStroke(Color.RED);
			getChildren().clear();
			getChildren().addAll(clock1,t1,t2,t3,t4,mintil,sagtil,sectil);
		}
		void move(){
			sectilX=200+75*Math.sin(sec*(2*Math.PI/60));
			sectilY=200+75*Math.cos(sec*(2*Math.PI/60));
			mintilX=200+50*Math.sin(min*(2*Math.PI/60));
			mintilY=200+50*Math.cos(min*(2*Math.PI/60));
			sagtilY=200+28*Math.sin(sag*(2*Math.PI/60));
			sagtilY=200+28*Math.cos(sag*(2*Math.PI/60));
		}
		
	}
}
