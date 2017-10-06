import java.util.*;
class largestrc{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
		int a=sc.nextInt(),b=sc.nextInt();
		int[] hu=new int[b];
		ArrayList<Integer> list4=new ArrayList<>();
		String jo="";
		for(int i=0;i<b;i++){
			hu[i]=sc.nextInt();jo+=hu[i]+" ";list4.add(hu[i]);
		}
		ArrayList<String> list=new ArrayList<>();
		ArrayList<Integer> list1=new ArrayList<>();
		ArrayList<Integer> list2=new ArrayList<>();
		ArrayList<Integer> list3=new ArrayList<>();
		
		int u=0;String wh="";int sh=0;
		for (int i=0;i<a;i++){
			u=sc.nextInt();
			for(int j=0;j<u;j++){
				sh=sc.nextInt();list1.add(sh);
				wh=""+sh;sh=0;
			}list.add(wh);wh="";
		}
		Collections.sort(list1);
		int jh=0;
		for (int i=0;i<list.size();i++){
			try{
				jh=Integer.parseInt(list.get(i));
				list2.add(jh);jh=0;
			}catch(Exception e){}
		}
		Collections.sort(list2);
		String jp="";
		
		for(int i=0;i<list1.size();i++){
			try{if(list2.get(i)!=list1.get(i) || list1.get(i)!=hu[i]){
				if(!list3.contains(list1.get(i)))
				list3.add(list1.get(i));
			}
			}catch(Exception e){}
		}
		Collections.sort(list4);
		for (int i=0;i<hu.length;i++){
				/*System.out.print(hu[i]);*/
				if(!list3.contains(list4.get(i)))
				list3.add(list4.get(i));
		}
		String res="";
		for(int i=0;i<list3.size();i++){
			if(list3.get(i)!=0)
			res+=list3.get(i)+" ";
		}
		System.out.print(res.equals(jo) ? -1:list3.size()+"\n"+res);
		
		
        
    } 
}