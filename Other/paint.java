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
import javafx.scene.canvas.*;
import javafx.scene.transform.Rotate;
import javafx.stage.*;
import javafx.util.Duration;
import java.util.*;
public class paint extends Application{
	double x,y;
	public void start(Stage gui){
		Pane pane=new Pane();
		Canvas c = new Canvas(200,200);
		GraphicsContext gc = c.getGraphicsContext2D();
		
		Button liner=new Button("LINE");
		//liner.setOnAction(t->{
			pane.setOnMousePressed(e->{        
				x=e.getX();y=e.getY();
			});
			pane.setOnMouseDragged(e->{
				Line line=new Line(x,y,e.getX(),e.getY());
				x=e.getX();y=e.getY();
				pane.getChildren().add(line);
			});
			pane.setOnMouseReleased(e->{
				Line line=new Line(x,y,e.getX(),e.getY());
				x=e.getX();y=e.getY();
				pane.getChildren().add(line);
			});
		//});
		Button lastik=new Button("lastik");
		lastik.setOnAction(e->{
			pane.setOnMouseDragged(t->{
				Rectangle rec=new Rectangle(t.getX(),t.getY(),10,10);
				rec.setFill(Color.WHITE);
				pane.getChildren().add(rec);
			});
		});
		Button cir=new Button("CIRCLE");
		cir.setOnAction(t->{
			Pane p=new Pane();
			pane.setOnMousePressed(e->{      
				x=e.getX();y=e.getY();
				pane.getChildren().remove(p);
			});
			pane.setOnMouseDragged(e->{				
				Circle circle=new Circle(Math.abs((e.getX()-x)/2+x),Math.abs((e.getY()-y)/2+y),Math.abs((e.getX()-x)/2));
				circle.setFill(Color.color(0,0,0,0));
				circle.setStroke(Color.BLACK);
				p.getChildren().clear();
				p.getChildren().add(circle);
				pane.getChildren().add(p);
			});
			pane.setOnMouseReleased(e->{
				Circle circle=new Circle(Math.abs((e.getX()-x)/2+x),Math.abs((e.getY()-y)/2+y),Math.abs((e.getX()-x)/2));
				circle.setFill(Color.color(0,0,0,0));
				circle.setStroke(Color.BLACK);
				pane.getChildren().remove(p);
				pane.getChildren().add(circle);
			});
		});
		Button rect=new Button("RECTANGLE");
		rect.setOnAction(t->{
			Pane p=new Pane();
			pane.setOnMousePressed(e->{
				x=e.getX();y=e.getY();
				pane.getChildren().remove(p);
			});
			pane.setOnMouseDragged(e->{
				Rectangle rec=new Rectangle(x<e.getX()?x:Math.abs(e.getX()-x),y<e.getY()?y:Math.abs(e.getY()-y),x<e.getX()?Math.abs(e.getX()-x):x,y<e.getY()?Math.abs(e.getY()-y):y);
				rec.setFill(Color.color(0,0,0,0));
				rec.setStroke(Color.BLACK);
				p.getChildren().clear();
				p.getChildren().add(rec);
				pane.getChildren().add(p);				
			});
			pane.setOnMouseReleased(e->{
				Rectangle rec=new Rectangle(x<e.getX()?x:Math.abs(e.getX()-x),y<e.getY()?y:Math.abs(e.getY()-y),x<e.getX()?Math.abs(e.getX()-x):x,y<e.getY()?Math.abs(e.getY()-y):y);
				rec.setFill(Color.color(0,0,0,0));
				rec.setStroke(Color.BLACK);
				pane.getChildren().add(rec);
			});
		});
		HBox h=new HBox();
		h.getChildren().addAll(lastik,liner,cir,rect);
		pane.getChildren().add(h);
		Scene scene=new Scene(pane,500,500,Color.color(0,0,0,0));
		gui.setScene(scene);
		gui.show();
		pane.getChildren().add(c);
	}
}