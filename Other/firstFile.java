import java.util.Scanner;
import java.io.*;
class firstFile{
	public static void main(String[] args) throws FileNotFoundException{
		String word=args[0],filename=args[1];
		File file = new File(filename);
		Scanner fin=new Scanner(file);
		String s="";
		while (fin.hasNext())
			s+=fin.nextLine();
		s=s.replace(word,"");
		fin.close();
		PrintWriter printer=new PrintWriter(file);
		printer.print(s);
		printer.close();
	}
}