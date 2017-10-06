import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
class first{
	public static void main(String[] args) throws IOException{
		File file = new File("input.txt");
		Scanner sc=new Scanner(file);
		int c=0;
		ArrayList list=new ArrayList<>();
		while(sc.hasNext()){
			list.add(sc.nextLine());c++;
		}
		Scanner scan=new Scanner(System.in);
		String h=scan.nextLine();
		for(int i=0;i<c;i++){
			if(((String)list.get(i)).contains(h)){
				String u =(String) list.get(i);
				String[] uu=u.split(":");
				try{
					System.out.println(uu[1]);
				}catch(Exception e){System.out.println("She/he was absent");}
			}
		}
	}
}