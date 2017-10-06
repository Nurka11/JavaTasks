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
public class connect extends Application{
	String driver,dbUrl,userName,password;
	public void start(Stage gui){
		Pane pane = new VBox();
		Label label = new Label("No connection");
		TextField drive = new TextField("");
		drive.setOnAction(e->{
			driver = drive.getText();
		});
		Label dl = new Label("JDBC Drive",drive);
		dl.setContentDisplay(ContentDisplay.RIGHT);
		TextField dburl = new TextField("");
		dburl.setOnAction(e->{
			dbUrl = dburl.getText();
		});
		Label dbul = new Label("Database URL",dburl);
		dbul.setContentDisplay(ContentDisplay.RIGHT);
		TextField user = new TextField("");
		user.setOnAction(e->{
			userName = user.getText();
		});
		Label ul = new Label("Username",user);
		ul.setContentDisplay(ContentDisplay.RIGHT);
		PasswordField p = new PasswordField();
		p.setOnAction(e->{
			password = p.getText();
		});
		Label pl = new Label("Password",p);
		pl.setContentDisplay(ContentDisplay.RIGHT);
		Button c = new Button("Connect to DB");
		c.setOnAction(e->{
			try{
				Class.forName(driver);
				System.out.println("Driver loaded");
				Connection co=DriverManager.getConnection(dbUrl,userName,password);
				label.setText("Database connected to "+dbUrl);
			}catch(Exception ex){}
		});
		pane.getChildren().addAll(label,dl,dbul,ul,pl,c);
		Scene scene = new Scene(pane,300,250);
		gui.setScene(scene);
		gui.show();
	}
}