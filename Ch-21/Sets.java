import java.util.*;
public class Sets{
	public static void main(String[] args){
		Set<String> set1=new LinkedHashSet<>();
		set1.add("NUR");
		Set<String> set2=new LinkedHashSet<>();
		set2.add("ZHAN");
		set2.add("NUR");
		// It's 
		Set<String> set3=new LinkedHashSet<>();
		int count=0;
		for(String s1:set1){
			for(String s2:set2){
				if(s1.equals(s2))count++;
			}
			if(count==set2.size()-1){set3.add(s1);count=0;}
		}
		for(String s2:set2){
			for(String s1:set1){
				if(s2.equals(s1))count++;
			}
			if(count==set1.size()-1){set3.add(s2);count=0;}
		}
		for(String s:set3)System.out.println(s);
		/*for(String s1:set1){
			for(String s2:set2){
				if(s1.equals(s2))set3.add(s1);
			}
		}
		for(String s:set3)System.out.println(s);*/
	}
}