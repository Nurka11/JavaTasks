import java.util.Scanner;
class primen{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int f=a;
		int d=1;
		String c="";
		int[] b={2,3,5,7,9,11,13,17,19,21,23,29,31,37,41,43,47,51,53,57,59,61,67,71,73,79,83,87,89,91,97,101,103,107,109,113,119,127};
		for(int i=0;i<b.length;i++){
			if(a/(b[i]*1.0)==((int)(a/b[i]))){
				a=a/b[i];
				d*=b[i];
				if (d==f)
					c+=b[i]+"=";
				else
					c+=b[i]+"*";
				i=i-1;
			}
				
		}
		System.out.println(c+d);
	}
}