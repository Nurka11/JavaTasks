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
import javafx.collections.*;
import javafx.application.Platform;
import java.util.concurrent.*;
import javafx.concurrent.*;
public class ShowTables extends Application{
	String id,res,res1;
	String h="ssn\tcourseId\tdataRegitered\tgrade";
	String k="id\tname\tcourse\tgrade";
	public void start(Stage gui) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded ");
		Connection co=DriverManager.getConnection("jdbc:mysql://localhost/passwords","root","nurnur11");
		System.out.println("Database connected");
		Statement st=co.createStatement();
		ObservableList<String> items=FXCollections.observableArrayList();
		items.addAll("Enrollment","Student");
		ComboBox pos=new ComboBox(items);
		Pane p = new HBox();
		Label label = new Label("Table Name");
		Button show = new Button("Show Contents");
		p.getChildren().addAll(label,pos);
		Label l = new Label("");
		pos.setOnAction(e->{
			switch((String)pos.getValue()){
				case "Enrollment":
					try{
						res="";
						String i = "select * from Enrollment";
						ResultSet r = st.executeQuery(i);
						res+=h+"\n";
						while(r.next()){
							res+=r.getString(1)+"\t"+r.getString(2)+"\t"+r.getString(3)+"\t"+r.getString(4)+"\n";
						}
						System.out.println(res);
						l.setText(res);
					}catch(Exception ex){}
				break;
				case "Student":
					try{
						res1="";
						String ip = "select * from Student";
						ResultSet rl = st.executeQuery(ip);
						res1+=k+"\n";
						while(rl.next()){
							res1+=rl.getString(1)+"\t"+rl.getString(2)+"\t"+rl.getString(3)+"\t"+rl.getString(4)+"\n";
						}
						System.out.println(res1);
						l.setText(res1);
					}catch(Exception ex){}
				break;
			}
		});
		Pane pane = new VBox();
		pane.getChildren().addAll(p,l);
		Scene scene = new Scene(pane,300,200);
		gui.setScene(scene);
		gui.show();
	}
}