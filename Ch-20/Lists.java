import java.util.*;
import java.io.*;
public class Lists{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc=new Scanner(System.in);
		ArrayList<String> list=new ArrayList<>();
		int index=0;
		int sum=0;
		String pos="";
		for(int i=0;i<4;i++){
			list.add(sc.next());
		}
		for(int i=0;i<list.size()/2;i++){
			if(list.get(i).contains("{") || list.get(i).contains("[") || list.get(i).contains("(")){
				sum++;
			}
			else {index=i;break;} 
		}
		int lim=0;
		for(int i=index+1;i<list.size();i++){
			if(list.get(sum).equals("}")){pos="{";sum--;}
			else if(list.get(sum).equals("]")){pos="[";sum--;}
			else if(list.get(sum).equals(")")){pos="(";sum--;}
			if(!list.get(i).equals(pos)){System.out.println(list.get(i)+" "+pos);System.exit(0);};
		}
		System.out.println("Yes");
	}
}