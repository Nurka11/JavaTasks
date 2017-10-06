import java.util.*;
public class Max{
	public static void main(String[] args){
		Integer[] t={1,5,6,47,8,6,1,3};
		System.out.println(max(t));
		Random r=new Random();
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=0;i<10;i++){
			list.add(r.nextInt(10));
		}
		System.out.println(list);
		System.out.println(maxi(list));
	}
	public static <E extends Comparable<E>> E max(E[] list){
		E maximum=list[0];
		for(int i=0;i<list.length;i++){
			if(maximum.compareTo(list[i])<0)
				maximum=list[i];
		}
		return maximum;
	}
	public static <E extends Comparable<E>> E maxi(ArrayList<E> list){
		E maximum=list.get(0);
		for(int i=1;i<list.size();i++){
			if(maximum.compareTo(list.get(i))<0)maximum=list.get(i);
		}
		return maximum;
	}
}