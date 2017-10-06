import java.io.*;
public class writer{
	public static void main(String[] args) throws Exception{
		DataOutputStream file=new DataOutputStream(new FileOutputStream("ghjk.dat"));
		for(int i=1;i<6;i++)
		file.writeInt(i);
		file.writeDouble(5.5);
		file.close();
	}
}