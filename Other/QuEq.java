import java.util.*;
class QuEq{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String Binary="";
		while(t!=0){
			Binary+=t%2;
			t=t/2;
		}
		for(int i=Binary.length();i>0;i--)
			System.out.print(Binary.charAt(i-1));
	}
	
	
}