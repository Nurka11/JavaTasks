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
public class client extends Application{
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	ObjectInputStream inlist;
	ArrayList<DataOutputStream> list;
	public void start(Stage gui) throws Exception{
		BorderPane pane=new BorderPane();
		TextArea text=new TextArea();
		Label l=new Label("Client",text);
		l.setContentDisplay(ContentDisplay.BOTTOM);
		Pane vp=new VBox();
		vp.getChildren().add(l);
		try{set();}catch(Exception k){}
		Thread t=new Thread(()->{
			while(true){
				try{
					String h=in.readUTF();
					text.appendText(h+"\n");
				}catch(Exception f){}
			}
		});
		t.start();
		TextArea text2=new TextArea();
		Label la=new Label("Client",text2);
		la.setContentDisplay(ContentDisplay.BOTTOM);
		vp.getChildren().add(la);
		pane.setCenter(vp);
		TextField text1=new TextField();
		pane.setBottom(text1);
		text1.setOnAction(e->{
			try{
				out.writeUTF(text1.getText());out.flush();
				text2.appendText(text1.getText()+"\n");
				text1.setText("");}
			catch(Exception i){}
		});
		Scene scene=new Scene(pane,400,400);
		gui.setScene(scene);
		gui.setTitle("CLIENT");
		gui.show();
	}
	public void set() throws Exception{
		socket=new Socket("localhost",8000);
		in=new DataInputStream(socket.getInputStream());
		out=new DataOutputStream(socket.getOutputStream());
		//inlist=new ObjectInputStream(socket.getInputStream());
		//System.out.println(in.readUTF());
	}
}
