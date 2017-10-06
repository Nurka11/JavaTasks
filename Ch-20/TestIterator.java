import java.util.*;
public class TestIterator{
	public static void main(String[] args){
		Collection<String> list=new ArrayList<>();
		list.add("asdfgh");
		list.add("sdf");
		list.add("gh");
		list.add("dfgh");
		Iterator<String> i=list.iterator();
		while(i.hasNext()){
			System.out.print(i.next().toUpperCase()+" ");
		}
		//System.out.println();
	}
}