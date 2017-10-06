public class sumDigits{
	public static void main(String[] args){
		System.out.println(sum(234));
	}
	public static int sum(long n){
		int k=(int)n-((int)n/10)*10;
		if(n==0)return k;
		return k+sum(n/10);
	}
}