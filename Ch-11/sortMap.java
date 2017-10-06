import java.util.*;
import java.io.*;
class names{
	public static void main(String[] args) throws Exception{
		Map<String,Integer> p=new HashMap<>();
		p.put("asd",20);
		p.put("as",10);
		TreeMap< String ,Integer> map= new TreeMap< String,Integer>(); 
		SortedMap<Integer, String> sortMapa = new TreeMap<Integer, String>(new IntegerComparator<Integer>()); 
		Iterator<?> it = ().iterator(); 

		while(it.hasNext()){ @SuppressWarnings("unchecked")
		Entry< String ,Integer> En = (Entry<String, Integer>) it.next(); 
		sortMapa.put( En.getValue(), En.getKey());
		} 
		Iterator<?> sortit = sortMapa.entrySet().iterator(); 
		while(sortit.hasNext()){ @SuppressWarnings("unchecked")
		Entry< Integer,String > sEn = (Entry<Integer,String>) sortit.next(); 
		System.out.println(sEn.getValue()+"-->"+sEn.getKey()); 
		}
	}
}