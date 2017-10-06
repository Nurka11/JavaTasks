import java.util.*;
public class Calc{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String a = scn.nextLine();
		String[] sandar = a.split("[-/*+]");
		String[] tanba = a.split("[0123456789]");
		int res = 0;
		for(int a = 0;a<tanba.length;a++){
			if(tanba[a]=="*"){
				res = Integer.parseInt(sandar[a])*Integer.parseInt(sandar[a+1]); 
			}
		}
		System.out.println(res);
	}
}