import java.util.*;
public class decimal{
	public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	int A = scanner.nextInt();	
	int B = scanner.nextInt();	
	int C = scanner.nextInt();	
	double x1,x2;
	int D = B*B-4*A*C;
	if(D==0){
		x1 = -1*B/(2*A);
		System.out.println(x1);
	}
	else if (D>0){
		x1 = (-1*B+Math.sqrt(D))/(2*A);
		x2 = (-1*B-Math.sqrt(D))/(2*A);
		System.out.println("x1 "+x1+" x2 "+x2);
	}
		
	}
}