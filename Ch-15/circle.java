import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class circle extends Application{
	public void start(Stage gui){
		ballpane ball=new ballpane();
		ball.paintb();
		Circle circle=new Circle(100,100,25);
		// Button right=new Button("Right");
		// Button left=new Button("Left");
		// Button up=new Button("up");
		// Button down=new Button("down");		
		// right.setOnAction(e -> {
			// ball.mover();
		// });
		// left.setOnAction(e -> {
			// ball.movel();
		// });
		// up.setOnAction(e -> {
			// ball.moveu();
		// });
		// down.setOnAction(e -> {
			// ball.moved();
		// });
		
		Pane bt=new HBox();
		//bt.getChildren().addAll(right,left,up,down);
		BorderPane bpane=new BorderPane();
		bpane.setOnKeyPressed(e ->{
			switch (e.getCode()){
				case S:ball.moved();break;
				case W:ball.moveu();break;
				case D:ball.mover();break;
				case A:ball.movel();break;
			}
		});
		
		bpane.setCenter(ball);
		bpane.setBottom(bt);
		Scene scene=new Scene(bpane,400,400);
		gui.setScene(scene);
		gui.show();
		bpane.requestFocus();
	}
	class ballpane extends Pane{
		Circle circle=new Circle(100,100,25);
		int x=100;
		int y=100;
		int r=25;
		void mover(){
			x+=10;paintb();
		}void movel(){
			x-=10;paintb();
		}void moveu(){
			y-=10;paintb();
		}void moved(){
			y+=10;paintb();
		}
		void paintb(){
			getChildren().clear();
			circle=new Circle(x,y,r);
			getChildren().add(circle);
		}
		
	}
}