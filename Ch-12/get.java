import java.net.*;
import java.io.*;
class get{
	public static void main(String[] args){
		InetAddress address=null;
		try{
			address=InetAddress.getByName(args[0]);
		}catch(Exception e){
			System.out.println(address);
		}
	}
}