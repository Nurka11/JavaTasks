import java.util.*;
class sortList{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<>();
		ArrayList<Integer> list1=new ArrayList<>(); 		
		for (int i=0;i<10;i++){
			int n=sc.nextInt();
			list.add(n);
		}
		for (int i = 0; i < list.size(); i++) {
            if(!list1.contains(list.get(i)))list1.add(list.get(i));
        }System.out.println(list1);
	}
}//dublikacia