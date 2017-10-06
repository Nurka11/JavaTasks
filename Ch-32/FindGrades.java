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
public class FindGrades extends Application{
	String res,id;
	public void start(Stage gui) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded ");
		Connection co=DriverManager.getConnection("jdbc:mysql://localhost/passwords","root","nurnur11");
		System.out.println("Database connected");
		Statement st=co.createStatement();
		Pane p = new HBox();
		Label label = new Label("SSN");
		TextField text = new TextField("ID");
		text.setOnAction(e->{
			id = text.getText();
		});
		Button show = new Button("Show Grade");
		p.getChildren().addAll(label,text,show);
		Label l = new Label("");
		show.setOnAction(e->{
			try{
				String i = "select name,course,grade from Student where id ='"+id+"'";
				ResultSet r = st.executeQuery(i);
				while(r.next()){
					res+=r.getString(1)+"'s grade on course "+r.getString(2)+" is "+r.getString(3)+"\n";
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