import java.math.*;
public class factorial{
	public static void main(String[] args){
		System.out.println(f(100));
	}
	static BigInteger f(long n){
		BigInteger res=BigInteger.ONE;
		if(BigInteger.valueOf(n)==BigInteger.ZERO)return res;
		return BigInteger.valueOf(n).multiply(f(n-1));
	}
}