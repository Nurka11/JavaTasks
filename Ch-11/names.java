import java.util.*;
import java.io.*;
class names{
	public static void main(String[] args) throws Exception{
		int k=1;
		File file =new File("names.txt");
		ArrayList abc= new ArrayList<>();
		Scanner fin=new Scanner(file);
		HashMap<String,Integer> p=new HashMap<>();
		while(fin.hasNext()){
			String jj=fin.next().replace("\n","");
			if (!p.containsKey(jj)){
                p.put(jj,1);
            }else{
                p.put(jj,(p.get(jj))+1);
            }
		}
		fin.close();
		File f=new File("sortnames.txt");
		String [] a = (((((p.toString()).replace("}","")).replace("{","")).replace("="," ")).split(","));
		
		ArrayList list=new ArrayList(p.entrySet());
    
		// Collections.sort(list,new Comparator(){
		// public int compare(Object obj1, Object obj2){
		   // return ((Comparable)((Map.Entry)(obj1)).getValue()).compareTo(((Map.Entry)(obj2)).getValue()); }});
		// Collections.reverse(list);
		TreeMap<String,Integer> t=new TreeMap<>(p);
		PrintWriter  output=new PrintWriter(f);
		// for(int i=0;i<p.size();i++){
			// output.print((k++)+" "+list.get(i)+"\n");
		// }output.close();
		System.out.println(t);
	}
}