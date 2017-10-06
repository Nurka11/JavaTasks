import java.util.*;
public class maxsubstring{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s=sc.nextLine();
		String[] h=s.split("");
		String j="";
		String k="";
		for(int i=0;i<s.length();i++){
			if(!j.contains(h[i])){
				j+=h[i];
			}
			else{
				k=(k.length()>j.length()?k:j);
				j=h[i];
			}
		}
		System.out.println(k.length()>j.length()?k:j);
	}
}