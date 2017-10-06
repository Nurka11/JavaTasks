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
import javafx.application.Platform;
import java.util.concurrent.*;;
import javafx.concurrent.*;;
public class Clock extends Application{
	ClockPane p;
	public void start(Stage gui){
		p=new ClockPane();
		Thread t=new Thread(new Runnable(){
			public void run(){
				while(true){
				Platform.runLater(new Runnable(){
					public void run(){
						p.setCurrentTime();
						p.paintClock();
					}
				});
				try{
					Thread.sleep(1000);
				}catch(Exception e){}
			}
		}});
		t.start();
		Scene scene=new Scene(p,250,250);
		gui.setScene(scene);
		gui.show();
	
}
	
}