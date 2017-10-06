import java.util.*;
public class permutation{
	static ArrayList<String> list=new ArrayList<>();
	static ArrayList<String> list1=new ArrayList<>();
	public static void main(String[] args){
		disp("abc");
		disp("","abc");
	}
	static void disp(String s){
		list1.add(s);
		String[] u=s.split("");
		for(int i=0;i<u.length;i++){
			list.add(u[i]);
		}
	}
	static String disp(String s1,String s2){
		Collections.shuffle(list);
		for(int i=0;i<list.size();i++)s1+=list.get(i);
		if(!list1.contains(s1) && list1.size()<6){list1.add(s1);return s1+" "+disp(s1,s2);}
		s1="";
		// if(list1.size()==6){
			// for(int i=0;i<list1.size();i++){s1+=list1.get(i)+" ";}
			// return s1;
		// }
		return s1+" "+disp(s1,s2);
	}
}