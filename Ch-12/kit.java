import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.image.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
public class kit  extends Application{
	public void start(Stage gui){
		//Image i=new Image("12011.jpeg");
		
		//ImageView im=new ImageView(i);
		Button b=new Button("");
		b.setOnAction((ActionEvent event) -> {
            b.setText("X");     
        });
		Button bt=new Button("");
		bt.setOnAction((ActionEvent event) -> {
            bt.setText("O");     
        });
		Pane p=new HBox(2);
		p.setPadding(new Insets(5,5,5,5));
		//p.getChildren().add(im);
		p.getChildren().add(b);
		p.getChildren().add(bt);
		Scene s=new Scene(p);
		gui.setScene(s);
		gui.show();
	}
} 