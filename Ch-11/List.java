import java.util.ArrayList;
import java.util.Scanner;
public class List{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int n=sc.nextInt();
            list.add(n);
        }
		int b=0;
        for (int i = 0; i < list.size(); i++) {
			int a = list.get(i);
            for (int j = i;j<list.size();j++){
                if(list.get(i)>list.get(j)){
					b=list.get(i);
                    a=list.get(j);
					list.set(j,b);
					list.set(i,a);
                }
            }
        }System.out.println(list);
    }
}//sort