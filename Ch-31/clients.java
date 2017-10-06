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
public class clients extends Application{
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	ObjectInputStream inlist;
	ArrayList<DataOutputStream> list;
	public void start(Stage gui) throws Exception{
		BorderPane pane=new BorderPane();
		TextArea text=new TextArea();
		pane.setCenter(text);
		try{set();}catch(Exception k){}
		Thread t=new Thread(()->{
			while(true){
				try{
					text.appendText(in.readUTF()+"\n");
				}catch(Exception f){}
			}
		});
		t.start();
		Thread t1=new Thread(()->{
			TextField text1=new TextField();
			pane.setBottom(text1);
			text1.setOnAction(e->{
				try{
					out.writeUTF(text1.getText());
					text1.setText("");}
				catch(Exception i){}
			});
		});
		t1.start();
		Scene scene=new Scene(pane,400,400);
		gui.setScene(scene);
		gui.setTitle("CLIENT");
		gui.show();
	}
	public void set() throws Exception{
		socket=new Socket("192.168.43.225",8000);
		in=new DataInputStream(socket.getInputStream());
		out=new DataOutputStream(socket.getOutputStream());
		//inlist=new ObjectInputStream(socket.getInputStream());
		//System.out.println(in.readUTF());
	}
}
