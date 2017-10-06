import java.util.*;
public class maxn{
	public static void main(String[] args){
		ArrayList<Integer> list=new ArrayList<>();
		Random r=new Random();
		for(int i=0;i<10;i++)list.add(r.nextInt(10));
		System.out.println(list);
		System.out.print(max(list));
	}
	public static int max(ArrayList<Integer> list){
		int maxi=list.get(0);;
		if(list.size()<=1)return maxi;
		if(maxi<list.get(1))list.remove(0);
		else list.remove(1);
		return max(list);
	}
}