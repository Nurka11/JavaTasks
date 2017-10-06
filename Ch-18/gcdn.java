public class gcdn{
	public static void main(String[] args){
		System.out.println(gcd(16,24));
	}
	static int gcd(int a,int b){
		if(b==0)return a;
		return gcd(b,b%a);
	}
}