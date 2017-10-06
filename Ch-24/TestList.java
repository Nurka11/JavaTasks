import java.util.*;
public class TestList{
	public static void main(String[] args){
		MyAbstractList<String> list1=new MyArrayList<String>();
		list1.add("Tom");
		list1.add("George");
		list1.add("Peter");
		MyAbstractList<String> list2=new MyArrayList<String>();
		list2.add("Tom");
		list2.add("Michael");
		list2.add("Daniel");
		list2.addAll(list1);
		System.out.println(list2);
		list2.removeAll(list1);
		System.out.println(list2);
	}
}