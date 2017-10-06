import java.util.concurrent.*;
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
public class ThreadEx extends Application{
	static String s="";
	public void start(Stage gui){
		Pane pane=new Pane();
		TextArea text=new TextArea();
		PrintChar p=new PrintChar('a',100);
		PrintChar p1=new PrintChar('b',100);
		PrintNum n=new PrintNum(100);
		Thread t1=new Thread(p);
		Thread t3=new Thread(p1);
		Thread t2=new Thread(n);
		t3.start();
		t2.start();
		t1.start();
		System.out.println(s);
		text.setText(s);
		pane.getChildren().add(text);
		Scene scene=new Scene(pane,400,400);
		gui.setScene(scene);
		gui.show();
	}
	static class PrintChar implements Runnable{
		private char c;
		private int time;
		PrintChar(char c,int time){
			this.c=c;
			this.time=time;
		}
		public void run(){
			for(int i=0;i<time;i++)s+=c;
		}
	}
	static class PrintNum implements Runnable{
		private int time;
		PrintNum(int time){
			this.time=time;
		}
		public void run(){
			for(int i=0;i<time;i++)s+=i+" ";
		}
	}
}