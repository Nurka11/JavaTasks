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
import javafx.util.*;
import javafx.application.Platform;
import java.util.concurrent.*;
import javafx.concurrent.*;
public class cclient extends Application{
	PrintWriter writer;
	ArrayList<DataOutputStream> list;
	
	public void start(Stage gui){
		BorderPane pane=new BorderPane();
		TextArea text=new TextArea();
		Label l=new Label("Client",text);
		l.setContentDisplay(ContentDisplay.BOTTOM);
		Pane vp=new VBox();
		vp.getChildren().add(l);
		try{set();}catch(Exception e){}
		TextArea text2=new TextArea();
		Label la=new Label("Client",text2);
		la.setContentDisplay(ContentDisplay.BOTTOM);
		vp.getChildren().add(la);
		pane.setCenter(vp);
		TextField text1=new TextField();
		pane.setBottom(text1);
		
		text1.setOnAction(e->{
			send(text1.getText());
		});
		
		Scene scene=new Scene(pane,400,400);
		gui.setScene(scene);
		gui.setTitle("CLIENT");
		gui.show();
	}
	public void set() throws Exception{
		Socket sock = new Socket("localhost",8000);
		InputStreamReader is = new InputStreamReader(sock.getInputStream());
		BufferedReader reader = new BufferedReader(is);
		writer = new PrintWriter(sock.getOutputStream());
		
		Thread thread = new Thread(new Listener(reader));
		thread.start();
	}
	
	private void send(String message) {
		writer.println(message);
		writer.flush();
	}
	
	private class Listener implements Runnable {
		String message;
		BufferedReader reader;
		public Listener(BufferedReader reader) {
			this.reader = reader;
		}
		@Override
		public void run() {
			try{
			while ((message = reader.readLine()) != null ) {
				// read
			}}catch(Exception e){}
		}
	}
	
	public void main(String[] args) {
		launch(args);
	}
}
