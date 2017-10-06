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
public class StaffTable extends Application{
	String id,lastName,firstName,address;
	Statement st;
	public void start(Stage gui) throws Exception{
		Pane pane = new VBox();
		set();
		TextField ID = new TextField("");
		ID.setOnAction(e->{
			id=ID.getText();
		});
		Label IDL = new Label("ID",ID);
		IDL.setContentDisplay(ContentDisplay.RIGHT);
		TextField Last = new TextField("");
		Last.setOnAction(e->{
			lastName=Last.getText();
		});
		Label LastL = new Label("LastName",Last);
		LastL.setContentDisplay(ContentDisplay.RIGHT);
		TextField First = new TextField("");
		First.setOnAction(e->{
			firstName=First.getText();
		});
		Label FirstL = new Label("FirstName",First);
		FirstL.setContentDisplay(ContentDisplay.RIGHT);
		TextField Address = new TextField("");
		Address.setOnAction(e->{
			address=Address.getText();
		});
		Label AddressL = new Label("Address",Address);
		AddressL.setContentDisplay(ContentDisplay.RIGHT);
		Button Insert = new Button("Insert");
		Insert.setOnAction(e->{
			try{
				insert();
			}catch(Exception ex){}
		});
		Button Update = new Button("Update");
		Update.setOnAction(e->{
			try{
				update();
			}catch(Exception ex){}
		});
		Button view = new Button("View");
		view.setOnAction(e->{
			try{
				View();
			}catch(Exception ex){}
		});
		pane.getChildren().addAll(IDL,LastL,FirstL,AddressL,Insert,Update,view);
		Scene scene = new Scene(pane,400,250);
		gui.setScene(scene);
		gui.show();
	}
	public void set() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded ");
		Connection co=DriverManager.getConnection("jdbc:mysql://localhost/passwords","root","nurnur11");
		System.out.println("Database connected");
		st=co.createStatement();
	}
	public void insert() throws Exception{
		String i = "insert into Staff(id,lastName,firstName,address)"+"values('"+id+"','"+lastName+"','"+firstName+"','"+address+"')";
		st.executeUpdate(i);
	}
	public void update() throws Exception{
		String i = "update Staff set lastName ='"+lastName+"',firstName ='"+firstName+"',address ='"+address+"' where id ='"+id+"'";
		st.executeUpdate(i);
	}
	public void View() throws Exception{
		String i = "select id,lastName,FirstName,address from Staff";
		String res = "";
		ResultSet r = st.executeQuery(i);
		while(r.next()){
			res+=r.getString(1)+"\t"+r.getString(2)+"\t"+r.getString(3)+"\t"+r.getString(4)+"\n";
		}
		Stage gui = new Stage();
		Pane pane = new Pane();
		Label label = new Label(res);
		pane.getChildren().add(label);
		Scene scene = new Scene(pane,400,400);
		gui.setScene(scene);
		gui.show();
	}
}