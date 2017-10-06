import java.util.*; 
import java.io.*;
public class Keys{
	public static void main(String[] args) throws Exception{
		Scanner input=new Scanner(System.in);
		String filename=args[0];
		File file=new File(filename);
		if(file.exists()){
			System.out.println("The number of keywords in "+filename+" is "+countKeywords(file));
		}
	}
	public static int countKeywords(File file)throws Exception{
		String[] keys1={"abstract", "assert", "boolean","break", "byte", "case", "catch", "char", "class", "const",
		"continue", "default", "do", "double", "else", "enum",
		"extends", "for", "final", "finally", "float", "goto",
		"if", "implements", "import", "instanceof", " int ",
		"interface", "long", "native", "new", "package", "private",
		"protected", "public", "return", "short", "static",
		"strictfp", "super", "switch", "synchronized", "this",
		"throw", "throws", "transient", "try", "void", "volatile",
		"while", "true", "false", "null"};
		int count=0;
		Scanner input=new Scanner(file);
		String s="";
		// while(input.hasNext()){
			// String word=input.next();
			// if(keys.contains(word))count++;
		// }
		input=new Scanner(file);
		String jk="";
		String coment="";
		while(input.hasNext()){
			jk=((input.nextLine()).replace("\"","\"</font>")).replaceFirst("\"</font>","<font color=\"green\">\"");
			if(jk.contains("//")){
				s+="<font color=\"green\">"+jk.replace("\t","&emsp;")+"</font>"+"<br>";
			}
			else{
				if(jk.contains("/*")){
					s+="com";
					coment+=jk.replace("/*","<font color=\"green\">/*").replace("\t","&emsp;")+"<br>";
					String j=input.nextLine();
					while(!j.contains("*/")){
						coment+=j.replace("\t","&emsp;")+"<br>";
						j=input.nextLine();
					}
					coment+=j.replace("\t","&emsp;")+"</font>"+"<br>";
				}
				else{
					s+=jk.replace("\t","&emsp;")+"<br>";
				}
			}
		}
		for(int i=0;i<keys1.length;i++)s=s.replace(""+keys1[i],"<font color=\"red\">"+keys1[i]+"</font>");
		s=s.replace("com",coment);
		input=new Scanner(new File("qwert.html"));
		PrintWriter fin=new PrintWriter("qwert.html");
		fin.write("<html>");fin.write("<head>");fin.write("<body>");fin.write(s);
		fin.write("</body>");fin.write("</head>");fin.write("</html>");fin.close();
		return count;
	}
}