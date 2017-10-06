import java.util.Scanner;
public class pattern{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string s1: ");
		String s1=sc.nextLine();
		System.out.print("Enter a string s2: ");
		String s2=sc.nextLine();
		String[] h=s1.split(s2);
		System.out.print("matched at index "+h[0].length());
	}
}