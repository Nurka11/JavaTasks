import java.util.*;
class sumseries{
	public static void main(String[] args){
		for(int i=0;i<10;i++){
			System.out.println(sum(i));
		}
	}
	public static double sum(int k){
		double s=k*1.0/(2*k+1);
		if(k==0)return s;
		return s+sum(k-1);
	} 
}