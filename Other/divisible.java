import java.math.BigInteger;
public class divisible{
    public static void main(String[] args) {
    long num=(Long.MAX_VALUE);
    BigInteger res=BigInteger.valueOf(num);
    double d=(double)num;
    BigInteger t=new BigInteger(Integer.toString(1));
    BigInteger b=new BigInteger(Integer.toString(5));
    BigInteger a=new BigInteger(Integer.toString(6));
    for (int i=0;i<30;i++){
        res=res.add(t);
        if((res.remainder(a).equals(BigInteger.ZERO)) || (res.remainder(b).equals(BigInteger.ZERO)))
            System.out.println(res);
        }
    }
}