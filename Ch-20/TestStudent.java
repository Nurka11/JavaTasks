import java.util.*;
public class TestStudent {
	public static void main(String[] args){
		Student s1=new Student("aaa",4);
		Student s2=new Student("Zhan",2);
		System.out.println((max(s1,s2,new StudentComparator())).getName());
		System.out.println(s1.compareTo(s2));
		Collection<String> collection1 = Arrays.asList("red", "cyan"); 
		Collection<String> collection2 = Arrays.asList("red", "blue"); 
		Collection<String> collection3 = Arrays.asList("pink", "tan"); 
		System.out.println(collection1); 
		System.out.println(Collections.disjoint(collection1, collection3));

	}
	public static Student max(Student s1,Student s2,Comparator<Student> c){
		if(c.compare(s1,s2)>0)return s1;
		else return s2;
	}
}