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
public class service extends Application{
	ServerSocket server;
	Socket socket;
	DataInputStream in;
	DataOutputStream out;

	ArrayList<DataOutputStream> list=new ArrayList<>();
	public void start(Stage gui) throws Exception{
		BorderPane pane=new BorderPane();
		Thread t=new Thread(()->{
			try{
				set();}catch(Exception n){}
		});
		t.start();
		TextArea text1=new TextArea();
		pane.setCenter(text1);
		Thread t1=new Thread(()->{
			while(true){
				try{
					String h=in.readUTF();
					text1.appendText(h+"\n");
					for(int i=0;i<list.size();i++)
						(list.get(i)).writeUTF(h);
				}catch(Exception f){}
			}
		});
		t1.start();
		TextField text=new TextField();
		pane.setBottom(text);
		text.setOnAction(e->{
			try{
				for(int i=0;i<list.size();i++)
					(list.get(i)).writeUTF(text.getText());
				text.setText("");}
			catch(Exception i){}
		});
		Scene scene=new Scene(pane,400,400);
		gui.setScene(scene);
		gui.setTitle("SERVER");
		gui.show();
	}
	public void set() {
		Thread t=new Thread(()->{
			try{server=new ServerSocket(8000);}catch(Exception l){};
			while(true){try{
				socket=server.accept();
				in=new DataInputStream(socket.getInputStream());
				out=new DataOutputStream(socket.getOutputStream());list.add(out);
				//outlist=new ObjectOutputStream(socket.getOutputStream());outlist.writeObject(list);
				out.writeUTF("Connected!!!");
			}catch(Exception j){}}
		});	
		t.start();
	}
}