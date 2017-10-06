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
public class binary extends Application{
	public void start(Stage gui){
		Pane pane=new VBox();
		TextField dec=new TextField("DecimalNumber");
		TextField hex=new TextField("Hexedecimal number");
		TextField bin=new TextField("Binary number");
		dec.setOnAction(e->{
			hex.setText(Integer.toHexString(Integer.parseInt(dec.getText())));
			bin.setText(Integer.toBinaryString(Integer.parseInt(dec.getText())));
		});
		hex.setOnAction(e->{
			dec.setText(""+(Integer.parseInt(hex.getText(),16)));
			bin.setText(Integer.toBinaryString(Integer.parseInt(dec.getText())));
		});
		bin.setOnAction(e->{
			dec.setText(""+(Integer.parseInt(bin.getText(),2)));
			hex.setText(Integer.toHexString(Integer.parseInt(dec.getText())));
		});
		pane.getChildren().addAll(dec,hex,bin);
		Scene scene=new Scene(pane,400,400);
		gui.setScene(scene);
		gui.show();
		
	}
}