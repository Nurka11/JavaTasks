import java.net.*;
import java.io.*;
import java.util.*;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.geometry.Bounds;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.*;
import java.sql.*;
import javafx.util.*;
import javafx.collections.*;
import javafx.application.Platform;
import java.util.concurrent.*;
import javafx.concurrent.*;
public class stadion extends Pane{
	public stadion(){
		
		Rectangle rec = new Rectangle(20,400);
		rec.setFill(Color.BLACK);
		
		Rectangle rec2 = new Rectangle(20,400);
		rec2.setFill(Color.BLACK);
		
		Rectangle rec3 = new Rectangle(400,20);
		rec3.setFill(Color.BLACK);
		
		Rectangle rec1 = new Rectangle(400,20);
		rec1.setFill(Color.BLACK);
		
		BorderPane pane = new BorderPane();
		pane.setLeft(rec);
		pane.setRight(rec2);
		pane.setTop(rec3);
		pane.setBottom(rec1);
		
		Line line = new Line(0,220,440,220);
		line.setStroke(Color.WHITE);
		
		Circle circle = new Circle(200,220,5);
		circle.setFill(Color.WHITE);
		
		Circle circle1 = new Circle(200,220,40);
		circle1.setFill(Color.color(0,0,0,0));
		circle1.setStroke(Color.WHITE);
		
		Rectangle rect = new Rectangle(110,20,180,70);
		rect.setFill(Color.color(0,0,0,0));
		rect.setStroke(Color.WHITE);
		
		Rectangle recta = new Rectangle(140,20,120,35);
		recta.setFill(Color.color(0,0,0,0));
		recta.setStroke(Color.WHITE);
		
		Circle dom = new Circle(200,70,3);
		dom.setFill(Color.WHITE);
		
		Rectangle rect1 = new Rectangle(110,350,180,70);
		rect1.setFill(Color.color(0,0,0,0));
		rect1.setStroke(Color.WHITE);
		
		Rectangle recta1 = new Rectangle(140,385,120,35);
		recta1.setFill(Color.color(0,0,0,0));
		recta1.setStroke(Color.WHITE);
		
		Circle dom1 = new Circle(200,370,3);
		dom1.setFill(Color.WHITE);
		
		Arc arc = new Arc(200,90,40,30,0,-180);
		arc.setFill(Color.color(0,0,0,0));
		arc.setStroke(Color.WHITE);
		
		Arc arc1 = new Arc(200,350,40,30,0,180);
		arc1.setFill(Color.color(0,0,0,0));
		arc1.setStroke(Color.WHITE);
		
		getChildren().addAll(line,circle,circle1,rect,recta,dom,pane,rect1,recta1,dom1,arc,arc1);
	}
}