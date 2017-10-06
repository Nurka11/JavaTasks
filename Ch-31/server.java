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
public class server extends Application{
	ServerSocket server;
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	TextArea text2;
	TextArea text1;
	TextField text;
	ArrayList<DataOutputStream> list=new ArrayList<>();
	public void start(Stage gui) throws Exception{
		BorderPane pane=new BorderPane();
		Thread t=new Thread(()->{
			try{
				set();}catch(Exception n){}
		});
		t.start();
		Pane vp=new VBox();
		text1=new TextArea();
		Label l=new Label("Client",text1);
		l.setContentDisplay(ContentDisplay.BOTTOM);
		vp.getChildren().add(l);
		// Thread t1=new Thread(()->{
			// while(true){
				// try{
					// String h=in.readUTF();
					// text1.appendText(h+"\n");
					// for(DataOutputStream d:list)
						// d.writeUTF(h);
				// }catch(Exception f){}
			// }
		// });
		// t1.start();
		text2=new TextArea();
		Label la=new Label("Client",text2);
		la.setContentDisplay(ContentDisplay.BOTTOM);
		vp.getChildren().add(la);
		text=new TextField();
		pane.setBottom(text);
		pane.setCenter(vp);
		// text.setOnAction(e->{
			// try{
				// out.writeUTF(text.getText());
				for(DataOutputStream d:list)
						d.writeUTF(text.getText());
				// text2.appendText(text.getText()+"\n");
				// text.setText("");}
			// catch(Exception i){}
		// });
		Scene scene=new Scene(pane,400,400);
		gui.setScene(scene);
		gui.setTitle("SERVER");
		gui.show();
	}
	public void set() {
			try{
				server=new ServerSocket(8000);
			}catch(Exception l){};
			while(true){try{
				socket=server.accept();
				in=new DataInputStream(socket.getInputStream());
				out=new DataOutputStream(socket.getOutputStream());list.add(out);
				//outlist=new ObjectOutputStream(socket.getOutputStream());outlist.writeObject(list);
				out.writeUTF("Connected!!!");}catch(Exception j){}}
				Thread t1=new Thread(()->{
					while(true){
						try{
							String h=in.readUTF();
							text1.appendText(h+"\n");
							for(DataOutputStream d:list)
								d.writeUTF(h);
						}catch(Exception f){}
					}
				});
				t1.start();
			
				text.setOnAction(e->{
					try{
						//out.writeUTF(text.getText());
						for(DataOutputStream d:list)
								d.writeUTF(text.getText());
						text2.appendText(text.getText()+"\n");
						text.setText("");}
					catch(Exception i){}
				});
	}
}