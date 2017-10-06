import java.util.*;
public class SyncSet{
	static Set<Integer> set;
	public static void main(String[] args){
		Thread t1=new Thread(new SetModify());
		Thread t2=new Thread(new ReadSet());
		t1.start();
		t2.start();
	}
	static class SetModify implements Runnable{
		public void run(){
			set=new HashSet<>();
			int i=1;
			while(true){
				set.add(i);i++;
				try{
					Thread.sleep(1000);
				}catch(Exception e){}
			}
		}
	}
	static class ReadSet implements Runnable{
		public void run(){
			Iterator<Integer> iterator=set.iterator();
			while(true){
				while(iterator.hasNext()){
					System.out.println(iterator.next()+" ");
				}
				try{
					Thread.sleep(1000);
				}catch(Exception e){}
			}
		}
	}
}