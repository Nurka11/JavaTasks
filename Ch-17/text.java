import java.util.*;
import java.io.*;
public class text{
	public static void main(String[] args) throws Exception{
		PrintWriter out=new PrintWriter("numbers.txt");
		Random r=new Random();
		for(int i=0;i<100;i++)
			out.write(r.nextInt(101)+" ");
		out.close();
	}
}