import java.util.*;
import java.util.concurrent.*;
public class Sum{
	static ArrayList<Integer> list;
	static int count;
	static int count2;
	public static void main(String[] args){
		list=new ArrayList<>();
		for(int i=0;i<9000000;i++){
			list.add(i);
		}
		long startTime = System.currentTimeMillis();
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(new sum());
		executor.shutdown();
		long endTime = System.currentTimeMillis();
		System.out.println(count+"   " +(endTime-startTime));
		int u=0;
		for(int i=0;i<9000000;i++)u+=i;
		System.out.println(u);
	}
	public static class sum implements Runnable{
		int x=list.size();
		public void run(){
			while(x!=1){
				x--;
				count+=list.get(x);
			}
		}
	}
}