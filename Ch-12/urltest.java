import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.net.*;
class urltest{
	public static void main(String[] args) throws IOException{
		String site="http://cs.armstrong.edu/liang";
		URL url=new URL(site);
		Scanner win=new Scanner(url.openStream());
		ArrayList list=new ArrayList<>();
		while(win.hasNext()){				
			String a=win.next();
			list.add(a);
			if(a.contains("http:")){
				String[] f=a.replace("=",">").split(">");
				String gl=f[1].substring(1,f[1].length()-1);
				url=new URL(gl);
				win=new Scanner(url.openStream());
				while(win.hasNext()){
					if((win.nextLine()).contains("Liang")){
						System.out.println(url);break;
					}
				}
				url=new URL("http://cs.armstrong.edu/liang");
				win=new Scanner(url.openStream());
			}if((win.nextLine()).contains("Computer Programming"))System.out.println("sdf");
		}
	}	
}