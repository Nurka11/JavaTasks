import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
public class Flag extends Application {
	ImageView imageView;
	public void start(Stage gui){
		Pane pane = new Pane();
		imageView = new ImageView("image.jpg");
		imageView.setFitWidth(100);
		imageView.setFitHeight(100);
		pane.getChildren().add(imageView); 
		Thread t=new Thread(new join());
		t.start();
		Scene scene = new Scene(pane, 300, 300); 
		gui.setScene(scene); 
		gui.show(); 
	}
	public class join implements Runnable{
		public void run(){
			int i=0;
			while(true){
			try{while(i<200){
				imageView.setTranslateY(i);i++;
				Thread.sleep(10);
			}}catch(Exception e){}
			try{while(i>0){
				imageView.setTranslateY(i);i--;
				Thread.sleep(10);
			}}catch(Exception e){}}
		}
	}
}