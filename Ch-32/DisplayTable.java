import java.net.*;
import java.io.*;
import java.util.*;
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
import java.sql.*;
import javafx.util.*;
import javafx.application.Platform;
import java.util.concurrent.*;
import javafx.concurrent.*;
public class DisplayTable extends Application{
	String id,res;
	String h="ssn\tcourseId\tdataRegitered\tgrade";
	public void start(Stage gui) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded ");
		Connection co=DriverManager.getConnection("jdbc:mysql://localhost/passwords","root","nurnur11");
		System.out.println("Database connected");
		Statement st=co.createStatement();
		Pane p = new HBox();
		Label label = new Label("Table Name");
		TextField text = new TextField("");
		text.setOnAction(e->{
			id = text.getText();
		});
		Button show = new Button("Show Contents");
		p.getChildren().addAll(label,text,show);
		Label l = new Label("ssn\tcourseId\tdataRegitered\tgrade");
		show.setOnAction(e->{
			try{
				String i = "select ssn,courseId,data,grade from "+id;
				ResultSet r = st.executeQuery(i);
				res+=h+"\n";
				while(r.next()){
					res+=r.getString(1)+"\t"+r.getString(2)+"\t"+r.getString(3)+"\t"+r.getString(4)+"\n";
				}
				System.out.println(res);
				l.setText(res);
			}catch(Exception ex){}
		});
		Pane pane = new VBox();
		pane.getChildren().addAll(p,l);
		Scene scene = new Scene(pane,300,200);
		gui.setScene(scene);
		gui.show();
	}
}