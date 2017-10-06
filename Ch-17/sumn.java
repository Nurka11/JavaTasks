import java.io.*;
public class sumn{
	public static void main(String[] args) throws Exception{
		DataOutputStream out=new DataOutputStream(new FileOutputStream("num.dat"));
		for(int i=1;i<101;i++)out.writeInt(i);
		DataInputStream in=new DataInputStream(new FileInputStream("num.dat"));
		int sum=0;
		while(in.read()!=-1)sum+=in.readInt();
		System.out.println(sum);
	}
}