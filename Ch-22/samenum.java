import java.util.*;
public class samenum{
	public static void main(String[] args){
		System.out.println("Enter a series of numbers ending with 0: ");
		Scanner sc=new Scanner(System.in);
		String s="";
		int a=sc.nextInt(),count=0;
		while(a!=0){
			s+=a;a=sc.nextInt();
		}
		String[] h=s.split("");
		String j="";
		String k="";
		for(int i=0;i<s.length();i++){
			if(j.contains(h[i])){
				j+=h[i];
			}
			else{
				k=(k.length()>j.length()?k:j);
				j=h[i];
			}
		}
		k=(k.length()>j.length()?k:j);
		for(int i=0;i<s.length();i++){if(h[i].equals(k.substring(0,1))){count=i;break;}}
		System.out.println("The larg number starts in "+count+" with "+k.length()+" values of "+k.substring(0,1));
	}
}