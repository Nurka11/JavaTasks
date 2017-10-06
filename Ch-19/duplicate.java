import java.util.*;
public class duplicate{
	public static void main(String[] args){
		Random r=new Random();
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=0;i<10;i++)list.add(r.nextInt(10));
		System.out.println(list);
		System.out.println(removeDuplicates(list));
	}
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
		ArrayList<E> list1=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(!list1.contains(list.get(i)))list1.add(list.get(i));
		}
		return list1;
	}
}