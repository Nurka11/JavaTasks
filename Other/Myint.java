class Myint{
	private static int value;
	public static int getMyint(){
		return value;
	}
	public  Myint(int u){
		value =u;
	}
	static boolean iseven(Object n){
		if (value%2==0)
			return true;
		else return false;
	} 
	static boolean isodd(Object o){
		if (value%2!=0)
			return true;
		else return false;
	} 
	static boolean isprime(Object s){
		double p=value*1.0;
		int y=value;
		if (value==1 || value==2)
			return true;
		else if(p/2==((int)(y/2)) || p/3==((int)(y/3)) || p/Math.sqrt(p)==((int)(y/Math.sqrt(y)))){
			return false;
		}
		return true;
	} 
	public static void main(String[] args){
		Myint mi=new Myint(15);
		Myint r=new Myint(21);
		System.out.println(iseven(mi));
		//System.out.println(mi.isodd());
		//System.out.println(mi.isprime());
	}
}