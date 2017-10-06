import java.util.Scanner;
public class qwr{
	public static void main(String[] main){
		Scanner sc=new Scanner(System.in);
		
		int k=sc.nextInt();
		System.out.println(qwer(k));
	}
	static int qwer(int j){
			int f=0;
			if(j%2==0){
				f+=j;
				return(qwer(j--));
			}else if(j==0){
				return f;
			}else{
				f+=(-j);
				return(qwer(j--));
			}
			
		}
	
}