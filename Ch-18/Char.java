public class Char{
	public static void main(String[] args){
		System.out.println(count("Welcome",'e'));
	}
	public static int count(String s,char c){
		if(s.length()==0)return 0;
		char c1=s.charAt(s.length()-1);
		return c1==c?1+count(s.substring(0,s.length()-1),c):count(s.substring(0,s.length()-1),c);
	}
}