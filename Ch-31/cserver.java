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
import java.io.*;
public class cserver {
	
	static ArrayList<PrintWriter> arrayList;
	
	private static void start() {
		try {
			ServerSocket ss = new ServerSocket(8000);
			while(true) {
				Socket sock = ss.accept();
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				InputStreamReader is = new InputStreamReader(sock.getInputStream());
				BufferedReader reader = new BufferedReader(is);
				System.out.println("user");
				arrayList.add(writer);
				
				Thread thread = new Thread(new Listener(sock));
				thread.start();
				
			}
			
		} catch (Exception ex) {}
	}
	
	private static class Listener implements Runnable {
		BufferedReader reader;
		public Listener(Socket sock) throws Exception{
			InputStreamReader is = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(is);
		} 
		@Override
		public void run() {
			String message;
			try{
			while ((message = reader.readLine()) != null ) {
				for (int i = 0; i < arrayList.size(); i++) {
					PrintWriter writer = arrayList.get(i);
					writer.println(message);
					writer.flush();
				}
			}}catch(Exception e){}
		}
	}
	
	public static void main(String[] args) {
		start();
	}
}