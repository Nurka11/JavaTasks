import java.util.*;
public class binary{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String Binary = sc.next();
		int san = Binary.length();
		int sum = 0;
		for(int i=san;i>0;i--){
			sum+=Math.pow(2*Integer.parseInt(Binary.charAt(i-1)+""),san-i);
		}
		System.out.println(sum);
}
}