public class sreverse{
	public static void main(String[] args){
		System.out.println(reverse("nahzruN"));
	}
	public static String reverse(String s){
		String d="";
		int i=s.length();
		if(s.length()==0)return d;
		return d+=s.substring(i-1,i)+reverse(s.substring(0,i-1));
	}
}