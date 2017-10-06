import java.util.*;
public class Sort{
	public static void main(String[] args){
		Random r=new Random();
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=0;i<10;i++){
			list.add(r.nextInt(10));
		}
		System.out.println(list);
		sort(list);
	}
	public static <E extends Comparable<E>> void sort(ArrayList<E> list){
		E b;
        for (int i = 0; i < list.size(); i++) {
			E a = list.get(i);
            for (int j = i;j<list.size();j++){
                if(list.get(i).compareTo(list.get(j))>0){
					b=list.get(i);
                    a=list.get(j);
					list.set(j,b);
					list.set(i,a);
                }
            }
        }
		System.out.println(list);
	}
}